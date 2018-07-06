package vn.a3dbuilder.quyennguyen.restaurant.LoginSocial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginMainSocialBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SplashLoginBinding;

public class LoginMainSocial extends AppCompatActivity {

    private LoginMainSocialBinding binding;
    private FirebaseAuth mAuthentication;
    private  String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_main_social);
        mAuthentication = FirebaseAuth.getInstance();

        //get password tu RegisterSocial
        Intent intent = getIntent();
        binding.edtUserName.setText(intent.getStringExtra("email"));
        binding.edtPassWord.setText(intent.getStringExtra("password"));

        binding.loginMainSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();

            }
        });
        binding.registerSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
        binding.loginSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFB();
            }
        });
        binding.forgotPasswordSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPw();
            }
        });
    }

    private void ForgotPw() {
    }

    private void LoginFB() {
        Intent intent = new Intent(LoginMainSocial.this, LoginSocial.class);
        startActivities(new Intent[]{intent});
    }

    private void Register() {
        Intent intent = new Intent(LoginMainSocial.this, RegisterSocial.class);
        startActivities(new Intent[]{intent});


    }

    private void Login() {
        email = binding.edtUserName.getText().toString();
        password = binding.edtPassWord.getText().toString();

        mAuthentication.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuthentication.getCurrentUser();
                            if (user.isEmailVerified()) {
                                Intent i = new Intent(getApplicationContext(), ViewPagerMain.class);
                                startActivity(i);
                            }else {
                                Toast.makeText(LoginMainSocial.this, "Email verification failed", Toast.LENGTH_LONG).show();
                            }


                        } else {

                            Toast.makeText(LoginMainSocial.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }

}
