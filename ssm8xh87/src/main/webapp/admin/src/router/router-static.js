import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discusszhiyuanzhehuodong from '@/views/modules/discusszhiyuanzhehuodong/list'
    import huodongfengcai from '@/views/modules/huodongfengcai/list'
    import storeup from '@/views/modules/storeup/list'
    import wenzhangzixun from '@/views/modules/wenzhangzixun/list'
    import zhiyuanzhehuodong from '@/views/modules/zhiyuanzhehuodong/list'
    import zhengshuxinxi from '@/views/modules/zhengshuxinxi/list'
    import huodongqiandao from '@/views/modules/huodongqiandao/list'
    import shequ from '@/views/modules/shequ/list'
    import huodongbaoming from '@/views/modules/huodongbaoming/list'
    import discusswenzhangzixun from '@/views/modules/discusswenzhangzixun/list'
    import config from '@/views/modules/config/list'
    import discusshuodongfengcai from '@/views/modules/discusshuodongfengcai/list'
    import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
    import huodongleixing from '@/views/modules/huodongleixing/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discusszhiyuanzhehuodong',
        name: '志愿者活动评论',
        component: discusszhiyuanzhehuodong
      }
      ,{
	path: '/huodongfengcai',
        name: '活动风采',
        component: huodongfengcai
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/wenzhangzixun',
        name: '文章资讯',
        component: wenzhangzixun
      }
      ,{
	path: '/zhiyuanzhehuodong',
        name: '志愿者活动',
        component: zhiyuanzhehuodong
      }
      ,{
	path: '/zhengshuxinxi',
        name: '证书信息',
        component: zhengshuxinxi
      }
      ,{
	path: '/huodongqiandao',
        name: '活动签到',
        component: huodongqiandao
      }
      ,{
	path: '/shequ',
        name: '社区',
        component: shequ
      }
      ,{
	path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
      ,{
	path: '/discusswenzhangzixun',
        name: '文章资讯评论',
        component: discusswenzhangzixun
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discusshuodongfengcai',
        name: '活动风采评论',
        component: discusshuodongfengcai
      }
      ,{
	path: '/zhiyuanzhe',
        name: '志愿者',
        component: zhiyuanzhe
      }
      ,{
	path: '/huodongleixing',
        name: '活动类型',
        component: huodongleixing
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
