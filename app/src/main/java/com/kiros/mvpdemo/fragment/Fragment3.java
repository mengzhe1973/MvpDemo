package com.kiros.mvpdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiros.mvpdemo.MainActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.ui.UsernameLoginActivity;

/**
 * Created by kiros on 2019/8/21.
 */

public class Fragment3 extends Fragment {
    private View view;
    private TextView start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        initView();
    }

    private void initView() {
        start = view.findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getContext(), UsernameLoginActivity.class));
                getActivity().finish();
            }
        });
    }
}
