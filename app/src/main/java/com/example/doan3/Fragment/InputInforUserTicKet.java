package com.example.doan3.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.doan3.ChooseTicket;
import com.example.doan3.Model.InforUserTicket;
import com.example.doan3.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputInforUserTicKet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputInforUserTicKet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InputInforUserTicKet() {
        // Required empty public constructor
    }
    LinearLayout btnbuttonsheet;
    LinearLayout show,hide;
    Button btnpay,btnadd;
    ImageView btnoutinput;
    EditText Lastname,Fistname,DateOfBirth,NumberPhone,Place;
    TextView tvLastname,tvFistname,tvDateOfBirth,tvNumberPhone,tvPlace,tvgender,tvpersonal;

    private BottomSheetBehavior bottomSheetBehavior;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputInforUserTicKet.
     */
    // TODO: Rename and change types and number of parameters
    public static InputInforUserTicKet newInstance(String param1, String param2) {
        InputInforUserTicKet fragment = new InputInforUserTicKet();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_input_infor_user_tic_ket, container, false);
        show = view.findViewById(R.id.show);
        hide = view.findViewById(R.id.hide);
        btnbuttonsheet = view.findViewById(R.id.btn_buttonsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(btnbuttonsheet);
        btnpay=view.findViewById(R.id.btnpay);
        Lastname=view.findViewById(R.id.txtLastName);
        Fistname=view.findViewById(R.id.txtFirstName);
        DateOfBirth=view.findViewById(R.id.txtbirthday);
        NumberPhone=view.findViewById(R.id.txtphone);
        Place=view.findViewById(R.id.txtPlace);
        //
        tvLastname=view.findViewById(R.id.tvlastname);
        tvFistname=view.findViewById(R.id.tvFirstName);
        tvDateOfBirth=view.findViewById(R.id.tvbirthday);
        tvNumberPhone=view.findViewById(R.id.tvphone);
        tvPlace=view.findViewById(R.id.tvPlace);
        tvgender=view.findViewById(R.id.tvgender);
        tvpersonal=view.findViewById(R.id.tvpersonal);

        btnadd=view.findViewById(R.id.btnAdd);
        hide.setVisibility(view.INVISIBLE);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebase();
                show.setVisibility(view.INVISIBLE);
                hide.setVisibility(view.VISIBLE);

                appearinforuser();

            }
        });

        btnoutinput=view.findViewById(R.id.outinput);
        ChooseTicket chooseTicket=(ChooseTicket) getActivity();
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fmticket1, new Pay_Fragment());
                transaction.commit();
                chooseTicket.ChangeColor(R.drawable.circle_gray,R.drawable.circle_gray,R.drawable.circle);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
        btnoutinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        return view;    }
    void firebase() {
        RadioGroup genderRadioGroup = view.findViewById(R.id.radioGroupGender);
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        String gender = "";
        if (selectedId != -1) {
            RadioButton radioButton = view.findViewById(selectedId);
            if (radioButton.getId() == R.id.radioButtonMale) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
        }

        RadioGroup personalRadioGroup = view.findViewById(R.id.radioGroupPersonalDocument);
        int selectedId2 = personalRadioGroup.getCheckedRadioButtonId();
        String personal = "";
        if (selectedId2 != -1) {
            RadioButton radioButton = view.findViewById(selectedId2);
            if (radioButton.getId() == R.id.CCCD) {
                personal = "CCCD";
            } else {
                personal = "PASSPORT";
            }
        }
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        // Tạo một đối tượng user chứa thông tin người dùng
        Map<String, Object> InforUserTicket = new HashMap<>();
        InforUserTicket.put("firstName", Fistname.getText().toString().trim());
        InforUserTicket.put("lastName", Lastname.getText().toString().trim());
        InforUserTicket.put("birthDay", DateOfBirth.getText().toString().trim());
        InforUserTicket.put("numberPhone", NumberPhone.getText().toString().trim());
        InforUserTicket.put("gender", gender);
        InforUserTicket.put("place", Place.getText().toString().trim());
        InforUserTicket.put("personal", personal);

        InforUserTicket inforUserTicket = new InforUserTicket(Fistname.getText().toString(),Lastname.getText().toString(), DateOfBirth.getText().toString(),NumberPhone.getText().toString(),gender,Place.getText().toString(),personal);
        db.getReference().child("InforUserTicket").setValue(inforUserTicket);
    }
void appearinforuser(){
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference();
     databaseReference.child("InforUserTicket").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);
                String birthDay = snapshot.child("birthDate").getValue(String.class);
                String numberPhone = snapshot.child("NumberPhone").getValue(String.class);
                String gender = snapshot.child("gender").getValue(String.class);
                String place = snapshot.child("place").getValue(String.class);
                String personal = snapshot.child("personal").getValue(String.class);
                tvFistname.setText(firstName);
                tvLastname.setText(lastName);
                tvDateOfBirth.setText(birthDay);
                tvNumberPhone.setText(numberPhone);
                tvgender.setText(gender);
                tvPlace.setText(place);
                tvpersonal.setText(personal);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Xử lý khi có lỗi xảy ra trong quá trình đọc dữ liệu từ Firebase
            Log.e("FirebaseError", "Error reading data from Firebase: " + databaseError.getMessage());
        }
    });

}
}