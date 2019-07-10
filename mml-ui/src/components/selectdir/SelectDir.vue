<template>
  <li>
    <el-radio width="100%" :label="selectdir.value">{{ selectdir.label }}</el-radio>
    <span @click="openClose" :class="[open ? 'ml-icon-wenjianjia-zhankai': 'ml-icon-wenjianjia-shouqi']"></span>
    <ul v-show="open"><ml-select-dir v-for="item in selectdir.children" :selectdir="item"></ml-select-dir></ul>
  </li>
  <<el-tree></el-tree>
</template>

<script>
  import ElTree from "../../../node_modules/element-ui/packages/tree/src/tree.vue";

  export default {
    components: {ElTree},
    props:['selectdir'],
    name:"MlSelectDir",
    data() {
      return {
        open: false
      }
    },
    methods: {
      openClose: function() {
        this.open = !this.open
      }
    }
  }
</script>

<style>
.ml-select{
  overflow-y: auto;
  height: 110px;
  padding:5px 20px 10px;
  border: 1px solid #e4e4e4;
  border-radius: 5px;
}
.ml-select ul{
  padding-left:10px;
}
.ml-select li{
  line-height: 20px;
}

.ml-select [class*="ml-icon-"]{
  float: right;
  color: #e6a23c;
}
.ml-select .el-radio{
  line-height: 20px;
}

.ml-select .el-radio__inner {
    display: inline-block;
    position: relative;
    border: 1px solid #dcdfe6;
    border-radius: 2px;
    box-sizing: border-box;
    width: 14px;
    height: 14px;
    background-color: #fff;
    z-index: 1;
    transition: border-color .25s cubic-bezier(.71,-.46,.29,1.46),background-color .25s cubic-bezier(.71,-.46,.29,1.46);
}

</style>
