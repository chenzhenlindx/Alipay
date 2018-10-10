package com.hxct.alipay;

import android.app.Activity;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.hxct.alipay.result.Result;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author czl QQ:285084661
 * @project_name SmartParty
 * @package_name com.hxct.alipay
 * @time 2018/4/28 9:25
 * @blog https://chenzhenlindx.github.io/
 */
public class AlipayHelper {
    public static Observable<PayResult> payV2(final Activity activity, final String orderInfo) {
        return payV2(activity, orderInfo, true);
    }

    /**
     * @param activity         请求支付的界面
     * @param orderInfo        订单信息 app支付请求参数字符串，主要包含商户的订单信息，key=value形式，以&连接。<br/>
     *                         app_id=2015052600090779 <br/>
     *                         biz_content={"timeout_express":"30m","seller_id":"","product_code":"QUICK_MSECURITY_PAY","total_amount":"0.02","subject":"1","body":"我是测试数据","out_trade_no":"314VYGIAGG7ZOYY"} <br/>
     *                         charset=utf-8 <br/>
     *                         method=alipay.trade.app.pay <br/>
     *                         sign_type=RSA2 <br/>
     *                         timestamp=2016-08-15 12:12:15 <br/>
     *                         version=1.0 <br/>
     *                         sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd3eRmKxJuthNUx4ERCXe552EV9PfwexqW+1wbKOdYtDIb4+7PL3Pc94RZL0zKaWcaY3tSL89/uAVUsQuFqEJdhIukuKygrXucvejOUgTCfoUdwTi7z+ZzQ=
     *                         <a href="https://docs.open.alipay.com/204/105465">App支付请求参数说明</a>
     * @param isShowPayLoading 用户在商户app内部点击付款，是否需要一个loading做为在钱包唤起之前的过渡，这个值设置为true，将会在调用pay接口的时候直接唤起一个loading，直到唤起H5支付页面或者唤起外部的钱包付款页面loading才消失。（建议将该值设置为true，优化点击付款到支付唤起支付页面的过渡过程。）
     * @return <a href="https://docs.open.alipay.com/204/105301">同步通知参数说明</a>
     */
    public static Observable<PayResult> payV2(final Activity activity, final String orderInfo, final boolean isShowPayLoading) {
        return Observable.create(new ObservableOnSubscribe<PayResult>() {
            @Override
            public void subscribe(ObservableEmitter<PayResult> e) {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, isShowPayLoading);
                PayResult resp = new PayResult(result);
                e.onNext(resp);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static boolean isSuccess(PayResult result) {
        return "9000".equals(result.getResultStatus());
    }

    public static Result getResult(PayResult payResult) {
        String resultStr = payResult.getResult();
        if (isSuccess(payResult)) {
            return new Gson().fromJson(resultStr, Result.class);
        }
        throw new IllegalArgumentException("支付未成功");
    }
}
