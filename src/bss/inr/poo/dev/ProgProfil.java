package bss.inr.poo.dev;

import java.util.Scanner;

public class ProgProfil {

	public static void main(String[] args) {
	//
		boolean continuer=true;
		int rep;
		Scanner lire=new Scanner(System.in);
		boolean corect=false;
	//	
		VectProfil vect_profil=new VectProfil(0);
		AdresseMail a=new AdresseMail();
		
		
		do {
			menu();
			System.out.print("\nVotre choix :  ");
			rep=lire.nextInt();
			switch(rep) {
			case 1:
				System.out.print("donner la taille de vecteur (nombre de profils) : ");
				vect_profil=new VectProfil(lire.nextInt());
				vect_profil.remplir();
				break;
			case 2:
				Profil p=new Profil();
				System.out.println("\nRemplir les information de profil à ajouter : ");
				p.saisir();
				vect_profil=vect_profil.ajouter(p);
				break;
			case 3:
				vect_profil.afficher();
				break;
			case 4:
				System.out.println("\nDonner l'adresse Mail de profil que vous voullez changer le mot de passe");
				a.saisir();
				vect_profil.modifierPass(a);
				break;
			case 5:
				System.out.println("\nDonner l'adresse Mail de profil que vous voullez changer la question secrète :");
				a.saisir();
				vect_profil.modifierQst(a);
				break;
			case 6:
				System.out.print("Veillez saisir le site : ");
        	    String Site=lire.next();     
        	//verif de nom de site
        	for (EnumSite i : EnumSite.values())
        	{
        		if ( Site.equals(i.toString()) ) {corect=true; break;}; //nom site saisi correct
        	}
        	if (corect) 
        	{
        		VectProfil r=vect_profil.extraire(EnumSite.valueOf(Site));
        		r.afficher();
        	}
        	else System.out.println("nom de site erroné ");
				break;
			case 7: continuer=false;
				break;
				default : System.out.println("\nChoix invalide\n"); 
					break;
					
			}
			
		}while(continuer);
		lire.close();
	}
	
	static void menu() {
		System.out.println("1-Créer vecteur de profils et le remplir  ");
		System.out.println("2-Ajouter profil  ");
		System.out.println("3-Afficher un vecteur de profils  ");
		System.out.println("4-Modifier mot de passe  ");
		System.out.println("5-Modifier question secrète  ");
		System.out.println("6-Extraire vecteur pour un site donné  ");
		System.out.println("7-Quitter  ");
	}

}
