package com.kiros.mvpdemo.adapter.staff;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.staff.MaintenanItem;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class MaintenedAdapter extends RecyclerView.Adapter<MaintenedAdapter.ViewHolder> {

    private Context context;
    private List<MaintenanItem> data;

    public MaintenedAdapter(Context context, List<MaintenanItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.staff_maintenance_record, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.time.setText(data.get(position).getTime());
        holder.reason.setText(data.get(position).getReason());
        holder.address.setText(data.get(position).getAddress());
        holder.situation.setText(data.get(position).getSituation());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView time;
        private TextView reason;
        private TextView address;
        private TextView situation;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            reason = itemView.findViewById(R.id.reason);
            address = itemView.findViewById(R.id.address);
            situation = itemView.findViewById(R.id.situation);
        }
    }
}
