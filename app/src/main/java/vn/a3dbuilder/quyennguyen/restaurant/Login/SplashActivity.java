package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import vn.a3dbuilder.quyennguyen.restaurant.Main.BrowseMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;

public class SplashActivity extends Activity {

private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAuth = FirebaseAuth.getInstance();

        Animation performAnimationImage = AnimationUtils.loadAnimation(this, R.anim.splash_image_rotate );
        performAnimationImage.setRepeatCount(1);

        performAnimationImage.setDuration(1600);

        ImageView imageView = findViewById(R.id.imageView11);
        imageView.startAnimation(performAnimationImage);
        int SPLASH_TIME_OUT = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() == null) {
                    goToNextPage(new Intent(SplashActivity.this, LoginDirect.class));
                } else {
                    goToNextPage(new Intent(SplashActivity.this, BrowseMain.class));
                }
            }
        }, SPLASH_TIME_OUT);
    }
    private void goToNextPage(Intent intent) {
        startActivity(intent);
        finish();
    }
}
