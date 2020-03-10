package StudeerFX.model;


import StudeerFX.view.Menu.MenuView;

public class Spel {

    String naam;
    String vraag;
    String antwoord;


    ///Geters
    public String getNaam() {
        return naam;
    }
    public String getVraag(){
        return vraag;
    }
    public String getAntwoord(){
        return antwoord;
    }

    ///Setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVraag(String vraag){
        this.vraag = vraag;
    }
    public void setAntwoord(String vraag){
        this.antwoord = antwoord;
    }

}


