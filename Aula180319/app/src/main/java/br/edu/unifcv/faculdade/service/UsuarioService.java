package br.edu.unifcv.faculdade.service;

import br.edu.unifcv.faculdade.model.Usuario;

public class UsuarioService {

    private Usuario mUsuario;

    public UsuarioService(Usuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public boolean isDadosOk(){
        return mUsuario.getNome().trim().isEmpty()
        && mUsuario.getSenha().trim().isEmpty();

    }
    public boolean isLoginOk() {
        return mUsuario.getNome().trim().equalsIgnoreCase("faculdade@faculdade")
        && mUsuario.getSenha().trim().equalsIgnoreCase("123mudar");
    }
}
