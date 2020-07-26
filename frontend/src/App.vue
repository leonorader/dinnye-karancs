<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App',
  created() {
    this.$store.dispatch('connect')
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

html, body, #app {
  height: 100%;
}

body {
  margin: 0;
  background-color: black;
}

main {
  display: flex;
  height: 100%;
  justify-content: center;
  align-items: center;
}
</style>
