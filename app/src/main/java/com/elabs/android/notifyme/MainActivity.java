package com.elabs.android.notifyme;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView dateView, timeView, d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int year, month, date, hours, minutes;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);

        Date time = calendar.getTime();
        hours= time.getHours();
        minutes = time.getMinutes();

        //Button button = (Button)findViewById(R.id.button);
        dateView = (TextView)findViewById(R.id.date_view);
        timeView = (TextView)findViewById(R.id.time_view);
        showDate(year, month, date);

        showTime(hours, minutes);
    }

    /**
     * Opens the DatePicker Dailog and sets the chosen date to the dateView textview
     *@param year the initial year to be display in the datePicker
     *@param month the initial month to be display in the datePicker
     *@param date the initial date to be display in the datePicker
     */
    public void showDate(int year, int month, int date)
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                dateView.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, date);

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });




    }

    /**
     * Opens the TimePicker Dailog and sets the chosen date to the dateView textview
     *@param hours the initial hours to be display in the timePicker
     *@param minutes the initial month to be display in the timePicker
     */

    public void showTime(int hours, int minutes)
    {

        TimePickerDialog.OnTimeSetListener timeChangedListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeView.setText(hourOfDay+":"+minute);
            }
        };
        final TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeChangedListener,hours, minutes, true );

        timeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
    }


}
