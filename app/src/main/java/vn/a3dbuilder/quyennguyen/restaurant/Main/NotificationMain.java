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
import vn.a3dbuilder.quyennguyen.restaurant.databinding.NotificationMainBinding;


public class NotificationMain extends Fragment {
    NotificationMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.notification_main, container, false);

        //ItemBookmarkList itemBookmarkList = new ItemBookmarkList(list.get(0), "Đẹp nhất VN", 12,150,"restaurant_photo_bookmark");
        ArrayList<ItemNotificationList> list = new ArrayList<>();
        list.add(new ItemNotificationList("Khach san Huong Lan", 12, true, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Lai", 25, true, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Buoi", 11, false, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Oi", 23, true, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Chanh", 15, true, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Sunlight", 24, true, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Hoa Hong", 25, false, R.drawable.img_notification));
        list.add(new ItemNotificationList("Khach san Huong Thom", 15, false, R.drawable.img_notification));

        ItemNotification adapter = new ItemNotification(list);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false );
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        return  binding.getRoot();


    }
}
