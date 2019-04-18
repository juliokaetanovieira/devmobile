package br.edu.unifcv.faculdade.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.constants.CarrosConstants;
import br.edu.unifcv.faculdade.mock.CarroMock;
import br.edu.unifcv.faculdade.model.Carro;

public class DetalhesCarroActivity extends AppCompatActivity {
    // Variáveis da classe
    private ViewHolder mViewHolder = new ViewHolder();
    private CarroMock mCarMock;
    private Carro mCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carro);

        setTitle("Detalhe Carro");

        // Instancia variáveis
        this.mCarMock = new CarroMock(this);

        this.loadComponents();

        // Obtém o valor passado por parâmetro
        this.getDataFromActivity();

        // Atribui os valores aos elementos de interface
        this.setData();
    }

    private void setData() {
        this.mViewHolder.imgCarro.setImageDrawable(this.mCarro.getPicture());
        this.mViewHolder.textModelo.setText(this.mCarro.getModelo());
        this.mViewHolder.textFabricante.setText(this.mCarro.getFabricante());
        this.mViewHolder.textPotencia.setText(String.valueOf(this.mCarro.getPotecia()));
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCarro.getPreco()));
    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mCarro = this.mCarMock.getCarro(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    private void loadComponents() {
        this.mViewHolder.imgCarro = this.findViewById(R.id.img_detalhe_carro);
        this.mViewHolder.textModelo = this.findViewById(R.id.text_detalhe_modelo);
        this.mViewHolder.textFabricante = this.findViewById(R.id.text_detalhe_fabricante);
        this.mViewHolder.textPotencia = this.findViewById(R.id.text_detalhe_potencia);
        this.mViewHolder.textPrice = this.findViewById(R.id.text_detalhe_preco);
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        ImageView imgCarro;
        TextView textModelo;
        TextView textFabricante;
        TextView textPotencia;
        TextView textPrice;
    }
}
