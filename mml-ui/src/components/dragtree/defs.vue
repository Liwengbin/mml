<template>
  <li :data-id="data.id" class="tree-node">
    <div v-if="datatype ==='drag'" :data-id="data.id" :id="'tree_'+data.id" class="ml-tree-node-label-def element-training" draggable='true'  t-node="span" @dragstart='drag($event)'>
      <span :class="'icon '+data.icon" style="margin-left: 16px;"></span>
      <span class="tree-node-label">{{data.name}}</span>
    </div>
    <div v-else v-on:click="returnExperiment(data.id)" class="ml-node-label-wrapper-leaf element-training">
      <span :class="'icon '+data.icon" style="margin-left: 16px;"></span>
      <span class="tree-node-label">{{data.name}}</span>
    </div>
  </li>
</template>

<script>
  export default {
    name:'MlDrfs',
    props:['data','datatype','now'],
    methods: {
      drag:function(event){
        event.dataTransfer.setData("mlid", event.target.id);
      },
      returnExperiment:function(dataid){
          this.now.experiment = dataid;
          this.now.id = dataid;
          this.now.type = "experiment"
      }
    }
  };
</script>

<style>
  .ml-node-label-wrapper-leaf {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    display: block;
    cursor:pointer;
    height: 26px;
    width: 140px;
    border: 1px solid transparent;
  }
  .ml-tree-node-label-def {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    display: block;
    cursor:-webkit-grab;
    height: 26px;
    width: 140px;
    border: 1px solid transparent;
    border-radius: 13px;
  }
  .ml-tree-node-label-def:hover{
    background-color: #fff;
    border-color: #289de9;
  }
  .ml-tree-node-label-def [class*=" ml-icon-"],.ml-node-label-wrapper-leaf [class*=" ml-icon-"]{
    color: #289de9;
  }
  .tree-node .ml-icon:hover{
    border-color: #289de9;
  }
  .ml-node-label-wrapper-leaf:hover{
    color: #289de9;
  }
</style>

