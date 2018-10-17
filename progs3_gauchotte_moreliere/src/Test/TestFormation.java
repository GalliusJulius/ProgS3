package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import progs3_gauchotte_moreliere.Formation;

/**
 * Classe de test de formation 
 * @author moreliere & Gauchotte
 *
 */
public class TestFormation {
	/**
	 * Formation utilise dans les tets
	 */
	Formation f;
	
	/**
	 * Initialisation des variables
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		f = new Formation(1);
	}

	/**
	 * Test du constructeur et des getteurs
	 */
	@Test
	public void testConstructeur() {
		assertEquals("La liste de matiere devrait etre initialise", 0, f.getMatiere().size());
		assertEquals("L'id de formation devrait etre 1", 1, f.getId());
	}
	
	/**
	 * Test de l'ajout de matieres dans la formation
	 */
	@Test
	public void testAjouterMatiere() {
		f.ajouterMatiere("Mathématiques", 5);
		f.ajouterMatiere("Français", 3);
		f.ajouterMatiere("Mathématiques", 3);
		
		assertEquals("La liste de matiere devrait contenir 2 éléments", 2, f.getMatiere().size());
		assertTrue("La liste de matiere devrait contenir les mathématiques", f.getMatiere().containsKey("Mathématiques"));
		assertTrue("La liste de matiere devrait contenir le français", f.getMatiere().containsKey("Français"));
		assertEquals("La liste de matiere devrait contenir le coeff de 3 pour les mathématiques", 3, f.getMatiere().get("Mathématiques"), 5);
		assertEquals("La liste de matiere devrait contenir le coeff de 3 pour le français", 3, f.getMatiere().get("Français"), 5);
	}
	
	/**
	 * Test de la suppression de matieres dans la formation
	 */
	@Test
	public void testSupprimerMatiere() {
		f.ajouterMatiere("Français", 3);
		f.ajouterMatiere("Mathématiques", 3);
		f.supprimerMatiere("Maths");
		
		assertEquals("La liste de matiere devrait contenir 2 éléments", 2, f.getMatiere().size());
		assertTrue("La liste de matiere devrait contenir les mathématiques", f.getMatiere().containsKey("Mathématiques"));
		assertTrue("La liste de matiere devrait contenir le français", f.getMatiere().containsKey("Français"));
		
		f.supprimerMatiere("Français");
		
		assertEquals("La liste de matiere devrait contenir 1 élément", 1, f.getMatiere().size());
		assertTrue("La liste de matiere devrait contenir les mathématiques", f.getMatiere().containsKey("Mathématiques"));
		assertFalse("La liste de matiere ne devrait pas contenir le français", f.getMatiere().containsKey("Français"));
		
		f.supprimerMatiere("Mathématiques");
		
		assertEquals("La liste de matiere devrait contenir 0 élément", 0, f.getMatiere().size());
		assertFalse("La liste de matiere ne devrait pas contenir les mathématiques", f.getMatiere().containsKey("Mathématiques"));
		assertFalse("La liste de matiere ne devrait pas contenir le français", f.getMatiere().containsKey("Français"));
	}
	
	/**
	 * Test de l'obtention du coefficient avec le nom de la matiere
	 */
	@Test
	public void testGetterCoefficient() {
		f.ajouterMatiere("Français", 3);
		f.ajouterMatiere("Mathématiques", 5);
		
		assertEquals("Le coefficient de la matiere devrait etre de 3", 3, f.getCoefficient("Français"), 5);
		assertEquals("Le coefficient de la matiere devrait etre de 5", 5, f.getCoefficient("Mathématiques"), 5);
		assertEquals("Le coefficient de la matiere devrait etre de 5", 0, f.getCoefficient("Maths"), 5);
	}

}
