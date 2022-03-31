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
            document.getElementById("modalDirector").innerText = pelicula.director;
            document.getElementById("modalProductor").innerText = pelicula.producer;

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

peliculaModal.addEventListener('click', (event) => {
    if (event.target.getAttribute('id') === 'peliculaModal'){
        closeModal();
    }
});
botonCerrarModal.addEventListener('click', () => {closeModal();});

