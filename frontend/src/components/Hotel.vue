<template>
  <p>{{hotel}}</p>
</template>

<script>
  export default {
    name: 'Hotel',
    computed: {
      hotel() {
        return this.$store.getters.hotel
      }
    }
  }
</script>

<style scoped>

</style>