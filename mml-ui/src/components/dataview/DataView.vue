<template>
  <div id="view">
    <el-table
      v-if="viewtype === 'table'"
      :data="tData.tableContext"
      stripe
      style="width: 100%">
      <el-table-column v-for="item in tData.tableHeader"
        :prop="item"
        :label="item">
      </el-table-column>
    </el-table>
    <template v-else-if="viewtype === 'log'">
      <el-pagination
        background
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :page-size="5"
        :total="50">
      </el-pagination>
      <el-collapse accordion>
        <el-collapse-item v-for="item in tData">
          <template slot="title">
            {{ item.callerFilename}} <i class="header-icon el-icon-info"> {{ item.levelString }}</i>
          </template>
          <div>时间:{{timeStamp2String(item.timestmp)}}</div>
          <div>Message:{{ item.formattedMessage }}</div>
          <div>callerClass:{{item.callerClass}}</div>
          <div>callerFilename:{{item.callerFilename}}</div>
          <div>callerLine:{{item.callerLine}}</div>
        </el-collapse-item>
      </el-collapse>
    </template>
    <template v-else>
      <div id="myChart" :style="{width: '100%', height: '400px'}"></div>
    </template>
  </div>
</template>
<script>
  import api from '../../api/api'
  import $ from 'jquery';
  export default {
    props:['tData','viewtype'],
    name:"MlDataView",
    data() {
      return {

      }
    },
    watch:{
      tData:{
        handler:function(val){
          this.drawLine();
          }
        },
        deep:true//对象内部的属性监听，也叫深度监听
      },
    mounted(){
      /*this.drawLine();*/
    },
    methods: {
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        var datafrom = new FormData();
        datafrom.append("page", val-1);
        datafrom.append("size", 5);
        datafrom.append("callerMethod", "f");
        api.getLogging(datafrom).then((response) => response.json())
          .then((data) => {
            this.tData = data.data;
          });
      },
      timeStamp2String (time){
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1;
        var date = datetime.getDate();
        var hour = datetime.getHours();
        var minute = datetime.getMinutes();
        var second = datetime.getSeconds();
        var mseconds = datetime.getMilliseconds();
        return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second+"."+mseconds;
      },
      drawLine(){
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('myChart'))
        // 绘制图表
        let option = null;
        console.log("12345654323456ert54323456");
        switch(this.viewtype){
          case 'radar':
            console.log("1234565432345654323456");
            var l = this.tData;

            var arr1 = new Array();
            var arr3 = new Array();
            for (var index in this.tData) {
              var arr2 = new Array();
              for (var i = 1; i < this.tData[index].tableHeader.length; i++) {
                arr2.push(this.tData[index].tableData[i]);
              }
              arr3.push(arr2);
            }
            for (var i = 1; i < this.tData[0].tableHeader.length; i++) {
              arr1.push({name: this.tData[0].tableHeader[i], max: this.tData[0].columnLimit[i]});
            }

            let res = {
              header:arr1,
              tableData:arr3
            }

            let leg= new Array();
              for (var index in this.tData) {
                leg.push(this.tData[index].tableData[0])
              }

            let ser= new Array();
              for (var index in this.tData){
                ser.push({
                  value : res.tableData[index],
                  name : leg[index]
                });
              }

            option = {
              tooltip: {},
              legend: {
                data: leg
              },
              radar: {
                // shape: 'circle',
                name: {
                  textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                  }
                },
                indicator: res.header
              },
              series: [{
                name: leg,
                type: 'radar',
                // areaStyle: {normal: {}},
                data : ser
              }]
            };
            break;
          case 'lineBar':

            break;
          default:break;
        }


        myChart.setOption(option);
      }
    },
    created: function () {
      console.log('cteated 钩子执行...');

    }
  }

</script>
<style>
   #view .el-collapse-item .el-collapse-item__arrow{
    height: 48px;
    line-height: 48px;
  }
</style>
