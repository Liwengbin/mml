export default(type = 'GET', url = 'http://localhost:8080', data = new FormData(), method = 'fetch') => {//export default async
  type = type.toUpperCase();
  url = "http://localhost:8080" + url;
  var headers = new Headers({
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  });

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

  if (window.fetch && method == 'fetch') {
    let requestConfig = {
      credentials: 'include',
      method: type,
      headers:headers,
      mode: "no-cors",
      cache: "default"
    }
    if (type == 'POST') {
      Object.defineProperty(requestConfig, 'body', {
        value: data
      })
    }
    return fetch(url, requestConfig);
  } else {
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
