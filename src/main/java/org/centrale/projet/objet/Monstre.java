/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.*;
/*import java.util.logging.Logger;*/

/**
 *
 * @author Groupe 14
 */
public abstract class Monstre extends Creature{
    
    /**
     * @param ptPar points de parade
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage d’attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt points de dégâts d’attaque
     * @param posEl la position 
     */

    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl){
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, posEl);
    }  

    
    public Monstre(Point2D posEl) {
        super(posEl);
    }
    
    public Monstre() {
        super();
    }

    public Monstre(Monstre m) {
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
        return "Monstre " + this.getLine();
    }
   
    /**
     *cette méthode permet d'afficher la position du monstre
     */
    public void affiche() {
        System.out.println("les cordonnées de ce monstre sont :["+this.posEl.getX()+";"+this.posEl.getY()+"]");
    }  

    /**
     * 
     * @return une linge contenant toute les informations sur le monstre
     */
    
    @Override
    public String getLine(){
    
        String line = "";
        line +=   super.getPtVie()+" "
                + super.getPourcentageAtt()+" " 
                + super.getPourcentagePar()+ " "
                + super.getDegAtt()+" " 
                + super.getPtPar()+" " 
                + super.getPosEl().getX() + " " 
                + super.getPosEl().getY();
        
        return line;
    }
    
    /**
     * Cette méthode permet de découper une ligne de paramètres et puis initialiser les attributs de cette 
     * classe par les paramètres retenues
     * @param ligne contient une chaine de caractères qui représente les paramètres de 
     * notre élément de jeu monstre
     */
    
    @Override
    public void setLine(String ligne){
        ArrayList<Integer> list_params = new ArrayList<>();
       
            String delimiteurs = " ,.;";   
            // on declare un 'tokenizer' qui va decouper 
            // 'line' en fonction de l'ensemble des delimiteurs
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);  
            // Parcours de l'ensemble des unites lexicales de 'ligne'
            // hasMoreTokens() retourne 'vrai' tant qu'il reste des 'mots'
            // dans 'ligne' separes par un des delimiteurs (espace, 
            // virgule, etc.) declares plus haut
            String mot1 = tokenizer.nextToken();
            while(tokenizer.hasMoreTokens()) {
                // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
                int para =Integer.parseInt(tokenizer.nextToken());
                list_params.add(para);
            } 
            this.setPtVie(list_params.get(0));
            this.setPourcentageAtt(list_params.get(1));
            this.setPourcentagePar(list_params.get(2));
            this.setDegAtt(list_params.get(3));
            this.setPtPar(list_params.get(4));
            Point2D point=new Point2D(list_params.get(5),list_params.get(6));
            this.setPosEl(point);
            
    }
}
