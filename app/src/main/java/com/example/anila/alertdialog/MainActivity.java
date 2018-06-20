package com.example.anila.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    AlertDialog.Builder builder;
    //private int[] country;
    String[] country = {"India", "USA", "China", "Japan", "Other"};
    String[] language={"C","C++","Java","Python"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to continue").setTitle("Dialog Example");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MainActivity.this, "You chose the YES", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
                Toast.makeText(MainActivity.this, "You chose NO", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Yellow");
        categories.add("Red");
        categories.add("greeen");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,language);
        AutoCompleteTextView ac=findViewById(R.id.autoCompleteTextView);
        ac.setThreshold(1);
        ac.setAdapter(data);
        //ac.setTextColor(android.R.color.holo_red_light);
        }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
    }
}



