<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100%","background":"url(http://codegen.caihongy.cn/20221109/ea2d226d42fe495daff146c9b99f4f24.jpg) center top  no-repeat","height":"100vh"}'>
		<view :style='{"width":"100%","padding":"24rpx","margin":"20rpx 0 0","display":"block","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 0 24rpx 0","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20221109/2a0f9dea035f46d391e96a71bab314a2.jpg" mode="aspectFill"></image>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.zhiyuanzhezhanghao"  type="text"  class="uni-input" name="" placeholder="志愿者账号" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.zhiyuanzhexingming"  type="text"  class="uni-input" name="" placeholder="志愿者姓名" />
			</view>
            <view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" @tap="zhiyuanzhetouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"width":"70%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'"  @change="zhiyuanzhexingbieChange" :value="zhiyuanzhexingbieIndex" :range="zhiyuanzhexingbieOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#999"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shoujihaoma"  type="text"  class="uni-input" name="" placeholder="手机号码" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shenfenzhenghao"  type="text"  class="uni-input" name="" placeholder="身份证号" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shequzhanghao"  type="text"  class="uni-input" name="" placeholder="社区账号" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" @tap="shequtupianTap" class="">
                <view>请上传图片</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="ruleForm.tupian" class="avator" :src="baseUrl+ruleForm.tupian" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shequmingcheng"  type="text"  class="uni-input" name="" placeholder="社区名称" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.fuzeren"  type="text"  class="uni-input" name="" placeholder="负责人" />
			</view>
			<picker :style='{"width":"70%","margin":"0 0 24rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'"  @change="shequxingbieChange" :value="shequxingbieIndex" :range="shequxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#999"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shoujihaoma"  type="text"  class="uni-input" name="" placeholder="手机号码" />
			</view>
			<view :style='{"width":"70%","margin":"0 0 8rpx 0","borderColor":"#dcdae5","borderStyle":"solid","borderWidth":"0 0 2rpx 0","height":"auto"}' v-if="tableName=='shequ'" class="uni-form-item uni-column">
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","background":"none","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shenfenzhenghao"  type="text"  class="uni-input" name="" placeholder="身份证号" />
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"24rpx 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221108/9576aabc35484eca94c43b91cc41cced.png) no-repeat","width":"478rpx","lineHeight":"88rpx","fontSize":"32rpx","backgroundSize":"100% 100%","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                zhiyuanzhexingbieOptions: [],
                zhiyuanzhexingbieIndex: 0,
                shequxingbieOptions: [],
                shequxingbieIndex: 0,
				ruleForm: {
                zhiyuanzhezhanghao: '',
                mima: '',
                zhiyuanzhexingming: '',
                touxiang: '',
                xingbie: '',
                nianling: '',
                shoujihaoma: '',
                shenfenzhenghao: '',
                shequzhanghao: '',
                mima: '',
                tupian: '',
                shequmingcheng: '',
                fuzeren: '',
                xingbie: '',
                shoujihaoma: '',
                shenfenzhenghao: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            }
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='zhiyuanzhe'){
                this.zhiyuanzhexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.zhiyuanzhexingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='shequ'){
                this.shequxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.shequxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            zhiyuanzhetouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            zhiyuanzhexingbieChange(e) {
                    this.zhiyuanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.zhiyuanzhexingbieOptions[this.zhiyuanzhexingbieIndex]
            },
            shequtupianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.tupian = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            shequxingbieChange(e) {
                    this.shequxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.shequxingbieOptions[this.shequxingbieIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.zhiyuanzhezhanghao) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`志愿者账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`zhiyuanzhe` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.zhiyuanzhexingming) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`志愿者姓名不能为空`);
					return
				}
				if(`zhiyuanzhe` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
					return
				}
				if(`zhiyuanzhe` == this.tableName && this.ruleForm.shenfenzhenghao&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzhenghao))){
					this.$utils.msg(`身份证号应输入身份证格式`);
					return
				}
				if((!this.ruleForm.shequzhanghao) && `shequ` == this.tableName){
					this.$utils.msg(`社区账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `shequ` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`shequ` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.shequmingcheng) && `shequ` == this.tableName){
					this.$utils.msg(`社区名称不能为空`);
					return
				}
				if(`shequ` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
					return
				}
				if(`shequ` == this.tableName && this.ruleForm.shenfenzhenghao&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzhenghao))){
					this.$utils.msg(`身份证号应输入身份证格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
