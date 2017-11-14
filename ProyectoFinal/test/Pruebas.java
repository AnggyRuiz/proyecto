/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.CtlMultiple;
import Controlador.CtlTema;
import Controlador.CtlUnica;
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
public class Pruebas extends TestCase {

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

    public void testReferencia() {
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "1234", "daniela", "daniela@hotmail.com", "3146517774", "2", "4"));
    }

    public void testExistencia() {
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", "", "daniela", "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", ""));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", "Daniela", "", "dani@hotmail.com", "3146517774", "2", "4"));

        assertEquals(false, CtlUsuario.SolicitudGuardar(0, null, "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", null, "daniela", "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", "Daniela", null, "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", null));

        assertEquals(false, CtlTema.SolicitudGuardar(0, ""));
        assertEquals(false, CtlTema.SolicitudGuardar(0, null));
        
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "", "1", "2", "3", "Hola", "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "", "", "2", "3", "", "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "0", "1", "", "3", "Hola", "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "0", "1", "", "3", "Hola", "", 0, 0));
        
        assertEquals(false, CtlUnica.SolicitudGuardar(0, null, "1", "2", "3", "Hola", "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, null, null, "2", "3", null, "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "0", "1", null, "3", "Hola", "1", 0, 0));
        assertEquals(false, CtlUnica.SolicitudGuardar(0, "0", "1", null, "3", "Hola", null, 0, 0));
        
        assertEquals(false, CtlMultiple.solicitudGuardar(0, "", "", "Pues sí", "Pues no", "", "", 0, 0));
        assertEquals(false, CtlMultiple.solicitudGuardar(0, "No", "", "", "Pues no", "Holi", "", 0, 0));
        assertEquals(false, CtlMultiple.solicitudGuardar(0, "Si", "", "Pues sí", "", "", "Ay", 0, 0));
        
        assertEquals(false, CtlMultiple.solicitudGuardar(0, null, null, "Pues sí", "Pues no", null, null, 0, 0));
        assertEquals(false, CtlMultiple.solicitudGuardar(0, "No", null, null, "Pues no", "Holi", null, 0, 0));
        assertEquals(false, CtlMultiple.solicitudGuardar(0, "Si", null, "Pues sí", null, null, "Ay", 0, 0));

        assertEquals("88", CtlUsuario.solicitudVerificarUsuario("88"));
        assertEquals("", CtlUsuario.solicitudVerificarUsuario(""));
        assertEquals("", CtlUsuario.solicitudVerificarUsuario(null));

        //assertEquals("", CtlUsuario.solicitudVerificarContraseñaUsuario(""));
        
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "", "", "", "", "", "", ""));
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "123", "Daniela", "", "dani@hotmail.com", "3146517774", "2", "4"));
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", ""));
//        
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "123", null, "daniela", "dani@hotmail.com", "3146517774", "2", "4"));
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "123", "Daniela", null, "dani@hotmail.com", "3146517774", "2", "4"));
//        assertEquals(false, CtlUsuario.SolicitudModificar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", null));

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
