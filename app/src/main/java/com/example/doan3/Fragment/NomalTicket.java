package com.example.doan3.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.doan3.Adapter.Session;
import com.example.doan3.Adapter.TicketAdapter;
import com.example.doan3.ChooseTicket;
import com.example.doan3.Model.TicketNomal;
import com.example.doan3.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NomalTicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NomalTicket extends Fragment  {
    Session session;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NomalTicket() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    TicketAdapter ticketAdapter;
    private NomalTicket fragment; // Thêm trường để lưu tham chiếu đến Fragment

    ArrayList<TicketNomal> arr_ticket;
    View view=getView();
    Button btnInforUser;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NomalTicket.
     */
    // TODO: Rename and change types and number of parameters
    public static NomalTicket newInstance(String param1, String param2) {
        NomalTicket fragment = new NomalTicket();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void loadData() {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("list_Flight");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    TicketNomal ticketNomal=dataSnapshot.getValue(TicketNomal.class);
                    arr_ticket.add(ticketNomal);
                }
                ticketAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
       }
    private void addControls(View view) {
        recyclerView = view.findViewById(R.id.recycleview);
        arr_ticket = new ArrayList<>();
        ticketAdapter = new TicketAdapter(getActivity(), arr_ticket);
        recyclerView.setAdapter(ticketAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    TextView txttottalprice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nomal_ticket, container, false);
        addControls(view);
        loadData();
        InputInforUserTicKet inputInforUserTicKet=new InputInforUserTicKet();
        if(view!=null)
        {
            String price = getArguments().getString("Price");
            String dateDepart = getArguments().getString("dateDepart");
            String arrivalPlace = getArguments().getString("arrivalPlace");
            String departPlace = getArguments().getString("departPlace");
            String namePlane = getArguments().getString("namePlane");
            String time = getArguments().getString("time");

            txttottalprice=view.findViewById(R.id.tvtotalprice);
            txttottalprice.setText(price);
            Bundle bundle = new Bundle();

            bundle.putString("Price",price);
            bundle.putString("dateDepart",dateDepart);
            bundle.putString("arrivalPlace",arrivalPlace);
            bundle.putString("departPlace",departPlace);
            bundle.putString("namePlane",namePlane);
            bundle.putString("time",time);

            inputInforUserTicKet.setArguments(bundle);
        }

        btnInforUser = view.findViewById(R.id.btninforuser);
        ChooseTicket chooseAirlineTicketsActivity=(ChooseTicket) getActivity();
        btnInforUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fmticket1,inputInforUserTicKet);
                transaction.commit();
                chooseAirlineTicketsActivity.ChangeColor(R.drawable.circle_gray,R.drawable.circle,R.drawable.circle_gray);
            }
        });
        return view;
    }
    LinearLayout nomalticket,vipticket,lnmain;
    Color color;
    TextView text,text1,text2,text3;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if(view != null) {
            text=view.findViewById(R.id.textticket);
            text1=view.findViewById(R.id.textticket1);
            text2=view.findViewById(R.id.textticket2);
            text3=view.findViewById(R.id.textticket3);
            vipticket = view.findViewById(R.id.vipticket);
            nomalticket = view.findViewById(R.id.nomalticket);
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
                }
            });

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
                }
            });
        }
    }

}