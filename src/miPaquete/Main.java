package miPaquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Letra letra1 = new Letra("IN/lote1.txt");
		
		letra1.Mostrar();
		
		letra1.Resolver("Hola");

	}

}
