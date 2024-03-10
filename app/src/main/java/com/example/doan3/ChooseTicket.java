package com.example.doan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.doan3.Fragment.ChooseAirPlane;

public class ChooseTicket extends AppCompatActivity {

    Fragment fragment;
    Button btnback,btnout;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fmticket1, ChooseAirPlane.class,null);
        transaction.commit();
        btnback=findViewById(R.id.btnbackinticket);
        btnout=findViewById(R.id.btnout);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fmticket1);
                if (currentFragment instanceof ChooseAirPlane) {
                    finish();
                } /*else if (currentFragment instanceof InforUserOfTicket) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, FirstChooseFragment.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle);
                    img2.setBackgroundResource(R.drawable.circle_gray);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }
                else if (currentFragment instanceof PayTicket) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, InforUserOfTicket.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle_gray);
                    img2.setBackgroundResource(R.drawable.circle);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }*/
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