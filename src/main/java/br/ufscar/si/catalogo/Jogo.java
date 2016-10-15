package br.ufscar.si.catalogo;

public class Jogo extends Midia{

    private String genero;

    public Jogo(String titulo, int anoCriacao, String genero){
        super(titulo, anoCriacao);
        this.genero = genero;
    }

    public int getTipo(){
        return 3;
    }

    public void imprimeFicha(){
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano: " + getAnoCriacao());
        System.out.println("Tipo: Jogo Eletrônico");
        System.out.println("Gênero: " + genero);

    }

}
