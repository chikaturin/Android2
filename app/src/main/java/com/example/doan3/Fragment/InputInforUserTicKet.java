package com.example.doan3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.doan3.ChooseTicket;
import com.example.doan3.Model.InforUserTicket;
import com.example.doan3.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.database.FirebaseDatabase;

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
    LinearLayout show;
    Button btnpay,btnadd;
    ImageView btnoutinput;
    EditText Lastname,Fistname,DateOfBirth,NumberPhone,Place;

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
        btnbuttonsheet = view.findViewById(R.id.btn_buttonsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(btnbuttonsheet);
        btnpay=view.findViewById(R.id.btnpay);
        Lastname=view.findViewById(R.id.txtLastName);
        Fistname=view.findViewById(R.id.txtFirstName);
        DateOfBirth=view.findViewById(R.id.txtbirthday);
        NumberPhone=view.findViewById(R.id.txtphone);
        Place=view.findViewById(R.id.txtPlace);
        btnadd=view.findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebase();
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
            RadioButton selectedRadioButton = view.findViewById(selectedId);
            gender = selectedRadioButton.getText().toString();
        }

        RadioGroup PersonalRadioGroup = view.findViewById(R.id.radioGroupPersonalDocument);
        int selectedId2 = PersonalRadioGroup.getCheckedRadioButtonId();
        String personal = "";
        if (selectedId2 != -1) {
            RadioButton selectedRadioButton = view.findViewById(selectedId2); // Chỉnh sửa ở đây
            personal = selectedRadioButton.getText().toString();
        }

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        // Tạo một đối tượng user chứa thông tin người dùng
        Map<String, Object> InforUserTicket = new HashMap<>();
        InforUserTicket.put("LastName", Lastname.getText().toString().trim());
        InforUserTicket.put("FirstName", Fistname.getText().toString().trim());
        InforUserTicket.put("BirthDay", DateOfBirth.getText().toString().trim());
        InforUserTicket.put("NumberPhone", NumberPhone.getText().toString().trim());
        InforUserTicket.put("Place", Place.getText().toString().trim());
        InforUserTicket.put("Gender", gender);
        InforUserTicket.put("Personal", personal);

        // Thêm đối tượng user vào bảng 'users' trong Firestore
        InforUserTicket inforUserTicket = new InforUserTicket(Fistname.getText().toString(),Lastname.getText().toString(), DateOfBirth.getText().toString(),NumberPhone.getText().toString(),gender,Place.toString(),personal);
        db.getReference().child("Users").setValue(inforUserTicket);
    }
}