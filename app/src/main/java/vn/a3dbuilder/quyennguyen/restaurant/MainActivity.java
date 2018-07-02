package vn.a3dbuilder.quyennguyen.restaurant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//khoi tao
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            //khoi tao noi nhan
            public void onReceive(Context context, Intent intent) {
            int number = intent.getIntExtra("count", 0);
            binding.textView44.setText( String.valueOf(number));
            }
        };
        //dang ki  nhan

        IntentFilter intentFilter = new IntentFilter( );
        intentFilter.addAction("count");
        registerReceiver(broadcastReceiver, intentFilter);

        Intent service = new Intent(this, MyService.class);
        startService(service);

        //huy service


    }
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}
