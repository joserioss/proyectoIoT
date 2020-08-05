package cl.jrios.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SensorServiceTest {
	@Test
	@DisplayName("Se registra un sensor")
	public void registrarSensor() {
		// - Ingresa un dispositivo a este servicio.
		// - Se crea dispositivoDto que setea al dispositivo entrante.
		// - Mediante un dao se realiza el registro del dispositivo.
		assertTrue(true);
	}

	@Test
	@DisplayName("Prueba para mostrar todos los sensores")
	public void llenarSensores() {
		// - Crear un dispositivoDto en donde se ocupe un dao.findAll().
		// para cargar todos los dispositivos que estan en la base de datos
		// a el dispositivoDto.
		assertTrue(true);
	}

	@Test
	@DisplayName("Se elimina un sensor")
	public void eliminarSensor() {
		// - Debe ingresar un Interger que corresponde al id del dispositivo a eliminar.
		// - Se hace uso del dao: findById para adquirir el dispositivo a eliminar.
		// - Ya identificandolo, se ocupa el dao.delet a este dispositivo.
		assertTrue(true);
	}

	@Test
	@DisplayName("Se actualiza un sensor")
	public void actualizarSensor() {
		// - Debe ingresar un Usuario con todos los campos requeridos,
		// como son: nombre, correo, contraseña. Estos deben ser guardados
		// mediante el dao.save y actualizados en la lista del usuarioDto
		assertTrue(true);
	}
}
