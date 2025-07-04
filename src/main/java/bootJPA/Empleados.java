package bootJPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;

@Entity
public class Empleados {
	@Id 
	private String dni;
	private String nombre;
	private String Apellidos;
	private Integer categoria;
	@Column(nullable=false)
	private Double salario;
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni2 the dni to set
	 */
	public void setDni(String dni) {
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return Apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	/**
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	/**
	 * @return the hoteles
	 */

	public Empleados(String dni, String nombre, String apellidos, Integer categoria,
			Double salario,
			Hoteles hoteles) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.categoria = categoria;
		this.salario = salario;
		
	}
	public Empleados() {
		super();
	}
	

}
