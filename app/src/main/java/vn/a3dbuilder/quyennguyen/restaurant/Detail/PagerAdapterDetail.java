package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapterDetail extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    public PagerAdapterDetail(FragmentManager fm) {
        super(fm);
        list= new ArrayList<>();
        list.add(new OverviewMain());
        list.add(new MenuMain());
        list.add(new ReviewMain());




    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    public CharSequence getPageTitle(int position) {
        switch (position) {

        case 0: return "Overview";
        case 1: return "Menu";
        case 2: return "Review";

        }
        return "";
    }
}
