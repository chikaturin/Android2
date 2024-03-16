package com.example.doan3.Fragment;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan3.History;
import com.example.doan3.MainActivity;
import com.example.doan3.Model.InforUserTicket;
import com.example.doan3.Model.TicketHis;
import com.example.doan3.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pay_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pay_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Pay_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pay_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Pay_Fragment newInstance(String param1, String param2) {
        Pay_Fragment fragment = new Pay_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
    }
    Button bntPay;
    TextView tvcode,tvtimeArrival,tvprice,tvprice1,tvprice2,tvtime,tvdepartDate,tvdepartPlace,tvnameplane,tvarrivalPlace,tvdepartDate1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pay_, container, false);
        if(view!=null)
        {
            String price = getArguments().getString("Price");
            String dateDepart = getArguments().getString("dateDepart");
            String arrivalPlace = getArguments().getString("arrivalPlace");
            String departPlace = getArguments().getString("departPlace");
            String namePlane = getArguments().getString("namePlane");
            String time = getArguments().getString("time");
            String timeArrival = getArguments().getString("timeArrival");
            String tvLastname = getArguments().getString("tvLastname");
            String tvFistname = getArguments().getString("tvFistname");
            String code = getArguments().getString("code");


            tvprice=view.findViewById(R.id.tvpricepay);
            tvprice1=view.findViewById(R.id.tvpricepay1);
            tvprice2=view.findViewById(R.id.tvpricepay2);
            tvtime=view.findViewById(R.id.tvtimepay);
            tvdepartDate=view.findViewById(R.id.tvDatepay);
            tvdepartDate1=view.findViewById(R.id.tvDate2pay);
            tvdepartPlace=view.findViewById(R.id.tvdepartPlacepay);
            tvnameplane=view.findViewById(R.id.txtnameAirplanepay);
            tvarrivalPlace=view.findViewById(R.id.tvarrivalPlacepay);
            tvtimeArrival=view.findViewById(R.id.timeArrivalpay);
            bntPay=view.findViewById(R.id.btnpayticket);
            tvcode=view.findViewById(R.id.txtcodepay);

            tvprice.setText(price);
            tvprice1.setText(price+"/Vé");
            tvprice2.setText(price);
            tvtime.setText(time);
            tvdepartDate.setText(dateDepart);
            tvdepartDate1.setText(dateDepart);
            tvarrivalPlace.setText(arrivalPlace);
            tvnameplane.setText(namePlane);
            tvdepartPlace.setText(departPlace);
            tvtimeArrival.setText(timeArrival);
            tvcode.setText(code+" ~ ");
            bntPay.setOnClickListener(new View.OnClickListener() {
                int i=0;
                @Override
//                namePlane,dateDepart,time,arrivalPlace,departPlace,price,"",tvFistname,tvLastname,timeArrival
                public void onClick(View v) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference historyRef = database.getReference("History");

                    Map<String, Object> history = new HashMap<>();
                    history.put("price", price);
                    history.put("dateDepart", dateDepart);
                    history.put("arrivalPlace", arrivalPlace);
                    history.put("departPlace", departPlace);
                    history.put("namePlane", namePlane);
                    history.put("time", time);
                    history.put("timeArrival", timeArrival);
                    history.put("firstnameHis", tvLastname);
                    history.put("lastnameHis", tvFistname);
                    history.put("code_History","HIS"+i);
                    history.put("code",code);
                    i++;
                    historyRef.push().setValue(history);
                    Activity activity=new Activity();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.finish();
                }
            });
        }
        return view;
    }
}