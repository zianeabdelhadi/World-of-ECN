/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 * cette englobe les personnages et les monstres
 * @author Groupe 14
 */
public abstract class Creature extends ElementDeJeu implements Deplacable{
    private int ptVie;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private int ptPar ;
    
    /**
     * 
     * @param ptPar points de parade
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage d’attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt points de dégâts d’attaque
     * @param posEl le position 
     */
    


    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
        super(posEl);
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
    }

    public Creature(Point2D posEl) {
        super(posEl);
    }
    
    Random rand = new Random();
    
    public Creature(){
        super();
        this.ptVie = rand.nextInt(6)+5;
        this.pourcentageAtt = rand.nextInt(41)+40;
        this.pourcentagePar = rand.nextInt(31)+30;
        this.degAtt = rand.nextInt(6)+15;
        this.ptPar = rand.nextInt(6)+15;
    }
    public Creature(Creature c){
        super(c);
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    @Override
    public Point2D getPosEl() {
        return posEl;
    }
    
    public boolean setPosEl(Point2D posEl, World world) {
        if(world.freePosition(posEl)) { 
            this.posEl = posEl;
            if(this instanceof Personnage) {
                Personnage pr=(Personnage) this;
                world.consommePosition(pr);
            }
            return true;
        }
        return false;
    }

    /**
     * cette méthode ermet de changer la position de la créature sans vérifier dans le monde
     * s'il y a déjà une créature à cette position
     * @param posEl position d'arrivée de la créature
     */
    @Override
    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }

    /**
     * Cette méthode permet de déplacer un élement de jeu sur une case adjacente de la où il se trouve
     * sans vérifier dans le monde si la case adjacente est libre
     * @param a unité de déplacement suivant x
     * @param b unité de déplacement suivant y
     * @return true si le déplacement est bien fait, false sinon
     */
    
    @Override
    public boolean deplace(int a, int b) {
        if(Math.abs(a)>1 || Math.abs(b)>1) {
            System.out.println("mauvais déplacement");
            return false;
        }
        this.posEl.setX(this.posEl.getX() + a);
        this.posEl.setY(this.posEl.getY() + b);
        return true;
    }
    /**
     * Cette méthode permet de déplacer un élement de jeu sur une case adjacente de la où il se trouve
     * sans vérifier dans le monde si la case adjacente est libre
     * @param a unité de déplacement suivant x
     * @param b unité de déplacement suivant y
     * @param world un monde
     * @return true si le déplacement est bien fait, false sinon
     */
    public boolean deplace(int a, int b, World world) {
        if(Math.abs(a)>1 || Math.abs(b)>1) {
            System.out.println("mauvais déplacement");
            return false;
        }
        return this.setPosEl(new Point2D(this.posEl.getX() + a, this.posEl.getY() + b), world);
    }
    
    
}
