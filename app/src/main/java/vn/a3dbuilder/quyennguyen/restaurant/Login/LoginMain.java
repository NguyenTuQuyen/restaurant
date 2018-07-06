package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;

import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.LoginSocial;
import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.SharedPreferenceHelper1;
import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginMainBinding;

import static android.support.v4.content.ContextCompat.startActivities;

public class LoginMain extends Fragment {

    LoginMainBinding binding;
    private AuthUtils mAuthUtils;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;
    private boolean firstTimeAccess;

    private String  email, password;

    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_main, container, false);


        mAuth = FirebaseAuth.getInstance();
        mAuthUtils = new AuthUtils();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    StaticConfig.UID = user.getUid();
                    if (firstTimeAccess) {
                        startActivity(new Intent(getActivity(), ViewPagerMain.class));
                        getActivity().finish();
                    }
                }
                firstTimeAccess = false;

                //login with Google Sign-in
//                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                        //.requestIdToken(getString(R.string.default_web_client_id))
//                        .requestIdToken("763652738957-ebmlvo5ouujqqaqdlnmc3br85m5qlqg5.apps.googleusercontent.com")
//                        .requestEmail()
//                        .build();
//                mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
            }
        };



        mAuth.addAuthStateListener(mAuthListener);



        email = binding.edtUserName.getText().toString();
        password = binding.edtPassWord.getText().toString();
//bat cac su kien Click

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();

            }
        });
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegisterPage();
            }
        });
        binding.loginFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginPage();
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goForgotPage();
            }
        });



        return  binding.getRoot();
    }


    private void Login() {
        email = binding.edtUserName.getText().toString();
        password = binding.edtPassWord.getText().toString();
        if (validateEmail() && validatePassword()) {
            mAuthUtils.signIn(email, password);
        }

    }
    public boolean validateEmail() {
        String email = binding.edtUserName.getText().toString().trim();
        final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.equals("")) {
            binding.edtUserName.setError("You should specify the email");
            return false;
        }
        if (!email.matches(EMAIL_PATTERN)) {
            binding.edtUserName.setError("The specified email is not correctly formated");
            return false;
        }
        return true;
    }
    public boolean validatePassword() {
        String password = binding.edtPassWord.getText().toString().trim();
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$";

        if ((password.equals("")) || (password.length() < 6)) {
            binding.edtPassWord.setError("You should specify the password");
            return false;
        }

        return true;
    }
    private void goForgotPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ForgotPassword forgotFragment = new ForgotPassword();
        forgotFragment.setAuthUtils(mAuthUtils);
        fragmentTransaction.replace(R.id.container, forgotFragment);
        fragmentTransaction.addToBackStack("Forgot");
        fragmentTransaction.commit();
    }

    private void goRegisterPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Register registerFragment = new Register();
        registerFragment.setAuthUtils(mAuthUtils);
        fragmentTransaction.replace(R.id.container, registerFragment);
        fragmentTransaction.addToBackStack("Register");
        fragmentTransaction.commit();
    }

    public void goLoginMainPage() {
        LoginMain loginMainFragment = new LoginMain();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, loginMainFragment);
        fragmentTransaction.addToBackStack("LoginMain");
        fragmentTransaction.commit();
    }
    public void goLoginPage() {
        Login loginFragment = new Login();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        loginFragment.setAuthUtils(mAuthUtils);
        fragmentTransaction.replace(R.id.container, loginFragment);
        fragmentTransaction.addToBackStack("Login");
        fragmentTransaction.commit();
    }
    public void redirect() {
        Intent redirect = new Intent(getActivity().getApplicationContext(), ViewPagerMain.class);
        getActivity().startActivity(redirect);
        getActivity().finish();
    }
    class AuthUtils {

        private Register mRegisterFragment;

        void createUser(final String username, final String email, String password, final String location, Register registerFragment) {
            mRegisterFragment = registerFragment;

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(mRegisterFragment.getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Register an account failed", Toast.LENGTH_SHORT).show();
                            } else {
                                initNewUserInfo(username, email, location);
                                Toast.makeText(getActivity(), "Register success", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                sendEmailVerification(mRegisterFragment.getActivity());

                            }
                        }
                    })

            ;
        }

        private void sendEmailVerification(Activity activity) {
            final FirebaseUser user = mAuth.getCurrentUser();
            user.getDisplayName();
            user.sendEmailVerification().addOnCompleteListener(activity, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        goLoginMainPage();
                    } else {
                        showMessage(mRegisterFragment.getActivity(), "Authentication failed.");
                    }

                }
            });
        }

        private void showMessage(Activity activity, String message) {
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
        }

        void signIn(String email, String password) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Incorrect email or password. Authentication failed", Toast.LENGTH_LONG).show();
                            } else {
                                if (user.isEmailVerified()) {
                                    FirebaseMessaging.getInstance().subscribeToTopic(mAuth.getCurrentUser().getUid());
                                    System.out.println(mAuth.getCurrentUser().getUid());
                                    saveUserInfo();
                                    redirect();
                                }else {
                                    Toast.makeText(getActivity(), "Email verification failed", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });

        }

        void saveUserInfo() {
            FirebaseDatabase.getInstance().getReference().child("user/" + StaticConfig.UID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    HashMap hashUser = (HashMap) dataSnapshot.getValue();
                    if (hashUser == null) {
                        return;
                    }
                    User userInfo = new User();
                    userInfo.name = (String) hashUser.get("name");
                    userInfo.email = (String) hashUser.get("email");
                    userInfo.avata = (String) hashUser.get("avata");
                    userInfo.location = (String) hashUser.get("location");
                    SharedPreferenceHelper.getInstance(getActivity()).saveUserInfo(userInfo);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        void initNewUserInfo(String username, String email, String location) {
            User newUser = new User();
            newUser.email = email;
            newUser.name = username;
            newUser.location = location;
            newUser.avata = StaticConfig.STR_DEFAULT_BASE64;
            if (user == null) {
                user = mAuth.getCurrentUser();
            }
            FirebaseDatabase.getInstance().getReference().child("user/" + user.getUid()).setValue(newUser);
        }
    }

    //TODO: comment in case of issue or remove after test
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}




