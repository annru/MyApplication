package com.zendaimoney.laocaibao.constant;

/**
 * Created by 00224524 on 2015/11/17.
 * 后台方法接口编号
 */
public class MethodCode {

    /**
     * 基础功能
     */
    //注册
    public static final String REGISTER = "400003";

    //登录
    public static final String LOGIN = "400002";

    //实名认证
    public static final String REAL_NAME_AUTHEN = "400006";

    //获取短信验证码
    public static final String SMS_VERIFY = "900011";

    //重置密码
    public static final String RESET_PASSWORD = "400005";

    //广告启动页
    public static final String LOADING_AD_PIC = "600013";

    //检测微信和捞财宝账户是否已经绑定
    public static final String IS_BINDING_WECHAT = "800014";

    //绑定微信
    public static final String BINDING_WECHAT = "400018";

    //获取短信验证码(新  2.1)
    public static final String SMS_VERIFY_400019 = "400019";

    //设置交易密码
    public static final String SET_TRADE_PASSWORD = "410001";

    //认证绑卡初始化信息
    public static final String CERTIFICATION_TO_CARD_INIT = "400070";

    //认证绑卡
    public static final String CERTIFICATION_TO_CARD = "400071";

    /**
     * 限时抢购
     */
    //公告通知
//    public static final String NOTICE_MESSAGE = "600012";

    //banner广告图片
    public static final String BANNER = "600004";

    //首页初始化（多接口合并）
    public static final String MAIN_INIT = "500014";


    /**
     * 产品列表
     */

    // 产品列表页面公告
    public static final String PRODUCTS_NOTICE = "800013";

    // 产品列表
    public static final String PRODUCTS_LIST = "500001";

    //转让产品列表
    public static final String TRANSFER_PRODUCTS_LIST = "500036";

    //月盈产品列表
    public static final String YUEYING_PRODUCTS_LIST = "500070";

    //下单校验
    public static final String ACTION_ID_SUBMIT_ORDER_VERIFY = "500040";

    //兑换预约券(上一期捞财币)
    public static final String ACTION_ID_EXCHANGE_APPOINTMENT_LAST = "800017";

    //兑换预约券(当前期捞财币)
    public static final String ACTION_ID_EXCHANGE_APPOINTMENT_CURR = "800006";

    //提交订单
    public static final String ACTION_ID_SUBMIT_ORDER = "500003";

    //获取支付状态信息
    public static final String GET_RECHARGE_STATUS = "500009";

    //获取支付信息
    public static final String GET_PAY_INFO = "520002";

    //获取支付信息
    public static final String ACTION_UNBIND_BANKCARD = "520008";

    //获取账户资产
    public static final String GET_ASSETS_INFO = "520003";

    //支付
    public static final String PAY_ORDER = "500005";

    //支持的银行列表
    public static final String SUPPORT_BANK_LIST = "530005";

    //获取支行列表
    public static final String GET_SUB_BANK_LIST = "530001";

    //获取支付渠道
//    public static final String PAY_PLATFORM = "530003";

    //TPP划扣获取验证码
    public static final String TPP_SMS_VERIFY_CODE = "530002";

    //TPP划扣
//    public static final String TPP_DEDUCT = "530004";

    //TPP充值
    public static final String TPP_RECHARGE = "520011";

    //1.11
    //余额支付
    public static final String BALANCE_PAYMENT = "520001";


    /**
     * 个人中心
     */
    //充值绑卡
    public static final String RECHARGE = "520007";


    //我的积分
    public static final String MY_POINTS = "700001";
    //签到
//    public static final String SIGN_IN = "400009";

    //我的红包
    //【已开启红包】
    public static final String OPEN_RED_ENVELOPE_LIST = "400013";
    //查询邀请用户消费信息接口【待开启红包】
    public static final String STAY_OPEN_RED_ENVELOPE_LIST = "400016";

    //资产明细
//    public static final String ASSET_DETAILS = "500011";

    //交易记录
//    public static final String TRANSACTION_RECORD = "500002";

    //取消订单
//    public static final String CANCEL_ORDER = "500004";

    //持有资产
    public static final String HOLD_ASSETS = "520004";
    //获取绑定银行卡
    public static final String GET_USER_BINGDING_CARD = "520006";
    //可用余额
    public static final String AVAILABLE_BALANCE = "520005";

    //提现
    public static final String ACTION_BANKCARD_WITHDRAW = "520009";

    //邀请好友得积分
    //邀请好友记录列表
//    public static final String INVITE_FRIENDS = "400015";

    //系统消息
    //是否有未读消息
//    public static final String NOT_READ_SYSTEM_MESSAGE_FLAG = "400012";
    //系统消息列表
    public static final String SYSTEM_MESSAGE = "600014"; //600002

    //系统消息详情
    public static final String SYSTEM_MESSAGE_DETAIL = "600015";

    //个人设置
    // 修改密码
    public static final String CHANGE_PASSWORD = "400004";

    //修改交易密码
    public static final String MOFIFY_TRADE_PASSWORD = "410002";

    //找回交易密码（忘记密码）
    public static final String FIND_TRADE_PASSWORD = "410003";

    //回款日历
//    public static final String REFUND_CALENDAR = "500022";


    //验证登录密码
    public static final String VALID_LOGIN_PASSWORD = "400020";


    //注销
    public static final String LOG_OFF = "400008";
    //获取账户余额
    public static final String ACTION_GET_ACCOUNT_AMOUNT = "800005";

    //回款计划列表
    public static final String ACTION_GET_PAY_BACK_PLANS = "500028";

    //获取加息券
    public static final String ACTION_GET_INTEREST_TICKETS = "800008";

    //获取预约券
    public static final String ACTION_GET_COUPON_TICKET = "800018";

    // 获取用户绑卡信息
    public static final String GET_USER_CARD_INFORMATION = "520015";

    //激活开户华瑞
    public static final String ACTIVITED_USER = "400060";
    //绑定银行卡
    public static final String TIED_BANNER_CARD = "520012";


    /**
     * 更多
     */
    //反馈意见【用户反馈】
    public static final String FEEDBACK = "600001";


    //版本更新
    public static final String VERSION_UPDATE = "000000";

    /**
     * 转让
     */
    //转让初始化
    public static final String TRANSFER_INITIALIZE = "500031";
    //查询转让利率
    public static final String QUERY_TRANSFER_RATE = "500032";
    //确认转让
    public static final String TRANSFER_CONFIRM = "500033";
    //取消转让
    public static final String TRANSFER_CANCEL = "500035";

    //获取收货地址列表
    public static final String SHIPPING_ADDRESS_LIST = "550001";

    //添加或者更新收货地址
    public static final String SAVE_SHIPPING_ADDRESS = "550002";

    //删除收货地址
    public static final String DELETE_SHIPPING_ADDRESS = "550003";

    //首页Tab自动签到
    public static final String SIGN_IN = "550007";

    //查询签到详情(签到日历)
    public static final String SIGN_IN_CALENDAR = "550008";

    //请求刮刮卡
    public static final String SCRATCH_CARD = "700005";

    //捞财宝3.3到期弹层提示活动初始化接口
    public static final String MYCENTER_ALERT_INIT = "905003";

    //更新用户分享时间等状态的接口
    public static final String SHARE_COMPLATE = "905004";

    //抓公仔游戏增加刮奖次数接口
    public static final String SHARE_INCREASE_GAME_TIMES = "906003";

    //理财计划产品列表
    public static final String PRODUCTS_LIST_FINANCIAL_PLAN = "500801";

    //理财计划提前退出初始化
    public static final String MONEY_PLAN_OUT_INIT = "500804";

    //理财计划提前退出
    public static final String MONEY_PLAN_OUT = "500805";

}
