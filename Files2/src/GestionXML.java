import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class GestionXML {

	public GestionXML() {

	}

	Set<Vehicle> llegir(String nomFitxero) throws FileNotFoundException {

		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFitxero)));
		Vehicle p2 = (Vehicle) d.readObject();
		d.close();
		return (Set<Vehicle>) p2;

	}

	void desa(String nomFitxer, Set<Vehicle> vehicles) throws FileNotFoundException {
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)));
		e.writeObject(vehicles);
		e.close();
	}
}
