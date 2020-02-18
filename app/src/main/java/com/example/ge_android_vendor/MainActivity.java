package com.example.ge_android_vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mShowCount = findViewById(R.id.tv_count);
        Log.d(LOG_TAG, "Hello World");
    }

    public void count(View view) {

        countUp();
        Toast toast = Toast
                .makeText(this, R.string.counting_toast_message, Toast.LENGTH_SHORT);

        toast.show();
    }


    public void countUp() {
        mCount++;

        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

}
