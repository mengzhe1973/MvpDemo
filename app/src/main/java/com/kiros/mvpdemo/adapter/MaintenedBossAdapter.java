package com.kiros.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.MaintenanBossItem;
import com.kiros.mvpdemo.entity.staff.MaintenanItem;

import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class MaintenedBossAdapter extends RecyclerView.Adapter<MaintenedBossAdapter.ViewHolder> {

    private Context context;
    private List<MaintenanBossItem> data;
    private int tag;

    public MaintenedBossAdapter(Context context, List<MaintenanBossItem> data, int tag) {
        this.context = context;
        this.data = data;
        this.tag = tag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.boss_maintenance_record, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.time.setText(data.get(position).getTime());
        holder.reason.setText(data.get(position).getReason());
        holder.address.setText(data.get(position).getAddress());
        if (tag == 0) {
            holder.l_situation.setVisibility(View.GONE);
        } else {
            holder.l_situation.setVisibility(View.VISIBLE);
            holder.situation.setText(data.get(position).getSituation());
        }
        holder.maintenancer.setText(data.get(position).getMaintenancer());
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
        private TextView maintenancer;
        private LinearLayout l_situation;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            reason = itemView.findViewById(R.id.reason);
            address = itemView.findViewById(R.id.address);
            situation = itemView.findViewById(R.id.situation);
            maintenancer = itemView.findViewById(R.id.maintenancer);
            l_situation = itemView.findViewById(R.id.l_situation);
        }
    }
}
