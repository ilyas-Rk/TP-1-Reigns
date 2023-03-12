    /**
     * TP 1 : Reigns ilyas R'kiouak
     */

package main;

public class Jauge {
 // Le type de la jauge
    protected TypeJauge type;
 // Le nom de la jauge
    protected String nom;
//  La valeur de la jauge
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

    // Retourne le nom de la jauge
    public String getNom() {
        return nom;
    }

    // Modifier le nom de la jauge
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Retourne la valeur de la jauge
    public int getValeur() {
        return valeur;
    }


    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    // Retourne le type de la jauge
    public TypeJauge getType() {
        return type;
    }
    
    //Modifie le type de la jauge.
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
