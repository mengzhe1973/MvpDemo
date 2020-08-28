package com.kiros.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kiros.mvpdemo.fragment.MaintenanceFragment;
import com.kiros.mvpdemo.fragment.MaintenedFragment;

/**
 * 作者：${NanFeiLong}
 * 日期 2016/12/9 17:36
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            // 已维保
            case 0:
                fragment = new MaintenedFragment();
                break;
            // 待维保
            case 1:
                fragment = new MaintenanceFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
