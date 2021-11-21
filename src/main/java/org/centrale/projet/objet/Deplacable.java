/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * interface de déplacement
 * @author Groupe 14
 */
public interface Deplacable {
    
    /**
     * 
     * @param dx unité de déplacement suivant x
     * @param dy unité de déplacement suivant y
     */
    public boolean deplace(int dx, int dy);
    
}
