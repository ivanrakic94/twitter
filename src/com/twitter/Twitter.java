package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa predstavlja drustvenu mrezu Twitter. Sadrzi metode za unosenje poruke i
 * pretrazivanje poruka po tagu.
 * 
 * @author ivanrakic94
 * @version 1.0
 */

public class Twitter {
	
	/**
	 * Lista objekata tipa TwitterPoruka.
	 */
	
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vraca sve poruke u listi.
	 * @return sve Twitter poruke kao lista
	 */
	
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda kreira novu TwitterPoruku na osnovu parametara
	 *  i unosi je na poslednje mesto u listi.
	 * @param korisnik ime novog korisnika
	 * @param poruka poruka koju korisnik unosi
	 */
	
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda vraca poruke u kojima se pojavljuje uneti tag, a maksimalni broj 
	 * vracenih poruka se unosi kao parametar.
	 * @param maxBroj maksimalan broj poruka koji moze biti vracen
	 * @param tag tag po kome se pretrazuju poruke u listi
	 * @return poruke u kojima je pronadjen uneti tag u vidu niza objekata`
	 * @throws java.lang.RuntimeException ako je uneti tag null ili prazan String
	 */
	
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
			for (int i = 0; i < poruke.size(); i++)
				if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
					if (brojac < maxBroj){
						rezultat[brojac]=poruke.get(i);
						brojac++;
					}
				else break;
		return rezultat;
	}
	
}