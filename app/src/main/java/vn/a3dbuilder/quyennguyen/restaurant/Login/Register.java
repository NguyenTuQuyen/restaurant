package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;
import java.util.concurrent.Executor;

import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.LoginMainSocial;
import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.RegisterSocial;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.RegisterBinding;

import static android.support.v4.content.ContextCompat.startActivities;


/**
 * Created by HV on 6/10/2018.
 */

public class Register extends Fragment {

    private RegisterBinding binding;
    private String username, email, password, location;

    private LoginMain.AuthUtils mAuthUtils;
    private LoginMain loginValidate;

    public void setAuthUtils(LoginMain.AuthUtils authUtils) {
        mAuthUtils = authUtils;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.register, container, false);

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = binding.edtEmail.getText().toString();
                password = binding.editText.getText().toString();
                username = binding.edtUserName3.getText().toString();
                location = binding.editText2.getText().toString();

                if (validateEmail() && validatePassword()) {
                    mAuthUtils.createUser(username, email, password,location, Register.this);
                    goLoginMainPage();
                }



            }
        });
        return binding.getRoot();
    }

    private void goLoginMainPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        LoginMain loginMainFragment = new LoginMain();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, loginMainFragment);
        fragmentTransaction.addToBackStack("LoginMain");
        fragmentTransaction.commit();
    }

    private boolean validatePassword() {
         password = binding.editText.getText().toString().trim();
        final String PASSWORD_PATERN = "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$";

        if ((binding.editText.getText().toString().equals("")) || (binding.editText.getText().length() < 6)) {
            binding.editText.setError("You should specify the password");
            return false;
        }

        return true;
    }

    private boolean validateEmail() {
         email = binding.edtEmail.getText().toString().trim();
        final String EMAIL_PATERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (email.equals("")) {
            binding.edtEmail.setError("You should specify the email");
            return false;
        }
        if (!email.matches(EMAIL_PATERN)) {
            binding.edtEmail.setError("The specified email is not correctly formated");
            return false;
        }
        return true;
    }




}

