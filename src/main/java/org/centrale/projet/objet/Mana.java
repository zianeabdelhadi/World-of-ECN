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
public class Mana extends Potion{

    /**
     * 
     * @param nbrPotion le nombre de mana à redonner
     * @param posEl la position de la potion mana
     */
    public Mana(int nbrPotion, Point2D posEl) {
        super(nbrPotion, posEl);
    }
    
    public Mana() {
        super();
    }

    public Mana(Mana m) {
        super(m);
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
       
        String text = "Ce mana se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"nbrPotion : "+ super.getNbrPotion()+"\n";
        return text;
    }
    
}
