<template>
<view>
<view @tap="close" :class="'weui-mask ' + (!show ? 'weui-mask_hidden' : '' )" v-if="mask"></view>
<view v-if="show" @tap="close" :class="'weui-dialog__wrp ' + extClass">
    <view class="weui-dialog" @tap.stop="stopEvent">
      <view class="weui-dialog__hd">
        <view class="weui-dialog__title">{{title}}
          <slot name="title"></slot>
        </view>
      </view>
      <view class="weui-dialog__bd">
        <slot></slot>
      </view>
      <view class="weui-dialog__ft">
        <block v-if="buttons && buttons.length">
          <view v-for="(item, index) in buttons" :key="index" :class="'weui-dialog__btn ' + item.className + ' ' + item.extClass" hover-class="weui-active" :data-index="index" @tap="buttonTap">{{item.text}}</view>
        </block>
        <slot name="footer" v-else></slot>
      </view>
    </view>
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

  return __webpack_require__(__webpack_require__.s = 20);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  20: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        multipleSlots: true,
        // 在组件定义时的选项中启用多slot支持
        addGlobalClass: true
      },
      properties: {
        title: {
          // 弹窗标题，也可以通过 slot 自定义
          type: String,
          value: ''
        },
        extClass: {
          // 弹窗 class
          type: String,
          value: ''
        },
        maskClosable: {
          type: Boolean,
          value: true
        },
        mask: {
          // 是否需要 遮罩层
          type: Boolean,
          value: true
        },
        show: {
          // 是否开启弹窗
          type: Boolean,
          value: false,
          observer: '_showChange'
        },
        buttons: {
          type: Array,
          value: [] // {text, extClass}

        }
      },
      data: {
        innerShow: false
      },

      ready() {
        const buttons = this.buttons;
        const len = buttons.length;
        buttons.forEach((btn, index) => {
          if (len === 1) {
            btn.className = 'weui-dialog__btn_primary';
          } else if (index === 0) {
            btn.className = 'weui-dialog__btn_default';
          } else {
            btn.className = 'weui-dialog__btn_primary';
          }
        });
        this.setData({
          buttons
        });
      },

      methods: {
        buttonTap(e) {
          const {
            index
          } = e.currentTarget.dataset;
          this.$emit('buttontap', {
            detail: {
              index,
              item: this.buttons[index]
            }
          }, {});
        },

        close() {
          const data = this;
          if (!data.maskClosable) return;
          this.setData({
            show: false
          });
          this.$emit('close', {
            detail: {}
          }, {});
        },

        stopEvent() {}

      }
    });
    /***/
  })
  /******/

});

export default {
  data() {
    return {
      mask: false,
      title: "",
      buttons: [],
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
  20: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        multipleSlots: true,
        // 在组件定义时的选项中启用多slot支持
        addGlobalClass: true
      },
      properties: {
        title: {
          // 弹窗标题，也可以通过 slot 自定义
          type: String,
          value: ''
        },
        extClass: {
          // 弹窗 class
          type: String,
          value: ''
        },
        maskClosable: {
          type: Boolean,
          value: true
        },
        mask: {
          // 是否需要 遮罩层
          type: Boolean,
          value: true
        },
        show: {
          // 是否开启弹窗
          type: Boolean,
          value: false,
          observer: '_showChange'
        },
        buttons: {
          type: Array,
          value: [] // {text, extClass}

        }
      },
      data: {
        innerShow: false
      },

      ready() {
        const buttons = this.buttons;
        const len = buttons.length;
        buttons.forEach((btn, index) => {
          if (len === 1) {
            btn.className = 'weui-dialog__btn_primary';
          } else if (index === 0) {
            btn.className = 'weui-dialog__btn_default';
          } else {
            btn.className = 'weui-dialog__btn_primary';
          }
        });
        this.setData({
          buttons
        });
      },

      methods: {
        buttonTap(e) {
          const {
            index
          } = e.currentTarget.dataset;
          this.$emit('buttontap', {
            detail: {
              index,
              item: this.buttons[index]
            }
          }, {});
        },

        close() {
          const data = this;
          if (!data.maskClosable) return;
          this.setData({
            show: false
          });
          this.$emit('close', {
            detail: {}
          }, {});
        },

        stopEvent() {}

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
.weui-dialog.weui-dialog_hidden{opacity:0;transform:scale3d(1, 1, 0)}.weui-dialog{opacity:1;-webkit-transform:scale3d(1, 1, 1) translateY(-50%);transform:scale3d(1, 1, 1) translateY(-50%);transition:all .2s ease-in}.weui-mask.weui-mask_hidden{opacity:0;transform:scale3d(1, 1, 0)}.weui-mask{opacity:1;transform:scale3d(1, 1, 1);transition:all .2s ease-in}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwREx0Z3NoJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGdDQUFnQyxTQUFTLENBQUMsMEJBQTBCLENBQUMsYUFBYSxTQUFTLENBQUMsbURBQW1ELENBQUMsMkNBQTJDLENBQUMsMEJBQTBCLENBQUMsNEJBQTRCLFNBQVMsQ0FBQywwQkFBMEIsQ0FBQyxXQUFXLFNBQVMsQ0FBQywwQkFBMEIsQ0FBQywwQkFBMEIiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLndldWktZGlhbG9nLndldWktZGlhbG9nX2hpZGRlbntvcGFjaXR5OjA7dHJhbnNmb3JtOnNjYWxlM2QoMSwgMSwgMCl9LndldWktZGlhbG9ne29wYWNpdHk6MTstd2Via2l0LXRyYW5zZm9ybTpzY2FsZTNkKDEsIDEsIDEpIHRyYW5zbGF0ZVkoLTUwJSk7dHJhbnNmb3JtOnNjYWxlM2QoMSwgMSwgMSkgdHJhbnNsYXRlWSgtNTAlKTt0cmFuc2l0aW9uOmFsbCAuMnMgZWFzZS1pbn0ud2V1aS1tYXNrLndldWktbWFza19oaWRkZW57b3BhY2l0eTowO3RyYW5zZm9ybTpzY2FsZTNkKDEsIDEsIDApfS53ZXVpLW1hc2t7b3BhY2l0eToxO3RyYW5zZm9ybTpzY2FsZTNkKDEsIDEsIDEpO3RyYW5zaXRpb246YWxsIC4ycyBlYXNlLWlufSJdfQ== */
</style>