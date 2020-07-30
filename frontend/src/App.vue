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
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
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

body {
  margin: 0;
  background: black;
  display: flex;
  justify-content: center;
  align-items: center;
}

#karancs {
  width: 6.4cm;
  height: 11.5cm;
  flex-direction: column;
}

main#karancs > div {
  width: 100%;
}

#matrix {
  height: 60%
}

.floor, .roof {
  background: #222;
  width: 100%;
  border: 1px solid black;
  margin: -1px 0;
  height: 12%;
  display: flex;
  justify-content: space-around;
}

.room {
  height: 55%;
  width: 12%;
  border: 1px solid black;
  margin: 1%;
}

.roof-hole {
  height: 80%;
  width: 22%;
  border: 1px solid black;
  margin: -1px 0;
  margin-top: 1%;
}





#entresol {
  height: 18%;
  display: flex;
  flex-direction: column;
  align-items: center
}

#base {
  width: 85%;
  border: 1px solid black;
  margin: -1px 0;
  height: 100%;
  background: #222;
  display: flex;
}

.tik {
  height: 50%;
  width: 4%;
  margin: -1px 1%;
  border: 1px solid black;
  background: #222;
}

.tik:first-child {
  margin-left: -2%;
}
.tik:last-child {
  margin-right: -2%;
}

.tok {
  height: 100%;
  width: 20%;
  border: 1px solid black;
  background: #222;
  margin: -1px 1%;

}

.tok-up {
  height: 60%;
  border: 1px solid black;
  width: 100%;
  margin: -1px 0;
}

.tok-down {
  height: 40%;
  border: 1px solid black;
  width: 100%;
  margin: -1px 0;
}


#hotel {
  height: 22%;
  display: flex;
  flex-direction: column;
  align-items: center
}

#line {
  width: 100%;
  border: 1px solid black;
  height: 30%;
  background: #222;
  position: relative
}

#cross {
  width: 97%;
  border: 1px solid black;
  height: 70%;
  background: #222;
  margin: -1px 0;
  display: flex;
  justify-content: space-around;
}

.window {
  border: 1px solid black;
  height: 100%;
  width: 18%;
}

.crossline {
  height: 5%;
  width: 100%;
  padding-top: 60%;
  border: 1px solid black;
}

</style>
