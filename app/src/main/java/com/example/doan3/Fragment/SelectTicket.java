package com.example.doan3.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.doan3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectTicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectTicket extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectTicket() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectTicket.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectTicket newInstance(String param1, String param2) {
        SelectTicket fragment = new SelectTicket();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private double price;

    public static SelectTicket Price(double price) {
        SelectTicket fragment = new SelectTicket();
        Bundle args = new Bundle();
        args.putDouble("price", price);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fmticketchoose,NomalTicket.class, null);
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_ticket, container, false);
    }
    LinearLayout nomalticket,vipticket,lnmain;
    View view=getView();
    Color color;
    TextView text,text1,text2,text3,Txttotalprice;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if(view != null) {
            Txttotalprice=view.findViewById(R.id.txttotalprice);
            text=view.findViewById(R.id.textticket);
            text1=view.findViewById(R.id.textticket1);
            text2=view.findViewById(R.id.textticket2);
            text3=view.findViewById(R.id.textticket3);
            vipticket = view.findViewById(R.id.vipticket);
            if (getArguments() != null) {
                price = getArguments().getDouble("price");
                Txttotalprice.setText("AAAA"); // Chuyển price thành chuỗi trước khi hiển thị
            }
            vipticket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lnmain = view.findViewById(R.id.lmnomalticket);
                    lnmain.setBackgroundColor(color.parseColor("#DAA20D"));
                    text.setTextColor(color.parseColor("#ABD1BC"));
                    text1.setTextColor(color.parseColor("#ABD1BC"));
                    text2.setTextColor(color.parseColor("#FFFFFF"));
                    text3.setTextColor(color.parseColor("#FFFFFF"));
                    text1.setBackgroundColor(color.parseColor("#DAA20D"));
                    text3.setBackgroundDrawable(getResources().getDrawable(R.drawable.underline3));
                    Fragment selectedFragment = null;
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticketchoose, VipTicket.class, null);
                    transaction.commit();
                }
            });
            nomalticket = view.findViewById(R.id.nomalticket);
            nomalticket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lnmain = view.findViewById(R.id.lmnomalticket);
                    lnmain.setBackgroundColor(color.parseColor("#005E79"));
                    text2.setTextColor(color.parseColor("#ABD1BC"));
                    text3.setTextColor(color.parseColor("#ABD1BC"));
                    text.setTextColor(color.parseColor("#FFFFFF"));
                    text1.setTextColor(color.parseColor("#FFFFFF"));
                    text1.setBackgroundDrawable(getResources().getDrawable(R.drawable.underline2));
                    text3.setBackgroundColor(color.parseColor("#005E79"));
                    Fragment selectedFragment = null;
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticketchoose, NomalTicket.class, null);
                    transaction.commit();
                }
            });
        }
    }
}