/**
 * 
 */
package adsof1718.grafos;

/**
 * Clase vertice
 * <p>
 * Esta clase contiene los datos del vertice: id, y datos genericos.
 * 
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez	sara.gonzalezg01@estudiante.uam.es
 */
public class Vertice<T> {
	private final int id; // identificador del v�rtice dentro del grafo
	private T datos; // datos almacenados en el v�rtice 
	
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}

	/**
	 * @return the datos
	 */
	public T getDatos() {
		return datos;
	}

	/**
	 * @param datos the datos to set
	 */
	public void setDatos(T datos) {
		this.datos = datos;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return  id + " : " + datos + "\n";
	}

}
