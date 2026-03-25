public class Moto extends Vehicle {

	private int cilindrada;
	private TipoMoto.tipoMoto tipus;

	public Moto(String matricula, String marca, String model, String color, int km, int cilindrada, String tipus)
			throws Exception {
		super(matricula, marca, model, color, km);

		if (cilindrada <= 0)
			throw new Exception("Cilindrada no válida");
		this.cilindrada = cilindrada;

		if (!TipoMoto.infoTipos(tipus))
			throw new Exception("tipo no válido");
		this.tipus = TipoMoto.addTipo(tipus);

	}

	public Moto() {

	}

	public void setTipus(TipoMoto.tipoMoto tipus) {
		this.tipus = tipus;
	}

	public int getCilindrada() {

		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {

		if (cilindrada > 0)
			this.cilindrada = cilindrada;
	}

	public String getTipus() {
	    return (tipus != null) ? tipus.name() : "";
	}

	public void setTipus(String tipus) {

		if (!TipoMoto.infoTipos(tipus))
			this.tipus = TipoMoto.addTipo(tipus);
	}

	@Override
	public String toString() {

		return "Moto [cilindrada=" + cilindrada + ", tipus=" + tipus + ", matricula=" + matricula + ", marca=" + marca
				+ ", model=" + model + ", color=" + color + ", km=" + km + "]";
	}
	public static String formatoCSV(Moto v) {
	    return "Moto; " +
	            v.getMatricula() + "; " +
	            v.getKm() + "; " +
	            v.getMarca() + "; " +
	            v.getModel() + "; " +
	            v.getColor() + "; " +
	            v.getCilindrada() + "; " +
	            v.getTipus();
	}

	@Override
	public int descuento() {

		if (cilindrada > 125) {

			return super.descuento();
		}

		if ((km / 5000) * 2 > 20)
			return 20;

		return (km / 5000) * 2;
	}

}