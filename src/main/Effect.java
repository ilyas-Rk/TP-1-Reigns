    /**
     * TP 1 : Reigns ilyas R'kiouak
     */

package main;

public class Effect {
    protected TypeEffect typeEffect;
    protected TypeJauge nomJauge;
    protected int valeur;
    public Effect(TypeEffect typeEffect, TypeJauge nomJauge, int valeur) {
        this.typeEffect = typeEffect;
        this.nomJauge = nomJauge;
        this.valeur = valeur;
    }


    public void setNomJauge(TypeJauge nomJauge) {
        this.nomJauge = nomJauge;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TypeEffect getTypeEffect() {
        return typeEffect;
    }

    public TypeJauge getNomJauge() {
        return nomJauge;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "; jauge " +
                 nomJauge +
                 (valeur>0 ? "+":"") +
                valeur;
    }
    public void appilquer(Personnage personnage){
        if(personnage.jaugeFinance.type==this.nomJauge){
            personnage.jaugeFinance.valeur += this.getValeur();
            return;
        }
        if(personnage.jaugeArmee.type==this.nomJauge){
            personnage.jaugeArmee.valeur += this.getValeur();
            return;
        }
        if(personnage.jaugePeuple.type==this.nomJauge){
            personnage.jaugePeuple.valeur += this.getValeur();
            return;
        }
        if(personnage.jaugeFinance.type==this.nomJauge){
            personnage.jaugeFinance.valeur += this.getValeur();
        }
    }

}
