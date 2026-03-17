public class Coche extends Vehicle {

	private boolean esAutomatic;

	public Coche(String matricula, String marca, String color, String model, int km, int numportes, boolean autom)
			throws Exception {
		super(matricula, marca, color, model, km);
		esAutomatic = autom;
	}

	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}

	@Override
	public String toString() {
		return "[ esAutomatic=" + esAutomatic + ", matricula=" + matricula + ", marca=" + marca + ", model=" + model
				+ ", color=" + color + ", km=" + km + "]";
	}

}