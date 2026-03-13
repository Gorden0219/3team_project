module.exports = {
    lintOnSave: false,
    publicPath: process.env.NODE_ENV === 'development' ? './' : '././',
    outputDir: 'dist'
    , devServer: {
        host: "0.0.0.0", //指定使用一个 host。默认是 localhost，这里默认值即可
        port: 8082, //指定端口
    }
}