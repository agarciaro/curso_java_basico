<template>
  <div id="my-component">
      <hr/>
    <h1>This is my component</h1>
    <h2>{{ subtitle }}</h2>
    <hr/>
  </div>
</template>

<script>
export default {
  name: "MyComponent",
  data() {
    return {
      subtitle: "I am a subtitle of my component",
    };
  },
};
</script>