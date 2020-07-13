package com.dream.NiuFaNet.Base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/27 0027.
 */
public class BasePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    public BasePagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        if (fragmentList!=null){
            fragments.clear();
            fragments.addAll(fragmentList);        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
