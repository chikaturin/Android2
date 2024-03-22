package com.example.doan3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan3.ChooseTicket;
import com.example.doan3.Model.TicketNomal;
import com.example.doan3.R;
import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private Context context;

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
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TicketNomal ticket = arr_tikket.get(position);
        holder.txtNameAirplane.setText(ticket.getNamePlane());


        holder.txtprice.setText(String.format("%,.0f VNĐ", ticket.getPrice()));
        holder.txtprice1.setText(String.format("%,.0f VNĐ", ticket.getPrice() + 1050000));
        holder.txtprice2.setText(String.format("%,.0f VNĐ", ticket.getPrice() + +1270000));
        holder.txtdeparture.setText(ticket.getDepartPlace());
        holder.txttime.setText(ticket.getTimeDepart());
        holder.txtdate.setText(ticket.getDateDepart() + " ");
        holder.txtdate1.setText(ticket.getDateDepart() + " ");
        holder.txtdestination.setText(ticket.getArrivalPlace());
        holder.timeArrival.setText(ticket.getTimeArrival());
        holder.txtcode.setText(ticket.getCode());


        holder.btnchoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChooseTicket.class);
                toggleButton(holder.btnchoose1);
                toggleButton2(holder.btnchoose2);
                toggleButton2(holder.btnchoose3);
                intent.putExtra("Price", String.format("%,.0f VNĐ", ticket.getPrice()));
                intent.putExtra("dateDepart",ticket.getDateDepart());
                intent.putExtra("arrivalPlace",ticket.getArrivalPlace());
                intent.putExtra("departPlace",ticket.getDepartPlace());
                intent.putExtra("namePlane",ticket.getNamePlane());
                intent.putExtra("time",ticket.getTimeDepart());
                intent.putExtra("timeArrival",ticket.getTimeArrival());
                intent.putExtra("code",ticket.getCode());
                context.startActivity(intent);
            }
        });

        holder.btnchoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChooseTicket.class);
                toggleButton(holder.btnchoose2);
                toggleButton2(holder.btnchoose1);
                toggleButton2(holder.btnchoose3);
                intent.putExtra("Price", String.format("%,.0f VNĐ", ticket.getPrice()+1050000));
                intent.putExtra("dateDepart",ticket.getDateDepart());
                intent.putExtra("arrivalPlace",ticket.getArrivalPlace());
                intent.putExtra("departPlace",ticket.getDepartPlace());
                intent.putExtra("namePlane",ticket.getNamePlane());
                intent.putExtra("time",ticket.getTimeDepart());
                intent.putExtra("timeArrival",ticket.getTimeArrival());
                intent.putExtra("code",ticket.getCode());
                context.startActivity(intent);
            }
        });

        holder.btnchoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChooseTicket.class);
                toggleButton(holder.btnchoose3);
                toggleButton2(holder.btnchoose2);
                toggleButton2(holder.btnchoose1);
                intent.putExtra("Price", String.format("%,.0f VNĐ", ticket.getPrice()+1270000));
                intent.putExtra("dateDepart",ticket.getDateDepart());
                intent.putExtra("arrivalPlace",ticket.getArrivalPlace());
                intent.putExtra("departPlace",ticket.getDepartPlace());
                intent.putExtra("namePlane",ticket.getNamePlane());
                intent.putExtra("time",ticket.getTimeDepart());
                intent.putExtra("timeArrival",ticket.getTimeArrival());
                intent.putExtra("code",ticket.getCode());
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

    private void toggleButton2(Button button) {
        button.setBackgroundResource(R.drawable.raidusbutton);
        button.setTextColor(Color.parseColor("#000000"));
        button.setText("Chọn");
    }

    @Override
    public int getItemCount() {
        return arr_tikket.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnchoose1, btnchoose2, btnchoose3;
        TextView txtcode,txtdate1,timeArrival, txtNameAirplane, txtprice, txtdeparture, txttime, txtdate, txtdestination, txtprice1, txtprice2,txttotalprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameAirplane = itemView.findViewById(R.id.txtnameAirplanepay);
            txtprice = itemView.findViewById(R.id.txtprice);
            txtdeparture = itemView.findViewById(R.id.tvdepartPlacepay);
            txttime = itemView.findViewById(R.id.tvtimepay);
            txtdate = itemView.findViewById(R.id.tvDatepay);
            txtdestination = itemView.findViewById(R.id.tvarrivalPlacepay);
            txtprice1 = itemView.findViewById(R.id.txtprice1);
            txtprice2 = itemView.findViewById(R.id.txtprice2);
            txtdate1 = itemView.findViewById(R.id.txtdate1);
            btnchoose1 = itemView.findViewById(R.id.btnchoose1);
            btnchoose2 = itemView.findViewById(R.id.btnchoose2);
            btnchoose3 = itemView.findViewById(R.id.btnchoose3);
            txttotalprice=itemView.findViewById(R.id.tvtotalprice);
            timeArrival=itemView.findViewById(R.id.timeArrival);
            txtcode=itemView.findViewById(R.id.txtcode);
        }
    }
}

