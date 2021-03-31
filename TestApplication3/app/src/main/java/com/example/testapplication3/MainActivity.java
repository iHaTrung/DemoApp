package com.example.testapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testapplication3.adapter.StudentAdapter;
import com.example.testapplication3.databinding.ActivityMainBinding;
import com.example.testapplication3.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Student> listStudent;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listStudent = new ArrayList<>();
        listStudent.add(new Student("4","Nguyen Van D", "Nam","31/03/2021"));
        listStudent.add(new Student("1","Nguyen Van A", "Nam","31/03/2021"));
        listStudent.add(new Student("2","Nguyen Van B", "Nam","31/03/2021"));
        listStudent.add(new Student("3","Nguyen Van C", "Nam","31/03/2021"));

        StudentAdapter adapter = new StudentAdapter(this,listStudent);
        recyclerView.setAdapter(adapter);

        binding.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listStudent.size() > 0) {
                    //Xoá phần tử đầu tiên của danh sách
                    int productpost = 0;
                    listStudent.remove(productpost);
                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
                }
            }
        });

        binding.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(nextScreen);
            }
        });

    }
}