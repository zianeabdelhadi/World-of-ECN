/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

// Dans un fichier RandomInteger.java
/**
 * 
 * @author Groupe 14
 */
public abstract class Personnage extends Creature{
    private String nom;
    private int ptMana;
    private int pourcentageMag;
    private int pourcenatageResistMag;
    private int degMag;
    private int distAttMax;
    List<Nourriture> listNourriture= new ArrayList<>();
    
    /**
     * 
     * @param ptPar points de parade
     * @param nom le nom du personnage
     * @param ptVie points de vie
     * @param ptMana points de magie
     * @param pourcentageAtt pourcentage d'attaque
     * @param pourcentagePar poucentage de parade
     * @param pourcentageMag pourcentage de magie 
     * @param pourcenatageResistMag poucentage de résistance à la magie
     * @param degAtt points de dégâts d’attaque
     * @param degMag points de dégâts magiques
     * @param distAttMax distance d'attaque maximum
     * @param posEl la position du personnage 
     */

    
    public Personnage(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
    
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
        this.nom = nom;
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcenatageResistMag = pourcenatageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
    }

    
    public Personnage(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, Point2D posEl) {
        super(posEl);
        this.nom = nom;
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcenatageResistMag = pourcenatageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
    }
    
    Random rand = new Random();
    
    public Personnage(){
        super();
        this.nom ="nouveau";
        this.ptMana = rand.nextInt(6)+5;
        this.pourcentageMag = rand.nextInt(41)+40;
        this.pourcenatageResistMag = rand.nextInt(6)+15;
        this.degMag = rand.nextInt(6)+15;
        this.distAttMax = rand.nextInt(2)+3;
    }
    public Personnage(Personnage p){
        super(p);
        this.nom =p.nom;
        this.ptMana = p.ptMana;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcenatageResistMag = p.pourcenatageResistMag;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;     
    }

    public List<Nourriture> getListNourriture() {
        return listNourriture;
    }

    public void setListNourriture(List<Nourriture> listNourriture) {
        this.listNourriture = listNourriture;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcenatageResistMag() {
        return pourcenatageResistMag;
    }

    public void setPourcenatageResistMag(int pourcenatageResistMag) {
        this.pourcenatageResistMag = pourcenatageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    @Override
    public Point2D getPosEl() {
        return posEl;
    }
    
    @Override
    public String toString() {
        return "Personage " + this.nom + "\n" 
                +"position: (" + this.posEl.toString() +")" + "\n" 
                +"Points de Mana : " + this.ptMana +"\n" 
                +"Distance d'attaque maximale : " +  this.distAttMax +"\n" 
                +"Pourcentage de résistance magique : "+  this.pourcenatageResistMag+"\n"
                +"Dégât magique : "+  this.degMag+"\n" 
                +"Pourcentage magique : "+  this.pourcentageMag +"\n" 
                +"Dégât d'attaque : "+ super.getDegAtt()+"\n" 
                +"Points de parade : "+ super.getPtPar()+"\n" 
                +"Points de vie  : "+ super.getPtVie()+"\n" 
                +"Pourcentage d'attaque : "+ super.getPourcentageAtt()+"\n" 
                +"Pourcentage de parade : "+ super.getPourcentagePar()+"\n" ;
    }

    /**
     * 
     * @return une linge contenant toute les informations sur la personne
     */
    @Override
    public String getLine() {
        String line = "";
        line +=   this.nom +" "
                + super.getPtVie()+" "
                + this.ptMana +" " 
                + super.getPourcentageAtt()+" "
                + super.getPourcentagePar()+" "
                + this.pourcentageMag +" "
                + this.pourcenatageResistMag+" "
                + super.getDegAtt()+" "
                + this.degMag+" "
                + this.distAttMax +" " 
                + super.getPtPar()+" " 
                +" " +super.getPosEl().getX()
                + " " + super.getPosEl().getY();
        
        return line;
    }
    
    /**
     * Cette méthode permet de découper une ligne de paramètres et puis initialiser les attributs de l'objet
     * courant par les paramètres retenues
     * @param ligne contient une chaine de caractères qui représente les paramètres de notre 
     * élément du jeu personnage
     */

    @Override
    public void setLine(String ligne){
        ArrayList<Integer> list_params = new ArrayList<>();
            String delimiteurs = " ,.;";   
            // on declare un 'tokenizer' qui va decouper 
            // 'line' en fonction de l'ensemble des delimiteurs
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);  
            // Parcours de l'ensemble des unites lexicales de 'ligne'
            // hasMoreTokens() retourne 'vrai' tant qu'il reste des 'mots'
            // dans 'ligne' separes par un des delimiteurs (espace, 
            // virgule, etc.) declares plus haut
            String mot1 = tokenizer.nextToken();
            String nomperso= tokenizer.nextToken();
            this.setNom(nomperso);
            while(tokenizer.hasMoreTokens()) {
                // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
                int para =Integer.parseInt(tokenizer.nextToken());
                list_params.add(para);
            } 

            this.setPtVie(list_params.get(0));
            this.setPtMana(list_params.get(1));
            this.setPourcentageAtt(list_params.get(2));
            this.setPourcentagePar(list_params.get(3));
            this.setPourcentageMag(list_params.get(4));
            this.setPourcenatageResistMag(list_params.get(5));
            this.setDegAtt(list_params.get(6));
            this.setDegMag(list_params.get(7));
            this.setDistAttMax(list_params.get(8));
            this.setPtPar(list_params.get(9));
            Point2D point=new Point2D(list_params.get(10),list_params.get(11));
            this.setPosEl(point);
            
    
    }
    
    
}
