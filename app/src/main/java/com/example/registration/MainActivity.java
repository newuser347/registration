package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView welcomeMemeber;
    TextView hours,fees;
    ArrayList<course> courseList = new ArrayList<>();
    ArrayList<String> courseTitle = new ArrayList<>();
    Spinner sp;
    RadioButton rb1, rb2;
    CheckBox ch1,ch2;
    Button add;
    public static double totalfees =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeMemeber=findViewById(R.id.welcomeMsg);
        welcomeMemeber.setText("Welcome back Sai");
        sp=findViewById(R.id.courseSp);
        fees=findViewById(R.id.shfee);
        hours=findViewById(R.id.shhrs);
        rb1=findViewById(R.id.rbg);
        rb2=findViewById(R.id.rbug);
        ch1=findViewById(R.id.cbAc);
        ch2=findViewById(R.id.cbMi);
        fillData();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,courseTitle);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(this);
        fees.setText(String.valueOf(courseList.get(0).getcFees()));

        hours.setText(String.valueOf(courseList.get(0).getcHours()));
        rb1.setOnClickListener(new RadioButtonsAction());
        rb2.setOnClickListener(new RadioButtonsAction());

        ch1.setOnCheckedChangeListener(new CheckBoxActions());
        ch2.setOnCheckedChangeListener(new CheckBoxActions());

    }

    public void fillData() {
        courseList.add(new course("Java", 6, 1300));
        courseList.add(new course("Swift", 5, 1500));
        courseList.add(new course("iOS", 5, 1350));
        courseList.add(new course("Android", 7, 1400));
        courseList.add(new course("Database", 4, 1000));
        for(int i = 0; i< courseList.size(); i++){
            courseTitle.add(courseList.get(i).getcName());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        fees.setText(String.valueOf(courseList.get(i).getcFees()));
        hours.setText(String.valueOf(courseList.get(i).getcHours()));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class RadioButtonsAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    private class CheckBoxActions implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            if(compoundButton.getId()==R.id.cbAc)
                if(ch1.isChecked())
                    totalfees+=1000;
                else
                    totalfees-=1000;
            if(compoundButton.getId()==R.id.cbMi)
                if(ch2.isChecked())
                    totalfees+=700;
                else
                    totalfees-=700;
        }
    }
}