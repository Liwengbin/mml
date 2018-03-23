export default(type = 'GET', url = '', data = {}, method = 'fetch') => {
  type = type.toUpperCase();
  url = "http://120.25.152.214:8080/mlService"+url;
  let mlHeaders = new Headers();
  mlHeaders.append('Accept','application/json');
  mlHeaders.append('Access-Control-Allow-Origin','http://120.25.152.214:8080/mlService');
  mlHeaders.append('Access-Control-Allow-Credentials','true');
  mlHeaders.append('Accept-Charset' ,'utf-8');
  mlHeaders.append('Content-Type', 'application/x-www-form-urlencoded');
  console.log('sadsdasd');
  if (type == 'GET') {
    let dataStr = ''; //数据拼接字符串
    for (var key of data.keys()) {
      dataStr += key + '=' + data.get(key) + '&';
    }
    if (dataStr !== '') {
      dataStr = dataStr.substr(0, dataStr.lastIndexOf('&'));
      url = url + '?' + dataStr;
    }
  }

  if(window.fetch && method == 'fetch'){
    let requestConfig = {
      method:type,
      Headers:{
        'Accept': 'application/json',
        'Access-Control-Allow-Origin':'http://localhost:8080',
        'Access-Control-Allow-Credentials': 'true',
        'Accept-Charset' : 'utf-8',
        'Content-Type': 'application/x-www-form-urlencoded'
    },
      mode:'cors',
      cache:'default',
      credentials:'include',
    }
    if(type =='POST'){
      Object.defineProperty(requestConfig, 'body', {
        value: data
      })
    }
    return fetch(url, requestConfig);
  }else{
    return new Promise((resolve, reject) => {
      let requestObj;
      if (window.XMLHttpRequest) {
        requestObj = new XMLHttpRequest();
      } else {
        requestObj = new ActiveXObject;
      }

      let sendData = '';
      if (type == 'POST') {
        sendData = data;
      }

      requestObj.open(type, url, true);
      requestObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      requestObj.send(sendData);

      requestObj.onreadystatechange = () => {
        if (requestObj.readyState == 4) {
          if (requestObj.status == 200) {
            let obj = requestObj.response
            if (typeof obj !== 'object') {
              obj = JSON.parse(obj);
            }
            resolve(obj)
          } else {
            reject(requestObj)
          }
        }
      }
    })
  }
}
