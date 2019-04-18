package br.edu.unifcv.faculdade.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.listener.OnListClickInteractionListener;
import br.edu.unifcv.faculdade.model.Carro;

/**
 * Responsável por fazer as manipulações de elementos de interface
 */
public class CarViewHolder extends RecyclerView.ViewHolder {

    // Elemento de interface
    private ImageView mImgCarPicture;
    private TextView mTextCarModel;
    private TextView mTextViewDetails;


    /**
     * Construtor
     */
    public CarViewHolder(View itemView) {
        super(itemView);
        this.mImgCarPicture = itemView.findViewById(R.id.img_foto_carro);
        this.mTextCarModel = itemView.findViewById(R.id.text_modelo_carro);
        this.mTextViewDetails = itemView.findViewById(R.id.text_ver_detalhe);
    }

    /**
     * Atribui valores aos elementos
     */
    public void bindData(final Carro carro, final OnListClickInteractionListener listener) {

        // Altera valor
        this.mTextCarModel.setText(carro.getModelo());
        this.mImgCarPicture.setImageDrawable(carro.picture);

        // Adciona evento de click
        this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(carro.getId());
            }
        });
    }

}