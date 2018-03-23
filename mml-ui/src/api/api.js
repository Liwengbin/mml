import http from '../utils/HTTP'
var api={};
api.getMenu=(data)=>http('GET','/app.json/menu',data);
api.getExperiment=(data)=>http('GET','/init.json/experiment/getExperiment',data);
api.getExperimentDir=(data)=>http('GET','/init.json/experiment/getExperimentDir',data);
api.getDir=(data)=>http('GET','/init.json/experiment/getDir',data);

api.getData=(data)=>http('POST','/user.json/data/getData',data);
api.addExperiment=(data)=>http('POST','/user.json/experiment/addExperiment',data);
api.getUserInformation=(data)=>http('POST','/user.json/user/getUserInformation',data);
api.addNode=(data)=>http('POST','/task.json/norun/addNode',data);
api.addNodeLink=(data)=>http('POST','/task.json/norun/addNodeLink',data);
api.getNode=(data)=>http('POST','/task.json/norun/loadNode',data);
api.getNodeState=(data)=>http('GET','/task.json/norun/getNodeState',data);
api.getNodeTableData=(data)=>http('POST','/user.json/data/getNodeTableData',data);
api.getNodeLineBarData=(data)=>http('POST','/user.json/data/getNodeLineBarData',data);
api.getNodeRadarData=(data)=>http('POST','/user.json/data/getNodeRadarData',data);

api.getNodeAll=(data)=>http('GET','/task.json/norun/loadNodeAll',data);
api.getNodeLinkAll=(data)=>http('GET','/task.json/norun/loadNodeLinkAll',data);
api.deleteNode=(data)=>http('POST','/task.json/norun/deleteNode',data);
api.deleteNodeLink=(data)=>http('POST','/task.json/norun/deleteNodeLink',data);
api.getComponent=(data)=>http('GET','/init.json/component/getComponent',data);
api.getComponentDir=(data)=>http('GET','/init.json/component/getComponentDir',data);
api.getDataSource=(data)=>http('GET','/init.json/dataSource/getDataSource',data);
api.getDataSourceDir=(data)=>http('GET','/init.json/dataSource/getDataSourceDir',data);

api.getLogging=(data)=>http('POST','/user.json/log/getLogging',data);

export default api;
