import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

public class GestionBinario implements GestoresOperaciones {

	public void desa(String nomFitxer, Set<Vehicle> vehicles) throws FileNotFoundException, IOException {
		ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(nomFitxer + ".bin"));

		for (Vehicle v : vehicles) {
			fileOut.writeObject(v);
		}

		fileOut.close();
	}

	public Set<Vehicle> llegir(String nomFitxer) throws Exception {
		ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(nomFitxer + ".bin"));
		Set<Vehicle> vehicles = new TreeSet<Vehicle>();
		try {

			while (true) {
				Vehicle v = (Vehicle) fileIn.readObject();
				vehicles.add(v);
			}
		} catch (EOFException e) {
			// Fin del fichero (esto es normal)
		} finally {
			fileIn.close();
		}

		return vehicles;
	}
}
