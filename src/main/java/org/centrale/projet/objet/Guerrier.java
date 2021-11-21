/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * 
 * @author Groupe 14
 */
public class Guerrier extends Personnage implements Combattant{

    /**
     * @param ptPar points de parade
     * @param nom le nom du guerrier
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
    public Guerrier(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
        }

    public Guerrier(String nom, int ptMana, int pourcentageMag, int pourcenatageResistMag, int degMag, int distAttMax, Point2D posEl) {
        super(nom, ptMana, pourcentageMag, pourcenatageResistMag, degMag, distAttMax, posEl);
    }
    
    public Guerrier(){
        super();
    }
    
    public Guerrier(Guerrier g){
        super(g);
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
     * Cette méthode permet de lancer un combat entre le guerrier et une créature
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
    

