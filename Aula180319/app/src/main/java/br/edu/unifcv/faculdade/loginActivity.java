package br.edu.unifcv.faculdade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.unifcv.faculdade.constants.ConversorMoedasConstants;
import br.edu.unifcv.faculdade.model.Usuario;
import br.edu.unifcv.faculdade.service.UsuarioService;
import br.edu.unifcv.faculdade.utils.SecurityPreferences;
import br.edu.unifcv.faculdade.utils.ToastUtils;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSecurityPreferences = new SecurityPreferences(this);
        loadcomponent();
        mViewHolder.buttonLogar.setOnClickListener(this);

    }

    private void loadcomponent() {
        this.mViewHolder.editUsuario = this.findViewById(R.id.camp_usuario);
        this.mViewHolder.editSenha = this.findViewById(R.id.camp_senha);
        this.mViewHolder.chkLembrar = this.findViewById(R.id.chkLembrar);
        this.mViewHolder.buttonLogar = this.findViewById(R.id.buttonLogar);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogar: {
                this.saveSecurityPreferences();
                this.logar();
                break;
            }
        }
    }

    private void logar() {

        Usuario mUsuario = new Usuario();

        mUsuario.setNome(this.mViewHolder.editUsuario.getText().toString());
        mUsuario.setSenha(this.mViewHolder.editSenha.getText().toString());
        UsuarioService mUsuarioService = new UsuarioService(mUsuario);

        if (!mUsuarioService.isDadosOk()) {
            ToastUtils.ShowToast(this, "Usuário e/ou Login não pode ser vazio");
        }else {
            if (mUsuarioService.isLoginOk()) {
                Intent intent = new Intent(this, MainActivity.class);

                intent.putExtras(this.passUserName(mUsuario.getNome()));
                startActivity(intent);
                finish();
                //Chamar a tela de moedas
            } else {
                ToastUtils.ShowToast(this, "Usuário e/ou Login inválido");
            }
        }

    }

    private Bundle passUserName(String nome){
        Bundle bundle = new Bundle();
        bundle.putString(ConversorMoedasConstants.USUARIO, nome);
        bundle.putString(ConversorMoedasConstants.SENHA, "123");
        return bundle;

    }


    private void saveSecurityPreferences() {
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.USUARIO, mViewHolder.editUsuario.getText().toString());
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.SENHA, mViewHolder.editSenha.getText().toString());
        this.mSecurityPreferences.storeString(ConversorMoedasConstants.LEMBRARSENHA, mViewHolder.chkLembrar.isChecked() ? "S" : "N");

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadSecurityPreferences();
    }

    private void loadSecurityPreferences() {
        this.mViewHolder.chkLembrar.setChecked(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.LEMBRARSENHA).equalsIgnoreCase("S"));

        if(mViewHolder.chkLembrar.isChecked()){
            this.mViewHolder.editUsuario.setText(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.USUARIO));
            this.mViewHolder.editSenha.setText(this.mSecurityPreferences.getStoredString(ConversorMoedasConstants.SENHA));
        }


    }

    private class ViewHolder {

        public EditText editUsuario;
        public EditText editSenha;
        public CheckBox chkLembrar;
        public Button buttonLogar;

    }
}
