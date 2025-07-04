package bootJPA;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity

public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dni;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	@Min(value=100000000)
	@Max(value=999999999)
	private int movil;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Intermedio",joinColumns = @JoinColumn(name = "dni"), inverseJoinColumns = @JoinColumn(name = "numeroh"))
	private List <Habitaciones> habitaciones = new ArrayList<>();
	@Override
	public String toString() {
		return "Clientes [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", movil=" + movil
				+ ", habitaciones=" + habitaciones + "]";
	}
	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the movil
	 */
	public int getMovil() {
		return movil;
	}
	/**
	 * @param movil the movil to set
	 */
	public void setMovil(int movil) {
		this.movil = movil;
	}
	/**
	 * @return the habitaciones
	 */
	public List<Habitaciones> getHabitaciones() {
		return habitaciones;
	}
	/**
	 * @param habitaciones the habitaciones to set
	 */
	public void setHabitaciones(ArrayList<Habitaciones> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Clientes(Integer dni, String nombre, String apellido,
			int movil,
			ArrayList<Habitaciones> habitaciones) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.movil = movil;
		this.habitaciones = habitaciones;
	}
	
	public Clientes() {}

}
