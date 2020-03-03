package fes.ico;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CamisaTest {

    private Camisa camisa = new Camisa();

    public CamisaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Prueba() {
        camisa.setListaCamisas(0, 1);
        camisa.setListaCamisas(1, 1);
        camisa.setListaCamisas(2, 1);
        camisa.MontoOriginal();
        camisa.MontoFinal();
        float valorEsperado = (float) 693.5;
        assertEquals(valorEsperado, camisa.getMontoFinal(), 0);
        //El último valor de la función assertEquals es para desiganr un margen de diferencia entre dos float
    }
}
