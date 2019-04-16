package br.edu.unifcv.faculdade.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.listener.OnListClickInteractionListener;
import br.edu.unifcv.faculdade.model.Carro;

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.text_modelo);
    }

    public void bindData(final Carro carro, final OnListClickInteractionListener listener) {
        this.mTextModel.setText(carro.getModelo());
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(carro.getId());
            }
        });
    }
}
