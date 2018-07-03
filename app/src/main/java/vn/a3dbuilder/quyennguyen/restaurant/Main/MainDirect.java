package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.MainDirectBinding;



public class MainDirect extends AppCompatActivity {
     MainDirectBinding binding;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_direct);
        fragmentManager = getSupportFragmentManager();

        showBrowseMain(null);
    }
    public void showBrowseMain(View view){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BrowseMain fragment = new BrowseMain();
        transaction.replace( R.id.container, fragment);
        transaction.commit();
    }

    public void showBookmarkMain(View view){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BookmarkMain fragment = new BookmarkMain();
        transaction.replace( R.id.container, fragment);
        transaction.commit();
    }


}
