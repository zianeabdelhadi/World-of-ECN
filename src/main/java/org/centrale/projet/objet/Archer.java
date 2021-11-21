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
public class Archer extends Personnage implements Combattant{
    
    /**
     *  
     * @param nom nom de l'archer
     * @param ptPar points de parade 
     * @param ptMana points de magie
     * @param pourcentageMag pourcentage de magie
     * @param pourcenatageResistMag pourcentage de résistence à la magie
     * @param degMag dégâts magiques
     * @param distAttMax distance d'attaque maximale
     * @param ptVie point de vie
     * @param pourcentageAtt pourcentage d'attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt dégâts d'attaque
     * @param posEl position de l'archer
     */
    public Archer(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
        
        }

    public Archer(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, Point2D posEl) {
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, posEl);
    }
    
    public Archer(){
        super();
    }
    
    public Archer(Archer A){
        super(A);
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
     * Cette méthode permet de lancer un combat entre l'archer et une créature
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
        
        if( dist > 1 && dist < this.getDistAttMax()){
            
            
            
            System.out.println("Combat à distance est lancée !!");
            
            int rand=generateurAleatoire.nextInt(100);
            
            if(rand > this.getPourcentageAtt()){
                attaque="ratée";
            }
            
            else{
                attaque="reussie";
                degat_subi = this.getDegAtt();
            }
            
        }
        
        
        if(dist >= 1 && dist < this.getDistAttMax()){
            System.out.println("Combat magique est lancée !!");
            this.setPtMana(this.getPtMana() - 1);
            int rand=generateurAleatoire.nextInt(100);
            if(rand > this.getPourcentageAtt()){
                attaque="ratée";
                }
            
            else{
                attaque="reussie";
                degat_subi = this.getDegMag();
                }
            }
        /*
        else{
            
            System.out.println("Aucun combat n'a été lancée !!");
        }*/
        return degat_subi;
        
        }

    }

    

