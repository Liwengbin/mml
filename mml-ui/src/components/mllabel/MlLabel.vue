<template>
  <div class="dms-prop-item ">
    <div class="dms-prop-label">
      <label>
			    <span class="dms-prop-label-text">
				  {{ title }}
			    </span>
        <span class="dms-prop-tooltip" :title="value">
				  {{ value }}
        </span>
      </label>
    </div>
  </div>
</template>


<script>
  export default {
    props:['title','value'],
    name:"MlLabel",
    data() {
      return {
        open: false
      }
    }
  }
</script>

<style>
  .dms-prop-item {
    position: relative;
    margin-bottom: 10px;
  }
  .dms-prop-label {
    position: relative;
    height: 30px;
    line-height: 30px;
  }
  .dms-prop-label label {
    display: inline-block;
    max-width: 100%;
    color: #666;
    font-weight: 400;
    margin: 0;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .dms-prop-tooltip {
    overflow: hidden;
    padding-left: 5px;
  }
  .dms-prop-tooltip {
    color: #999;
  }
</style>
