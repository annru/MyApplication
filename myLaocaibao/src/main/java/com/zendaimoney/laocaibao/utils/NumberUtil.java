package com.zendaimoney.laocaibao.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;

public class NumberUtil {

    /**
     * 根据本金计算收益(保留小数点后2位，不四舍五入) 计算公式=本金*理财周期/365*（约定年化收益率）
     *
     * @param investAmt 投资金额
     * @param rate      年化收益率
     * @param term      投资期限
     */
    public static double calculateProfit(String investAmt, String rate,
                                         String term) {
        double defaultVal = 0.00;
        BigDecimal yearTermBd = new BigDecimal(365.0);
        BigDecimal percentBd = new BigDecimal(100);
        try {
            BigDecimal investAmtBd = new BigDecimal(investAmt);
            BigDecimal rateBd = new BigDecimal(rate);
            BigDecimal termBd = new BigDecimal(term);
            BigDecimal result = investAmtBd.multiply(termBd)
                    .divide(yearTermBd, 5, BigDecimal.ROUND_DOWN)
                    .multiply(rateBd)
                    .divide(percentBd, 5, BigDecimal.ROUND_DOWN);
            return result.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();// 小数点后2位截断
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultVal;
    }

    /**
     * 新的计算收益方式
     * 公式：投资金额/项目总金额*项目利息
     * version 2.5.0
     */
    public static String calculateProfitNew(String investAmt, String totalAmt, String interest) {
        if (totalAmt == null || interest == null)
            return "0";
        BigDecimal investAmtBd = new BigDecimal(investAmt);
        BigDecimal totalAmtBd = new BigDecimal(totalAmt);
        BigDecimal interestBd = new BigDecimal(interest);
        BigDecimal resultBd = investAmtBd.multiply(interestBd).divide(totalAmtBd, 2, BigDecimal.ROUND_DOWN);//截断保留2位小数
        return resultBd.toString();
    }


    /**
     * 毫秒换算成天时分秒
     */
    public static String formatDuring(long mss) {
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;
        return formatTime(days) + " 天 " + formatTime(hours) + " 时 "
                + formatTime(minutes) + " 分 " + formatTime(seconds) + " 秒 ";
    }

    private static String formatTime(long value) {
        if (value < 10)
            return "0" + value;
        else
            return String.valueOf(value);
    }

    /**
     * 货币格式转化 例如：格式：#,###.00 货币值 123456789.00 输出 123,456,789.00
     *
     * @param money  货币值
     * @param format 格式
     * @return 返回格式后的货币值
     */
    public static String getFormateMoney(String money, String format) {
        if (TextUtils.isEmpty(money)) {
            money = "0";
        }
        try {
            Format formate = new DecimalFormat(format);
            double tempDoubleValue = Double.parseDouble(money);
            String value = formate.format(tempDoubleValue);
            return value.replaceAll("'", ",");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 格式化利率(保留一位小数)
     */
    public static String getFormatRate(String rate) {
        try {
            BigDecimal rateBd = new BigDecimal(rate);
            return rateBd.setScale(1, BigDecimal.ROUND_DOWN).toString();// 小数点后1位截断
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }

    public static String getFormatRateMultiply(String rate, int r) {
        try {
            BigDecimal rateBd = new BigDecimal(rate);
            BigDecimal interestBd = new BigDecimal(100);
            BigDecimal resultBd = rateBd.multiply(interestBd);
            return resultBd.setScale(r, BigDecimal.ROUND_DOWN).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }

    public static String getTensFormat(String rate, boolean hasZero) {
        try {
            BigDecimal rateBd = new BigDecimal(rate);
            BigDecimal interestBd = new BigDecimal(10);
            BigDecimal resultBd = rateBd.multiply(interestBd);
            String result = resultBd.setScale(1, BigDecimal.ROUND_DOWN).toString();
            if (hasZero) {
                return result;
            } else {
                if (result.lastIndexOf("0") == result.length() - 1) {
                    return result.substring(0, result.indexOf("."));
                } else {
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }
}
