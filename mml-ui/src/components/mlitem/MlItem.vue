<template>
  <div class="ml-item">
    <label class="ml-label" :style="labelStyle">{{ label }}</label>
    <div class="ml-value">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  export default {
    props:['label','labelStyle'],
    name:"MlItem",
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
  .ml-item{
    width: 100%;
    padding: 10px;
  }
  .ml-item .ml-label{
    height: 20px;
    line-height: 20px;
  }
  .ml-item .ml-value{
    line-height: 40px;
    position: relative;
    font-size: 14px;
    padding-left: 20px;
  }
  .ml-value label{
    width: 100%;
    display: block;
  }
</style>
