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
public class Lapin extends Monstre{
    
    /**
     * 
     * @param ptPar points de parade
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage d’attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt points de dégâts d’attaque
     * @param posEl la position du lapin 
     */

    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
    }

    public Lapin(Point2D posEl) {
        super(posEl);
    }
    
    public Lapin() {
        super();
    }

    public Lapin(Lapin l) {
        super(l);
    }

    @Override
    public Point2D getPosEl() {
        return posEl;
    }

    @Override
    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }
    /**
     * cette méthode permet d'afficher le lapin
     * @return une chaine de caractères des paramètres de lapin
     */
    @Override
    public String toString() {
        return "Ce Lapin se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"Dégât d'attaque : "+ super.getDegAtt()+"\n" 
                +"Points de parade : "+ super.getPtPar()+"\n" 
                +"Points de vie  : "+ super.getPtVie()+"\n" 
                +"Pourcentage d'attaque : "+ super.getPourcentageAtt()+"\n" 
                +"Pourcentage de parade : "+ super.getPourcentagePar()+"\n" ;
    }
    
}
