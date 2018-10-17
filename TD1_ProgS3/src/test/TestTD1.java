package test;

import static org.junit.Assert.*;

import org.junit.*;

import tp1.DeviseException;
import tp1.Money;
import tp1.MoneyList;

/**
 * Classe de test de la classe money 
 * @author victo
 *
 */
public class TestTD1 {
	/**
	 * les 3 Money initialement instancié
	 */
	private Money m1,m2,m3;
	private MoneyList list;
	
	/**
	 * Initalisation du debut (s'execute avant tout) 
	 */
	@Before 
	public void init() {
		m1 = new Money(40,"EUR");
		m2 = new Money(40,"EUR");
		m3 = new Money(40,"USD");
		list = new MoneyList();
	}
	

	/**
	 * Test de la methode equals de money
	 */
	@Test
	public void testEquals() {
		boolean res = m1.equals(m2);
		assertTrue("m1 et m2 devraient être égaux",res);
		res = m2.equals(m3);
		assertFalse("m2 et m3 devraient ne pas être égaux",res);
		
	}
	
	/**
	 * Test de la methode ajouter de Money 
	 */
	@Test
	public void testAdd() {
		Money m4 = m1.add(m2);
		assertEquals("La nouvelle money devrait avoir un montant de 80",m4.getMontant(),80);
		assertEquals("La nouvelle money devrait avoir un montant de 80",m4.getDevise(),"EUR");
	}
	
	/**
	 * Test de la methode ajouter de Money 
	 */
	@Test
	public void testAddErrone() {
		Money m4 = m1.add(m3);
		assertEquals("La nouvelle money devrait etre null",m4,null);
	}
	
	/**
	 * Test permettant de verifier le bon fonctionnement de l'ajout
	 * @throws DeviseException
	 */
	@Test
	public void testAJouterMoneyList() throws DeviseException {
		list.ajouterSomme(m1);
		assertEquals("La liste devrait avoir un élément :",1,list.getList().size());
		list.ajouterSomme(m3);
		assertEquals("La liste devrait avoir deux éléments :",2,list.getList().size());
		list.ajouterSomme(m2);
		assertEquals("La liste devrait avoir deux éléments :",2,list.getList().size());
		assertEquals("La 1er élément de la liste devrait avoir un montant de 80 :",80,list.getList().get(0).getMontant());
	}
	
	/**
	 * Methode permettant de verifier que le tri par montant fonctionne
	 * @throws DeviseException
	 */
	@Test
	public void testTriMontant() throws DeviseException {
		list.ajouterSomme(new Money(10,"EUR"));
		list.ajouterSomme(new Money(100,"USA"));
		list.ajouterSomme(m3);
		list.triMontant();
		assertEquals("La 1er élément de la liste devrait avoir un montant de 10 :",10,list.getList().get(0).getMontant());
		assertEquals("La 2eme élément de la liste devrait avoir un montant de 40 :",40,list.getList().get(1).getMontant());
		assertEquals("La 3eme élément de la liste devrait avoir un montant de 100 :",100,list.getList().get(2).getMontant());
	}
	
	/**
	 * TEst permettant de verifier que le tri par devise fonctionne
	 * @throws DeviseException
	 */
	@Test
	public void testTriDevise() throws DeviseException {
		list.ajouterSomme(new Money(100,"USA"));
		list.ajouterSomme(new Money(10,"EUR"));
		list.ajouterSomme(m3);
		list.triDevise();
		assertEquals("La 1er élément de la liste devrait avoir etre eur:","EUR",list.getList().get(0).getDevise());
		assertEquals("La 2eme élément de la liste devrait etre USA :","USA",list.getList().get(1).getDevise());
		assertEquals("La 3eme élément de la liste devrait etre USD :","USD",list.getList().get(2).getDevise());
	}

}
