package com.example.doan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan3.Fragment.InputInforUserTicKet;
import com.example.doan3.Fragment.NomalTicket;
import com.example.doan3.Fragment.Pay_Fragment;

public class ChooseTicket extends AppCompatActivity {

    Fragment fragment;
    TextView test;
    Button btnback,btnout;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fmticket1, NomalTicket.class,null);
//        String testa=getIntent().getStringExtra("Price");
//        test=findViewById(R.id.testactivity);
//        test.setText(testa);

        transaction.commit();
        btnback=findViewById(R.id.btnbackinticket);
        btnout=findViewById(R.id.outinput);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fmticket1);
                if (currentFragment instanceof NomalTicket) {
                    finish();
                }
                else if (currentFragment instanceof InputInforUserTicKet) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, NomalTicket.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle);
                    img2.setBackgroundResource(R.drawable.circle_gray);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }

                else if (currentFragment instanceof Pay_Fragment) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, InputInforUserTicKet.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle_gray);
                    img2.setBackgroundResource(R.drawable.circle);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void ChangeColor(int color1,int color2, int color3){
        img1 =findViewById(R.id.img1ticket);
        img2 =findViewById(R.id.img2ticket);
        img3 =findViewById(R.id.img3ticket);
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
    }
}