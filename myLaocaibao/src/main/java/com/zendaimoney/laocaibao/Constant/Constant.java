package com.zendaimoney.laocaibao.Constant;

import android.os.Environment;

/**
 * 常量类
 *
 * @author 00225075
 */
public class Constant {

    // 参数key
    public static final String PROPERTY_PROGECT_NO = "projectNo";// 项目编号
    public static final String PROPERTY_REQ_RUL = "reqUrl";// 请求url
    public static final String PROPERTY_REQ_PARAM = "reqParam";// 请求参数
    public static final String PROPERTY_REQ_HEAD_PARAM = "reqHeadParam";// 请求头参数
    public static final String PROPERTY_REQ_TIMESTAMP = "reqTimestamp";
    public static final String PROPERTY_SN = "sn";
    public static final String PROPERTY_SIGN = "sign";
    public static final String PROPERTY_SESSIONTOKEN = "sessionToken";
    public static final String PROPERTY_APP_VERSION = "version";
    public static final String PROPERTY_MECHANISM = "mechanism";//机构（证大）
    public static final String PROPERTY_PLATFORM = "platform";//平台（无线）
    public static final String PROPERTY_TOGATHERTYPE = "togatherType";//合作类型（证大无线）
    public static final String PROPERTY_OPENCHANNEL = "openchannel";//渠道id
    public static final String PROPERTY_UMENG_CHANNEL = "UMENG_CHANNEL";//友盟渠道
    public static final String PROPERTY_TOKEN = "token";
    public static final String PROPERTY_USERAGENT = "userAgent";

    public static final String PROGECT_NO = "Lc_WS2015";
    //******************红包标识******************//

    //未使用
    public static final String PAYCHECKS_STATUS_AVAIL = "AVAIL";
    //已使用
    public static final String PAYCHECKS_STATUS_CONSUMED = "CONSUMED";
    //已过期
    public static final String PAYCHECKS_STATUS_OVERDUE = "OVERDUE";

    //认证支付
    public static final String PROPERTY_VERSION = "version";// 收银台版本
    public static final String PROPERTY_MERCHANTCODE = "merchantCode";// 商户号
    public static final String PROPERTY_CHANNEL_ORDERNO = "channelOrderNo";// 业务订单号
    public static final String PROPERTY_ORDER_ID = "orderId";// 订单号
    public static final String PROPERTY_SERNUM = "sernum";// 请求流水号
    public static final String PROPERTY_PAY_AMT = "payAmt";// 支付金额
    public static final String PROPERTY_BANKCARDNO = "bankCardNo";// 银行卡号
    public static final String PROPERTY_BUSIID = "busiId";// 订单Id
    public static final String PROPERTY_PAYTIME = "payTime";// 支付时间
    public static final String PROPERTY_USER_NO = "userNo";// 客户编号
    public static final String PROPERTY_USERNAME = "userName";// 客户姓名
    public static final String PROPERTY_USERCARDID = "userCardId";// 客户身份证
    public static final String PROPERTY_ORDERDESC = "orderDesc";// 订单备注
    public static final String PROPERTY_CALLBACK_URL = "callbackUrl";// 结果通知URL
    public static final String PROPERTY_PRODUCT_TYPE = "productType";// 产品类型
    public static final String PROPERTY_CUSTOMER_ID = "customerId";// 客户ID
    public static final String PROPERTY_ORDER_AMT = "orderAmt";// 订单金额


    // 支行列表
    // public static final String PROPERTY_MERCHANTCODE = "merchantCode";
    public static final String PROPERTY_REQ_SERNUM = "reqSernum";
    public static final String PROPERTY_REQ_TIME = "reqTime";
    // public static final String PROPERTY_PRODUCT_TYPE = "productType";
    // public static final String PROPERTY_BANKCARDNO = "bankCardNo";
    public static final String PROPERTY_BANK_CODE = "bankCode";
    public static final String PROPERTY_BANK_CARD_NO = "bankCardNo";
    public static final String PROPERTY_BANK_NAME = "bankName";
    public static final String PROPERTY_CITY_CODE = "cityCode";
    public static final String PROPERTY_SUB_BANK_NAME = "subBankName";//支行名称
    public static final String PROPERTY_SUB_BANK_CODE = "subBankCode";//支行银行代码
    public static final String PROPERTY_BANK_CARDTYPE = "cardType";//卡类型


    public static final String PROPERTY_ACTIVITY_NAME = "activityName";


    /********************************
     * 保存的信息
     **********************************/

    // 保存的登录信息
    public static final String logged = "logged";
    // 保存的手势密码
    public static final String password = "password";
    // 手势密码状态
    public static final String gesturepassword = "gesturepassword";
    /********************************
     * onActivityResult
     **********************************/
    // 登录完成返回刷新
    public static final int Refresh = 1;
    // 传递的帐户
    public static final String Hidden_Mobile = "moblie";
    // 传递的密码
    public static final String Hidden_Password = "password";


    //保存版本号
    public static final String VERSION_CODE = "versionCode";

    public static final String See = "see";

    public static final String SHOWMONEY = "isShowMoneyOnMyCenter";

    /*****************************
     * 退出登录的标识
     **************************/

    // 退出登录
    public static final String EXIT = "exit";

    // */ 手势密码点的状态
    public static final int POINT_STATE_NORMAL = 0; // 正常状态

    public static final int POINT_STATE_SELECTED = 1; // 按下状态

    public static final int POINT_STATE_WRONG = 2; // 错误状态


    /******************************
     * 推送标识
     ************************************/
    public static final int NOTIFICATION_ID_LIVE = 1; // 正常状态
    public static final String NOTIFICATION_ACTION_SEND = "com.notifications.intent.action.Click";
    public static final String NOTIFICATION_NOTIFYID = "notifyId";
    public static final String NOTIFICATION_PUSH = "push";


    public static final String LAOMENTY_PATH = Environment.getExternalStorageDirectory()
            .getPath() + "/laomoney/";
    public static final String CRASH_PATH = "crash/";
    public static final String PIC_PATH = "pic/";
    public static final String AD_PATH = "ad/";


    //金额千分位格式化
    public static final String FORMAT_NO_DECIMAL = "#,###";  //不带小数点
    public static final String FORMAT_TWO_DECIMAL = "#,##0.00";//带2位小数点


    public static final int REQUEST_CODE_ACTIVITY = 10;  //首页  活动中心或者banner页面的跳转
    public static final int REQUEST_CODE_CENTER = 11;  //个人中心   任务中心或者捞财币商城的跳转
    public static final int REQUEST_CODE_CALL_ADDRESS_BOOK = 20;  //生活服务  调用手机通讯录

    /**
     * 首页TAB 广告图片弹窗ID保存KEY
     * 根据接口请求的ID与原先保存在sharedpreferences中的popup_id比较，不一致则显示弹窗
     */
    public static final String PREFERENCES_KEY_POPUP_ID = "POPUP_ID";

    /**
     * 从登录页面跳转到注册页面，注册成功后回调到登录页面登录
     */
    public static final int REQUEST_CODE_LOGIN_TO_REGISTER = 101;


    /**
     * 从登录页面跳转到忘记密码页面，忘记密码成功后后回调到登录页面登录
     */
    public static final int REQUEST_CODE_LOGIN_TO_FORGET_PWD = 102;


    /**
     * 上一个页面跳转名称传值key
     */
    public static final String INTENT_ACTIVITY_NAME = "ActivityName";

    /**
     * 保存上一次登录的账号
     */
    public static final String LAST_LOGIN_ACCOUNT = "lastLoginAccount";

    /**
     * 新手半透明引导层是否显示标识符
     */
    public static final String IS_SHOW_LAYER_CALENDAR = "isShowLayerCalendar";//平台日历


    /**
     * 微信包名
     */
    public static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";

    /**
     * requestCode
     */
    public static final int RESULT_CODE_SHOPPING_MALL_FRAGMENT = 100;//小象生活

}
