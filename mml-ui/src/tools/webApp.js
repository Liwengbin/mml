const webApp = {
  daytime:{//白天
    ASIDE_BACKGROUND_COLOR:'#454c59',
    ASIDE_ICO_TEXT_COLOR:'#FFF',
    ACTIVE_TEXT_COLOR:"#ffd04b",
    BOX_HOM_BACKGROUND_COLOR:'#e7ecf5',//首页背景颜色
    TEMPLATE_BACKGROUND_COLOR:'#FFF',//首页模板背景颜色
    TEMPLATE_BACKGROUND_COLOR_HOVER:'rgba(0,170,238,.6)',//鼠标上移动背景颜色
    TEMPLATE_COLOR:'#666',

    SUBASSEMBLY_ICON_BACKGROUND_COLOR:'#74aece',//组件图标颜色
    SUBASSEMBLY_TEXT_COLOR:'#666'
  },
  night:{//夜间
    ASIDE_BACKGROUND_COLOR:'#454c59',
    ASIDE_ICO_TEXT_COLOR:'#FFF',
    BOX_HOM_BACKGROUND_COLOR:'#e7ecf5',//首页背景颜色
    TEMPLATE_BACKGROUND_COLOR:'#FFF',//首页模板背景颜色
    TEMPLATE_BACKGROUND_COLOR_HOVER:'rgba(0,170,238,.6)',//鼠标上移动背景颜色
    TEMPLATE_COLOR:'#666',

    SUBASSEMBLY_ICON_BACKGROUND_COLOR:'#74aece',//组件图标颜色
    SUBASSEMBLY_TEXT_COLOR:'#666'
  },
  jianjie:{
    title:'简介',
    value:['ml 是一款全新的机器学习平台',
    '本版本定位于：易用、强大、高效。通过提供丰富易用的界面拖拽组件以及背后强大的数据处理功能，让用户轻松上手，完成各种机器学习建模分析任务。主要包\n' +
    '含了： 数据源创建、特征工程、机器学习算法、模型评估、一键部署以及训练数据可视化等。',
    '数据源创建： 支持本地文件上传、实时流数据接入（Kafka、Redis）、Hdfs数据（Hive）、Mysql等。',
    '机器学习模型：'+
    '从底层支持而言，主要分为Spark、Tensorflow与MXNet三种，封装了常用的机器学习算法。包括但不局限于： 逻辑回归LR、梯度提升' +
    '决策树GBDT、因子分解模型FM、深度神经网络DNN、分类SVM、聚类Kmeans、主题模型LDA、协同过滤CF以及Spark原生自带算法等' +
    '。' ,
    '模型评估： 对模型训练结果进行可视化分析，比如ROC曲线绘制等。',
    '一键部署： 基于ml平台实现项目的一键部署上线，通过开发通用的Score框架，实现各种模型的嵌入。']
  },
  banben:{title:'版本沿进',
          value:['主要参照阿里数加机器学习平台 + 谷歌云机器学习平台进行改造。','提供更友好的使用姿势，更快捷的实验处理过程。']}

};
export default webApp;
