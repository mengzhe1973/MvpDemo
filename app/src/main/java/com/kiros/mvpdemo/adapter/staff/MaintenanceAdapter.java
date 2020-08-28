package com.kiros.mvpdemo.adapter.staff;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.staff.MaintenanceItem;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class MaintenanceAdapter extends RecyclerView.Adapter<MaintenanceAdapter.ViewHolder> {

    private Context context;
    private List<MaintenanceItem> data;

    public MaintenanceAdapter(Context context, List<MaintenanceItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.maintenance_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTime.setText(data.get(position).getItemTime());
        holder.EqName.setText(data.get(position).getEqName());
        holder.EqNum.setText(data.get(position).getEqNum());
        holder.EqAbnormal.setText(data.get(position).getEqAbnormal());
        holder.HappenTime.setText(data.get(position).getHappenTime());
        holder.EqAddress.setText(data.get(position).getEqAddress());
        holder.maintenanceTime.setText(data.get(position).getMaintenanceTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTime;
        private TextView EqName;
        private TextView EqNum;
        private TextView EqAbnormal;
        private TextView HappenTime;
        private TextView EqAddress;
        private TextView maintenanceTime;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTime = itemView.findViewById(R.id.itemTime);
            EqName = itemView.findViewById(R.id.EqName);
            EqNum = itemView.findViewById(R.id.EqNum);
            EqAbnormal = itemView.findViewById(R.id.EqAbnormal);
            HappenTime = itemView.findViewById(R.id.HappenTime);
            EqAddress = itemView.findViewById(R.id.EqAddress);
            maintenanceTime = itemView.findViewById(R.id.maintenanceTime);
        }
    }
}
