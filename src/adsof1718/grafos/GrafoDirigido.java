/**
 * 
 */
package adsof1718.grafos;

import java.util.*;

/**
 * @author leah_
 */
public class GrafoDirigido<T> extends Grafo<T> {
	
	public GrafoDirigido(){
		super();
	}
	
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if (super.existeArco(v1, v2))
			return;
		Map<Integer,Double> vMap2 = new TreeMap<>();
		vMap2.put(v2.getId(), peso);
		super.arcos.put(v1.getId(), vMap2);	
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		return super.arcos.get(v1.getId()).get(v2.getId()).doubleValue();
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> list = new ArrayList<>();
		for (Integer i : arcos.get(v.getId()).keySet()) {
			list.add(vertices.get(i));
		}
		return list;
	}
	
	/**
	 * @param args
	 */
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
