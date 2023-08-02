package biblioteca.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;

import javax.xml.crypto.Data;

public class Empleado extends Usuario implements Fichar,Comparable<Empleado>{
	
	private String idEmpleado;
	private int tiempoTrabajado;
	private Date fechaAlta;
	private Date fechaBaja;
	private boolean fichado;
	private Supervisor supervisor;
	private LinkedHashSet<Date>diasFichados = new LinkedHashSet<Date>();
	private ArrayList<Socio> sociosPrestados = new ArrayList<Socio>();
	private Date auxhora;
	
	public Empleado() {
		super();
	}
	
	public void setSociosPrestados(ArrayList<Socio> sociosPrestados) {
		this.sociosPrestados = sociosPrestados;
	}
	public Empleado(String idEmpleado,String nombre, String apellido, int edad, String dni, Date fechaAlta,Supervisor supervisor) {
		super(nombre, apellido, edad, dni);
		this.fechaAlta = fechaAlta;
		this.supervisor = supervisor;
		
		Calendar calendarioAux = Calendar.getInstance();
        calendarioAux.setTime(fechaAlta);
        calendarioAux.add(Calendar.YEAR, 1);
        
        sociosPrestados = new ArrayList<Socio>();
		this.fechaBaja = calendarioAux.getTime();
		this.idEmpleado = idEmpleado;
		fichado = false;
		diasFichados = new LinkedHashSet<Date>();
	}
	
	public Empleado(String nombre, String apellido, int edad, String dni, Date fechaAlta ) {
		super(nombre, apellido, edad, dni);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = new Date();
		fichado = false;
	}
	
	public Empleado(Object emple) {
		setNombre(((Empleado)emple).getNombre());
		setApellido(((Empleado)emple).getApellido());
		setDni(((Empleado)emple).getDni());
		setEdad(((Empleado)emple).getEdad());
		setFechaAlta(((Empleado)emple).getFechaAlta());
		setIdEmpleado(((Empleado)emple).getIdEmpleado());
		setTiempoTrabajado(((Empleado)emple).getTiempoTrabajado());
		setSupervisor(((Empleado)emple).getSupervisor());
		fichado = false;
		setFechaBaja(((Empleado)emple).getFechaBaja());
		
	}
	
	
	
	public ArrayList<Socio> getSociosPrestados() {
		return sociosPrestados;
	}
	
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getTiempoTrabajado() {
		return tiempoTrabajado;
	}
	public void setDiasFichados(LinkedHashSet<Date> diasFichados) {
		this.diasFichados = diasFichados;
	}

	public void setTiempoTrabajado(int tiempoTrabajado) {
		this.tiempoTrabajado = tiempoTrabajado;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	
	
	@Override
    public void entrar(Date fecha) {
        if (!diasFichados.contains(fecha)) {
            diasFichados.add(fecha);
            auxhora = fecha;
            System.out.println("Empleado fichado al entrar: " + fecha);
            fichado = true;
        } else {
            System.out.println("Fecha inválida o duplicada. No se puede fichar al entrar.");
        }
    }

    @Override
    public void salir(Date fecha) {
        if (!diasFichados.contains(fecha)) {
            diasFichados.add(fecha);
            System.out.println("Empleado fichado al salir: " + fecha);
            tiempoTrabajado += fecha.getHours() - auxhora.getHours();
            fichado = false;
        } else {
            System.out.println("Fecha inválida o duplicada. No se puede fichar al salir.");
        }
    }

    public LinkedHashSet<Date> getDiasFichados() {
		return diasFichados;
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
    
    public ArrayList<Socio> verSociosPrestados() {
        System.out.println("Socios prestados:");
        for (Socio socio : sociosPrestados) {
            System.out.println(socio);
        }
        return sociosPrestados;
    }
    
    public void agregarSocioPrestado(Socio socio) {
        sociosPrestados.add(socio);
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idEmpleado);
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
		Empleado other = (Empleado) obj;
		return Objects.equals(idEmpleado, other.idEmpleado);
	}
    
	@Override
	public int compareTo(Empleado emple){
    	return this.getTiempoTrabajado() - emple.getTiempoTrabajado(); 
    }

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", tiempoTrabajado=" + tiempoTrabajado + ", fechaAlta="
				+ fechaAlta  + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
