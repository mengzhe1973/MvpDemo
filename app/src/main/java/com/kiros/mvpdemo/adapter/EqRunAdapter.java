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
import com.kiros.mvpdemo.entity.EqRunItem;
import com.kiros.mvpdemo.ui.CurDetailActivity;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class EqRunAdapter extends RecyclerView.Adapter<EqRunAdapter.ViewHolder> {

    private Context context;
    private List<EqRunItem> data;

    public EqRunAdapter(Context context, List<EqRunItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.operation_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.EqName.setText(data.get(position).getEqName());
        holder.EqNum.setText(data.get(position).getEqNum());
        holder.EqUsage.setText(data.get(position).getEqUsage());

        holder.runTime.setText(data.get(position).getRunTime());
        holder.defender.setText(data.get(position).getDefender());
        holder.runSpeed.setText(data.get(position).getRunSpeed());
        holder.eqAddress.setText(data.get(position).getEqAddress());
        holder.eqTemperature.setText(data.get(position).getEqTemperature());
        holder.utilizationRate.setText(data.get(position).getUtilizationRate());
        holder.repairNum.setText(data.get(position).getRepairNum());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView EqName;
        private TextView EqNum;
        private TextView EqUsage;

        private TextView runTime;
        private TextView defender;
        private TextView runSpeed;
        private TextView eqAddress;
        private TextView eqTemperature;
        private TextView utilizationRate;
        private TextView repairNum;

        public ViewHolder(View itemView) {
            super(itemView);
            EqName = itemView.findViewById(R.id.EqName);
            EqNum = itemView.findViewById(R.id.EqNum);
            EqUsage = itemView.findViewById(R.id.EqUsage);
            runTime = itemView.findViewById(R.id.runTime);
            defender = itemView.findViewById(R.id.defender);
            runSpeed = itemView.findViewById(R.id.runSpeed);
            eqAddress = itemView.findViewById(R.id.eqAddress);
            eqTemperature = itemView.findViewById(R.id.eqTemperature);
            utilizationRate = itemView.findViewById(R.id.utilizationRate);
            repairNum = itemView.findViewById(R.id.repairNum);
        }
    }
}
