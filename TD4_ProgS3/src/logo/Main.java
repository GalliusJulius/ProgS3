package logo;



public class Main
{
   
    public static void main(String args[])
    {
    	/**
        ReneLaTaupe l = new ReneLaTaupe();
        MyImage i = l.getLogo(); 
        
        i.paintOver("src/img/Chapeau.png", 280,42);
        i.paintOver("src/img/Sunglasses.png", 255,76);
        i.display();  // Permet l'affichage dans une fenetre de l'image associee
        */
    	
    	/**
    	Image i = new Taupe();
    	Image lo = new Text(new Lunette(new Chapeau(i)),"Salut, ceci est un beau logo");
    	lo.getLogo().display();
    	System.out.println(lo.combienCaCoute());
    	Image i2 = new CrazyFrog();
    	Image lo2 = new Lunette(new Chapeau(i2));
    	lo2.getLogo().display();
    	System.out.println(lo2.combienCaCoute());
    	*/
    	
    	Image i =new Taupe();
    	i.getLogo().display();
    }
        
}
