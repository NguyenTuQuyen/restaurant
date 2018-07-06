package vn.a3dbuilder.quyennguyen.restaurant.LoginSocial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SplashLoginBinding;

public class SplashLoginSocial extends AppCompatActivity {

    private SplashLoginBinding binding;
    private FirebaseAuth mAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.splash_login);
        mAuthentication = FirebaseAuth.getInstance();
        if (mAuthentication.getCurrentUser() == null) {
            goToNextPage(new Intent(SplashLoginSocial.this, LoginMainSocial.class));
        } else {
            goToNextPage(new Intent(SplashLoginSocial.this, ViewPagerMain.class));
        }
    }
    private void goToNextPage(Intent intent) {
        startActivity(intent);
        finish();
    }
}
