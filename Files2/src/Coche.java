public class Coche extends Vehicle {

	private boolean esAutomatic;
	private int numportes;

	public Coche(String matricula, String marca, String model, String color, int km, int numportes, boolean autom)
			throws Exception {
		super(matricula, marca, color, model, km);
		esAutomatic = autom;
		this.numportes = numportes;
	}

	public Coche() {

	}

	public int getNumportes() {
		return numportes;
	}

	public void setNumportes(int numportes) {
		this.numportes = numportes;
	}

	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}



	@Override
	public String toString() {
		return "Coche [esAutomatic=" + esAutomatic + ", numportes=" + numportes + ", matricula=" + matricula
				+ ", marca=" + marca + ", model=" + model + ", color=" + color + ", km=" + km + "]";
	}

	public static String formatoCSV(Coche v) {
	    return "Coche; " +
	            v.getMatricula() + "; " +
	            v.getKm() + "; " +
	            v.getMarca() + "; " +
	            v.getModel() + "; " +
	            v.getColor() + "; " +
	            v.getNumportes() + "; " +
	            v.isEsAutomatic();
	}

}