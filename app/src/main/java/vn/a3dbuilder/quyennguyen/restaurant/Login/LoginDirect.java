package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginDirectBinding;

/**
 * Created by HV on 6/10/2018.
 */

public class LoginDirect extends AppCompatActivity {
    private LoginDirectBinding binding;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_direct);

        LoginMain loginMain = new LoginMain();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, loginMain);
        fragmentTransaction.commit();


    }
}
