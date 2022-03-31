
const cargarPeliculas = async() => {
    try{
        const respuesta = await fetch('https://ghibliapi.herokuapp.com/films');
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

cargarPeliculas();