/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * interface de combat
 * @author Groupe 14
 */
public interface Combattant {
    /**
     * 
     * @param C une créature ou un nuage toxique 
     * @return  le dégât subis par le défenseure
     */
    public int combattre(Creature C);    
}
