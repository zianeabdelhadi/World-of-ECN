/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * Cette classe représente un monde où il y a plusieurs éléments de jeu  
 * @author Groupe 14
 */
public class World {
    
    private int largeur = 50 ;
    private int longueur = 50 ;
    private int nbr_personne = 1000;
    private int nbr_monstre = 1000;
    private int nbr_objet = 200;
    Joueur player;
    LinkedList<ElementDeJeu> listEleJeu = new LinkedList<>();
    
    /**
     * cette méthode permet de créer un monde 2D des éléments de jeu
     * @param nomSauvegarde représente le nom du ficheir de sauvegarde
     * @throws Exception 
     */
    public World(String nomSauvegarde) throws Exception {
        //S'il n'y a pas de fichier de sauvegarde on crée un monde aléatoire et un joueur
        if(nomSauvegarde == null) {
        this.creeMondeAleaNew();
        this.creationJoueur();
        } 
        
        else {
            //Sinon on charge le monde et le joueur à partir du fichier de sauvegarde
            ChargementPartie ch = new ChargementPartie(nomSauvegarde);
            ch.chargerPartie();
            //World w=ch.chargerPartie();
            this.largeur=ch.getLargeur();
            this.listEleJeu = ch.getListEleJeu();
            this.longueur = ch.getLongueur();
            this.player.setPersonne(ch.player.personne);
            this.mettreDansMonde(this.player.personne);
            
        }
        
        
    }
    /**
     * cette méthode permet d'initialiser les paramètres du monde  
     * @throws Exception 
     */
    public World() throws Exception {
        this.largeur = 40;
        this.longueur = 40;
        this.nbr_personne = 100;
        this.nbr_monstre = 100;
        this.nbr_objet = 1000;
        this.player = new Joueur();
        
        this.creeMondeAleaNew();
        this.creationJoueur();
    }
    /**
     * ce getter permet de retourner le nombre de personnages qui doit être trouver dans le monde
     * @return le nombre de personnages 
     */
    public int getNbr_personne() {
        return nbr_personne;
    }
    /**
     * ce setter permet de modifier le nombre de personnages qui doit être trouverdans le monde
     * @param nbr_personne le nombre de personnages 
     */
    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = nbr_personne;
    }
    /**
     * ce getter permet de retourner le nombre de monstres qui doit être trouver dans le monde
     * @return le nombre de monstres
     */
    public int getNbr_monstre() {
        return nbr_monstre;
    }
    /**
     * ce setter permet de modifier le nombre de monstres qui doit être trouver dans le monde
     * @param nbr_monstre 
     */
    public void setNbr_monstre(int nbr_monstre) {
        this.nbr_monstre = nbr_monstre;
    }
    /**
     * ce getter permet de retourner le nombre d'objets qui doit être trouver dans le monde
     * @return le nombre d'objets
     */
    public int getNbr_objet() {
        return nbr_objet;
    }
    /**
     * ce setter permet de modifier le nombre d'objets qui doit être trouver dans le monde
     * @param nbr_objet le nombre d'objets
     */
    public void setNbr_objet(int nbr_objet) {
        this.nbr_objet = nbr_objet;
    }
    /**
     * ce getter permet de retourner la largeur de notre monde 2D
     * @return la largeur du monde
     */
    public int getLargeur() {
        return largeur;
    }
    /**
     * ce setter permet de modifier la largeur de notre monde 2D
     * @param largeur la largeur du monde
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    /**
     * ce getter permet de retourner la longueur de notre monde 2D
     * @return la longueur du monde
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * ce setter permet de modifier la longueur de notre monde 2D
     * @param longueur la longueur du monde
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
    /**
     * ce getter permet de retourner la liste des éléments de jeu 
     * @return la liste des éléments de jeu 
     */
    public LinkedList<ElementDeJeu> getListEleJeu() {
        return listEleJeu;
    }
    /**
     * ce setter permet de modifier la liste des éléments de jeu 
     * @param listEleJeu la liste des éléments de jeu
     */
    public void setListEleJeu(LinkedList<ElementDeJeu> listEleJeu) {
        this.listEleJeu = listEleJeu;
    }
    /**
     * ce getter permet de retourner le joueur qui se trouve dans notre monde
     * @return le joueur qui se trouve dans notre monde
     */
    public Joueur getPlayer() {
        return player;
    }
    /**
     * ce setter permet de modifier le joueur qui se trouve dans notre monde
     * @param player le joueur qui se trouve dans notre monde
     */
    public void setPlayer(Joueur player) {
        this.player = player;
    }
    /**
     * cette méthode permet de gérer les tours de jeu 
     * @return un boolean qui indique si le joueur veut jouer encore ou non
     */
    public boolean tourDeJeu() {
        boolean quit = false;
        //on parcourt la liste de nourriture du joueur pour diminuer la durée de chaque nourriture par 1
        for(int i=0; i< this.player.personne.listNourriture.size(); i++){
            
            this.player.personne.listNourriture.get(i).setDuree(this.player.personne.listNourriture.get(i).getDuree()-1);
            
            if(this.player.personne.listNourriture.get(i).getDuree() == 0){
                //Si la durée d'une nourriture est 0, on ajoute le malus et on soustraire le bonus
                //du paramètre points de parade du joueur, puis on supprime la nourriture en question
                int bonus = this.player.personne.listNourriture.get(i).getBonus();
                int malus = this.player.personne.listNourriture.get(i).getMalus();

                this.player.personne.setPtPar(this.player.personne.getPtPar() + malus - bonus);
                
                this.player.personne.listNourriture.remove(i);
                
            }
            
            
        }
        
        Random rand = new Random();
        
        Scanner nextAction = new Scanner(System.in);
        //le joueur saisi son choix 
        System.out.println("Veuillez saisir votre prochaine action (se_deplacer, combattre, sauvegarder ou quitter) :");
        String action = nextAction.next();
        if("se_deplacer".equals(action)){
            //on déplace le joueur si la place est vide 
            System.out.print("Votre ancienne position : ");
            System.out.println(this.player.personne.posEl.toString());
            Point2D point = new Point2D(this.player.personne.posEl.getX(),
                    this.player.personne.posEl.getY());
            while(freePosition(point) == false){
                point = new Point2D(this.player.personne.posEl.getX()+(rand.nextInt(3)-1),
                    this.player.personne.posEl.getY()+(rand.nextInt(3)-1));
        }
            this.player.personne.setPosEl(point);
            System.out.print("Votre nouvelle position : ");
            System.out.println(this.player.personne.posEl.toString());
        }
        
        if ("sauvegarder".equals(action)){
            //on sauvegarde un fichier qui contient les éléments de jeu  
            String nomFichier = "Sauvegarde";
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            String delimiteurs = " /:";   
            StringTokenizer tokenizer = new StringTokenizer(time, delimiteurs);  
            while(tokenizer.hasMoreTokens()) {
                
                String mot = tokenizer.nextToken();
                nomFichier += "_" + mot;
            }
            
            System.out.println("Le fichier de sauvegarde est : " + nomFichier);
            SauvegardePartie S = new SauvegardePartie(nomFichier+".txt");
            S.sauvegarderPartie(this);
        }
        
        if ("combattre".equals(action)){
            //le joueur fait un 
            System.out.println("commencer");
            
            int disattamax = this.player.personne.getDistAttMax();
            int degat_subi = 0;
            
            List<Creature> creatures;
            creatures = this.listEleJeu.stream()
                    .filter(elem -> elem instanceof Creature)
                    .map(elem -> (Creature) elem)
                    .toList();
            
            
            for (Creature C : creatures){
                //S'il y a élément de jeu dans la wone d'attaque du joueur le combat est lancée
                if (this.player.personne.posEl.distance(C.posEl) <= disattamax){
                    
                    String class_name = C.getClass().getSimpleName() ;
                    
                    //System.out.println("Cette créature est dans la zonne d'attaque :" + class_name);
                    
                    ArrayList<ElementDeJeu> list_Eljeu = new ArrayList<>();
                    ElementDeJeu archer = new Archer();
                    list_Eljeu.add(archer) ;
                    ElementDeJeu guerrier = new Guerrier();
                    list_Eljeu.add(guerrier) ;
                    ElementDeJeu mage = new Mage();
                    list_Eljeu.add(mage) ;
                    ElementDeJeu loup = new Loup();
                    list_Eljeu.add(loup) ;
                    NuageToxique nuage = new NuageToxique();
                    list_Eljeu.add(nuage);
                    String[] elejeu = {"Archer", "Guerrier", "Mage", "Loup", "NuageToxique"};

                    int index = 0 ;
                    boolean find = false ;
                    while (find == false && index < elejeu.length) {

                        if (elejeu[index].equals(class_name) ) {

                            find = true ;

                        }
                        else {
                            index += 1 ;

                        }
                    }
                    if (find == true) {
                        
                        System.out.println("Créature "+ class_name+" est dans votre zonne d'attaque");
                        //on rassemble les dégats subis du joueur dans chaque combat
                        degat_subi += C.combattre(this.player.personne);

                    }
            }
        }
            
        System.out.println("Vous avez subi " + degat_subi + " de dégâts.");
        
        }
        
        if ("quitter".equals(action)){
            // on quitte le jeu
            
            quit = true;
        }
        
        
        return quit;
    }
    /**
     * cette méthode permet de crée un joueur et le mettre dans le monde
     */
    public void creationJoueur(){
        Joueur jou=new Joueur();
        this.player = jou;
        this.player.saisir();
        this.mettreDansMonde(this.player.personne);
    }
    /**
     * cette méthode permet de mettre un élément de jeu dans le monde
     * @param elem un élément de jeu
     */
    public void mettreDansMonde(ElementDeJeu elem) {
        Random random = new Random();
        if(elem instanceof Creature) {
            //on ajoute l'élément, si la position est vide  
            while(!freePosition(elem.getPosEl())) {
                //on prend une position aléatoire
                int x=random.nextInt(this.longueur);
                int y=random.nextInt(this.largeur);
                elem.posEl.setposition(x, y);
                
            }
        }
        
        if (elem instanceof NuageToxique) {
            while(!freePosition(elem.getPosEl())) {
                int x=random.nextInt(this.longueur);
                int y=random.nextInt(this.largeur);
                elem.posEl.setposition(x, y);
            }
        }
        if (elem instanceof Object) {
                int x=random.nextInt(this.longueur);
                int y=random.nextInt(this.largeur);
                elem.posEl.setposition(x, y);
            
        }
        // on ajoute lélément dans la liste des éléments de jeu de notre monde 
        this.listEleJeu.add(elem);
    }
    /**
     * cette méthode permet de vérifier si une position est vide ou non
     * @param pos une position
     * @return true si la position est vide, false sinon
     */
    public boolean freePosition(Point2D pos) {
        return findAttPos(pos).isEmpty();
    }
    /**
     * cette méthode permet de générer une liste de creatures qui se trouve dans la meme position 
     * passée comme paramètre
     * @param pos une position 
     * @return un résultat optionel sur la présence d'une creature dans la position passée comme paramètre 
     */
    public Optional<Creature> findAttPos(Point2D pos) {
        List<Creature> creatures = this.listEleJeu.stream()
                .filter(elem -> elem instanceof Creature && elem.getPosEl().equals(pos))
                .map(elem -> (Creature) elem)
                .toList();
        return creatures.isEmpty() ? Optional.empty() : Optional.of(creatures.get(0));
    }
    /**
     * cette méthode gére la consommation des objets 
     * @param p une personnage 
     */
    public void consommePosition(Personnage p) {
        //on prend que les objets de la liste des éléments de jeu
        List<Objet> objets = this.listEleJeu.stream()
                .filter(elem -> elem instanceof Objet && elem.getPosEl().equals(p.getPosEl()))
                .map(elem -> (Objet) elem)
                .toList();
        objets.forEach((var objet) -> {
            if(objet instanceof Soin) {
                //si l'objet est soin, on ajoute le nombre de potion au nombre de vie du personnage
                Soin soin =(Soin)objet; 
                p.setPtVie(p.getPtVie()+soin.getNbrPotion());
            } else if (objet instanceof Mana) {
                //si l'objet est mana, on ajoute le nombre de potion au nombre de mana du personnage 
                Mana mana=(Mana)objet;
                
                p.setPtMana(p.getPtMana()+mana.getNbrPotion());
            } 
            
            else if (objet instanceof Nourriture) {
                //si l'objet est nourritur, on ajoute bonus et on soustraire malus de la nourriture
                //au points de parade du personnage 
                Nourriture nourriture =(Nourriture)objet; 
                p.listNourriture.add(nourriture);
                
                p.setPtPar(p.getPtPar()+nourriture.getBonus()-nourriture.getMalus());
                //on détruit l'objet du monde
                objet = null ;
                
            }
        });
    }
    /**
     * cette méthode permet de créer un monde aléatoire
     * @throws Exception 
     */
   
    public void creeMondeAleaNew() throws Exception {
        Random random = new Random();
        List<Class<? extends Personnage>> personnages = List.of(Archer.class, Guerrier.class,Mage.class,Paysan.class);
        List<Class<? extends Monstre>> monstres = List.of(Loup.class, Lapin.class );
        List<Class<? extends Objet>> objets = List.of(Soin.class, Mana.class, NuageToxique.class, Nourriture.class ); 
        // on crée nbr_personne de personnage
        for(int i=0; i<this.nbr_personne; i++){
            int choix = random.nextInt(personnages.size());
            Class<? extends Personnage> typePersonnage = (Class<? extends Personnage>) personnages.get(choix);
            Creature creature = typePersonnage.getConstructor().newInstance();
            if(creature instanceof Personnage) {
                //Personnage p;
                Personnage p = (Personnage)creature;
                p.setNom("P_" + i);
            }
            this.mettreDansMonde(creature);
        }
        // on crée nbr_monstre de monstre
        for(int i=0; i<this.nbr_monstre; i++){
            int choix = random.nextInt(monstres.size()); 
            Class<? extends Monstre> typeMonstre = monstres.get(choix);
            Creature creature = typeMonstre.getConstructor().newInstance();
            this.mettreDansMonde(creature);
        }
        // on crée nbr_objet d'objets
        for(int i=0; i<this.nbr_objet; i++){
            int choix = random.nextInt(objets.size()); 
            Class<? extends Objet> typeObjet = objets.get(choix);
            Objet obj = typeObjet.getConstructor().newInstance();
            this.mettreDansMonde(obj);
        }   
        }
    
    
    /**
     * cette méthode permet de retourner représentation de notre monde sous une charte 
     * @return une charte sous forme d'un plateau de jeu
     */
    public String charte(){
        
        String charte = "";
        
        charte += "vous êtes: " + this.player.personne.getNom()+"\n";
        
        
        for(int i=0; i<this.longueur; i++) {
            for(int j=0; j<this.largeur; j++) {
                Optional<Creature> creatures = this.findAttPos(new Point2D(i, j));
                //si une position dans notre monde est vide
                if(creatures.isEmpty()){
                     charte +="| |";
                }
                else if(creatures.get().equals(this.player.personne)) {
                        
                         charte +="*J*";
                }
                else {
                     charte += "|" + creatures.get().getClass().getSimpleName().charAt(0)+ "|";
                }
            }
             charte +="\n";
        }
        
        return charte;
    }
    /**
     * cette méthode permet d'afficher notre monde
     */
    public void affiche() {
        
        this.listEleJeu.forEach(elem -> {
            System.out.println(elem.toString());
        });
        
        System.out.print(this.charte());
        
    }
    /**
     * cette méthode permet de sauvegarder la charte avec la date précise de sauvegarde
     */
    public void suvegarder_charte(){
        
        BufferedWriter bufferedWriter = null;
        
        String charte = this.charte();
        
        String Fichier = "Charte";
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            String delimiteurs = " /:";   
            StringTokenizer tokenizer = new StringTokenizer(time, delimiteurs);  
            while(tokenizer.hasMoreTokens()) {
                
                String mot = tokenizer.nextToken();
                Fichier += "_" + mot;
            }
        
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(Fichier+".txt"));
            
            bufferedWriter.write(charte);
            
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
      

