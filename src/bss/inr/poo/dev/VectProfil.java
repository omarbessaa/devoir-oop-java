package bss.inr.poo.dev;

import java.util.Scanner;

public class VectProfil {
//attributs
	int taille;
	Profil[] vect;
//méthodes
	//constructeur
	public VectProfil (int taille) {
		this.taille=taille;
		vect=new Profil[taille];
	}
	
	//afficher
	public void afficher() {
		for (int i=0;i<this.taille;i++)
		{
			vect[i].afficher();
		}
	}
	
	//existe
	public boolean existe(Profil p) {
		for (int i=0;i<this.taille;i++)
		{
			if (vect[i].adresse.egale(p.adresse)) return true;
		}
		return false;
	}
	
	//remplir
	public void remplir() {
		for (int i=0;i<this.taille;i++)
		{
			vect[i]=new Profil();
			System.out.println("remplissage de profil numéro : "+(i+1));
			vect[i].saisir();
		}
	}
	
	//ajouter
	public VectProfil ajouter(Profil p) {
		
		if (this.existe(p)) {System.out.println("Ce profil existe déjà "); return null;}
		else {
				VectProfil v=new VectProfil(((this.taille)+1));
				int i=0;
						
				for (i=0;i<this.taille;i++)
				{
					v.vect[i]=this.vect[i];
				}
				v.vect[i]=p;
				return v;
		 	}
	}	

//tri
	//tri par date
	public void trierParDate() {
		Profil pTemp=new Profil();
		int fin=this.taille;
		int i=0;
		
		fin--;
		while(fin > 0)
		{
			while(i<fin)
			{
				if (this.vect[i].dateNaissance.comparerA(this.vect[i+1].dateNaissance )== -1) 
				{pTemp=this.vect[i]; this.vect[i]=this.vect[i+1]; this.vect[i+1]=pTemp;}
				i++;
			}
			fin--;
			i=0;
		}
	}
	
	//tri par adresse
	public void trierParAdresse() {
		Profil pTemp=new Profil();
		int fin=this.taille;
		int i=0;
		
		fin--;
		while(fin > 0)
		{
			while(i<fin)
			{
				if (this.vect[i].adresse.comparerA(this.vect[i+1].adresse )== -1) 
				{pTemp=this.vect[i]; this.vect[i]=this.vect[i+1]; this.vect[i+1]=pTemp;}
				i++;
			}
			fin--;
			i=0;
		}
	}
	
	//tri par nom
	public void trierParNom() {
		Profil pTemp=new Profil();
		int fin=this.taille;
		int i=0;
		
		fin--;
		while(fin > 0)
		{
			while(i<fin)
			{
				if (this.vect[i].nom.compareTo(this.vect[i+1].nom) > 0) 
				{pTemp=this.vect[i]; this.vect[i]=this.vect[i+1]; this.vect[i+1]=pTemp;}
				i++;
			}
			fin--;
			i=0;
		}
	}
	
	//supprimer
	public VectProfil supprimer(AdresseMail a) {
		
		VectProfil v=new VectProfil(((this.taille)-1));
		int i=0;
				
		for ( i=0;i<this.taille;i++)
		{
			if (vect[i].adresse.egale(a)) break;
		}
		
		if (i==this.taille) {System.out.println("Ce profil n'existe pas "); return null;}
		else
		{
			while(i<(this.taille-1))
			{
				v.vect[i]=this.vect[i+1];
			}
			
			return v;
		}
		}
	
	//extraire
	//extraire statique
	public static VectProfil extraire(VectProfil v,EnumSite s) {
		
		VectProfil r=new VectProfil(0);
		int i=0;
				
		for (i=0;i<v.taille;i++)
		{
		  if (v.vect[i].adresse.getNomSite().compareTo(s) == 0) {r=r.ajouter(v.vect[i]); v.supprimer(v.vect[i].adresse);}  
		}
		
		return r;
		
	}
	
	//extraire instance
    public VectProfil extraire(EnumSite s) {
		
		VectProfil r=new VectProfil(0);
		int i=0;
				
		for (i=0;i<this.taille;i++)
		{
		  if (this.vect[i].adresse.getNomSite().compareTo(s) == 0) {r=r.ajouter(this.vect[i]); this.supprimer(this.vect[i].adresse);}  
		}
		
		return r;
		
	}
    
    //*************************************************************************
    //Modifier mot de passe
    public void modifierPass(AdresseMail a) {
    	
    	Scanner sc=new Scanner(System.in);
    	int i;
    	
    	for ( i=0;i<this.taille;i++)
		{
			if (vect[i].adresse.egale(a)) break;
		}
		
		if (i==this.taille) System.out.println("Ce profil n'existe pas ");
		else
		{
			System.out.print("\nDonner le nouveau mot de passe : ");
			this.vect[i].changerMotDePasse(sc.nextLine());
			
		}
		sc.close();
    }
    
    //Modifier la question secrète
    public void modifierQst(AdresseMail a) {
    	
    	Scanner sc=new Scanner(System.in);
    	String qst;
    	int i;
    	
    	for ( i=0;i<this.taille;i++)
		{
			if (vect[i].adresse.egale(a)) break;
		}
		
		if (i==this.taille) System.out.println("Ce profil n'existe pas ");
		else
		{
			System.out.print("\nDonner la nouvelle question secrète : ");
			qst=sc.nextLine();
			System.out.print("\nDonner la nouvelle répense de la question secrète : ");
			this.vect[i].changerQst(qst, sc.nextLine());
			
		}
		sc.close();
    	
    }
}
