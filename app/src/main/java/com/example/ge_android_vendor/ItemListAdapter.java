package com.example.ge_android_vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ItemListAdapter extends
        RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {


    private LayoutInflater mInflater;

    private final LinkedList<String> mItemList;

    public ItemListAdapter(Context context,
                           LinkedList<String> itemList) {

        mInflater = LayoutInflater.from(context);
        this.mItemList = itemList;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        public final TextView ItemView;
        final ItemListAdapter mAdapter;


        public ItemViewHolder(@NonNull View itemView, ItemListAdapter adapter) {
            super(itemView);

            ItemView = itemView.findViewById(R.id.tv_item_list);
            this.mAdapter = adapter;

            ItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            int mPosition = getLayoutPosition();

            String element = mItemList.get(mPosition);

            mItemList.set(mPosition, "Clicked!" + element);

            mAdapter.notifyDataSetChanged();

        }
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.itemlist
                , parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {

        String mCurrent = mItemList.get(position);
        holder.ItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }





}
