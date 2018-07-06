package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.auth.FirebaseAuth;

import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.LoginMainSocial;
import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SplashLoginBinding;

public class SplashLogin extends AppCompatActivity {

    private SplashLoginBinding binding;
    private FirebaseAuth mAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.splash_login);
        mAuthentication = FirebaseAuth.getInstance();
        Animation performAnimationImage = AnimationUtils.loadAnimation(this, R.anim.splash_image_rotate);
        performAnimationImage.setRepeatCount(1);
        performAnimationImage.setDuration(1600);
        binding.imageView12.startAnimation(performAnimationImage);
        int SPLASH_TIME_OUT = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuthentication.getCurrentUser() == null) {
                    goToNextPage(new Intent(SplashLogin.this, LoginDirect.class));
                } else {
                    goToNextPage(new Intent(SplashLogin.this, ViewPagerMain.class));
                }
            }
        }, SPLASH_TIME_OUT);

    }
    private void goToNextPage(Intent intent) {
        startActivity(intent);
        finish();
    }
}
