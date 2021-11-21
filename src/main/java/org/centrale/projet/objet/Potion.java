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
public class Potion extends Objet{
    
    private int nbrPotion ;
       
    /**
     * 
     * @param nbrPotion le nombre de points a ajouter 
     * @param posEl la position de la potion 
     */
    public Potion(int nbrPotion, Point2D posEl) {
        super(posEl);
        this.nbrPotion = nbrPotion;
    }
    
    public Potion() {
        super();
        this.nbrPotion=10;
    }

    public Potion(Potion p) {
        super(p);
        this.nbrPotion=p.nbrPotion;
    }

    public int getNbrPotion() {
        return nbrPotion;
    }

    public void setNbrPotion(int nbrPotion) {
        this.nbrPotion = nbrPotion;
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
        return "Potion : " + this.getLine();
    }
    
    /**
     *
     * @return une linge contenant toutes les informations sur la potion
     */
    @Override
    public String getLine() {
        String line = "";
        line +=  this.nbrPotion + " " 
                + super.getPosEl().getX() + " " 
                + super.getPosEl().getY();
        return line;
    }
    
    /**
     * Cette méthode permet de découper une ligne de paramètres et puis initialiser les attributs de cette 
     * classe par les paramètres retenues
     * @param ligne contient une chaine de caractères qui représente les paramètres de notre 
     * élément du jeu potion
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
            this.setNbrPotion(list_params.get(0));
            Point2D point=new Point2D(list_params.get(1),list_params.get(2));
            this.setPosEl(point);
            System.out.print(this);
    
    }
      
}
