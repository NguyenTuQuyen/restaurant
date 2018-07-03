package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import vn.a3dbuilder.quyennguyen.restaurant.Detail.PagerAdapterDetail;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ViewPagerDetailBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ViewPagerMainBinding;

public class ViewPagerDetail extends AppCompatActivity {
    private ViewPagerDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.view_pager_detail);

        PagerAdapterDetail adapter = new PagerAdapterDetail(getSupportFragmentManager());
        binding.viewPager2.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager2);
        for (int i = 0; i< binding.tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = binding.tabLayout.getTabAt(i);


        }

    }
}
