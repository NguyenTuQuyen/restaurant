package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ViewPagerMainBinding;

public class ViewPagerMain extends AppCompatActivity {
    private ViewPagerMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.view_pager_main);

        PagerAdapterMain adapter = new PagerAdapterMain(getSupportFragmentManager());
        binding.viewPager2.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager2);
        for (int i = 0; i< binding.tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = binding.tabLayout.getTabAt(i);


        }
        binding.tabLayout.getTabAt(0).setIcon(R.drawable.home_on);
        binding.tabLayout.getTabAt(1).setIcon(R.drawable.search_off);
        binding.tabLayout.getTabAt(2).setIcon(R.drawable.pointer);
        binding.tabLayout.getTabAt(3).setIcon(R.drawable.notification_off);
        binding.tabLayout.getTabAt(4).setIcon(R.drawable.pin_off);
    }
}
