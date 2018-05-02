package adsof1718.grafos.got;

/**
 * Clase PersonajeGOT
 * <p>
 * Esta clase sera el tipo de datos usado por los vertices.
 * 
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez	sara.gonzalezg01@estudiante.uam.es
 */
public class PersonajeGOT {
	private String nombre;
	private String casa;

	/**
	 * Constructor de la clase PersonajeGOT
	 * 
	 * @param nombre, String nombre
	 * @param casa, String casa
	 */
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
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
	 * @return the casa
	 */
	public String getCasa() {
		return casa;
	}

	/**
	 * @param casa the casa to set
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}
	
	

}
