package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ForgotPasswordBinding;



/**
 * Created by HV on 6/10/2018.
 */

public class ForgotPassword extends Fragment {

    private ForgotPasswordBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.forgot_password, container, false);

        binding.getpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDirect loginDirect = (LoginDirect) getActivity();

                loginDirect.showLoginMain(view,null,null);
            }
        });
        return binding.getRoot();
    }
}
