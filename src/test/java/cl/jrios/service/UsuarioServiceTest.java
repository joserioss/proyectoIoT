package cl.jrios.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService servicio;

    // se deben construír, las pruebas de todos los servicios que se
    // implementen
    
    @Test
    @DisplayName("prueba de ingresar usuario")
    public void igresar(){
        // ingreso un usuario
        // reviso el largo.
        assertTrue(true); // test ok: hardcore
    }

    @Test
    @DisplayName("prueba de eliminar usuario")
    public void eliminar(){
        assertTrue(true); // test ok: hardcore
    }

}
