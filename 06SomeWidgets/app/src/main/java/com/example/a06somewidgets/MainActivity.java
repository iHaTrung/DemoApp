package com.example.a06somewidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import com.example.a06somewidgets.databinding.ActivityMainBinding;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.cbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.cbFemale.setChecked(false);
                }
            }
        });

        binding.cbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.cbMale.setChecked(false);
                }
            }
        });

        binding.spinnerCountry.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.country)));
        binding.spinnerUni.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.university)));

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPlatform = "";
                if (binding.cbIphone.isChecked()){
                    strPlatform += binding.cbIphone.getText();
                }
                if (binding.cbAndroid.isChecked()){
                    strPlatform += ", " + binding.cbAndroid.getText();
                }
                if (binding.cbWindowmobile.isChecked()){
                    strPlatform += ", " + binding.cbWindowmobile.getText() + " ";
                }
                binding.platform.setText("Platform: " + strPlatform );

                String strGender = "";
                if (binding.cbMale.isChecked()){
                    strGender += binding.cbMale.getText();
                }
                if (binding.cbFemale.isChecked()){
                    strPlatform += binding.cbFemale.getText();
                }
                binding.gender.setText("Gender: " + strGender);

                binding.rate.setText("Rate: " + String.valueOf(binding.ratingbar.getRating()));

                binding.country.setText("Country: " + binding.spinnerCountry.getSelectedItem().toString());

                binding.university.setText("My university: " + binding.spinnerUni.getSelectedItem().toString());

                String strFavo = "";
                if (binding.cbTennis.isChecked()){
                    strFavo += binding.cbTennis.getText();
                }
                if (binding.cbRunning.isChecked()){
                    strFavo += ", " + binding.cbRunning.getText();
                }
                if (binding.cbSwimming.isChecked()){
                    strFavo += ", " + binding.cbSwimming.getText();
                }
                if (binding.cbSleeping.isChecked()){
                    strFavo += ", " + binding.cbSleeping.getText();
                }
                if (binding.cbReading.isChecked()){
                    strFavo += ", " + binding.cbReading.getText();
                }
                binding.favorite.setText("My favorite: " + strFavo);
            }
        });
    }

}