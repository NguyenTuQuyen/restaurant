package vn.a3dbuilder.quyennguyen.restaurant;

import android.app.Service;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemBinding;

/**
 * Created by HV on 5/27/2018.
 */


public class MyService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (i < 100){
                   i++;
                   try{
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   // tao Intent
                    Intent intent1 = new Intent();
                   intent1.setAction("count");
                   intent1.putExtra("count", i);
                    //gui cho he thong
                    sendBroadcast(intent1);

                }
            }
        });
        thread.start();

        return START_STICKY;
    }
}
