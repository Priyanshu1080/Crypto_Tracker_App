package com.example.cryptotrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RCcurrencyAdapter extends RecyclerView.Adapter<RCcurrencyAdapter.ViewHolder> {
   private ArrayList<CRcurrencyModal> currencyRVModalArrayList;
   private Context context;
   private static DecimalFormat df2 = new DecimalFormat("#.##");
    public RCcurrencyAdapter(ArrayList<CRcurrencyModal> currencyRVModalArrayList, Context context) {
        this.currencyRVModalArrayList = currencyRVModalArrayList;
        this.context = context;
    }
    public void filterList(ArrayList<CRcurrencyModal> filteredList)
    {
        currencyRVModalArrayList = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RCcurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_currency_item,parent,false);
        return new RCcurrencyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCcurrencyAdapter.ViewHolder holder, int position) {
        CRcurrencyModal currencyRVModal = currencyRVModalArrayList.get(position);
        holder.currencyNameTV.setText(currencyRVModal.getName());
        holder.symbolTV.setText(currencyRVModal.getSymbol());
        holder.rateTV.setText("$ "+df2.format(currencyRVModal.getPrice()));

    }

    @Override
    public int getItemCount() {
        return currencyRVModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyNameTV,symbolTV,rateTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyNameTV = itemView.findViewById(R.id.idTVName);
            symbolTV=itemView.findViewById(R.id.idTVSymbol);
            rateTV=itemView.findViewById(R.id.idCRrate);
        }
    }
}
