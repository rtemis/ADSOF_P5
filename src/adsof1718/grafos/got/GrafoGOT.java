package adsof1718.grafos.got;

import java.nio.MappedByteBuffer;
import java.nio.file.*;
import java.util.stream.*;

import javax.print.attribute.Size2DSyntax;

import java.util.*;
import java.io.*;

import adsof1718.grafos.*;

/**
 * Clase GrafoGOT extiende a GrafoNoDirigido
 * <p>
 * Esta clase usa metodos lambda para controlar el flujo de datos
 *  del grafo. Tambien se controla a traves de los streams, metodos
 *  heredados de Java 8.
 * 
 * 
 * @author Leah Hadeed 		leah.hadeed@estudiante.uam.es
 * @author Sara Gonzalez 	sara.gonzalezg01@estudiante.uam.es
 *
 * @param <T>, tipo de datos siendo PersonajeGOT
 */
public class GrafoGOT<T extends PersonajeGOT> extends GrafoNoDirigido<T>{
	
	/**
	 * Constructor de GrafoGOT
	 * <p> 
	 * @param ficheroVertices, fichero csv de vertices
	 * @param ficheroArcos, fichero csv de arcos
	 * @throws Exception if files are not found
	 */
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();
		File inputF = new File(ficheroVertices);
	    InputStream inputFS = new FileInputStream(inputF);
	    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	    
	    br.lines().forEach(line -> {	
	    	String[] datos = line.split(",");
	    	addVertice(Integer.parseInt(datos[0]), (T) new PersonajeGOT(datos[1], datos[2]));
	    });
	    
	    br.close();
	    
	    inputF = new File(ficheroArcos);
	    inputFS = new FileInputStream(inputF);
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(inputFS));
	    
	    br2.lines().forEach(line -> {
	    	String [] datos = line.split(",");
	    	addArco(getVertices().get(Integer.parseInt(datos[0]) - 1), getVertices().get(Integer.parseInt(datos[1]) - 1), Double.parseDouble(datos[2]));
	    });
	    br2.close();
	}
	
	/**
	 * Metodo getVertice
	 * <p> 
	 * Devuelve el vértice que contiene el personaje cuyo nombre se indica como argumento de entrada.
	 * @param nombre, String, nombre de personaje
	 * @return v Vertice 
	 */
	public Vertice<PersonajeGOT> getVertice(String nombre) {
		return (Vertice<PersonajeGOT>) vertices.values().stream().filter( v -> v.getDatos().getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	/**
	 * Metodo casas
	 * <p>
	 * Devuelve una lista con los nombres de las casas sin repeticiones, ordenadas, y sin valores null
	 * @return casas List
	 */
	public List<String> casas() {
		return vertices.values().stream().map(v -> v.getDatos().getCasa()).filter(v -> !v.equals("null")).distinct().sorted().collect(Collectors.toList());
	}
	
	/**
	 * Metodo miembrosCasa
	 * <p>
	 * Devuelve una lista con los nombres de los personajes de una casa indicada como 
	 *  argumento de entrada. 
	 * @param casa, String casa deseada
	 * @return miembros List
	 */
	public List<String> miembrosCasa(String casa) {
		return vertices.values().stream().filter(v -> v.getDatos().getCasa().equals(casa)).map(v -> v.getDatos().getNombre()).collect(Collectors.toList());
	}
	
	/**
	 * Metodo gradoPersonajes
	 * <p>
	 * Este metodo devuelve un mapa del grado de los personajes, usando como
	 *  clave los nombres de los personajes y el valor siendo la cantidad de 
	 *  vecinos que tiene cada personaje.
	 * @return map de los grados de los personajes
	 */
	public Map<String, Integer> gradoPersonajes() {
		Map<String, Integer> mapped = new TreeMap<>();
		vertices.values().stream().forEach(v -> {
			if (arcos.containsKey(v.getId())) {
				mapped.put(v.getDatos().getNombre(), getVecinosDe(v).size());
			}
		});
		return mapped;
	} 
	
	/**
	 * Metodo gradoPonderadoPersonajes
	 * <p>
	 * Devuelve los personajes y sus “grados ponderados”, esto es la suma de los
	 *  pesos de los arcos que unen a cada vértice con sus vecinos. 
	 * @return map de grados ponderados
	 */
	public Map<String, Integer> gradoPonderadoPersonajes() {
		Map<String,Integer> mapped = new TreeMap<>();
		vertices.values().stream().forEach(v -> {
			if (arcos.containsKey(v.getId()))
				mapped.put(v.getDatos().getNombre(), arcos.get(v.getId()).values().stream().reduce(Double::sum).orElse(0.0).intValue());
		});
		return mapped;
	} 
	
	/**
	 * Metodo personajesRelevantes
	 * <p>
	 * Devuelve los personajes y sus “grados ponderados”, pero sólo para 
	 *  aquellos personajes cuyo grado ponderado es superior al grado 
	 *  ponderado medio en la red social. 
	 * @return map de personas relevantes
	 */
	public Map<String, Integer> personajesRelevantes() {
		Map<String, Integer> map = new TreeMap<>();
		double media = gradoPonderadoPersonajes().values().stream().mapToDouble(a -> a).average().getAsDouble();
		vertices.values().stream().forEach(v -> {
			if (gradoPonderadoPersonajes().containsKey(v.getDatos().getNombre()))
				if (gradoPonderadoPersonajes().get(v.getDatos().getNombre()).intValue() > media)
					map.put(v.getDatos().getNombre(), gradoPonderadoPersonajes().get(v.getDatos().getNombre()));
		});
		return map;
	}
	
	public static void main(String ... args) {
		try {
			GrafoGOT<PersonajeGOT> grafo = new GrafoGOT<PersonajeGOT>("got-s01-vertices.csv", "got-s01-arcos.csv");
			System.out.println("Casas de GOT:\n" +grafo.casas().toString() + "\n");
			System.out.println("Personas Relevantes:\n" + grafo.personajesRelevantes().toString() + "\n");
			System.out.println("Miembros de casa Targaryen:\n" + grafo.miembrosCasa("Targaryen").toString() + "\n");
			System.out.println("Grados ponderados de los personajes:\n" + grafo.gradoPonderadoPersonajes() + "\n");
			System.out.println("Grados de los personajes:\n" + grafo.gradoPersonajes().toString() + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
