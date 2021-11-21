/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Groupe 14
 */
public abstract class Objet extends ElementDeJeu {

    
        /**
     * 
     * @param posEl la position de l'objet 
     */
    
    public Objet(Point2D posEl) {
        super(posEl);
    }
    
    public Objet() {
        super();
    }
    public Objet(Objet o) {
        super(o);
    }

    @Override
    public Point2D getPosEl() {
        return posEl;
    }

    @Override
    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }
    
}
