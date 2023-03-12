package main;

public class Jauge {

    protected TypeJauge type;

    protected String nom;

    protected int valeur;


    public Jauge(TypeJauge type,String nom, int valeur){
        this.type=type;
        this.nom = nom;
        this.valeur = valeur;
    }
    public void afficheJauge() {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<this.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(this.getValeur()>0?this.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += this.getNom();
        System.out.println(resultat);
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getValeur() {
        return valeur;
    }


    public void setValeur(int valeur) {
        this.valeur = valeur;
    }


    public TypeJauge getType() {
        return type;
    }

    public void setType(TypeJauge type) {
        this.type = type;
    }
    public Boolean verfierJauge(){
        if(this.getValeur()>=50|| this.getValeur()<=0){
            return true;
        }
        return false;
    }
}
