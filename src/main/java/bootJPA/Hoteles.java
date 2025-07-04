package bootJPA;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Hoteles {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idH;
	private String ciudad;
	@Column(columnDefinition = "VARCHAR(10) DEFAULT 'Spain'")
	private String pais;
	@Column(nullable=false)
	private int estrellas;
	
	@OneToMany(mappedBy = "hoteles", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Habitaciones> habitaciones=new ArrayList<>();
	@OneToMany
	@JoinColumn(name="hotel_id")
	private List<Empleados> empleados= new ArrayList<>();
	@Override
	public String toString() {
		return "Hoteles [idH=" + idH + ", ciudad=" + ciudad + ", pais=" + pais + ", estrellas=" + estrellas
				;
	}
	/**
	 * @return the idH
	 */
	public int getIdH() {
		return idH;
	}
	/**
	 * @param idH the idH to set
	 */
	public void setIdH(int idH) {
		this.idH = idH;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String coidad) {
		this.ciudad = coidad;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the estrellas
	 */
	public int getEstrellas() {
		return estrellas;
	}
	/**
	 * @param estrellas the estrellas to set
	 */
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
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
	public void setHabitaciones(List<Habitaciones> habitaciones) {
		this.habitaciones = habitaciones;
	}
	/**
	 * @return the empleados
	 */
	public List<Empleados> getEmpleados() {
		return empleados;
	}
	/**
	 * @param profe the empleados to set
	 */
	public void setEmpleados(List<Empleados> profe) {
		this.empleados = profe;
	}
	public Hoteles(int idH, String ciudad, String pais, int estrellas, List<Habitaciones> habitaciones,
			List<Empleados> empleados) {
		super();
		this.idH = idH;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estrellas = estrellas;
		this.habitaciones = habitaciones;
		this.empleados = empleados;
	}
	public Hoteles() {
		super();
	}
	

}
