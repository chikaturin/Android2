package com.example.doan3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doan3.Model.TicketNomal;
import com.example.doan3.R;
import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private Context context;
    private TicketAdapter mListener;

    private ArrayList<TicketNomal> arr_tikket;

    public TicketAdapter(Context context, ArrayList<TicketNomal> arr_tikket) {
        this.context = context;
        this.arr_tikket = arr_tikket;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recyclethanhticket, parent, false);
        return new ViewHolder(view);
    }
    private double pricetotal;
    public double TotalPrice()
    {
        return pricetotal;
    }
    private double pricetotal1;
    public double TotalPrice1()
    {
        return pricetotal1;
    }
    private double pricetotal2;
    public double TotalPrice2()
    {
        return pricetotal2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TicketNomal ticket = arr_tikket.get(position);
        holder.txtNameAirplane.setText(ticket.getNamePlane());
        holder.txtprice.setText(String.format("%,.0f VNĐ", ticket.getPrice()));
        pricetotal = ticket.getPrice();
        holder.txtprice1.setText(String.format("%,.0f VNĐ", ticket.getPrice() + 100000));
        pricetotal1= ticket.getPrice();
        holder.txtprice2.setText(String.format("%,.0f VNĐ", ticket.getPrice() + 370000));
        pricetotal2 = ticket.getPrice();
        holder.txtdeparture.setText(ticket.getDepartPlace());
        holder.txttime.setText(ticket.getTime());
        holder.txtdate.setText(ticket.getDateDepart() + " ");
        holder.txtdate1.setText(ticket.getDateDepart() + " ");
        holder.txtdestination.setText(ticket.getArrivalPlace());

        holder.btnchoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton(holder.btnchoose1);
                toggleButton2(holder.btnchoose2);
                toggleButton2(holder.btnchoose3);
                TotalPrice();
            }
        });

        holder.btnchoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton(holder.btnchoose2);
                toggleButton2(holder.btnchoose1);
                toggleButton2(holder.btnchoose3);
                TotalPrice1();
            }
        });

        holder.btnchoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton(holder.btnchoose3);
                toggleButton2(holder.btnchoose2);
                toggleButton2(holder.btnchoose1);
                TotalPrice2();
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
    }    private void toggleButton2(Button button) {
            button.setBackgroundResource(R.drawable.raidusbutton);
            button.setTextColor(Color.parseColor("#000000"));
            button.setText("Chọn");

        button.setSelected(!button.isSelected());
    }

    @Override
    public int getItemCount() {
        return arr_tikket.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnchoose1, btnchoose2, btnchoose3;
        TextView txtdate1, txtNameAirplane, txtprice, txtdeparture, txttime, txtdate, txtdestination, txtprice1, txtprice2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameAirplane = itemView.findViewById(R.id.txtnameAirplane);
            txtprice = itemView.findViewById(R.id.txtprice);
            txtdeparture = itemView.findViewById(R.id.txtdeparture);
            txttime = itemView.findViewById(R.id.txttime);
            txtdate = itemView.findViewById(R.id.txtdate);
            txtdestination = itemView.findViewById(R.id.txtdestination);
            txtprice1 = itemView.findViewById(R.id.txtprice1);
            txtprice2 = itemView.findViewById(R.id.txtprice2);
            txtdate1 = itemView.findViewById(R.id.txtdate1);
            btnchoose1 = itemView.findViewById(R.id.btnchoose1);
            btnchoose2 = itemView.findViewById(R.id.btnchoose2);
            btnchoose3 = itemView.findViewById(R.id.btnchoose3);
        }
    }
}
