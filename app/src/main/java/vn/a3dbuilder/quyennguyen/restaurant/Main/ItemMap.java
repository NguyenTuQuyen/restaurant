package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemMapBinding;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemMap extends RecyclerView.Adapter {
   private List<ItemMapList> list;

   public ItemMap(List<ItemMapList> list){
       this.list = list;

   }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemMapBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_map, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout account item
        ItemMapBinding binding = DataBindingUtil.findBinding(holder.itemView);
        ItemMapList data = list.get(position);
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
