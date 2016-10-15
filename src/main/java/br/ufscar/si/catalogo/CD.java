package br.ufscar.si.catalogo;

public class CD extends Midia {

    protected String artista;

    public CD(String titulo, int anoCriacao, String artista){
        super(titulo, anoCriacao);
        this.artista = artista;
    }

    public void adicionaFaixa(String faixa, int duracao){
        // TODO
    }

    public int getTipo(){
        return 1;
    }

    public void imprimeFicha(){
        // TODO
    }

}
