<template>
<view>
<block v-if="link">
    <view @tap="navigateTo" :class="'weui-cell weui-cell_access ' + extClass + ' ' + outerClass + '' + (inForm ? ' weui-cell-inform' : '') + '' + (inline ? '' : ' .weui-cell_label-block')" :hover-class="hover ? 'weui-cell_active weui-active' : extHoverClass">
        <view v-if="hasHeader" :class="'weui-cell__hd ' + iconClass">
            <block v-if="icon">
                <image :src="icon" class="weui-cell__icon" mode="aspectFit"></image>
            </block>
            <block v-else>
                <slot name="icon"></slot>
            </block>
            <block v-if="inForm">
                <block v-if="title"><view class="weui-label">{{title}}</view></block>
                <block v-else>
                    <slot name="title"></slot>
                </block>
            </block>
            <block v-else>
                <block v-if="title">{{title}}</block>
                <block v-else>
                    <slot name="title"></slot>
                </block>
            </block>
        </view>
        <view v-if="hasBody" class="weui-cell__bd">
            <block v-if="value">{{value}}</block>
            <block v-else>
                <slot></slot>
            </block>
        </view>
        <view v-if="hasFooter" :class="'weui-cell__ft weui-cell__ft_in-access ' + footerClass">
            <block v-if="footer">{{footer}}</block>
            <block v-else>
                <slot name="footer"></slot>
            </block>
        </view>
    </view>
</block>
<block v-else>
    <view @tap="navigateTo" :class="'weui-cell ' + (showError && error ? 'weui-cell_warn' : '') + ' ' + (inForm ? 'weui-cell-inform' : '') + ' ' + extClass + ' ' + outerClass" :hover-class="hover ? 'weui-cell_active weui-active' : extHoverClass">
        <view v-if="hasHeader" :class="'weui-cell__hd ' + iconClass">
            <block v-if="icon">
                <image :src="icon" class="weui-cell__icon" mode="aspectFit"></image>
            </block>
            <block v-else>
                <slot name="icon"></slot>
            </block>
            <block v-if="inForm">
                <block v-if="title"><view class="weui-label">{{title}}</view></block>
                <block v-else>
                    <slot name="title"></slot>
                </block>
            </block>
            <block v-else>
                <block v-if="title">{{title}}</block>
                <block v-else>
                    <slot name="title"></slot>
                </block>
            </block>
        </view>
        <view v-if="hasBody" :class="'weui-cell__bd ' + bodyClass">
            <block v-if="value">{{value}}</block>
            <block v-else>
                <slot></slot>
            </block>
        </view>
        <view v-if="hasFooter" :class="'weui-cell__ft ' + footerClass">
            <block v-if="footer">{{footer}}</block>
            <block v-else>
                <slot name="footer"></slot>
            </block>
            <icon v-if="showError && error" type="warn" size="23" color="#E64340"></icon>
        </view>
    </view>
</block>
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

  return __webpack_require__(__webpack_require__.s = 9);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  9: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        hover: {
          type: Boolean,
          value: false
        },
        link: {
          type: Boolean,
          value: false
        },
        extClass: {
          type: String,
          value: ''
        },
        iconClass: {
          type: String,
          value: ''
        },
        bodyClass: {
          type: String,
          value: ''
        },
        icon: {
          type: String,
          value: ''
        },
        title: {
          // 和icon二选一，都是放在cell_hd里面
          type: String,
          value: ''
        },
        value: {
          type: String,
          value: ''
        },
        showError: {
          type: Boolean,
          value: false
        },
        prop: {
          // 校验的属性，给父元素form使用
          type: String,
          value: ''
        },
        url: {
          // 在link为true的时候有效，表示navigator的跳转url
          type: String,
          value: ''
        },
        footerClass: {
          type: String,
          value: ''
        },
        footer: {
          type: String,
          value: ''
        },
        inline: {
          // 左右布局样式还是上下布局
          type: Boolean,
          value: true
        },
        hasHeader: {
          type: Boolean,
          value: true
        },
        hasFooter: {
          type: Boolean,
          value: true
        },
        hasBody: {
          type: Boolean,
          value: true
        },
        extHoverClass: {
          // 提供给需要定制 hover-class 的场景，要求 hover 为 false
          type: String,
          value: ''
        }
      },
      relations: {
        '../form/form': {
          type: 'ancestor'
        },
        '../cells/cells': {
          type: 'ancestor'
        }
      },
      data: {
        inForm: false
      },
      methods: {
        setError(error) {
          this.setData({
            error: error || false
          });
        },

        setInForm() {
          this.setData({
            inForm: true
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
          });
        },

        navigateTo() {
          const data = this;

          if (data.url && data.link) {
            uni.navigateTo({
              url: data.url,
              success: res => {
                this.$emit('navigatesuccess', {
                  detail: res
                }, {});
              },
              fail: fail => {
                this.$emit('navigateerror', {
                  detail: fail
                }, {});
              }
            });
          }
        }

      }
    });
    /***/
  })
  /******/

});
import mpCells from "../cells/cells";

export default {
  data() {
    return {
      icon: "",
      title: "",
      inForm: false,
      iconClass: "",
      hasHeader: false,
      value: "",
      hasBody: false,
      footer: "",
      footerClass: "",
      hasFooter: false,
      hover: false,
      inline: false,
      outerClass: "",
      extClass: "",
      link: false,
      bodyClass: "",
      error: ""
    };
  },

  components: {
    mpCells
  },
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
  9: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        hover: {
          type: Boolean,
          value: false
        },
        link: {
          type: Boolean,
          value: false
        },
        extClass: {
          type: String,
          value: ''
        },
        iconClass: {
          type: String,
          value: ''
        },
        bodyClass: {
          type: String,
          value: ''
        },
        icon: {
          type: String,
          value: ''
        },
        title: {
          // 和icon二选一，都是放在cell_hd里面
          type: String,
          value: ''
        },
        value: {
          type: String,
          value: ''
        },
        showError: {
          type: Boolean,
          value: false
        },
        prop: {
          // 校验的属性，给父元素form使用
          type: String,
          value: ''
        },
        url: {
          // 在link为true的时候有效，表示navigator的跳转url
          type: String,
          value: ''
        },
        footerClass: {
          type: String,
          value: ''
        },
        footer: {
          type: String,
          value: ''
        },
        inline: {
          // 左右布局样式还是上下布局
          type: Boolean,
          value: true
        },
        hasHeader: {
          type: Boolean,
          value: true
        },
        hasFooter: {
          type: Boolean,
          value: true
        },
        hasBody: {
          type: Boolean,
          value: true
        },
        extHoverClass: {
          // 提供给需要定制 hover-class 的场景，要求 hover 为 false
          type: String,
          value: ''
        }
      },
      relations: {
        '../form/form': {
          type: 'ancestor'
        },
        '../cells/cells': {
          type: 'ancestor'
        }
      },
      data: {
        inForm: false
      },
      methods: {
        setError(error) {
          this.setData({
            error: error || false
          });
        },

        setInForm() {
          this.setData({
            inForm: true
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
          });
        },

        navigateTo() {
          const data = this;

          if (data.url && data.link) {
            uni.navigateTo({
              url: data.url,
              success: res => {
                this.$emit('navigatesuccess', {
                  detail: res
                }, {});
              },
              fail: fail => {
                this.$emit('navigateerror', {
                  detail: fail
                }, {});
              }
            });
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
.weui-cell_wxss.weui-cell_wxss:before{display:block}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwWUFCdklQJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLHNDQUFzQyxhQUFhIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi53ZXVpLWNlbGxfd3hzcy53ZXVpLWNlbGxfd3hzczpiZWZvcmV7ZGlzcGxheTpibG9ja30iXX0= */
</style>