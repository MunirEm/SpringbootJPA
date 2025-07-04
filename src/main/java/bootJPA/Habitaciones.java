package bootJPA;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Habitaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroh;
	@Column(nullable=false)
	private String tipo;
	@Column(nullable=false)
	private Double precionoche;
	private Integer capacidad;
	private Boolean disponible;
	@ManyToMany(mappedBy = "habitaciones" , fetch = FetchType.LAZY)
	private ArrayList <Clientes> clientes = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="fk_idH", referencedColumnName="idH")
	private Hoteles hoteles;
	/**
	 * @return the numeroh
	 */
	public int getNumeroh() {
		return numeroh;
	}
	/**
	 * @param numeroh the numeroh to set
	 */
	public void setNumeroh(Integer numeroh) {
		this.numeroh = numeroh;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the precionoche
	 */
	public Double getPrecionoche() {
		return precionoche;
	}
	/**
	 * @param precionoche the precionoche to set
	 */
	public void setPrecionoche(Double precionoche) {
		this.precionoche = precionoche;
	}
	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}
	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	/**
	 * @return the clientes
	 */
	public ArrayList<Clientes> getClientes() {
		return clientes;
	}
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}
	/**
	 * @return the hotels
	 */
	public Hoteles getHoteles() {
		return hoteles;
	}
	/**
	 * @param hotels the hotels to set
	 */
	public void setHoteles(Hoteles hoteles) {
		this.hoteles = hoteles;
	}
	@Override
	public String toString() {
		return "Habitaciones [numeroh=" + numeroh + ", tipo=" + tipo + ", precionoche=" + precionoche + ", capacidad="
				+ capacidad + ", disponible=" + disponible + ", clientes=" + clientes + ", hoteles=" + hoteles + "]";
	}
	public Habitaciones(Integer numeroh, String tipo, Double precionoche, Integer capacidad, Boolean disponible,
			ArrayList<Clientes> clientes, Hoteles hoteles) {
		super();
		this.numeroh = numeroh;
		this.tipo = tipo;
		this.precionoche = precionoche;
		this.capacidad = capacidad;
		this.disponible = disponible;
		this.clientes = clientes;
		this.hoteles = hoteles;
	}
	public Habitaciones() {}
}
