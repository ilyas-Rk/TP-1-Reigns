package main;

import java.util.Map;
import java.util.TreeMap;


public class Question {

    protected String nomPersonnage;

    protected String question;

    protected String effetGauche;

    protected String effetDroite;

    protected Map<TypeJauge, Integer> effetJaugeGauche;

    protected Map<TypeJauge, Integer> effetJaugeDroite;

    public Question(String nomPersonnage,
                    String question,
                    String effetGauche,
                    String effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effetJaugeDroite = new TreeMap<>();
        this.effetJaugeGauche = new TreeMap<>();
    }

    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        System.out.println("Effet G:"+afficheEffets(effetJaugeGauche));
        System.out.println("Effet D:"+afficheEffets(effetJaugeDroite));
        System.out.flush();
    }


    private String afficheEffets(Map<TypeJauge, Integer> effets) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Integer> effet : effets.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }


    public void appliqueEffetsGauche(Personnage personnage){
        this.appliqueEffets(effetJaugeGauche, personnage);
    }


    public void appliqueEffetsDroite(Personnage personnage){
        this.appliqueEffets(effetJaugeDroite, personnage);
    }


    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Personnage personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                case ARMEE:
                    personnage.getJaugeArmee().setValeur(
                            personnage.getJaugeArmee().getValeur()
                                    +effet.getValue());
                    break;
                case CLERGE:
                    personnage.getJaugeClerge().setValeur(
                            personnage.getJaugeClerge().getValeur()
                                    +effet.getValue());
                    break;
                case FINANCE:
                    personnage.getJaugeFinance().setValeur(
                            personnage.getJaugeFinance().getValeur()
                                    +effet.getValue());
                    break;
                case PEUPLE:
                    personnage.getJaugePeuple().setValeur(
                            personnage.getJaugePeuple().getValeur()
                                    +effet.getValue());
                    break;
            }
        }
    }


    public void ajouteEffetGauche(TypeJauge jauge,
                                  int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }


    public void ajouteEffetDroite(TypeJauge jauge,
                                  int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }


    public String getNomPersonnage() {
        return nomPersonnage;
    }


    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }


    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public String getEffetGauche() {
        return effetGauche;
    }


    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }


    public String getEffetDroite() {
        return effetDroite;
    }


    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }

}
