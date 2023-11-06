package com.mycompany.cashcontroljava;

public class UsuarioNode {
    private Usuario usuario;
    private UsuarioNode left;
    private UsuarioNode right;

    public UsuarioNode(Usuario usuario) {
        this.usuario = usuario;
        this.left = null;
        this.right = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioNode getLeft() {
        return left;
    }

    public void setLeft(UsuarioNode left) {
        this.left = left;
    }

    public UsuarioNode getRight() {
        return right;
    }

    public void setRight(UsuarioNode right) {
        this.right = right;
    }

}

