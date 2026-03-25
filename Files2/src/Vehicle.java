import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class Vehicle implements Serializable, Comparable<Vehicle> {
	protected String matricula;
	protected String marca;
	protected String model;
	protected String color;
	protected int km;

	public Vehicle(String matricula, String marca, String model, String color, int km) throws Exception {
		// Patrón inventado a seguir: AA 12345 AA
		if (!Pattern.matches("^[A-Z]{2}-[0-9]{5}-[A-Z]{2}$", matricula))
			throw new Exception("Matricula no válida " + matricula);
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.color = color;
		if (km < 0)
			throw new Exception("Error en el km");
		this.km = km;
	}

	public Vehicle() {

	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int descuento() {

		int des = this.getKm() / 10000;

		if (des > 10)
			return 10;

		return des;
	}
	public static boolean deleteVehicle(String mat, Set<Vehicle> v) {
		Vehicle borrar = null;
		for(Vehicle s : v) {
			if(s.getMatricula().equals(mat)) {
				borrar = s;
				break;
			}
		}
		return v.remove(borrar);
	}
	public static Vehicle mayorKm(Set<Vehicle> listado) {
		int kms = 0;
		Vehicle mandar = null;
		
		for(Vehicle v : listado) {
			int compara = v.getKm();
			if(kms < compara) {
				kms = compara;
				mandar = v;
			}
		}
		return mandar;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.getClass().getSimpleName(), marca, model, matricula);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Vehicle other = (Vehicle) obj;

		return Objects.equals(matricula, other.matricula) && Objects.equals(marca, other.marca)
				&& Objects.equals(model, other.model);

	}

	@Override
	public String toString() {
		return "Vehicle [matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", color=" + color
				+ ", km=" + km + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}


	public int compareTo(Vehicle p) {

		// Primero comprar las clases
		int comparacionClase = this.getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
		if (comparacionClase != 0) {
			return comparacionClase;
		}

		int comparacionModelo = this.model.compareTo(p.getModel());
		if (comparacionModelo != 0) {
			return comparacionModelo;
		}

		int comparacionMarca = this.marca.compareTo(p.getMarca());
		if (comparacionMarca != 0) {
			return comparacionMarca;
		}

		return this.matricula.compareTo(p.getMatricula());
	}

}