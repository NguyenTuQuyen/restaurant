package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemReview1Binding;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemReview2Binding;

import static vn.a3dbuilder.quyennguyen.restaurant.R.layout.*;
import static vn.a3dbuilder.quyennguyen.restaurant.R.layout.item_review2;


/**
 * Created by HV on 5/30/2018.
 */

public class ItemReview extends RecyclerView.Adapter {
   private List<ItemReviewTextList> list;

   public ItemReview(List<ItemReviewTextList> list){
       this.list = list;

   }

    @Override
    public int getItemViewType(int position) {
        ItemReviewTextList itemReviewTextList = list.get(position);
        if (itemReviewTextList instanceof ItemReviewImgList) {
            return 2;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());

        View view;
        if (viewType == 2){
            ItemReview2Binding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_review2, RecycleView,false);
            view = binding.getRoot();
        }else{
            ItemReview1Binding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_review1,RecycleView, false);
            view = binding.getRoot();
        }
MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ItemReviewTextList itemReviewTextList = list.get(position);

        if (itemReviewTextList instanceof ItemReviewImgList){
            ItemReview2Binding binding = DataBindingUtil.findBinding(holder.itemView);
            ItemReviewImgList itemReviewImgList = (ItemReviewImgList) itemReviewTextList;
            binding.imageView7.setImageResource(itemReviewImgList.getImageLink1());
            binding.imageView14.setImageResource(itemReviewImgList.getImageLink2());
            binding.imageView16.setImageResource(itemReviewImgList.getImageLink3());


        }
//        else{
//            ItemReview1Binding binding = DataBindingUtil.findBinding(holder.itemView);
//            binding.imageView3.setImageResource(itemReviewTextList.getLinkAvatar());
//            binding.textView49.setText(itemReviewTextList.getUsername());
//            binding.textView50.setText(itemReviewTextList.getTime());
//            binding.textView51.setText(((int) itemReviewTextList.getMark()));
//            binding.textView48.setText(itemReviewTextList.getReview());
//        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder  extends RecyclerView.ViewHolder{
        public MyViewHolder(View view) {
            super(view);
        }
    }
}
