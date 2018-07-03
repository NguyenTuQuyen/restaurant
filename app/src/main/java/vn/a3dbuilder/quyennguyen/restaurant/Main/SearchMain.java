package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.BookmarkMainBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SearchMainBinding;



public class SearchMain extends Fragment {
    SearchMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_main, container, false);


        //ItemBookmarkList itemBookmarkList = new ItemBookmarkList(list.get(0), "Đẹp nhất VN", 12,150,"restaurant_photo_bookmark");
        ArrayList<ItemSearchList> list = new ArrayList<>();
        list.add(new ItemSearchList("Khach san Huong Lan", "Khach san Tot Nhat", 12,8,150, R.drawable.restaurant_photo_bookmark));
        list.add(new ItemSearchList("Khach san Huong Lai", "Khach san Ngon Nhat", 12,9,200, R.drawable.restaurant_photo2));
        list.add(new ItemSearchList("Khach san Huong Buoi", "Khach san Dep Nhat", 12,7,300, R.drawable.restaurant_photo3));
        list.add(new ItemSearchList("Khach san Huong Oi", "Khach san Tot Nhat", 12,8,120, R.drawable.restaurant_photo4));
        list.add(new ItemSearchList("Khach san Huong Chanh", "Khach san Re Nhat", 12,5,50, R.drawable.restaurant_photo4));
        list.add(new ItemSearchList("Khach san Huong Sunlight", "Khach san Tot Nhat", 12,7,200, R.drawable.restaurant_photo4));
        list.add(new ItemSearchList("Khach san Huong Hoa Hong", "Khach san Tot Nhat", 12,9,150, R.drawable.restaurant_photo4));
        list.add(new ItemSearchList("Khach san Huong Thom", "Khach san Tot Nhat", 12,10,100, R.drawable.restaurant_photo4));

        ItemSearch adapter = new ItemSearch(list);
        binding.recyclerView6.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false );
        binding.recyclerView6.setLayoutManager(linearLayoutManager);

        return  binding.getRoot();

    }
}
