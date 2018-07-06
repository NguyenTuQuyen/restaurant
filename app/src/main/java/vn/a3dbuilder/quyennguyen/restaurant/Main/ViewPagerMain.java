package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.accounts.Account;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.File;
import java.util.Locale;

import vn.a3dbuilder.quyennguyen.restaurant.Account.AccountMain;
import vn.a3dbuilder.quyennguyen.restaurant.Login.LoginDirect;
import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.LoginMainSocial;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ViewPagerMainBinding;

public class ViewPagerMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPagerMainBinding binding;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.view_pager_main);
        mAuth = FirebaseAuth.getInstance();
        //set ServicePushNotification
        startServicePushNotification();

        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.user);
        toolbar.setOverflowIcon(drawable);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //pager + tab layout
        PagerAdapterMain adapter = new PagerAdapterMain(getSupportFragmentManager());
        binding.viewPager2.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager2);
        for (int i = 0; i< binding.tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = binding.tabLayout.getTabAt(i);


        }
        binding.tabLayout.getTabAt(0).setIcon(R.drawable.home_on);
        binding.tabLayout.getTabAt(1).setIcon(R.drawable.search_off);
        binding.tabLayout.getTabAt(2).setIcon(R.drawable.pointer);
        binding.tabLayout.getTabAt(3).setIcon(R.drawable.notification_off);
        binding.tabLayout.getTabAt(4).setIcon(R.drawable.pin_off);

        //subcribe notification from FCM
        subcribeFirebasePushNotification();
    }

    private void startServicePushNotification() {
        startService(new Intent(new Intent(this, MyServiceNotificationPush.class)));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_my_account) {
            Intent intent = new Intent(this, AccountMain.class);
            startActivities(new Intent[]{intent});
            return true;
        }else if(id == R.id.action_logout){
            pressLogout();
            //showChangeLangDialog();

            return true;
        }else if(id == R.id.action_exit){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.exit_this_app)
                    .setCancelable(true)
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ViewPagerMain.this.finish();

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

            return true;
        }else if(id == R.id.change_lang){
            showChangeLangDialog();
        }else if(id == R.id.manage){
            showManage();
        }



        return super.onOptionsItemSelected(item);
    }

    private void showManage() {
        //Unsubcribe from firebase notification

        //unsubscribeFromTopic();
    }
    private void subcribeFirebasePushNotification(){
        //lay bien luu du lieu isSubcribe tu localDB len, KT neu True thi subcribe, mat dinh la true
        boolean isSubcribe = true;
        if(isSubcribe){
            FirebaseMessaging.getInstance().subscribeToTopic("news")
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = getString(R.string.msg_subscribed);
                            if (!task.isSuccessful()) {
                                msg = getString(R.string.msg_subscribe_failed);
                            }

                           // Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        }
                    });
            
        }
    }


    private void pressLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.logout_dialog_question)
                .setCancelable(true)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic(mAuth.getCurrentUser().getUid());

                        FirebaseAuth.getInstance().signOut();
                        File avatarImage = new File(Environment.getExternalStorageDirectory().getPath() + "/avatar");
                        if (avatarImage.exists()) {
                            avatarImage.delete();
                        }

                        Intent intent = new Intent(getApplicationContext(), LoginDirect.class);
                        startActivities(new Intent[]{intent});
                       // LocalDB.getInstance(ViewPagerActivity.this).dropDB();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);

       // item.setChecked(true);
        int id = item.getItemId();
        Toast.makeText(getApplicationContext(),"ndf",Toast.LENGTH_LONG).show();
        switch (id) {
            case R.id.nav_manage:

                break;
                // Handle the camera action
            case R.id.nav_language:
                showChangeLangDialog();
                break;

            case R.id.nav_contact:
                break;

            case R.id.nav_help:
                break;

        }

        return true;


    }

    private void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language_dialog, null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner = (Spinner) dialogView.findViewById(R.id.spinner);

        dialogBuilder.setTitle(getResources().getString(R.string.lang_dialog_title));
        dialogBuilder.setPositiveButton(R.string.select, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int language = spinner.getSelectedItemPosition();
                switch (language) {
                    case 0:

                        setLocale("en");

                        break;
                    case 1:

                        setLocale("vi");

                        break;
                    default:

                        setLocale("en");

                }
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf,dm);
        Intent refresh = new Intent(this, ViewPagerMain.class);
        startActivities(new Intent[]{refresh});
    }


}
