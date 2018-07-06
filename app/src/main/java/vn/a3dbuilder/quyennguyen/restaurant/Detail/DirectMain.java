package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.DirectMainBinding;

public class DirectMain extends AppCompatActivity {
    private DirectMainBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     binding = DataBindingUtil.setContentView(this, R.layout.direct_main);

     binding.buttonBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             onBackPressed();
         }
     });
    }
}
