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
public class Paysan extends Personnage {

    
    /**
     * 
     * @param ptPar points de parade
     * @param nom le nom du paysan
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
    
    public Paysan(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl) {
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
    }

    public Paysan(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, Point2D posEl) {
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, posEl);
    }
    
    public Paysan() {
        super();
    }

    public Paysan(Paysan p) {
        super(p);
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
