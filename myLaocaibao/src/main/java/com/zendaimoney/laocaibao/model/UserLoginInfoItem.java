package com.zendaimoney.laocaibao.model;

/**
 * 用户返回的信息
 *
 * @author 00225075
 */
public class UserLoginInfoItem {
    private String token;
    // 用户名字
    private String cmRealName;
    // 用户身份证号 有身份证代表已认证
    private String cmIdnum;
    // 状态
    private String cmStatus;
    // 手机号
    private String cmCellphone;
    // 用户编号
    private String cmAccount;
    // 用户ID
    private String cmCustomerId;
    // 是否是员工 0:否1:是
    private String cmEmployee;
    // 邀请码
    private String cmInviteCode;
    // 介绍人码
    private String cmIntroduceCode;
    // 会话令牌
    private String sessionToken;

    // 二维码
    private String qrCode;
    //积分
    private String integral;
    // 密钥
//    private String payPrivateKey;
    //是否开户 0：否1：是
//    private String isOpenAccount;
    //是否绑卡 0：否1：是
//    private String isTieCard;
    //产品H5Url
//    private String pdh5Url;
    //产品详情Url
//    private String pdUrl;
    private int isBindCard; //是否绑卡 0：否1：是


    private String cmNumToken;//活动用户信息

    private String shareRedUrl;//登录分享红包Url

    private int isSetPayPassword;//0表示未设置交易密码，1表示已经设置交易密码
    private int isAuth;//
    private Integer isOpen;//华瑞银行是否开户 0未开户  1已开户
    private Integer isDepositVersion;//3.2版本存管是否上线

    public int getIsBindCard() {
        return isBindCard;
    }

    public void setIsBindCard(int isBindCard) {
        this.isBindCard = isBindCard;
    }

    public Integer getIsDepositVersion() {
        return isDepositVersion;
    }

    public void setIsDepositVersion(Integer isDepositVersion) {
        this.isDepositVersion = isDepositVersion;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public int getIsSetPayPassword() {
        return isSetPayPassword;
    }

    public void setIsSetPayPassword(int isSetPayPassword) {
        this.isSetPayPassword = isSetPayPassword;
    }

    public String getShareRedUrl() {
        return shareRedUrl;
    }

    public void setShareRedUrl(String shareRedUrl) {
        this.shareRedUrl = shareRedUrl;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }


    public String getCmEmployee() {
        return cmEmployee;
    }

    public void setCmEmployee(String cmEmployee) {
        this.cmEmployee = cmEmployee;
    }

    public String getCmInviteCode() {
        return cmInviteCode;
    }

    public void setCmInviteCode(String cmInviteCode) {
        this.cmInviteCode = cmInviteCode;
    }

    public String getCmIntroduceCode() {
        return cmIntroduceCode;
    }

    public void setCmIntroduceCode(String cmIntroduceCode) {
        this.cmIntroduceCode = cmIntroduceCode;
    }

    public String getCmRealName() {
        return cmRealName;
    }

    public void setCmRealName(String cmRealName) {
        this.cmRealName = cmRealName;
    }

    public String getCmIdnum() {
        return cmIdnum;
    }

    public void setCmIdnum(String cmIdnum) {
        this.cmIdnum = cmIdnum;
    }

    public String getCmStatus() {
        return cmStatus;
    }

    public void setCmStatus(String cmStatus) {
        this.cmStatus = cmStatus;
    }

    public String getCmCellphone() {
        return cmCellphone;
    }

    public void setCmCellphone(String cmCellphone) {
        this.cmCellphone = cmCellphone;
    }

    public String getCmAccount() {
        return cmAccount;
    }

    public void setCmAccount(String cmAccount) {
        this.cmAccount = cmAccount;
    }

    public String getCmCustomerId() {
        return cmCustomerId;
    }

    public void setCmCustomerId(String cmCustomerId) {
        this.cmCustomerId = cmCustomerId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

//    public String getIsOpenAccount() {
//        return isOpenAccount;
//    }
//
//    public void setIsOpenAccount(String isOpenAccount) {
//        this.isOpenAccount = isOpenAccount;
//    }

//    public String getPdh5Url() {
//        return pdh5Url;
//    }
//
//    public void setPdh5Url(String pdh5Url) {
//        this.pdh5Url = pdh5Url;
//    }

//    public String getIsTieCard() {
//        return isTieCard;
//    }

//    public void setIsTieCard(String isTieCard) {
//        this.isTieCard = isTieCard;
//    }

//    public String getPdUrl() {
//        return pdUrl;
//    }
//
//    public void setPdUrl(String pdUrl) {
//        this.pdUrl = pdUrl;
//    }

    public String getCmNumToken() {
        return cmNumToken;
    }

    public void setCmNumToken(String cmNumToken) {
        this.cmNumToken = cmNumToken;
    }
}
