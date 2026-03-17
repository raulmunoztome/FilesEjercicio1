public abstract class TipoMoto {

	public enum tipoMoto {
		URBANA, DEPORTIVA, SCOOTER, TRAIL, CUSTOM
	}

	public static boolean infoTipos(String moto) {

		for (tipoMoto t : tipoMoto.values()) {
			if (t.name().equalsIgnoreCase(moto))
				return true;
		}
		return false;
	}

	public static tipoMoto addTipo(String moto) {

		return tipoMoto.valueOf(moto.toUpperCase());

	}
}
