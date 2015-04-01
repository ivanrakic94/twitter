/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Seka i bato
 *
 */
public class TwitterTest {
	
	Twitter t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		assertEquals(poruke, t.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		
		t.unesi("Pera", "poruka");
		
		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Pera", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("poruka", t.vratiSvePoruke().get(0).getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi2() {
		
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "neka poruka");
		
		assertEquals(2, t.vratiSvePoruke().size());
		
		assertEquals("Pera", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("poruka", t.vratiSvePoruke().get(0).getPoruka());
		
		assertEquals("Mika", t.vratiSvePoruke().get(1).getKorisnik());
		assertEquals("neka poruka", t.vratiSvePoruke().get(1).getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		
		t.unesi(null, null);

	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiEmpty() {
		
		t.unesi("", "");

	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPrekoracenje() {
		
		t.unesi("korisnik", "poruka poruka poruka poruka poruka poruka poruka "
				+ "poruka poruka poruka poruka poruka poruka poruka poruka "
				+ "poruka poruka poruka poruka poruka poruka poruka "
				+ "poruka poruka poruka poruka ");

	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "druga poruka");
		t.unesi("Zika", "komentar");
		
		assertEquals(5, t.vratiPoruke(5, "poruka").length);
		assertEquals("Pera", t.vratiPoruke(5, "poruka")[0].getKorisnik());
		assertEquals("poruka", t.vratiPoruke(5, "poruka")[0].getPoruka());
		assertEquals("Mika", t.vratiPoruke(5, "poruka")[1].getKorisnik());
		assertEquals("druga poruka", t.vratiPoruke(5, "poruka")[1].getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "druga poruka");
		t.unesi("Zika", "komentar");
		
		t.vratiPoruke(5, null);
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmpty() {
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "druga poruka");
		t.unesi("Zika", "komentar");
		
		t.vratiPoruke(5, "");
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeNegativno() {
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "druga poruka");
		t.unesi("Zika", "komentar");
		
		assertEquals(100, t.vratiPoruke(0, "poruka").length);
		assertEquals("Pera", t.vratiPoruke(5, "poruka")[0].getKorisnik());
		assertEquals("poruka", t.vratiPoruke(5, "poruka")[0].getPoruka());
		assertEquals("Mika", t.vratiPoruke(5, "poruka")[1].getKorisnik());
		assertEquals("druga poruka", t.vratiPoruke(5, "poruka")[1].getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukePrekoracenje() {
		t.unesi("Pera", "poruka");
		t.unesi("Mika", "druga poruka");
		t.unesi("Zika", "treca poruka");
		
		
		assertEquals(2, t.vratiPoruke(2, "poruka").length);
		assertEquals("Pera", t.vratiPoruke(2, "poruka")[0].getKorisnik());
		assertEquals("poruka", t.vratiPoruke(2, "poruka")[0].getPoruka());
		assertEquals("Mika", t.vratiPoruke(2, "poruka")[1].getKorisnik());
		assertEquals("druga poruka", t.vratiPoruke(2, "poruka")[1].getPoruka());
	}

}
