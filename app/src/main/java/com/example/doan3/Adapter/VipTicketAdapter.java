package com.example.doan3.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import com.example.doan3.Model.VipTicketModel;
import com.example.doan3.R;

public class VipTicketAdapter extends RecyclerView.Adapter<VipTicketAdapter.ViewHolder> {
    Context context;
    ArrayList<VipTicketModel>arr_tikketvip;
    public VipTicketAdapter(Activity context, ArrayList<VipTicketModel>arr_tikketvip){
        this.context=context;
        this.arr_tikketvip=arr_tikketvip;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewticket1=layoutInflater.inflate(R.layout.recyclethanhvipticket,parent,false);
        ViewHolder viewHolderticket=new ViewHolder(viewticket1);

        return viewHolderticket;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VipTicketModel ticket=arr_tikketvip.get(position);
        holder.txtNameAirplanevip.setText(ticket.getNameAirplanevip());
        holder.txtpricevip.setText(ticket.getPricevip()+" ");
        holder.txtdeparturevip.setText(ticket.getDeparturevip());
        holder.txttimevip.setText(ticket.getTimevip());
        holder.txtdatevip.setText(ticket.getDatevip());
        holder.txtdestinationvip.setText(ticket.getDestinationvip());
    }


    @Override
    public int getItemCount() {
        return arr_tikketvip.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNameAirplanevip,txtpricevip,txtdeparturevip,txttimevip,txtdatevip,txtdestinationvip;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameAirplanevip=itemView.findViewById(R.id.txtnameairplanevip);
            txtpricevip=itemView.findViewById(R.id.txtpricevip);
            txtdeparturevip=itemView.findViewById(R.id.txtdeparturevip);
            txttimevip=itemView.findViewById(R.id.txttimevip);
            txtdatevip=itemView.findViewById(R.id.txtdatevip);
            txtdestinationvip=itemView.findViewById(R.id.txtdestinationvip);
        }
    }
}
