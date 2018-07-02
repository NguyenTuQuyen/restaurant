package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapterMain extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    public PagerAdapterMain(FragmentManager fm) {
        super(fm);
        list= new ArrayList<>();
        list.add(new BrowseMain());
        list.add(new SearchMain());
        list.add(new MapMain());
        list.add(new NotificationMain());
        list.add(new BookmarkMain());



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


        }
        return "";
    }
}
