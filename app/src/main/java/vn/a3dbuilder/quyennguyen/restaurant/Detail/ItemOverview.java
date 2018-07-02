package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemOverviewBinding;


/**
 * Created by HV on 5/30/2018.
 */

public class ItemOverview extends RecyclerView.Adapter {
   private List<ItemOverviewList> list;

   public ItemOverview(List<ItemOverviewList> list){
       this.list = list;

   }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemOverviewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_overview, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout bookmark item
        ItemOverviewBinding binding = DataBindingUtil.findBinding(holder.itemView);
        ItemOverviewList data = list.get(position);
        binding.textView25.setText(data.getMark());
        binding.imageView10.setImageResource(data.getLinkImg());




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
