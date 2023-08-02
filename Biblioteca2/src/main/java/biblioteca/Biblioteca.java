package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import biblioteca.Usuario.Empleado;
import biblioteca.Usuario.Socio;
import biblioteca.Usuario.Supervisor;
import biblioteca.conexion.Database;
import biblioteca.prestamo.Autor;
import biblioteca.prestamo.Editorial;
import biblioteca.prestamo.Ejemplar;
import biblioteca.prestamo.Genero;
import biblioteca.prestamo.Libro;
import biblioteca.prestamo.Prestamo;
import biblioteca.prestamo.Revista;

public class Biblioteca {
	
	
	private static ArrayList<Empleado> empleados;
	private static ArrayList<Supervisor> supervisores;
	private static ArrayList<Socio> socios;
	private static ArrayList<Ejemplar> ejemplares;
	private static ArrayList<Prestamo> prestamos;
	private static ArrayList<DiaSemana> horario;
	private static Map<String,Date> fechaMultas;
	private static Empleado empleadoActual;
	private static Supervisor supervisorActual;
        

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
                try {
                Database d = new Database();
                d.testConnection();
            } catch (Exception e) {
            }
		empleados = new ArrayList<Empleado>();
		supervisores = new ArrayList<Supervisor>();
		socios = new ArrayList<Socio>();
		ejemplares = new ArrayList<Ejemplar>();
		prestamos = new ArrayList<Prestamo>();
		horario = new ArrayList<DiaSemana>();
		fechaMultas = new HashMap<>();   
		
		Socio socio1 = new Socio("Joaquin","Contreras",20,"4123","1");
        Socio socio2 = new Socio("Pepe","Antonietez",20,"1243","2");
            
        
        Autor autor1 = new Autor("Pepe");
		Autor autor2 = new Autor("Pepa");
		Genero genero1 = Genero.POLICIAL;
		Genero genero2 = Genero.INFORMATIVO;
		Editorial editorial1 = new Editorial("San Agust");
		Editorial editorial2 = new Editorial("San Pepe");
		
		ArrayList<Autor> autores = new ArrayList<Autor>();
		ArrayList<Genero> generos = new ArrayList<Genero>();
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		autores.add(autor1);
		autores.add(autor2);
		generos.add(genero1);
		generos.add(genero2);
		editoriales.add(editorial1);
		editoriales.add(editorial2);
		
		Libro libro1 = new Libro ("San Juan","43SB",editoriales,autores,generos);
		Libro libro2 = new Libro ("Pepe","43SK",editoriales,autores,generos);
		
		Revista revista = new Revista("3201","Santa Paola",editoriales);
		Revista revista2 = new Revista("3201","Santa Paola",editoriales);
		Revista revista3 = new Revista("3202","Santa Paola",editoriales);
		
		Ejemplar ejemplar1 =  new Ejemplar("1",libro1);
		Ejemplar ejemplar2 =  new Ejemplar("2",revista);
        
		socio1.setPenalizacion(true);
		
        socios.add(socio1);
        socios.add(socio2);
        
        
        ejemplares.add(ejemplar1);
        ejemplares.add(ejemplar2);
        
        
        
		
		// Crear un supervisor
        Supervisor supervisor = new Supervisor("Pedro", "Gomez", 35, "98765432","pepe","1");

        // Crear un empleado
        Empleado empleado1 = new Empleado("1","Juan", "Perez", 25, "12345678", new Date("20/02/2023"), supervisor);
        Empleado empleado2 = new Empleado("2","Juan", "Perez", 25, "122145678", new Date("20/02/2023"), supervisor);
        
        empleado1.agregarSocioPrestado(socio1);
        
        // Agregar empleados al supervisor
        supervisor.agregarEmpleado(empleado1);
        supervisor.agregarEmpleado(empleado2);
        
        Date fechaFichado1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("10-05-2023 09:00:00");
        Date fechaFichado2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("11-05-2023 16:00:00");
        Date fechaFichado3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("12-05-2023 09:00:00");
        Date fechaFichado4 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("13-05-2023 16:00:00");
        Date fechaFichado5 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("14-05-2023 09:00:00");
        Date fechaFichado6 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("15-05-2023 16:00:00");
        Date fechaFichado7 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("16-05-2023 09:00:00");
        Date fechaFichado8 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("17-05-2023 16:00:00");
        Date fechaFichado9 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("18-05-2023 09:00:00");
        Date fechaFichado10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("19-05-2023 16:00:00");
        
        //Fichar al empleado
        
        empleado1.entrar(fechaFichado1);
        empleado1.salir(fechaFichado2);
        empleado1.entrar(fechaFichado3);
        empleado1.salir(fechaFichado4);
        empleado1.entrar(fechaFichado5);
        empleado1.salir(fechaFichado6);
        empleado1.entrar(fechaFichado7);
        empleado1.salir(fechaFichado8);
        empleado1.entrar(fechaFichado9);
        empleado1.salir(fechaFichado10);
        
        empleado2.entrar(fechaFichado1);
        empleado2.salir(fechaFichado2);
        empleado2.entrar(fechaFichado3);
        empleado2.salir(fechaFichado4);
        empleado2.entrar(fechaFichado5);
        empleado2.salir(fechaFichado6);
        empleado2.entrar(fechaFichado7);
        empleado2.salir(fechaFichado8);
        
        supervisores.add(supervisor);
        empleados.add(empleado1);
        empleados.add(empleado2);
		
        Prestamo prestamo1 = new Prestamo(socio1,ejemplares,"1",new Date(123, 4, 7),new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000),empleado1);
        
        prestamos.add(prestamo1);
        
		DiaSemana lunes = DiaSemana.LUNES;
		DiaSemana martes = DiaSemana.MARTES;
		DiaSemana miercoles = DiaSemana.MIERCOLES;
		DiaSemana jueves = DiaSemana.JUEVES;
		DiaSemana viernes = DiaSemana.VIERNES;
		DiaSemana sabado = DiaSemana.SABADO;
		
		horario.add(lunes);
		horario.add(martes);
		horario.add(miercoles);
		horario.add(jueves);
		horario.add(viernes);
		horario.add(sabado);
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("Iniciando.... ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("¿Eres un empleado o un supervisor?");
			System.out.println("1. Supervisor");
			System.out.println("2. Empleado");
			System.out.println("3. Apagar Sistema");
			System.out.println("Seleccione una opcion");
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch(opcion) {
				case 1 -> {
                                    System.out.println();
                                    comprobarSupervisor();
                        }
				case 2 -> {
                                    System.out.println("Dime tú id de empleado: ");
                                    String id = scanner.nextLine();
                                    System.out.println();
                                    for(Empleado e:empleados) {
                                        if(e.getIdEmpleado().equals(id)) {
                                            empleadoActual = e;
                                            System.out.println("Bienvenido " + e.getNombre());
                                            empleadoActual.entrar(new Date());
                                            main();
                                        }
                                    }
                        }
				case 3 -> System.out.println("Apagando...");
				default -> System.out.println("Opción NO valida");
			}
		}while(opcion!=3);
		
		
		
	}
	
	
	public static void main() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			comprobarLibrosDevueltos();
		      System.out.println("----- Menú -----");
		      System.out.println("1. Menu de usuarios");
		      System.out.println("2. Menu Ejemplares");
		      System.out.println("3. Menu prestamos");
		      System.out.println("4. Ver horarios");
		      System.out.println("5. Salir");
		      System.out.print("Selecciona una opción: ");
		         opcion = scanner.nextInt();

		          switch (opcion) {
		           case 1:
		              menuUsuario();
		                    
		               break;
		           case 2:
		        	   menuEjemplares();
		              
		                    
		              break;
		           case 3:
		        	   menuPrestamos();
		        	   
		                    
		               break;
		           case 4:
		               verHorario();
		               break;
		           case 5:
		               System.out.println("¡Hasta luego!");
		               empleadoActual.salir(new Date());
		               break;
		           default:
		              System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
		              break;
		         }

		            System.out.println(); // Línea en blanco para separar las iteraciones del menú
		        } while (opcion != 5);

		        
		    
		

		     
	}
	
	public static void comprobarSupervisor() {
		Scanner sc = new Scanner(System.in);
		String contra = "";
		System.out.println("¿Cual es tú id?");
		String id = sc.nextLine();
		for(Supervisor s:supervisores) {
			if(s.getIdSupervisor().equals(id)) {
				System.out.println("¿Cual es la contraseña? ");
				contra = sc.nextLine();
				if(s.getContrasena().equals(contra)) {
					supervisorActual = s;
					supervisorActual.entrar(new Date());
					menuSupervisor();
				}
			}
		}
	}
	
	public static void menuSupervisor() {
		Scanner scanner = new Scanner(System.in);
	    int opcion;

	    do {
	        System.out.println("== Menú Supervisor" + supervisorActual.getNombre()+ "==");
	        System.out.println("1. Ver empleados que trabajan en la biblioteca");
	        System.out.println("2. Ver empleados que supervisas");
	        System.out.println("3. Agregar empleado supervisar");
	        System.out.println("4. Mostrar cantidad de socios atendidos y prestamos por empleado");
	        System.out.println("5. Control de horas de este mes");
	        System.out.println("6. Productividad de todos los empleados");
	        System.out.println("7. Salir");
	        System.out.println("Empleados a total que supervisas: " + supervisorActual.getEmpleados().size());
	        System.out.print("Seleccione una opción: ");
	        opcion = scanner.nextInt();

	        scanner.nextLine(); 

	        switch (opcion) {
	            case 1:
	                mostrarEmpleados();
	                break;
	            case 2:
	                verEmpleadosSupervisados();
	                break;
	            case 3:
	                agregarEmpleado();
	                break;
	            case 4:
	                mostrarSociosEmpleados();
	                break;
	            case 5:
	            	controlDeHorasEmpleado();
	            	break;
	            case 6:
	                productividadDeLosEmpleados();
	                break;
	            
	            case 7:
	                System.out.println("Saliendo del menú Ejemplares...");
	                
	                for(Supervisor s:supervisores) {
	                	if(s.getIdSupervisor().equals(supervisorActual.getIdSupervisor())) {
	                		supervisores.remove(s);
	                		supervisores.add(supervisorActual);
	                		Collections.sort(supervisores);
	                	}
	                }
	                break;
	            default:
	                System.out.println("Opción inválida.");
	                break;
	        }

	        System.out.println();
	    } while (opcion != 7);
	}
	
	private static void controlDeHorasEmpleado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cual empleado quieres comprobar sus horas de este mes?");		
		for(Empleado p:supervisorActual.getEmpleados()) {
			System.out.println(p.toString());
		}
		
		Date fechaActual = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaActual);
		calendario.add(Calendar.MONTH, -1);
		Date mesAnterior = calendario.getTime();
		
		String idSocio = sc.nextLine();
		for(Empleado p:supervisorActual.getEmpleados()) {
			if(p.getIdEmpleado().equals(idSocio)) {
				supervisorActual.controlDeHoras(p,mesAnterior,fechaActual);
			}
		}
	}


	private static void productividadDeLosEmpleados() {
		System.out.println("Productividad de los empleados: ");
		supervisorActual.productividadTodosLosTrabajadores();
		
	}


	private static void mostrarSociosEmpleados() {
		int i = 0;
		for(Empleado p: empleados) {
			System.out.println("El empleado " + p.getNombre() +" atendio y hizo prestamo a los socios:");
			for(Socio s: p.getSociosPrestados()) {
				i++;
				System.out.println(s.toString());
			}
			System.out.println("Atendio un total de: " +i);
			i=0;
		}
		
	}


	private static void agregarEmpleado() {
		Scanner sc = new Scanner(System.in);
		String idEmpleado = "";
		String nombre = "";
		String apellido = "";
		int edad = 0;
		String dni = "";
		Date fechaAlta = new Date();
		
		System.out.println("NO pueden ser los siguientes empleados id");
		for(Empleado p :empleados) {
			System.out.println(p.getIdEmpleado());
			System.out.println();
		}
		System.out.println("ID:");
		idEmpleado = sc.nextLine();
		
		for(Empleado p :empleados) {
			if(p.getIdEmpleado().equalsIgnoreCase(idEmpleado)) {
				System.out.println("NO puede ser iguales a los ID mostrados");
				return;
			}			
		}
		
		System.out.println("Nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Apellido: ");
		apellido = sc.nextLine();
		
		sc.nextLine();
		System.out.println("Edad:");
		edad = sc.nextInt();
		
		sc.nextLine();
		System.out.println("DNI:");
		dni = sc.nextLine();
		
		Empleado e = new Empleado(idEmpleado,nombre,apellido,edad,dni,fechaAlta,supervisorActual);
		empleados.add(e);
		Collections.sort(empleados);
		System.out.println("EMPLEADO agredo exitosamente");
	}


	private static void verEmpleadosSupervisados() {
		System.out.println("Empleados supervisados");
		for(Empleado p : supervisorActual.getEmpleados()) {
			System.out.println(p.toString());
		}
	}


	private static void mostrarEmpleados() {
		for(Empleado p: empleados) {
			System.out.println(p.toString());
		}
		
	}


	public static void menuEjemplares() {
	    Scanner scanner = new Scanner(System.in);
	    int opcion;

	    do {
	        System.out.println("== Menú Ejemplares ==");
	        System.out.println("1. Crear ejemplar");
	        System.out.println("2. Leer ejemplares");
	        System.out.println("3. Actualizar ejemplar");
	        System.out.println("4. Eliminar ejemplar");
	        System.out.println("5. Buscar ejemplar libro");
	        System.out.println("6. Buscar ejemplar revista");
	        System.out.println("7. Salir");
	        System.out.print("Seleccione una opción: ");
	        opcion = scanner.nextInt();

	        scanner.nextLine(); // Consumir nueva línea después de nextInt()

	        switch (opcion) {
	            case 1:
	                crearEjemplar();
	                break;
	            case 2:
	                leerEjemplares();
	                break;
	            case 3:
	                actualizarEjemplar();
	                break;
	            case 4:
	                eliminarEjemplar();
	                break;
	            case 5:
	                buscarEjemplarLibro();
	                break;
	            case 6:
	                buscarEjemplarRevista();
	                break;
	            case 7:
	                System.out.println("Saliendo del menú Ejemplares...");
	                break;
	            default:
	                System.out.println("Opción inválida.");
	                break;
	        }

	        System.out.println();
	    } while (opcion != 7);
	}
	
	
	public static void crearEjemplar() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("1. Crear ejemplar de libro");
	    System.out.println("2. Crear ejemplar de revista");
	    System.out.print("Seleccione el tipo de ejemplar a crear: ");
	    int tipoEjemplar = scanner.nextInt();

	    scanner.nextLine(); // Consumir nueva línea después de nextInt()

	    System.out.print("Ingrese el ID del ejemplar: ");
	    String idEjemplar = scanner.nextLine();
	    if (idEjemplar.isBlank()) {
	        System.out.println("El ID del ejemplar no puede estar vacío.");
	        return;
	    }

	    // Verificar si el ID del ejemplar ya existe en el ArrayList<Ejemplar>
	    for (Ejemplar ejemplarExistente : ejemplares) {
	        if (ejemplarExistente.getIdEjemplar().equals(idEjemplar)) {
	            System.out.println("El ID del ejemplar ya existe.");
	            return;
	        }
	    }

	    if (tipoEjemplar == 1) {
	        System.out.print("Ingrese el título del libro: ");
	        String tituloLibro = scanner.nextLine();
	        if (tituloLibro.length() < 2) {
	            System.out.println("El título del libro debe contener al menos 2 caracteres.");
	            return;
	        }

	        System.out.print("Ingrese el ISBN del libro: ");
	        String isbnLibro = scanner.nextLine();
	        
	        if(!isbnLibro.isEmpty()) {
	        	if(isbnLibro.length()>=1) {
	        		
	        	}else {
	        		System.out.println("DEBE TENER AL MENOS UN CARACTER");
	        		return;
	        	}
	        }else {
	        	System.out.println("NO puede estar vacio el ISBN");
	        	return;
	        }

	        ArrayList<Editorial> editorialesLibro = new ArrayList<Editorial>();
	        String editorialLibro;
	        do {
	            System.out.print("Ingrese la editorial del libro (deje en blanco para finalizar): ");
	            editorialLibro = scanner.nextLine();
	            if (!editorialLibro.isBlank()) {
	                editorialesLibro.add(new Editorial(editorialLibro));
	            }
	        } while (!editorialLibro.isBlank());

	        ArrayList<Autor> autoresLibro = new ArrayList<Autor>();
	        String autorLibro;
	        do {
	            System.out.print("Ingrese el autor del libro (deje en blanco para finalizar): ");
	            autorLibro = scanner.nextLine();
	            if (!autorLibro.isBlank()) {
	                autoresLibro.add(new Autor(autorLibro));
	            }
	        } while (!autorLibro.isBlank());

	        if (editorialesLibro.isEmpty()) {
	            System.out.println("El libro debe tener al menos una editorial.");
	            return;
	        }

	        if (autoresLibro.isEmpty()) {
	            System.out.println("El libro debe tener al menos un autor.");
	            return;
	        }

	        ArrayList<Genero> generosLibro = new ArrayList<Genero>();
	        String generoLibro;
	        do {
	            System.out.print("Ingrese el género del libro (deje en blanco para finalizar): ");
	            generoLibro = scanner.nextLine();
	            if (!generoLibro.isBlank()) {
	                try {
	                    Genero generoSeleccionado = Genero.valueOf(generoLibro.toUpperCase());
	                    generosLibro.add(generoSeleccionado);
	                } catch (IllegalArgumentException e) {
	                    System.out.println("Género inválido. Por favor, ingrese un género válido.");
	                }
	            }
	        } while (!generoLibro.isBlank());

	        if (generosLibro.isEmpty()) {
	            System.out.println("El libro debe tener al menos un género.");
	            return;
	        }

	        Libro libro = new Libro(tituloLibro, isbnLibro, editorialesLibro, autoresLibro, generosLibro);
	        Ejemplar ejemplar = new Ejemplar(idEjemplar, libro);
	        ejemplares.add(ejemplar);

	        System.out.println("Ejemplar de libro creado exitosamente.");
	    } else if (tipoEjemplar == 2) {
	        System.out.print("Ingrese el título de la revista: ");
	        String tituloRevista = scanner.nextLine();
	        if (tituloRevista.isBlank() || tituloRevista.length() < 2) {
	            System.out.println("El título de la revista no puede estar vacío y debe tener al menos 2 caracteres.");
	            return;
	        }

	        ArrayList<Editorial> editorialesRevista = new ArrayList<Editorial>();
	        String editorialRevista;
	        do {
	            System.out.print("Ingrese la editorial de la revista (deje en blanco para finalizar): ");
	            editorialRevista = scanner.nextLine();
	            if (!editorialRevista.isBlank()) {
	                editorialesRevista.add(new Editorial(editorialRevista));
	            }
	        } while (!editorialRevista.isBlank());

	        if (editorialesRevista.isEmpty()) {
	            System.out.println("La revista debe tener al menos una editorial.");
	            return;
	        }

	        Revista revista = new Revista(idEjemplar, tituloRevista, editorialesRevista);
	        Ejemplar ejemplar = new Ejemplar(idEjemplar, revista);
	        ejemplares.add(ejemplar);

	        System.out.println("Ejemplar de revista creado exitosamente.");
	    } else {
	        System.out.println("Tipo de ejemplar inválido.");
	    }
	}




	public static void leerEjemplares() {
	    if (ejemplares.isEmpty()) {
	        System.out.println("No hay ejemplares registrados en la biblioteca.");
	    } else {
	        // Ordenar los ejemplares en orden natural
	        Collections.sort(ejemplares);

	        System.out.println("Lista de ejemplares:");
	        for (Ejemplar ejemplar : ejemplares) {
	            System.out.println(ejemplar.toString());
	            System.out.println();
	        }
	    }
	}
	
	public static void actualizarEjemplar() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Ingrese el ID del ejemplar a actualizar: ");
	    String idEjemplar = scanner.nextLine();

	    Ejemplar ejemplarEncontrado = null;
	    for (Ejemplar ejemplar : ejemplares) {
	        if (ejemplar.getIdEjemplar().equals(idEjemplar)) {
	            ejemplarEncontrado = ejemplar;
	            break;
	        }
	    }

	    if (ejemplarEncontrado == null) {
	        System.out.println("No se encontró ningún ejemplar con el ID especificado.");
	    } else {
	        System.out.println("Ejemplar encontrado:");
	        System.out.println(ejemplarEncontrado.toString());
	        System.out.println();

	        System.out.println("Seleccione la información a actualizar:");
	        System.out.println("1. Título");
	        if (ejemplarEncontrado.getLibro() != null) {
	            System.out.println("2. Autores");
	            System.out.println("3. Editorial");
	            System.out.println("4. Géneros");
	        } else if (ejemplarEncontrado.getRevista() != null) {
	            System.out.println("2. Editoriales");
	        }
	        System.out.print("Ingrese el número correspondiente: ");
	        int opcion = scanner.nextInt();

	        scanner.nextLine(); // Consumir nueva línea después de nextInt()

	        switch (opcion) {
	            case 1:
	                System.out.print("Ingrese el nuevo título del ejemplar: ");
	                String nuevoTitulo = scanner.nextLine();
	                if (ejemplarEncontrado.getLibro() != null) {
	                    ejemplarEncontrado.getLibro().setTitulo(nuevoTitulo);
	                } else if (ejemplarEncontrado.getRevista() != null) {
	                    ejemplarEncontrado.getRevista().setTitulo(nuevoTitulo);
	                }
	                break;
	            case 2:
	                if (ejemplarEncontrado.getLibro() != null) {
	                    System.out.print("Ingrese el nuevo listado de autores (separados por comas): ");
	                    String autoresInput = scanner.nextLine();
	                    String[] autoresArray = autoresInput.split(",");
	                    ArrayList<Autor> autores = new ArrayList<>();
	                    for (String autorNombre : autoresArray) {
	                        Autor autor = new Autor(autorNombre.trim());
	                        autores.add(autor);
	                    }
	                    ejemplarEncontrado.getLibro().setAutores(autores);
	                } else if (ejemplarEncontrado.getRevista() != null) {
	                    System.out.print("Ingrese el nuevo listado de editoriales (separados por comas): ");
	                    String editorialesInput = scanner.nextLine();
	                    String[] editorialesArray = editorialesInput.split(",");
	                    ArrayList<Editorial> editoriales = new ArrayList<>();
	                    for (String editorialNombre : editorialesArray) {
	                        Editorial editorial = new Editorial(editorialNombre.trim());
	                        editoriales.add(editorial);
	                    }
	                    ejemplarEncontrado.getRevista().setEditoriales(editoriales);
	                }
	                break;
	            case 3:
	                if (ejemplarEncontrado.getLibro() != null) {
	                    System.out.print("Ingrese la nueva editorial del libro: ");
	                    String nuevaEditorial = scanner.nextLine();
	                    Editorial editorial = new Editorial(nuevaEditorial);
	                    ArrayList<Editorial> editoriales = new ArrayList<>();
	                    editoriales.add(editorial);
	                    ejemplarEncontrado.getLibro().setEditorial(editoriales);
	                } else if (ejemplarEncontrado.getRevista() != null) {
	                    System.out.print("Ingrese el nuevo listado de editoriales (separados por comas): ");
	                    String editorialesInput = scanner.nextLine();
	                    String[] editorialesArray = editorialesInput.split(",");
	                    ArrayList<Editorial> editoriales = new ArrayList<>();
	                    for (String editorialNombre : editorialesArray) {
	                        Editorial editorial = new Editorial(editorialNombre.trim());
	                        editoriales.add(editorial);
	                    }
	                    ejemplarEncontrado.getRevista().setEditoriales(editoriales);
	                }
	                break;
	            case 4:
	                if (ejemplarEncontrado.getLibro() != null) {
	                    System.out.print("Ingrese el nuevo género del libro: ");
	                    String nuevoGenero = scanner.nextLine();
	                    Genero genero = Genero.valueOf(nuevoGenero.toUpperCase());
	                    ArrayList<Genero> generos = new ArrayList<>();
	                    generos.add(genero);
	                    ejemplarEncontrado.getLibro().setGeneros(generos);
	                }
	                break;
	            default:
	                System.out.println("Opción inválida.");
	        }

	        System.out.println("Ejemplar actualizado:");
	        System.out.println(ejemplarEncontrado.toString());
	    }
	}


	public static void eliminarEjemplar() {
	    if (ejemplares.isEmpty()) {
	        System.out.println("La lista de ejemplares está vacía.");
	        return;
	    }

	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Ingrese el ID del ejemplar a eliminar: ");
	    String idEjemplar = scanner.nextLine();

	    Ejemplar ejemplarEncontrado = null;
	    for (Ejemplar ejemplar : ejemplares) {
	        if (ejemplar.getIdEjemplar().equals(idEjemplar)) {
	            ejemplarEncontrado = ejemplar;
	            break;
	        }
	    }

	    if (ejemplarEncontrado == null) {
	        System.out.println("No se encontró ningún ejemplar con el ID especificado.");
	    } else {
	        ejemplares.remove(ejemplarEncontrado);
	        System.out.println("Ejemplar eliminado exitosamente.");
	    }
	}

	public static void buscarEjemplarLibro() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Ingrese el ID del libro a buscar: ");
	    String idLibro = scanner.nextLine();

	    for (Ejemplar ejemplar : ejemplares) {
	        if (ejemplar.getLibro() != null && ejemplar.getIdEjemplar().equals(idLibro)) {
	            System.out.println("Ejemplar de libro encontrado:");
	            System.out.println(ejemplar.toString());
	            return; 
	        }
	    }

	    System.out.println("No se encontró ningún ejemplar de libro con el ID especificado.");
	}

	public static void buscarEjemplarRevista() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Ingrese el ID de la revista a buscar: ");
	    String idRevista = scanner.nextLine();

	    for (Ejemplar ejemplar : ejemplares) {
	        if (ejemplar.getRevista() != null && ejemplar.getIdEjemplar().equals(idRevista)) {
	            System.out.println("Ejemplar de revista encontrado:");
	            System.out.println(ejemplar.toString());
	            return; 
	        }
	    }

	    System.out.println("No se encontró ningún ejemplar de revista con el ID especificado.");
	}


	


	private static void menuUsuario() {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("----- Menú Socio-----");
			System.out.println("1. Crear un Socio");
			System.out.println("2. Ver socios");
			System.out.println("3. Actualizar Socio");
			System.out.println("4. Eliminar Socio");
			System.out.println("5. Salir");
			
		
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Has seleccionado la opción 1: Crear un socio.");
				crearSocio();
				break;
			case 2:
				System.out.println("Has seleccionado la opción 2: Leer socios.");
				leerSocios();
				break;
			case 3:
				System.out.println("Has seleccionado la opción 3: Actualizar un socio.");
				actualizarSocio();
				break;
			case 4:
				System.out.println("Has seleccionado la opción 4: Eliminar un socio.");
				eliminarSocio();
				break;
			case 5:
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
				break;
			}
		}while(opcion != 5);
	}
	
	public static void crearSocio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del socio: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la edad del socio: ");
        int edad = scanner.nextInt();

        scanner.nextLine(); 

        System.out.print("Ingrese el DNI del socio: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese el ID del socio: ");
        String idSocio = scanner.nextLine();

        Socio socio = new Socio(nombre, apellido, edad, dni, idSocio);
        socios.add(socio);

        System.out.println("Socio creado exitosamente.");

        
    }
	
	public static void leerSocios() {
	    if (socios.isEmpty()) {
	        System.out.println("No hay socios registrados en la biblioteca.");
	    } else {
	        // Ordenar los socios en orden alfabético por nombre
	        Collections.sort(socios);

	        System.out.println("Lista de socios:");
	        for (Socio socio : socios) {
	            System.out.println(socio.toString());
	            System.out.println();
	        }
	    }
	}

	
	public static void actualizarSocio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del socio que desea actualizar: ");
        String idSocio = scanner.nextLine();

        Socio socioEncontrado = null;

        for (Socio socio : socios) {
            if (socio.getIdSocio().equals(idSocio)) {
                socioEncontrado = socio;
                break;
            }
        }

        if (socioEncontrado != null) {
            System.out.print("Ingrese el nuevo nombre del socio: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo apellido del socio: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la nueva edad del socio: ");
            int edad = scanner.nextInt();

            scanner.nextLine(); // Consumir nueva línea después de nextInt()

            System.out.print("Ingrese el nuevo DNI del socio: ");
            String dni = scanner.nextLine();

            socioEncontrado.setNombre(nombre);
            socioEncontrado.setApellido(apellido);
            socioEncontrado.setEdad(edad);
            socioEncontrado.setDni(dni);

            System.out.println("Socio actualizado exitosamente.");
        } else {
            System.out.println("No se encontró ningún socio con ese ID.");
        }

      
    }
	
	 public static void eliminarSocio() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese el ID del socio que desea eliminar: ");
	        String idSocio = scanner.nextLine();

	        Socio socioEncontrado = null;

	        for (Socio socio : socios) {
	            if (socio.getIdSocio().equals(idSocio)) {
	                socioEncontrado = socio;
	                break;
	            }
	        }

	        if (socioEncontrado != null) {
	            socios.remove(socioEncontrado);
	            System.out.println("Socio eliminado exitosamente.");
	        } else {
	            System.out.println("No se encontró ningún socio con ese ID.");
	        }

	        
	    }
	 
	 public static void menuPrestamos() {
		    Scanner scanner = new Scanner(System.in);
		    int opcion;

		    do {
		        System.out.println("------ Menú ------");
		        System.out.println("1. Crear préstamo");
		        System.out.println("2. Mostrar préstamos");
		        System.out.println("3. Actualizar préstamo");
		        System.out.println("4. Devolver prestamo");
		        System.out.println("5. Salir");
		        System.out.print("Seleccione una opción: ");
		        opcion = scanner.nextInt();

		        switch (opcion) {
		            case 1:
		                crearPrestamo();
		                break;
		            case 2:
		                mostrarPrestamos();
		                break;
		            case 3:
		            	System.out.println("ID que quieres actualizar: ");
		            	String idPasado = new Scanner(System.in).nextLine();
		                actualizarPrestamoPorId(idPasado);
		                break;
		            case 4:
		            	devolucion();
		                break;
		            case 5:
		                System.out.println("Saliendo del programa...");
		                break;
		            default:
		                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
		                break;
		        }

		        System.out.println();
		    } while (opcion != 5);
		}
	 
	 public static void crearPrestamo() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("-- Crear préstamo --");

	        // Leer datos del préstamo
	        System.out.print("Ingrese el ID del socio: ");
	        String idSocio = scanner.nextLine();

	        // Buscar el socio por su ID en el ArrayList de socios
	        Socio socio = null;
	        for (Socio s : socios) {
	            if (s.getIdSocio().equalsIgnoreCase(idSocio)) {
	            	if(s.isPenalizacion()!=true) {
	            		socio = s;
		                s.setActivo(true);
		                s.setPenalizacion(true);
		                break;
	            	}else {
	            		System.out.println("DEBES UN LIBRO NO PUEDES HACER PRESTAMOS SIN DEVOLVER LIBROS");
	            		return;
	            	}	            		             
	            }
	        }

	        if (socio == null) {
	            System.out.println("No se encontró el socio con el ID especificado.");
	            return;
	        }

	        System.out.print("Ingrese el ID del préstamo: ");
	        String idPrestamo = scanner.nextLine();

	        Date fechaIni = new Date(); // Obtener la fecha actual como fecha inicial del préstamo

	        // Crear una lista de ejemplares vacía
	        ArrayList<Ejemplar> listarEjemplares = new ArrayList<>();

	        // Mostrar los ejemplares disponibles
	        System.out.println("Ejemplares disponibles:");
	        for (Ejemplar ejemplar : ejemplares) {
	            System.out.println(ejemplar.toString());
	        }

	        // Leer los ejemplares del préstamo
	        String opcion;
	        do {
	            System.out.print("¿Desea agregar un ejemplar al préstamo? (s/n): ");
	            opcion = scanner.nextLine();

	            if (opcion.equalsIgnoreCase("s")) {
	                System.out.print("Ingrese el ID del ejemplar: ");
	                String idEjemplar = scanner.nextLine();

	                // Verificar si el ejemplar ya fue seleccionado previamente
	                boolean ejemplarYaSeleccionado = false;
	                for (Ejemplar ejemplar : listarEjemplares) {
	                    if (ejemplar.getIdEjemplar().equalsIgnoreCase(idEjemplar)) {
	                        ejemplarYaSeleccionado = true;
	                        break;
	                    }
	                }

	                if (ejemplarYaSeleccionado) {
	                    System.out.println("El ejemplar ya fue seleccionado anteriormente.");
	                } else {
	                    // Buscar el ejemplar en la lista de ejemplares disponibles
	                    Ejemplar ejemplarSeleccionado = null;
	                    for (Ejemplar ejemplar : ejemplares) {
	                        if (ejemplar.getIdEjemplar().equalsIgnoreCase(idEjemplar)) {
	                            ejemplarSeleccionado = ejemplar;
	                            break;
	                        }
	                    }

	                    if (ejemplarSeleccionado != null) {
	                        // Agregar el ejemplar seleccionado a la lista de ejemplares del préstamo
	                        listarEjemplares.add(ejemplarSeleccionado);
	                        System.out.println("Ejemplar agregado al préstamo.");
	                    } else {
	                        System.out.println("El ejemplar no está disponible.");
	                    }
	                }
	            }
	        } while (opcion.equalsIgnoreCase("s"));

	        // Buscar el empleado que realiza el préstamo por su ID en el ArrayList de empleados
	        Empleado empleado = null;
	        System.out.print("Ingrese el ID del empleado que realiza el préstamo: ");
	        String idEmpleado = scanner.nextLine();

	        for (Empleado e : empleados) {
	            if (e.getIdEmpleado().equalsIgnoreCase(idEmpleado)) {
	                empleado = e;
	                break;
	            }
	        }

	        if (empleado == null) {
	            System.out.println("No se encontró el empleado con el ID especificado.");
	            return;
	        }
	        
	        

	        // Crear la fecha final sumando 15 días a la fecha inicial
	        Calendar calendarioAux = Calendar.getInstance();
	        calendarioAux.setTime(fechaIni);
	        calendarioAux.add(Calendar.DAY_OF_MONTH, 15);
	        Date fechaFin = calendarioAux.getTime();
	        
	        //Guardar socio en empleado
	        empleado.agregarSocioPrestado(socio);
	        
	        // Crear el objeto Prestamo
	        Prestamo prestamo = new Prestamo(socio, listarEjemplares, idPrestamo, fechaIni, fechaFin, empleado);

	        // Agregar el préstamo al ArrayList de préstamos
	        prestamos.add(prestamo);

	        System.out.println("El préstamo se ha creado correctamente.");
	        socio.setPenalizacion(true);
	    }
	 
	 public static void mostrarPrestamos() {
		    System.out.println("-- Listado de préstamos --");

		    if (prestamos.isEmpty()) {
		        System.out.println("No hay préstamos registrados.");
		        return;
		    }
		    System.out.println("Prestamos NO devueltos.");
		    for (Prestamo prestamo : prestamos) {
		    if(prestamo.isDevuelto() != true) {	
		        System.out.println("ID del préstamo: " + prestamo.getIdPrestamo());
		        System.out.println("Socio: " + prestamo.getSocio().getNombre());
		        System.out.println("Fecha inicial: " + prestamo.getFechaIni());
		        System.out.println("Fecha final: " + prestamo.getFechaFin());
		        System.out.println("Empleado que realizó el préstamo: " + prestamo.getEmpleado().getNombre());
		        System.out.println("------------------------");
		    	}
		    }
		    
		    System.out.println("Prestamo  devueltos: ");
		   
		    for (Prestamo prestamo : prestamos) {
		    if(prestamo.isDevuelto() == true)	
		        System.out.println("ID del préstamo: " + prestamo.getIdPrestamo());
		        System.out.println("Socio: " + prestamo.getSocio().getNombre());
		        System.out.println("Fecha inicial: " + prestamo.getFechaIni());
		        System.out.println("Fecha final: " + prestamo.getFechaFin());
		        System.out.println("Empleado que realizó el préstamo: " + prestamo.getEmpleado().getNombre());
		        System.out.println("------------------------");
		    }
		}

	 
	 

	 public static void actualizarPrestamoPorId(String idPrestamo) {
	     System.out.println("-- Actualizar préstamo --");

	     Prestamo prestamoEncontrado = null;
	     for (Prestamo prestamo : prestamos) {
	         if (prestamo.getIdPrestamo().equals(idPrestamo)) {
	             prestamoEncontrado = prestamo;
	             break;
	         }
	     }

	     if (prestamoEncontrado == null) {
	         System.out.println("No se encontró un préstamo con el ID especificado.");
	         return;
	     }

	     System.out.println("Préstamo encontrado:");
	     System.out.println("ID del préstamo: " + prestamoEncontrado.getIdPrestamo());
	     System.out.println("Fecha inicial: " + prestamoEncontrado.getFechaIni());
	     System.out.println("Fecha final actual: " + prestamoEncontrado.getFechaFin());

	     // Mostrar los ejemplares disponibles
	     System.out.println("Ejemplares disponibles:");
	     for (Ejemplar ejemplar : ejemplares) {
	         System.out.println(ejemplar.toString());
	     }

	     // Solicitar al usuario si desea agregar un ejemplar
	     Scanner scanner = new Scanner(System.in);
	     System.out.print("¿Desea agregar un ejemplar al préstamo? (s/n): ");
	     String opcion = scanner.nextLine();

	     if (opcion.equalsIgnoreCase("s")) {
	         System.out.print("Ingrese el ID del ejemplar a agregar: ");
	         String idEjemplar = scanner.nextLine();

	         // Buscar el ejemplar en la lista de ejemplares disponibles
	         Ejemplar ejemplarSeleccionado = null;
	         for (Ejemplar ejemplar : ejemplares) {
	             if (ejemplar.getIdEjemplar().equals(idEjemplar)) {
	                 ejemplarSeleccionado = ejemplar;
	                 break;
	             }
	         }

	         if (ejemplarSeleccionado == null) {
	             System.out.println("El ejemplar no existe en la lista de ejemplares disponibles.");
	         } else {
	             // Verificar si el ejemplar ya está en el préstamo
	             boolean ejemplarExistente = false;
	             for (Ejemplar ejemplar : prestamoEncontrado.getListarEjemplares()) {
	                 if (ejemplar.getIdEjemplar().equals(idEjemplar)) {
	                     ejemplarExistente = true;
	                     break;
	                 }
	             }

	             if (ejemplarExistente) {
	                 System.out.println("El ejemplar ya está en el préstamo. No se puede agregar nuevamente.");
	             } else {
	                 // Agregar el ejemplar al préstamo
	                 prestamoEncontrado.getListarEjemplares().add(ejemplarSeleccionado);
	                 System.out.println("El ejemplar ha sido agregado al préstamo.");
	             }
	         }
	     }

	     // Solicitar al usuario si desea cambiar la fecha final del préstamo
	     System.out.print("¿Desea cambiar la fecha final del préstamo? (s/n): ");
	     opcion = scanner.nextLine();

	     if (opcion.equalsIgnoreCase("s")) {
	         System.out.print("Ingrese la nueva fecha final (formato: dd/MM/yyyy): ");
	         String fechaFinStr = scanner.nextLine();

	         try {
	             Date fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinStr);

	             if (fechaFin.before(prestamoEncontrado.getFechaIni())) {
	                 System.out.println("La nueva fecha final debe ser como mínimo un día después de la fecha inicial.");
	             } else {
	                 prestamoEncontrado.setFechaFin(fechaFin);
	                 System.out.println("La fecha final del préstamo ha sido actualizada.");
	             }
	         } catch (Exception e) {
	             System.out.println("Error al analizar la fecha. Asegúrese de ingresar el formato correcto (dd/MM/yyyy).");
	         }
	     }
	 }

	 public static void devolucion() {
		    Scanner opc = new Scanner(System.in);
		    System.out.println("ID de socio que devuelve: ");
		    String nombreId = opc.nextLine();
		    opc.nextLine();
		    Socio socio = null;
		    boolean encontrado = false;

		    for (Socio s : socios) {
		        if (s.getIdSocio().equalsIgnoreCase(nombreId)) {
		            socio = s;
		            break;
		        }
		    }

		    if (socio != null) {		        
		            for (Prestamo p : prestamos) {
		                if (p.getSocio().equals(socio) && !p.isDevuelto()) {
		                    System.out.println("El ejemplar que debes es:");
		                    for (Ejemplar e : p.getListarEjemplares()) {
		                        System.out.println(e.toString());
		                    }
		                    encontrado = true;
		                    break;
		                }
		            }

		            if (!encontrado) {
		                System.out.println("El socio no tiene préstamos pendientes.");
		            } else {
		                System.out.println("¿Desea marcar los préstamos como devueltos? (S/N)");
		                String respuesta = opc.nextLine();
		                if (respuesta.equalsIgnoreCase("S")) {
		                    for (Prestamo p : prestamos) {
		                        if (p.getSocio().equals(socio) && !p.isDevuelto()) {
		                            p.setDevuelto(true);
		                            comprobarLibrosDevueltos();
		                        }
		                    }
		                    System.out.println("Se han marcado los préstamos como devueltos.");
		                } else {
		                    System.out.println("Los préstamos no han sido marcados como devueltos.");
		                }
		            }
		        
		    } else {
		        System.out.println("No se encontró un socio con el ID ingresado.");
		    }
		}

	 private static void comprobarLibrosDevueltos() {
		    System.out.println("Los siguientes socios deben libros: ");
		    for (Prestamo p : prestamos) {
		        if (p.isDevuelto()==false) {
		            System.out.println(p.getSocio().toString());
		            System.out.println(p.getFechaFin());
		            Date fechaActual = new Date();

		            Calendar fechaFin = Calendar.getInstance();
		            fechaFin.setTime(p.getFechaFin());

		            Calendar fechaActualCalendar = Calendar.getInstance();
		            fechaActualCalendar.setTime(fechaActual);

		            if (fechaFin.get(Calendar.YEAR) <= fechaActualCalendar.get(Calendar.YEAR)
		                    && fechaFin.get(Calendar.MONTH) <= fechaActualCalendar.get(Calendar.MONTH)
		                    && fechaFin.get(Calendar.DAY_OF_MONTH) <= fechaActualCalendar.get(Calendar.DAY_OF_MONTH)) {
		            	
		                Calendar calendario = Calendar.getInstance();
		                calendario.setTime(fechaActual);
		                calendario.add(Calendar.DAY_OF_YEAR, 15);
		                Date fechaResultado = calendario.getTime();
		                
		                p.getSocio().setPenalizacion(true);
		                
		                fechaMultas.put(p.getSocio().getIdSocio(), fechaResultado);
		            } else if (fechaFin.get(Calendar.MONTH) == fechaActualCalendar.get(Calendar.MONTH)
		                    && fechaFin.get(Calendar.YEAR) >= fechaActualCalendar.get(Calendar.YEAR)) {
		                if (fechaFin.get(Calendar.DAY_OF_MONTH) > fechaActualCalendar.get(Calendar.DAY_OF_MONTH)) {
		                    p.getSocio().setPenalizacion(false);
		                }
		            } else if (fechaFin.get(Calendar.MONTH) > fechaActualCalendar.get(Calendar.MONTH)
		                    && fechaFin.get(Calendar.YEAR) >= fechaActualCalendar.get(Calendar.YEAR)) {
		                p.getSocio().setPenalizacion(false);
		            }
		        }
		    }

		    // Recorrer la lista de socios y cambiar el estado de penalización si la fecha de multa coincide con la fecha actual
		    for (Socio socio : socios) {
		        Date fechaMulta = fechaMultas.get(socio.getIdSocio());
		        if (fechaMulta != null) {
		            Calendar fechaMultaCalendar = Calendar.getInstance();
		            fechaMultaCalendar.setTime(fechaMulta);

		            Calendar fechaActualCalendar = Calendar.getInstance();

		            if (fechaMultaCalendar.get(Calendar.YEAR) == fechaActualCalendar.get(Calendar.YEAR)
		                    && fechaMultaCalendar.get(Calendar.MONTH) == fechaActualCalendar.get(Calendar.MONTH)
		                    && fechaMultaCalendar.get(Calendar.DAY_OF_MONTH) == fechaActualCalendar.get(Calendar.DAY_OF_MONTH)) {
		                socio.setPenalizacion(false);
		            }
		        }
		    }
		    System.out.println("Dia que se realizo comprobación: " + obtenerFechaActual());
		}

        

    public static String obtenerFechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formato.format(fechaActual);
    }
    
    private static Date getTomorrowMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


	public static void verHorario() {
		for(DiaSemana dia :horario) {
			System.out.println("Dia: "+dia.name());
			System.out.println("Hora de apertura: " + dia.getHoraApertura());
			System.out.println("Hora de cierre: " + dia.getHoraCierre());
			System.out.println();
		}
	}

}

