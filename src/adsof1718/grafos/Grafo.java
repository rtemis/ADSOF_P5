/**
 * 
 */
package adsof1718.grafos;

import java.util.*;
import java.util.stream.*;

/**
 * @author leah_
 *
 */
public abstract class Grafo <T> {
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Map<Integer,Double>> arcos;
	
	/**
	 * 
	 */
	public Grafo() {
		vertices = new TreeMap<>();
		arcos = new TreeMap<>();
	}
	
	
	public Vertice<T> addVertice(T datos){
		int id;
		if (vertices.isEmpty())
			id = 0;
		else
			id = vertices.size();
		Vertice v = new Vertice(vertices.size(), datos);
		vertices.put(id, v);
		return v;
	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice v = new Vertice(id, datos);
		vertices.put(id, v);
		return v;
	}
	
	public List<Vertice<T>> getVertices() {
		List<Vertice<T>> list = new ArrayList<>(vertices.values());
		return list;
	}
	
	public int getNumVertices() {
		return vertices.size();
	}
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null)
			return false;
		if (arcos.containsKey(v1.getId()) && arcos.get(v1.getId()).containsKey(v2.getId()))
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
		return vertices.values().toString();
	}


}
