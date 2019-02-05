package yatzoo;

import java.util.ArrayList;
import java.util.List;

public class YatzooSpill {
	
	private List<Spiller> spillere = new ArrayList<>();
	{
		spillere.add(new Spiller("Atle"));
		spillere.add(new Spiller("Kari"));
	}
	private Spiller vinner = null; // tar vare på vinneren for å kunne vise han

	private Terning terning = new Terning();
	private Brett brett = new Brett();

	/**
	 * Lager et nytt stigespll.
	 */
	public Stigespill() {
	}
}
