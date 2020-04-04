package com.example.ge_android_vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);




        Spinner spinner =  findViewById(R.id.spn_extra_item_option);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> parentAdapterView, View view, int position, long id) {
        String spinnerLabel = parentAdapterView.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_main:
                if (checked)
                    // Same day service
                    displayToast("Main Item");
                break;
            case R.id.rb_beverage:
                if (checked)
                    // Next day delivery
                    displayToast("Beverage");
                break;
            case R.id.rb_extra_side:
                if (checked)
                    // Pick up
                    displayToast("Extra Or Side");
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


}
