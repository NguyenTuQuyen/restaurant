package vn.a3dbuilder.quyennguyen.restaurant.LoginSocial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.RegisterSocialBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SplashLoginBinding;

public class RegisterSocial extends AppCompatActivity {

    private RegisterSocialBinding binding;
    private String username, email, password;

    private FirebaseAuth mAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.register_social);
        mAuthentication = FirebaseAuth.getInstance();


        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();

            }
        });

    }

    private void Register() {
        email = binding.edtEmail.getText().toString().trim();
        password = binding.editText.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(RegisterSocial.this, "Please enter email",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6){
            Toast.makeText(RegisterSocial.this, "Please enter valid password ( > 6 chars)",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        mAuthentication.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuthentication.getCurrentUser();
                            Toast.makeText(RegisterSocial.this, "Register success.",
                                    Toast.LENGTH_SHORT).show();
                            sendVerificationEmail();
                            Intent intent = new Intent(RegisterSocial.this, LoginMainSocial.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            startActivities(new Intent[]{intent});
                        } else {
                            
                            Toast.makeText(RegisterSocial.this, "Register failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

        username = binding.edtUserName3.getText().toString();



    }

    private void sendVerificationEmail() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {

                            overridePendingTransition(0, 0);
                            FirebaseAuth.getInstance().signOut();


                        } else {

                            FirebaseAuth.getInstance().signOut();
                        }
                    }
                });
    }
}
