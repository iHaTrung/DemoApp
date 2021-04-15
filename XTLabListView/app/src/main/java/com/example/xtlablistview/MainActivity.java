package com.example.xtlablistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xtlablistview.adapter.StudentListViewAdapter;
import com.example.xtlablistview.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> listStudent;
    Student newStudent;
    String newID, newName, newGender, newDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        newID = intent.getStringExtra(AddStudentActivity.ID);
        newName = intent.getStringExtra(AddStudentActivity.NAME);
        newGender = intent.getStringExtra(AddStudentActivity.GENDER);
        newDate = intent.getStringExtra(AddStudentActivity.DATE);

        newStudent = new Student(newID,newName,newGender, newDate);

        listStudent = new ArrayList<>();


        listStudent.add(new Student("1","Nguyen Van A", "Nam","31/03/2021"));
        listStudent.add(new Student("2","Nguyen Van B", "Nam","31/03/2021"));
        listStudent.add(new Student("3","Nguyen Van C", "Nu","31/03/2021"));
        listStudent.add(new Student("4","Nguyen Van D", "Nu","31/03/2021"));
        listStudent.add(new Student("5","Nguyen Van E", "Nam","31/03/2021"));
        listStudent.add(new Student("6","Nguyen Van F", "Nam","31/03/2021"));
        listStudent.add(new Student("7","Nguyen Van G", "Nu","31/03/2021"));
        listStudent.add(new Student("8","Nguyen Van H", "Nam","31/03/2021"));
        listStudent.add(new Student("9","Nguyen Van I", "Nu","31/03/2021"));
        listStudent.add(new Student("10","Nguyen Van J", "Nam","31/03/2021"));
        listStudent.add(new Student("11","Nguyen Van K", "Nam","31/03/2021"));
        if(newStudent.getId()!=null){
            listStudent.add(newStudent);
        }


        StudentListViewAdapter studentListViewAdapter = new StudentListViewAdapter(listStudent);

        ListView listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(studentListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               listStudent.remove(position);
               studentListViewAdapter.notifyDataSetChanged();
            }
        });


        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addScreen = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(addScreen);
            }
        });
    }
}