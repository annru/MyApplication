package com.zendaimoney.laocaibao.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.orhanobut.logger.Logger;
import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;
import com.zendaimoney.laocaibao.constant.MethodCode;
import com.zendaimoney.laocaibao.constant.ParamsKey;
import com.zendaimoney.laocaibao.http.CommonCallBack;
import com.zendaimoney.laocaibao.model.ProductInfoItem;
import com.zendaimoney.laocaibao.model.ProductsInfo;
import com.zendaimoney.laocaibao.utils.NumberUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/7/24.
 * description:
 */

public class ProductTabOneFragment extends LazyLoadFragment implements CommonCallBack, OnRefreshListener,
        OnLoadMoreListener {


    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;

    private List<ProductInfoItem> mData;
    private int mPageNo = 1;
    private static final int PAGE_SIZE = 10;

    public static ProductTabOneFragment newInstance() {
        return new ProductTabOneFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_tab_one, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setVerticalScrollBarEnabled(true);
//        recyclerView.setAdapter(new MyRecyclerViewAdapter());
        sendRequest();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    private void sendRequest() {
        sendRequest(ProductsInfo.class, getParamsToJson(false), MethodCode.PRODUCTS_LIST, this);
    }

    private JSONObject getParamsToJson(boolean isRefresh) {
        JSONObject json = new JSONObject();
        try {
            json.put("id", "");
            json.put(ParamsKey.PAGE_NO, isRefresh ? 1 : mPageNo);
            json.put(ParamsKey.PAGE_SIZE, PAGE_SIZE);
//            json.put(ParamsKey.CUSTOMER_ID, LcbUtil.getCustomerId(mContext));
            json.put(ParamsKey.CUSTOMER_ID, "");
            json.put(ParamsKey.IS_LOAN, "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onFail() {

    }

    @Override
    public void onResponse(Object result) {
        ProductsInfo info = (ProductsInfo) result;
        ProductsInfo.Infos item = info.getInfos();
        List<ProductInfoItem> list = item.getResults();
        Logger.d(list.size());

    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_product_tab_one_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final ProductInfoItem item = mData.get(position);
            holder.productNameText.setText(item.getProductName());
            //年化收益率
            String rateStr = getActivity().getString(R.string.baifenhao, NumberUtil.getFormatRateMultiply(item
                    .getYearRateInit(), 1));
            Spannable sp = new SpannableString(rateStr);
            sp.setSpan(new AbsoluteSizeSpan(14, true), rateStr.length() - 1, rateStr.length(), Spannable
                    .SPAN_INCLUSIVE_EXCLUSIVE);
            holder.rateText.setText(sp);
            //理财期限
            String termStr = getActivity().getString(R.string.tian, item.getInvestPeriod());
            Spannable termSp = new SpannableString(termStr);
            termSp.setSpan(new AbsoluteSizeSpan(14, true), termStr.length() - 1, termStr.length(), Spannable
                    .SPAN_INCLUSIVE_EXCLUSIVE);
            holder.termText.setText(termSp);
            //起投金额
            String minInvestAmtStr = getActivity().getString(R.string.invest_lower, NumberUtil.getFormateMoney(item
                    .getInvestLower(), "#,###"));
            //剩余购买金额
            String remaindSaleAmtStr = getActivity().getString(R.string.remind_amount, NumberUtil.getFormateMoney(item
                    .getRemaindAmt(), "#,##0.00"));
            String result = minInvestAmtStr + " | " + remaindSaleAmtStr;
            SpannableString spannableString = new SpannableString(result);
            int startIndex = result.indexOf("元");
            int endIndex = result.lastIndexOf("元");
            int yuIndex = result.indexOf("余");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#656565")), 0, startIndex, Spanned
                    .SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#656565")), yuIndex + 1, endIndex, Spanned
                    .SPAN_INCLUSIVE_EXCLUSIVE);
            holder.investMinAmountTv.setText(spannableString);

            //推荐标识符
            if (item.getIsRecommend().equals("1")) {
                holder.recommendImg.setVisibility(View.VISIBLE);
            } else {
                holder.recommendImg.setVisibility(View.GONE);
            }

            //封闭期（理财计划产品列表显示封闭期）
            if (item.getSubjectType().equals("4")) {//表示为理财计划的产品
                holder.closedPeriodTv.setVisibility(View.VISIBLE);
            } else {
                holder.closedPeriodTv.setVisibility(View.GONE);
            }

            //产品加息
            String addInterest = item.getAddInterest();
            double addInterestValue = 0;
            try {
                addInterestValue = Double.valueOf(addInterest);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (addInterestValue == 0) {
                holder.addInterestText.setVisibility(View.GONE);
            } else {
                holder.addInterestText.setVisibility(View.VISIBLE);
                String interestText = "+" + NumberUtil.getFormatRateMultiply(addInterest, 1) + "%";
                holder.addInterestText.setText(interestText);
            }

            final String sellOut = item.getSellOut();

            //营销字段内容
            String marketStr = item.getMarketing();
            if (TextUtils.isEmpty(marketStr) || sellOut.equals("1") || sellOut.equals("3")) {//已售罄的产品，营销字段不显示
                holder.saleTipTv.setVisibility(View.GONE);
            } else {
                holder.saleTipTv.setVisibility(View.VISIBLE);
                holder.saleTipTv.setText(marketStr);
            }

            //产品属性标签显示
            int productTipStatus = item.getProductTipStatus();
            switch (productTipStatus) {
                case 5:
                    holder.productFlagTv.setVisibility(View.VISIBLE);
                    holder.productFlagTv.setText("预约专享");
                    break;
                case 2:
                    holder.productFlagTv.setVisibility(View.VISIBLE);
                    holder.productFlagTv.setText("新手专享");
                    break;
                case 3:
                    holder.productFlagTv.setVisibility(View.VISIBLE);
                    holder.productFlagTv.setText("微信专享");
                    break;
                case 1:
                    holder.productFlagTv.setVisibility(View.VISIBLE);
                    holder.productFlagTv.setText("限购一次");
                    break;
                case 0://普通产品
                    if (item.getHotSellFlag().equals("1")) {//热销标识
                        holder.productFlagTv.setVisibility(View.VISIBLE);
                        holder.productFlagTv.setText("热销");
                    } else {
                        holder.productFlagTv.setVisibility(View.GONE);
                    }
                    break;
                case 6:
                    holder.productFlagTv.setVisibility(View.VISIBLE);
                    holder.productFlagTv.setText("可转让");
                    break;
            }

            switch (sellOut) {
                case "0"://0:未售罄，正常
                    holder.startTimeLl.setVisibility(View.GONE);
                    holder.sellOutImg.setVisibility(View.GONE);
                    holder.productFlagTv.setBackgroundResource(R.drawable.shape_product_flag_bg);
                    holder.rateText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_ea3e4f));
                    holder.addInterestText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_ea3e4f));
                    holder.productNameText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_222222));
                    holder.termText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_222222));
                    break;
                case "1"://1:已售罄
                case "3"://3：已结售
                    holder.startTimeLl.setVisibility(View.GONE);
                    holder.sellOutImg.setVisibility(View.VISIBLE);
                    holder.rateText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_999999));
                    holder.addInterestText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_999999));
                    //已售罄产品标签背景设为灰色
                    holder.productFlagTv.setBackgroundResource(R.drawable.shape_product_flag_gray_bg);
                    holder.productNameText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_B6B6B6));
                    holder.rateText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_B6B6B6));
                    holder.addInterestText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_B6B6B6));
                    holder.termText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_B6B6B6));
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color
                                    .color_B6B6B6)), 0, result
                                    .length(),
                            Spanned
                                    .SPAN_INCLUSIVE_EXCLUSIVE);
                    holder.investMinAmountTv.setText(spannableString);
                    break;
                case "2"://未起售
                    if (productTipStatus != 5) {//如果不是预约专享产品，则显示预约时间
                        holder.startTimeLl.setVisibility(View.VISIBLE);
                    }
                    holder.saleStartTimeTv.setText(item.getSaleStartDate());
                    holder.sellOutImg.setVisibility(View.GONE);
                    holder.productFlagTv.setBackgroundResource(R.drawable.shape_product_flag_bg);
                    holder.rateText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_ea3e4f));
                    holder.addInterestText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_ea3e4f));
                    holder.productNameText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_222222));
                    holder.termText.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_222222));
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_name_tv)
        TextView productNameText; //产品名称

        @BindView(R.id.rate_tv)
        TextView rateText;// 年化收益率

        @BindView(R.id.term_tv)
        TextView termText;// 投资期限

        @BindView(R.id.product_flag_tv)
        TextView productFlagTv;// 产品标识符（比如新手产品，微信产品，热销产品等等）

        @BindView(R.id.add_interest_tv)
        TextView addInterestText; //加息

        @BindView(R.id.sale_tip_tv)
        TextView saleTipTv;//营销字段

        @BindView(R.id.product_recommend_img)
        ImageView recommendImg;//推荐标识符

        @BindView(R.id.sale_start_time_tv)
        TextView saleStartTimeTv;//开抢时间

        @BindView(R.id.start_time_ll)
        LinearLayout startTimeLl;//父容器

        @BindView(R.id.invest_min_amount_tv)
        TextView investMinAmountTv;//起投金额

        @BindView(R.id.sell_out_img)
        ImageView sellOutImg;//已售罄签章

        @BindView(R.id.closed_period_tv)
        TextView closedPeriodTv;//封闭期


        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
