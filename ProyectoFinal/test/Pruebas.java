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
import org.junit.Assert;
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
//        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "", "", "", "", "", ""));
    }

    public void testExistencia() {
        assertEquals(false, CtlUsuario.SolicitudGuardar(0, "", "1234", "daniela", "daniela@hotmail.com", "3146517774", "2", "4"));
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
        
        assertEquals(true, CtlUsuario.SolicitudModificar(0, "", "", "", "", "", "", ""));
        assertEquals(true, CtlUsuario.SolicitudModificar(0, "123", "", "", "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(true, CtlUsuario.SolicitudModificar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", ""));
        
        assertEquals(true, CtlUsuario.SolicitudModificar(0, null, null, null, null, null, null, null));
        assertEquals(true, CtlUsuario.SolicitudModificar(0, "123", null, null, "dani@hotmail.com", "3146517774", "2", "4"));
        assertEquals(true, CtlUsuario.SolicitudModificar(0, "123", "Daniela", "daniela", "dani@hotmail.com", "3146517774", "2", null));

        assertEquals(true, CtlTema.SolicitudModificar(0, ""));
        assertEquals(true, CtlTema.SolicitudModificar(0, null));
        
    }
    
    private static String[] validEmails, invalidEmails;
 
    /**
     * Load data to run the tests.
     */
    @BeforeClass
    public static void emailProviderText() {
        validEmails = new String[] { "test@example.com",
                "test-101@example.com", "test.101@yahoo.com",
                "test101@example.com", "test_101@example.com",
                "test-101@test.net", "test.100@example.com.au", "test@e.com",
                "test@1.com", "test@example.com.com", "test+101@example.com",
                "101@example.com", "test-101@example-test.com" };
 
        invalidEmails = new String[] { "example", "example@.com.com",
                "exampel101@test.a", "exampel101@.com", ".example@test.com",
                "example**()@test.com", "example@%*.com",
                "example..101@test.com", "example.@test.com",
                "test@example_101.com", "example@test@test.com",
                "example@test.com.a5" };
    }
 
    /**
     * Test which validate an array of valid e-mails.
     */
    @Test
    public void validEmailTest() {
 
        for (String temp : validEmails) {
 
            // Check if the e-mail is valid using our method.
            boolean valid = FrmRegistrarUsu.validateEmail(temp);
            System.out.println("Email is valid : " + temp + " , " + valid);
 
            // All of e-mails of this test must be valid.
            Assert.assertEquals(valid, true);
        }
 
    }
 
    /**
     * Test which validate an array of invalid e-mails.
     */
    @Test
    public void invalidEmailTest() {
 
        for (String temp : invalidEmails) {
 
            // Check if the e-mail is valid using our method.
            boolean valid = FrmRegistrarUsu.validateEmail(temp);
            System.out.println("Email is valid : " + temp + " , " + valid);
 
            // All of e-mails of this test must be invalid.
            Assert.assertEquals(valid, false);
        }
 
    }
 

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
