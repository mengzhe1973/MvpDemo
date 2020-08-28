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
import com.kiros.mvpdemo.entity.InfringementItem;
import com.kiros.mvpdemo.ui.CurDetailActivity;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class InfringementAdapter extends RecyclerView.Adapter<InfringementAdapter.ViewHolder> {

    private Context context;
    private List<InfringementItem> data;

    public InfringementAdapter(Context context, List<InfringementItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.infringement_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.infringementTime.setText(data.get(position).getInfringementTime());
        holder.infringementTip.setText(data.get(position).getInfringementTip());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView infringementTime;
        private TextView infringementTip;

        public ViewHolder(View itemView) {
            super(itemView);
            infringementTime = itemView.findViewById(R.id.infringementTime);
            infringementTip = itemView.findViewById(R.id.infringementTip);
        }
    }
}
