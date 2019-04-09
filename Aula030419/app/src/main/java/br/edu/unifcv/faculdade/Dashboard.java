package br.edu.unifcv.faculdade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Criando os elementos de interface
        this.loadComponents();

        this.setEvents();
    }

    private void setEvents(){
        //Como setar o evento de um botão:
        this.mViewHolder.cardConversor.setOnClickListener(this);
        this.mViewHolder.cardCars.setOnClickListener(this);
    }

    private void loadComponents() {
        this.mViewHolder.cardConversor = this.findViewById(R.id.card_conversor);
        this.mViewHolder.cardCars = this.findViewById(R.id.cardCars);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_conversor: {
                this.createConversor();
                break;
            }
            case R.id.cardCars: {
                break;
            }
        }
    }

    private void createConversor() {
        Intent intent = new Intent(this, ConversorActivity.class);
        startActivity(intent);
    }


    private static class ViewHolder{
        CardView cardConversor;
        CardView cardCars;
    }
}
