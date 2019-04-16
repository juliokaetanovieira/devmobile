package br.edu.unifcv.faculdade.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.constants.CarrosConstants;
import br.edu.unifcv.faculdade.mock.CarroMock;
import br.edu.unifcv.faculdade.model.Carro;

public class DetalhesCarroActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private Carro mCarro;
    private CarroMock mCarroMock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carro);

        this.mCarroMock = new CarroMock();

        this.loadComponents();

        this.getDataFromActivity();

        this.SetData();
    }

    private void SetData() {
        this.mViewHolder.textModelo.setText(this.mCarro.getModelo());
        this.mViewHolder.textPotencia.setText(String.valueOf(this.mCarro.getPotencia()));
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCarro.getPreco()));
    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            this.mCarro = this.mCarroMock.getCarro(extras.getInt(CarrosConstants.CARRO_ID, 0));
        }
    }

    private void loadComponents() {
        this.mViewHolder.textModelo = this.findViewById(R.id.text_modelo_carro);
        this.mViewHolder.textPotencia = this.findViewById(R.id.text_potencia_carro);
        this.mViewHolder.textPrice = this.findViewById(R.id.text_preco_carro);
    }

    private static class ViewHolder {
        TextView textModelo;
        TextView textPotencia;
        TextView textPrice;
    }
}
