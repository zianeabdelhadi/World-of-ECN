/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 *
 * @author Groupe 14
 */
public class Nourriture extends Objet{
    
    private int bonus;
    private int malus;
    private int duree;
    /**
     * 
     * @param bonus le nombre de bonus à donner au personnage
     * @param malus le nombre de malus à donner au personnage
     * @param duree la durée de vie de la nourriture
     * @param posEl la position de nourriture
     */
    public Nourriture(int bonus, int malus, int duree, Point2D posEl) {
        super(posEl);
        this.bonus = bonus;
        this.malus = malus;
        this.duree = duree;
    }

    public Nourriture(int bonus, int malus, int duree) {
        this.bonus = bonus;
        this.malus = malus;
        this.duree = duree;
    }

    public Nourriture(int bonus, int malus, int duree, Objet o) {
        super(o);
        this.bonus = bonus;
        this.malus = malus;
        this.duree = duree;
    }
    
    Random random = new Random();
    
    public Nourriture() {
        super();
        this.bonus = random.nextInt(5)+5;
        this.malus = random.nextInt(5)+5;
        this.duree = random.nextInt(5)+5;
    }
    public Nourriture(Nourriture no) {
        super(no);
        this.bonus = no.bonus;
        this.malus = no.malus;
        this.duree = no.duree;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getMalus() {
        return malus;
    }

    public void setMalus(int malus) {
        this.malus = malus;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public Point2D getPosEl() {
        return posEl;
    }

    @Override
    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }
    
    @Override
    public String toString() {
        return "Cette nourriture se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"Durée : "+this.duree+" , Bonus : "+this.bonus+" , Malus : "+this.malus+"\n";
    }
    
    
    /**
     *
     * @return une linge contenant toutes les informations sur la nourriture
     */
    @Override
    public String getLine() {
        String line = "";
        line +=  this.bonus + " "
                +this.malus + " "
                +this.duree + " "
                + super.getPosEl().getX() + " " 
                + super.getPosEl().getY();
        
        return line;
    }
     /**
      *Cette méthode permet de découper une ligne de paramètres et puis initialiser les attributs de cette 
     * classe par les paramètres retenues
     * @param ligne contient une chaine de caractères qui représente les paramètres de 
     * notre élément de jeu nourriture 
      */
    @Override
    public void setLine(String ligne){
            ArrayList<Integer> list_params = new ArrayList<>();
            String delimiteurs = " ,.;";   
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);  
            String mot1 = tokenizer.nextToken();
            while(tokenizer.hasMoreTokens()) {
                // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
                int para =Integer.parseInt(tokenizer.nextToken());
                list_params.add(para);
            }
            
            this.setBonus(list_params.get(0));
            this.setMalus(list_params.get(1));
            this.setDuree(list_params.get(2));
            Point2D point=new Point2D(list_params.get(3),list_params.get(4));
            this.setPosEl(point);
            
}
 
    
}
