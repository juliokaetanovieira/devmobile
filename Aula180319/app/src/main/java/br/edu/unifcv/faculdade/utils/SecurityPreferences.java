package br.edu.unifcv.faculdade.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.
                getSharedPreferences("ConversorMoedas",
                Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).commit();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

}
