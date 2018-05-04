/**
 * 
 */
package adsof1718.grafos;

import java.util.*;

/**
 * Clase GrafoDirigido extiende a Grafo
 * <p>
 * Esta clase hereda todos los metodos de la super clase pero la forma 
 *  de manejar los datos es de forma dirigida. Eso quiere decir que 
 *  los arcos son direccionales y no bidireccionales, y que si un arco
 *  existe entre dos vertices, solo exite en una direccion. 
 *  
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez 	sara.gonzalezg01@estudiante.uam.es
 */
public class GrafoDirigido<T> extends Grafo<T> {
	
	/**
	 * Constructor heredado de la super clase
	 */
	public GrafoDirigido(){
		super();
	}
	
	@Override
	/**
	 * Anade un arco al grafo, comprobando primero si existe ya un arco
	 *  entre el primer vertice y cualquier otro. En el caso de que si, 
	 *  anade el arco directamente al mapa de vecinos del primer vertice.
	 *  Si no, crea el mapa de vecinos y luego mete el arco.
	 */
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if (arcos.containsKey(v1.getId()))
			arcos.get(v1.getId()).put(v2.getId(), peso);
		else {
			Map<Integer,Double> vMap2 = new TreeMap<>();
			vMap2.put(v2.getId(), peso);
			super.arcos.put(v1.getId(), vMap2);
		}
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		return super.arcos.get(v1.getId()).get(v2.getId()).doubleValue();
	}

	@Override
	/**
	 * Este metodo coge los vecinos de un vertice de forma direccional,
	 *  de tal manera de que si existe una instancia del id del vertice
	 *  dado en otro mapa de vecinos, no tiene influencia sobre esta lista.
	 */
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> list = new ArrayList<>();
		for (Integer i : arcos.get(v.getId()).keySet()) {
			list.add(vertices.get(i));
		}
		return list;
	}
	
	public static void main(String[] args) {
		Grafo<String> g = new GrafoDirigido<>();
		System.out.println(g.getClass().getName() + "\n");
		
		Vertice<String> v1 = g.addVertice("A");
		Vertice<String> v2 = g.addVertice("B");
		Vertice<String> v3 = g.addVertice("C");
		
		g.addArco(v1, v2, 10);
		g.addArco(v1, v2, 20);
		g.addArco(v3, v1, 30);
		
		System.out.println(g);
		List<Vertice<String>> vecinos1 = g.getVecinosDe(v1);
		
		System.out.println("Vecinos de " + v1 + ":");
		for (Vertice<String> v : vecinos1) {
		 System.out.println(v);
		}
		
		double peso1 = g.getPesoDe(v1, v2);
		System.out.println("Peso entre " + v1 + " y " + v2 + ": " + peso1);
		double peso2 = g.getPesoDe(v1, v3);
		System.out.println("Peso entre " + v1 + " y " + v3 + ": " + peso2);
	}

}
