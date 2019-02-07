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
		
		assertEquals(temp[terningNummer-1], kopp.getKopp()[terningNummer-1]);
	}
	
	@Test 
	public void testAntallDyr () {
		Terning[] eksempelKopp = {Terning.LØVE, Terning.GRIS, Terning.GRIS, Terning.HVAL, Terning.GRIS};
		kopp = new Kopp(eksempelKopp); 
		assertEquals(resultatblokk.antallDyr(kopp, Terning.GRIS), 3);
	}
	
	@Test 
	public void testAntallLike () {
		Terning[] eksempelKopp = {Terning.LØVE, Terning.GRIS, Terning.GRIS, Terning.HVAL, Terning.GRIS};
		kopp = new Kopp(eksempelKopp); 
		assertEquals(resultatblokk.antallDyr(kopp, Terning.GRIS), 3);
	}
	
	/*
	@Test 
	public void testAntallDyr () {
		Terning[] eksempelKopp = {Terning.LØVE, Terning.GRIS, Terning.GRIS, Terning.HVAL, Terning.GRIS};
		kopp = new Kopp(eksempelKopp); 
		assertEquals(resultatblokk.antallDyr(kopp, Terning.GRIS), 3);
	}
	*/
}

