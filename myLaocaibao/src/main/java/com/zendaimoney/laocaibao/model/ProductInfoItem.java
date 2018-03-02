package com.zendaimoney.laocaibao.model;

import com.zendaimoney.laocaibao.http.MsgResult;

import java.io.Serializable;

/**
 * 产品列表实体类
 *
 * @author 00224524 2015-06-24
 */
public class ProductInfoItem extends MsgResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String yearRate;// 利率
    private String yearRateInit;//初始利率
    private String interestStartDate;// 起息日
    private String interestEndDate;// 到期日
    private String remaindAmt;// 剩余金额
    private String investPeriod;// 理财期限
    private String totalInvestPerson;// 投资总人数
    private String totalInvestAmt;// 投资总金额
    private String id;// 产品id
    private String investLower;// 投资下线
    private String investUpper;// 投资上限
    private String saleStartDate;// 起售日
    private String saleEndDate;
    private String invitationCodeFlag; // 1为邀请码必填，0:邀请码非必填
    private String repayType; // 还款方式
    private String remaindTime;// 距离结束时间;
    private String remaindSaleStartTime;// 距离结束时间;
    private String sellOut;// 售罄标识 0:未售罄 1:已售罄
    private String upLowFlag;// 上下架标识1:上架0:下架
    private String hotSellFlag;// 热销标识1:热销0:未热销
    //    private String isNewHand;// 新手标标识1:新手0:非新手// 该字段在2.1版本中弃用，新增limitType字段  2016-03-21
    private String limitType;// 0:普通产品，1:限购产品，2:新手标，3：微信专享，9：其他
    private String nowProportion;// 已售比例
    private String productPrincipal;// 项目本金
    private String productFeature;// 项目特点
    private String interestRule;// 起息规则
    private String addInterest;//产品加息
    private String imgUrl;//产品图片URL
    private String agreementUrl;//产品协议URL
    private String productName;// 产品名称
    private String productDesc;// 产品介绍
    private String fundArrivalDesc;// 资金到账说明
    private String riskMeasures;// 风控措施
    private String productDetailUrl;// 产品详情url
    private int contractId;// 大于0表示是标的产品
    private String marketing;//营销字段内容
    private String contractTypeDict;//优选、智选标识 yes:智选，no:优选
    private String contractDesc;//优选、智选文案
    private String isRecommend;//0:否，1：是
    private String productInterest;//项目利息
    private String yearRateProportion;//加息后的利息（已乘以100）


    private String surplusInvestPeriod;//剩余投资期限(转让产品列表使用该字段)
    private String transferCharge;//转让服务费(转让产品列表使用该字段)
    private String isTransfer; //1表示转让产品
    private String reservatTime;//预约时间（预约产品)
    private String subjectType;//是否为理财计划产品，4表示理财计划产品
    private int productTipStatus;//

    public int getProductTipStatus() {
        return productTipStatus;
    }

    public void setProductTipStatus(int productTipStatus) {
        this.productTipStatus = productTipStatus;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getReservatTime() {
        return reservatTime;
    }

    public void setReservatTime(String reservatTime) {
        this.reservatTime = reservatTime;
    }

    // ）

    //V2.8.0新增(不用)
//    private String isAppoint = "0";//是否为预约产品，0是非预约产品，1是预约产品
//    private String isNewRule = "0";//是否为新产品规则，0表示老规则，1表示新规则
//    private String greenHand = "0";//是否为新手产品，0表示普通产品，1表示新手产品
//    private int limitNum = 0;//限购产品，限购次数
//    private String wechat = "0";//是否为微信专享产品，0表示非微信产品，1表示微信产品
    private String transferStatus = "0";//是否可转让，0表示不能转让，1表示可以转让
//    private String leftReservatTime;//距离预约时间

//    public String getLeftReservatTime() {
//        return leftReservatTime;
//    }
//
//    public void setLeftReservatTime(String leftReservatTime) {
//        this.leftReservatTime = leftReservatTime;
//    }

//    public String getWechat() {
//        return wechat;
//    }
//
//    public void setWechat(String wechat) {
//        this.wechat = wechat;
//    }
//
//    public int getLimitNum() {
//        return limitNum;
//    }
//
//    public void setLimitNum(int limitNum) {
//        this.limitNum = limitNum;
//    }
//
//    public String getGreenHand() {
//        return greenHand;
//    }
//
//    public void setGreenHand(String greenHand) {
//        this.greenHand = greenHand;
//    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

//    public String getIsNewRule() {
//        return isNewRule;
//    }
//
//    public void setIsNewRule(String isNewRule) {
//        this.isNewRule = isNewRule;
//    }
//
//    public String getIsAppoint() {
//        return isAppoint;
//    }
//
//    public void setIsAppoint(String isAppoint) {
//        this.isAppoint = isAppoint;
//    }

    public String getYearRateProportion() {
        return yearRateProportion;
    }

    public void setYearRateProportion(String yearRateProportion) {
        this.yearRateProportion = yearRateProportion;
    }

    public String getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(String isTransfer) {
        this.isTransfer = isTransfer;
    }

    public String getTransferCharge() {
        return transferCharge;
    }

    public void setTransferCharge(String transferCharge) {
        this.transferCharge = transferCharge;
    }

    public String getSurplusInvestPeriod() {
        return surplusInvestPeriod;
    }

    public void setSurplusInvestPeriod(String surplusInvestPeriod) {
        this.surplusInvestPeriod = surplusInvestPeriod;
    }

    public String getProductInterest() {
        return productInterest;
    }

    public void setProductInterest(String productInterest) {
        this.productInterest = productInterest;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getContractTypeDict() {
        return contractTypeDict;
    }

    public void setContractTypeDict(String contractTypeDict) {
        this.contractTypeDict = contractTypeDict;
    }

    public String getContractDesc() {
        return contractDesc;
    }

    public void setContractDesc(String contractDesc) {
        this.contractDesc = contractDesc;
    }

    public String getMarketing() {
        return marketing;
    }

    public void setMarketing(String marketing) {
        this.marketing = marketing;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getAgreementUrl() {
        return agreementUrl;
    }

    public void setAgreementUrl(String agreementUrl) {
        this.agreementUrl = agreementUrl;
    }

    public String getYearRateInit() {
        return yearRateInit;
    }

    public void setYearRateInit(String yearRateInit) {
        this.yearRateInit = yearRateInit;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddInterest() {
        return addInterest;
    }

    public void setAddInterest(String addInterest) {
        this.addInterest = addInterest;
    }

    public String getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(String saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public String getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(String saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public String getRemaindSaleStartTime() {
        return remaindSaleStartTime;
    }

    public void setRemaindSaleStartTime(String remaindSaleStartTime) {
        this.remaindSaleStartTime = remaindSaleStartTime;
    }

    public String getRiskMeasures() {
        return riskMeasures;
    }

    public void setRiskMeasures(String riskMeasures) {
        this.riskMeasures = riskMeasures;
    }

    public String getInvestUpper() {
        return investUpper;
    }

    public void setInvestUpper(String investUpper) {
        this.investUpper = investUpper;
    }

    public String getInterestEndDate() {
        return interestEndDate;
    }

    public void setInterestEndDate(String interestEndDate) {
        this.interestEndDate = interestEndDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getYearRate() {
        return yearRate;
    }

    public void setYearRate(String yearRate) {
        this.yearRate = yearRate;
    }

    public String getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(String interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public String getRemaindAmt() {
        return remaindAmt;
    }

    public void setRemaindAmt(String remaindAmt) {
        this.remaindAmt = remaindAmt;
    }

    public String getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(String investPeriod) {
        this.investPeriod = investPeriod;
    }

    public String getTotalInvestPerson() {
        return totalInvestPerson;
    }

    public void setTotalInvestPerson(String totalInvestPerson) {
        this.totalInvestPerson = totalInvestPerson;
    }

    public String getTotalInvestAmt() {
        return totalInvestAmt;
    }

    public void setTotalInvestAmt(String totalInvestAmt) {
        this.totalInvestAmt = totalInvestAmt;
    }

    public String getInvestLower() {
        return investLower;
    }

    public void setInvestLower(String investLower) {
        this.investLower = investLower;
    }

    public String getInvitationCodeFlag() {
        return invitationCodeFlag;
    }

    public void setInvitationCodeFlag(String invitationCodeFlag) {
        this.invitationCodeFlag = invitationCodeFlag;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getRemaindTime() {
        return remaindTime;
    }

    public void setRemaindTime(String remaindTime) {
        this.remaindTime = remaindTime;
    }

    public String getSellOut() {
        return sellOut;
    }

    public void setSellOut(String sellOut) {
        this.sellOut = sellOut;
    }

    public String getUpLowFlag() {
        return upLowFlag;
    }

    public void setUpLowFlag(String upLowFlag) {
        this.upLowFlag = upLowFlag;
    }

    public String getHotSellFlag() {
        return hotSellFlag;
    }

    public void setHotSellFlag(String hotSellFlag) {
        this.hotSellFlag = hotSellFlag;
    }


    public String getNowProportion() {
        return nowProportion;
    }

    public void setNowProportion(String nowProportion) {
        this.nowProportion = nowProportion;
    }

    public String getProductPrincipal() {
        return productPrincipal;
    }

    public void setProductPrincipal(String productPrincipal) {
        this.productPrincipal = productPrincipal;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getInterestRule() {
        return interestRule;
    }

    public void setInterestRule(String interestRule) {
        this.interestRule = interestRule;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getFundArrivalDesc() {
        return fundArrivalDesc;
    }

    public void setFundArrivalDesc(String fundArrivalDesc) {
        this.fundArrivalDesc = fundArrivalDesc;
    }

}
