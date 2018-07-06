package vn.a3dbuilder.quyennguyen.restaurant.Login;

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
import com.google.firebase.auth.FirebaseAuth;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ForgotPasswordBinding;



/**
 * Created by HV on 6/10/2018.
 */

public class ForgotPassword extends Fragment {

    private ForgotPasswordBinding binding;
    private FragmentManager fragmentManager;
    private LoginMain.AuthUtils mAuthUtils;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.forgot_password, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        binding.getpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        String email = binding.edtEmail.getText().toString().trim();
                        if (TextUtils.isEmpty(email)) {
                            Toast.makeText(getActivity(), "Enter your registered email", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "We have sent you instructions to reset your password", Toast.LENGTH_SHORT).show();
                                            goLoginMainPage();
                                        } else {
                                            Toast.makeText(getActivity(), "Failed to send reset email", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        goLoginMainPage();
                    }

            });

        return binding.getRoot();
    }
    public void setAuthUtils(LoginMain.AuthUtils authUtils) {
        mAuthUtils = authUtils;
    }

    private void goLoginMainPage() {
        LoginMain loginMainFragment = new LoginMain();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, loginMainFragment);
        fragmentTransaction.addToBackStack("Forgot");
        fragmentTransaction.commit();
    }
}
