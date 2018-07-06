package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import vn.a3dbuilder.quyennguyen.restaurant.Detail.ViewPagerDetail;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.ItemBrowseBinding;

import static android.app.PendingIntent.getActivity;


public class ItemBrowse extends RecyclerView.Adapter {
    public interface Callback {
        void onItemSelected(int position, ItemBrowseList list);
    }
   private List<ItemBrowseList> list;
    private Callback callback;

    public void onItemClick(Callback callback) {
        this.callback = callback;
    } // co the goi ham ben Main Activity de setText

    public ItemBrowse(List<ItemBrowseList> list){
       this.list = list;

   }
    public int getItemViewType(int position) {// so luong layout: 1, 2, 3
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup RecycleView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(RecycleView.getContext());
        ItemBrowseBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_browse, RecycleView, false);
        View view = binding.getRoot();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        //gan du lieu vao layout bookmark item
        ItemBrowseBinding binding = DataBindingUtil.findBinding(holder.itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if(callback != null) {
                    callback.onItemSelected(pos, list.get(pos));
                }
            }
        });




        ItemBrowseList data = list.get(position);
        binding.txtRestaurantName.setText(data.getListName());
        binding.imageView4.setImageResource(data.getLinkImg());
        binding.textView10.setText(data.getDescription());
        binding.textView12.setText(data.getDistance());
        binding.textView13.setText(data.getPlace());
//        binding.textView16.setText(data.getPrice());
//        binding.textView25.setText(data.getMark());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder  extends RecyclerView.ViewHolder {

       public MyViewHolder(View itemView) {
            super(itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                // vị trí vừa click
//                                int position = getAdapterPosition();
//                                Toast.makeText(view.getContext(), "jnehnfj", Toast.LENGTH_LONG).show();
//                                if(callback != null) {
//                                    callback.onItemSelected(position, list.get(position));
//                                }
//                            }
//                        });

        }

    }
}
