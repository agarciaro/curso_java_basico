const peliculaModal = document.getElementById("peliculaModal");
const botonCerrarModal = document.getElementById("botonCerrarModal");

const showModal = async (idPelicula) => {
    try{
        const respuesta = await fetch(`https://ghibliapi.herokuapp.com/films/${idPelicula}`);
        if(respuesta.status === 200){
            const pelicula = await respuesta.json();
            console.log(pelicula);

            //Mapear la respuesta en componentes HTML
            document.getElementById("modalTitulo").innerText = pelicula.title;
            document.getElementById("modalImagen").setAttribute('src', pelicula.image);
            document.getElementById("modalDescripcion").innerText = pelicula.description;

            ////Ya tengo toda la pantalla preparada
            peliculaModal.classList.remove('hidden');
        }else{
            console.error("Error al invocar webservice");
        }
    }catch(error){
        console.error(error);
    }
};

const closeModal = () => {
    peliculaModal.classList.add('hidden');
};

botonCerrarModal.addEventListener('click', () => {closeModal();});

