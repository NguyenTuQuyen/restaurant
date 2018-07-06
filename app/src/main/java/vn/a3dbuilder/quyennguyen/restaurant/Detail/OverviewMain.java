package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import vn.a3dbuilder.quyennguyen.restaurant.Detail.ItemOverview;
import vn.a3dbuilder.quyennguyen.restaurant.Detail.ItemOverviewList;
import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.OverviewMainBinding;


public class OverviewMain extends Fragment {
    OverviewMainBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.overview_main, container,false);


        ArrayList<ItemOverviewList> list = new ArrayList<>();
        list.add(new ItemOverviewList(8,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(9, R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(7,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(8,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(9,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(9,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(7,  R.drawable.restaurant_photo_overview));
        list.add(new ItemOverviewList(6,  R.drawable.restaurant_photo_overview));

        ItemOverview adapter = new ItemOverview(list);
        binding.recyclerView5.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false );
        binding.recyclerView5.setLayoutManager(linearLayoutManager);

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DirectMain.class);
                startActivity(intent);
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int phoneNumber = 1668636113;
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"0"+ phoneNumber));
                    startActivity(intent);
                } catch (Exception e) {
                    //TODO smth
                }
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewPagerMain.class);
                startActivity(intent);
            }
        });


        return  binding.getRoot();
    }


}
