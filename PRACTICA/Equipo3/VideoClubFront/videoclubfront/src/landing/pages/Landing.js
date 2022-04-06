import React, { useEffect, useState } from "react";
import PeliculasList from "../components/PeliculasList";
import ErrorModal from "../../shared/components/UIElements/ErrorModal";
import LoadingSpinner from "../../shared/components/UIElements/LoadingSpinner";
import { useHttpClient } from "../../shared/hooks/http-hook";
import { Pagination } from "@mui/material";
import { Box } from "@mui/system";
import Input from "@mui/material/Input";

const Landing = () =>{
    const [loadedMovies, setLoadedMovies] = useState();
    const { isLoading, error, sendRequest, clearError } = useHttpClient();
    const [ page , setPage] = useState(0);
    const [search, setSearch] = useState("");
    const [totalPages, setTotalPages] = useState(0);
    const [ size , setSize] = useState(8)

    useEffect(() => {
        const fetchMovies = async () => {
          
          try {
            const responseData = await sendRequest(
              `${process.env.REACT_APP_BACKEND_URL}/peliculas/?page=${page}&size=${size}&filter=${search}`
            );
            setLoadedMovies(responseData.content);
            setTotalPages(responseData.totalPages);
          } catch (err) {}
        };
        fetchMovies();
      }, [sendRequest, page, size, search]);
    
      const handleTextFieldKeyDown = (event) => {
        switch (event.key) {
          case "Enter":
            if (event.target.value) {
              setSearch(event.target.value);
            } else {
              setSearch("");
            }
            break;
          case "Escape":
            setSearch("");
            break;
          default:
            break;
        }
      };
      const selectPage = (event, value) => {
        setPage(value-1);
      };
  return (
    <React.Fragment>
      <ErrorModal error={error} onClear={clearError} />
      {isLoading && (
        <div className="center">
          <LoadingSpinner />
        </div>
      )}
      {!isLoading && loadedMovies && (
         <div>
         <Box
           className="search-box"
           sx={{ display: "flex", alignItems: "flex-end" }}
         >
           <Input
             fullWidth
             label="Buscar"
             id="fullWidth"
             className="search"
             inputProps={{ style: { fontSize: 30 } }} // font size of input text
             inputlabelprops={{ style: { fontSize: 30 } }}
             placeholder="  Buscar"
             onKeyDown={handleTextFieldKeyDown}
           />
         </Box>
         <PeliculasList items={loadedMovies}  />
         <div className="pagination">
         <Pagination
           count={totalPages}
           page={page}
           color="success"
           onChange={selectPage}
           size="large"
         />
         </div>
       </div>
      
      )}
      ;
    </React.Fragment>
  );
};

export default Landing;