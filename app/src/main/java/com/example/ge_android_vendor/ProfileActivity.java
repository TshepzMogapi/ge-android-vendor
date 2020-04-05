package com.example.ge_android_vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private int mOrderMaxMin;

    private TextView mOrderMinText;

    static final String STATE_ORDER_MIN = "Item Order Minutes";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt(STATE_ORDER_MIN, mOrderMaxMin);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mOrderMinText = findViewById(R.id.order_active_minutes);

        if (savedInstanceState != null) {
            mOrderMaxMin = savedInstanceState.getInt(
                    STATE_ORDER_MIN
            );

            mOrderMinText.setText(String.valueOf(mOrderMaxMin));
        }
    }

    public void decreaseMinutes(View view) {

        int viewId = view.getId();

        mOrderMaxMin--;
        mOrderMinText.setText(String.valueOf(mOrderMaxMin));
    }

    public void increaseMinutes(View view) {

        int viewId = view.getId();

        mOrderMaxMin++;
        mOrderMinText.setText(String.valueOf(mOrderMaxMin));
    }
}
