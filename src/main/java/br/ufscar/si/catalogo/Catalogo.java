package br.ufscar.si.catalogo;

public class Catalogo implements ColecaoMidia{

    public Midia[] midias;

    public Catalogo(int tamMax){
        this.midias = new Midia[tamMax];
    }

    public boolean adicionaMidia(Midia midia){
        return true;
    }

    public Midia obtemMidia(String titulo){
        return new DVD("Batata", 2016, "Terror");
    }

    public int quantidadeMaximaDeMidias(){
        return 1;
    }

    public int quantidadeDeMidias(){
        return 1;
    }

    public int quantidadeDeCDs(){
        return 1;
    }

    public int quantidadeDeDVDs(){
        return 2;
    }

    public int quantidadeDeJogos(){
        return 3;
    }

    public Midia[] colecao(){
        return this.midias;
    }

    public void imprimeColecao(){
        Midia[] midias = this.colecao();
        System.out.println();
    }

    public Midia[] colecaoPorTipo(int tipo){
        return this.midias;
    }

    public void imprimePorTipoColecao(int tipo){
        Midia[] midias = this.colecaoPorTipo(tipo);
        System.out.println();
    }
}
