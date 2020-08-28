package com.kiros.mvpdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.entity.EvaluateItem;
import com.kiros.mvpdemo.ui.EvaluateActivity;
import com.kiros.mvpdemo.ui.FeedbackActivity;


import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {

    private Context context;
    private List<EvaluateItem> data;

    public EvaluateAdapter(Context context, List<EvaluateItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.evaluate_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.feedbackTime.setText(data.get(position).getFeedbackTime());
        holder.evaluateName.setText(data.get(position).getEvaluateName());
        holder.evaluateTime.setText(data.get(position).getEvaluateTime());
        holder.evaluateAddress.setText(data.get(position).getEvaluateAddress());
        holder.evaluateReason.setText(data.get(position).getEvaluateReason());
        holder.feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context, EvaluateActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView feedbackTime;
        private TextView evaluateName;
        private TextView evaluateTime;
        private TextView evaluateAddress;
        private TextView evaluateReason;
        private TextView feedback;

        public ViewHolder(View itemView) {
            super(itemView);
            feedbackTime = itemView.findViewById(R.id.feedbackTime);
            evaluateName = itemView.findViewById(R.id.evaluateName);
            evaluateTime = itemView.findViewById(R.id.evaluateTime);
            evaluateAddress = itemView.findViewById(R.id.evaluateAddress);
            evaluateReason = itemView.findViewById(R.id.evaluateReason);
            feedback = itemView.findViewById(R.id.feedback);
        }
    }
}
