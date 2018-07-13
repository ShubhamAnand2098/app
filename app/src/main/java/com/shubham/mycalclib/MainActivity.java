package com.shubham.mycalclib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.shubham.mycalc.CalcAdd;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "" + CalcAdd.Add(10, 20), Toast.LENGTH_SHORT).show();
        CalcAdd a = new CalcAdd();
    }
}
