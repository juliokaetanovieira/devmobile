package br.edu.unifcv.faculdade.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.adapter.CarListAdapter;
import br.edu.unifcv.faculdade.constants.CarrosConstants;
import br.edu.unifcv.faculdade.listener.OnListClickInteractionListener;
import br.edu.unifcv.faculdade.mock.CarroMock;

public class CarrosActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        CarroMock carroMock = new CarroMock();

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);
                Intent i = new Intent(mContext, DetalhesCarroActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        };


        // 1 - Obter a recyclerView
        this.mViewHolder.recyclerCars = this.findViewById(R.id.recycler_carros);

        // 2 - Definir um adapter - Responsável por ligar a listagem ao RecyclerView
        CarListAdapter carListAdapter = new CarListAdapter(carroMock.getList(), listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        // 3 - Definir um Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);
    }

    private static class ViewHolder {
        RecyclerView recyclerCars;
    }
}
