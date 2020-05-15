package com.example.androidforms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ImageView backArrow, settings, voice, cart;
    private EditText nameEdtTxt, emailEdtTxt, descriptionEdtTxt, websiteEdtTxt;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
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
}
