package com.example.doan3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan3.Adapter.TicketAdapter;
import com.example.doan3.Adapter.VipTicketAdapter;
import com.example.doan3.Model.VipTicketModel;
import com.example.doan3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VipTicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VipTicket extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public VipTicket() {
        // Required empty public constructor
    }
    Button btnclick1,btnclick2,btnclick3;
    RecyclerView recyclerView;
    VipTicketAdapter ticketAdaptervip;
    View view=getView();
    ArrayList<VipTicketModel>arr_tikketvip;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NomalTicket.
     */
    // TODO: Rename and change types and number of parameters
    public static VipTicket newInstance(String param1, String param2) {
        VipTicket fragment = new VipTicket();
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

    private void loadData() {
        arr_tikketvip.add(new VipTicketModel("VN797","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN897","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN997","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN197","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN297","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN397","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN497","20/02/2024","20:03","SGN","HN",1900223));
        arr_tikketvip.add(new VipTicketModel("VN597","20/02/2024","20:03","SGN","HN",1900223));
    }
    private void addControls(View view) {
        recyclerView = view.findViewById(R.id.recycleviewvip);
        arr_tikketvip = new ArrayList<>();
        ticketAdaptervip=new VipTicketAdapter(getActivity(),arr_tikketvip);
        recyclerView.setAdapter(ticketAdaptervip);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vip_ticket, container, false);
        addControls(view);
        loadData();
        return view;
    }
}