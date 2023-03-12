package main;

public enum Genre {

    ROI,

    REINE;

    public String longRegne(){
        if(this==ROI)
            return "Long règne au roi ";
        return "Long règne à la reine";
    }
}