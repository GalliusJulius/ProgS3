package ParcoursIterateur;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.*;

public class TestParcours {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int[][] tab = {{6,1},{2,3},{1,2}};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(6);
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(1);
		ls.add(2);
		TableauEntier t = new TableauEntier(tab);
		Parcours ligne = t.iterateurLigne();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(ligne.hasNext()) {
			Integer temp = ligne.next();
			res.add(temp);
		}
		int i =0; boolean juste = true;
		for(Integer val : res) {
			if(val != ls.get(i)) {
				juste=false;
			}
			i++;
		}
		assertTrue("On devrait avoir les deux meme listes",juste);
	}
	
	@Test
	public void testZigZag() {
		int[][] tab = {{6,1},{2,3},{1,2}};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(6);
		ls.add(1);
		ls.add(3);
		ls.add(2);
		ls.add(1);
		ls.add(2);
		TableauEntier t = new TableauEntier(tab);
		Parcours ligne = t.iterateurZigZag();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(ligne.hasNext()) {
			Integer temp = ligne.next();
			res.add(temp);
		}
		int i =0; boolean juste = true;
		for(Integer val : res) {
			if(val != ls.get(i)) {
				juste=false;
			}
			i++;
		}
		assertTrue("On devrait avoir les deux meme listes",juste);
	}
	
	@Test
	public void testColonne() {
		int[][] tab = {{6,1},{2,3},{1,2}};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(6);
		ls.add(2);
		ls.add(1);
		ls.add(1);
		ls.add(3);
		ls.add(2);
		TableauEntier t = new TableauEntier(tab);
		Parcours ligne = t.iterateurColonne();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(ligne.hasNext()) {
			Integer temp = ligne.next();
			res.add(temp);
		}
		int i =0; boolean juste = true;
		for(Integer val : res) {
			if(val != ls.get(i)) {
				juste=false;
			}
			i++;
		}
		assertTrue("On devrait avoir les deux meme listes",juste);
	}
	
	@Test 
	public void testIterable() {
		int[][] tab = {{6,1},{2,3},{1,2}};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ls.add(6);
		ls.add(1);
		ls.add(3);
		ls.add(2);
		ls.add(1);
		ls.add(2);
		TableauEntier t = new TableauEntier(tab);
		ArrayList<Integer> res = new ArrayList<Integer>();
		Iterator ite = t.iterator();
		while(ite.hasNext()) {
			Integer temp = (Integer) ite.next();
			System.out.println(temp);
			res.add(temp);
		}
		int i =0; boolean juste = true;
		for(Integer val : res) {
			if(val != ls.get(i)) {
				juste=false;
			}
			i++;
		}
		assertTrue("On devrait avoir les deux meme listes",juste);
	}

}
