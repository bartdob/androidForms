package com.example.androidforms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView backArrow, settings, voice, cart;
    private EditText nameEdtTxt, emailEdtTxt, descriptionEdtTxt, websiteEdtTxt;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Button btnFinish;

    private String country = "";
    private ArrayList<String> countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("UK");
        countries.add("Rusia");
        countries.add("Portugies");
        countries.add("Spain");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
        spinner.setAdapter(adapter);

        initOnClickListeners ();

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishRegistering();
            }
        });
    }

    private void initWidget(){
        backArrow = (ImageView) findViewById(R.id.backArrow);
        settings = (ImageView) findViewById(R.id.settings);
        voice = (ImageView) findViewById(R.id.voice);
        cart = (ImageView) findViewById(R.id.cart);

        nameEdtTxt = (EditText) findViewById(R.id.nameEdtTxt);
        emailEdtTxt = (EditText) findViewById(R.id.emailEdtTxt);
        descriptionEdtTxt = (EditText) findViewById(R.id.descriptionEdtText);
        websiteEdtTxt = (EditText) findViewById(R.id.websiteEdtTxt);

        spinner = (Spinner) findViewById(R.id.countrySpinner);

        radioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        btnFinish = (Button) findViewById(R.id.btnFinish);
    }

    private void finishRegistering(){
        String name = nameEdtTxt.getText().toString();
        String email = emailEdtTxt.getText().toString();
        String describtion = descriptionEdtTxt.getText().toString();
        String website = websiteEdtTxt.getText().toString();

        String gender = "";
        int checkedRb = radioGroup.getCheckedRadioButtonId();
        switch (checkedRb){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Ohter";
                break;
            default:
                break;

        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country =  countries.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country = "No Country Selected";
            }
        });

        String finalMessage = "Name: " + name + "\nEmail: " + email + "\nDescription: " + describtion + "\nWebsite: " + website;
        Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show();
        )

    }
    private void initOnClickListeners (){
            backArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "back arrow tapped", Toast.LENGTH_LONG).show();
                }
            });

            settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "settings tapped", Toast.LENGTH_LONG).show();
                }
            });

            voice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Voice Selected", Toast.LENGTH_SHORT).show();
                }
            });

            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Cart Selected", Toast.LENGTH_SHORT).show();
                }
            });
    }
}

