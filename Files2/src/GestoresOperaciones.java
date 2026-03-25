import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface GestoresOperaciones {
	Set<Vehicle> llegir(String nombreFichero) throws FileNotFoundException, Exception;

	void desa(String fichero, Set<Vehicle> v) throws FileNotFoundException, IOException;

}
