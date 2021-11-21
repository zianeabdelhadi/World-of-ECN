
package org.centrale.projet.objet;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cette classe permet de charger une partie déja existante
 * @author Groupe 14
 */
public class ChargementPartie {
    
    private int largeur;
    private int longueur;
    Joueur player;
    LinkedList<ElementDeJeu> listEleJeu = new LinkedList<>();
    
    String nomFichier ;
    BufferedReader buffread=null ;
    

    public ChargementPartie(String nomFichier) {
        this.nomFichier = nomFichier;
        System.out.print("Start chargement");
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public Joueur getPlayer() {
        return player;
    }

    public void setPlayer(Joueur player) {
        this.player = player;
    }

    public LinkedList<ElementDeJeu> getListEleJeu() {
        return listEleJeu;
    }

    public void setListEleJeu(LinkedList<ElementDeJeu> listEleJeu) {
        this.listEleJeu = listEleJeu;
    }
    
    
/*
    ChargementPartie(String nomfich) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    /**
     * Cette méthode permet de retourner un élément de jeu à partir d'une ligne de paramètres
     * @param ligne contient les paramètres de l'élément du jeu
     * @return un élément de jeu
     */
    public ElementDeJeu creerElementJeu(String ligne){
        String delimiteurs = " ,.;";   
            // on declare un 'tokenizer' qui va decouper 
            // 'line' en fonction de l'ensemble des delimiteurs
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);  
            // Parcours de l'ensemble des unites lexicales de 'ligne'
            // hasMoreTokens() retourne 'vrai' tant qu'il reste des 'mots'
            // dans 'ligne' separes par un des delimiteurs (espace, 
            // virgule, etc.) declares plus haut
        //on récupère le nom du classe qui représente le premier mot de la ligne
        String nomClass = tokenizer.nextToken(); 
        //on crée une liste des éléments de jeu
        ArrayList<ElementDeJeu> list_Eljeu = new ArrayList<>();
        
        ElementDeJeu archer = new Archer();
        list_Eljeu.add(archer) ;
        ElementDeJeu guerrier = new Guerrier();
        list_Eljeu.add(guerrier) ;
        ElementDeJeu mage = new Mage();
        list_Eljeu.add(mage) ;
        ElementDeJeu paysan = new Paysan();
        list_Eljeu.add(paysan) ;
        ElementDeJeu lapin = new Lapin();
        list_Eljeu.add(lapin) ;
        ElementDeJeu loup = new Loup();
        list_Eljeu.add(loup) ;
        ElementDeJeu nuageToxique = new NuageToxique();
        list_Eljeu.add(nuageToxique) ;
        ElementDeJeu soin = new Soin();
        list_Eljeu.add(soin) ;
        ElementDeJeu mana = new Mana();
        list_Eljeu.add(mana) ; 
        ElementDeJeu nourriture = new Nourriture();
        list_Eljeu.add(nourriture) ;
        //on crée une liste des noms des éléments de jeu
        String[] elejeu = {"Archer", "Guerrier", "Mage", "Paysan","Lapin","Loup","NuageToxique","Soin","Mana","Nourriture"};
        
        int index = 0 ;
        boolean find = false ;  
        
        while (find == false && index < elejeu.length) {
        
            if (elejeu[index].equals(nomClass) ) {
                
                find = true ; 
            
            }
            else {
            index += 1 ;
            
            }
        }
        //on fait appel au méthode setLine pour charger les informations qui se trouve
        //dans la ligne aux paramètres de l'objet 
        list_Eljeu.get(index).setLine(ligne);
        
        return  list_Eljeu.get(index);
    }
    
    /**
     * cette méthode permet de retourner un objet de type World
     * contenant l'ensemble des éléments de jeu qui étaient sauvegardés dans le
     * fichier texte 
     * @return  un objet de type World
     */
    public void chargerPartie() throws Exception{
        System.out.print("Start chargerPartie()");
        //World newWorld = new World();
      try {
        String ligne ;
        this.buffread = new BufferedReader(new FileReader(this.nomFichier));
        String delimiteurs = " ,.;";   
        ligne = this.buffread.readLine();  
        //String nomClass = tokenizer.nextToken();
        while(ligne !=null){
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
        String nomClass = tokenizer.nextToken();
        switch (nomClass){
                case "Joueur": {
                    //Joueur jou = new Joueur();
                    ArrayList<Personnage> list_personnage = new ArrayList<>();
                    Personnage archer = new Archer();
                    list_personnage.add(archer) ;
                    Personnage guerrier = new Guerrier();
                    list_personnage.add(guerrier) ;
                    Personnage mage = new Mage();
                    list_personnage.add(mage) ;
                    Personnage paysan = new Paysan();
                    list_personnage.add(paysan) ;
                    String nomClass2 = tokenizer.nextToken();
                    String[] personnage = {"Archer", "Guerrier", "Mage", "Paysan"};
                    int index = 0 ;
                    boolean find = false ;
                    while (find == false ) {

                        if (personnage[index].equals(nomClass2) ) {
                            
                            find = true ;
                            
                        }
                        else {
                            index += 1 ;
                            
                        }
                    }
                    Joueur joueu = new Joueur(list_personnage.get(index));
                    System.out.print(joueu.personne);
                    String newligne=ligne.replace("Joueur ","");
                    joueu.personne.setLine(newligne);
                    this.setPlayer(joueu);
                    //newWorld.setPlayer(joueu);
                }
                break;
                case "Largeur":{
                    int p=Integer.parseInt(tokenizer.nextToken());
                    System.out.print(p);
                    this.largeur = p;
                    //newWorld.setLargeur(p);
                }
                break;
                case "Hauteur":{
                    int p=Integer.parseInt(tokenizer.nextToken());
                    System.out.print(p);
                    this.longueur = p ;
                    //newWorld.setLongueur(p);
                }
                break;
                default : {
                    ElementDeJeu elmt = creerElementJeu(ligne);
                    this.listEleJeu.add(elmt);
                }
                break;
        }
          ligne = this.buffread.readLine();
        }
        
        
        //newWorld.setListEleJeu(listEleJeu);
        this.buffread.close();
      } catch (IOException | NumberFormatException e) {
    }
      
       //return newWorld ;
    }
}
    

