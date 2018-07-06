package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.Main.ViewPagerMain;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ReviewMainBinding;


public class ReviewMain extends Fragment {
    ReviewMainBinding binding;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.review_main, container, false);


List<ItemReviewTextList> objects = new ArrayList<>();
        objects.add(new ItemReviewTextList("Quyen",12,8,R.drawable.pin_off,"Good"));
        objects.add(new ItemReviewImgList(R.drawable.restaurant_photo3,R.drawable.restaurant_photo3,R.drawable.restaurant_photo3));
        objects.add(new ItemReviewTextList("Quyen",12,8,R.drawable.pin_off,"Good"));

        objects.add(new ItemReviewTextList("Quyen",12,8,R.drawable.pin_off,"Good"));
        objects.add(new ItemReviewImgList(R.drawable.restaurant_photo3,R.drawable.restaurant_photo3,R.drawable.restaurant_photo3));


        ItemReview adapter = new ItemReview(objects);

        binding.recyclerView7.setAdapter(adapter);

        binding.recyclerView7.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewPagerMain.class);
                startActivity(intent);
            }
        });
        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddRatingDialog();
            }
        });
    return  binding.getRoot();
    }

    private void openAddRatingDialog() {
//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        NoticeDialogFragment noticeDialogFragment = new NoticeDialogFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("username", "get usename ra...");
//        bundle.putString("review", "get review ra...");
//        noticeDialogFragment.setArguments(bundle);
//        //Use the commented out line below if you want the click listener to return to a fragment instead of an activity
//        //assuming that this class in a fragment and not an activity
//        //rotateSettingsFragment.setTargetFragment(getActivity().getSupportFragmentManager().findFragmentByTag("TagForThisFragment"), 0);
//        noticeDialogFragment.setTargetFragment(noticeDialogFragment, 0);
//        noticeDialogFragment.setCancelable(true);
//        noticeDialogFragment.show(fm, "NoticeDialogFragment");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        NoticeDialogFragment dialogFragment = new NoticeDialogFragment();
        dialogFragment.show(ft, "dialog");
    }



}

