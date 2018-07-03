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
import vn.a3dbuilder.quyennguyen.restaurant.databinding.MapMainBinding;



public class MapMain extends Fragment {
    MapMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.map_main, container, false);


        //ItemBookmarkList itemBookmarkList = new ItemBookmarkList(list.get(0), "Đẹp nhất VN", 12,150,"restaurant_photo_bookmark");
        ArrayList<ItemMapList> list = new ArrayList<>();
        list.add(new ItemMapList("Khach san Huong Lan", 150, R.drawable.restaurant_photo_map, 10));
        list.add(new ItemMapList("Khach san Huong Lai", 200, R.drawable.restaurant_photo_map,9));
        list.add(new ItemMapList("Khach san Huong Buoi", 300, R.drawable.restaurant_photo_map, 8));
        list.add(new ItemMapList("Khach san Huong Oi", 120, R.drawable.restaurant_photo_map, 7));
        list.add(new ItemMapList("Khach san Huong Chanh", 50, R.drawable.restaurant_photo_map, 6));
        list.add(new ItemMapList("Khach san Huong Sunlight", 200, R.drawable.restaurant_photo_map, 5));
        list.add(new ItemMapList("Khach san Huong Hoa Hong", 150, R.drawable.restaurant_photo_map,8));
        list.add(new ItemMapList("Khach san Huong Thom", 150, R.drawable.restaurant_photo_map,5));

        ItemMap adapter = new ItemMap(list);
        binding.recyclerView4.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false );
        binding.recyclerView4.setLayoutManager(linearLayoutManager);

        return  binding.getRoot();

    }
}
