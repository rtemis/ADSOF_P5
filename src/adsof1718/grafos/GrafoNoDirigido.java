/**
 * 
 */
package adsof1718.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez	sara.gonzalezg01@estudiante.uam.es
 */
public class GrafoNoDirigido<T> extends Grafo<T> {
	
	public GrafoNoDirigido() {
		super();
	}
	
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		Map<Integer,Double> vMap1 = new TreeMap<>();
		vMap1.put(v2.getId(), peso);
		Map<Integer,Double> vMap2 = new TreeMap<>();
		vMap2.put(v1.getId(), peso);
		super.arcos.put(v1.getId(), vMap1);
		super.arcos.put(v2.getId(), vMap2);
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		if (super.arcos.get(v1.getId()).get(v2.getId()) != null)
			return super.arcos.get(v1.getId()).get(v2.getId()).doubleValue();
		else 
			return super.arcos.get(v2.getId()).get(v1.getId()).doubleValue();
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> list = new ArrayList<>();
		for (Integer i : arcos.get(v.getId()).keySet()) {
			list.add(vertices.get(i));
		}
		return list;
	}
	
	@Override
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		if(super.existeArco(v1, v2) == true) {
			return true;
		}
		else if(super.existeArco(v2, v1) == true) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo<String> g = new GrafoNoDirigido<>();
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
