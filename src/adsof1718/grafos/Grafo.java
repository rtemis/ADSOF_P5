/**
 * 
 */
package adsof1718.grafos;

import java.util.*;
import java.util.stream.*;

/**
 * Clase Abstracto Grafo
 * <p>
 * Esta clase, ademas de ser abstracta, es generica, que permite 
 *  el uso de tipos variados de datos en la estructura del 'Grafo'.
 * <p>
 * Esta clase contiene un mapa de vertices y un mapa de arcos, 
 *   
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez	sara.gonzalezg01@estudiante.uam.es
 */
public abstract class Grafo <T> {
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer,Map<Integer,Double>> arcos;
	
	/**
	 * Constructor de Grafo
	 * <p>
	 * Inicializa los atributos de vertices y de arcos a nuevos TreeMaps
	 */
	public Grafo() {
		vertices = new TreeMap<>();
		arcos = new TreeMap<>();
	}
	
	/**
	 * Metodo addVertice
	 * <p>
	 * Este metodo anade un vertice al grafo solo usando sus datos
	 * @param datos, T tipo generico de datos
	 * @return v Vertice nuevo
	 */
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
	
	/**
	 * Metodo addVertice 
	 * <p>
	 * Este metodo anade un vertice al grafo usando su id y sus datos.
	 * @param id, int id del vertice
	 * @param datos, T tipo generico de datos
	 * @return v Vertice nuevo
	 */
	protected Vertice<T> addVertice(int id, T datos){
		Vertice v = new Vertice(id, datos);
		vertices.put(id, v);
		return v;
	}
	
	/**
	 * Metodo getVertices
	 * <p>
	 * Devuelve una lista de vertices del grafo
	 * @return vertices List
	 */
	public List<Vertice<T>> getVertices() {
		List<Vertice<T>> list = new ArrayList<>(vertices.values());
		return list;
	}
	
	/**
	 * Metodo getNumVertices
	 * <p>
	 * Devuelve la cantidad de vertices en el grafo
	 * @return size int cantidad de vertices
	 */
	public int getNumVertices() {
		return vertices.size();
	}
	
	/**
	 * Metodo addArco
	 * <p>
	 * Este metodo sera implementado en las subclases para incluir un arco en 
	 *  el mapa de arcos del grafo.
	 *  
	 * @param v1, Vertice primer vertice
	 * @param v2, Vertice segundo vertice
	 * @param peso Peso del arco
	 */
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	/**
	 * Metodo existeArco
	 * <p>
	 * Este metodo busca un arco entre los dos vertices dados.
	 *  
	 * @param v1, Vertice primer vertice
	 * @param v2, Vertice segundo vertice
	 * @return true o false
	 */
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null)
			return false;
		if (arcos.containsKey(v1.getId()) && arcos.get(v1.getId()).containsKey(v2.getId()))
			return true;
			
		return false;
	}
	
	/**
	 * Metodo getNumArcos
	 * <p>
	 * Devuelve la cantidad de arcos que hay en el grafo
	 * @return size int cantidad de arcos
	 */
	public int getNumArcos() {
		return arcos.size();
	}
	
	/**
	 * Metodo getPesoDe
	 * <p>
	 * Este metodo sera implementado en las subclases, pero devuelve el peso de arco
	 *  entre dos vertices dados.
	 *  
	 * @param v1, Vertice primer vertice
	 * @param v2, Vertice segundo vertice
	 * @return peso double
	 */
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	/**
	 * Metodo getVecinosDe
	 * <p>
	 * Este metodo sera implementado en las subclases, pero devuelve una lista
	 *  de los vertices vecinos
	 *  
	 * @param v, Vertice
	 * @return vecinos List
	 */
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); 
	
	public String toString() {	
		return vertices.values().toString();
	}


}
