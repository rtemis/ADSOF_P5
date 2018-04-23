/**
 * 
 */
package adsof1718.grafos;

import java.util.List;

/**
 * @author leah_
 *
 */
public class GrafoNoDirigido extends Grafo<T> {

	


	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		Grafo<String> g = new GrafoNoDirigido<T>();
		//Grafo<String> g = new GrafoDirigido<>();
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
