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
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.RegisterBinding;


/**
 * Created by HV on 6/10/2018.
 */

public class Login extends Fragment {

    private LoginBinding binding;
    private FragmentManager fragmentManager;
    private LoginMain.AuthUtils mAuthUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.login, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goLoginMainPage();
            }

        });
        binding.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        fragmentTransaction.addToBackStack("LoginMain");
        fragmentTransaction.commit();
    }
}
