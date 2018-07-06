package vn.a3dbuilder.quyennguyen.restaurant.Account;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemAccountBinding;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemAccount extends RecyclerView.Adapter {
   private List<ItemAccountList> list;

   public ItemAccount(List<ItemAccountList> list){
       this.list = list;

   }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemAccountBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_account, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout account item
        ItemAccountBinding binding = DataBindingUtil.findBinding(holder.itemView);
        ItemAccountList data = list.get(position);
        binding.txtRestaurantName.setText(data.getListName());
        binding.imageView4.setImageResource(data.getLinkImg());
        binding.textView12.setText(data.getDistance());
        binding.button4.setText(data.getMark());



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
