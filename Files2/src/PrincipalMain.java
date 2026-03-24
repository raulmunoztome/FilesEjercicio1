import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PrincipalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = "10";
		String nombreArchivo = "";
		List<Vehicle> l1 = new ArrayList<>();
		Set<Vehicle> vset = null;

		GestionCSV gestor1 = new GestionCSV();
		GestionXML gestor2 = new GestionXML();

		try {
			Vehicle m1 = new Moto("AB-12345-BA", "Seat", "motorola", "azul", 5000, 125, "URBANA");
			l1.add(m1);
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
				// FALTA ACCESO A LOS METODOS, YA NO SON ESTATICOS
				try {
					System.out.println("Introduce el nombre del archivo: ");
					nombreArchivo = sc.nextLine();

				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;

			case 2:

				try {

					System.out.println("Introduce el nombre del archivo: ");
					nombreArchivo = sc.nextLine();

				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;

			case 3:
				for (Vehicle v : vset) {
					System.out.println(v);
				}
				break;

			case 4:
				System.out.println("Quieres introducir un coche o una moto? ");
				String clase = sc.nextLine();
				if (clase.equalsIgnoreCase("coche")) {
					String marca, modelo, color, km, numPortes, autom, matric;
					System.out.println("Introduce la matricula:");
					matric = sc.nextLine();
					System.out.println("Introduce la marca:");
					marca = sc.nextLine();
					System.out.println("Introduce el modelo:");
					modelo = sc.nextLine();
					System.out.println("Introduce el color:");
					color = sc.nextLine();
					System.out.println("Introduce los km:");
					km = sc.nextLine();
					System.out.println("Introduce el numero de puertas: ");
					numPortes = sc.nextLine();
					System.out.println("Es automatico? true/false");
					autom = sc.nextLine();

					try {
						vset.add(new Coche(matric, marca, modelo, color, Integer.parseInt(km),
								Integer.parseInt(numPortes), Boolean.getBoolean(autom)));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {
					String marca, modelo, color, km, cilindra, tipus, matric;
					System.out.println("Introduce la matricula:");
					matric = sc.nextLine();
					System.out.println("Introduce la marca:");
					marca = sc.nextLine();
					System.out.println("Introduce el modelo:");
					modelo = sc.nextLine();
					System.out.println("Introduce el color:");
					color = sc.nextLine();
					System.out.println("Introduce los km:");
					km = sc.nextLine();
					System.out.println("Introduce el numero de la cilindrada: ");
					cilindra = sc.nextLine();
					System.out
							.println("Escribe uno de los siguientes tipos: URBANA, DEPORTIVA, SCOOTER, TRAIL, CUSTOM");
					tipus = sc.nextLine();

					try {
						vset.add(new Moto(matric, marca, modelo, color, Integer.parseInt(km),
								Integer.parseInt(cilindra), tipus));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
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