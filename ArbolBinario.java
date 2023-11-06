package com.mycompany.cashcontroljava;

public class ArbolBinario {
    private UsuarioNode raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(Usuario usuario) {
        raiz = insertarRec(raiz, usuario);
    }

    private UsuarioNode insertarRec(UsuarioNode nodo, Usuario usuario) {
        if (nodo == null) {
            return new UsuarioNode(usuario);
        }

        if (usuario.getNickname().compareTo(nodo.getUsuario().getNickname()) < 0) {
            nodo.setLeft(insertarRec(nodo.getLeft(), usuario));
        } else if (usuario.getNickname().compareTo(nodo.getUsuario().getNickname()) > 0) {
            nodo.setRight(insertarRec(nodo.getRight(), usuario));
        }

        return nodo;
    }

    public Usuario buscarUsuarioPorNickname(String nickname) {
        return buscarUsuarioPorNicknameRec(raiz, nickname);
    }

    private Usuario buscarUsuarioPorNicknameRec(UsuarioNode nodo, String nickname) {
        if (nodo == null) {
            return null;
        }

        int comparacion = nickname.compareTo(nodo.getUsuario().getNickname());

        if (comparacion == 0) {
            return nodo.getUsuario();
        } else if (comparacion < 0) {
            return buscarUsuarioPorNicknameRec(nodo.getLeft(), nickname);
        } else {
            return buscarUsuarioPorNicknameRec(nodo.getRight(), nickname);
        }
    }
}