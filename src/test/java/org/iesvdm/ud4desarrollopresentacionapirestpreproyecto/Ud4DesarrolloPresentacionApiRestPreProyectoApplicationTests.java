package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto;

import jakarta.transaction.Transactional;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Horario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.ArteMarcialRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.HorarioRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.MaestroRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.SesionRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ud4DesarrolloPresentacionApiRestPreProyectoApplicationTests {

	@Autowired
	private HorarioRepository horarioRepository;

	@Autowired
	private MaestroRepository maestroRepository;
	@Autowired
	private ArteMarcialRepository arteMarcialRepository;
	@Autowired
	private SesionRepository sesionRepository;


	private static Maestro maestro1;
	private static Maestro maestro2;
	private static Maestro maestro3;
	private static Maestro maestro4;
	private static Maestro maestro5;

	private static Sesion sesion1;
	private static Sesion sesion2;
	private static Sesion sesion3;
	private static Sesion sesion4;
	private static Sesion sesion5;

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
	@BeforeAll
	static void contextLoads() {
		/*Creación de maestros*/
		maestro1 = new Maestro(1, "maestro1", "", "", "", new HashSet<>(), new HashSet<>());
		maestro2 = new Maestro(2, "maestro2", "", "", "", new HashSet<>(), new HashSet<>());
		maestro3 = new Maestro(3, "maestro3", "", "", "", new HashSet<>(), new HashSet<>());
		maestro4 = new Maestro(4, "maestro4", "", "", "", new HashSet<>(), new HashSet<>());
		maestro5 = new Maestro(5, "maestro5", "", "", "", new HashSet<>(), new HashSet<>());

		/*Creación de sets de artes marciales*/
		arteMarcial1 = new ArteMarcial(1, "art_1", new HashSet<>(), new HashSet<>());
		arteMarcial2 = new ArteMarcial(2, "art_2", new HashSet<>(), new HashSet<>());
		arteMarcial3 = new ArteMarcial(3, "art_3", new HashSet<>(), new HashSet<>());
		arteMarcial4 = new ArteMarcial(4, "art_4", new HashSet<>(), new HashSet<>());
		arteMarcial5 = new ArteMarcial(5, "art_5", new HashSet<>(), new HashSet<>());

		/*Creación de sesiones*/
		sesion1 = new Sesion(1, "ses_1", 3, true, null, new HashSet<>());
		sesion2 = new Sesion(2, "ses_2", 3, true, null, new HashSet<>());
		sesion3 = new Sesion(3, "ses_3", 3, true, null, new HashSet<>());
		sesion4 = new Sesion(4, "ses_4", 3, true, null, new HashSet<>());
		sesion5 = new Sesion(5, "ses_5", 3, true, null, new HashSet<>());

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
	void crearArtesMarciales(){
		arteMarcialRepository.save(arteMarcial1);
		arteMarcialRepository.save(arteMarcial2);
		arteMarcialRepository.save(arteMarcial3);
		arteMarcialRepository.save(arteMarcial4);
		arteMarcialRepository.save(arteMarcial5);
	}

	@Test
	@Order(2)
	void crearSesiones(){
		sesionRepository.save(sesion1);
		sesionRepository.save(sesion2);
		sesionRepository.save(sesion3);
		sesionRepository.save(sesion4);
		sesionRepository.save(sesion5);
	}

	@Test
	@Order(3)
	void asociarArteMarcialAMaestro(){
		arteMarcial1.setMaestros(maestros1);
		arteMarcial2.setMaestros(maestros2);
		arteMarcial3.setMaestros(maestros3);
		arteMarcial4.setMaestros(maestros4);
		arteMarcial5.setMaestros(maestros5);

		arteMarcialRepository.save(arteMarcial1);
		arteMarcialRepository.save(arteMarcial2);
		arteMarcialRepository.save(arteMarcial3);
		arteMarcialRepository.save(arteMarcial4);
		arteMarcialRepository.save(arteMarcial5);



		maestro1.setArtesMarciales(arteMarcialSet1);
		maestro2.setArtesMarciales(arteMarcialSet2);
		maestro3.setArtesMarciales(arteMarcialSet3);
		maestro4.setArtesMarciales(arteMarcialSet4);
		maestro5.setArtesMarciales(arteMarcialSet5);

		maestroRepository.save(maestro1);
		maestroRepository.save(maestro2);
		maestroRepository.save(maestro3);
		maestroRepository.save(maestro4);
		maestroRepository.save(maestro5);

	}

	@Test
	@Order(4)
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
	@Order(5)
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
	@Order(6)
	void testFindSesions() {
		Sesion sesion = new Sesion(0
				, "The Ultimate Warrior"
				, 10
				, true,new HashSet<>()
				, arteMarcialRepository.findById(1).get()
				,new HashSet<>());
		sesionRepository.save(sesion);

		Horario horario = Horario.builder()
				.fecha(LocalDate.now())
				.horaInicio(LocalTime.of(8, 15))
				.horaFin(LocalTime.of(10,30))
				.build();

		Horario horario2 = Horario.builder()
				.fecha(LocalDate.now())
				.horaInicio(LocalTime.of(18, 15))
				.horaFin(LocalTime.of(22,30))
				.build();

		this.horarioRepository.save(horario);
		this.horarioRepository.save(horario2);

		sesion.getHorarios().add(horario);
		sesion.getHorarios().add(horario2);

		sesionRepository.save(sesion);

	}

	@Test
	@Order(7)
	void testFindSesionHorarios()  {

		List<Sesion> sesionList = sesionRepository.findSesionsByArteMarcial_NombreIgnoreCaseOrderByHorarios_FechaAscHorarios_HoraInicioAsc("art_1");

		sesionList.forEach(System.out::println);

	}
}