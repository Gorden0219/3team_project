<template>
  <div class="addEdit-block" style="width: 100%;">
    <el-form
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        :style='{"border":"1px solid #FF8C51","padding":"30px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderRadius":"0","flexWrap":"wrap","background":"#fff","display":"flex"}'
        class="add-update-preview"
        label-width="100px"
    >
      <template>
        <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="标题"
                      prop="biaoti">
          <el-input v-model="ruleForm.biaoti" :readonly="ro.biaoti" clearable placeholder="标题"></el-input>
        </el-form-item>
        <el-form-item v-else :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="标题" prop="biaoti">
          <el-input v-model="ruleForm.biaoti" placeholder="标题" readonly></el-input>
        </el-form-item>
        <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="标签"
                      prop="biaoqian">
          <el-input v-model="ruleForm.biaoqian" :readonly="ro.biaoqian" clearable placeholder="标签"></el-input>
        </el-form-item>
        <el-form-item v-else :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="标签" prop="biaoqian">
          <el-input v-model="ruleForm.biaoqian" placeholder="标签" readonly></el-input>
        </el-form-item>
        <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' class="date" label="记录日期"
                      prop="jiluriqi">
          <el-date-picker
              v-model="ruleForm.jiluriqi"
              :readonly="ro.jiluriqi"
              format="yyyy 年 MM 月 dd 日"
              placeholder="记录日期"
              type="date"
              value-format="yyyy-MM-dd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item v-else-if="ruleForm.jiluriqi" :style='{"width":"50%","margin":"0 0 20px 0"}' class="input"
                      label="记录日期" prop="jiluriqi">
          <el-input v-model="ruleForm.jiluriqi" placeholder="记录日期" readonly></el-input>
        </el-form-item>
        <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="账号"
                      prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" :readonly="ro.zhanghao" clearable placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item v-else :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
        </el-form-item>
        <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="姓名"
                      prop="xingming">
          <el-input v-model="ruleForm.xingming" :readonly="ro.xingming" clearable placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item v-else :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
        </el-form-item>
      </template>
      <el-form-item v-if="type!='info'" :style='{"width":"50%","margin":"0 0 20px 0"}' label="笔记内容"
                    prop="bijineirong">
        <editor
            v-model="ruleForm.bijineirong"
            action="file/upload"
            class="editor"
            style="min-width: 200px; max-width: 600px;">
        </editor>
      </el-form-item>
      <el-form-item v-else-if="ruleForm.bijineirong" :style='{"width":"50%","margin":"0 0 20px 0"}' label="笔记内容"
                    prop="bijineirong">
        <span
            :style='{"fontSize":"14px","lineHeight":"40px","color":"#000","fontWeight":"500","display":"inline-block"}'
            v-html="ruleForm.bijineirong"></span>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
        <el-button
            v-if="type!='info'"
            :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0","background":"#FF8C51","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
            class="btn-success" type="primary" @click="onSubmit">提交
        </el-button>
        <el-button
            v-if="type!='info'"
            :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"0","background":"#FF8C51","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
            class="btn-close" @click="back()">取消
        </el-button>
        <el-button
            v-if="type=='info'"
            :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"0","background":"#FF8C51","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
            class="btn-close" @click="back()">返回
        </el-button>
      </el-form-item>
    </el-form>


  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import {checkIdCard, isEmail, isIntNumer, isMobile, isNumber, isPhone, isURL} from "@/utils/validate";

export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',


      ro: {
        biaoti: false,
        biaoqian: false,
        bijineirong: false,
        jiluriqi: false,
        zhanghao: false,
        xingming: false,
      },


      ruleForm: {
        biaoti: '',
        biaoqian: '',
        bijineirong: '',
        jiluriqi: '',
        zhanghao: '',
        xingming: '',
      },


      rules: {
        biaoti: [
          {required: true, message: '标题不能为空', trigger: 'blur'},
        ],
        biaoqian: [
          {required: true, message: '标签不能为空', trigger: 'blur'},
        ],
        bijineirong: [],
        jiluriqi: [],
        zhanghao: [],
        xingming: [],
      }
    };
  },
  props: ["parent"],
  computed: {},
  created() {
    this.ruleForm.jiluriqi = this.getCurDate()
  },
  methods: {

    // 下载
    download(file) {
      window.open(`${file}`)
    },
    // 初始化
    init(id, type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if (this.type == 'info' || this.type == 'else') {
        this.info(id);
      } else if (this.type == 'logistics') {
        this.logistics = false;
        this.info(id);
      } else if (this.type == 'cross') {
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj) {
          if (o == 'biaoti') {
            this.ruleForm.biaoti = obj[o];
            this.ro.biaoti = true;
            continue;
          }
          if (o == 'biaoqian') {
            this.ruleForm.biaoqian = obj[o];
            this.ro.biaoqian = true;
            continue;
          }
          if (o == 'bijineirong') {
            this.ruleForm.bijineirong = obj[o];
            this.ro.bijineirong = true;
            continue;
          }
          if (o == 'jiluriqi') {
            this.ruleForm.jiluriqi = obj[o];
            this.ro.jiluriqi = true;
            continue;
          }
          if (o == 'zhanghao') {
            this.ruleForm.zhanghao = obj[o];
            this.ro.zhanghao = true;
            continue;
          }
          if (o == 'xingming') {
            this.ruleForm.xingming = obj[o];
            this.ro.xingming = true;
            continue;
          }
        }


      }


      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {

          var json = data.data;
          if (json.zhanghao != '' && json.zhanghao && this.$storage.get("role") != "管理员") {
            this.ruleForm.zhanghao = json.zhanghao
            this.ro.zhanghao = true;
          }
          if (json.xingming != '' && json.xingming && this.$storage.get("role") != "管理员") {
            this.ruleForm.xingming = json.xingming
            this.ro.xingming = true;
          }
        } else {
          this.$message.error(data.msg);
        }
      });


    },
    // 多级联动参数

    info(id) {
      this.$http({
        url: `bijixinxi/info/${id}`,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          //解决前台上传图片后台不显示的问题
          let reg = new RegExp('../../../upload', 'g')//g代表全部
          this.ruleForm.bijineirong = this.ruleForm.bijineirong.replace(reg, '../../../springbootc71oi/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {


      var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
      var crossuserid;
      var crossrefid;
      var crossoptnum;
      if (this.type == 'cross') {
        var statusColumnName = this.$storage.get('statusColumnName');
        var statusColumnValue = this.$storage.get('statusColumnValue');
        if (statusColumnName != '') {
          var obj = this.$storage.getObj('crossObj');
          if (statusColumnName && !statusColumnName.startsWith("[")) {
            for (var o in obj) {
              if (o == statusColumnName) {
                obj[o] = statusColumnValue;
              }
            }
            var table = this.$storage.get('crossTable');
            this.$http({
              url: `${table}/update`,
              method: "post",
              data: obj
            }).then(({data}) => {
            });
          } else {
            crossuserid = this.$storage.get('userid');
            crossrefid = obj['id'];
            crossoptnum = this.$storage.get('statusColumnName');
            crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
          }
        }
      }
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          if (crossrefid && crossuserid) {
            this.ruleForm.crossuserid = crossuserid;
            this.ruleForm.crossrefid = crossrefid;
            let params = {
              page: 1,
              limit: 10,
              crossuserid: this.ruleForm.crossuserid,
              crossrefid: this.ruleForm.crossrefid,
            }
            this.$http({
              url: "bijixinxi/page",
              method: "get",
              params: params
            }).then(({
                       data
                     }) => {
              if (data && data.code === 0) {
                if (data.data.total >= crossoptnum) {
                  this.$message.error(this.$storage.get('tips'));
                  return false;
                } else {
                  this.$http({
                    url: `bijixinxi/${!this.ruleForm.id ? "save" : "update"}`,
                    method: "post",
                    data: this.ruleForm
                  }).then(({data}) => {
                    if (data && data.code === 0) {
                      this.$message({
                        message: "操作成功",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                          this.parent.showFlag = true;
                          this.parent.addOrUpdateFlag = false;
                          this.parent.bijixinxiCrossAddOrUpdateFlag = false;
                          this.parent.search();
                          this.parent.contentStyleChange();
                        }
                      });
                    } else {
                      this.$message.error(data.msg);
                    }
                  });

                }
              } else {
              }
            });
          } else {
            this.$http({
              url: `bijixinxi/${!this.ruleForm.id ? "save" : "update"}`,
              method: "post",
              data: this.ruleForm
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: "操作成功",
                  type: "success",
                  duration: 1500,
                  onClose: () => {
                    this.parent.showFlag = true;
                    this.parent.addOrUpdateFlag = false;
                    this.parent.bijixinxiCrossAddOrUpdateFlag = false;
                    this.parent.search();
                    this.parent.contentStyleChange();
                  }
                });
              } else {
                this.$message.error(data.msg);
              }
            });
          }
        }
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.bijixinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
.amap-wrapper {
  width: 100%;
  height: 500px;
}

.search-box {
  position: absolute;
}

.el-date-editor.el-input {
  width: auto;
}

.add-update-preview .el-form-item /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  font-weight: 500;
  width: 100px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.add-update-preview .el-form-item /deep/ .el-form-item__content {
  margin-left: 100px;
}

.add-update-preview .el-input /deep/ .el-input__inner {
  border: 2px solid #797979;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  outline: none;
  color: #000;
  width: 400px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview .el-select /deep/ .el-input__inner {
  border: 2px solid #797979;
  border-radius: 0;
  padding: 0 10px;
  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  outline: none;
  color: #000;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview .el-date-editor /deep/ .el-input__inner {
  border: 2px solid #797979;
  border-radius: 0;
  padding: 0 10px 0 30px;
  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  outline: none;
  color: #000;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview /deep/ .el-upload--picture-card {
  background: transparent;
  border: 0;
  border-radius: 0;
  width: auto;
  height: auto;
  line-height: initial;
  vertical-align: middle;
}

.add-update-preview /deep/ .upload .upload-img {
  border: 1px dashed #797979;
  cursor: pointer;
  border-radius: 6px;
  color: #797979;
  width: 90px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
  border: 1px dashed #797979;
  cursor: pointer;
  border-radius: 6px;
  color: #797979;
  width: 90px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview /deep/ .el-upload .el-icon-plus {
  border: 1px dashed #797979;
  cursor: pointer;
  border-radius: 6px;
  color: #797979;
  width: 90px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview .el-textarea /deep/ .el-textarea__inner {
  border: 2px solid #797979;
  border-radius: 0;
  padding: 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  outline: none;
  color: #000;
  width: 400px;
  font-size: 14px;
  height: 120px;
}
</style>
