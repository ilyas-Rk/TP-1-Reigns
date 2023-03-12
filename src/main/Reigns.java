package main;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    protected String effetGauche;
    /**
     * l'effet de la réponse de droite
     */
    protected String effetDroite;
    /**
     * les effets sur les jauges pour la réponse de gauche
     */
    protected Vector<Effect> effects;
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
        this.effects = new Vector<Effect>();
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
    public void afficheQuestion2() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        this.afficheEffets2();
        System.out.flush();
    }


    public void afficheEffets2(){
        for(TypeEffect typeEffect : TypeEffect.values()){
            StringBuilder result = new StringBuilder();
            result.append("Effet ").append(typeEffect).append(":");
            for(Effect effet : this.effects){
                if(effet.typeEffect == typeEffect){
                    result.append(effet.toString());
                }
            }
            System.out.println(result);
        }

    }
    public void appliquerEffet2(TypeEffect typeEffect, Personnage personnage){
        for(Effect effet : this.effects){
            if(effet.typeEffect == typeEffect){
                effet.appilquer(personnage);
            }
        }
    }
    public void ajoutEffets2(TypeEffect typeEffect, TypeJauge nomJauge, int valeur){
        effects.add(new Effect(typeEffect, nomJauge, valeur));
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

    private void appliqueEffetArmee(Personnage personnage, int valeur,TypeJauge key){
        if(key.equals(TypeJauge.ARMEE))
        personnage.getJaugeArmee().setValeur(personnage.getJaugeArmee().getValeur() + valeur);
    }

    private void appliqueEffetClerge(Personnage personnage, int valeur,TypeJauge key){
        if(key.equals(TypeJauge.CLERGE))
        personnage.getJaugeClerge().setValeur(personnage.getJaugeClerge().getValeur() + valeur);
    }

    private void appliqueEffetFinance(Personnage personnage, int valeur,TypeJauge key){
        if(key.equals(TypeJauge.FINANCE))
        personnage.getJaugeFinance().setValeur(personnage.getJaugeFinance().getValeur() + valeur);
    }

    private void appliqueEffetPeuple(Personnage personnage, int valeur,TypeJauge key){
        if(key.equals(TypeJauge.PEUPLE))
        personnage.getJaugePeuple().setValeur(personnage.getJaugePeuple().getValeur() + valeur);
    }
    private void appliqueEffets(Map<TypeJauge,Integer> effets, Personnage personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
                appliqueEffetArmee(personnage, effet.getValue(),effet.getKey());
                appliqueEffetClerge(personnage, effet.getValue(),effet.getKey());
                appliqueEffetFinance(personnage, effet.getValue(),effet.getKey());
                appliqueEffetPeuple(personnage, effet.getValue(),effet.getKey());
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
