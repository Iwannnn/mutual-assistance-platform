Page({
  data: {
    nbFrontColor: '#ffffff',
    nbBackgroundColor: '#f0f0ff',
  },
  onLoad() {
    this.setData({
      nbTitle: '我的',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#f0f0ff',
    })
  }
})