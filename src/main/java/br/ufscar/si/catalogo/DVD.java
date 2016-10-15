package br.ufscar.si.catalogo;

public class DVD extends Midia{

    protected String diretor;

    public DVD(String titulo, int anoCriacao, String diretor){
        super(titulo, anoCriacao);
        this.diretor = diretor;
    }

    public void adicionaArtista(String artista, int papel){
        // TODO
    }

    public int getTipo(){
        return 2;
    }

    public void imprimeFicha(){
        // TODO
    }

}
