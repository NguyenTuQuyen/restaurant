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



/**
 * Created by HV on 6/20/2018.
 */

public class BookmarkMain extends Fragment {
    BookmarkMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bookmark_main, container, false);



        ArrayList<ItemBookmarkList> list = new ArrayList<>();
        list.add(new ItemBookmarkList("Khach san Huong Lan", "Khach san Tot Nhat", 12,150, R.drawable.restaurant_photo_bookmark));
        list.add(new ItemBookmarkList("Khach san Huong Lai", "Khach san Ngon Nhat", 12,200, R.drawable.restaurant_photo2));
        list.add(new ItemBookmarkList("Khach san Huong Buoi", "Khach san Dep Nhat", 12,300, R.drawable.restaurant_photo3));
        list.add(new ItemBookmarkList("Khach san Huong Oi", "Khach san Tot Nhat", 12,120, R.drawable.restaurant_photo4));
        list.add(new ItemBookmarkList("Khach san Huong Chanh", "Khach san Re Nhat", 12,50, R.drawable.restaurant_photo4));
        list.add(new ItemBookmarkList("Khach san Huong Sunlight", "Khach san Tot Nhat", 12,200, R.drawable.restaurant_photo4));
        list.add(new ItemBookmarkList("Khach san Huong Hoa Hong", "Khach san Tot Nhat", 12,150, R.drawable.restaurant_photo4));
        list.add(new ItemBookmarkList("Khach san Huong Thom", "Khach san Tot Nhat", 12,150, R.drawable.restaurant_photo4));

        ItemBookmark adapter = new ItemBookmark(list);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false );
        binding.recyclerView.setLayoutManager(linearLayoutManager);


        return  binding.getRoot();
    }

}
