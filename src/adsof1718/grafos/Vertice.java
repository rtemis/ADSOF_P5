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
	
	@Override
	public String toString() {
		return  id + " : " + datos;
	}

}
