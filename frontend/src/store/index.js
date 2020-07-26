import Vue from 'vue'
import Vuex from 'vuex'
import {moduleWebSocket} from './websocket'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    websocket: moduleWebSocket
  },
  state: {
    hotel: null
  },
  mutations: {
    setHotel(state, payload) {
      state.hotel = payload
    }
  },
  actions: {},
  getters: {
    hotel: state => state.hotel
  }
})