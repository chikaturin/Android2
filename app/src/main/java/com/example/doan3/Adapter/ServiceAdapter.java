package com.example.doan3.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan3.Model.Servicemodel;
import com.example.doan3.R;
import com.example.doan3.ServiceActivity;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
    private Context context;

    private ArrayList<Servicemodel> arr_service;
    private float pricecacul;
    private String namePlane;
    private String dateDepart;
    private String timeDepart;
    private String arrivalPlace;
    private String departPlace;
    private  String code;
    private String timeArrival;
    private String firstName;
    private String lastName;
    private String price;

    public ServiceAdapter(Context context, ArrayList<Servicemodel> arr_service, float pricecacul,String namePlane,String dateDepart,String timeDepart,String arrivalPlace,
    String departPlace,String code,String timeArrival,String firstName,String lastName,String price) {
        this.context = context;
        this.arr_service = arr_service;
        this.pricecacul = pricecacul;
        this.namePlane=namePlane;
        this.dateDepart = dateDepart;
        this.timeDepart = timeDepart;
        this.price = price;
        this.firstName = firstName;
        this.lastName = lastName;
        this.arrivalPlace = arrivalPlace;
        this.departPlace = departPlace;
        this.code = code;
        this.timeArrival = timeArrival;
    }

    @NonNull
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycleservice, parent, false);
        return new ServiceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ViewHolder holder, int position) {
        Servicemodel servicemodel=arr_service.get(position);
        holder.img.setImageResource(servicemodel.getImage());
        holder.decription.setText(servicemodel.getName());
        holder.price.setText(String.format("%,.0f VNĐ", servicemodel.getPrice()));
        holder.choose.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                toggleButton(holder.choose);
                Intent intent=new Intent(context, ServiceActivity.class);
                SharedPreferences sharedPreferences = context.getSharedPreferences("ticket_data", Context.MODE_PRIVATE);

                float priceCacul = sharedPreferences.getFloat("Pricecacul", 0.0f);
                float totalprice = servicemodel.getPrice() + priceCacul;

                intent.putExtra("Pricecacula",String.format("%,.0f VNĐ", totalprice));
                intent.putExtra("name",servicemodel.getName());
                intent.putExtra("PriceService",String.format("%,.0f VNĐ",servicemodel.getPrice()));
                intent.putExtra("Price", price);
                intent.putExtra("dateDepart",dateDepart);
                intent.putExtra("arrivalPlace",arrivalPlace);
                intent.putExtra("departPlace",departPlace);
                intent.putExtra("namePlane",namePlane);
                intent.putExtra("time",timeDepart);
                intent.putExtra("timeArrival",timeArrival);
                intent.putExtra("code",code);
                intent.putExtra("tvLastname",firstName);
                intent.putExtra("tvFistname",lastName);

                context.startActivity(intent);
            }
        });
    }
    private void toggleButton(Button button) {
        if (button.isSelected()) {
            button.setBackgroundResource(R.drawable.raidusbutton);
            button.setTextColor(Color.parseColor("#000000"));
            button.setText("Chọn");
        } else {
            button.setBackgroundResource(R.drawable.raidusbutton2);
            button.setTextColor(Color.parseColor("#FFFFFF"));
            button.setText("Đã chọn");
        }
        button.setSelected(!button.isSelected());
    }

    @Override
    public int getItemCount() {
        return arr_service.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView price,decription;
        Button choose;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgservice);
            price=itemView.findViewById(R.id.tvpriceservice);
            decription=itemView.findViewById(R.id.tvdecription);
            choose=itemView.findViewById(R.id.btnchoose_service);
        }
    }
}
