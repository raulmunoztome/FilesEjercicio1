import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrincipalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = "17";
		String nombreArchivo = "";
		Set<Vehicle> vset = new TreeSet<Vehicle>();

		GestionCSV gestor1 = new GestionCSV();
		GestionXML gestor2 = new GestionXML();
		GestionBinario gestor3 = new GestionBinario();

		try {

			Vehicle v1 = new Moto("AB-12345-BA", "Seat", "motorola", "azul", 5000, 125, "URBANA");
			Vehicle v2 = new Moto("AF-10345-BA", "Tesla", "Alfa", "blanco", 8000, 125, "URBANA");
			Vehicle v3 = new Coche("RT-44444-ZZ", "Citroen", "Picasso", "rojo", 20000, 5, false);

			vset.add(v1);
			vset.add(v2);
			vset.add(v3);

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
					vset = gestor1.llegir(nombreArchivo);

				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;

			case 2:

				try {

					System.out.println("Introduce el nombre del archivo: ");
					nombreArchivo = sc.nextLine();
					vset = gestor2.llegir(nombreArchivo);

				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;

			case 3:
				for (Vehicle v : vset) {
					System.out.println(v + "\n");
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
				System.out.println("introduce la matricula: ");
				String buscar = sc.nextLine();
				if (Vehicle.deleteVehicle(buscar, vset)) {
					System.out.println("vehiculo eliminado");
				} else
					System.out.println("Elemento no encontrado");
				break;
			case 6:
				System.out.println("El vehiculo con mayor KM es:\n" + Vehicle.mayorKm(vset));
				break;
			case 7:
				System.out.println("introduce el nombre del archivo donde guardar los vehiculos:");
				String archivo = sc.nextLine();
				gestor1.desa(archivo, vset);
				break;
			case 8:
				System.out.println("introduce el nombre del archivo donde guardar los vehiculos:");
				String archivo2 = sc.nextLine();
				try {
					gestor2.desa(archivo2, vset);
				} catch (FileNotFoundException e) {

				}
				break;
			case 9:

				System.out.println("introduce el nombre del archivo donde guardar los vehiculos:");

				String archivoB = sc.nextLine();
				try {
					gestor3.desa(archivoB, vset);
				} catch (FileNotFoundException e) {

					System.out.println(e.getMessage());
				} catch (IOException e) {

					System.out.println(e.getMessage());
				}
				break;
			case 10:
				System.out.println("Introduce el nombre del archivo: ");

				String encontrar = sc.nextLine();
				try {
					vset = gestor3.llegir(encontrar);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
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
		System.out.println("9 -> GUARDAR EN BINARIO");
		System.out.println("10 -> RECUPERAR EL BINARIO");

	}
}