<template>
  <el-container id="index">
    <el-header v-bind:style="{height:40+'px',backgroundColor:'#303133',padding: 0+'px'}">
      <el-row id="topnav">
        <el-col :span="2">
          <span class="ml-icon-logo"></span>
        </el-col>
        <el-col :span="8" :offset="14">
          <el-popover
            ref="popoverUser"
            placement="bottom"
            width="200"
            trigger="click">
            <el-button type="text" icon="el-icon-error" style="padding-left: 75px;color: #303133">注销</el-button>
            <el-form label-position="left" inline class="ml-table-expand">
              <el-form-item label="用户名:">
                <span>{{ information.userName }}</span>
              </el-form-item>
              <el-form-item label="用户ID:">
                <span>{{ information.id }}</span>
              </el-form-item>
              <el-form-item label="用户电话:">
                <span>{{ information.userPhone }}</span>
              </el-form-item>
              <el-form-item label="用户Email:">
                <span>{{ information.userEmail }}</span>
              </el-form-item>
            </el-form>
          </el-popover>
          <el-button type="text" v-popover:popoverUser>IT-Art<i class="el-icon-arrow-down el-icon--right"></i></el-button>
          <el-select v-model="value" placeholder="请选择">
            <el-option
              v-for="item in yuyans"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>
      </el-row>
    </el-header>
    <el-container>
    <el-aside width="60px">
      <el-menu default-active="zujian"
               :text-color="BACK.ASIDE_ICO_TEXT_COLOR"
               :background-color="BACK.ASIDE_BACKGROUND_COLOR"
               :active-text-color="BACK.ACTIVE_TEXT_COLOR"
               @select="handleSelect"
               class="ml-menu"
               v-bind:style="{height:contain.Height-40+'px'}">
        <template v-for="item in items">
          <el-menu-item style="padding: 0 10px" :index="item.dex">
            <i :class="item.icon" :title="item.name"></i>
           <!-- <span slot="title">{{ item.name }}</span>-->
          </el-menu-item>
        </template>
      </el-menu>
    </el-aside>
    <el-container>
        <el-main v-show="show.task">
          <el-row>
            <el-col :span="3" id="colleft" style="overflow-x:hidden;overflow-y:auto" v-bind:style="{height:contain.Height-40+'px',backgroundColor:'#eee'}">
              <el-container style="height: 100%;border-right: 1px solid #eee;">
                <el-header style="height: 40px;padding: 0px">
                  <el-input
                    style="border-radius: 0px"
                    placeholder="请输入内容"
                    v-model="input1">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </el-header>
                <el-main>
                <ul>
                  <ml-tree v-show="show.zujian" v-for="item in module" datatype="drag" :module="item" MenuType="zujian"></ml-tree>
                  <ml-tree v-show="show.shiyan" v-for="item in document" datatype="common" :module="item" MenuType="shiyan" :now="now"></ml-tree>
                  <ml-tree v-show="show.shuju" v-for="item in DataSource" datatype="drag" :module="item" MenuType="shuju"></ml-tree>
                  <ml-drfs v-on:childInfo="getInfoExperiment"></ml-drfs>
                </ul>
                </el-main>
                <el-footer style="padding: 0px">
                  <div class="pai-btn-create">
                    <span class="align-middle">
                      <span class="el-icon-circle-plus-outline"></span>
                      <el-button type="text" @click="openNewExperiment = true">新建实验</el-button>
                    </span>
                  </div>
                </el-footer>
              </el-container>
            </el-col>
            <el-col :span="17"><ml-svg-main :module="module" :contain="contain" :svgProportion="svgProportion" :now="now"></ml-svg-main></el-col>
            <el-col :span="4" v-bind:style="{height:contain.Height-40+'px',backgroundColor:'#f5f7fa'}" style="border-left: 1px solid #dcdfe6;"><ml-sub-main :now="now"></ml-sub-main></el-col>
          </el-row>
      </el-main>
      <el-main v-show="show.shouye" v-bind:style="{height:contain.Height+'px',backgroundColor:'#eee'}">
        <el-row style="padding-right: 35px">
          <el-col :span="5" :offset="1" style="padding: 10px 0px">
            <el-card>
              <div class="ml-icon-tianjia"></div>
              <div style="padding: 14px;">
                <span>创建空白实验</span>
                <div class="bottom clearfix">
                  <time class="time">{{ currentDate }}</time>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="5" :offset="1" v-for="(o, index) in 10" :key="o" style="padding: 10px 0px">
            <el-card>
              <div class="ml-icon-moban"></div>
              <div style="padding: 14px;">
                <span>实验模板 {{index}}</span>
                <div class="bottom clearfix">
                  <time class="time">{{ currentDate }}</time>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
      <el-main v-show="show.shezhi" v-bind:style="{height:contain.Height+'px',backgroundColor:'#fff'}">
        <el-row>
          <el-col :span="12">
            <el-form ref="form" :model="setform" label-width="80px">
            <el-form-item label="夜间模式">
              <el-switch v-model="setform.delivery"></el-switch>
            </el-form-item>
            <el-form-item label="夜间模式">
              <button id="btntest">鼠标右击测试</button>
            </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>

      <el-main v-show="show.bangzhu" v-bind:style="{height:contain.Height+'px',backgroundColor:'#fff'}">
        <el-row>
          <el-col :span="12">
            <div>
              <label></label>
              <div></div>
            </div>
            <el-form ref="form" :model="setform" label-width="80px">
                <ml-item :label="'帮助文档'" :labelStyle="'font-size: 16px;font-weight: 700;color: #dd6161;width: 100%;'">
                <ml-item :label="webApp.jianjie.title" :labelStyle="'font-size: 16px;font-weight: 700;width: 100%;'"><label v-for="v in webApp.jianjie.value"> {{ v }} </label></ml-item>
                <ml-item :label="webApp.banben.title" :labelStyle="'font-size: 16px;font-weight: 700;width: 100%;'"><label v-for="v in webApp.banben.value"> {{ v }} </label></ml-item>
                </ml-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
    </el-container>

    <el-dialog title="新建实验" :visible.sync="openNewExperiment">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="名称" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="项目" prop="region">
          <el-select v-model="ruleForm.region" placeholder="请选择项目">
            <el-option label="DataSource" value="DataSource"></el-option>
            <el-option label="WorkFlow" value="WorkFlow"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="描述" prop="desc">
          <el-input type="textarea" v-model="ruleForm.desc"></el-input>
        </el-form-item>
        <el-form-item label="位置" prop="address">
          <el-radio-group v-model="ruleForm.address">
            <div class="ml-select">
              <ul style="margin: 5px 0;"><ml-select-dir v-for="item in selectdir" :selectdir="item"></ml-select-dir></ul>
            </div>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </el-container>
</template>

<script>
  import webApp from '../../tools/webApp.js'
  import ElMenu from "../../../node_modules/element-ui/packages/menu/src/menu.vue";
  import ElAside from "../../../node_modules/element-ui/packages/aside/src/main.vue";
  import ElMain from "../../../node_modules/element-ui/packages/main/src/main.vue";
  import MlSubMain from "../../components/submain/SubMain.vue";
  import MlTree from "../../components/dragtree/MlTree.vue";
  import ElRow from "element-ui/packages/row/src/row";
  import ElCol from "element-ui/packages/col/src/col";
  import api from '../../api/api'
  import ElHeader from "../../../node_modules/element-ui/packages/header/src/main.vue";
  import ElFooter from "../../../node_modules/element-ui/packages/footer/src/main.vue";
  import ElFormItem from "../../../node_modules/element-ui/packages/form/src/form-item.vue";
  import MlDrfs from "../../components/dragtree/defs.vue";
  import MlSelectDir from "../../components/selectdir/SelectDir.vue";
  import MlSvgMain from "../../components/svgmain/SvgMain.vue";
  import { Message } from 'element-ui';
  import $ from 'jquery';
  import MlItem from "../../components/mlitem/MlItem.vue";
  export default {
    components: {
      MlItem,
      MlSvgMain,
      MlSelectDir,
      MlDrfs,
      ElFormItem,
      ElFooter,
      ElHeader,
      ElCol,
      ElRow,
      MlTree,
      MlSubMain,
      ElMain,
      ElAside,
      ElMenu},
    data() {
      return {
        now:{
          id:'1',
          type:'experiment',
          experiment:'1'
        },
        setform: {
          delivery: false
        },
        ruleForm: {
          name: '',
          region: '',
          desc: '',
          address:''
        },
        svgProportion:{
          x:0.8,
          y:0.8
        },
        rules: {
          name: [
            { required: true, message: '请输入实验名称', trigger: 'blur' },
            { min: 3, max: 20, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          region: [
            { required: true, message: '请选择项目名称', trigger: 'change' }
          ]
        },
        selectdir: [],
        openNewExperiment:false,
        input1:'',
        currentDate: new Date(),
        yuyans: [{
          value: '1',
          label: '简体中文'
        }, {
          value: '2',
          label: 'English'
        }],
        value: '1',
        contain:{
          Width:1366,
          Height:619
        },
        show:{
          task:true,
          ml:true,
          shouye:false,
          shiyan:false,
          shuju:false,
          zujian:true,
          moxian:false,
          shezhi:false,
          yonghu:false,
          gongzuo:false,
          yuyan:false,
          bangzhu:false
        },
        BACK : webApp.daytime,
        webApp:webApp,
        width:120+'px',
        items:[],
        DataSource:[],
        document:[],
        module:[],
        information:{}
      }
    },
    created: function () {
      this.contain.Height=document.documentElement.clientHeight;
      this.contain.Width=document.documentElement.clientWidth;
      console.log('cteated 钩子执行...');

      var getComponent = new FormData();
      getComponent.append("ID", "1");
      api.getUserInformation(getComponent).then((response) => response.json())
        .then((data) => {
          this.information =data.data;
        });
      api.getComponentDir(getComponent).then((response) => response.json())
        .then((data) => {
          this.module =data.data;
        });
      var getDataSource = new FormData();
      getDataSource.append("ID", "2");
      api.getComponentDir(getDataSource).then((response) => response.json())
        .then((data) => {
          this.DataSource =data.data;
        });

      var formData = new FormData();
      formData.append("ID", "0");
      api.getMenu(formData).then((response) => response.json())
        .then((data) => {
          this.items =data.data;
        });

      var formDirData = new FormData();
      formDirData.append("ID", "6");
      api.getExperimentDir(formDirData).then((response) => response.json())
        .then((data) => {
          this.document =data.data;
        });

      api.getDir(formData).then((response) => response.json())
        .then((data) => {
          this.selectdir =data.data;
        });

    },
    methods: {
      getInfoExperiment:function (msg) {
        console.log("child-info-experiment>>"+msg);
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      submitForm(subfrom){
        this.$refs[subfrom].validate((valid) => {
          if (valid) {
            console.log("Info>>submit!>>"+this.ruleForm.address);
            var addExperiment = new FormData();
            addExperiment.append('Name',this.ruleForm.name);
            addExperiment.append('Region',this.ruleForm.region);
            addExperiment.append('Desc',this.ruleForm.desc);
            addExperiment.append('Address',this.ruleForm.address);
            api.addExperiment(addExperiment).then((response) => response.json())
              .then((data) => {
                this.openNewExperiment = false;
                Message({
                  dangerouslyUseHTMLString: true,
                  message: "<strong>创建实验"+this.ruleForm.name+"成功！</strong><br><strong>创建时间:<i>"+this.currentDate+"</i></strong>",
                  iconClass:'ml-icon-shiyan'
                });
              });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      handleSelect:function(key, keyPath) {
        console.log(key);
        for (var item in this.items) {
          console.log(this.items[item].dex);
          this.show[this.items[item].dex]=false;
        }
        this.show[key]=true;
        if( contains(key,['shiyan','zujian','moxing','shuju']) ){
          this.show['task']=true;
        }else {
          this.show['task']=false;
        }
      }
    }
  }
  function contains(obj,arr) {
    var i = arr.length;
    while (i--) {
      if (arr[i] === obj) {
        return true;
      }
    }
    return false;
  }

</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
ul{
  padding: 0px;
}
  .ml-menu{
    border: none;
  }
  .ml-menu li{
    padding-left: 0px;
    text-align: center;
  }
  #index .el-main,#index .el-aside{
    padding: 0px;
  }

  .pai-btn-create {
    position: relative;
    height: 100%;
    width: 100%;
    line-height: 4;
    font-size: 16px;
    text-align: center;
    cursor: pointer;
    color: #182a3c;
    background-color: hsla(0,0%,100%,.9);
    -webkit-transition: background-color .2s ease;
    -o-transition: background-color .2s ease;
    transition: background-color .2s ease;
    -webkit-box-shadow: 0 0 16px -5px rgba(0,0,0,.2);
    box-shadow: 0 0 16px -5px rgba(0,0,0,.2);
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

.el-card .ml-icon-tianjia,.el-card .ml-icon-moban{
    height: 100px;
    padding-top: 30px;
    font-size: 80px;
    line-height: 100px;
    text-align: center;
    width: 100%;
  }
  .el-card .ml-icon-tianjia{
    color: #67c23a;
  }
  .el-card .ml-icon-moban {
    color: #8cc5ff;
  }
  .el-card{
    cursor: pointer;
  }
  .el-card:hover {
    background-color: #f5f7fa;
  }

  .ml-table-expand {
    font-size: 0;
  }
  .ml-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .ml-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 100%;
  }
  .el-radio-group{
    width: 100%;
  }

  #colleft ::-webkit-scrollbar {
    width: 6px;
    height: 6px;
  }
  #colleft ::-webkit-scrollbar-thumb {
    background-color: #aeaeae;
    min-height: 50px;
    min-width: 50px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    -webkit-transition: background-color .2s;
    -o-transition: background-color .2s;
    transition: background-color .2s;
  }
  #colleft ::-webkit-scrollbar-track-piece {
    background-color: #eee;
  }
</style>
