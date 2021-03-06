export const moduleWebSocket = {
  state: {
    webSocket: null
  },
  actions: {
    connect(context) {
      context.state.webSocket = null

      const protocol = location.protocol === 'https:' ? 'wss:' : 'ws:'
      // eslint-disable-next-line
      const connectionUrl = process.env.NODE_ENV === 'development' ? `${protocol}//localhost:8098` : `${protocol}//${location.hostname}:${location.port}`
      // const connectionUrl = 'wss://dinnye-karancs.herokuapp.com'

      let ws = new WebSocket(`${connectionUrl}/socket/hotel`)
      ws.onopen = function () {
        console.log('socket opened - registered')
        context.dispatch('sendPing')
      }
      ws.onerror = function () {
        console.log('error with socket')
      }
      ws.onmessage = function (event) {
        context.dispatch('onMessage', event.data)
      }
      context.state.webSocket = ws
    },
    onMessage(context, message) {
      message = JSON.parse(message)
      switch (message.id) {
        case 'hotel': {
          console.log(message)
          context.commit('setHotel', message.data)
          break
        }
        default:
          break
      }
    },
    sendPing(context) {
      context.state.webSocket.send('ping')
      setTimeout(function() {
        context.dispatch('sendPing')
      }, 900)
    }
  }
}
