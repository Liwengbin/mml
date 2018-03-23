<template>
  <div>
  <div class="sub-item">
    <div><label><span>{{ description }}</span></label></div>
    <button class="btn" @click="outerVisible = true">已选择<span style="color: #0086b3"> {{ value.length}} </span>个字段</button>
  </div>
    <el-dialog width="60%" title="Task配置" :visible.sync="outerVisible">
      <div slot="footer" class="dialog-footer">
        <el-button @click="outerVisible = false">取 消</el-button>
        <el-button type="primary" >确定</el-button>
      </div>
      <el-row>
        <el-col :span="11">
          <el-tree
            :data="datafield"
            :props="defaultProps"
            show-checkbox
            node-key="id"
            ref="tree"
            default-expand-all
            @check-change="handleCheckChange">
          </el-tree>
        </el-col>
        <el-col :span="11" :offset="1" style="max-height: 400px;overflow-y: auto;">
          <div class="selected-list">
            <div class="table-header">
              <table class="table table-bordered">
                <thead>
                <tr>
                  <th>
						<span class="ml-icon-shanchu" @click="moveValue('all')">
						</span>
                  </th>
                  <th>
                    字段
                  </th>
                  <th>
                    类型
                  </th>
                </tr>
                </thead>
              </table>
            </div>
            <div class="table-body">
              <table class="table table-bordered table-hover">
                <tbody v-for="v in value">
                <tr>
                  <td>
                    <span class="ml-icon-shanchu" @click="moveValue(v.name)"></span>
                  </td>
                  <td>
                    {{ v.name }}
                  </td>
                  <td>
                    {{ v.type }}
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
  import ElDialog from "../../../node_modules/element-ui/packages/dialog/src/component.vue";
  import ElButton from "../../../node_modules/element-ui/packages/button/src/button.vue";
  import ElRow from "element-ui/packages/row/src/row";
  import ElCol from "element-ui/packages/col/src/col";

  export default {
    props: ['datafield','description'],
    components: {
      ElCol,
      ElRow,
      ElButton,
      ElDialog},
    name: 'MlFieldsDialog',
    data () {
      return {
        outerVisible: false,
        innerVisible: false,
        value:[],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },
    methods: {
      handleCheckChange:function(){
        console.log(this.$refs.tree.getCheckedKeys());
        var array = this.$refs.tree.getCheckedKeys();
        this.value.splice(0, this.value.length);
        var type = "DEFAULT";
        for(var arr in array){
          if(array[arr].substr(0,4) !="type"){
            for(var v_data in this.datafield){
              for(var v_ch in this.datafield[v_data].children){
                if(this.datafield[v_data].children[v_ch].id ==array[arr]){
                  type=this.datafield[v_data].label;
                }
              }
            }
            var v = {"name":array[arr],"type":type};
            this.value.push(v);
          }
        }
        this.setCheckedKeys();
      },
      setCheckedKeys() {
        var arr = new Array();
        for(var v_value in this.value){
          arr.push(this.value[v_value].name);
        }
        this.$refs.tree.setCheckedKeys(arr);
      },
      moveValue(v_data){
        if(v_data =="all"){
          this.value.splice(0,this.value.length);
          this.setCheckedKeys();
        }else{
          for(var v_value in this.value){
            if(this.value[v_value].name = v_data){
              this.value.splice(v_value,1);
              this.setCheckedKeys();
              break;
            }
          }
        }
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .table-bordered {
    border: 1px solid #c0c4cc;
  }
  .table {
    width: 100%;
    max-width: 100%;
    border-collapse: collapse;
    border-spacing: 0;
  }
  .dialog-column-select .selected-list .table-bordered>thead>tr>th {
    border-bottom: 0;
  }
  .table-bordered>thead>tr>th {
    border: 1px solid #c0c4cc;
  }
  .table>thead>tr>th {
    line-height: 1.6;
    color: #999;
    font-weight: 400;
    vertical-align: bottom;
    border-top: 1px solid #c0c4cc;
    border-bottom: 1px solid #c0c4cc;
  }
  .table tbody tr td {
    line-height: 1.5;
  }
  .table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
    border: 1px solid #c0c4cc;
  }
  .selected-list td:first-child, .selected-list th:first-child {
    width: 36px;
    text-align: center;
    position: relative;
  }
  .selected-list td:nth-child(2), .selected-list th:nth-child(2) {
    width: 60%;
  }
  .selected-list [class*=" ml-icon-"],.selected-list [class*="ml-icon-"]{
    cursor: pointer;
  }
  .selected-list [class*=" ml-icon-"]:hover,.selected-list [class*="ml-icon-"]:hover{
    color: #ff0000;
  }
  .sub-item{
    width: 100%;
    height: auto;
    margin-bottom: 20px;
  }
  .sub-item div{
    width: 100%;
    text-align: left;
  }
  .sub-item button{
    width: 100%;
    background-color: #e4e7ed;
  }

  .btn{
    display: inline-block;
    margin-bottom: 0;
    font-weight: 400;
    text-align: center;
    vertical-align: middle;
    touch-action: manipulation;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    text-transform: none;
    white-space: nowrap;
    padding: 4px 16px;
    font-size: 12px;
    line-height: 1.66666667;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }
  .btn:focus{
    outline: 0;
    color: #333;
    text-decoration: none;
  }
  .btn:hover {
    border: 1px solid #c0c4cc;
    background-color: #eee;
  }
  .sub-item label {
    color: #666;
    font-weight: 400;
    margin: 0;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
</style>
