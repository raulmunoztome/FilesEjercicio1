import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PrincipalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = "10";
		List<Vehicle> l1 = new ArrayList<>();
		Set<Vehicle> vset;

		try {
			Vehicle c1 = new Moto("AA-55555-AA", "Seat", "motorola", "azul", 5000, 125, "URBANA");
			Concesionario C1 = new Concesionario("Calle falsa 123, 08830", l1);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		System.out.println("Introduce tu opción: ");
		while (opcion != "0") {

			pintarMenu();

			opcion = sc.nextLine();
			switch (Integer.parseInt(opcion)) {
			case 1:
				try {

					vset = GestionFichero.llegirCSV("archivo.txt");
				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;

			}
		}
		sc.close();

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