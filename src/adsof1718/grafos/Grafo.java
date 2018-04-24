
package adsof1718.grafos;

import java.util.*;
import java.util.stream.*;

/**
 * Clase abstracta Grafo
 * <p>
 * Esta clase implementa el funcionamiento de un grafo, formado por un conjunto de
 * vertices (que pueden ser de cualquier tipo de dato), unidos por aristas (o arcos).
 * De esta clase heredan las clases GrafoDirigido y GrafoNoDirigido, dependiento del
 * tipo de arco que usen.
 * 
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez	sara.gonzalezg01@estudiante.uam.es
 */
public abstract class Grafo <T> {
	protected Map<Integer, Vertice<T>> vertices;
	private List<Arco>arcos;
	
	/**
	 * Constructor de la clase Grafo
	 */
	public Grafo() {
		vertices = new TreeMap<>();
		arcos = new ArrayList<>();
	}
	
	/**
	 * Metodo para añadir un vertice al TreeMap de vertices que forman en grafo (en la ultima posicion)
	 * @param datos, String del vertice en nuestro caso, aunque es generico en el caso general
	 * @return Vertice<T>, vertice añadido
	 */
	public Vertice<T> addVertice(T datos){
		Vertice v = new Vertice(vertices.size(), datos);
		vertices.put(vertices.size(), v);
		return v;
	}
	
	/**
	 * Metodo para añadir un vertice al TreeMap de vertices que forman en grafo (en la posicion indicada)
	 * @param id, int del id del vertice y la posicion en el Map
	 * @param datos,String del vertice en nuestro caso, aunque es generico en el caso general
	 * @return Vertice<T>, vertice añadido
	 */
	protected Vertice<T> addVertice(int id, T datos){
		Vertice v = new Vertice(id, datos);
		vertices.put(id, v);
		return v;
	}
	
	/**
	 * Metodo que devuelve los vertices que forman el grafo, ordenados por su id
	 * @return List<Vertice<T>>, lista de los vertices
	 */
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> lista = ((Collection<Vertice<T>>) vertices).stream().collect(Collectors.toList());
		return lista;
	}
	
	/**
	 * Metodo que devuelve el numero de vertices del grafo
	 * @return
	 */
	public int getNumVertices() {
		return vertices.size();
	}
	
	/**
	 * Metodo que comprueba si los dos vertices que se pasan como argumento estan conectados
	 * @param v1, Vertice<T> vertice 1 a comprobar
	 * @param v2, Vertice<T> vertice 2 a comprobar
	 * @return boolean, true si esa relacion es cierta, false si no
	 */
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(v1 == null || v2 == null)
			return false;
		//if(arcos.get(v1) == v2)
		//	return true;
			
		return false;
	}
	
	/**
	 * Metodo que devuelve el numero de arcos (aristas) que hay en el grafo
	 * @return int, numero de arcos
	 */
	public int getNumArcos() {
		return arcos.size();
	}
	
	@Override
	/**
	 * Metodo que devuelve el String de los datos de todos los vertices que forman el grafo
	 * @return String, el String a imprimir
	 */
	public String toString() {		// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		String x = "";		
		x += ((Collection<Vertice<T>>) vertices).stream().toString();
		return x;
	}
	
	/**
	 * Metodo abstracto para añadir una arista que una dos vertices, y el peso de esta relacion
	 * @param v1 Vertice<T>, vertice 1 a relacionar
	 * @param v2Vertice<T>, vertice 2 a relacionar
	 * @param peso, int del peso de la relacion
	 */
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	/**
	 * Metodo abstracto que devuelve el peso de la relacion (arco) entre dos vertices
	 * @param v1
	 * @param v2
	 * @return
	 */
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	 // (en grafo dirigido, v ha de ser origen de los arcos)
	
	


}
