package StudeerFX.model;


import StudeerFX.view.Menu.MenuView;

public class Spel {

    private int aantalVragen;
    private String antwoord,vraag,naam,vakkeuze;
    Vragen vragen = new Vragen();




    public void addVraag(){
        vragen.addVraagAntwoord(vraag,antwoord,vakkeuze);
    }
    public void genereerVraag(){vragen.maakVraag(aantalVragen);
//        System.out.println("vragen Stat" + vragen.vragenStatistiek + "Antwoorden Stat" + vragen.antwoordenStatistiek);
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

    public int getAantalVragen() {
        return aantalVragen;
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

    public void setAantalVragen(int aantalVragen)
    {
        this.aantalVragen = aantalVragen;
    }
}
//test

