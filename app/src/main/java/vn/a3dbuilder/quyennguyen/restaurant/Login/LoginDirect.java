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
    private int page = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_direct);


        fragmentManager = getSupportFragmentManager();
        showLoginMain(null,null,null);


//xu li database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");


        User user = new User("admin@admin","admin", "123");

        String id = UUID.randomUUID().toString();
        myRef.child(id).setValue(user);


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                User value = dataSnapshot.getValue(User.class);
                Log.d("df", dataSnapshot.getKey() + ": " + value.username);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //end xu li database

    public void showLoginMain(View view, String username, String password){
        page = 0;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LoginMain fragment = new LoginMain();
        fragment.setUsername(username);
        fragment.setPassword(password);
        transaction.replace( R.id.container, fragment);
        transaction.commit();
    }
// setting backPress
    @Override
    public void onBackPressed() {
        if (page == 1) {
            showLoginMain(null,null,null);
            page--;
        }
        else if (page == 0) {
            super.onBackPressed();
        }
    }

    public void showRegister(View view) {
        page = 1;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Register fragment = new Register();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
    public void showLogin(View view) {
        page = 1;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Login fragment = new Login();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
    public void showForgotPassword(View view) {
        page = 1;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ForgotPassword fragment = new ForgotPassword();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
