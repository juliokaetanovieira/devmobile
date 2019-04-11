package br.edu.unifcv.faculdade.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.constants.ConversorMoedasConstants;
import br.edu.unifcv.faculdade.utils.SecurityPreferences;

public class ConversorActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Insere o layout na activity
        setContentView(R.layout.activity_conversor);

        // Busca os elementos da interface
        this.loadComponents();

        // Limpa os valores iniciais
        this.clearValues();

        // Adiciona evento de click no elemento
        this.setEventsOnButtons();

        // instanciando nossa Classe que encapsula o Shared Preferences
        this.mSecurityPreferences = new SecurityPreferences(this);

        // lendo as informações que vem da tela de login
        //this.loadParams();

    }

    /*private void loadParams() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String valor = bundle.getString(ConversorMoedasConstants.USUARIO) + " : " +
                bundle.getString(ConversorMoedasConstants.SENHA);

        this.mViewHolder.textUsuario.setText(valor);
    }*/

    private void setEventsOnButtons() {
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.mViewHolder.buttonLimpar.setOnClickListener(this);
    }

    private void loadComponents() {
        this.mViewHolder.editReal = this.findViewById(R.id.edit_valor);
        this.mViewHolder.editCotDollar = this.findViewById(R.id.edit_cot_dollar);
        this.mViewHolder.editCotEuro = this.findViewById(R.id.edit_cot_euro);

        this.mViewHolder.textDollar = this.findViewById(R.id.txt_dollar);
        this.mViewHolder.textEuro = this.findViewById(R.id.txt_euro);
        this.mViewHolder.textUsuario = this.findViewById(R.id.txt_usuario);

        this.mViewHolder.buttonCalculate = this.findViewById(R.id.btn_calcular);
        this.mViewHolder.buttonLimpar = this.findViewById(R.id.btn_limpar);
    }

    @Override
    public void onClick(View view) {
        // Verifica se o elemento clicado é o que nos interessa
        switch (view.getId()) {
            case R.id.btn_calcular: {
                calculateValues();
                break;
            }
            case R.id.btn_limpar: {
                clearValues();
                break;
            }
        }
    }

    private void calculateValues() {
        if (isDadosValidos()) {
            // Obtém o valor do EditText
            Double mReal = Double.valueOf(this.mViewHolder.editReal.getText().toString());
            Double mCotacaoDolar_ = Double.valueOf(this.mViewHolder.editCotDollar.getText().toString());
            Double mCotacaoEuro_ = Double.valueOf(this.mViewHolder.editCotEuro.getText().toString());

            // Converte valores
            this.mViewHolder.textDollar.setText(String.format("%.2f", mReal / mCotacaoDolar_));
            this.mViewHolder.textEuro.setText(String.format("%.2f", mReal / mCotacaoEuro_));

            // nossa classe que irá salvar os valores da cotação e ultimo valor informado
            this.saveSecurityPreferences();
        }
    }

    private void saveSecurityPreferences() {
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.VALOR_REAL, mViewHolder.editReal.getText().toString());
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.COTACAO_EURO, mViewHolder.editCotEuro.getText().toString());
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.COTACAO_DOLAR, mViewHolder.editCotEuro.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadSecurityPreferences();
    }

    private void loadSecurityPreferences() {
        this.mViewHolder.editCotDollar.setText(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.COTACAO_DOLAR));
        this.mViewHolder.editCotEuro.setText(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.COTACAO_EURO));
        this.mViewHolder.editReal.setText(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.VALOR_REAL));
    }

    private boolean isDadosValidos() {
        if (this.mViewHolder.editReal.getText().toString().trim().isEmpty()) {
            showToast("Informe o valor que deseja converter");
            this.mViewHolder.editReal.requestFocus();
            return false;
        } else if (this.mViewHolder.editCotDollar.getText().toString().trim().isEmpty()) {
            showToast("Informe a cotação do dollar");
            this.mViewHolder.editCotDollar.requestFocus();
            return false;
        } else if (this.mViewHolder.editCotEuro.getText().toString().trim().isEmpty()) {
            showToast("Informe a cotação do euro");
            this.mViewHolder.editCotEuro.requestFocus();
            return false;
        } else if (isZeroCotacoesValues()) {
            return false;
        }
        return true;
    }

    private boolean isZeroCotacoesValues() {
        if (Double.parseDouble(this.mViewHolder.editCotDollar.getText().toString()) <= 0) {
            showToast("O valor da cotação do 'dólar' deve ser maior que ZERO");
            this.mViewHolder.editCotDollar.requestFocus();
            return true;
        } else if (Double.parseDouble(this.mViewHolder.editCotEuro.getText().toString()) <= 0) {
            showToast("O valor da cotação do 'euro' deve ser maior que ZERO");
            this.mViewHolder.editCotEuro.requestFocus();
            return true;
        }
        return false;
    }

    private void showToast(final String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Limpa os valores iniciais
     */
    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        private EditText editReal;
        private EditText editCotEuro;
        private EditText editCotDollar;
        private TextView textDollar;
        private TextView textEuro;
        private TextView textUsuario;
        private Button buttonCalculate;
        private Button buttonLimpar;
    }

}
