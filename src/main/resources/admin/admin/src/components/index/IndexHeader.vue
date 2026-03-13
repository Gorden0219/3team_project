<template>
  <div class="navbar">
    <div :style='{"display":"block"}' class="title">
      <el-image v-if="false"
                :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}'
                class="title-img"
                fit="cover" src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"/>
      <span :style='{"padding":"0 0 0 12px","lineHeight":"44px","color":"#404B5F","float":"left","fontWeight":"bold"}'
            class="title-name">{{ this.$project.projectName }}</span>
    </div>
    <div :style='{"position":"absolute","right":"20px","top":"8px","display":"flex"}' class="right">
      <div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#404B5F"}' class="nickname">
        {{ this.$storage.get('role') }} {{ this.$storage.get('adminName') }}
      </div>
      <div v-if="this.$storage.get('role')!='管理员'"
           :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#404B5F"}' class="logout"
           @click="onIndexTap">退出到前台
      </div>
      <div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#404B5F"}' class="logout"
           @click="onLogout">退出登录
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      ruleForm: {},
      user: {},
    };
  },
  created() {

  },
  mounted() {
    let sessionTable = this.$storage.get("sessionTable")
    this.$http({
      url: sessionTable + '/session',
      method: "get"
    }).then(({
               data
             }) => {
      if (data && data.code === 0) {
        this.user = data.data;
        this.$storage.set('userid', data.data.id);
      } else {
        let message = this.$message
        message.error(data.msg);
      }
    });
  },
  methods: {
    onLogout() {
      let storage = this.$storage
      let router = this.$router
      storage.clear()
      router.replace({
        name: "login"
      });
    },
    onIndexTap() {
      window.location.href = `${this.$base.indexUrl}`
    },
  }
};
</script>


<style lang="scss" scoped>
.navbar {

}
</style>
