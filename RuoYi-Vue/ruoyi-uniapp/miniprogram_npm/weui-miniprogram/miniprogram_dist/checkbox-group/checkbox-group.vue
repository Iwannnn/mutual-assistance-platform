<template>
<view>
<checkbox-group :class="extClass" v-if="multi" @change="checkedChange">
    <slot></slot>
</checkbox-group>
<radio-group :class="extClass" :-else @change="checkedChange">
    <slot></slot>
</radio-group>
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

  return __webpack_require__(__webpack_require__.s = 24);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  24: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        multi: {
          type: Boolean,
          value: true,
          observer: '_multiChange'
        },
        extClass: {
          type: String,
          value: ''
        },
        prop: {
          type: String,
          value: ''
        }
      },
      data: {
        targetList: [],
        parentCell: null
      },
      relations: {
        '../checkbox/checkbox': {
          type: 'descendant',

          linked(target) {
            this.targetList.push(target);
            target.setMulti(this.multi);

            if (!this.firstItem) {
              this.firstItem = target;
            }

            if (target !== this.firstItem) {
              target.setOuterClass('weui-cell_wxss');
            }
          },

          unlinked(target) {
            let index = -1;
            this.targetList.forEach((item, idx) => {
              if (item === target) {
                index = idx;
              }
            });
            this.targetList.splice(index, 1);

            if (!this.targetList) {
              this.firstItem = null;
            }
          }

        },
        '../form/form': {
          type: 'ancestor'
        },
        '../cells/cells': {
          type: 'ancestor',

          linked(target) {
            if (!this.parentCell) {
              this.parentCell = target;
            }

            this.setParentCellsClass();
          },

          unlinked() {
            this.parentCell = null; // 方便内存回收
          }

        }
      },
      methods: {
        checkedChange(checked, target) {
          if (this.multi) {
            const vals = [];
            this.targetList.forEach(item => {
              if (item.data.checked) {
                vals.push(item.data.value);
              }
            });
            this.$emit('change', {
              detail: {
                value: vals
              }
            });
          } else {
            let val = '';
            this.targetList.forEach(item => {
              if (item === target) {
                val = item.data.value;
              } else {
                item.setData({
                  checked: false
                });
              }
            });
            this.$emit('change', {
              detail: {
                value: val
              }
            }, {});
          }
        },

        setParentCellsClass() {
          const className = this.multi ? 'weui-cells_checkbox' : '';

          if (this.parentCell) {
            this.parentCell.setCellsClass(className);
          }
        },

        _multiChange(multi) {
          this.targetList.forEach(target => {
            target.setMulti(multi);
          });

          if (this.parentCell) {
            this.parentCell.setCellMulti(multi);
          }

          return multi;
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
      multi: false,
      extClass: "",
      checked: false
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
  24: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        multi: {
          type: Boolean,
          value: true,
          observer: '_multiChange'
        },
        extClass: {
          type: String,
          value: ''
        },
        prop: {
          type: String,
          value: ''
        }
      },
      data: {
        targetList: [],
        parentCell: null
      },
      relations: {
        '../checkbox/checkbox': {
          type: 'descendant',

          linked(target) {
            this.targetList.push(target);
            target.setMulti(this.multi);

            if (!this.firstItem) {
              this.firstItem = target;
            }

            if (target !== this.firstItem) {
              target.setOuterClass('weui-cell_wxss');
            }
          },

          unlinked(target) {
            let index = -1;
            this.targetList.forEach((item, idx) => {
              if (item === target) {
                index = idx;
              }
            });
            this.targetList.splice(index, 1);

            if (!this.targetList) {
              this.firstItem = null;
            }
          }

        },
        '../form/form': {
          type: 'ancestor'
        },
        '../cells/cells': {
          type: 'ancestor',

          linked(target) {
            if (!this.parentCell) {
              this.parentCell = target;
            }

            this.setParentCellsClass();
          },

          unlinked() {
            this.parentCell = null; // 方便内存回收
          }

        }
      },
      methods: {
        checkedChange(checked, target) {
          if (this.multi) {
            const vals = [];
            this.targetList.forEach(item => {
              if (item.data.checked) {
                vals.push(item.data.value);
              }
            });
            this.$emit('change', {
              detail: {
                value: vals
              }
            });
          } else {
            let val = '';
            this.targetList.forEach(item => {
              if (item === target) {
                val = item.data.value;
              } else {
                item.setData({
                  checked: false
                });
              }
            });
            this.$emit('change', {
              detail: {
                value: val
              }
            }, {});
          }
        },

        setParentCellsClass() {
          const className = this.multi ? 'weui-cells_checkbox' : '';

          if (this.parentCell) {
            this.parentCell.setCellsClass(className);
          }
        },

        _multiChange(multi) {
          this.targetList.forEach(target => {
            target.setMulti(multi);
          });

          if (this.parentCell) {
            this.parentCell.setCellMulti(multi);
          }

          return multi;
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
