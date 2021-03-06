package com.example.ge_android_vendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ItemListAdapter mItemListAdapter;
    private ArrayList<Item> mItemsData;


    private final LinkedList<String> mItemList = new LinkedList<>();

    private static final String LOG_TAG =
            ItemsActivity.class.getSimpleName();

    public static final String EXTRA_ITEM =
            "com.example.android.ge_android_vendor.extra.ITEM";

    private EditText mItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        mRecyclerView = findViewById(R.id.rv_content_items);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mItemsData = new ArrayList<>();

        mItemListAdapter = new ItemListAdapter(this, mItemsData);

        mRecyclerView.setAdapter(mItemListAdapter);

        initializeData();

        ItemTouchHelper touchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT
                | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                        mItemsData.remove(viewHolder.getAdapterPosition());

                        mItemListAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                    }
                });

        touchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void initializeData() {

        String[] itemsList = getResources()
                .getStringArray(R.array.items_titles);

        String[] itemsDescriptions = getResources()
                .getStringArray(R.array.items_descriptions);

        TypedArray itemsImageResources =
                getResources().obtainTypedArray(R.array.items_images);

        for (int i = 0; i < itemsList.length; i++) {
            mItemsData.add(new Item(itemsList[i], itemsDescriptions[i],
                    itemsImageResources.getResourceId(i,0)));
        }

        itemsImageResources.recycle();

        mItemListAdapter.notifyDataSetChanged();

    }

    public void launchSecondActivity(View view) {


        Intent intent = new Intent(this, ItemDetailActivity.class);


        startActivity(intent);

        Log.d(LOG_TAG, "launching sec act");
    }
}
