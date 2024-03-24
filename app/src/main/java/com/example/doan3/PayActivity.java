package com.example.doan3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PayActivity extends AppCompatActivity {
    Button btnback, btnout;
    ImageView img1, img2, img3, img4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Button bntPay;
        TextView tvservicepay,tvcode,tvtimeArrival,tvprice,tvprice1,tvprice2,tvtime,tvdepartDate,tvdepartPlace,tvnameplane,tvarrivalPlace,tvdepartDate1;
        String priceservice=getIntent().getStringExtra("PriceService");
        String pricetotal=getIntent().getStringExtra("pricetotal");
        String price =getIntent().getStringExtra("Price");
        String dateDepart = getIntent().getStringExtra("dateDepart");
        String arrivalPlace = getIntent().getStringExtra("arrivalPlace");
        String departPlace = getIntent().getStringExtra("departPlace");
        String namePlane = getIntent().getStringExtra("namePlane");
        String Nameservice = getIntent().getStringExtra("Nameservice");
        String time = getIntent().getStringExtra("time");
        String timeArrival = getIntent().getStringExtra("timeArrival");
        String tvLastname =getIntent().getStringExtra("tvLastname");
        String tvFistname =getIntent().getStringExtra("tvFistname");
        String code = getIntent().getStringExtra("code");

        tvprice=findViewById(R.id.tvpricepay);
        tvprice1=findViewById(R.id.tvpricepay1);
        tvprice2=findViewById(R.id.tvpricepay2);
        tvtime=findViewById(R.id.tvtimepay);
        tvdepartDate=findViewById(R.id.tvDatepay);
        tvdepartDate1=findViewById(R.id.tvDate2pay);
        tvdepartPlace=findViewById(R.id.tvdepartPlacepay);
        tvnameplane=findViewById(R.id.txtnameAirplanepay);
        tvarrivalPlace=findViewById(R.id.tvarrivalPlacepay);
        tvtimeArrival=findViewById(R.id.timeArrivalpay);
        bntPay=findViewById(R.id.btnpayticket);
        tvcode=findViewById(R.id.txtcodepay);
        tvservicepay=findViewById(R.id.servicepay);
//
        tvprice.setText(pricetotal);
        tvprice1.setText(price+"/Vé");
        tvprice2.setText(price);
        tvservicepay.setText(priceservice);
        tvtime.setText(time);
        tvdepartDate.setText(dateDepart);
        tvdepartDate1.setText(dateDepart);
        tvarrivalPlace.setText(arrivalPlace);
        tvnameplane.setText(namePlane);
        tvdepartPlace.setText(departPlace);
        tvtimeArrival.setText(timeArrival);
        tvcode.setText(code+" ~ ");
        if(priceservice==null)
        {
            tvservicepay.setText("0");
        }
        else {
            tvservicepay.setText(priceservice);
        }
        if(pricetotal==null)
        {
            tvprice.setText(price);
        }
        else {
            tvprice.setText(pricetotal);
        }
        bntPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference historyRef = database.getReference("History");

                Map<String, Object> history = new HashMap<>();
                if(pricetotal==null)
                {
                    history.put("price", price);
                }
                else {
                    history.put("price", pricetotal);
                }
                history.put("PriceService",priceservice);
                history.put("dateDepart", dateDepart);
                history.put("arrivalPlace", arrivalPlace);
                history.put("departPlace", departPlace);
                history.put("namePlane", namePlane);
                history.put("Nameservice", Nameservice);
                history.put("time", time);
                history.put("timeArrival", timeArrival);
                history.put("firstnameHis", tvLastname);
                history.put("lastnameHis", tvFistname);
                history.put("code_History","HIS");
                history.put("code",code);
                historyRef.push().setValue(history);
                Intent intent = new Intent(PayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnout = findViewById(R.id.outinput);
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img1 = findViewById(R.id.img1ticket);
        img2 = findViewById(R.id.img2ticket);
        img3 = findViewById(R.id.img3ticket);
        img4 = findViewById(R.id.img4ticket);
    }
    public void ChangeColor(int color1, int color2, int color3, int color4) {
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
        img4.setBackgroundResource(color4);
    }
}