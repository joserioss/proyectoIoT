package cl.jrios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import cl.jrios.model.dto.DispositivoDto;
import cl.jrios.model.dto.SensorDto;
import cl.jrios.model.dto.UsuarioDto;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.PrivacidadDispositivo;
import cl.jrios.model.entity.Rol;
import cl.jrios.model.entity.Sensor;
import cl.jrios.model.entity.TipoSensor;
import cl.jrios.model.entity.Usuario;
import cl.jrios.service.DispositivoService;
import cl.jrios.service.SensorService;
import cl.jrios.service.UsuarioService;

@SpringBootApplication
public class ProyectoIoTApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIoTApplication.class, args);
	}

}

@Component
class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private UsuarioService servicioUsuario;
	@Autowired
	private DispositivoService servicioDispositivo;
	@Autowired
	private SensorService servicioSensor;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//************ USUARIO INICIAL ****************
		Usuario usuario = new Usuario();
		usuario.setNombre("Usuario administrador");
		usuario.setCorreo("admin@mail.cl");
		usuario.setContrasenia("1234");
		usuario.setRol(Rol.ROLE_ADMIN);
		UsuarioDto usuarioDto = servicioUsuario.registrarUsuario(usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Usuario usuario");
		usuario2.setCorreo("user@mail.cl");
		usuario2.setContrasenia("1234");
		usuario2.setRol(Rol.ROLE_USER);
		UsuarioDto usuarioDto2 = servicioUsuario.registrarUsuario(usuario2);
		
//************ DISPOSITIVO INICIAL ****************
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setNombre("ESP8266-1");
		dispositivo.setMac("60:01:94:61:B1:FD");
		dispositivo.setUbicacion("Puente Alto, villa cielo andino");
		dispositivo.setPrivacidad(PrivacidadDispositivo.ROLE_PUBLICO);
		DispositivoDto dispositivoDto  = servicioDispositivo.registrarDispositivo(dispositivo);
				
		
//************ DISPOSITIVO INICIAL ****************
		Dispositivo dispositivo2 = new Dispositivo();
		dispositivo2.setNombre("ESP8266-2");
		dispositivo2.setMac("2C:3A:E8:42:0E:53");
		dispositivo2.setUbicacion("Puente Alto, casas viejas");
		dispositivo2.setPrivacidad(PrivacidadDispositivo.ROLE_PUBLICO);
		DispositivoDto dispositivoDto2  = servicioDispositivo.registrarDispositivo(dispositivo2);
	
//********* VINCULACION DISPOSITIVO-USUARIO ************

//		ESCRITURA PARA MISMO DISPOSITIVO Y MUCHOS USUARIOS
//		usuario.asignarDispositivo(dispositivo);
//		servicioUsuario.actualizarUsuario(usuarioDto);	
//		usuario2.asignarDispositivo(dispositivo);
//		servicioUsuario.actualizarUsuario(usuarioDto2);
//		dispositivo.asignarUsuario(usuario);
//		servicioDispositivo.actualizarDispositivo(dispositivoDto);
//		dispositivo.asignarUsuario(usuario2);
//		servicioDispositivo.actualizarDispositivo(dispositivoDto);
		
//		ESCRITURA PARA MISMO USUARIOS Y MUCHOS DISPOSITIVOS		
		usuario.asignarDispositivo(dispositivo);
		servicioUsuario.actualizarUsuario(usuarioDto);	
		dispositivo.asignarUsuario(usuario);
		servicioDispositivo.actualizarDispositivo(dispositivoDto);

		usuario.asignarDispositivo(dispositivo2);
		servicioUsuario.actualizarUsuario(usuarioDto);	
		dispositivo2.asignarUsuario(usuario);
		servicioDispositivo.actualizarDispositivo(dispositivoDto2);

//		usuario2.asignarDispositivo(dispositivo2);
//		servicioUsuario.actualizarUsuario(usuarioDto2);
//		dispositivo2.asignarUsuario(usuario2);
//		servicioDispositivo.actualizarDispositivo(dispositivoDto2);
		
		
//************ SENSOR INICIAL ****************
		Sensor sensor = new Sensor();
		sensor.setNombre("MPU6050");
		sensor.setTipo(TipoSensor.ROLE_MOVIMIENTO);
		sensor.setDescripcion("Sensor para detectar movimiento en la tierra, cuando una persona esta realizando perforaciones");
		sensor.setDispositivo(dispositivo);
		servicioSensor.registrarSensor(sensor);

//************ SENSOR INICIAL ****************
		Sensor sensor2 = new Sensor();
		sensor2.setNombre("HCSR-04");
		sensor2.setTipo(TipoSensor.ROLE_DISTANCIA);
		sensor2.setDescripcion("Sensor para detectar la disitancia de un objeto");
		servicioSensor.registrarSensor(sensor2);


	}
}
