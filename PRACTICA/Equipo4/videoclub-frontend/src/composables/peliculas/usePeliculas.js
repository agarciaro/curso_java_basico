import { reactive } from "vue";
import { PELICULAS_URL } from "../../secret";

export const usePreviewPeliculas = async () => {

    let peliculas = reactive([]);

    let res = await fetch(PELICULAS_URL + "/pagination?page=0&size=4");
    let data = await res.json();

    console.log(data);

    peliculas.value = data;

    return peliculas;
}