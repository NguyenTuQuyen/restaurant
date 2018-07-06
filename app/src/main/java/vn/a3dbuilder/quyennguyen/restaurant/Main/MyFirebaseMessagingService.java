package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import vn.a3dbuilder.quyennguyen.restaurant.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FireBaseMessaging";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        addNotification(remoteMessage.getData().get("title"));

    }

    private void addNotification(String text) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.pin_off)
                        .setContentTitle("Restaurant")
                        .setContentText("This is a test notification");

        Intent notificationIntent = new Intent(this, ViewPagerMain.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        builder.setContentText(text);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}

