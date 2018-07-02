package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemMenuBinding;


/**
 * Created by HV on 5/30/2018.
 */

public class ItemMenu extends RecyclerView.Adapter {
   private List<ItemMenuList> list;

   public ItemMenu(List<ItemMenuList> list){
       this.list = list;

   }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemMenuBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_menu, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout bookmark item
        ItemMenuBinding binding = DataBindingUtil.findBinding(holder.itemView);
        ItemMenuList data = list.get(position);
        binding.txtRestaurantName2.setText(data.getListName());
        binding.imageView5.setImageResource(data.getLinkImg());
        binding.textView15.setText(data.getDescription());
        binding.textView16.setText(data.getPrice());



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
