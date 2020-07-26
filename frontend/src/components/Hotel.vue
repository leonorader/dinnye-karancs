<template>
  <main>
    <canvas id="canvas" height="200" width="100"></canvas>
    <!--<p>{{hotel}}</p>-->
  </main>
</template>

<script>
  export default {
    name: 'Hotel',
    data() {
      return {
        canvas: null,
        context: null,

        unit: 8,
        width: 2 * 8,
        height: 8
      }
    },
    computed: {
      hotel() {
        return JSON.parse(this.$store.getters.hotel)
      }
    },
    methods: {
      draw: function (frame) {
        console.log(frame)
        for (let m = 0; m < frame.length; m++) {
          for (let n = 0; n < frame[m].length; n++) {
            let x = (3 * n + 1) * this.unit
            let y = (2 * m + 1) * this.unit
            console.log(frame[m][n])
            this.context.fillStyle = frame[m][n].data
            this.context.strokeStyle = frame[m][n].data
            this.context.fillRect(x, y, this.width, this.height)
          }
        }
      }
    },
    mounted() {
      this.canvas = document.getElementById('canvas')
      this.canvas.width = 200
      this.canvas.height = 125

      this.context = this.canvas.getContext('2d')
      // this.context.fillStyle = '#fffff0'
      // this.context.strokeStyle = '#373734'
      this.context.lineWidth = 1
    },
    watch: {
      hotel() {
        console.log(this.hotel)
        if (!this.hotel) return
        if (this.context) this.context.clearRect(0, 0, this.canvas.width, this.canvas.height)

        this.draw(this.hotel.rooms)
        // await new Promise(resolve => setTimeout(resolve, waitTime));
        // this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
      }
    }
  }
</script>

<style scoped>

  main {
    background-color: black;
  }

</style>