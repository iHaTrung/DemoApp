package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.testapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        binding.btnDientich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chieudai = binding.chieudai.getText().toString();
                double a = Double.parseDouble(chieudai);
                String chieurong = binding.chieurong.getText().toString();
                double b = Double.parseDouble(chieurong);
                String chieucao = binding.chieucao.getText().toString();
                double c = Double.parseDouble(chieucao);

                double s = 2*(a*b+a*c+b*c);

                binding.ketqua.setText(String.valueOf(s));
            }
        });

        binding.btnThetich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chieudai = binding.chieudai.getText().toString();
                double a = Double.parseDouble(chieudai);
                String chieurong = binding.chieurong.getText().toString();
                double b = Double.parseDouble(chieurong);
                String chieucao = binding.chieucao.getText().toString();
                double c = Double.parseDouble(chieucao);

                double thetich = a*b*c;

                binding.ketqua.setText(String.valueOf(thetich));
            }
        });
    }
}