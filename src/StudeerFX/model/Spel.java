package StudeerFX.model;


import StudeerFX.view.Menu.MenuView;

public class Spel {

    VraagSelector vraagSelector = new VraagSelector();
    private int aantalVragenInvoeren, aantalVragenAfnemen;
    Vragen vragen = new Vragen();
    private String antwoord,vraag,naam,vakkeuzeInvoeren,vakkeuzeAfnemen;

    public void addVraag(){
        vragen.addVraagAntwoord(vraag,antwoord,vakkeuzeInvoeren);
    }
    public void genereerVraag(){vragen.maakVraag(aantalVragenInvoeren);
//        System.out.println("vragen Stat" + vragen.vragenStatistiek + "Antwoorden Stat" + vragen.antwoordenStatistiek);
    }
    public void addVragenVraagselector(){vraagSelector.addVragen(aantalVragenAfnemen,vakkeuzeAfnemen,vragen);}
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

    public int getAantalVragenInvoeren() {
        return aantalVragenInvoeren;
    }

    public void setAantalVragenInvoeren(int aantalVragenInvoeren) {
        this.aantalVragenInvoeren = aantalVragenInvoeren;
    }

    public int getAantalVragenAfnemen() {
        return aantalVragenAfnemen;
    }

    public void setAantalVragenAfnemen(int aantalVragenAfnemen) {
        this.aantalVragenAfnemen = aantalVragenAfnemen;
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

    public String getVakkeuzeInvoeren() {
        return vakkeuzeInvoeren;
    }

    public void setVakkeuzeInvoeren(String vakkeuzeInvoeren) {
        this.vakkeuzeInvoeren = vakkeuzeInvoeren;
    }

    public String getVakkeuzeAfnemen() {
        return vakkeuzeAfnemen;
    }

    public void setVakkeuzeAfnemen(String vakkeuzeAfnemen) {
        this.vakkeuzeAfnemen = vakkeuzeAfnemen;
    }
}
//test

