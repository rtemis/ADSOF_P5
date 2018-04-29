package adsof1718.grafos.got;

import java.nio.file.*;
import java.util.stream.*;
import java.util.*;
import java.io.*;

import adsof1718.grafos.*;

public class GrafoGOT<T extends PersonajeGOT> extends GrafoNoDirigido<T>{
	
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();
		File inputF = new File(ficheroVertices);
	    InputStream inputFS = new FileInputStream(inputF);
	    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	    
	    br.lines().forEach(line -> {	
	    	String[] datos = line.split(",");
	    	addVertice(Integer.parseInt(datos[0]),(T) new PersonajeGOT(datos[1], datos[2]));
	    });
	    
	    inputF = new File(ficheroArcos);
	    inputFS = new FileInputStream(inputF);
	    br = new BufferedReader(new InputStreamReader(inputFS));
	    
	    br.lines().forEach(line -> {
	    	String [] datos = line.split(",");
	    	addArco(getVertices().get(Integer.parseInt(datos[0])), getVertices().get(Integer.parseInt(datos[1])), Double.parseDouble(datos[2]));
	    });
	    
	}
	    
	public Vertice<PersonajeGOT> getVertice(String nombre) {
		return (Vertice<PersonajeGOT>) vertices.values().stream().filter( v -> v.getDatos().getNombre().equals(nombre));
	}
	
	public List<String> casas() {
//		List list = vertices.values().stream().filter(v -> v.getDatos().getCasa() != null);
//		return list;
	}
	
	public List<String> miembrosCasa(String casa) {
		
	}
	
	public Map<String, Integer> gradoPersonajes() {
		
	} 
	
	public Map<String, Integer> gradoPonderadoPersonajes() {
		
	} 
	
	public Map<String, Integer> personajesRelevantes() {
		
	}


}
