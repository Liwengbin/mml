import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/home/Home'
//import Index from '@/views/index/Index'
//import Datasource from '@/views/datasource/Datasource'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '/Home',
      component: Home
    }
  ]
})
