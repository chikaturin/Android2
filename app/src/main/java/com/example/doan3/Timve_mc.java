package com.example.doan3;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timve_mc extends AppCompatActivity {

    EditText etngayve,etNoiden,etNoidi;
    TextView etngaydi;
    Button btnmc,btnTimVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timve_mc);
        etngaydi = (TextView) findViewById(R.id.et_Ngaydi);
        etNoidi = (EditText) findViewById(R.id.etNoidi);
        etNoiden = (EditText) findViewById(R.id.etNoiden);
        etngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgayDi();
            }
        });

        btnTimVe = (Button) findViewById(R.id.TimVe);
        btnTimVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Timve_mc.this , ChooseTicket.class);
                Bundle b = new Bundle();
                b.putString("NgayDi",etngaydi.getText().toString());
                b.putString("NoiDi",etNoidi.getText().toString());
                b.putString("NoiDen",etNoiden.getText().toString());

                SharedPreferences sharedPreferences = getSharedPreferences("ticket_dataa", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Arrivalplace", etNoiden.getText().toString());
                editor.putString("Date", etngaydi.getText().toString());
                editor.putString("Departplace",etNoidi.getText().toString());

                editor.apply();
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
    private void ChonNgayDi(){
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                etngaydi.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,date);
        datePickerDialog.show();
    }

    private void ChonNgayVe() {
        Calendar calendar = Calendar.getInstance();
        int dateVe = calendar.get(Calendar.DATE);
        int monthVe = calendar.get(Calendar.MONTH);
        int yearVe = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                if (selectedDate.before(calendar)) {
                    // The return date is before the departure date
                    // You can show an error message or handle it as per your requirement
                    Toast.makeText(getApplicationContext(), "Ngày về phải lớn hơn ngày đi", Toast.LENGTH_SHORT).show();
                } else {
                    calendar.set(year, month, dayOfMonth);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    etngayve.setText(simpleDateFormat.format(calendar.getTime()));
                }
            }
        }, yearVe, monthVe, dateVe);
        datePickerDialog.show();
    }
}