<template>
  <div class="home">
      <h1>Holaaaaa</h1>
      <Suspense>
        <ListPreviewPeliculas/>
      </Suspense>
  </div>
</template>

<script>

import ListPreviewPeliculas from '../components/ListPreviewPeliculas.vue'

// @ is an alias to /src
export default {
  name: 'home-page',
  components: {
    ListPreviewPeliculas
  }
}
</script>