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

}
