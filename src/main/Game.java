    /**
     * TP 1 : Reigns ilyas R'kiouak
     */

package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Personnage personnage;

    /**
     * la banque des questions
     */
    private ArrayList<Question> questions;
    public Game(){


        // début du jeu
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions2();

        System.out.println("Création du personnage...");

        initPersonnage();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        personnage.AfficheJauges();


        // tirages des questions
        int nbTours = 0;
        while(!this.finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion2(question);
            personnage.AfficheJauges();
        }


        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");
     }

    // Demande au joueur de répondre à la question et applique les effets en fonction de sa réponse
    private void reponseQuestion(Question question){
        question.afficheQuestion2();
       
        // récupèrer la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }

        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffetsGauche(this.personnage);
        }else{
            question.appliqueEffetsDroite(this.personnage);
        }
    }
    private void reponseQuestion2(Question question){
        question.afficheQuestion2();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        question.appliquerEffet2(TypeEffect.valueOf(reponse.toString()), this.personnage);
    }


 // Initialise le personnage
    private void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine;
        if(genre==1){
            roiReine = Genre.ROI;
        }else{
            roiReine = Genre.REINE;
        }

        this.personnage = new Personnage(nom,roiReine);
    }
    public static Question initq1(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        return question1;
    }
    public static Question initq12(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniersS",
                "Oui",
                "Non");
        question1.ajoutEffets2(TypeEffect.G, TypeJauge.ARMEE, -5);
        question1.ajoutEffets2(TypeEffect.G, TypeJauge.PEUPLE, 5);
        question1.ajoutEffets2(TypeEffect.D, TypeJauge.PEUPLE, -7);
        return question1;
    }
    public static Question initq2(){
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        return question2;
    }
    public static Question initq3(){
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        return question3;
    }
    public static Question initq4(){
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        return question4;
    }
    public static Question initq5(){
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        return question5;
    }

      // Initialise la banque de questions  
    private void initBanqueQuestions2(){
        this.questions = new ArrayList<>();
        Question q1 = initq12();
        this.questions.add(q1);
    }
    private void initBanqueQuestions(){
        this.questions = new ArrayList<>();
        Question q1 = initq1();
        this.questions.add(q1);
        Question q2 = initq2();
        this.questions.add(q2);
        Question q3 = initq3();
        this.questions.add(q3);
        Question q4 = initq4();
        this.questions.add(q4);
        Question q5 = initq5();
        this.questions.add(q5);
    }


    private Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*this.questions.size());
        return this.questions.get(numQuestion);
    }
    public boolean finDuJeu(){
        return this.personnage.jaugeClerge.verfierJauge()
                || this.personnage.jaugePeuple.verfierJauge()
                || this.personnage.jaugeArmee.verfierJauge()
                || this.personnage.jaugeFinance.verfierJauge();
    }
}

