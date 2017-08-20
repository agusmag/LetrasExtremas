package miPaquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Agustin
 *	
 */
public class Letra { 
	private int cantPalabras;
	private String[] arrayPalabras;

	
	//Constructor de la clase Letra.
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
	
	public void Mostrar(){
	
		for (int i = 0; i < arrayPalabras.length; i++) {
			System.out.println(arrayPalabras[i]);
		}
	
	}
	
	public void Resolver(String path){
		
	
		
	}
	
	
}
