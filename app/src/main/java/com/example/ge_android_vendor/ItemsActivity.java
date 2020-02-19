package com.example.ge_android_vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ItemsActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            ItemsActivity.class.getSimpleName();

    public static final String EXTRA_ITEM =
            "com.example.android.ge_android_vendor.extra.ITEM";

    private EditText mItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        mItemName = findViewById(R.id.et_item_name);
    }

    public void launchSecondActivity(View view) {

        String itemName = mItemName.getText().toString();

        Intent intent = new Intent(this, ItemDetailActivity.class);

        intent.putExtra(EXTRA_ITEM, itemName);

        startActivity(intent);

        Log.d(LOG_TAG, "launching sec act");
    }
}
