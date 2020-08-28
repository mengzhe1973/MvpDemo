package com.kiros.mvpdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.CuringItem;
import com.kiros.mvpdemo.entity.GuaranteeItem;
import com.kiros.mvpdemo.ui.CurDetailActivity;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class CuringAdapter extends RecyclerView.Adapter<CuringAdapter.ViewHolder> {

    private Context context;
    private List<CuringItem> data;

    public CuringAdapter(Context context, List<CuringItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.curing_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.EqName.setText(data.get(position).getEqName());
        holder.EqNum.setText(data.get(position).getEqNum());
        holder.EqUsage.setText(data.get(position).getEqUsage());
        holder.curingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CurDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView EqName;
        private TextView EqNum;
        private TextView EqUsage;
        private LinearLayout curingItem;

        public ViewHolder(View itemView) {
            super(itemView);
            EqName = itemView.findViewById(R.id.EqName);
            EqNum = itemView.findViewById(R.id.EqNum);
            EqUsage = itemView.findViewById(R.id.EqUsage);
            curingItem = itemView.findViewById(R.id.curingItem);
        }
    }
}
