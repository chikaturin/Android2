package com.example.doan3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    Button btnAirplane,btnAirplane1;
    TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gán tham chiếu của Button và TextView từ layout XML
        btnAirplane = findViewById(R.id.btnairplane);
        a = findViewById(R.id.aaa);

        // Xử lý sự kiện khi nút được nhấn
        btnAirplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khởi chạy hoạt động mới khi nút được nhấn
                Intent intent = new Intent(MainActivity.this, Timve_mc.class);
                startActivity(intent);
            }
        });
        btnAirplane1=findViewById(R.id.btnairplane1);
        btnAirplane1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });
    }
    void test(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference();
        databaseReference.child("DSChuyenBay/NoiDen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string=snapshot.getValue(String.class);
                a=findViewById(R.id.aaa);
                a.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}