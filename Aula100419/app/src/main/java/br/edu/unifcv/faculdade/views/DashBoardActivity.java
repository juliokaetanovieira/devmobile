package br.edu.unifcv.faculdade.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import br.edu.unifcv.faculdade.R;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        // Criando os elementos de interface
        this.loadComponents();

        // Setando os eventos do CardView
        this.setEvents();
    }

    private void setEvents() {
        this.mViewHolder.cardConversor.setOnClickListener(this);
        this.mViewHolder.cardCars.setOnClickListener(this);
    }

    private void loadComponents() {
        this.mViewHolder.cardConversor = this.findViewById(R.id.card_conversor);
        this.mViewHolder.cardCars = this.findViewById(R.id.carCars);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_conversor: {
                this.createConversor();
                break;
            }
            case R.id.carCars: {
                this.createCarsList();
                break;
            }
        }
    }

    private void createCarsList() {
        // A onde eu estou e para onde eu vou:
        Intent i = new Intent(this, CarrosActivity.class);
        startActivity(i);
    }

    private void createConversor() {
        Intent i = new Intent(this, ConversorActivity.class);
        startActivity(i);
    }

    private static class ViewHolder {
        CardView cardConversor;
        CardView cardCars;
    }
}
