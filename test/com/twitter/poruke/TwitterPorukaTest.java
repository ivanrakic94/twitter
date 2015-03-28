/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ivan_2
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka tp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Pera");
		
		assertEquals("Pera", tp.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmpty() {
		tp.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Poruka");
		
		assertEquals("Poruka", tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoracenje() {
		tp.setPoruka("Poruka Poruka Poruka Poruka Poruka Poruka Poruka Poruka"
				+ "Poruka Poruka Poruka Poruka Poruka Poruka Poruka Poruka"
				+ "Poruka Poruka Poruka Poruka Poruka Poruka Poruka Poruka"
				+ "Poruka Poruka Poruka Poruka Poruka Poruka");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("Pera");
		tp.setPoruka("Poruka");
		
		assertEquals("KORISNIK:"+tp.getKorisnik()+" VREME:"+tp.getVreme().getTime()+
				" PORUKA:"+tp.getPoruka(), tp.toString());
	}

}
