package com.kevin.tech.myandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.tech.myandroid.R;
import com.kevin.tech.myandroid.bean.MyJoke;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    //    private Context context;
    private List<MyJoke> data;
    private LinearLayout mHeaderLayout;
    private LinearLayout mFooterLayout;

    public RecyclerViewAdapter(List<MyJoke> data) {
//        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_view, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView2.setText(Html.fromHtml(data.get(position).getContent()));
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setNewData(List<MyJoke> data) {
        this.data = (List) (data == null ? new ArrayList() : data);
//        if(this.mRequestLoadMoreListener != null) {
//            this.mNextLoadEnable = true;
//            this.mLoadMoreEnable = true;
//            this.mLoading = false;
//            this.mLoadMoreView.setLoadMoreStatus(1);
//        }

//        this.mLastPosition = -1;
        this.notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.data.remove(position);
//        this.notifyItemRangeRemoved(position, 1);
        this.notifyItemRemoved(position);
    }

    //    public void add(int position, String item) {
//        this.data.add(position, item);
//        this.notifyItemInserted(position);
//    }
    public int getHeaderLayoutCount() {
        return this.mHeaderLayout != null && this.mHeaderLayout.getChildCount() != 0 ? 1 : 0;
    }

    public int getFooterLayoutCount() {
        return this.mFooterLayout != null && this.mFooterLayout.getChildCount() != 0 ? 1 : 0;
    }

    private onItemClickListener itemClickListener;
    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(onItemClickListener listener) {
        itemClickListener = listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView2)
        TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
