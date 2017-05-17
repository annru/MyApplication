package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HealthInfoDataItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2016/11/21.
 * 健康资讯 数据适配器
 */

public class HealthKnowledgeInfoListAdapter extends RecyclerView.Adapter<HealthKnowledgeInfoListAdapter.MyViewHolder> {
    private List<HealthInfoDataItem> mData;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public HealthKnowledgeInfoListAdapter(Context context, List<HealthInfoDataItem> list) {
        this.mData = list;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_health_knowledge_info_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titleTv.setText(mData.get(position).getTitle());
        holder.timeTv.setText(convertTime(mData.get(position).getTime()));
        loadImage(mContext, mData.get(position).getImg(), holder.infoImg);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.title_tv)
        TextView titleTv;

        @Bind(R.id.time_tv)
        TextView timeTv;

        @Bind(R.id.info_list_img)
        ImageView infoImg;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    private void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(imageView);
    }

    private String convertTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return sdf.format(date);
    }

}
