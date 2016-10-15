package br.ufscar.si.catalogo;

public abstract class Midia {

    private String titulo;

    private int anoCriacao;

    public Midia(String titulo, int anoCriacao) {
        this.titulo = titulo;
        this.anoCriacao = anoCriacao;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public int getAnoCriacao()
    {
        return anoCriacao;
    }

    public abstract int getTipo();

    public abstract void imprimeFicha();
}
