package adsof1718.grafos;

import java.util.Map;

public class Arco<T> {
	private Vertice<T> origen;
	private Vertice<T> destino;
	private Integer peso;
	private boolean dirigido;

	public Arco(Vertice<T> v1, Vertice<T> v2, Integer peso, boolean d) {
		origen = v1;
		destino = v2;
		this.peso = peso;
		dirigido = d;
	}
	

}
