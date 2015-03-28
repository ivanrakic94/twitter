package com.twitter.poruke;

import java.util.GregorianCalendar;

/**
 * Klasa predstavlja jednu poruku na drustvenoj mrezi Twitter.
 * 
 * @author ivanrakic94
 * @version 1.0
 *
 */

public class TwitterPoruka {
	
	/**
	 * Ime korisnika koji salje poruku.
	 */
	
	private String korisnik;
	
	/**
	 * Poruka koja se salje.
	 */
	
	private String poruka;
	
	/**
	 * Metoda vraca ime korisnika, tj. vrednost atributa korisnik.
	 * @return ime korisnika kao String.
	 */
	
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja ime korisnika na unetu vrednost.
	 * @param korisnik novo ime korisnika
	 * @throws java.lang.RuntimeException ako je uneti String null ili prazan String.
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca poruku, tj. vrednost atributa poruka.
	 * @return poruka kao String
	 */
	
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda postavlja vrednost atributa poruka na uneti String.
	 * @param poruka nova poruka
	 * @throws java.lang.RuntimeException ako je uneta poruka null ili ako je duza od
	 * 140 karaktera.
	 */
	
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Redefinisana metoda toString klase Object.
	 * Vraca String u kome se nalaze informacije o korisniku, sadrzaju poruke i
	 * vremenu slanja.
	 */
	
	@Override
	public String toString(){
		return "KORISNIK:"+korisnik+" VREME:"+vreme.getTime()+
				" PORUKA:"+poruka;
	}
}
