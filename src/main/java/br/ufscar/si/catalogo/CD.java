package br.ufscar.si.catalogo;

public class CD extends Midia {

    protected String artista;

    protected String[][] faixas;

    private int posicaoFaixa;

    public CD(String titulo, int anoCriacao, String artista){
        super(titulo, anoCriacao);
        this.artista = artista;

        faixas = new String[30][2];
        posicaoFaixa = 0;
    }

    public void adicionaFaixa(String faixa, int duracao){
        faixas[posicaoFaixa][0] = artista;
        faixas[posicaoFaixa][1] = String.format("%s:%s", duracao / 60, duracao % 60);
        
        posicaoFaixa++;
    }

    public int getTipo(){
        return 1;
    }

    public void imprimeFicha(){
        System.out.println("Título: " + titulo);
        System.out.println("Ano: " + anoCriacao);
        System.out.println("Tipo: CD de música");
        System.out.println("Artista: " + artista);

        int faixasOutput = 0;

        for (String[] faixa : faixas){
            if (faixa[0].length() > 0) {
                System.out.printf(
                    "Faixa %s: %s, duração: %s\n", 
                    ++faixasOutput,
                    faixa[0],
                    faixa[1]                    
                );
            }
        }
    }

}
