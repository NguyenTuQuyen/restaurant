package vn.a3dbuilder.quyennguyen.restaurant.Account;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.AccountMainBinding;



/**
 * Created by HV on 5/30/2018.
 */

public class AccountMain extends AppCompatActivity {
    private AccountMainBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.account_main);

        //ItemBookmarkList itemBookmarkList = new ItemBookmarkList(list.get(0), "Đẹp nhất VN", 12,150,"restaurant_photo_bookmark");
        ArrayList<ItemAccountList> list = new ArrayList<>();
        list.add(new ItemAccountList("Khach san Huong Lan", 150, R.drawable.restaurant_photo_account, 10));
        list.add(new ItemAccountList("Khach san Huong Lai", 200, R.drawable.restaurant_photo_account,9));
        list.add(new ItemAccountList("Khach san Huong Buoi", 300, R.drawable.restaurant_photo_account, 8));
        list.add(new ItemAccountList("Khach san Huong Oi", 120, R.drawable.restaurant_photo_account, 7));
        list.add(new ItemAccountList("Khach san Huong Chanh", 50, R.drawable.restaurant_photo_account, 6));
        list.add(new ItemAccountList("Khach san Huong Sunlight", 200, R.drawable.restaurant_photo_account, 5));
        list.add(new ItemAccountList("Khach san Huong Hoa Hong", 150, R.drawable.restaurant_photo_account,8));
        list.add(new ItemAccountList("Khach san Huong Thom", 150, R.drawable.restaurant_photo_account,5));

        ItemAccount adapter = new ItemAccount(list);
        binding.recyclerView3.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false );
        binding.recyclerView3.setLayoutManager(linearLayoutManager);



    }
}
