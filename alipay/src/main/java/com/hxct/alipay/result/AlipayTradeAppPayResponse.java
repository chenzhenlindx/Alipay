package com.hxct.alipay.result;

/**
 * @author czl QQ:285084661
 * @project_name SmartParty
 * @package_name com.hxct.alipay.result
 * @time 2018/4/28 10:15
 * @blog https://chenzhenlindx.github.io/
 */
public class AlipayTradeAppPayResponse {
    /**
     * code : 10000
     * msg : Success
     * app_id : 2014072300007148
     * out_trade_no : 081622560194853
     * trade_no : 2016081621001004400236957647
     * total_amount : 0.01
     * seller_id : 2088702849871851
     * charset : utf-8
     * timestamp : 2016-10-11 17:43:36
     */
    /**
     * 结果码
     */
    private String code;
    /**
     * 处理结果的描述，信息来自于code返回结果的描述
     */
    private String msg;
    /**
     * 支付宝分配给开发者的应用Id。
     */
    private String app_id;
    /**
     * 商户网站唯一订单号
     */
    private String out_trade_no;
    /**
     * 该交易在支付宝系统中的交易流水号。最长64位。
     */
    private String trade_no;
    /**
     * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01,100000000.00]，精确到小数点后两位。
     */
    private String total_amount;
    /**
     * 收款支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
     */
    private String seller_id;
    /**
     * 编码格式
     */
    private String charset;
    /**
     * 时间
     */
    private String timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
