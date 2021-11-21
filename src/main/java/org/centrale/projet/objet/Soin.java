/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Groupe 14
 */
public class Soin extends Potion{

    /**
     * 
     * @param nbrPotion le nombre de points de vie à redonner
     * @param posEl la position de la potion soin
     */
    public Soin(int nbrPotion, Point2D posEl) {
        super(nbrPotion, posEl);
    }
    
    public Soin() {
        super();
    }

    public Soin(Soin s) {
        super(s);
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
        return "Cette soin se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"nbrPotion : "+ super.getNbrPotion()+"\n";
    }
    
}
