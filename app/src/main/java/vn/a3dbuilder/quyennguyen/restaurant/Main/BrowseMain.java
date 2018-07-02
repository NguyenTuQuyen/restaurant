package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import vn.a3dbuilder.quyennguyen.restaurant.Detail.ViewPagerDetail;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.BrowseMainBinding;






public class BrowseMain extends Fragment {
    BrowseMainBinding binding;
    private ItemBrowse adapter;
    private ArrayList<ItemBrowseList> list = new ArrayList<>();


    private void addData() {
        list.add(new ItemBrowseList("Khach san Huong Lan", "Khach san Tot Nhat", 12,8,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Lai", "Khach san Ngon Nhat", 12,9,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Buoi", "Khach san Dep Nhat", 12,7,300, "Ha Noi, VietNam",R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Oi", "Khach san Tot Nhat", 12,8,120, "Ha Noi, VietNam",R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Chanh", "Khach san Re Nhat", 12,5,50, "Ha Noi, VietNam",R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Sunlight", "Khach san Tot Nhat", 12,7,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Hoa Hong", "Khach san Tot Nhat", 12,9,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
        list.add(new ItemBrowseList("Khach san Huong Thom", "Khach san Tot Nhat", 12,10,100,"Ha Noi, VietNam", R.drawable.restaurant_photo));

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.browse_main, container,false);
//        MainDirect mainDirect = (MainDirect) getActivity();
//        binding.setActivity(mainDirect);
        addData();
        adapter = new ItemBrowse(list);
        binding.recyclerView2.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false );
        binding.recyclerView2.setLayoutManager(linearLayoutManager);

        adapter.onItemClick(new ItemBrowse.Callback() {
            public void onItemSelected(int position, ItemBrowseList value) {
                Intent i = new Intent(getActivity(), ViewPagerDetail.class);
                startActivity(i);
                //dem du lieu theo do ra trang detail
            }
        });
        binding.btnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView42.setText("Restaurant");
                list.clear();
                addData();
                adapter.notifyDataSetChanged();
            }
        });

        binding.btnClubBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView42.setText("Club&Bar");

                list.clear();


                list.add(new ItemBrowseList("Khach san Huong Lan", "Khach san Tot Nhat", 12,8,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Lai", "Khach san Ngon Nhat", 12,9,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Buoi", "Khach san Dep Nhat", 12,7,300, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Oi", "Khach san Tot Nhat", 12,8,120, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Chanh", "Khach san Re Nhat", 12,5,50, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Sunlight", "Khach san Tot Nhat", 12,7,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Hoa Hong", "Khach san Tot Nhat", 12,9,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Thom", "Khach san Tot Nhat", 12,10,100,"Ha Noi, VietNam", R.drawable.restaurant_photo));

                adapter.notifyDataSetChanged();
            }
        });

        binding.btnCoffeeTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView42.setText("Coffee&Tea");
                list.clear();


                list.add(new ItemBrowseList("Bar Huong Lan", "Khach san Tot Nhat", 12,8,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Lai", "Khach san Ngon Nhat", 12,9,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Buoi", "Khach san Dep Nhat", 12,7,300, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Oi", "Khach san Tot Nhat", 12,8,120, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Chanh", "Khach san Re Nhat", 12,5,50, "Ha Noi, VietNam",R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Sunlight", "Khach san Tot Nhat", 12,7,200,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Hoa Hong", "Khach san Tot Nhat", 12,9,150,"Ha Noi, VietNam", R.drawable.restaurant_photo));
                list.add(new ItemBrowseList("Khach san Huong Thom", "Khach san Tot Nhat", 12,10,100,"Ha Noi, VietNam", R.drawable.restaurant_photo));

                adapter.notifyDataSetChanged();
            }
        });

        return  binding.getRoot();
    }



}
