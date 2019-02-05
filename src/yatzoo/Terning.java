package yatzoo;

public enum Terning {
		LØVE(1), SLANGE(2), PANDA(3), GRIS(4), ELEFANT(5), HVAL(6);
		private int nr;

		private Terning(int n) { // Konstruktør
			this.nr = n;
		}

		public int getNr() {
			return nr;
		}

		public static Terning finnDyr(int n) {
			Terning dyret = null;
			for (Terning dyr : Terning.values()) {
				if (dyr.nr == n) {
					dyret = dyr;
					break;
				}
			}
			return dyret;
		}// metode

		public static Terning finnDyr(String input) {
			Terning dyret = null;
			for (Terning dyr : Terning.values()) {
				if (dyr.toString().equals(input.toUpperCase())) {
					dyret = dyr;
					break;
				}
			}
			return dyret;
		}// metode

}
