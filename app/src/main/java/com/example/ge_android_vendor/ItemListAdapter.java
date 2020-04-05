package com.example.ge_android_vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class ItemListAdapter extends
        RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {


    private LayoutInflater mInflater;

//    private final LinkedList<String> mItemList;

    private ArrayList<Item> mItemsData;
    private Context mContext;

//    public ItemListAdapter(Context context,
//                           LinkedList<String> itemList) {
//
//        mInflater = LayoutInflater.from(context);
//        this.mItemList = itemList;
//    }

    public ItemListAdapter(Context context,
                           ArrayList<Item> itemsData) {

        this.mItemsData = itemsData;
        this.mContext = context;
    }




    @NonNull
    @Override
    public ItemListAdapter.ItemViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.from(mContext)
                .inflate(R.layout.itemlist
                , parent, false);
        return new ItemViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {

//        String mCurrent = mItemList.get(position);
//        holder.ItemView.setText(mCurrent);

        Item currentItem = mItemsData.get(position);

        holder.bindTo(currentItem);

    }

    @Override
    public int getItemCount() {
        return mItemsData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

//        public final TextView ItemView;
//        final ItemListAdapter mAdapter;

        private TextView mTitleText;
        private TextView mDescriptionText;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

//            ItemView = itemView.findViewById(R.id.tv_item_list);
//            this.mAdapter = adapter;

            mTitleText = itemView.findViewById(R.id.vh_item_title);
            mDescriptionText = itemView.findViewById(R.id.vh_item_description);

//            ItemView.setOnClickListener(this);
        }


        void bindTo(Item currentItem) {
            mTitleText.setText(currentItem.getTitle());
            mDescriptionText.setText(currentItem.getDescription());
        }

        @Override
        public void onClick(View v) {

//
//            int mPosition = getLayoutPosition();
//
//            String element = mItemList.get(mPosition);
//
//            mItemList.set(mPosition, "Clicked!" + element);
//
//            mAdapter.notifyDataSetChanged();

        }
    }





}
