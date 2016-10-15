package br.ufscar.si.catalogo;

public class CD extends Midia {

    private String artista;

    private String[][] faixas;

    private int posicaoFaixa;

    public CD(String titulo, int anoCriacao, String artista){
        super(titulo, anoCriacao);
        this.artista = artista;

        faixas = new String[15][2];
        posicaoFaixa = 0;
    }

    public void adicionaFaixa(String faixa, int duracao){
        faixas[posicaoFaixa][0] = faixa;
        faixas[posicaoFaixa][1] = String.format("%s:%s", duracao / 60, duracao % 60);
        
        posicaoFaixa++;
    }

    public int getTipo(){
        return 1;
    }

    public void imprimeFicha(){
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano: " + getAnoCriacao());
        System.out.println("Tipo: CD de música");
        System.out.println("Artista: " + artista);

        int faixasOutput = 0;

        for (String[] faixa : faixas){
            if (faixa[0] != null) {
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
