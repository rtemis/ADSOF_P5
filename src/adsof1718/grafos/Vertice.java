/**
 * 
 */
package adsof1718.grafos;

/**
 * @author leah_
 *
 */
public class Vertice<T> {
	private final int id; // identificador del v�rtice dentro del grafo
	private T datos; // datos almacenados en el v�rtice 


	/**
	 * 
	 */
	public Vertice(T datos) {
		this.id = 0;
		this.datos = datos;
	}
	
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}

}
