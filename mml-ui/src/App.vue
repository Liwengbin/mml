<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'app'
  }
</script>

<style>
  /*@import "assets/icon/iconfont.css";*/
  #app {
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    font-size: 13px;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }
  ::-webkit-scrollbar {
    width: 6px;
    height: 6px;
  }
  body
  {
    overflow-x:hidden;
    overflow-y:hidden;
    margin: 0px;
  }
  ::-webkit-scrollbar-thumb {
    background-color: #aeaeae;
    min-height: 50px;
    min-width: 50px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    -webkit-transition: background-color .2s;
    -o-transition: background-color .2s;
    transition: background-color .2s;
  }
  ::-webkit-scrollbar-track-piece {
    background-color: #eee;
  }
  #topnav input{
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    font-size: 14px;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #fff;
    background-color: rgb(48, 49, 51);
    border: none;
    width: 115px;
  }
  .el-menu-item [class^=ml-icon-] {
    margin-right: 5px;
    width: 24px;
    text-align: center;
    font-size: 18px;
    vertical-align: middle;
  }
</style>

