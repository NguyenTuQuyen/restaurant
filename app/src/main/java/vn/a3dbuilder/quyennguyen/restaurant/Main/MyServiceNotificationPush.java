package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import vn.a3dbuilder.quyennguyen.restaurant.R;

public class MyServiceNotificationPush extends Service {
    public MyServiceNotificationPush() {
    }
    private BroadcastReceiver broadcastReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void PushNotification(){
        Notification.Builder notification = new Notification.Builder(getApplicationContext());
        //set small icon
        notification.setSmallIcon(R.drawable.pin_off);

        RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.item_notification_push);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            notification.setCustomBigContentView(contentView);
        }else{
            notification.setContent(contentView);
        }

        //dua du lieu vao
        contentView.setTextViewText(R.id.textView52, "Restaurant Name");
        contentView.setTextViewText(R.id.textView53, "Description");
        contentView.setImageViewResource(R.id.imageView15, R.drawable.pin_off);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(15, notification.build());
        //startForeground(15, notification.build());
        //chay duoi nen, khong cho tat, chi tat khi kill giao dien

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("view");
        registerReceiver(broadcastReceiver,intentFilter);
        //chay cai PushNotification len
        PushNotification();

        return START_STICKY;
    }
    public void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}
