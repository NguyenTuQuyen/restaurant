package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemNotificationBinding;


/**
 * Created by HV on 5/30/2018.
 */

public class ItemNotification extends RecyclerView.Adapter {
   private List<ItemNotificationList> list;

   public ItemNotification(List<ItemNotificationList> list){
       this.list = list;

   }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemNotificationBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_notification, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout bookmark item
        ItemNotificationBinding binding = DataBindingUtil.findBinding(holder.itemView);
        ItemNotificationList data = list.get(position);
        binding.txtNotification.setText(data.getNotification());
        binding.imageView5.setImageResource(data.getLinkImg());
        binding.textView21.setText(data.getTime());
        binding.button5.setVisibility((data.following ? View.VISIBLE : View.INVISIBLE));



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder  extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
