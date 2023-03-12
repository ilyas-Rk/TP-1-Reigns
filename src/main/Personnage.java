    /**
     * TP 1 : Reigns ilyas R'kiouak
     */

package main;

public class Personnage {
    // Le nom du personnage
    protected String nom;
   
    // Le genre du personnage
    protected Genre genre;

    // La jauge de Clergé
    protected Jauge jaugeClerge;

    // La jauge de Peuple
    protected Jauge jaugePeuple;

    // La jauge d'Armée
    protected Jauge jaugeArmee;

    // La jauge de Finances
    protected Jauge jaugeFinance;

    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation les jauges entre 15 et 35 points
        jaugeClerge = new Jauge(TypeJauge.CLERGE,"Clergé", 15 + (int)(Math.random() * (35 - 15)));
        jaugePeuple = new Jauge(TypeJauge.PEUPLE, "Peuple", 15 + (int)(Math.random() * (35 - 15)));
        jaugeArmee = new Jauge(TypeJauge.ARMEE, "Armée", 15 + (int)(Math.random() * (35 - 15)));
        jaugeFinance = new Jauge(TypeJauge.FINANCE, "Finances", 15 + (int)(Math.random() * (35 - 15)));
    }

    // Afficher les jauges 
    public void AfficheJauges() {
        jaugeClerge.afficheJauge();
        jaugePeuple.afficheJauge();
        jaugeArmee.afficheJauge();
        jaugeFinance.afficheJauge();
        System.out.println();
    }

    // Modification et retourne les jauges 
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }


    public Jauge getJaugePeuple() {
        return jaugePeuple;
    }

    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }


    public Jauge getJaugeArmee() {
        return jaugeArmee;
    }

    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    public Jauge getJaugeFinance() {
        return jaugeFinance;
    }

    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }

}
