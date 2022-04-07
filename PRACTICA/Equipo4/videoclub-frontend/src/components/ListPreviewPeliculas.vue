<template>
    <div class="row">
        <div class="example-2 card" v-for="pelicula in peliculasData" :key="pelicula.id">
            <div class="wrapper">
            <div class="data">
                <div class="content">
                
                <h1 class="title"><a href="#">{{pelicula.titulo}}</a></h1>
                
                <p class="text">The antsy bingers of Netflix will eagerly anticipate the digital release of the Survive soundtrack, out today.</p>
                <span class="author">Jose</span>
                <a href="#" class="button">Read more</a>
                </div>
            </div>
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from '@vue/reactivity';

import { usePreviewPeliculas } from '../composables/peliculas/usePeliculas';

export default {
  async setup() {
    const peliculas = await usePreviewPeliculas();

    var peliculasData = reactive(peliculas.value);

    return { peliculasData };
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('../assets/css/cards.css');

</style>
