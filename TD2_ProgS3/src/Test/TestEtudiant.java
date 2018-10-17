package Test;

import static org.junit.Assert.*;
import org.junit.*;

import progs3_gauchotte_moreliere.Etudiant;
import progs3_gauchotte_moreliere.Formation;

/**
 * CLasse peremettant de tester un etudiant
 * @author moreliere & Gauchotte
 *
 */
public class TestEtudiant {
	/**
	 * Etudiant utilise dans les tests
	 */
	private Etudiant e;

	/**
	 * Initialisation des variables 
	 */
	@Before
	public void setup() {
		Formation f = new Formation(1);
		e = new Etudiant("093725","Dupont","Jean",f);
		f.ajouterMatiere("SVT", 2.5);
		f.ajouterMatiere("Math", 6);
		f.ajouterMatiere("Francais", 5);
	}
	
	/**
	 * Test du constructeur d'etudiant et des getteurs
	 */
	@Test
	public void testConstructeur() {
		assertEquals("L'étudiant devrait s'appeller Jean","Jean",e.getPrenom());
		assertEquals("L'étudiant devrait avoir pour nom Dupont","Dupont",e.getNom());
		assertEquals("L'étudiant devrait avoir pour numero nip 093725","093725",e.getNip());
		assertEquals("L'étudiant devrait avoir pour numéro de formation 1",1,e.getIdFomation());
		assertEquals("L'étudiant ne devrait pas avoir de resultats",0,e.getResultats().size());
	}
	
	/**
	 * Test qui verifie que l'ajout de notes est bien fonctionnel 
	 */
	@Test 
	public void testAjoutNote() {
		e.ajouterNote(15, "Math");
		assertEquals("L'étudiant devrait avoir des résultats dans une seule matiere",1,e.getResultats().size());
		e.ajouterNote(19, "Math");
		assertEquals("L'étudiant devrait avoir des résultats dans une seule matiere",1,e.getResultats().size());
		assertEquals("L'étudiant devrait avoir deux notes en Math",2,e.getResultats().get("Math").size());
		e.ajouterNote(19, "SVT");
		assertEquals("L'étudiant devrait avoir des résultats dans deux matieres",2,e.getResultats().size());
		//ne doit pas marcher (sport ne fait pas partie de la formation)
		e.ajouterNote(11, "Sport");
		assertEquals("L'étudiant devrait toujours avoir des résultats dans deux matieres",2,e.getResultats().size());
	}
	
	/**
	 * Methode qui test le calcul de moyenne par matiere
	 */
	@Test
	public void testMoyenneMatiere() {
		e.ajouterNote(15, "Math");
		e.ajouterNote(19, "Math");
		assertEquals(17,e.calculerMoyenne("Math"),2);
	}
	
	/**
	 * Methode qui test le calcul de la moyenne general d'un etudiant
	 */
	@Test 
	public void testMoyenneGeneral() {
		assertEquals(0,e.calculerMoyenneGenerale(),2);
		e.ajouterNote(15, "Math");
		e.ajouterNote(19, "Math");
		e.ajouterNote(19, "SVT");
		e.ajouterNote(11, "Francais");
		assertEquals(15.72,e.calculerMoyenneGenerale(),2);
	}
}
