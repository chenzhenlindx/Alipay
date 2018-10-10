# 支付宝集成组件
## 集成方法
1. 在工程目录下添加maven
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }       
        ...
    }
}
```
2. module下添加gradle依赖
```
implementation 'com.github.chenzhenlindx:Alipay:1.0.0'
//可选
implementation 'io.reactivex.rxjava2:rxjava:2.1.6'
//可选
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
```

## 使用方法
1. 向服务端请求生成订单信息orderInfo，格式参考[App支付请求参数说明](https://docs.open.alipay.com/204/105465/)
2. 在Activity调用AlipayHelper.payV2(final Activity activity, final String orderInfo)
```
String orderInfo = "";
//这里需要获取后端的orderInfo信息
AlipayHelper.payV2(MainActivity.this, orderInfo).subscribe(new Consumer<PayResult>() {
    public void accept(PayResult payResult) {
       if (AlipayHelper.isSuccess(payResult)) {
            Result var2 = AlipayHelper.getResult(payResult);
       } else {
           String var3 = payResult.getMemo();
          Toast.makeText(MainActivity.this,var3,Toast.LENGTH_SHORT).show();
       }
     }
});
```