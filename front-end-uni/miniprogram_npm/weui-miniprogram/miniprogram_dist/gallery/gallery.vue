<template>
<view :class="'weui-gallery ' + (show ? 'weui-gallery_show' : '') + ' ' + extClass">
  <view class="weui-gallery__info">{{current+1}}/{{currentImgs.length}}</view>
  <swiper class="weui-gallery__img__wrp" @tap="hideGallery" :indicator-dots="false" @change="change" :current="current" :autoplay="false" :duration="500">
    <block v-for="(item, index) in currentImgs" :key="index">
      <swiper-item>
        <image mode="aspectFit" class="weui-gallery__img" :src="item"></image>
      </swiper-item>
    </block>
  </swiper>
  <view class="weui-gallery__opr" v-if="showDelete">
    <navigator @tap="deleteImg" class="weui-gallery__del">删除</navigator>
  </view>
</view>
</template>

<script>
module.exports =
/******/
(function (modules) {
  // webpackBootstrap

  /******/
  // The module cache

  /******/
  var installedModules = {};
  /******/

  /******/
  // The require function

  /******/

  function __webpack_require__(moduleId) {
    /******/

    /******/
    // Check if module is in cache

    /******/
    if (installedModules[moduleId]) {
      /******/
      return installedModules[moduleId].exports;
      /******/
    }
    /******/
    // Create a new module (and put it into the cache)

    /******/


    var module = installedModules[moduleId] = {
      /******/
      i: moduleId,

      /******/
      l: false,

      /******/
      exports: {}
      /******/

    };
    /******/

    /******/
    // Execute the module function

    /******/

    modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
    /******/

    /******/
    // Flag the module as loaded

    /******/

    module.l = true;
    /******/

    /******/
    // Return the exports of the module

    /******/

    return module.exports;
    /******/
  }
  /******/

  /******/

  /******/
  // expose the modules object (__webpack_modules__)

  /******/


  __webpack_require__.m = modules;
  /******/

  /******/
  // expose the module cache

  /******/

  __webpack_require__.c = installedModules;
  /******/

  /******/
  // define getter function for harmony exports

  /******/

  __webpack_require__.d = function (exports, name, getter) {
    /******/
    if (!__webpack_require__.o(exports, name)) {
      /******/
      Object.defineProperty(exports, name, {
        enumerable: true,
        get: getter
      });
      /******/
    }
    /******/

  };
  /******/

  /******/
  // define __esModule on exports

  /******/


  __webpack_require__.r = function (exports) {
    /******/
    if (typeof Symbol !== 'undefined' && Symbol.toStringTag) {
      /******/
      Object.defineProperty(exports, Symbol.toStringTag, {
        value: 'Module'
      });
      /******/
    }
    /******/


    Object.defineProperty(exports, '__esModule', {
      value: true
    });
    /******/
  };
  /******/

  /******/
  // create a fake namespace object

  /******/
  // mode & 1: value is a module id, require it

  /******/
  // mode & 2: merge all properties of value into the ns

  /******/
  // mode & 4: return value when already ns object

  /******/
  // mode & 8|1: behave like require

  /******/


  __webpack_require__.t = function (value, mode) {
    /******/
    if (mode & 1) value = __webpack_require__(value);
    /******/

    if (mode & 8) return value;
    /******/

    if (mode & 4 && typeof value === 'object' && value && value.__esModule) return value;
    /******/

    var ns = Object.create(null);
    /******/

    __webpack_require__.r(ns);
    /******/


    Object.defineProperty(ns, 'default', {
      enumerable: true,
      value: value
    });
    /******/

    if (mode & 2 && typeof value != 'string') for (var key in value) __webpack_require__.d(ns, key, function (key) {
      return value[key];
    }.bind(null, key));
    /******/

    return ns;
    /******/
  };
  /******/

  /******/
  // getDefaultExport function for compatibility with non-harmony modules

  /******/


  __webpack_require__.n = function (module) {
    /******/
    var getter = module && module.__esModule ?
    /******/
    function getDefault() {
      return module['default'];
    } :
    /******/
    function getModuleExports() {
      return module;
    };
    /******/

    __webpack_require__.d(getter, 'a', getter);
    /******/


    return getter;
    /******/
  };
  /******/

  /******/
  // Object.prototype.hasOwnProperty.call

  /******/


  __webpack_require__.o = function (object, property) {
    return Object.prototype.hasOwnProperty.call(object, property);
  };
  /******/

  /******/
  // __webpack_public_path__

  /******/


  __webpack_require__.p = "";
  /******/

  /******/

  /******/
  // Load entry module and return exports

  /******/

  return __webpack_require__(__webpack_require__.s = 21);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  21: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        imgUrls: {
          type: Array,
          value: [],

          observer(newVal) {
            this.setData({
              currentImgs: newVal
            });
          }

        },
        showDelete: {
          // 是否显示delete按钮
          type: Boolean,
          value: true
        },
        show: {
          type: Boolean,
          value: true
        },
        current: {
          type: Number,
          value: 0
        },
        hideOnClick: {
          type: Boolean,
          value: true
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {
        currentImgs: []
      },

      ready() {
        const data = this;
        this.setData({
          currentImgs: data.imgUrls
        });
      },

      methods: {
        change(e) {
          this.setData({
            current: e.detail.current
          });
          this.$emit('change', {
            detail: {
              current: e.detail.current
            }
          }, {});
        },

        deleteImg() {
          const data = this;
          const imgs = data.currentImgs;
          const url = imgs.splice(data.current, 1);
          this.$emit('delete', {
            detail: {
              url: url[0],
              index: data.current
            }
          }, {});

          if (imgs.length === 0) {
            // @ts-ignore
            this.hideGallery();
            return;
          }

          this.setData({
            current: 0,
            currentImgs: imgs
          });
        },

        hideGallery() {
          const data = this;

          if (data.hideOnClick) {
            this.setData({
              show: false
            });
            this.$emit('hide', {
              detail: {}
            }, {});
          }
        }

      }
    });
    /***/
  })
  /******/

});

export default {
  data() {
    return {
      currentImgs: [],
      current: 0,
      showDelete: false,
      extClass: "",
      show: false
    };
  },

  components: {},
  props: {},

  /******/
  i: moduleId,

  /******/
  l: false,

  /******/
  exports: {}
  /******/
  ,
  enumerable: true,
  get: getter,
  value: 'Module',
  value: true,
  enumerable: true,
  value: value,

  /***/
  21: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        imgUrls: {
          type: Array,
          value: [],

          observer(newVal) {
            this.setData({
              currentImgs: newVal
            });
          }

        },
        showDelete: {
          // 是否显示delete按钮
          type: Boolean,
          value: true
        },
        show: {
          type: Boolean,
          value: true
        },
        current: {
          type: Number,
          value: 0
        },
        hideOnClick: {
          type: Boolean,
          value: true
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {
        currentImgs: []
      },

      ready() {
        const data = this;
        this.setData({
          currentImgs: data.imgUrls
        });
      },

      methods: {
        change(e) {
          this.setData({
            current: e.detail.current
          });
          this.$emit('change', {
            detail: {
              current: e.detail.current
            }
          }, {});
        },

        deleteImg() {
          const data = this;
          const imgs = data.currentImgs;
          const url = imgs.splice(data.current, 1);
          this.$emit('delete', {
            detail: {
              url: url[0],
              index: data.current
            }
          }, {});

          if (imgs.length === 0) {
            // @ts-ignore
            this.hideGallery();
            return;
          }

          this.setData({
            current: 0,
            currentImgs: imgs
          });
        },

        hideGallery() {
          const data = this;

          if (data.hideOnClick) {
            this.setData({
              show: false
            });
            this.$emit('hide', {
              detail: {}
            }, {});
          }
        }

      }
    });
    /***/
  })
  /******/
  ,
  methods: {}
};
</script>
<style>
.weui-gallery{display:none}.weui-gallery_show.weui-gallery{display:flex}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwd3ZHUXhxJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGNBQWMsWUFBWSxDQUFDLGdDQUFnQyxZQUFZIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi53ZXVpLWdhbGxlcnl7ZGlzcGxheTpub25lfS53ZXVpLWdhbGxlcnlfc2hvdy53ZXVpLWdhbGxlcnl7ZGlzcGxheTpmbGV4fSJdfQ== */
</style>