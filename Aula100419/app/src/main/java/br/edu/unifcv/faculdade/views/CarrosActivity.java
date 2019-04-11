package br.edu.unifcv.faculdade.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.adapter.CarListAdapter;

public class CarrosActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        // 1 - Obter a recyclerView
        this.mViewHolder.recyclerCars = this.findViewById(R.id.recycler_carros);

        // 2 - Definir um adapter - Responsável por ligar a listagem ao RecyclerView
        CarListAdapter carListAdapter = new CarListAdapter();
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        // 3 - Definir um Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);
    }

    private static class ViewHolder {
        RecyclerView recyclerCars;
    }
}
