import java.util.Scanner;

public class PrincipalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = "10";
		System.out.println("Introduce tu opción: ");
		while (opcion != "0") {
			pintarMenu();
			opcion = sc.nextLine();
			switch (Integer.parseInt(opcion)) {

			}
		}
	}

	public static void pintarMenu() {
		System.out.println("0 -> SALIR");
		System.out.println("1 -> CARGAR VEHICULOS DESDE FITXER CSV");
		System.out.println("2 -> CARGAR DESDE FITXER XML");
		System.out.println("3 -> MOSTRAR LA LLISTA DE VEHICLES");
		System.out.println("4 -> AFEGIR UN VEHICLE");
		System.out.println("5 -> TREURE UN VEHICULE (PER MATRICULA)");
		System.out.println("6 -> BUSCAR VEHICULO CON MAS KM");
		System.out.println("7 -> GUARDAR FICHEROS EN UN CSV");
		System.out.println("8 -> GUARDAR FICHEROS A UN XML");

	}
}
