package com.example.ge_android_vendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
    }

    private void initializeData() {

        String[] itemsList = getResources()
                .getStringArray(R.array.item_titles);

        String[] itemsDescriptions = getResources()
                .getStringArray(R.array.item_descriptions);

        for (int i = 0; i < itemsList.length; i++) {
            mItemsData.add(new Item(itemsList[i], itemsDescriptions[i]));
        }

        mItemListAdapter.notifyDataSetChanged();

    }

    public void launchSecondActivity(View view) {


        Intent intent = new Intent(this, ItemDetailActivity.class);


        startActivity(intent);

        Log.d(LOG_TAG, "launching sec act");
    }
}
