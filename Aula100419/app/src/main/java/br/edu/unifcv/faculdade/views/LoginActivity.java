package br.edu.unifcv.faculdade.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import br.edu.unifcv.faculdade.R;
import br.edu.unifcv.faculdade.constants.ConversorMoedasConstants;
import br.edu.unifcv.faculdade.model.Usuario;
import br.edu.unifcv.faculdade.service.UsuarioService;
import br.edu.unifcv.faculdade.utils.SecurityPreferences;
import br.edu.unifcv.faculdade.utils.ToastUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mvViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loadComponents();

        this.mvViewHolder.btnLogar.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);
    }

    private void loadComponents() {
        mvViewHolder.edtLogin = this.findViewById(R.id.edit_login);
        mvViewHolder.edtSenha = this.findViewById(R.id.edit_senha);
        mvViewHolder.chkLembrar = this.findViewById(R.id.checkbox_lembrar);
        mvViewHolder.btnLogar = this.findViewById(R.id.button_logar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_logar: {
                this.login();
                break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadSecurityPreferences();
    }

    private void loadSecurityPreferences() {
        boolean isLembrar = mSecurityPreferences.getStoredBoolean(ConversorMoedasConstants.LEMBRAR);

        if (isLembrar) {
            mvViewHolder.edtLogin.setText(mSecurityPreferences.getStoredString(ConversorMoedasConstants.USUARIO));
            mvViewHolder.edtSenha.setText(mSecurityPreferences.getStoredString(ConversorMoedasConstants.SENHA));
            mvViewHolder.chkLembrar.setChecked(isLembrar);
        }

    }

    private void login() {
        UsuarioService mUsuarioService = new UsuarioService(this.getUsuario());

        if (mUsuarioService.isDadosValidos()) {
            if (mUsuarioService.isLoginOk()) {
                this.saveSecurityPreferences();
                Intent intent = new Intent(this, DashBoardActivity.class);
                intent.putExtras(this.passUserName(this.getUsuario().getNome()));
                startActivity(intent);
                finish();
            } else {
                ToastUtils.showToast(this, "Login ou senha inválidos!");
            }
        } else {
            ToastUtils.showToast(this, "Preencha todos os dados!");
        }

    }

    private Bundle passUserName(String nome) {
        Bundle bundle = new Bundle();
        bundle.putString(ConversorMoedasConstants.USUARIO, nome);
        bundle.putString(ConversorMoedasConstants.SENHA, "123");
        return bundle;
    }


    private void saveSecurityPreferences() {
        mSecurityPreferences.storeBoolean(ConversorMoedasConstants.LEMBRAR, mvViewHolder.chkLembrar.isChecked());
        mSecurityPreferences.storeString(ConversorMoedasConstants.USUARIO, mvViewHolder.edtLogin.getText().toString());
        mSecurityPreferences.storeString(ConversorMoedasConstants.SENHA, mvViewHolder.edtSenha.getText().toString());
    }

    private Usuario getUsuario() {
        Usuario mUsuario = new Usuario();
        mUsuario.setNome(mvViewHolder.edtLogin.getText().toString());
        mUsuario.setSenha(mvViewHolder.edtSenha.getText().toString());
        return mUsuario;
    }

    private class ViewHolder {
        public EditText edtLogin;
        public EditText edtSenha;
        public CheckBox chkLembrar;
        public Button btnLogar;
    }
}
