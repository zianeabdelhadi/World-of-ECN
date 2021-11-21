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

import java.io.*;
import java.util.*;

public class SauvegardePartie {
    
    
    private String nomFichier;
    BufferedWriter bufferedWriter = null;

    public SauvegardePartie(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    /**
     * cette méthode permet de retourner les lignes descriptives de toutes
     * les éléments de la liste sous forme d'un texte
     * @param liste la liste des éléments de jeu
     * @param w un monde
     * @return les lignes descriptives de toutes les éléments de la liste sous forme d'un texte
     */
    
    public String getTexteSauvegarde(List<ElementDeJeu> liste, World w){
        
        String text = "";
        
            for (ElementDeJeu element : liste) {
                
                if(element.equals(w.player.personne)){
                    
                    String line = element.getLine();
                    String name = element.getClass().getSimpleName();
                    text += "Joueur " + name+" "+line+"\n";
                }
                
                else{
                    
                    String line = element.getLine();
                    String name = element.getClass().getSimpleName();
                    text += name+" "+line+"\n";
                }
            
                
               
            }
        return text;
    }
    /**
     * cette méthode permet de sauvegarder les informations des éléments de jeu
     * sous forme d'un fichier texte
     * @param w un monde
     */
    public void sauvegarderPartie(World w){
        
        String first_ligne = "Largeur "+w.getLargeur()+"\n" + "Hauteur "+w.getLongueur()+"\n";
        
        List liste = w.listEleJeu;
        String text = first_ligne + getTexteSauvegarde(liste, w);
        
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomFichier));
            
            bufferedWriter.write(text);
            
        }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // on ferme le fichier
        finally {
          try {
            if (bufferedWriter != null) {
              // je force l'Ã©criture dans le fichier
              bufferedWriter.flush();
              // puis je le ferme
              bufferedWriter.close();
            }
          }
          // on attrape l'exception potentielle 
          catch (IOException ex) {
            ex.printStackTrace();
          }
        }
    }
}
