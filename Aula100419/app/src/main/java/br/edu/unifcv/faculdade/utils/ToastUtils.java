package br.edu.unifcv.faculdade.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(final Context context, final String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
