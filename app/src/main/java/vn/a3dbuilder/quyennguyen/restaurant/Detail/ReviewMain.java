package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.MenuMainBinding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ReviewMainBinding;


public class ReviewMain extends Fragment {
    ReviewMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.review_main, container, false);


List<ItemReviewTextList> objects = new ArrayList<>();
objects.add(new ItemReviewTextList("Quyen",12,8,R.drawable.green_circle,"Good"));
objects.add(new ItemReviewImgList(R.drawable.restaurant_photo3,R.drawable.restaurant_photo_menu,R.drawable.restaurant_photo3));


        ItemReview adapter = new ItemReview(objects);

        binding.recyclerView7.setAdapter(adapter);

        binding.recyclerView7.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    return  binding.getRoot();
    }
}
