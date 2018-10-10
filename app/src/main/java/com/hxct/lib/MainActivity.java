package com.hxct.lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hxct.alipay.AlipayHelper;
import com.hxct.alipay.PayResult;
import com.hxct.alipay.result.Result;

import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.cl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderInfo = "";
                orderInfo="alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2015122201022437&biz_content=%7B%22body%22%3A%22%E5%8C%85%E6%9C%88%E8%B4%AD%E5%BD%A9%22%2C%22out_trade_no%22%3A%22201804281500410001%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%BD%A9%E7%A5%A8%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fapi.whyirengo.com%2Fpay%2Falipay%2Ffinish&sign=z%2Bp9%2Byu1fdQBMaPqCbgZVzLCp%2FIF90txzKuCD6Ib9w%2BSmB24zd%2BRrS2ZiOUF%2FlakhZVuDQXRjFa4%2Bg9xVVoivxxSzWW%2FpD4Ac%2B803%2FPKD6tqKZuAHZ5Uo2cH5exBMEgFas9GkpWD3l6IqEFZa52zyuxMOGYD3e2e6Ml2QEekCLtdN8KT4rIZ0GocfK%2B2bw7jJq1SLtU%2FpxkSkydfw%2BzDy%2BONuT1joNd6GqYa5%2FlL3BAVWUo6EoaDSXRHqp%2B1ufpmDQjMWT7%2FUWrHvOnt%2BDvGQcpZGPxGk2WyA%2FaSsjLZztJcLg3XD67c%2FJhRPEhwzcYS3vlJLxow9DZEAhqmmgkpnw%3D%3D&sign_type=RSA2&timestamp=2018-04-28+15%3A00%3A41&version=1.0";
                //这里需要获取后端的orderInfo信息
                AlipayHelper.payV2(MainActivity.this, orderInfo).subscribe(new Consumer<PayResult>() {
                    public void accept(PayResult payResult) {
                        if (AlipayHelper.isSuccess(payResult)) {
                            Result var2 = AlipayHelper.getResult(payResult);
                        } else {
                            String var3 = payResult.getMemo();
                            Toast.makeText(MainActivity.this, var3, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
