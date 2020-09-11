package com.example.hw222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class TaskTimeActivity extends AppCompatActivity {
    private Button chooseStartDate;
    private Button chooseEndDate;
    private CalendarView startDateCalendar;
    private CalendarView endtDateCalendar;
    private Button btnOK;
    private long startDate;
    private String startDateTxt;
    private long endDate;
    private String endDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_time);
        init();
    }

    private void init() {
        chooseStartDate = findViewById(R.id.chooseStartDate);
        chooseEndDate = findViewById(R.id.chooseEndDate);
        startDateCalendar = findViewById(R.id.startDateCalendar);
        endtDateCalendar = findViewById(R.id.endtDateCalendar);
        btnOK = findViewById(R.id.btnOK);

        // Скроем календари при запуске приложения
        startDateCalendar.setVisibility(View.GONE);
        endtDateCalendar.setVisibility(View.GONE);

        chooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDateCalendar.setVisibility(View.VISIBLE);
                endtDateCalendar.setVisibility(View.GONE);
            }
        });

        chooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endtDateCalendar.setVisibility(View.VISIBLE);
                startDateCalendar.setVisibility(View.GONE);
            }
        });

        startDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                int m = month + 1;
                startDateTxt = year +"-"+ m +"-"+ day;
                chooseStartDate.setText(getString(R.string.txtStartDate, startDateTxt));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, m, day);
                startDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        endtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                int m = month + 1;
                endDateTxt = year + "-"+ m +"-"+ day;
                chooseEndDate.setText(getString(R.string.txtEndDate, endDateTxt));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, m, day);
                endDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startDate > endDate){
                    Toast.makeText(TaskTimeActivity.this, R.string.toastError, Toast.LENGTH_LONG).show();
                    chooseStartDate.setText(R.string.chooseStartDate);
                    chooseEndDate.setText(R.string.chooseEndDate);
                } else {
                    Toast.makeText(TaskTimeActivity.this,
                            getString(R.string.toastStartEnd, startDateTxt, endDateTxt), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}