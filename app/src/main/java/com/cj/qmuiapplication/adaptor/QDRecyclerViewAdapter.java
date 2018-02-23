package com.cj.qmuiapplication.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.cj.qmuiapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：Demo 中通用的 RecyclerView Adapter。
 */

public class QDRecyclerViewAdapter extends RecyclerView.Adapter<QDRecyclerViewAdapter.ViewHolder> {

    private List<Data> mItems;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public QDRecyclerViewAdapter() {
        mItems = new ArrayList<>();
    }

    public static List<Data> generateDatas(int count) {
        ArrayList<Data> mDatas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            mDatas.add(new Data(String.valueOf(i)));
        }
        return mDatas;
    }

    public void addItem(int position) {
        if (position > mItems.size()) return;

        mItems.add(position, new Data(String.valueOf(position)));
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        if (position >= mItems.size()) return;

        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View root = inflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        return new ViewHolder(root, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Data data = mItems.get(i);
        viewHolder.setText(data.text);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItemCount(int count) {
        mItems.clear();
        mItems.addAll(generateDatas(count));

        notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(RecyclerView.ViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    public static class Data {
        public String text;

        public Data(String text) {
            this.text = text;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private QDRecyclerViewAdapter mAdapter;

        public ViewHolder(View itemView, QDRecyclerViewAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);

            mAdapter = adapter;

            mTextView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void setText(String text) {
            mTextView.setText(text);
        }


        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }
    }
}