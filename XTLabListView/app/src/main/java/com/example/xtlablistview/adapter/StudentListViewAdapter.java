package com.example.xtlablistview.adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.xtlablistview.R;
import com.example.xtlablistview.model.Student;

import java.util.ArrayList;

public class StudentListViewAdapter extends BaseAdapter {

    final ArrayList<Student> listStudent;

    public StudentListViewAdapter(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }


    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return listStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(listStudent.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.student_view, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Student student = (Student) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.studentname)).setText(student.getName());
        ((TextView) viewProduct.findViewById(R.id.studentdate)).setText(student.getDate());
        return viewProduct;
    }
}
