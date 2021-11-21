  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * cette classe représente un élément de jeu
 * @ Groupe 14
 */
public abstract class ElementDeJeu {
    
    protected Point2D posEl;
    
    /**
     * 
     * @param posEl la position de l'élèment de jeu 
     */

    public ElementDeJeu(Point2D posEl) {
        this.posEl = posEl;
    }
    
    public ElementDeJeu() {
        this.posEl = new Point2D();
    }
    public ElementDeJeu(ElementDeJeu ej) {
        this.posEl = new Point2D(ej.posEl);
    }

    public Point2D getPosEl() {
        return posEl;
    }

    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }
    
    public int combattre(Creature C){
        
        return 0;
        
    }
    
    public abstract String getLine();
    public abstract void setLine(String ligne);
   
           
}
    
