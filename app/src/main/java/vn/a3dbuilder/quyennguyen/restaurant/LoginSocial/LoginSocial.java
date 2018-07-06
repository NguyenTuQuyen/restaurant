package vn.a3dbuilder.quyennguyen.restaurant.LoginSocial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

import vn.a3dbuilder.quyennguyen.restaurant.Detail.ViewPagerDetail;
import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.LoginSocialBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.SplashLoginBinding;

public class LoginSocial extends AppCompatActivity {

    private LoginSocialBinding binding;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login_social);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               //.requestIdToken(getString(R.string.default_web_client_id))
                .requestIdToken("763652738957-ebmlvo5ouujqqaqdlnmc3br85m5qlqg5.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();

            }
        });
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
//                Intent intent = new Intent(LoginSocial.this, ViewPagerMain.class);
//                startActivities(new Intent[]{intent});
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(LoginSocial.this, "Google SignIn failed.",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
    // [END onactivityresult]
    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuthentication.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuthentication.getCurrentUser();
                            Toast.makeText(LoginSocial.this, "Authentication with Google success.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginSocial.this, ViewPagerMain.class);
                            startActivities(new Intent[]{intent});
                        } else {

                            Toast.makeText(LoginSocial.this, "Authentication with Google failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}
