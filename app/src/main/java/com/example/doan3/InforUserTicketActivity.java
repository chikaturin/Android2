package com.example.doan3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan3.Model.InforUserTicket;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class InforUserTicketActivity extends AppCompatActivity {
    Button btnback, btnout;
    ImageView img1, img2, img3, img4;
    LinearLayout btnbuttonsheet;
    LinearLayout show, hide;
    Button btnpay, btnadd;
    Button btnoutinput;
    EditText Lastname, Fistname, NumberPhone, Place;
    TextView DateOfBirth, tvLastname, tvprice, tvFistname, tvDateOfBirth, tvNumberPhone, tvPlace, tvgender, tvpersonal;

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_user_ticket);

        show = findViewById(R.id.show);
        hide = findViewById(R.id.hide);
        btnbuttonsheet =findViewById(R.id.btn_buttonsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(btnbuttonsheet);
        btnpay = findViewById(R.id.btnpay);
        Lastname = findViewById(R.id.txtLastName);
        Fistname = findViewById(R.id.txtFirstName);
        DateOfBirth = findViewById(R.id.txtbirthday);
        NumberPhone =findViewById(R.id.txtphone);
        Place =findViewById(R.id.txtPlace);
        DateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birthday();
            }
        });
        String price = getIntent().getStringExtra("Price");
        float pricecacul = getIntent().getFloatExtra("Pricecacul",0);
        String dateDepart=getIntent().getStringExtra("dateDepart");
        String arrivalPlace=getIntent().getStringExtra("arrivalPlace");
        String departPlace=getIntent().getStringExtra("departPlace");
        String namePlane=getIntent().getStringExtra("namePlane");
        String time=getIntent().getStringExtra("time");
        String timeArrival=getIntent().getStringExtra("timeArrival");
        String code=getIntent().getStringExtra("code");
        tvprice = findViewById(R.id.tvpriceinfor);
        tvprice.setText(price);

        tvLastname = findViewById(R.id.tvlastname);
        tvFistname = findViewById(R.id.tvFirstName);
        tvDateOfBirth = findViewById(R.id.tvbirthday);
        tvNumberPhone = findViewById(R.id.tvphone);
        tvPlace = findViewById(R.id.tvPlace);
        tvgender = findViewById(R.id.tvgender);
        tvpersonal = findViewById(R.id.tvpersonal);

        btnadd = findViewById(R.id.btnAdd);
        hide.setVisibility(View.INVISIBLE);
        final boolean[] isInformationAdded = new boolean[1];
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebase();
                String phoneNumber = NumberPhone.getText().toString().trim();
                if (phoneNumber.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số điện thoại đúng định dạng (10 chữ số)", Toast.LENGTH_SHORT).show();
                }
                else {
                    show.setVisibility(view.INVISIBLE);
                    hide.setVisibility(view.VISIBLE);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    isInformationAdded[0] = true;
                    appearinforuser();
                }

            }
        });

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isInformationAdded[0]) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập thông tin trước khi thanh toán", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    ChangeColor(R.drawable.circle_gray, R.drawable.circle_gray,R.drawable.circle,R.drawable.circle_gray);
                    Intent intent =new Intent(InforUserTicketActivity.this, ServiceActivity.class);
                    intent.putExtra("Price",price);
                    intent.putExtra("Pricecacul", pricecacul);
                    intent.putExtra("dateDepart",dateDepart);
                    intent.putExtra("arrivalPlace",arrivalPlace);
                    intent.putExtra("departPlace",departPlace);
                    intent.putExtra("namePlane",namePlane);
                    intent.putExtra("time",time);
                    intent.putExtra("timeArrival",timeArrival);
                    intent.putExtra("code",code);
                    intent.putExtra("tvLastname",Lastname.getText().toString());
                    intent.putExtra("tvFistname",Fistname.getText().toString());
                    startActivity(intent);
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
        btnoutinput = findViewById(R.id.outinput);
        btnoutinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });


        btnout = findViewById(R.id.outinputif);
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InforUserTicketActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img1 = findViewById(R.id.img1ticket);
        img2 = findViewById(R.id.img2ticket);
        img3 = findViewById(R.id.img3ticket);
        img4 = findViewById(R.id.img4ticket);
    }

    public void ChangeColor(int color1, int color2, int color3, int color4) {
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
        img4.setBackgroundResource(color4);
    }
    void firebase() {
        RadioGroup genderRadioGroup = findViewById(R.id.radioGroupGender);
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        String gender = "";
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            if (radioButton.getId() == R.id.radioButtonMale) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
        }

        RadioGroup personalRadioGroup = findViewById(R.id.radioGroupPersonalDocument);
        int selectedId2 = personalRadioGroup.getCheckedRadioButtonId();
        String personal = "";
        if (selectedId2 != -1) {
            RadioButton radioButton = findViewById(selectedId2);
            if (radioButton.getId() == R.id.CCCD) {
                personal = "CCCD";
            } else {
                personal = "PASSPORT";
            }
        }
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        Map<String, Object> InforUserTicket = new HashMap<>();
        InforUserTicket.put("firstName", Fistname.getText().toString().trim());
        InforUserTicket.put("lastName", Lastname.getText().toString().trim());
        InforUserTicket.put("birthDay", DateOfBirth.getText().toString().trim());
        InforUserTicket.put("numberPhone", NumberPhone.getText().toString().trim());
        InforUserTicket.put("gender", gender);
        InforUserTicket.put("place", Place.getText().toString().trim());
        InforUserTicket.put("personal", personal);

        com.example.doan3.Model.InforUserTicket inforUserTicket = new InforUserTicket(Fistname.getText().toString(), Lastname.getText().toString(), DateOfBirth.getText().toString(), NumberPhone.getText().toString(), gender, Place.getText().toString(), personal);
        db.getReference().child("InforUserTicket").setValue(inforUserTicket);
    }

    void appearinforuser() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("InforUserTicket").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);
                String birthDay = snapshot.child("birthDate").getValue(String.class);
                String numberPhone = snapshot.child("numberPhone").getValue(String.class);
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
    private void birthday(){
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateOfBirth.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,date);
        datePickerDialog.show();
    }

}
