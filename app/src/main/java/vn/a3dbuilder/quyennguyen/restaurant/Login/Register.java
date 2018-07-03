package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.RegisterBinding;


/**
 * Created by HV on 6/10/2018.
 */

public class Register extends Fragment {

    private RegisterBinding binding;
    String username;
    String password;
    String email;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.register, container, false);



        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDirect loginDirect = (LoginDirect) getActivity();
                email = binding.edtEmail.getText().toString();
                username = binding.edtUserName3.getText().toString();
                password = binding.editText.getText().toString();
                loginDirect.showLoginMain(view,username,password);

        //luu du lieu vao FireBase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        User user = new User(email, username,password );

        String id = UUID.randomUUID().toString();
        myRef.child(id).setValue(user);
            }
        });
        return binding.getRoot();
    }
}
