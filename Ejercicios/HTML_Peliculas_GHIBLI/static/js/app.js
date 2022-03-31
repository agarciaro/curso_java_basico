const MAX_FILTER = 250;

const cargarPeliculas = async(limit) => {
    try{
        const respuesta = await fetch(`https://ghibliapi.herokuapp.com/films?limit=${limit}`);
        console.log(respuesta);

        if(respuesta.status === 200){
            const datos = await respuesta.json();
            let peliculas = '';

            datos.forEach(pelicula => {
                peliculas += `
                    <div class="pelicula">
                        <img class="poster" src="${pelicula.image}">
                        <h3 class="titulo">${pelicula.title}</h3>
                    </div>
                `;
            });

            document.getElementById('contenedor').innerHTML = peliculas;

        } else if(respuesta.status === 400){
            console.error("Ocurrió un error al llamar a la API REST");
        } else {
            console.error("No se encuentra la URL especificada");
        }
    } catch(error){
        console.error(error);
    }

}

const filterButtons = document.getElementsByClassName("filter_button");
console.log(filterButtons);

Array.from(filterButtons).forEach(button => {
    button.addEventListener('click', (event) => {cargarPeliculas(event.target.value === 'ALL'?MAX_FILTER:event.target.value)})
});

/* const boton5 = document.getElementById("filter5");
const boton10 = document.getElementById("filter10");
const botonAll = document.getElementById("filterAll"); */

/* boton5.addEventListener('click', () => {cargarPeliculas(5);});
boton10.addEventListener('click', () => {cargarPeliculas(10);});
botonAll.addEventListener('click', () => {cargarPeliculas(MAX_FILTER);}); */

cargarPeliculas(MAX_FILTER);