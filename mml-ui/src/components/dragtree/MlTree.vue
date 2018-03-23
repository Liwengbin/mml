<template>
    <li v-if="module.dir == true" class="tree-node">
    <div @click="toggle(module.id)" :id="module.id" class="ml-tree-node-label-cat">
      <span class="icon" :class="[open ? 'ml-icon-bottom': 'ml-icon-right']"></span>
      <span class="icon" :class="[open ? 'ml-icon-wenjianjia-zhankai': 'ml-icon-wenjianjia-shouqi']"></span>
      <span class="tree-node-label">{{ module.name }}</span>
    </div>
      <ul v-show="open" calss="ml-ul" style="padding-left: 16px">
        <template v-for="item in module.children">
          <ml-tree :module="item" :datatype="datatype" :MenuType="MenuType" :now="now"></ml-tree>
        </template>
      </ul>
    </li>
    <ml-drfs v-else :data="module" :datatype="datatype" :MenuType="MenuType" :now="now"></ml-drfs>
</template>

<script>
  import api from '../../api/api'
  import MlDrfs from "./defs.vue";
  export default {
    components: {MlDrfs},
    name: 'MlTree',
    props: ['module','datatype','MenuType','now'],
    data() {
      return {
        open: false
      }
    },
    methods: {
      toggle: function(_id) {
          let isChildren= 'children' in this.module;
          let method ='';
          if(_id == this.module.id && this.open==false && !isChildren){
            var formData = new FormData();
            switch(this.MenuType){
              case "zujian":
                method='getComponentDir';
                break;
              case "shiyan":
                method='getExperimentDir';
                break;
              case "shuju":
                method='getComponentDir';
                break
            }
            formData.append("ID", _id);
            api[method](formData).then((response) => response.json())
              .then((data) => {
                this.module['children'] = data.data;
                this.open = !this.open
                console.log(`data = \n`, data)
              });
          }else {
            this.open = !this.open
          }
      }
    }
  }
</script>

<style>
  .ml-tree-node-label-cat{
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    cursor: pointer;
    display: block;
    height: 26px;
    width: 140px;
    border: 1px solid transparent;
    border-radius: 13px;
  }
  li{
    list-style: none;
    text-align: -webkit-left;
  }
  .tree-node .ml-tree-node-label-* {
    position: relative;
    height: 30px;
  }
  .tree-node .ml-tree-node-label-*{
    display: block;
    width: 110px;
    line-height: 24px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .tree-node-label {
    width: auto;
  }
  .tree-node-label {
    height: 28px;
    line-height: 28px;
    width: 140px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .ml-tree-node-label-cat [class*=" ml-icon-wenjianjia-"]{
    color: #ffb300;
    font-size: 14px;
  }
  .ml-tree-node-label-cat .ml-icon-right,.ml-tree-node-label-cat .ml-icon-bottom{
    font-size: 13px;
    color: #969896;
  }
</style>
