package com.example.doan3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.doan3.ChooseTicket;
import com.example.doan3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Service_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Service_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Service_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Service_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Service_Fragment newInstance(String param1, String param2) {
        Service_Fragment fragment = new Service_Fragment();
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

    View view=getView();
    Button btnpay;
    Pay_Fragment payFragment=new Pay_Fragment();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_, container, false);
        if(view!=null)
        {
            Bundle bundle=getArguments();
            if(bundle!=null) {
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

                bundle.putString("Price", price);
                bundle.putString("dateDepart", dateDepart);
                bundle.putString("arrivalPlace", arrivalPlace);
                bundle.putString("departPlace", departPlace);
                bundle.putString("namePlane", namePlane);
                bundle.putString("time", time);
                bundle.putString("timeArrival", timeArrival);
                bundle.putString("tvLastname", tvLastname);
                bundle.putString("tvFistname", tvFistname);
                bundle.putString("code", code);

                payFragment.setArguments(bundle);
                btnpay = view.findViewById(R.id.btnpayofservice);
                btnpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ChooseTicket chooseTicket = (ChooseTicket) getActivity();
                        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                        transaction.replace(R.id.fmticket1, payFragment);
                        transaction.commit();
                        chooseTicket.ChangeColor(R.drawable.circle_gray, R.drawable.circle_gray, R.drawable.circle_gray,R.drawable.circle);
                    }
                });
            }
        }
        return view;
    }
}