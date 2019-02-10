package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import yatzoo.Kopp;
import yatzoo.Resultatblokk;
import yatzoo.Terning;

public class testKategorier {
	Resultatblokk resultatblokk;
	Kopp kopp;

	@Before
	public final void nyResultatblokk() {
		resultatblokk = new Resultatblokk();
		kopp = new Kopp();
	}

	@Test
	public void testLagreTerning() {

		kopp.trill();

		Terning[] temp = kopp.getKopp();
		int terningNummer = 2;

		kopp.lagreTerning(terningNummer);
		kopp.trill();

		assertEquals(temp[terningNummer - 1], kopp.getKopp()[terningNummer - 1]);
	}

	@Test
	public void testAntallDyr() {
		Terning[] eksempelKopp = { Terning.LØVE, Terning.GRIS, Terning.GRIS, Terning.HVAL, Terning.GRIS };
		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.antallDyr(kopp, Terning.GRIS), 3);
	}

	@Test
	public void testAntallLike() {
		Terning[] eksempelKopp = { Terning.GRIS, Terning.GRIS, Terning.GRIS, Terning.GRIS, Terning.GRIS };
		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.antallLike(kopp, 4), 4);
	}

	@Test
	public void testToPar() {
		Terning[] eksempelKopp = { Terning.GRIS, Terning.LØVE, Terning.LØVE, Terning.HVAL, Terning.GRIS };
		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.toPar(kopp), 4);
	}

	@Test
	public void testHus() {
		Terning[] eksempelKopp = { Terning.HVAL, Terning.LØVE, Terning.LØVE, Terning.LØVE, Terning.HVAL };
		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.hus(kopp), 5);
	}

	@Test
	public void testAlleUlike() {
		Terning[] eksempelKopp = { Terning.GRIS, Terning.LØVE, Terning.PANDA, Terning.SLANGE, Terning.HVAL };
		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.alleUlike(kopp), 5);
	}

	@Test
	public void testAlleLike() {
		Terning[] eksempelKopp = { Terning.GRIS, Terning.GRIS, Terning.GRIS, Terning.GRIS, Terning.GRIS };
		Terning[] eksempelKopp2 = { Terning.GRIS, Terning.GRIS, Terning.ELEFANT, Terning.GRIS, Terning.GRIS };

		kopp = new Kopp(eksempelKopp);
		assertEquals(resultatblokk.alleLike(kopp), 10);

		kopp = new Kopp(eksempelKopp2);
		assertEquals(resultatblokk.alleLike(kopp), 0);
	}

	@Test
	public void testTomKopp() {
		kopp.trill();
		int terningNr = 2;

		kopp.lagreTerning(terningNr);
		assertEquals(kopp.getLagredeTerninger()[terningNr - 1], 1);

		kopp.tomKopp();
		assertEquals(kopp.getLagredeTerninger()[terningNr - 1], 0);

		kopp.lagreTerning(3);
		kopp.lagreTerning(1);
		kopp.tomKopp();

		for (int i : kopp.getLagredeTerninger()) {
			assertEquals(i, 0);

		}
	}
}
