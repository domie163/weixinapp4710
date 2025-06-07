<template>
	<div style="height: 100%;">
		<index-aside v-if="'vertical' == 'vertical'" :style='{"boxShadow":"0px 0 0px #ddd","padding":"110px 0 60px","overflow":"hidden","top":"0","left":"0","background":"linear-gradient(23deg, rgba(99,90,241,1) 0%, rgba(155,141,255,1) 50%, rgba(99,90,241,1) 100%)","bottom":"0","width":"220px","fontSize":"0px","position":"fixed","height":"100%","zIndex":"1001"}'></index-aside>
		<el-main :style='"vertical" == "vertical" ? {"minHeight":"100%","padding":"0","margin":"0 0 0 220px","position":"relative","background":"#f6f6f6","display":"block"} : {"minHeight":"100%","margin":"0","position":"relative"}'>
			<index-header :style='{"boxShadow":"inset 0px 20px 32px 0px #d5cffd","padding":"0 20px 0","borderColor":"#ddd","alignItems":"center","display":"flex","justifyContent":"center","top":"0","borderRadius":"0px","left":"0px","background":"#fff","borderWidth":"0 0 1px","width":"calc(100% - 0px)","position":"fixed","borderStyle":"solid","zIndex":"1002","height":"64px"}'></index-header>
			<index-aside v-if="'vertical' == 'horizontal'" :style='{"width":"100%","borderColor":"#efefef","borderStyle":"solid","background":"#304156","borderWidth":"0 0 1px 0","height":"auto"}'></index-aside>
			<bread-crumbs :title="title" :style='{"padding":"0px 30px","margin":"64px auto 0","borderColor":"#eee","borderRadius":"0","borderWidth":"0 0 1px 0","background":"linear-gradient(23deg, rgba(99,90,241,1) 0%, rgba(183,173,255,1) 50%, rgba(99,90,241,1) 100%)","width":"calc(100% - 60px)","borderStyle":"solid","height":"auto"}' class="bread-crumbs"></bread-crumbs>
			<router-view class="router-view"></router-view>
		</el-main>
	</div>
</template>

<script>
	import IndexAside from '@/components/index/IndexAsideStatic'
	import IndexHeader from '@/components/index/IndexHeader'
	import menu from "@/utils/menu";
	export default {
		components: {
			IndexAside,
			IndexHeader
		},
		data() {
			return {
				menuList: [],
				role: "",
				currentIndex: -2,
				itemMenu: [],
				title: ''
			};
		},
		mounted() {
			let menus = menu.list();
			this.menuList = menus;
			this.role = this.$storage.get("role");
		},
		created() {
			this.init();
			console.log(console.log(this.$route.path))
		},
		methods: {
			init(){
				this.$nextTick(()=>{
					
				})
			},
			menuHandler(menu) {
				this.$router.push({
					name: menu.tableName
				});
				this.title = menu.menu;
			},
			titleChange(index, menus) {
				this.currentIndex = index
				this.itemMenu = menus;
				console.log(menus);
			},
			homeChange(index) {
				this.itemMenu = [];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
			},
			centerChange(index) {
				this.itemMenu = [{
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "修改密码",
					"tableName": "updatePassword"
				}, {
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "个人信息",
					"tableName": "center"
				}];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
				
			}
		}
	};
</script>
<style lang="scss" scoped>
	a {
		text-decoration: none;
		color: #555;
	}

	a:hover {
		background: #00c292;
	}
	
	.el-main {
		padding: 0;
		display: block;
	}

	.nav-list {
		width: 100%;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;

		.nav-title {
			display: inline-block;
			font-size: 15px;
			color: #333;
			padding: 15px 25px;
			border: none;
		}

		.nav-title.active {
			color: #555;
			cursor: default;
			background-color: #fff;
		}
	}

	.nav-item {
		margin-top: 20px;
		background: #FFFFFF;
		padding: 15px 0;

		.menu {
			padding: 15px 25px;
		}
	}
	
	.detail-form-content {
	    background: transparent;
	}
</style>
