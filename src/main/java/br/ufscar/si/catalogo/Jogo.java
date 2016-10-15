package br.ufscar.si.catalogo;

public class Jogo extends Midia{

    protected String genero;

    public Jogo(String titulo, int anoCriacao, String genero){
        super(titulo, anoCriacao);
        this.genero = genero;
    }

    public int getTipo(){
        return 3;
    }

    public void imprimeFicha(){
        System.out.println("Título: " + titulo);
        System.out.println("Ano: " + anoCriacao);
        System.out.println("Tipo: Jogo Eletrônico");
        System.out.println("Gênero: " + genero);

    }

}
