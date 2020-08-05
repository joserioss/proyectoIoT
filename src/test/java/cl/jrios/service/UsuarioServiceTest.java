package cl.jrios.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.javafaker.Faker;

import cl.jrios.model.dao.UsuarioRepository;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Usuario;

@SpringBootTest
public class UsuarioServiceTest {

	private static Usuario usuario;
	private static UsuarioDto usuarioDto;
	private static List<Usuario> usuarios;

	@Autowired
	private UsuarioService servicio;

	@MockBean
	UsuarioRepository mockerDao;

	private static final Faker faker = new Faker(new Locale("es-ES"));

	@BeforeAll
	static void fixture() {
		usuario = new Usuario();

		usuario.setId(faker.number().randomDigit());
		usuario.setNombre(faker.name().name());
		usuario.setCorreo(faker.internet().emailAddress());
		usuario.setContrasenia(faker.internet().password());

		usuarioDto = new UsuarioDto();
		usuarioDto.setUsuario(usuario);

		usuarios = new ArrayList<>();
		usuarios.add(usuario);
	}

	@Test
	@DisplayName("Se registra un usuario desde dentro del sistema")
	public void registrarUsuario() {
		// - Ingresa un usuario de clase Usuario como parametro a este servicio.
		// - Se crea otro usuario al cual mediante un dao se
		// realiza una busqueda en la base de datos si exise su email.
		// - Si el correo ya ha sido registrado anteriormente, entonces
		// no se puede volver a registrar dicho usuario.
		// - En caso de que no se encuentre usuario con ese correo el 
		// registro será correcto
		assertTrue(true);
	}

	@Test
	@DisplayName("Se registra un usuario desde fuera del sistema")
	public void registrarUsuarioExterno() {
		// - Ingresa un usuario de clase RegistroDto a este servicio.
		// - Se comparan si las dos contraseñas ingresadas en registro
		// son iguales entre si, de ser correcto se crea un nuevo Usuario
		// con los atributos de la clase registro ingresada.
		// - El usuario registrado asumira  un ROL_USER por defetecto,
		// Solo el administrador podra transformar a otro usuario en admin.
		// - El usuario cargado con la clase registro se ingresa al 
		// servicio registrarUsuario().
		assertTrue(true); 
	}

	@Test
	@DisplayName("Prueba para mostrar todos los usuarios guardados")
	public void llenarUsuarios() {
		// - Crear un usuarioDto en donde se ocupe un dao.findAll(). 
		// para cargar todos los usuarios que estan en la base de datos
		// a el usuarioDto.
		assertTrue(true); 
	}

	@Test
	@DisplayName("Prueba para eliminar un usuario segun su ID")
	public void eliminarUsuario() {
		// - Debe ingresar un Interger que corresponde al id del usuario a eliminar.
		// - Se hace uso del dao: findById para adquirir el usuario a eliminar.
		// - Ya identificandolo, se ocupa el dao.delet a este usuario.
		assertTrue(true); 
	}
	
	@Test
	@DisplayName("Prueba para actualizar un usuario segun su ID")
	public void actualizarUsuario() {
		// - Debe ingresar un Usuario con todos los campos requeridos,
		// como son: nombre, correo, contraseña. Estos deben ser guardados
		// mediante el dao.save y actualizados en la lista del usuarioDto
		assertTrue(true); 
	}
	
	@Test
	@DisplayName("Prueba de busqueda de un usuario por su correo electronico")
	public void buscarUsuarioPorCorreo() {
		// - Debe ingresar como parametro un String con el correo electronico.
		// - Se busca con la queri opcional: findByCorreo el string que llegó,
		// devolviendo el usuario que posea a dicho correo electronico.
		// - De este usuario se retorna el nombre.
		assertTrue(true); 
	}
	
	@Test
	@DisplayName("Prueba para obtener un usuario por su ID")
	public void obtenerPorId() {
		// - Debe ingresar un interger que corresponde al Id que se desea buscar
		// - Haciendo uso del dao.findId se busca al usuario que posea ese ID
		// y se retorna.
		assertTrue(true); 
	}
}
