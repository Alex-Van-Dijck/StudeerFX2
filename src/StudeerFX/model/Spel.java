package StudeerFX.model;


import StudeerFX.view.Menu.MenuView;

public class Spel {

    private String antwoord,vraag,naam,vakkeuze;
    Vragen vragen = new Vragen();




    public void addVraag(){
        vragen.addVraagAntwoord(vraag,antwoord,vakkeuze);
    }
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
    public String getVakkeuze() {
        return vakkeuze;
    }
    ///Setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVraag(String vraag){
        this.vraag = vraag;
    }
    public void setAntwoord(String antwoord){
        this.antwoord = antwoord;
    }
    public void setVakkeuze(String vakkeuze) {
        this.vakkeuze = vakkeuze;
    }
}
//test

