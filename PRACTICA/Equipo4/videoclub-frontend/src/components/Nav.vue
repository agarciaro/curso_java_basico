<template>
    <header class="header">
        <a href="#" class="logo">Videoclub</a>
        <input class="menu-btn" type="checkbox" id="menu-btn" />
        <label class="menu-icon" for="menu-btn"><span class="navicon"></span></label>
        <ul class="menu">
            <li><a href="/#/peliculas">Peliculas</a></li>
            <li><a href="/#/Login">Login</a></li>
        </ul>
    </header>
</template>

<script>
export default {
  name: 'nav-component'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('../assets/css/nav.css');
</style>
