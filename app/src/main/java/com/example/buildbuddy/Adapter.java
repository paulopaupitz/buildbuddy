package com.example.buildbuddy;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Itens> listaItens;
    public Adapter(List<Itens> lista){
        this.listaItens = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Itens item = listaItens.get(position);
        holder.item.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item;
        public MyViewHolder(View view) {
            super(view);
            item = itemView.findViewById(R.id.textItem);
        }
    }
}

