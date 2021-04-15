package com.example.xtlablistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.xtlablistview.databinding.ActivityAddStudentBinding;

import java.util.Calendar;

public class AddStudentActivity extends AppCompatActivity {

    ActivityAddStudentBinding binding;
    Calendar c;
    DatePickerDialog dpd;
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String DATE = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.addDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddStudentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                        binding.addDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }

                }, day, month, year);

                dpd.show();
                final Calendar c = Calendar.getInstance();
            }
        });

        binding.btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    byExtras();
            }
        });
    }

    public void byExtras(){
        Intent intent = new Intent(AddStudentActivity.this,MainActivity.class);
        intent.putExtra(ID,binding.addID.getText().toString());
        intent.putExtra(NAME,binding.addName.getText().toString());
        intent.putExtra(GENDER,binding.addGender.getText().toString());
        intent.putExtra(DATE,binding.addDate.getText().toString());
        startActivity(intent);
    }
}