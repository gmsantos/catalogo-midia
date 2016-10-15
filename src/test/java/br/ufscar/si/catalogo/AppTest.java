package br.ufscar.si.catalogo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private CD cd1;
    private CD cd2;
    private DVD dvd1;
    private DVD dvd2;
    private Jogo jogo1;
    private Jogo jogo2;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void setUp() throws Exception {
        cd1 = new CD("X & Y", 2005, "Cold Play");
        cd1.adicionaFaixa("Square One", 287); // 4:47
        cd1.adicionaFaixa("What If", 297); // 4:57
        cd1.adicionaFaixa("White Shadows", 328); // 5:28
        cd1.adicionaFaixa("Fix You", 294); // 4:54
        cd1.adicionaFaixa("Talk", 311); // 5:11
        cd1.adicionaFaixa("X&Y", 274); // 4:34

        dvd1 = new DVD(
            "O Senhor dos Anéis - A Sociedade dos Anel", 
            2001,
            "Peter Jacson"
        );

        dvd1.adicionaArtista("Elijah Wood", "Frodo Baggins");
        dvd1.adicionaArtista("Viggo Mortensen", "Aragorn");
        dvd1.adicionaArtista("Orlando Bloom", "Legolas Greenleaf");
        dvd1.adicionaArtista("Christopher Lee", "Saruman");
        dvd1.adicionaArtista("Ian McKellen", "Gandalf");

        jogo1 = new Jogo("Need For Speed - Underground II", 2005, "Corrida");

        cd2 = new CD(
            "Bachianas Brasileiras No.2", 
            2004,
            "Orquestra de Câmara da Universidade de São Paulo"
        );

        cd2.adicionaFaixa("(Prelúdio) O Canto do Capadócio", 512); // 4:32
        cd2.adicionaFaixa("(Ária) O Canto da Nossa Terra", 389); // 6:29
        cd2.adicionaFaixa("(Dança) Lembranca do Sertão", 324); // 5:24
        cd2.adicionaFaixa("(Tocata) O Trenzinho do Caipira", 284); // 4:44

        dvd2 = new DVD("Matrix", 1999, "Andy & Larry Wachoski");
        dvd2.adicionaArtista("Keanu Reeves", "Neo");
        dvd2.adicionaArtista("Laurence Fishburne", "Morpheus");
        dvd2.adicionaArtista("Carrie-Anne Moss", "Trinity");
        dvd2.adicionaArtista("Hugo Weaving", "Agente Smith");
        dvd2.adicionaArtista("Gloria Foster", "Óraculo");

        jogo2 = new Jogo("Fifa 2008", 2008, "Esporte");
    }

    public void testShouldCapCatalogToThreeHundred()
    {
        Catalogo catalogo1 = new Catalogo(300);
        Catalogo catalogo2 = new Catalogo(301);
        Catalogo catalogo3 = new Catalogo(299);

        assertEquals(300, catalogo1.quantidadeMaximaDeMidias());
        assertEquals(300, catalogo2.quantidadeMaximaDeMidias());
        assertEquals(299, catalogo3.quantidadeMaximaDeMidias());
    }

    public void testShouldFillCatalogWithMultipleMedia()
    {
        Catalogo catalogo = new Catalogo(6);

        assertTrue(catalogo.adicionaMidia(cd1));
        assertTrue(catalogo.adicionaMidia(dvd1));
        assertTrue(catalogo.adicionaMidia(jogo1));
        assertTrue(catalogo.adicionaMidia(cd2));
        assertTrue(catalogo.adicionaMidia(dvd2));
        assertTrue(catalogo.adicionaMidia(jogo2));

        assertEquals(jogo2, catalogo.obtemMidia("Fifa 2008"));
        assertEquals(dvd2, catalogo.obtemMidia("Matrix"));
        assertEquals(cd1, catalogo.obtemMidia("X & Y"));
        assertEquals(jogo1, catalogo.obtemMidia("Need For Speed - Underground II"));
        assertEquals(dvd1, catalogo.obtemMidia("O Senhor dos Anéis - A Sociedade dos Anel"));
        assertEquals(cd2, catalogo.obtemMidia("Bachianas Brasileiras No.2"));
    }

    public void testShouldReturnFalseIfPassCatalogLimit()
    {
        Catalogo catalogo = new Catalogo(2);

        catalogo.adicionaMidia(cd1);
        catalogo.adicionaMidia(dvd1);

        assertFalse(catalogo.adicionaMidia(jogo1));
    }

    public void testShouldCountByMedia()
    {
        Catalogo catalogo = new Catalogo(3);

        catalogo.adicionaMidia(cd1);
        catalogo.adicionaMidia(cd2);
        catalogo.adicionaMidia(dvd1);

        assertEquals(2, catalogo.quantidadeDeCDs());
        assertEquals(1, catalogo.quantidadeDeDVDs());
        assertEquals(0, catalogo.quantidadeDeJogos());        
    }
    
    public void testShouldCountByMediaInBigCatalog()
    {
        Catalogo catalogo = new Catalogo(100);

        catalogo.adicionaMidia(cd1);
        catalogo.adicionaMidia(cd2);
        catalogo.adicionaMidia(dvd1);

        assertEquals(2, catalogo.quantidadeDeCDs());
        assertEquals(1, catalogo.quantidadeDeDVDs());
        assertEquals(0, catalogo.quantidadeDeJogos());        
    }

    public void testShouldFindInvalidTitle()
    {
        Catalogo catalogo = new Catalogo(100);

        catalogo.adicionaMidia(cd1);
        catalogo.adicionaMidia(cd2);
        catalogo.adicionaMidia(dvd1);

        assertNull(catalogo.obtemMidia("Batata"));        
    }

    public void testShouldCountMediaQuantity()
    {
        Catalogo catalogo = new Catalogo(100);

        catalogo.adicionaMidia(cd1);
        catalogo.adicionaMidia(cd2);
        catalogo.adicionaMidia(dvd1);

        assertEquals(3, catalogo.quantidadeDeMidias());        
    }
}
