package StudeerFX.model;


import StudeerFX.view.Menu.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spel {

    VraagSelector vraagSelector = new VraagSelector();
    private int aantalVragenInvoeren, aantalVragenAfnemen, vraagNummer, aantalVragenGesteld;
    Vragen vragen = new Vragen();
    private String antwoord,vraag,naam,vakkeuzeInvoeren,vakkeuzeAfnemen, vraagTest, antwoordTest;
    private List<String> vragenTest = new ArrayList<>();
    private List<String> antwoordenTest = new ArrayList<>();
    private Random rand  = new Random();
    private int random, punten, maxpunten;
    private int poging = 1;



    //Communicatie tussen models

    public void addVraag(){
        vragen.addVraagAntwoord(vraag,antwoord,vakkeuzeInvoeren);
    }
    public void genereerVraag(){vragen.maakVraag(aantalVragenInvoeren);
//        System.out.println("vragen Stat" + vragen.vragenStatistiek + "Antwoorden Stat" + vragen.antwoordenStatistiek);
    }
    public void addVragenVraagselector(){vraagSelector.addVragen(aantalVragenAfnemen,vakkeuzeAfnemen,vragen);}
    public void geefVragen(){

            vragenTest = vraagSelector.getVragenTemp();
            antwoordenTest = vraagSelector.getAntwoordenTemp();

            aantalVragenGesteld = 1;

    }

    //SpelFuncties

    public void geefVraag(){
        if(poging == 1) {

            random = rand.nextInt(vragenTest.size());

        }
        setVraagTest(vragenTest.get(random));
        setAntwoordTest(antwoordenTest.get(random));

    }
    public void kijkNa(String answer){
    poging = poging +1;
        if(answer.equals(antwoordenTest.get(random))){
            punten = punten +1;
            poging = 1;
            aantalVragenGesteld = aantalVragenGesteld +1;
            maxpunten = maxpunten+1;
            vragenTest.remove(random);
            antwoordenTest.remove(random);
        }else {
            if (poging == 4) {
                maxpunten = maxpunten + 1;
                aantalVragenGesteld = aantalVragenGesteld + 1;
                vragenTest.remove(random);
                antwoordenTest.remove(random);
                poging = 1;
            }
        }
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

    public String getVraagTest() {
        return vraagTest;
    }

    public void setVraagTest(String vraagTest) {
        this.vraagTest = vraagTest;
    }

    public String getAntwoordTest() {
        return antwoordTest;
    }

    public int getAantalVragenGesteld() {
        return aantalVragenGesteld;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public int getMaxpunten() {
        return maxpunten;
    }

    public void setMaxpunten(int maxpunten) {
        this.maxpunten = maxpunten;
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

    public void setAntwoordTest(String antwoordTest) {
        this.antwoordTest = antwoordTest;
    }

    public int getVraagNummer() {
        return vraagNummer;
    }

    public void setAantalVragenGesteld(int aantalVragenGesteld) {
        this.aantalVragenGesteld = aantalVragenGesteld;
    }

    public void setVraagNummer(int vraagNummer) {
        this.vraagNummer = vraagNummer;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    public int getPoging() {
        return poging;
    }

    public void setPoging(int poging) {
        this.poging = poging;
    }
}
//test

