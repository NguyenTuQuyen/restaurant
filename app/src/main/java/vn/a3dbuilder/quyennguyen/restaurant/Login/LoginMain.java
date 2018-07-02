package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vn.a3dbuilder.quyennguyen.restaurant.Detail.PagerAdapterDetail;
import vn.a3dbuilder.quyennguyen.restaurant.Main.MainDirect;
import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginMainBinding;

public class LoginMain extends Fragment {

    LoginMainBinding binding;
    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_main, container, false);
        LoginDirect loginDirect = (LoginDirect) getActivity();
        binding.setActivity(loginDirect);

        if (!TextUtils.isEmpty(username)) {
            binding.edtUserName.setText(username);
        }
        if (!TextUtils.isEmpty(password)) {
            binding.edtPassWord.setText(password);
        }
        

        //getData
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
username = binding.edtUserName.getText().toString();
password = binding.edtPassWord.getText().toString();
                final DatabaseReference user = FirebaseDatabase.getInstance().getReference("User");
                user.orderByChild("username").equalTo(username).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot data: dataSnapshot.getChildren()
                                ) {

                            if (data.child("password").getValue(String.class).equals(password)){
                                Intent i = new Intent(getActivity(), ViewPagerMain.class);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }



                });

            }
        });


        return  binding.getRoot();
    }
}




