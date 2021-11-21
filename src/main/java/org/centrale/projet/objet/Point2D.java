/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Groupe 14
 */
public class Point2D {
    
    private int x;
    private int y;

    public Point2D() {
        this.x=0;
        this.y=0;
    }
    
    /**
     * 
     * @param x coordonnée x
     * @param y coordonnée y
     */
    
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Point2D(Point2D p){
        x=p.x;
        y=p.y;
    }
    
    @Override
    public String toString() {
        return "X = " + this.x + ";" + " Y = " + this.y  ;
    }
    
    /**
     * @affiche Les coordonnées x et y
     */
    public void affiche(){
        System.out.println("les cordonnées de cet objet sont :["+x+";"+y+"]");
    }
    
    /**
     * 
     * @param dx valeur de translation suivant x
     * @param dy aleur de translation suivant x 
     */
    public void translater(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    
    }
    
    /**
     * Cette méthode change les coordonnées x et y
     * @param a nouvelle coordonnée x
     * @param b nouvelle coordonnée y
     */
    
    public void setposition(int a, int b){
        this.x=a;
        this.y=b;
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @param p un point quelconque
     * @return la distance 
     */
        
    public float distance(Point2D p){
        float dis = (float) Math.sqrt(((this.x-p.getX())*(this.x-p.getX()))+((this.y-p.getY())*(this.y-p.getY())));
        
        return dis ;
    }
    
}
