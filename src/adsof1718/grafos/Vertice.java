/**
 * 
 */
package adsof1718.grafos;

/**
 * @author leah_
 *
 */
public class Vertice<T> {
	private final int id; // identificador del vértice dentro del grafo
	private T datos; // datos almacenados en el vértice 
	
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
		return  id + " : " + datos;
	}

}
