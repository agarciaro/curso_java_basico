const MAX_FILTER = 250;

const cargarPeliculas = async (limit) => {
    try{
        const respuesta = await fetch(`https://ghibliapi.herokuapp.com/films?limit=${limit}`);
        console.log(respuesta);

        if(respuesta.status === 200){
            const datos = await respuesta.json();
            let peliculas = '';

            datos.forEach(pelicula => {
                peliculas += `
                    <div class="pelicula" name="peliculaCard" id="${pelicula.id}">
                        <img class="poster" src="${pelicula.image}">
                        <h3 class="titulo">${pelicula.title}</h3>
                    </div>
                `;
            });

            document.getElementById('contenedor').innerHTML = peliculas;
            Array.from(document.getElementsByName("peliculaCard")).forEach(peliculaCard => {
                peliculaCard.addEventListener('click', () => {showModal(peliculaCard.getAttribute('id'))});
            });

        } else if(respuesta.status === 400){
            console.error("Ocurrió un error al llamar a la API REST");
        } else {
            console.error("No se encuentra la URL especificada");
        }
    } catch(error){
        console.error(error);
    }

}

const filterButtons = document.getElementsByName("botonFiltro");
console.log(filterButtons);

Array.from(filterButtons).forEach(button => {
    button.addEventListener('click', (event) => {cargarPeliculas(event.target.value === 'ALL'?MAX_FILTER:event.target.value)})
});

const botonModal = document.getElementById("botonModal");
/* botonModal.addEventListener('click', (event) => {showModal('2baf70d1-42bb-4437-b551-e5fed5a87abe');});
 */

cargarPeliculas(MAX_FILTER);