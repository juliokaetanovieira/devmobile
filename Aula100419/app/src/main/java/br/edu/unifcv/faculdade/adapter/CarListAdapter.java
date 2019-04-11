package br.edu.unifcv.faculdade.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.viewholder.CarViewHolder;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_car_list, viewGroup, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder carViewHolder, int i) {
        //Responsavel por fazer a troca dos Recyclerview

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
