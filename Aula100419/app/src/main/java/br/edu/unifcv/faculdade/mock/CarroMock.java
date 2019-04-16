package br.edu.unifcv.faculdade.mock;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifcv.faculdade.model.Carro;
 //Criando o mock da poha toda:
public class CarroMock {
    private List<Carro> mListCarro;

    public CarroMock() {
        this.mListCarro = new ArrayList<>();
        for (int i = 0; i<= 100; i++){
            this.mListCarro.add(new Carro(i, String.valueOf(i), i * 10, Double.valueOf(i * 100)));
        }
    }

    public List<Carro> getList(){
        return this.mListCarro;
    }

    public Carro getCarro(int id) {
        return this.mListCarro.get(id);
    }
}
