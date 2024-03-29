package com.example.doan3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan3.Model.TicketHis;
import com.example.doan3.Model.TicketNomal;
import com.example.doan3.R;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;

    private ArrayList<TicketHis> arr_tikket;

    public HistoryAdapter(Context context, ArrayList<TicketHis> arr_tikket) {
        this.context = context;
        this.arr_tikket = arr_tikket;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.historyrecycle, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TicketHis ticket = arr_tikket.get(position);
        holder.tvcodeAirplan.setText("Mã chuyến bay: "+ ticket.getCode());
        holder.tvnamePlanehis.setText(ticket.getNamePlane()+" ~ ");
        holder.tvtimehis.setText(" ~ "+ticket.getTime());
        holder.tvdateDeparthis.setText(ticket.getDateDepart());
        holder.tvarrivalPlaceHis.setText(ticket.getArrivalPlace());
        holder.tvdepartPlacehis.setText(ticket.getDepartPlace());
        holder.tvfirstnamehis.setText(ticket.getFirstnameHis());
        holder.tvlastnamehis.setText(ticket.getLastnameHis());
        holder.tvprice.setText(ticket.getPrice());
        holder.tvcodehis.setText(ticket.getCode_History());
        holder.tvnameservice.setText(ticket.getNameservice());
        holder.tvpriceservice.setText(ticket.getPriceService());
    }



    @Override
    public int getItemCount() {
        return arr_tikket.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvpriceservice,tvnameservice,tvcodehis,tvdepartPlacehis,tvarrivalPlaceHis,tvdateDeparthis,tvtimehis,tvnamePlanehis,tvcodeAirplan,tvlastnamehis,tvfirstnamehis,tvprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdepartPlacehis=itemView.findViewById(R.id.departPlacehistory);
            tvarrivalPlaceHis=itemView.findViewById(R.id.arrivalPlaceHistory);
            tvdateDeparthis=itemView.findViewById(R.id.dateDepartHistory);
            tvtimehis=itemView.findViewById(R.id.timeHistory);
            tvnamePlanehis=itemView.findViewById(R.id.namePlaneHistory);
            tvcodeAirplan=itemView.findViewById(R.id.codeAirplaneHistory);
            tvlastnamehis=itemView.findViewById(R.id.tvlastnamehis);
            tvfirstnamehis=itemView.findViewById(R.id.tvFirstNamehis);
            tvprice=itemView.findViewById(R.id.tvpriceHis);
            tvcodehis=itemView.findViewById(R.id.tvcodehis);
            tvnameservice=itemView.findViewById(R.id.Nameservice);
            tvpriceservice=itemView.findViewById(R.id.PriceService);
        }
    }
}

