/**
 * 
 */
package adsof1718.grafos;

import java.util.*;

/**
 * @author leah_
 *
 */
public abstract class Grafo<T> {
	private T t;
	protected Map<Integer, Vertice<T>> vertices;
	
	/**
	 * 
	 */
	public Grafo() {
		vertices = new HashMap<>();
	}
	
	public Vertice<T> addVertice(T datos){
		Vertice v = new Vertice(datos);
		vertices.put(arg0, v);
	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice v = new Vertice(id, datos);
		vertices.put(id, v));
	}
	
	public List<Vertice<T>> getVertices(){
		return vertices;
	}
	
	public int getNumVertices() {
		
	}
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		
	}
	
	public int getNumArcos() {
		
	}
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	
	public String toString() {		// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		
	}


}
