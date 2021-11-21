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
public class Loup extends Monstre implements Combattant{

    /**
     * 
     * @param ptPar points de parade
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage d’attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt points de dégâts d’attaque
     * @param posEl la position du loup 
     */
    
    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
        
    }  

    public Loup(Point2D posEl) {
        super(posEl);
    }
    
    public Loup() {
        super();
    }

    public Loup(Loup l) {
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
     * 
     * Cette méthode permet de lancer un combat entre le loup et une créature
     * @param C une créature ou un nuage toxique
     * @return le dégât subis par le défenseure
     */
    
    @Override
    public int combattre(Creature C) {
        
        int degat_subi = 0;
        
        float dist = this.posEl.distance(C.getPosEl());
        String attaque;
        Random generateurAleatoire = new Random();
        if(dist == 1){
            
            System.out.println("Combat en contact lancé !!");
            
            int rand=generateurAleatoire.nextInt(100);
            
            if( rand > this.getPourcentageAtt()){
                
                attaque = "ratée";
               
            }
            
            else{
                
                attaque="reussie";
                rand=generateurAleatoire.nextInt(100);
                
                if(rand > C.getPourcentagePar()){
                    degat_subi = this.getDegAtt();
                }
                
                else{
                    degat_subi = this.getDegAtt()-C.getPtPar();
                }
            }
            
        }
        /*
        else{
            
            System.out.println("Aucun combat n'a été lancée !!");
        }
        */
        return degat_subi;
        
        }
    /**
     * cette méthode permet d'afficher le lapin
     * @return une chaine de caractères des paramètres de loup
     */
    @Override
    public String toString() {
        return "Ce Loup se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"Dégât d'attaque : "+ super.getDegAtt()+"\n" 
                +"Points de parade : "+ super.getPtPar()+"\n" 
                +"Points de vie  : "+ super.getPtVie()+"\n" 
                +"Pourcentage d'attaque : "+ super.getPourcentageAtt()+"\n" 
                +"Pourcentage de parade : "+ super.getPourcentagePar()+"\n" ;
    }
    
}
