package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.*;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.*;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.util.UtilJPA;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.beans.Transient;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ud4DesarrolloPresentacionApiRestPreProyectoApplicationTests {

	@Autowired
	EntityManager entityManager;
	@Autowired
	private PlatformTransactionManager transactionManager;
	private TransactionTemplate transactionTemplate;

	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired
	private MaestroRepository maestroRepository;
	@Autowired
	private ArteMarcialRepository arteMarcialRepository;
	@Autowired
	private SesionRepository sesionRepository;
	@Autowired
	private MaestroArteMarcialRepository maestroArteMarcialRepository;
	@Autowired
	private UsuarioArteMarcialRepository usuarioArteMarcialRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;


	private static Maestro maestro1;
	private static Maestro maestro2;
	private static Maestro maestro3;
	private static Maestro maestro4;
	private static Maestro maestro5;

	private static Usuario usuarioAdmin;
	private static Usuario usuario1;
	private static Usuario usuario2;
	private static Usuario usuario3;
	private static Usuario usuario4;
	private static Usuario usuario5;




	private static Sesion sesion1;
	private static Sesion sesion2;
	private static Sesion sesion3;
	private static Sesion sesion4;
	private static Sesion sesion5;

	private static Horario horario1;
	private static Horario horario2;
	private static Horario horario3;
	private static Horario horario4;
	private static Horario horario5;
	private static Horario horario6;
	private static Horario horario7;
	private static Horario horario8;
	private static Horario horario9;
	private static Horario horario10;

	private static ArteMarcial arteMarcial1;
	private static ArteMarcial arteMarcial2;
	private static ArteMarcial arteMarcial3;
	private static ArteMarcial arteMarcial4;
	private static ArteMarcial arteMarcial5;
	private static final Set<Maestro> maestros1 = new HashSet<>();
	private static final Set<Maestro> maestros2 = new HashSet<>();
	private static final Set<Maestro> maestros3 = new HashSet<>();
	private static final Set<Maestro> maestros4 = new HashSet<>();
	private static final Set<Maestro> maestros5 = new HashSet<>();

	private static final Set<ArteMarcial> arteMarcialSet1 = new HashSet<>();
	private static final Set<ArteMarcial> arteMarcialSet2 = new HashSet<>();
	private static final Set<ArteMarcial> arteMarcialSet3 = new HashSet<>();
	private static final Set<ArteMarcial> arteMarcialSet4 = new HashSet<>();
	private static final Set<ArteMarcial> arteMarcialSet5 = new HashSet<>();
	private static final Set<Sesion> sesionSet1 = new HashSet<>();
	private static final Set<Sesion> sesionSet2 = new HashSet<>();
	private static final Set<Sesion> sesionSet3 = new HashSet<>();
	private static final Set<Sesion> sesionSet4 = new HashSet<>();
	private static final Set<Sesion> sesionSet5 = new HashSet<>();
	private static Set<Usuario> usuarioSet1;
	private static Set<Usuario> usuarioSet2;
	private static Set<Usuario> usuarioSet3;
	private static Set<Usuario> usuarioSet4;
	private static Set<Usuario> usuarioSet5;
	private static Set<Maestro> maestroSet1 = new HashSet<>();
	private static Set<Maestro> maestroSet2 = new HashSet<>();
	private static Set<Maestro> maestroSet3 = new HashSet<>();
	private static Set<Maestro> maestroSet4 = new HashSet<>();
	private static Set<Maestro> maestroSet5 = new HashSet<>();

	@BeforeEach
	public void setUp() {
		transactionTemplate = new TransactionTemplate(transactionManager);
	}
	@BeforeAll
	static void contextLoads() {
		/*Creación de usuarios*/
		usuarioAdmin = new Usuario(1, "davidbq", "David", "davidbroglioquero@gmail.com", "1234", "Broglio Quero", "674622358", "admin", null, null);
		usuario1 = new Usuario(2, "usuario1", "usuario1", "usuario1@gmail.com", "1234", "usuario1", "666666666", "user", new HashSet<>(), null);
		usuario2 = new Usuario(3, "usuario2", "usuario2", "usuario2@gmail.com", "1234", "usuario2", "666666666", "user", new HashSet<>(), null);
		usuario3 = new Usuario(4, "usuario3", "usuario3", "usuario3@gmail.com", "1234", "usuario3", "666666666", "user", new HashSet<>(), null);
		usuario4 = new Usuario(5, "usuario4", "usuario4", "usuario4@gmail.com", "1234", "usuario4", "666666666", "user", new HashSet<>(), null);
		usuario5 = new Usuario(6, "usuario5", "usuario5", "usuario5@gmail.com", "1234", "usuario5", "666666666", "user", new HashSet<>(), null);

		usuarioSet1 = new HashSet<>();
		usuarioSet2 = new HashSet<>();
		usuarioSet3 = new HashSet<>();
		usuarioSet4 = new HashSet<>();
		usuarioSet5 = new HashSet<>();

		usuarioSet1.add(usuario1);
		usuarioSet1.add(usuario2);
		usuarioSet1.add(usuario5);
		usuarioSet2.add(usuario1);
		usuarioSet2.add(usuario2);
		usuarioSet2.add(usuario3);
		usuarioSet2.add(usuario4);
		usuarioSet3.add(usuario3);
		usuarioSet3.add(usuario4);
		usuarioSet3.add(usuario5);
		usuarioSet4.add(usuario1);
		usuarioSet4.add(usuario4);
		usuarioSet4.add(usuario5);
		usuarioSet5.add(usuario2);
		usuarioSet5.add(usuario3);




		/*Creación de maestros*/
		maestro1 = new Maestro(1, "maestro1", "ape1", "ape1", "666 66 66", "maestro1@thedojo.com" , new HashSet<>(), new HashSet<>());
		maestro2 = new Maestro(2, "maestro2", "ape2", "ape2", "666 66 66", "maestro2@thedojo.com", new HashSet<>(), new HashSet<>());
		maestro3 = new Maestro(3, "maestro3", "ape3", "ape3", "666 66 66", "maestro3@thedojo.com", new HashSet<>(), new HashSet<>());
		maestro4 = new Maestro(4, "maestro4", "ape4", "ape4", "666 66 66", "maestro4@thedojo.com",new HashSet<>(), new HashSet<>());
		maestro5 = new Maestro(5, "maestro5", "ape5", "ape5", "666 66 66", "maestro5@thedojo.com", new HashSet<>(), new HashSet<>());

		/*Creación de sets de artes marciales*/
		arteMarcial1 = new ArteMarcial(1, "art_1", new HashSet<>(), new HashSet<>(), new HashSet<>());
		arteMarcial2 = new ArteMarcial(2, "art_2", new HashSet<>(), new HashSet<>(), new HashSet<>());
		arteMarcial3 = new ArteMarcial(3, "art_3", new HashSet<>(), new HashSet<>(), new HashSet<>());
		arteMarcial4 = new ArteMarcial(4, "art_4", new HashSet<>(), new HashSet<>(), new HashSet<>());
		arteMarcial5 = new ArteMarcial(5, "art_5", new HashSet<>(), new HashSet<>(), new HashSet<>());

		/*Creación de Horarios*/
		horario1 = new Horario(1, 1, LocalTime.of(18, 30), LocalTime.of(19, 30), null);
		horario2 = new Horario(2, 1, LocalTime.of(19, 30), LocalTime.of(20, 30), null);
		horario3 = new Horario(3, 2, LocalTime.of(18, 30), LocalTime.of(19, 30), null);
		horario4 = new Horario(4, 2, LocalTime.of(19, 30), LocalTime.of(20, 30), null);
		horario5 = new Horario(5, 3, LocalTime.of(18, 30), LocalTime.of(19, 30), null);
		horario6 = new Horario(6, 3, LocalTime.of(19, 30), LocalTime.of(20, 30), null);
		horario7 = new Horario(7, 4, LocalTime.of(18, 30), LocalTime.of(19, 30), null);
		horario8 = new Horario(8, 4, LocalTime.of(19, 30), LocalTime.of(20, 30), null);
		horario9 = new Horario(9, 5, LocalTime.of(18, 30), LocalTime.of(19, 30), null);
		horario10 = new Horario(10, 5, LocalTime.of(19, 30), LocalTime.of(20, 30), null);

		Set<Horario> horarioSes1 = new HashSet<>();
		Set<Horario> horarioSes2 = new HashSet<>();
		Set<Horario> horarioSes3 = new HashSet<>();
		Set<Horario> horarioSes4 = new HashSet<>();
		Set<Horario> horarioSes5 = new HashSet<>();

		horarioSes1.add(horario1);
		horarioSes1.add(horario5);
		horarioSes2.add(horario3);
		horarioSes2.add(horario7);
		horarioSes3.add(horario2);
		horarioSes3.add(horario6);
		horarioSes4.add(horario4);
		horarioSes4.add(horario8);
		horarioSes5.add(horario9);
		horarioSes5.add(horario10);

		/*Creación de sesiones*/
		sesion1 = new Sesion(1, "ses_1", 3, true, horarioSes1, null, new HashSet<>(), new HashSet<>());
		sesion2 = new Sesion(2, "ses_2", 3, true, horarioSes2, null, new HashSet<>(), new HashSet<>());
		sesion3 = new Sesion(3, "ses_3", 3, true, horarioSes3, null, new HashSet<>(), new HashSet<>());
		sesion4 = new Sesion(4, "ses_4", 3, true, horarioSes4, null, new HashSet<>(), new HashSet<>());
		sesion5 = new Sesion(5, "ses_5", 3, true, horarioSes5, null, new HashSet<>(), new HashSet<>());

		/*Creación de sets de maestro*/
		maestros1.add(maestro1);
		maestros1.add(maestro5);

		maestros2.add(maestro2);
		maestros2.add(maestro3);
		maestros2.add(maestro5);

		maestros3.add(maestro1);
		maestros3.add(maestro4);
		maestros3.add(maestro3);

		maestros4.add(maestro2);

		maestros5.add(maestro1);
		maestros5.add(maestro5);

		maestroSet1.add(maestro1);
		maestroSet1.add(maestro2);
		maestroSet2.add(maestro1);
		maestroSet2.add(maestro2);
		maestroSet3.add(maestro3);
		maestroSet3.add(maestro4);
		maestroSet4.add(maestro4);
		maestroSet4.add(maestro5);
		maestroSet5.add(maestro5);

		/*Creación de sets de arte marcial*/
		arteMarcialSet1.add(arteMarcial1);
		arteMarcialSet1.add(arteMarcial2);

		arteMarcialSet2.add(arteMarcial1);

		arteMarcialSet3.add(arteMarcial3);
		arteMarcialSet3.add(arteMarcial4);
		arteMarcialSet3.add(arteMarcial5);

		arteMarcialSet4.add(arteMarcial4);
		arteMarcialSet4.add(arteMarcial5);

		arteMarcialSet5.add(arteMarcial5);

		/*Creación de sets de sesion*/
		sesionSet1.add(sesion1);
		sesionSet1.add(sesion2);

		sesionSet2.add(sesion3);
		sesionSet2.add(sesion1);

		sesionSet3.add(sesion5);
		sesionSet3.add(sesion4);
		sesionSet3.add(sesion2);

		sesionSet4.add(sesion1);

		sesionSet5.add(sesion5);
		sesionSet5.add(sesion3);

	}

	@Test
	@Order(0)
    void crearMaestros(){
		maestroRepository.save(maestro1);
		maestroRepository.save(maestro2);
		maestroRepository.save(maestro3);
		maestroRepository.save(maestro4);
		maestroRepository.save(maestro5);
	}
	@Test
	@Order(1)
	void crearHorarios(){
		horarioRepository.save(horario1);
		horarioRepository.save(horario2);
		horarioRepository.save(horario3);
		horarioRepository.save(horario4);
		horarioRepository.save(horario5);
		horarioRepository.save(horario6);
		horarioRepository.save(horario7);
		horarioRepository.save(horario8);
		horarioRepository.save(horario9);
		horarioRepository.save(horario10);

	}
	@Test
	@Order(2)
	void crearArtesMarciales(){
		arteMarcialRepository.save(arteMarcial1);
		arteMarcialRepository.save(arteMarcial2);
		arteMarcialRepository.save(arteMarcial3);
		arteMarcialRepository.save(arteMarcial4);
		arteMarcialRepository.save(arteMarcial5);
	}
	@Test
	@Order(3)
	void crearUsuarios(){
		usuarioRepository.save(usuarioAdmin);
		usuarioRepository.save(usuario1);
		usuarioRepository.save(usuario2);
		usuarioRepository.save(usuario3);
		usuarioRepository.save(usuario4);
		usuarioRepository.save(usuario5);

	}
	@Test
	@Order(4)
	void crearSesiones(){
		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);
	}

	@Test
	@Order(5)
	void asociarArteMarcialAMaestro(){




		Set<MaestroArteMarcial> maestroArteMarcials = new HashSet<>();
		Set<MaestroArteMarcial> maestroArteMarcials1 = new HashSet<>();
		Set<MaestroArteMarcial> maestroArteMarcials2 = new HashSet<>();
		Set<MaestroArteMarcial> maestroArteMarcials3 = new HashSet<>();
		Set<MaestroArteMarcial> maestroArteMarcials4 = new HashSet<>();

		MaestroArteMarcial maestroArteMarcial1 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro1, arteMarcial1), "3º dan");
		MaestroArteMarcial maestroArteMarcial2 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro1, arteMarcial2), "5º dan");
		MaestroArteMarcial maestroArteMarcial3 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro2, arteMarcial3), "4º dan");
		MaestroArteMarcial maestroArteMarcial4 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro2, arteMarcial4), "4º dan");
		MaestroArteMarcial maestroArteMarcial5 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro3, arteMarcial1), "5º dan");
		MaestroArteMarcial maestroArteMarcial6 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro3, arteMarcial3), "3º dan");
		MaestroArteMarcial maestroArteMarcial7 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro3, arteMarcial4), "4º dan");
		MaestroArteMarcial maestroArteMarcial8 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro4, arteMarcial4), "7º dan");
		MaestroArteMarcial maestroArteMarcial9 = new MaestroArteMarcial(new MaestroArteMarcial.Pk(maestro5, arteMarcial5), "8º dan");

		maestroArteMarcials.add(maestroArteMarcial1);
		maestroArteMarcials.add(maestroArteMarcial2);
		maestroArteMarcials1.add(maestroArteMarcial3);
		maestroArteMarcials1.add(maestroArteMarcial4);
		maestroArteMarcials2.add(maestroArteMarcial5);
		maestroArteMarcials2.add(maestroArteMarcial6);
		maestroArteMarcials2.add(maestroArteMarcial7);
		maestroArteMarcials3.add(maestroArteMarcial8);
		maestroArteMarcials4.add(maestroArteMarcial9);




		maestro1.setMaestroArteMarcials(maestroArteMarcials);
		maestro2.setMaestroArteMarcials(maestroArteMarcials1);
		maestro3.setMaestroArteMarcials(maestroArteMarcials2);
		maestro4.setMaestroArteMarcials(maestroArteMarcials3);
		maestro5.setMaestroArteMarcials(maestroArteMarcials4);

		maestroArteMarcialRepository.save(maestroArteMarcial1);
		maestroArteMarcialRepository.save(maestroArteMarcial2);
		maestroArteMarcialRepository.save(maestroArteMarcial3);
		maestroArteMarcialRepository.save(maestroArteMarcial4);
		maestroArteMarcialRepository.save(maestroArteMarcial5);
		maestroArteMarcialRepository.save(maestroArteMarcial6);
		maestroArteMarcialRepository.save(maestroArteMarcial7);
		maestroArteMarcialRepository.save(maestroArteMarcial8);
		maestroArteMarcialRepository.save(maestroArteMarcial9);




		maestroRepository.save(maestro1);
		maestroRepository.save(maestro2);
		maestroRepository.save(maestro3);
		maestroRepository.save(maestro4);
		maestroRepository.save(maestro5);

	}

	@Test
	@Order(6)
	void asociarArteMarcialASesion() {

		sesionSet1.add(sesion3);
		sesionSet1.add(sesion5);

		arteMarcial1.setSesiones(sesionSet1);
		arteMarcial2.setSesiones(sesionSet2);
		arteMarcial3.setSesiones(sesionSet3);
		arteMarcial4.setSesiones(sesionSet4);
		arteMarcial5.setSesiones(sesionSet5);

		arteMarcialRepository.save(arteMarcial1);
		arteMarcialRepository.save(arteMarcial2);
		arteMarcialRepository.save(arteMarcial3);
		arteMarcialRepository.save(arteMarcial4);
		arteMarcialRepository.save(arteMarcial5);

		sesion1.setArteMarcial(arteMarcial1);
		sesion2.setArteMarcial(arteMarcial2);
		sesion3.setArteMarcial(arteMarcial3);
		sesion4.setArteMarcial(arteMarcial4);
		sesion5.setArteMarcial(arteMarcial5);

		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);
	}
	@Test
	@Order(7)
	void asociarArteMarcialConUsuario(){
		Set<UsuarioArteMarcial> usuarioArteMarcials = new HashSet<>();
		Set<UsuarioArteMarcial> usuarioArteMarcials1 = new HashSet<>();
		Set<UsuarioArteMarcial> usuarioArteMarcials2 = new HashSet<>();
		Set<UsuarioArteMarcial> usuarioArteMarcials3 = new HashSet<>();
		Set<UsuarioArteMarcial> usuarioArteMarcials4 = new HashSet<>();

		UsuarioArteMarcial usuarioArteMarcial1 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario1, arteMarcial1), "3º dan");
		UsuarioArteMarcial usuarioArteMarcial2 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario1, arteMarcial2), "cinturón blanco");
		UsuarioArteMarcial usuarioArteMarcial3 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario2, arteMarcial3), "1º dan");
		UsuarioArteMarcial usuarioArteMarcial4 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario2, arteMarcial4), "2º dan");
		UsuarioArteMarcial usuarioArteMarcial5 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario3, arteMarcial1), "cinturón negro");
		UsuarioArteMarcial usuarioArteMarcial6 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario3, arteMarcial3), "cinturón azul");
		UsuarioArteMarcial usuarioArteMarcial7 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario3, arteMarcial4), "cinturón rojo");
		UsuarioArteMarcial usuarioArteMarcial8 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario4, arteMarcial4), "cinturón amarillo");
		UsuarioArteMarcial usuarioArteMarcial9 = new UsuarioArteMarcial(new UsuarioArteMarcial.Pk(usuario5, arteMarcial5), "1º dan");

		usuarioArteMarcials.add(usuarioArteMarcial1);
		usuarioArteMarcials.add(usuarioArteMarcial2);
		usuarioArteMarcials1.add(usuarioArteMarcial3);
		usuarioArteMarcials1.add(usuarioArteMarcial4);
		usuarioArteMarcials2.add(usuarioArteMarcial5);
		usuarioArteMarcials2.add(usuarioArteMarcial6);
		usuarioArteMarcials2.add(usuarioArteMarcial7);
		usuarioArteMarcials3.add(usuarioArteMarcial8);
		usuarioArteMarcials4.add(usuarioArteMarcial9);




		usuario1.setUsuarioArteMarcials(usuarioArteMarcials);
		usuario2.setUsuarioArteMarcials(usuarioArteMarcials1);
		usuario3.setUsuarioArteMarcials(usuarioArteMarcials2);
		usuario4.setUsuarioArteMarcials(usuarioArteMarcials3);
		usuario5.setUsuarioArteMarcials(usuarioArteMarcials4);

		usuarioArteMarcialRepository.save(usuarioArteMarcial1);
		usuarioArteMarcialRepository.save(usuarioArteMarcial2);
		usuarioArteMarcialRepository.save(usuarioArteMarcial3);
		usuarioArteMarcialRepository.save(usuarioArteMarcial4);
		usuarioArteMarcialRepository.save(usuarioArteMarcial5);
		usuarioArteMarcialRepository.save(usuarioArteMarcial6);
		usuarioArteMarcialRepository.save(usuarioArteMarcial7);
		usuarioArteMarcialRepository.save(usuarioArteMarcial8);
		usuarioArteMarcialRepository.save(usuarioArteMarcial9);




		usuarioRepository.save(usuario1);
		usuarioRepository.save(usuario2);
		usuarioRepository.save(usuario3);
		usuarioRepository.save(usuario4);
		usuarioRepository.save(usuario5);
	}

	@Test
	@Order(8)
	void asociarSesionConMaestro(){
		sesion1.setMaestros(maestros1);
		sesion2.setMaestros(maestros2);
		sesion3.setMaestros(maestros3);
		sesion4.setMaestros(maestros4);
		sesion5.setMaestros(maestros5);

		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);

		maestro1.setSesiones(sesionSet1);
		maestro2.setSesiones(sesionSet2);
		maestro3.setSesiones(sesionSet3);
		maestro4.setSesiones(sesionSet4);
		maestro5.setSesiones(sesionSet5);

		maestroRepository.save(maestro1);
		maestroRepository.save(maestro2);
		maestroRepository.save(maestro3);
		maestroRepository.save(maestro4);
		maestroRepository.save(maestro5);
	}
	@Test
	@Order(9)
	void asociarSesionConUsuario(){
		sesion1.setUsuarios(usuarioSet1);
		sesion2.setUsuarios(usuarioSet2);
		sesion3.setUsuarios(usuarioSet3);
		sesion4.setUsuarios(usuarioSet4);
		sesion4.setUsuarios(usuarioSet5);

		usuario1.setSesiones(sesionSet1);
		usuario2.setSesiones(sesionSet2);
		usuario3.setSesiones(sesionSet3);
		usuario4.setSesiones(sesionSet4);
		usuario5.setSesiones(sesionSet5);

		usuarioRepository.save(usuario1);
		usuarioRepository.save(usuario2);
		usuarioRepository.save(usuario3);
		usuarioRepository.save(usuario4);
		usuarioRepository.save(usuario5);


		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);
	}
	@Test
	@Order(10)
	void asociarSesionConArteMarcial(){
		sesion1.setArteMarcial(arteMarcial1);
		sesion2.setArteMarcial(arteMarcial2);
		sesion3.setArteMarcial(arteMarcial3);
		sesion4.setArteMarcial(arteMarcial4);
		sesion5.setArteMarcial(arteMarcial5);

		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);

	}

}