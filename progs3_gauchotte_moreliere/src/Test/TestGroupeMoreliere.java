package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

import progs3_gauchotte_moreliere.Etudiant;
import progs3_gauchotte_moreliere.Formation;
import progs3_gauchotte_moreliere.Groupe2;

/**
 * Classe peremttant de tester un groupe de personnes
 * @author moreliere
 *
 */
public class TestGroupeMoreliere {
	
	/**
	 * Groupe utile aux tests
	 */
	Groupe2 g;
	/**
	 * Etudiants utiles aux tests
	 */
	Etudiant e1,e2,e3,e4,e5;
	
	/**
	 * Setup des variables de bases utiles pour les tests
	 */
	@Before
	public void setup() {
		g = new Groupe2(1);
		Formation f = new Formation(1);
		f.ajouterMatiere("Math", 2);
		f.ajouterMatiere("Sport", 4);
		e1 = new Etudiant("01","Moreliere","Jean",f);
		e2 = new Etudiant("02","Gauchotte","Rémi",f);
		e3 = new Etudiant("03","Dupont","Victor",f);
		e4 = new Etudiant("04","Schmitt","George",new Formation(2));
		e5 = new Etudiant("05","Fsdfsd","fdsqf",f);
		e1.ajouterNote(12, "Math");
		e2.ajouterNote(12, "Math");
		e3.ajouterNote(16, "Math");
		e5.ajouterNote(16, "Math");
		e1.ajouterNote(12, "Sport");
		e2.ajouterNote(14, "Sport");
	}

	/**
	 * Test de l'ajout d'un etudiant a un groupe
	 */
	@Test
	public void testAjout() {
		//Ajout simple (meme formation)
		g.ajouterEtudiant(e1);
		assertEquals("Il devrait y avoir un etudiant dans le groupe",1,g.getGroupe().size());
		//Ajout qui ne devrait pas marcher
		g.ajouterEtudiant(e4);
		assertEquals("Il devrait y avoir toujours un seul étudiant dans le groupe",1,g.getGroupe().size());
		//On remet un qui devrait marcher
		g.ajouterEtudiant(e2);
		assertEquals("Il devrait y avoir deux etudiants dans le groupe",2,g.getGroupe().size());
	}
	
	/**
	 * Test de l'a suppresion d'un étudiant dans un groupe
	 */
	@Test
	public void testSuppresion() {
		g.ajouterEtudiant(e1);
		g.ajouterEtudiant(e2);
		g.ajouterEtudiant(e3);
		assertEquals("Il devrait y avoir 3 etudiants dans le groupe",3,g.getGroupe().size());
		assertTrue("Le groupe devrait contenir e2",g.getGroupe().contains(e2));
		g.supprimerEtudiant(e2);
		assertEquals("Il devrait y avoir 2 etudiants dans le groupe",2,g.getGroupe().size());
		assertFalse("Le groupe ne devrait plus contenir e2",g.getGroupe().contains(e2));	
	}
	
	/**
	 * Test du calcule de la moyenne en math du groupe
	 */
	@Test
	public void testMoyenneMatiere() {
		g.ajouterEtudiant(e1);g.ajouterEtudiant(e2);g.ajouterEtudiant(e3);g.ajouterEtudiant(e5);
		assertEquals(14,g.calculerMoyGroupe("Math"),0);
	}
	
	
	/**
	 * Test de la moyenne general de tous les étudiants
	 */
	@Test
	public void testMoyenneTotal() {
		g.ajouterEtudiant(e1);g.ajouterEtudiant(e2);g.ajouterEtudiant(e3);g.ajouterEtudiant(e5);
		assertEquals(14.3,g.calculerMoyGenGroupe(),1);
	}
	
	/**
	 * Test des methodes de trie
	 */
	@Test 
	public void testTri() {
		g.ajouterEtudiant(e1);g.ajouterEtudiant(e2);g.ajouterEtudiant(e3);g.ajouterEtudiant(e5);
		System.out.println(g.getGroupe());
		g.triAlpha();
		System.out.println(g.getGroupe());
		assertEquals("Il devrait y a voir dupont en 1er","03",g.getGroupe().get(0).getNip());
		assertEquals("Il devrait y a voir Moreliere en dernier","01",g.getGroupe().get(3).getNip());
		e3.ajouterNote(0, "Sport");
		e2.ajouterNote(20, "Sport");
		e2.ajouterNote(20, "Math");
		g.triParMerite();
		assertEquals("Il devrait y a voir Gauchotte en 1er","02",g.getGroupe().get(0).getNip());
		assertEquals("Il devrait y a voir Dupont en dernier","03",g.getGroupe().get(3).getNip());
	}
	
	
	

}
