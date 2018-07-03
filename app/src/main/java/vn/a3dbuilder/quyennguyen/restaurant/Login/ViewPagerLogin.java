package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ViewpagerLoginBinding;

/**
 * Created by HV on 6/13/2018.
 */

public class ViewPagerLogin extends AppCompatActivity {

    private ViewpagerLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.viewpager_login);
        PagerAdapterLogin adapter = new PagerAdapterLogin(getSupportFragmentManager());

        binding.viewPager.setAdapter(adapter);




}
}