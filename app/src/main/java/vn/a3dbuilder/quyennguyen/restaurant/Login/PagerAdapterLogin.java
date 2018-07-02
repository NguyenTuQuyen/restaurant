package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


/**
 * Created by HV on 6/13/2018.
 */

public class PagerAdapterLogin extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    public PagerAdapterLogin(FragmentManager fm) {
        super(fm);
       list.add(new LoginMain());
       list.add(new Login());
       list.add(new ForgotPassword());
       list.add(new Register());

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
