package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.adapter.ProductAdapter;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;
import com.zendaimoney.laocaibao.constant.MethodCode;
import com.zendaimoney.laocaibao.constant.ParamsKey;
import com.zendaimoney.laocaibao.http.CommonCallBack;
import com.zendaimoney.laocaibao.model.ProductInfoItem;
import com.zendaimoney.laocaibao.model.ProductsInfo;
import com.zendaimoney.laocaibao.pullrefresh2.XRecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/7/24.
 * description:
 */

public class ProductTabTwoFragment extends LazyLoadFragment implements CommonCallBack, XRecyclerView.LoadingListener {


    @BindView(R.id.x_recycler_view)
    XRecyclerView xRecyclerView;

    private ProductAdapter mAdapter;
    private List<ProductInfoItem> mData = new ArrayList<>();
    private int mPageNo = 1;
    private static final int PAGE_SIZE = 10;
    private int n = 0;


    public static ProductTabTwoFragment newInstance() {
        return new ProductTabTwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_tab_two, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        xRecyclerView.setLoadingListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ProductAdapter(getActivity(), mData);
        xRecyclerView.setAdapter(mAdapter);
        sendRequest();
    }

    @Override
    protected void lazyLoad() {

    }


    private void sendRequest() {
        xRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                sendRequest(ProductsInfo.class, getParamsToJson(false), MethodCode.PRODUCTS_LIST,
                        ProductTabTwoFragment.this);
            }
        });
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
    public void onRefresh() {
        sendRequest();
    }

    @Override
    public void onLoadMore() {
        sendRequest();
        n++;
    }

    @Override
    public void onFail() {

    }

    @Override
    public void onResponse(Object object) {
        ProductsInfo info = (ProductsInfo) object;
        ProductsInfo.Infos item = info.getInfos();
        mData = item.getResults();
        mAdapter.setList(mData);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                xRecyclerView.refreshComplete();
                xRecyclerView.loadMoreComplete();
                mAdapter.notifyDataSetChanged();
                if (n == 3) {
                    xRecyclerView.setNoMore(true);
                }
            }
        });
    }
}
