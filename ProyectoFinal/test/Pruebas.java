/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.CtlUsuario;
import Vista.FrmRegistrarUsu;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yo
 */
public class Pruebas extends TestCase{
    
    public Pruebas() {
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
    
    public void testReferencia(){
//        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "1234", "daniela", "daniela@hotmail.com", "3146517774", "2", "4"));
    }
    
    public void testExistencia() {
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "Daniela Díaz", "danielad", "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", "", "danielad", "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", "Daniela Díaz", "", "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", "Daniela Díaz", "danielad", "dani092012@hotmail.com", "3146517774", "2", ""));
        
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, null, "Daniela Díaz", "danielad", "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", null, "danielad", "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", "Daniela Díaz", null, "dani092012@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "232016", "Daniela Díaz", "danielad", "dani092012@hotmail.com", "3146517774", "2", null));
        
        assertEquals("danielad", CtlUsuario.solicitudVerificarUsuario("danielad"));
        assertEquals("", CtlUsuario.solicitudVerificarUsuario(""));
        assertEquals("", CtlUsuario.solicitudVerificarUsuario(null));
        
        assertEquals("[232016, 232016, Daniela Díaz, danielad, dani092012@hotmail.com, 3146517774, 2, 4]", CtlUsuario.solicitudVerificarContraseñaUsuario(""));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
