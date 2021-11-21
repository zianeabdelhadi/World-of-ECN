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
public class NuageToxique extends Objet implements Combattant, Deplacable {

    int pourcentageAtt;
    int pourcentagePar;
    int degAtt;
    int ptPar ;
    
    /**
     * 
     * @param pourcentageAtt pourcentgage d'attaque
     * @param pourcentagePar pourcentage de parade 
     * @param degAtt points de dégâts d’attaque
     * @param ptPar points de parade
     * @param posEl la position du nuage toxique
     */
    
    
    public NuageToxique(int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D posEl) {
        super(posEl);
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
    }
    
    Random rand = new Random();
    
    public NuageToxique() {
        super();
        this.pourcentageAtt = rand.nextInt(41)+40;
        this.pourcentagePar = rand.nextInt(31)+30;
        this.degAtt = rand.nextInt(6)+15;
        this.ptPar = rand.nextInt(6)+15;
    }
    public NuageToxique(NuageToxique n) {
        super(n);
        this.pourcentageAtt =n.pourcentageAtt;
        this.pourcentagePar = n.pourcentagePar;
        this.degAtt =n.degAtt;
        this.ptPar =n.ptPar;
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

    @Override
    public void setPosEl(Point2D posEl) {
        this.posEl = posEl;
    }
   
    /**
     * 
     * Cette méthode permet de lancer un combat entre le nuage toxique et une créature
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
     * Cette méthode permit de déplacer un élement de jeu sur une case adjacente de la où il se trouve
     * @param a unité de déplacement suivant x
     * @param b unité de déplacement suivant y
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
     * 
     * @return une linge contenant toutes les informations sur le nuage toxique
     */
    
    @Override
    public String getLine(){
        String line = "";
        
        line += this.pourcentageAtt+ " "
                + this.pourcentagePar+ " "
                + this.degAtt + " "  
                + this.ptPar+ " " 
                + super.getPosEl().getX()+ " "
                +super.getPosEl().getY();
        
        return line;
    }
    
 
    @Override
    public String toString() {
        return "Ce NuageToxique se trouve à la position: (" + this.posEl.toString() +")" + "et il a comme paramètres :\n" 
                +"pourcentageAtt: "+this.getPourcentageAtt()+"\n"
                +"pourcentagePar: "+this.getPourcentagePar()+"\n"
                +"degAtt: "+this.getDegAtt()+"\n"
                +"ptPar: "+this.getPtPar()+"\n";
    }
     /**
     * Cette méthode permet de découper une ligne de paramètres et puis initialiser les attributs de cette 
     * classe par les paramètres retenues
     * @param ligne contient une chaine de caractères qui représente les paramètres de notre élément de jeu
     * nuage toxique
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

            this.setPourcentageAtt(list_params.get(0));
            this.setPourcentagePar(list_params.get(1));
            this.setDegAtt(list_params.get(2));
            this.setPtPar(list_params.get(3));
            Point2D point=new Point2D(list_params.get(4),list_params.get(5));
            this.setPosEl(point);
            System.out.print(this);
    
    }
    
}
