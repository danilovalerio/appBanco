package com.example.testesantanderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testesantanderapp.R;

public class AdapterTransacoes extends RecyclerView.Adapter<AdapterTransacoes.MyViewHolder> {
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Pega o objeto itemLista e converte numa visualização
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_transacoes, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText("Condominio");
        holder.desc.setText("Bla bla bla bla bla");
        holder.date.setText("12/23/3444");
        holder.value.setText("33333");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    //para exibir os dados dentro de cada elemento de lista
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        TextView date;
        TextView value;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            desc = itemView.findViewById(R.id.tvDesc);
            date = itemView.findViewById(R.id.tvDate);
            value = itemView.findViewById(R.id.tvValue);
        }
    }
}
