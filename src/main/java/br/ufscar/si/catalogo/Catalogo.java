package br.ufscar.si.catalogo;

public class Catalogo implements ColecaoMidia{

    private Midia[] midias;

    private int midiaPosicao;

    private int limiteCatalogo;

    public Catalogo(int tamMax){
        limiteCatalogo = tamMax > 300 ? 300 : tamMax;
        midias = new Midia[limiteCatalogo];
        
        midiaPosicao = 0;
    }

    public boolean adicionaMidia(Midia midia){

        if (limiteCatalogo <= midiaPosicao){
            return false;
        }

        midias[midiaPosicao] = midia;
        midiaPosicao++;

        return true;
    }

    public Midia obtemMidia(String titulo){
        for (Midia midia : midias){
            if (midia != null && midia.getTitulo().equals(titulo)){
                return midia;
            }
        }
        
        return null;
    }

    public int quantidadeMaximaDeMidias(){
        return limiteCatalogo;
    }

    public int quantidadeDeMidias(){
        return midiaPosicao;
    }

    public int quantidadeDeCDs(){
        int qtdeCDs = 0;

        for (Midia midia : midias){
            if (midia instanceof CD){
                qtdeCDs++;
            }
        }

        return qtdeCDs;
    }

    public int quantidadeDeDVDs(){
        int qtdeDVDs = 0;

        for (Midia midia : midias){
            if (midia instanceof DVD){
                qtdeDVDs++;
            }
        }

        return qtdeDVDs;
    }

    public int quantidadeDeJogos(){
        int qtdeJogos = 0;

        for (Midia midia : midias){
            if (midia instanceof Jogo){
                qtdeJogos++;
            }
        }

        return qtdeJogos;
    }

    private int contarPorTipo(int tipo)
    {
        int qtde = 0;

        for (Midia midia : midias){
            if (midia != null && midia.getTipo() == tipo){
                qtde++;
            }
        }

        return qtde;
    }

    public Midia[] colecao(){
        return midias;
    }

    public void imprimeColecao(){
        Midia[] midias = colecao();

        for (Midia midia : midias){
            midia.imprimeFicha();
        }
    }

    public Midia[] colecaoPorTipo(int tipo){
        int arraySize = contarPorTipo(tipo);
        
        Midia[] midiasFiltrado = new Midia[arraySize];
        int midiasFiltradoPosicao = 0;

        for (Midia midia : midias){
            if (midia != null && midia.getTipo() == tipo){
                midiasFiltrado[midiasFiltradoPosicao] = midia;
                midiasFiltradoPosicao++;
            }
        }
        
        return midiasFiltrado;
    }

    public void imprimePorTipoColecao(int tipo){
        Midia[] midias = this.colecaoPorTipo(tipo);

        for (Midia midia : midias){
            midia.imprimeFicha();
        }
    }
}
