<template>
  <!--<main>-->
    <!--<canvas id="canvas"></canvas>-->
    <!--<p>{{hotel}}</p>-->
  <!--</main>-->

  <main id="karancs">
    <div id="matrix" v-if="hotel">
      <div class="roof">
        <div class="roof-hole"></div>
        <div class="roof-hole"></div>
        <div class="roof-hole"></div>
        <div class="roof-hole"></div>
      </div>

      <div v-for="i in 7" class="floor">
        <div v-for="j in 8" class="room" :style="{'background-color': hotel[i][j].data}" :ref="'room-' + (i-1) + '-' + (j-1)"></div>
      </div>
    </div>

    <div id="entresol">
      <div id="base">
        <div class="tik"></div>
        <div class="tok" ref="window-1">
          <div class="tok-up"></div>
          <div class="tok-down"></div>
        </div>
        <div class="tik"></div>
        <div class="tok" ref="window-2">
          <div class="tok-up"></div>
          <div class="tok-down"></div>
        </div>
        <div class="tik"></div>
        <div class="tok" ref="window-3">
          <div class="tok-up"></div>
          <div class="tok-down"></div>
        </div>
        <div class="tik"></div>
        <div class="tok" ref="window-4">
          <div class="tok-up"></div>
          <div class="tok-down"></div>
        </div>
        <div class="tik"></div>
      </div>
    </div>

    <div id="hotel">
      <div id="line"></div>
      <div id="cross">
        <div class="window"></div>
        <div class="window"></div>
        <div class="window"></div>
        <div class="window"></div>
        <div class="window"></div>
      </div>
      <div id="door"></div>
    </div>
  </main>

  <!--<main>-->
  <!--<canvas id="canvas"></canvas>-->
  <!--<p>{{hotel}}</p>-->
  <!--</main>-->

</template>

<script>
  export default {
    name: 'Hotel',
    data() {
      return {
        // canvas: null,
        // context: null,

        // unit: 16,
        // width: 2 * 16,
        // height: 16
      }
    },
    computed: {
      hotel() {
        return JSON.parse(this.$store.getters.hotel)
      }
    },
    methods: {
      // draw: function (frame) {
      //   console.log(frame)
      //   for (let m = 0; m < frame.length; m++) {
      //     for (let n = 0; n < frame[m].length; n++) {
      //       this.$refs['room-' + m + '-'+ n].


            // let x = (3 * n + 1) * this.unit
            // let y = (2 * m + 1) * this.unit
            // console.log(frame[m][n])
            // this.context.fillStyle = frame[m][n].data
            // this.context.strokeStyle = frame[m][n].data
            // this.context.fillRect(x, y, this.width, this.height)
      //     }
      //   }
      // }
    },
    mounted() {
      // this.canvas = document.getElementById('canvas')
      // this.canvas.width = this.unit * 3 * 8 + 16
      // this.canvas.height = this.unit * 2 * 8 + 16
      //
      // this.context = this.canvas.getContext('2d')
      // this.context.lineWidth = 1
    },
    watch: {
      // hotel() {
      //   console.log(this.hotel)
      //   if (!this.hotel) return
      //   if (this.context) this.context.clearRect(0, 0, this.canvas.width, this.canvas.height)
      //
      //   this.draw(this.hotel.rooms)
      // }
    }
  }
</script>

<style scoped>

  main {
    background-color: black;
  }

</style>