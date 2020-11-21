package bss.inr.poo.dev;

import java.util.Scanner;

public class Profil {
//attributs
	String nom;
	String prenom;
	Date dateNaissance;
	long numTeleph;
	AdresseMail adresse;
	String motPass;
	String qstSecrete;
	String repQst;
	
//M�thodes
	//constructeur avec param�tres
    public	Profil(String nom,String prenom,Date  date,long num,AdresseMail adresse,String mot,String qst,String rep) {
    	this.nom=nom;
    	this.prenom=prenom;
    	this.dateNaissance=date;
    	this.numTeleph=num;
    	this.adresse=adresse;
    	this.motPass=mot;
    	this.qstSecrete=qst;
    	this.repQst=rep;
    }
    //constructeur sans param�tres
    public Profil() {
    	
    }
    
    //afficher
    public void afficher() {
    	
    	System.out.println("Nom de profil : "+ this.nom);
    	System.out.println("Prenom de profil : "+ this.prenom);
    	System.out.print("Date de naissance : ");
    	this.dateNaissance.afficher();
    	System.out.println("Num�ro de t�l�phone de profil : "+ this.numTeleph);
    	System.out.print("Adresse mail de profil  : ");
    	this.adresse.afficher();
    	
    }
    
    //changer Mot De Passe
    public void changerMotDePasse(String mot){
    	this.motPass=mot;
    }
    
    //changer Question secrt�te ==> changemment de r�pense 
    public void changerQst(String qst,String rep) {
    	this.qstSecrete=qst;
    	this.repQst=rep;
    }
    
    //saisir
    public void saisir() {
    	Scanner scn=new Scanner(System.in);
    	
    	System.out.print("Saisir votre nom : ");
    	this.nom=scn.nextLine();
    	System.out.print("Saisir votre prenom : ");
    	this.prenom=scn.nextLine();
    	System.out.println("Saisir votre date de naissance : ");
    	this.dateNaissance.saisir();
    	System.out.println("Saisir votre adresse mail : ");
    	this.adresse.saisir();
    	System.out.print("Saisir votre num�ro de t�l�phone : ");
    	this.numTeleph=scn.nextLong();
    	scn.nextLine();
    	System.out.print("Cr�er votre mot de passe : ");
    	this.motPass=scn.nextLine();
    	System.out.println("Introduire la question secr�te que vous d�sirez afin de vous identifi� lors de changemment fe mot de passe : ");
    	this.qstSecrete=scn.nextLine();
    	System.out.println("Veillez maintenant saisir la r�pense de la question secr�te : ");
    	this.repQst=scn.nextLine();
    	
    	scn.close();
    }
    
}
