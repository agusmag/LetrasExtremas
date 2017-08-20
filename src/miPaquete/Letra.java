package miPaquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Letra {
	private int cantPalabras;
	private String[] arrayPalabras;

	// Constructor de la clase Letra.
	public Letra(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		cantPalabras = sc.nextInt();
		sc.nextLine();
		arrayPalabras = new String[cantPalabras];

		for (int i = 0; i < arrayPalabras.length; i++) {
			arrayPalabras[i] = sc.nextLine();
		}

		sc.close();

	}

	public void Mostrar() {

		for (int i = 0; i < arrayPalabras.length; i++) {
			System.out.println(arrayPalabras[i]);
		}
		System.out.println();
	}

	public void Resolver(String path) {
		Map<Character, Integer> mapa = new HashMap<Character, Integer>();
		int posLetra;

		for (int i = 0; i < arrayPalabras.length; i++) {
			posLetra = arrayPalabras[i].length() - 1;

			if (mapa.containsKey(arrayPalabras[i].charAt(0))) {
				mapa.put(arrayPalabras[i].charAt(0), mapa.get(arrayPalabras[i].charAt(0)) + 1);
			} else {
				mapa.put(arrayPalabras[i].charAt(0), 1);
			}
			
			if (mapa.containsKey(arrayPalabras[i].charAt(posLetra))) {
				mapa.put(arrayPalabras[i].charAt(posLetra), mapa.get(arrayPalabras[i].charAt(posLetra)) + 1);
			} else {
				mapa.put(arrayPalabras[i].charAt(posLetra), 1);
			}
		}

		int cantMax = 0;
		StringBuilder cadLetras = new StringBuilder();
		
		for (Map.Entry<Character, Integer> elemento : mapa.entrySet()) {
			System.out.println("Clave =" + elemento.getKey() + " | Valor =" + elemento.getValue());
			if (elemento.getValue() >= cantMax) {
				cantMax = elemento.getValue();
			}
		}
		
		for (Map.Entry<Character, Integer> elemento : mapa.entrySet()) {
			if (elemento.getValue() == cantMax) {
				cadLetras.append(elemento.getKey());
			}
		}
		
		char [] caracteresClave = cadLetras.toString().toCharArray();
		char primeraLetra;
		char ultimaLetra;
		Set<String> palabrasLote = new HashSet<String>();
		
		for (int i = 0; i < caracteresClave.length; i++) {
			for (int j = 0; j < arrayPalabras.length; j++) {
				primeraLetra =  arrayPalabras[j].charAt(0);
				ultimaLetra = arrayPalabras[j].charAt(arrayPalabras[j].length()-1);
				
				if (caracteresClave[i] == primeraLetra || caracteresClave[i] == ultimaLetra){
					palabrasLote.add(arrayPalabras[j]);
				}
			}	
		}
		
		System.out.println();
		
		for (int i = 0; i < caracteresClave.length; i++) {
			System.out.print(caracteresClave[i] + " ");
		}
		
		System.out.println();
		
		for (String palabra : palabrasLote) {
			System.out.println(palabra);
		}
	}

}
