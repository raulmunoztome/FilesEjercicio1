import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class GestionFichero {

	static Set<Vehicle> llegirCSV(String nomFitxer) throws Exception {

		File fitxer = new File(nomFitxer); // Adreçament relatiu

		FileReader fReader = null; // Lector del fitxer

		String linia;
		Set<Vehicle> total = new TreeSet<>();

		try (BufferedReader bReader = new BufferedReader(new FileReader(fitxer))) {
			String info;
			while ((linia = bReader.readLine()) != null) {

				String matricula, marca, model, color;
				int km;
				String[] elemento = linia.split("; ");
				if (elemento.length != 8)
					throw new Exception("error en los datos recibidos");
				matricula = elemento[1];
				km = Integer.parseInt(elemento[2]);
				marca = elemento[3];
				model = elemento[4];
				color = elemento[5];

				if (elemento[0] == "coche") {
					boolean esAutomatic = Boolean.parseBoolean(elemento[7]);
					int numPuertas = Integer.parseInt(elemento[8]);
					total.add(new Coche(matricula, marca, model, color, km, numPuertas, esAutomatic));

				} else {
					int cilindrada = Integer.parseInt(elemento[7]);
					String tipus = elemento[8];
					total.add(new Moto(matricula, marca, model, color, km, cilindrada, tipus));
				}

			}
			return total;

		} catch (FileNotFoundException e) {

			System.out.println("Fitxer no existeix");
			return total;
		} catch (IOException e) {

			System.out.println(e.getMessage());
			return total;
		}
	}

	static void desaCSV(String nomFitxer, Set<Vehicle> vehicles) {
		boolean append = false;

		PrintWriter pWriter = null;

		FileWriter fWriter = null;

		try {

			fWriter = new FileWriter(nomFitxer, append);

			pWriter = new PrintWriter(fWriter);
			for (Vehicle v : vehicles) {
				pWriter.println(v);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {

			try {

				if (fWriter != null)

					fWriter.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

			if (pWriter != null)

				pWriter.close();

		}

	}
}