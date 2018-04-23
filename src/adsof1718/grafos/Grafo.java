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
	protected Map<Vertice<T>, Vertice<T>> arcos;
	
	/**
	 * 
	 */
	public Grafo() {
		vertices = new TreeMap<>();
		arcos = new TreeMap<>();
	}
	
	public Vertice<T> addVertice(T datos){
		Vertice v = new Vertice(vertices.size() + 1, datos);
		vertices.put(vertices.size() + 1, v);
		return v;

	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice v = new Vertice(id, datos);
		vertices.put(id, v);
		return v;
	}
	
	public List<Vertice<T>> getVertices(){
		
		return vertices;
	}
	
	public int getNumVertices() {
		return vertices.size();
	}
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null)
			return false;
		if(arcos.get(v1) == v2)
			return true;
			
		return false;
	}
	
	public int getNumArcos() {
		return arcos.size();		
	}
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	
	public String toString() {		// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		
	}


}
