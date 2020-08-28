package com.kiros.mvpdemo.adapter.staff;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.staff.WillMaintenanItem;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class WillMaintenanceAdapter extends RecyclerView.Adapter<WillMaintenanceAdapter.ViewHolder> {

    private Context context;
    private List<WillMaintenanItem> data;

    public WillMaintenanceAdapter(Context context, List<WillMaintenanItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.will_maintenance_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.time.setText(data.get(position).getTime());
        holder.address.setText(data.get(position).getAddress());
        holder.summary.setText(data.get(position).getSummary());
        holder.scheduling.setText(data.get(position).getScheduling());
        holder.remarks.setText(data.get(position).getRemarks());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView time;
        private TextView address;
        private TextView summary;
        private TextView scheduling;
        private TextView remarks;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            address = itemView.findViewById(R.id.address);
            summary = itemView.findViewById(R.id.summary);
            scheduling = itemView.findViewById(R.id.scheduling);
            remarks = itemView.findViewById(R.id.remarks);
        }
    }
}
