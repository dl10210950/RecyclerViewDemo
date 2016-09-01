package com.duanlian.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by duanlian on 2016/8/31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> list;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    // 给MyHolder传递布局对象
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //引入布局
        View view = layoutInflater.inflate(R.layout.item_recyclerview, parent, false);
        //实例化自己创建的ViewHolder类
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    // 把数据，赋值给控件对象
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //给item的控件赋值
        holder.textView.setText(list.get(position));
    }

    // 计算有多少条数据
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_textview);
        }
    }

}
