package yatzoo;

public class main {

	public static void main(String[] args) {
		Kopp kopp = new Kopp(); 
		kopp.trill();
		kopp.skrivUtVerdier();
		
		Resultatblokk rb = new Resultatblokk();
		kopp.lagreTerning(1);
		kopp.lagreTerning(3);
		System.out.println();
		kopp.skrivUtVerdier();
		
		int poeng = rb.antallLike(kopp, 4); 
		
		System.out.println(poeng);
		
	/*	kopp.lagreTerning(1);
		kopp.lagreTerning(4);
		
		kopp.trill();
		System.out.println();
		kopp.skrivUtVerdier();
	*/
		}
	
	//String nystr = str.replaceAll("\\s","");     2 4 5 -> 245 
	//char[] array = nystr.toCharArray()           
	
	/* 
	 * For å lagre terninger som bruker skriver inn 
	 * splittet med mellomrom
	 * 
	 * String[] integerStrings = str.split(" ");
	 * int[] integerTab = new int[integerStrings.length]; 
	 * 
	 * for (int i = 0; i < integerStrings-1; i++) {
	 * 	integerTab[i] = Integer.parseInt(integerStrings[i]);
	 * 	
	 * }
	 * */
	 
		
	}

