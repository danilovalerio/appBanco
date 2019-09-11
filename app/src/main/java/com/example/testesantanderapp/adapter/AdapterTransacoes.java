package com.example.testesantanderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testesantanderapp.R;
import com.example.testesantanderapp.model.Transaction;

import java.util.List;

public class AdapterTransacoes extends RecyclerView.Adapter<AdapterTransacoes.MyViewHolder> {
    private List<Transaction> listTransaction;

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

    public AdapterTransacoes(List<Transaction> lista) {
        this.listTransaction = lista;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Pega o objeto itemLista e converte numa visualização
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_transacoes, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Transaction transaction = listTransaction.get(position);
        holder.title.setText(transaction.getTitle());
        holder.desc.setText(transaction.getDesc());
        holder.date.setText(transaction.getDate());
        holder.value.setText(transaction.getValue().toString());
    }

    @Override
    public int getItemCount() {
        return listTransaction.size();
    }
}
