package com.example.testapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.testapplication3.databinding.ActivityAddStudentBinding;

import java.util.Calendar;

public class AddStudentActivity extends AppCompatActivity {

    ActivityAddStudentBinding binding;
    Calendar c;
    DatePickerDialog dpd;

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
    }
}