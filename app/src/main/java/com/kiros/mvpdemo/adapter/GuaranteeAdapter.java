package com.kiros.mvpdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.EvaluateItem;
import com.kiros.mvpdemo.entity.GuaranteeItem;
import com.kiros.mvpdemo.ui.EvaluateActivity;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class GuaranteeAdapter extends RecyclerView.Adapter<GuaranteeAdapter.ViewHolder> {

    private Context context;
    private List<GuaranteeItem> data;

    public GuaranteeAdapter(Context context, List<GuaranteeItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.guarantee_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.guaranteeTime.setText(data.get(position).getGuaranteeTime());
        holder.guaranteeAddress.setText(data.get(position).getGuaranteeAddress());
        holder.guaranteeReason.setText(data.get(position).getGuaranteeReason());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView guaranteeTime;
        private TextView guaranteeAddress;
        private TextView guaranteeReason;

        public ViewHolder(View itemView) {
            super(itemView);
            guaranteeTime = itemView.findViewById(R.id.guaranteeTime);
            guaranteeAddress = itemView.findViewById(R.id.guaranteeAddress);
            guaranteeReason = itemView.findViewById(R.id.guaranteeReason);
        }
    }
}
