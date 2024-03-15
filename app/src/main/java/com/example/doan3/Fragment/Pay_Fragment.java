package com.example.doan3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.doan3.R;

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
    TextView tvtimeArrival,tvprice,tvprice1,tvprice2,tvtime,tvdepartDate,tvdepartPlace,tvnameplane,tvarrivalPlace,tvdepartDate1;

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

            tvprice.setText(price);
            tvprice1.setText(price);
            tvprice2.setText(price+"/Vé");
            tvtime.setText(time);
            tvdepartDate.setText(dateDepart);
            tvdepartDate1.setText(dateDepart);
            tvarrivalPlace.setText(arrivalPlace);
            tvnameplane.setText(namePlane);
            tvdepartPlace.setText(departPlace);
            tvtimeArrival.setText(timeArrival);
            bntPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Trả về trang home
                }
            });
        }
        return view;    }
}