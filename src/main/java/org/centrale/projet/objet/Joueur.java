/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.util.*;

/**
 * cette classe représente un joueur
 * @author Groupe 14
 */

public final class Joueur {

    Personnage personne ;
    Combattant combat;
    
    /**
     * 
     * @param personne un personnage
     */
    public Joueur(Personnage personne){
        
        this.personne = personne;
           
    }
    
    public Joueur() {
        this.setPersonne(personne);
    }

    public Personnage getPersonne() {
        return personne;
    }

    public void setPersonne(Personnage personne) {
        this.personne = personne;
    }
    /**
     * cette classe permet à l'utilisateur de choisir un personnage et le représente comme joueur
     */
    public void saisir() {
        ArrayList<Personnage> list_personnage = new ArrayList<>();
        
        Personnage archer = new Archer();
        list_personnage.add(archer) ;
        Personnage guerrier = new Guerrier();
        list_personnage.add(guerrier) ;
        Personnage mage = new Mage();
        list_personnage.add(mage) ;
        Personnage paysan = new Paysan();
        list_personnage.add(paysan) ;
        
        String[] personnage = {"Archer", "Guerrier", "Mage", "Paysan"};
        
        Scanner saisiePersonnage = new Scanner(System.in);
        System.out.println("Veuillez saisir votre personnage (Archer, Guerrier ou Mage):");
        String perso = saisiePersonnage.next();
        
        int index = 0 ;
        boolean find = false ;  
        
        while (find == false ) {
        
            if (personnage[index].equals(perso) ) {
                
                find = true ;
                
            }
            else {
                index += 1 ;
                
            }
        }
        
        this.personne = list_personnage.get(index);
       
        Scanner saisienom = new Scanner(System.in);
        System.out.println("Veuillez saisir un nom à votre personnage :");
        String nom = saisienom.next();
        
        Random random = new Random();
  
        this.personne.setDegAtt(random.nextInt(5)+5);
        this.personne.setDegMag(random.nextInt(4)+4);
        this.personne.setDistAttMax(random.nextInt(10)+10);
        this.personne.setNom(nom);
        this.personne.posEl.setX(random.nextInt(50));
        this.personne.posEl.setY(random.nextInt(50));
        this.personne.setPourcenatageResistMag(random.nextInt(35)+35);
        this.personne.setPourcentageAtt(random.nextInt(40)+40);
        this.personne.setPourcentagePar(random.nextInt(40)+40);
        this.personne.setPtMana(random.nextInt(5)+5);
        this.personne.setPtPar(random.nextInt(5)+5);
        this.personne.setPtVie(random.nextInt(5)+5);
        
        
    }
    
    public void choix(Personnage personne, int dx, int dy, Creature ennemie){
        
        Scanner sedeplacer = new Scanner(System.in);
        System.out.println("Voulez vous se déplacer :");
        String rep_deplacer = sedeplacer.next();
        if (rep_deplacer.equals("Oui")) {
            
            personne.deplace(dx, dy);
        }
    
    }
    
    /**
     * cette méthode permet d'afficher le joueur
     */
    public void affiche(){
        System.out.print(this.personne);
    }

}
