package Test;

import static org.junit.Assert.*;

import org.junit.*;

import progs3_gauchotte_moreliere.Etudiant;
import progs3_gauchotte_moreliere.Formation;
import progs3_gauchotte_moreliere.Groupe2;

public class TestGroupe2 {
	Groupe2 g;
	Formation f,f2;

	@Before
	public void setUp() throws Exception {
		g = new Groupe2(1);
		f = new Formation(1);
		f2 = new Formation(2);
		f.ajouterMatiere("Mathématiques", 5);
		f.ajouterMatiere("Français", 3);
	}

	@Test
	public void testConstructeur() {
		assertEquals("La liste d'etudiants devrait etre initialisee", 0, g.getGroupe().size());
		assertEquals("La formation devrait etre initialisee avec un id de 1", 1, g.getFormation().getId());
	}
	
	
	@Test
	public void testAjouterEtudiant() {
		Formation f = new Formation(1);
		Formation f2 = new Formation(2);
		g.ajouterEtudiant(new Etudiant("1257PN", "Durand", "Francois", f));
		
		assertEquals("La liste d'etudiants devrait contenir un etudiant", 1, g.getGroupe().size());
		assertEquals("L'etudiant dans le groupe devrait s'appeler 'Francois'", "Francois", g.getGroupe().get(0).getPrenom());
		assertEquals("Le nom de l'etudiant dans le groupe devrait etre 'Durand'", "Durand", g.getGroupe().get(0).getNom());
		assertEquals("Le nip de l'etudiant dans le groupe devrait etre '1257PN'", "1257PN", g.getGroupe().get(0).getNip());
		
		g.ajouterEtudiant(new Etudiant("1579GH", "Marc", "Dupont", f2));
		
		assertEquals("La liste d'etudiants devrait toujours contenir un etudiant", 1, g.getGroupe().size());
	}
	
	
	@Test
	public void testSupprimerEtudiant() {
		Etudiant e = new Etudiant("1257PN", "Durand", "Francois", f);
		g.ajouterEtudiant(e);
		g.ajouterEtudiant(new Etudiant("1579GH", "Dupont", "Marc", f));
		assertEquals("La liste d'etudiants devrait contenir 2 etudiants", 2, g.getGroupe().size());
		
		g.supprimerEtudiant(e);
		
		assertEquals("La liste d'etudiants devrait contenir 1 etudiant (1 supprime)", 1, g.getGroupe().size());
		assertEquals("L'etudiant restant dans le groupe devrait s'appeler 'Marc'", "Marc", g.getGroupe().get(0).getPrenom());
		assertEquals("Le nom de l'etudiant restant dans le groupe devrait etre 'Dupont'", "Dupont", g.getGroupe().get(0).getNom());
		assertEquals("Le nip de l'etudiant restant dans le groupe devrait etre '1579GH'", "1579GH", g.getGroupe().get(0).getNip());
		
		g.supprimerEtudiant(new Etudiant("1579GH", "Dupont", "Marc", f));
		
		assertEquals("La liste d'etudiants devrait etre vide", 0, g.getGroupe().size());
	}
	
	@Test
	public void testCalculerMoyEtGenGroupe() {
		Etudiant e1 = new Etudiant("1257PN", "Durand", "Francois", f);
		e1.ajouterNote(15, "Mathématiques");
		e1.ajouterNote(13, "Mathématiques");
		e1.ajouterNote(12, "Français");
		
		Etudiant e2 = new Etudiant("1579GH", "Dupont", "Marc", f);
		e2.ajouterNote(17, "Mathématiques");
		e2.ajouterNote(20, "Mathématiques");
		e2.ajouterNote(16, "Français");
		
		g.setFormation(e1.getFormation());
		g.ajouterEtudiant(e1);
		g.ajouterEtudiant(e2);
		
		assertEquals("La moyenne du groupe devrait etre de 16.25 en Mathématiques", 16.25, g.calculerMoyGroupe("Mathématiques"), 2);
		assertEquals("La moyenne du groupe devrait etre de 14 en Français", 14.0, g.calculerMoyGroupe("Français"), 2);
		assertEquals("La moyenne du generale du groupe devrait etre de 15.41", 15.41, g.calculerMoyGenGroupe(), 2);
	}
	
	
	@Test
	public void testTriAlpha_ParMerite() {
		Etudiant e1 = new Etudiant("1257PN", "Durand", "Francois", f);
		e1.ajouterNote(15, "Mathématiques");
		e1.ajouterNote(13, "Mathématiques");
		e1.ajouterNote(12, "Français");
		
		Etudiant e2 = new Etudiant("1579GH", "Dupont", "Marc", f);
		e2.ajouterNote(17, "Mathématiques");
		e2.ajouterNote(20, "Mathématiques");
		e2.ajouterNote(16, "Français");
		
		Etudiant e3 = new Etudiant("1580DT", "Dupond", "Louis", f);
		e3.ajouterNote(14, "Mathématiques");
		e3.ajouterNote(12, "Mathématiques");
		e3.ajouterNote(18, "Français");
		
		Etudiant e4 = new Etudiant("1664PM", "Dupont", "Jean", f);
		e4.ajouterNote(9, "Mathématiques");
		e4.ajouterNote(11, "Mathématiques");
		e4.ajouterNote(13, "Français");
		
		g.setFormation(e1.getFormation());
		g.ajouterEtudiant(e1);
		g.ajouterEtudiant(e2);
		g.ajouterEtudiant(e3);
		g.ajouterEtudiant(e4);
		
		System.out.println(g.getGroupe());
		g.triAlpha();
		System.out.println(g.getGroupe());
		g.triParMerite();
		System.out.println(g.getGroupe());
	}
}
