package biblioteca.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;



public class Supervisor extends Usuario implements Fichar,Comparable<Supervisor>{
	
    private String idSupervisor;
    private ArrayList<Empleado> empleados;
    private boolean fichado;
    private LinkedHashSet<Date> diasFichados = new LinkedHashSet<>();
    private String contrasena;
    private Date auxHoras;
    private LocalDateTime diaAlta;
    private LocalDateTime diaBaja;
    

    public Supervisor() {
        super();
        empleados = new ArrayList<>();
    }

    public Supervisor(String nombre, String apellido, int edad, String dni,String contrasena,String idSupervisor) {
        super(nombre, apellido, edad, dni);
        empleados = new ArrayList<>();
        this.idSupervisor = idSupervisor;
        this.contrasena = contrasena;
    }

    public LocalDateTime getDiaAlta() {
        return diaAlta;
    }

    public void setDiaAlta(LocalDateTime diaAlta) {
        this.diaAlta = diaAlta;
    }

    public LocalDateTime getDiaBaja() {
        return diaBaja;
    }

    public void setDiaBaja(LocalDateTime diaBaja) {
        this.diaBaja = diaBaja;
    }

    
    
    
    

    public Supervisor(Object supervisor) {
		setNombre(((Supervisor)supervisor).getNombre());
		setApellido(((Supervisor)supervisor).getApellido());
		setDni(((Supervisor)supervisor).getDni());
		setEdad(((Supervisor)supervisor).getEdad());
		setIdSupervisor(((Supervisor)supervisor).getIdSupervisor());
		setEmpleados(((Supervisor)supervisor).getEmpleados());		
		fichado = false;
		setDiasFichados(((Supervisor)supervisor).diasFichados);
	}

    
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public LinkedHashSet<Date> getDiasFichados() {
		return diasFichados;
	}

	public void setDiasFichados(LinkedHashSet<Date> diasFichados) {
		this.diasFichados = new LinkedHashSet<Date>();
		this.diasFichados = (LinkedHashSet<Date>) diasFichados.clone();
	}

	public String getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = new ArrayList<Empleado>(); 
        this.empleados =  (ArrayList<Empleado>)empleados.clone();
    }



   

    @Override
    public void entrar(Date fecha) {
        if (!diasFichados.contains(fecha)) {
            diasFichados.add(fecha);
            System.out.println("Supervisor fichado al entrar: " + fecha);
            fichado = true;  
        } else {
            System.out.println("Fecha inválida o duplicada. No se puede fichar al entrar.");
        }
    }

    @Override
    public void salir(Date fecha) {
        if (!diasFichados.contains(fecha)) {
            diasFichados.add(fecha);
            System.out.println("Supervisor fichado al salir: " + fecha);
            fichado = false;
        } else {
            System.out.println("Fecha inválida o duplicada. No se puede fichar al salir.");
        }
    }

	private boolean validarFormatoFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String fechaString = sdf.format(fecha);

        try {
            Date fechaFormateada = sdf.parse(fechaString);
            return fecha.equals(fechaFormateada);
        } catch (ParseException e) {
            return false;
        }
    }
	
	
	
public int controlDeHoras(Empleado empleado, Date fechaInicio, Date fechaFin) {
    int horasTrabajadas = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    int pocision = 0;
    for (Date fecha : empleado.getDiasFichados()) {
    	pocision++;
    	Date auxFechaEntrada;
    	Date auxFechaSalida;
        if (fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0&&pocision % 2 == 0) {
            horasTrabajadas += fecha.getHours(); 
        }else if(fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0&&pocision % 2 != 0){
        	horasTrabajadas -= fecha.getHours();
        }
    }

    System.out.println("Horas trabajadas por el empleado " + empleado.getNombre() + " " + empleado.getApellido() +
            " desde " + sdf.format(fechaInicio) + " hasta " + sdf.format(fechaFin) + ": " + horasTrabajadas);

    return horasTrabajadas;
}


	
	public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
	}
	
	public ArrayList<Empleado> obtenerEmpleadosSupervisados() {
        return empleados;
    }
	
	public Empleado obtenerEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            return empleados.get(indice);
        } else {
            return null;
        }
    }
	
	public void actualizarEmpleado(int indice, Empleado empleadoActualizado) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.set(indice, empleadoActualizado);
        }
    }
	
	public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.remove(indice);
        }
    }
	
	public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
	
	public void cantidadDePrestamoPorEmpleado(Empleado empleado) {
		int cantSocios = 0;
		for(Empleado empleado1:empleados) {
			if(empleado.equals(empleado1)){
				for(Socio socio: empleado1.getSociosPrestados()) cantSocios++;				
				System.out.println("El empleado " + empleado1.getNombre()+ ". Hizo una cantidad de prestamos de : " + cantSocios);
				cantSocios = 0;
			}
		}
	}
	
	public void productividadTodosLosTrabajadores() {
		
		Collections.sort(this.empleados,( emple1, emple2) ->  emple2.getTiempoTrabajado() - emple1.getTiempoTrabajado());
			
		for(Empleado emple:this.empleados) {
			System.out.println("Nombre: " + emple.getNombre());
			System.out.println("Apellido: " + emple.getApellido());
			System.out.println("Horas trabajadas: " + emple.getTiempoTrabajado());
			
		}
		System.out.println("Prueba");
	}

	@Override
	public int compareTo(Supervisor o) {
		
		return this.getIdSupervisor().compareTo(o.getIdSupervisor());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idSupervisor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supervisor other = (Supervisor) obj;
		return Objects.equals(idSupervisor, other.idSupervisor);
	}
	
	
}

