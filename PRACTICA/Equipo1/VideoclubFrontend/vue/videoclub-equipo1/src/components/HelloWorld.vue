<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Hola Mundo desde template</h2>
    <h3>{{ texto }}</h3>
    <div style="background: red">
      <MyComponent></MyComponent>
    </div>
  </div>
</template>

<script>
import MyComponent from './MyComponent.vue';

export default {
  name: 'HelloWorld',
  components: {
    MyComponent
  },
  props: {
    msg: String
  },
  data(){
    return{
      texto: "Hola Mundo desde componente!!"
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
