package br.ufscar.si.catalogo;

public class DVD extends Midia{

    protected String diretor;

    private int posicaoArtitas;
    
    protected String[][] artistas;

    public DVD(String titulo, int anoCriacao, String diretor){
        super(titulo, anoCriacao);
        this.diretor = diretor;

        posicaoArtitas = 0;
        artistas = new String[4][1];
    }

    public void adicionaArtista(String artista, String papel){
        artistas[posicaoArtitas][0] = artista;
        artistas[posicaoArtitas][1] = papel;

        posicaoArtitas++;
    }

    public int getTipo(){
        return 2;
    }

    public void imprimeFicha(){
        System.out.println("Título: " + titulo);
        System.out.println("Ano: " + anoCriacao);
        System.out.println("Tipo: Filme em DVD");
        System.out.println("Diretor: " + diretor);

        int artistasOutput = 0;

        for (String[] artista : artistas){
            if (artista[0].length() > 0) {
                System.out.printf(
                    "Artista %s: %s, papel: %s\n", 
                    ++artistasOutput,
                    artista[0],
                    artista[1]                    
                );
            }
        }
    }

}
