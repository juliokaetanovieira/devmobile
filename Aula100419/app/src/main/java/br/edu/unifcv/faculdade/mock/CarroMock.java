package br.edu.unifcv.faculdade.mock;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.model.Carro;

/**
 * Classe mock implementada para simular um repositório de dados
 * Ex: Banco de dados, chamada a serviço API
 */
public class CarroMock {

    // Lista de carros
    private List<Carro> mListCars;

    /**
     * Construtor - Inicia Mock
     */
    public CarroMock(Activity activity) {
        this.mListCars = getCarMockList(activity);
    }

    /**
     * Retorna lista de carros
     */
    public List<Carro> getList() {
        return this.mListCars;
    }

    /**
     * Retorna carro de acordo com o Id
     */
    public Carro getCarro(int id) {
        return this.mListCars.get(id);
    }

    private List<Carro> getCarMockList(Activity activity) {
        List<Carro> mMockList = new ArrayList<>();
        int id = 0;
        Carro audiR8 = new Carro(id, "Audi R8", "Audi", 610, Double.valueOf(1165338.00), ContextCompat.getDrawable(activity, R.drawable.audir8));
        mMockList.add(audiR8);
        Carro bugattiChiron = new Carro(++id, "Bugatti Chiron", "Bugatti", 1520, Double.valueOf(1000000.00), ContextCompat.getDrawable(activity, R.drawable.bugattichiron));
        mMockList.add(bugattiChiron);
        Carro civicTypeR = new Carro(++id, "Civic Type R", "Honda", 310, Double.valueOf(136000.00), ContextCompat.getDrawable(activity, R.drawable.civictyper));
        mMockList.add(civicTypeR);
        Carro corolla = new Carro(++id, "Corolla", "Toyota", 144, Double.valueOf(101000.00), ContextCompat.getDrawable(activity, R.drawable.corolla));
        mMockList.add(corolla);
        Carro ferrari458Italia = new Carro(++id, "Ferrari 458 Itália", "Ferrari", 670, Double.valueOf(1500000.00), ContextCompat.getDrawable(activity, R.drawable.ferrari458));
        mMockList.add(ferrari458Italia);
        Carro ferrariF60America = new Carro(++id, "Ferrari F60 América", "Ferrari", 700, Double.valueOf(2500000.00), ContextCompat.getDrawable(activity, R.drawable.ferrarif60america));
        mMockList.add(ferrariF60America);
        Carro jaguarFTypeCoupe = new Carro(++id, "Jaguar F-Type Coupe", "Jaguar", 340, Double.valueOf(500000.00), ContextCompat.getDrawable(activity, R.drawable.jaguarftype));
        mMockList.add(jaguarFTypeCoupe);
        Carro jeepRenegade = new Carro(++id, "Jeep Renegade", "Jeep", 139, Double.valueOf(79000.00), ContextCompat.getDrawable(activity, R.drawable.jeeprenegade));
        mMockList.add(jeepRenegade);
        Carro lamborghiniAventador = new Carro(++id, "Lamborghini Aventador", "Lamborghini", 700, Double.valueOf(2800000.00), ContextCompat.getDrawable(activity, R.drawable.lamborghiniaventador));
        mMockList.add(lamborghiniAventador);
        Carro mcLarenMP412C = new Carro(++id, "McLaren MP4-12C", "McLaren", 625, Double.valueOf(2200000.00), ContextCompat.getDrawable(activity, R.drawable.mclarenmp412c));
        mMockList.add(mcLarenMP412C);
        Carro mustang = new Carro(++id, "Mustang", "Ford", 533, Double.valueOf(270000.00), ContextCompat.getDrawable(activity, R.drawable.mustang));
        mMockList.add(mustang);
        Carro porsche911 = new Carro(++id, "Porsche 911", "Porsche", 435, Double.valueOf(509000.00), ContextCompat.getDrawable(activity, R.drawable.porsche911));
        mMockList.add(porsche911);
        Carro rangeRoverEvoque = new Carro(++id, "Range Rover Evoque", "Range Rover", 285, Double.valueOf(224000.00), ContextCompat.getDrawable(activity, R.drawable.rangerover));
        mMockList.add(rangeRoverEvoque);
        Carro vanquish = new Carro(++id, "Vanquish", "Aston Martin", 573, Double.valueOf(1850000.00), ContextCompat.getDrawable(activity, R.drawable.vanquish));
        mMockList.add(vanquish);

        return mMockList;
    }

}