<template>
  <el-container>
    <el-header style="height: 40px;
                      border-bottom: 1px solid #c0c4cc;
                      text-align: center;
                      line-height: 40px;">
      <span class="icon ml-icon ml-icon-shiyan"></span>
      <span class="tree-node-label">我的实验</span>
    </el-header>
    <el-main id="main" v-bind:style="{height:(contain.Height-140)+'px',padding: 0+'px',position:'relative'}">
      <div v-bind:style="{minHeight:contain.Width+'px',minWidth:contain.Width+'px'}">
        <svg xmlns="http://www.w3.org/2000/svg" id="svgmain" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" preserveAspectRatio="xMinYMin meet" @drop='drop($event)' @dragover='allowDrop($event)' class="svg-main" v-bind:style="{minHeight:contain.Width+'px',minWidth:contain.Width+'px'}">
          <g v-bind:transform="'scale('+svgProportion.x+','+svgProportion.y+')'">
          <template v-for="pathl in paths">
            <g>
              <g :class="pathl.startC" :id="pathl.id">
                <path class="connector-wrap" :d="pathl.d">
                </path>
                <path class="connector" :d="pathl.d">
                </path>
                <path class="source-marker">
                </path>
                <path class="target-marker">
                </path>
                <rect class="comment-bg" width="" height="" transform="">
                </rect>
                <text class="comment" y="" transform="">
                </text>
              </g>
            </g>
          </template>
          <g>
            <g :class="pathing.startC" :id="pathing.id">
              <path class="connector-wrap" :d="pathing.d">
              </path>
              <path class="connector" :d="pathing.d">
              </path>
              <path class="source-marker">
              </path>
              <path class="target-marker">
              </path>
              <rect class="comment-bg" width="" height="" transform="">
              </rect>
              <text class="comment" y="" transform="">
              </text>
            </g>
          </g>
          <g>
          <template v-for="node in nodes">
            <g class="pane-cell pane-node" v-bind:transform="'translate('+node.positionX+','+node.positionY+')'">
              <g class="pane-scalable" transform="scale(1,1)">
                <foreignObject width="180" height="30">
                  <body xmlns="http://www.w3.org/1999/xhtml">
            <div @mousedown="nodeClick($event,node.id,node.cateGory)" class="pane-node-content element-analytics has-status ml-node" :id="'node_'+node.id" :data-id="node.id" t-node="g" @dragstart='drag($event)' draggable="true">
            <span :class="'icon '+node.icon">
            </span>
                    <span>
            </span>
                    <span class="name" >
              {{node.name}}
            </span>
                    <span :class="'status ml-icon-'+start[node.id]">
            </span>
                    <div class="pane-port-list in">
                      <template v-for="inPort in node.inPorts">
                      <div class="pane-port-wrap" :style="{width:1/(node.inPorts.length+1)*100+'%'}">
                        <div  :class="[ contains(inPort.id,InPort) ? 'pane-port is-connected': 'pane-port']"  :id="'inPort_'+inPort.id" @drop='indrop($event)' @dragover='inallowDrop($event)'>
                            <span class="port-magnet" :in-id="inPort.id" :data-id="node.id">
                            </span>
                        </div>
                      </div>
              </template>
                    </div>


                    <div class="pane-port-list out">
                      <template v-for="outPort in node.outPorts">
                      <div class="pane-port-wrap" :style="{width:1/(node.outPorts.length+1)*100+'%'}">
                        <div class="pane-port" :id="'outPort_'+outPort.id" :out-id="outPort.id" :data-id="node.id" t-node="port" @drag='dragging($event)' @dragstart='outdrag($event)' draggable="true">
                  <span class="port-magnet">
                  </span>
                        </div>
                      </div>
                      </template>
                    </div>

                  </div>
                  <div class="pane-node-bulb">
            <span class="icon icon-bulb">
            </span>
                  </div>
                  </body>
                </foreignObject>
              </g>
            </g>
          </template>
          </g>
          </g>
        </svg>
      </div>
      <div class="pai-bnpm-actions">
        <ul>
          <li @click="magnify">
            <el-tooltip class="item" effect="dark" content="放大" placement="right">
              <span class="el-icon-zoom-in"></span>
            </el-tooltip>
          </li>
          <li @click="shrink">
            <el-tooltip class="item" effect="dark" content="缩小" placement="right">
			        <span class="el-icon-zoom-out"></span>
            </el-tooltip>
          </li>
          <li>
            <el-tooltip class="item" effect="dark" content="适应画布" placement="right">
			        <span class="el-icon-d-caret"> </span>
            </el-tooltip>
          </li>
          <li>
            <el-tooltip class="item" effect="dark" content="实际尺寸" placement="right">
			        <span class="el-icon-upload2"></span>
            </el-tooltip>
          </li>
        </ul>
      </div>
    </el-main>
    <el-footer style="text-align: center">
      <el-button type="text" icon="icon ml-icon-yunxing">运行</el-button>
      <el-button type="text" icon="el-icon-upload">上传</el-button>
      <el-button type="text" icon="el-icon-share">分享</el-button>
    </el-footer>
    <div id="contextView" class=" ui-context-menu-layer ml-right" tabindex="-1" style="z-index: 9999; display: none;">
      <ul class="ui-context-menu" role="menu" style="top: 200px; left: 693px;">
        <li class="ui-context-menu-item" role="menuItem" data-id="node-rename">
          <i role="menuItemIcon" class="ml-icon-chongmingming">
          </i>
          <span class="item-name" role="menuItemLabel">
				重命名
			</span>
        </li>
        <li class="ui-context-menu-item" role="menuItem" data-id="node-delete">
          <i role="menuItemIcon" class="ml-icon-shanchu">
          </i>
          <span class="item-name" role="menuItemLabel">
				删除
			</span>
          <span class="item-access-key" role="menuAccessKey">
				<i>
					Delete
				</i>
			</span>
        </li>
        <li class="ui-context-menu-item" role="menuItem" data-id="node-copyNodes">
          <i role="menuItemIcon" class="ml-icon-fuzhi">
          </i>
          <span class="item-name" role="menuItemLabel">
				复制
			</span>
          <span class="item-access-key" role="menuAccessKey">
			</span>
        </li>
        <li class="ui-context-menu-item" role="menuItem" data-id="node-showLog" @click="viewdata('log')">
          <i role="menuItemIcon" class="ml-icon-chakan">
          </i>
          <span class="item-name" role="menuItemLabel">
				查看日志
			</span>
          <span class="item-access-key" role="menuAccessKey">
			</span>
        </li>
        <li class="ui-context-menu-item hidden" role="menuItem" data-id="node-showTensorboard" @click="viewdata('table')">
          <i role="menuItemIcon" class="ml-icon-shuju">
          </i>
          <span class="item-name" role="menuItemLabel">
				    查看数据
			    </span>
        </li>
        <li v-if="cateGory !== 'table'" class="ui-context-menu-item hidden" role="menuItem" data-id="node-showTensorboard" @click="viewdata('radar')">
          <i role="menuItemIcon" class="ml-icon-fenxi1">
          </i>
          <span class="item-name" role="menuItemLabel">
            查看视图
        </span>
        </li>
      </ul>
    </div>
    <el-dialog title="节点数据" :visible.sync="dialogDataView"><ml-data-view :tData="viewData" :viewtype="viewType"></ml-data-view></el-dialog>
  </el-container>
</template>

<script>
  import api from '../../api/api'
  import ElFooter from "../../../node_modules/element-ui/packages/footer/src/main.vue";
  import ElMain from "../../../node_modules/element-ui/packages/main/src/main.vue";
  import ElHeader from "../../../node_modules/element-ui/packages/header/src/main.vue";
  import { Message } from 'element-ui';
  import $ from 'jquery';
  import MlDataView from "../dataview/DataView.vue";
  export default {
    name:"MlSvgMain",
    components: {
      MlDataView,
      ElHeader,
      ElMain,
      ElFooter
    },
    props: ['contain','svgProportion','now'],
    data() {
      return {
        nowNode:1,
        dialogDataView:false,
        contextView:false,
        viewData:[],
        cateGory:"table",
        viewType:"table",
        py: null, px: null,
        InPort:[],
        paths: [],
        nodes:[],
        nodelinks:[],
        pathing: {
          startC: 'pane-cell pane-link',
          id: 'pathing',
          d: null
        },
        start: {}
      };
    },

    watch:{
      now:{
        handler:function(val){
          console.log('svgMain>>Infon >>'+val.id);
          if(val.type == "experiment"){
            var formSVGData = new FormData();
            formSVGData.append("ID", val.id);
            api.getNodeAll(formSVGData).then((response) => response.json())
              .then((data) => {
                this.nodes = data.data;
                console.log('nodes数据='+this.nodes);
                api.getNodeLinkAll(formSVGData).then((response) => response.json())
                  .then((data) => {
                    this.nodelinks = data.data;
                    console.log('nodelink数据='+this.nodelinks);
                    this.initTypeport();
                    this.initpath();
                  });
              });

            api.getNodeState(formSVGData).then((response) => response.json())
              .then((data) => {
                this.start = data.data;
              });
          }
        },
        deep:true//对象内部的属性监听，也叫深度监听
      },
      nodes:{
        handler:function(val){
          this.initpath();
        },
        deep:true//对象内部的属性监听，也叫深度监听
      }
    },
    mounted: function () {
      console.log('SVG-mounted 钩子执行...');
      /*SVG-data*/
      var formSVGData = new FormData();
      formSVGData.append("ID", "1");

      api.getNodeAll(formSVGData).then((response) => {
          if(response.ok){
            return response.json()
          }
          else{
            throw "getNodeAll error";
          }
        })
        .then((data) => {
          this.nodes = data.data;
          api.getNodeLinkAll(formSVGData).then((response) => response.json())
            .then((data) => {
              this.nodelinks = data.data;
              this.initTypeport();
              this.initpath();
            });
        }).catch( err => console.log(err) );

      api.getNodeState(formSVGData).then((response) => response.json())
        .then((data) => {
          this.start = data.data;
        });
    },
    methods: {
      viewdata:function (viewtype) {
        this.dialogDataView = true;
        this.viewType = viewtype;
        var datafrom = new FormData();
        datafrom.append("page", 0);
        datafrom.append("size", 30);
        datafrom.append("nodeId", this.nowNode);

        switch(this.viewType){
          case 'table':
            api.getNodeTableData(datafrom).then((response) => response.json())
              .then((data) => {
                this.viewData = data.data;
              });
            break;
          case 'radar':
            api.getNodeRadarData(datafrom).then((response) => response.json())
              .then((data) => {
                this.viewData = data.data;
              });
            break;
          case 'lineBar':
            api.getNodeLineBarData(datafrom).then((response) => response.json())
              .then((data) => {
                this.viewData = data.data;
              });
            break;
          case 'log':
            datafrom.append("callerMethod", "f");
            datafrom.set("page", 0);
            datafrom.set("size", 5);
            api.getLogging(datafrom).then((response) => response.json())
              .then((data) => {
                this.viewData = data.data;
              });
            break;
          default:break;
        }

        if(false) {
          datafrom.append("className", "二班");
          api.getData(datafrom).then((response) => response.json())
            .then((data) => {
              this.viewData = data.data;
            });
        }
      },
      contains:function (key,arr) {
        return contain(key,arr);
      },
      nodeClick:function (aevent,data_id,cate) {
        this.cateGory = cate;
        if(window.event)aevent=window.event;      //解决兼容性
        //右键为3
        if (3 == aevent.which) {              //当事件属性button的值为2时，表用户按下了右键
          document.oncontextmenu = function (aevent) {
            if (window.event) {
              aevent = window.event;
              aevent.returnValue = false;         //对IE 中断 默认点击右键事件处理函数
            } else {
              aevent.preventDefault();          //对标准DOM 中断 默认点击右键事件处理函数
            }
            ;
          };
          $("#contextView").css('display','block');
          $(".ml-right > ul").css('top',aevent.clientY-40);
          $(".ml-right > ul").css('left',aevent.clientX-60);
          this.nowNode = data_id;
          aevent.preventDefault();//阻止捕获生成菜单
          console.log('Info 右击事件!!'+cate);
        } else if (1 == aevent.which) {
          //左键为1
          this.now.id = data_id;
          this.now.type = "node";
          console.log('Info 左键事件!! >>'+data_id);
        }
        console.log('Info>> nodeClick>> 事件>> '+data_id);
      },
      initTypeport:function () {
        for (var linkcode in this.nodelinks) {
          var inportid = this.nodelinks[linkcode].inputPortId;
          this.InPort.push(inportid);
          //var dtag = document.getElementById('inPort_'+inportid);
          console.log('class'+inportid);
          //dtag.setAttribute('class', 'pane-port is-connected');
          }
      },
      magnify:function () {
        this.svgProportion.x=this.svgProportion.x+0.2;
        this.svgProportion.y=this.svgProportion.y+0.2;
      },
      shrink:function () {
        if(this.svgProportion.x <=0.4){
          Message({
            showClose: true,
            message: '不能再缩小了哦！',
            type: 'warning'
          });
        }else{
          this.svgProportion.x=this.svgProportion.x-0.2;
          this.svgProportion.y=this.svgProportion.y-0.2;
        }
      },
      canvas:function () {

      },
      measure:function () {

      },
      initpath: function () {
        var mx, my, tx, ty, soc, tag, inportid, outportid, outwidth, inwidth, startC = 'pane-cell pane-link';
        this.paths.splice(0, this.paths.length);
        for (var linkcode in this.nodelinks) {
          soc = this.nodelinks[linkcode].source;
          tag = this.nodelinks[linkcode].target;
          inportid = this.nodelinks[linkcode].inputPortId;
          outportid = this.nodelinks[linkcode].outputPortId;
          for (var nodecode in this.nodes) {
            if (soc == this.nodes[nodecode].id) {
              mx = this.nodes[nodecode].positionX;
              my = this.nodes[nodecode].positionY;
              for (var outport in this.nodes[nodecode].outPorts) {
                if (this.nodes[nodecode].outPorts[outport].id == outportid) {
                  outwidth = (182 * this.nodes[nodecode].outPorts[outport].sequence) / (this.nodes[nodecode].outPorts.length + 1);
                }
              }
            } else if (tag == this.nodes[nodecode].id) {
              tx = this.nodes[nodecode].positionX;
              ty = this.nodes[nodecode].positionY;
              for (var inport in this.nodes[nodecode].inPorts) {
                if (this.nodes[nodecode].inPorts[inport].id == inportid) {
                  inwidth = (182 * this.nodes[nodecode].inPorts[inport].sequence) / (this.nodes[nodecode].inPorts.length + 1);
                }
              }
              if (this.start[tag] == 'running') {
                startC = "pane-cell pane-link pane-link-flow";
              } else {
                startC = 'pane-cell pane-link';
              }
            }
          }
          console.log(linkcode);
          var m1 = new xy(mx + outwidth, my + 30);
          var t1 = new xy(tx + inwidth+1, ty);
          var jspath = new JsPath(m1, t1);
          var str = {
            "soc": soc,
            "tag": tag,
            "id": Math.floor(Math.random() * 100 + 1),
            "d": jspath.d,
            "startC": startC,
            "outwidth": outwidth,
            "inwidth": inwidth
          };
          this.paths.push(str);
        }
      },
      drop: function (event) {
        //event.preventDefault();
        var datae = event.dataTransfer.getData("mlid");
        var item = document.getElementById(datae);

        var svg_id = event.target;
        var x = event.clientX;
        var y = event.clientY;
        var t_node = item.attributes["t-node"].value;

        switch (t_node) {
          case 'g':
            var nodeid = item.attributes["data-id"].value;
            console.log('--> Event mouseup x: ' + x + ', y: ' + y);
            var vx = x - event.dataTransfer.getData("mx");
            var vy = y - event.dataTransfer.getData("my");

            for (var cnode in this.nodes) {
              if (this.nodes[cnode].id == nodeid) {
                this.nodes[cnode].positionX += vx;
                this.nodes[cnode].positionY += vy;
              }
            }
            this.initpath();
            break;
          case 'span':
            var t_item_id = item.attributes["data-id"].value;
            var formData = new FormData();
            formData.append("ID", t_item_id);
            formData.append("nodeX", (event.clientX - svg_id.getBoundingClientRect().left - 95)/this.svgProportion.x);
            formData.append("nodeY", (event.clientY - svg_id.getBoundingClientRect().top - 16)/this.svgProportion.y);
            formData.append("experimentId",this.now.experiment);
            api.addNode(formData).then((response) => response.json())
              .then((data) => {
                this.nodes.push(data.data);
                this.start[data.data.id]="ready";
              });
            break;
          case 'port':
            this.pathing.d = "M0 0 Q 0 0, 0 0 T 0 0";
            console.log('Event>> Info >>' + t_node + '没有拖拽到目标元素！');
            break;
          default:
            this.pathing.d = "M0 0 Q 0 0, 0 0 T 0 0";
            console.log('Event>> Exception >>' + t_node + '失败！');
        }
      },

      allowDrop: function (event) {//阻止捕获
        event.preventDefault();
      },
      drag: function (event) {
        console.log('Event>> INFO >>' + event.which + '提示！');
        event.dataTransfer.setData("mlid", event.target.id);
        event.dataTransfer.setData("mx", event.clientX);
        event.dataTransfer.setData("my", event.clientY);
      },

      indrop: function (event) {
        event.stopPropagation();
        var inid = event.target.getAttribute('in-id');
        var out = event.dataTransfer.getData("mlid");
        var outid = document.getElementById(out).getAttribute('out-id');
        var inNodeid = event.target.getAttribute('data-id');
        var outNodeid = event.dataTransfer.getData('outNodeid');

        var formData = new FormData();
        formData.append("Source", outNodeid);
        formData.append("outputPortId", outid);

        formData.append("Target", inNodeid);
        formData.append("inputPortId", inid);

        formData.append("experimentId", this.now.experiment);
        api.addNodeLink(formData).then((response) => response.json())
          .then((data) => {
            this.nodelinks.push(data.data);
            this.initpath();
            this.initTypeport();
          });

        console.log('indrop>> in >>' + inid);
        console.log('indrop>> out >>' + outid);
        console.log('indrop>> in >>' + inNodeid);
        console.log('indrop>> out >>' + outNodeid);
        this.pathing.d = "M0 0 Q 0 0, 0 0 T 0 0";
      },
      inallowDrop: function (event) {//阻止捕获
        //event.preventDefault();
      },
      outdrag: function (event) {
        event.dataTransfer.setData("mlid", event.target.id);
        var outNodeid = event.target.getAttribute('data-id')
        event.dataTransfer.setData("outNodeid", outNodeid);

        this.px = event.clientX;
        this.py = event.clientY;
        var img = new Image();
        img.src = '../../src/assets/outicon.png';
        event.dataTransfer.setDragImage(img, 8, 3);
      },
      dragging: function (event) {
        var svg_id = document.getElementById('svgmain');

        console.log("元素被拖动");
        console.log("X=" + event.clientX);
        console.log("Y=" + event.clientY);

        var m1 = new xy((this.px - svg_id.getBoundingClientRect().left)/this.svgProportion.x, (this.py - svg_id.getBoundingClientRect().top)/this.svgProportion.y);
        var t1 = new xy((event.clientX - svg_id.getBoundingClientRect().left)/this.svgProportion.x, (event.clientY - svg_id.getBoundingClientRect().top)/this.svgProportion.y);

        var jspath = new JsPath(m1, t1);
        this.pathing.d = jspath.d;
        this.pathing.id = Math.floor(Math.random() * 100 + 1);
        this.pathing.startC = 'pane-cell pane-link';
      }
    }
  };

  $(document).ready(function(){
    $(document).click(function(event){
      if(window.event)event=window.event;      //解决兼容性
      //右键为3
      if (3 == event.which) {}
      else if(1 == event.which){
        $("#contextView").css('display','none');
      }else {
        $("#contextView").css('display','none');
      }

      /*      var _con = $('#contextView');   // 设置目标区域
            if(!_con.is(event.target) && _con.has(event.target).length === 0){ // Mark 1
              $("#contextView").css('display','none');        //淡出消失
            }*/
    });
    $("#main").bind("contextmenu",function(e){
      return false;
    });

    $(".ml-r").bind("contextmenu",function(e){
      return false;
    });
  });

  function contain(obj,arr) {
    var i = arr.length;
    while (i--) {
      if (arr[i] === obj) {
        return true;
      }
    }
    return false;
  };
  function xy(x1,y1) {
    this.x=x1;
    this.y=y1;
    return this;
  };
  function JsPath(m1,t1) {
    var MT = new getPath(m1, t1);
    this.d = "M" + MT.M.x + " " + MT.M.y + " Q " + MT.Q1.x + " " + MT.Q1.y + ", " + MT.Q2.x + " " + MT.Q2.y + " T " + MT.T.x + " " + MT.T.y
    return this;
  };
   function getPath(m, t) {
    var mtx = Math.floor((t.x - m.x) / 4);
    var mty = Math.floor((t.y - m.y) / 4);
    this.M = m;
    this.T = t;
    if(Math.abs(mtx)*0.25>Math.abs(mty) || mty<=10){
      if(mty<10 && mty>-10){
        this.Q1 = new xy(m.x+5, m.y + 10);
      }else{
        this.Q1 = new xy(m.x+5, m.y + 3 * Math.abs(mty));
      }
      this.Q2 = new xy(m.x + 2 * mtx, m.y + 2 * mty);
    }else{
      this.Q1 = new xy(m.x, m.y + 2 * mty);
      this.Q2 = new xy(m.x + 2 * mtx, m.y + 2 * mty);
    }
    return this;
  }
</script>

<style>
  .svg-main{

  }
  .pane-node body, .pane-node foreignObject {
    background-color: transparent;
    overflow: visible;
  }
  .pane-node{
    display: block;
    cursor: -webkit-grab;
  }
  .ml-node:hover{
    background-color: #ecf5ff;
  }
  .pane-node-content {
    width: 180px;
    height: 30px;
    background-color: hsla(0,0%,100%,.9);
    border: 1px solid #289de9;
    border-radius: 15px;
    font-size: 12px;
    -webkit-transition: background-color .2s;
    transition: background-color .2s;
  }

  .pane-node-content .icon {
    float: left;
    color: #fff;
    font-size: 16px;
    background-color: #289de9;
  }
  .pane-node-content .status {
    float: left;
    font-size: 16px;
  }
  .pane-node-content .ml-icon-success{
    color: #7bff27;
  }
  .pane-node-content .ml-icon-running{
    color: #7bff27;
  }
  .pane-node-content .ml-icon-ready{
    color: #567eff;
  }
  .pane-node-content .ml-icon-mistake{
    color: #ff312a;
  }
  .pane-node-content .name {
    float: left;
    width: 120px;
    height: 28px;
    line-height: 28px;
    font-size: 14px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .pane-node-content .icon, .pane-node-content .status {
    width: 16px;
    height: 16px;
    padding: 6px;
    margin: 1px;
    border-radius: 100%;
  }
  .pane-port-list.in {
    clear: both;
    margin-top: -36px;
  }
  .pane-port-list {
    float: left;
    width: 180px;
    margin-top: -5px;
  }
  .pane-port-wrap {
    height: 1px;
    float: left;
  }
  .pane-port-list.out {
    margin-top: -5px;
    clear: both;
  }

  .pane-port {
    width: 10px;
    height: 10px;
    float: right;
    margin-right: -5px;
    border: 1px solid gray;
    border-radius: 50%;
    background-color: #fff;
    -webkit-transition: background-color .2s;
    transition: background-color .2s;
  }
  .pane-port .port-magnet {
    float: left;
    width: 20px;
    height: 20px;
    margin-top: -6px;
    margin-left: -6px;
    background-color: transparent;
    border-radius: 50%;
  }
  .pane-port-list.out .pane-port {
    cursor: crosshair;
  }

  .pane-port-list.in .pane-port {
    cursor: auto;
  }
  .pane-link, .pane-link-connecting {
    cursor: default;
  }
  .pane-link .connector-wrap {
    fill: none;
    stroke: hsla(0,0%,100%,0);
    stroke-width: 15px;
  }
  .pane-link-connecting .connector, .pane-link .connector {
    fill: none;
    stroke: gray;
    stroke-width: 1px;
  }
  .pane-link-connecting .target-marker, .pane-link .target-marker {
    fill: gray;
    stroke: gray;
    stroke-width: 1px;
  }
  .pane-link .comment-bg {
    fill: #f1f9fd;
    stroke: #ccc;
    stroke-dasharray: 3;
  }
  .pane-link .comment {
    font-size: 12px;
  }
  .pane-port-list.in .pane-port.is-connected {
    width: 0;
    height: 0;
    border-style: solid;
    border-width: 5px 4px 0;
    border-color: gray transparent transparent;
    background-color: transparent;
    border-radius: 0;
    margin-top: 3px;
  }

  .pane-link-connecting.pane-link-flow .connector, .pane-link.pane-link-flow .connector {
    stroke: rgba(57,202,116,.8);
    stroke-width: 2px;
    stroke-dasharray: 5;
    -webkit-animation: ant-line 30s infinite linear;
    -o-animation: ant-line 30s infinite linear;
    animation: ant-line 30s infinite linear;
  }

  .pai-bnpm-actions {
    position: absolute;
    font-size: 16px;
    top: 52px;
    z-index: 9999;
    right: 18px;
    width: 32px;
    background-color: hsla(0,0%,96%,.9);
    border: 1px solid hsla(0,0%,93%,.9);
    -webkit-box-shadow: 0 0 20px rgba(0,0,0,.01);
    box-shadow: 0 0 20px rgba(0,0,0,.01);
    border-radius: 3px;
  }

  .pai-bnpm-actions ul {
    padding: 2px 0;
  }
  .pai-bnpm-actions .item{
    width: 100%;
    height: 100%;
    text-align: center;
  }
  .pai-bnpm-actions li{
    line-height: 1.5;
    cursor: pointer;
  }

  .ui-context-menu {
    margin: 0;
    padding: 5px 0;
    min-width: 200px;
    position: absolute;
    list-style: none;
    background-color: rgba(255,255,255,.98);
    border: 1px solid #eee;
    -webkit-box-shadow: 5px 5px 30px rgba(0,0,0,.1);
    box-shadow: 5px 5px 30px rgba(0,0,0,.1);
    border-radius: 2px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }
  .ui-context-menu-item {
    position: relative;
    font-size: 12px;
    color: #333;
    height: 26px;
    line-height: 26px;
    padding-left: 30px;
    padding-right: 10px;
    cursor: pointer;
    -webkit-transition: background-color .1s ease;
    -o-transition: background-color .1s ease;
    transition: background-color .1s ease;
  }
  .ui-context-menu-item .icon {
    color: #666;
    position: absolute;
    top: 5px;
    left: 7px;
  }

  .ui-context-menu-item:hover{
    background-color: #eee;
  }
  .ui-context-menu-layer {
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: transparent;
  }
</style>
