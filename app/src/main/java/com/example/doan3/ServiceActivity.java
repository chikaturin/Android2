package com.example.doan3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan3.Adapter.ServiceAdapter;
import com.example.doan3.Model.Servicemodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    Button btnpay;
    Button btnback, btnout;

    TextView price_Service;
    RecyclerView recyclerView;
    ServiceAdapter serviceAdapter;
    ArrayList<Servicemodel> arr_service;
    TextView decription;
    ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        String price = getIntent().getStringExtra("Price");
        String pricetotal=getIntent().getStringExtra("Pricecacula");
        String priceservice=getIntent().getStringExtra("PriceService");
        String dateDepart=getIntent().getStringExtra("dateDepart");
        String arrivalPlace=getIntent().getStringExtra("arrivalPlace");
        String departPlace=getIntent().getStringExtra("departPlace");
        String namePlane=getIntent().getStringExtra("namePlane");
        String nameservice=getIntent().getStringExtra("name");
        String time=getIntent().getStringExtra("time");
        String timeArrival=getIntent().getStringExtra("timeArrival");
        String code=getIntent().getStringExtra("code");
        String tvLastname =getIntent().getStringExtra("tvLastname");
        String tvFistname =getIntent().getStringExtra("tvFistname");
        float pricecacul = getIntent().getFloatExtra("Pricecacul", 0);

        recyclerView = findViewById(R.id.recycleservice);
        arr_service = new ArrayList<>();
        serviceAdapter = new ServiceAdapter(this, arr_service,pricecacul,namePlane,dateDepart,time,arrivalPlace,departPlace,code,timeArrival,tvFistname,tvLastname,price);
        recyclerView.setAdapter(serviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference();
        databaseReference.child("serviceList/FD01/information").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string=snapshot.getValue(String.class);
                decription=findViewById(R.id.tvdecriptiona);
                decription.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        price_Service=findViewById(R.id.priceservicea);
        if(pricetotal==null)
        {
            price_Service.setText(price);
        }
        else {
            price_Service.setText(pricetotal);
        }
        btnpay = findViewById(R.id.btnpayofservice);
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, PayActivity.class);
                intent.putExtra("pricetotal",pricetotal);
                intent.putExtra("PriceService",priceservice);
                intent.putExtra("Price",price);
                intent.putExtra("Pricecacul",pricecacul);
                intent.putExtra("dateDepart",dateDepart);
                intent.putExtra("arrivalPlace",arrivalPlace);
                intent.putExtra("departPlace",departPlace);
                intent.putExtra("namePlane",namePlane);
                intent.putExtra("time",time);
                intent.putExtra("timeArrival",timeArrival);
                intent.putExtra("code",code);
                intent.putExtra("tvLastname",tvLastname);
                intent.putExtra("tvFistname",tvFistname);
                intent.putExtra("Nameservice",nameservice);
                ChangeColor(R.drawable.circle_gray, R.drawable.circle_gray, R.drawable.circle_gray,R.drawable.circle    );
                startActivity(intent);
            }
        });

        btnout = findViewById(R.id.outinputif);
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        img1 = findViewById(R.id.img1ticket);
        img2 = findViewById(R.id.img2ticket);
        img3 = findViewById(R.id.img3ticket);
        img4 = findViewById(R.id.img4ticket);
    }
    private void loadData() {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("serviceList");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Servicemodel servicemodel=dataSnapshot.getValue(Servicemodel.class);
                    arr_service.add(servicemodel);
                }
                serviceAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void ChangeColor(int color1, int color2, int color3, int color4) {
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
        img4.setBackgroundResource(color4);
    }
}