package br.edu.unifcv.faculdade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import br.edu.unifcv.faculdade.model.Usuario;
import br.edu.unifcv.faculdade.service.UsuarioService;
import br.edu.unifcv.faculdade.utils.ToastUtils;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder viewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadcomponent();
        viewHolder.buttonLogar.setOnClickListener(this);
    }

    private void loadcomponent(){
        this.viewHolder.editUsuario = this.findViewById(R.id.camp_usuario);
        this.viewHolder.editSenha = this.findViewById(R.id.camp_senha);
        this.viewHolder.chkLembrar = this.findViewById(R.id.chkLembrar);
        this.viewHolder.buttonLogar = this.findViewById(R.id.buttonLogar);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonLogar: {
                logar();
                break;
            }
        }
    }

    private void logar(){
        Usuario mUsuario = new Usuario();
        mUsuario.setNome(this.viewHolder.editUsuario.getText().toString());
        mUsuario.setSenha(this.viewHolder.editSenha.getText().toString());
        UsuarioService mUsuarioService = new UsuarioService(mUsuario);

        if (mUsuarioService.isLoginOk()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //Chamar a tela de moedas
        } else {
            ToastUtils.ShowToast( this, "Usuário e/ou Login inválido");
        }

    }

    private class ViewHolder {

        public EditText editUsuario;
        public EditText editSenha;
        public CheckBox chkLembrar;
        public Button buttonLogar;
    }
}
