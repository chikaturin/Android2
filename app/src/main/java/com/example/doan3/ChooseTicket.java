package com.example.doan3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan3.Adapter.TicketAdapter;
import com.example.doan3.Model.TicketNomal;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChooseTicket extends AppCompatActivity {

    RecyclerView recyclerView;
    TicketAdapter ticketAdapter;
    ArrayList<TicketNomal> arr_ticket;
    LinearLayout nomalticket, vipticket, lnmain;
    TextView text, text1, text2, text3;
    Color color;
    Button btnback,btnout,btnInforUser;
    ImageView img1,img2,img3,img4;

    String ngayDi,noiDi,noiDen;
    TextView txttottalprice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);

        String price = getIntent().getStringExtra("Price");
        float pricecacul = getIntent().getFloatExtra("Pricecacul",0);
        String dateDepart=getIntent().getStringExtra("dateDepart");
        String arrivalPlace=getIntent().getStringExtra("arrivalPlace");
        String departPlace=getIntent().getStringExtra("departPlace");
        String namePlane=getIntent().getStringExtra("namePlane");
        String time=getIntent().getStringExtra("time");
        String timeArrival=getIntent().getStringExtra("timeArrival");
        String code=getIntent().getStringExtra("code");
        SharedPreferences sharedPreferences = getSharedPreferences("ticket_dataa", Context.MODE_PRIVATE);
        String arrivalplace = sharedPreferences.getString("Arrivalplace"," ");
        String date = sharedPreferences.getString("Date"," ");
        String departplace = sharedPreferences.getString("Departplace"," ");


        //code cua trong
        Intent i = getIntent();
        Bundle b = i.getExtras();
        //

        addControls();
        loadData(date,departplace,arrivalplace);
        txttottalprice=findViewById(R.id.tvtotalprice);
        txttottalprice.setText(price);

        btnout = findViewById(R.id.outinput);
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTicket.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnInforUser = findViewById(R.id.btninforuser);
        btnInforUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txttottalprice.getText().toString().isEmpty())
                {
                    ChangeColor(R.drawable.circle_gray, R.drawable.circle, R.drawable.circle_gray,R.drawable.circle_gray);
                    Intent intent =new Intent(ChooseTicket.this, InforUserTicketActivity.class);
                    intent.putExtra("Price",price);
                    intent.putExtra("Pricecacul",pricecacul);
                    intent.putExtra("dateDepart",dateDepart);
                    intent.putExtra("arrivalPlace",arrivalPlace);
                    intent.putExtra("departPlace",departPlace);
                    intent.putExtra("namePlane",namePlane);
                    intent.putExtra("time",time);
                    intent.putExtra("timeArrival",timeArrival);
                    intent.putExtra("code",code);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng chọn vé", Toast.LENGTH_SHORT).show();
                }
            }
        });

        text = findViewById(R.id.textticket);
        text1 = findViewById(R.id.textticket1);
        text2 = findViewById(R.id.textticket2);
        text3 = findViewById(R.id.textticket3);
        vipticket = findViewById(R.id.vipticket);
        nomalticket = findViewById(R.id.nomalticket);

        vipticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmain = findViewById(R.id.lmnomalticket);
                lnmain.setBackgroundColor(color.parseColor("#DAA20D"));
                text.setTextColor(color.parseColor("#ABD1BC"));
                text1.setTextColor(color.parseColor("#ABD1BC"));
                text2.setTextColor(color.parseColor("#FFFFFF"));
                text3.setTextColor(color.parseColor("#FFFFFF"));
                text1.setBackgroundColor(color.parseColor("#DAA20D"));
                text3.setBackgroundDrawable(getResources().getDrawable(R.drawable.underline3));
            }
        });

        nomalticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnmain = findViewById(R.id.lmnomalticket);
                lnmain.setBackgroundColor(color.parseColor("#005E79"));
                text2.setTextColor(color.parseColor("#ABD1BC"));
                text3.setTextColor(color.parseColor("#ABD1BC"));
                text.setTextColor(color.parseColor("#FFFFFF"));
                text1.setTextColor(color.parseColor("#FFFFFF"));
                text1.setBackgroundDrawable(getResources().getDrawable(R.drawable.underline2));
                text3.setBackgroundColor(color.parseColor("#005E79"));
            }
        });
    }
    private void loadData(String ngayDi,String noiDi,String noiDen) {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("list_Flight");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                TicketNomal ticketNomal=snapshot.getValue(TicketNomal.class);
                if (ticketNomal != null){
                    if(ticketNomal.getDateDepart().equals(ngayDi) && ticketNomal.getDepartPlace().equals(noiDi) && ticketNomal.getArrivalPlace().equals(noiDen)){
                        arr_ticket.add(ticketNomal);
                    }
                    ticketAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot:snapshot.getChildren())
//                {
//                    TicketNomal ticketNomal=dataSnapshot.getValue(TicketNomal.class);
//                    arr_ticket.add(ticketNomal);
//                }
//                ticketAdapter.notifyDataSetChanged();
//            }
        });
    }

    private void addControls() {
        recyclerView = findViewById(R.id.recycleview);
        arr_ticket = new ArrayList<>();
        ticketAdapter = new TicketAdapter(this, arr_ticket,ngayDi,noiDen,noiDi);
        recyclerView.setAdapter(ticketAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    void ChangeColor(int color1,int color2, int color3,int color4){
        img1 =findViewById(R.id.img1ticket);
        img2 =findViewById(R.id.img2ticket);
        img3 =findViewById(R.id.img3ticket);
        img4 =findViewById(R.id.img4ticket);
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
        img4.setBackgroundResource(color4);
    }
}
