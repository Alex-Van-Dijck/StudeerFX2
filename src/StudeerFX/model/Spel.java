package StudeerFX.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Spel {

    private VraagSelector vraagSelector = new VraagSelector();
    private int aantalVragenInvoeren, aantalVragenAfnemen, vraagNummer, aantalVragenGesteld;
    private Vragen vragen = new Vragen();
    private String antwoord,vraag, antwoord2 ,naam,vakkeuzeInvoeren,vakkeuzeAfnemen, vraagTest, antwoordTest, antwoordTest2;
    private List<String> vragenTest = new ArrayList<>();
    private List<String> antwoordenTest = new ArrayList<>();
    private List<String> antwoordenTest2 = new ArrayList<>();
    private Random rand  = new Random();
    private int random, punten,  size;
    private int poging = 1;
    public String path;
    private double maxpunten;
    private boolean testKlaar = false, append = false;



    //Communicatie tussen models

    public void addVraag(){
        vragen.addVraagAntwoord(vraag,antwoord,antwoord2,vakkeuzeInvoeren);
    }
    public void genereerVraag(){vragen.maakVraag(aantalVragenInvoeren);
//        System.out.println("vragen Stat" + vragen.vragenStatistiek + "Antwoorden Stat" + vragen.antwoordenStatistiek);
    }
    public void addVragenVraagselector(){vraagSelector.addVragen(aantalVragenAfnemen,vakkeuzeAfnemen,vragen);}
    public void geefVragen(){

            vragenTest = vraagSelector.getVragenTemp();
            antwoordenTest = vraagSelector.getAntwoordenTemp();
            antwoordenTest2 =vraagSelector.getAntwoordenTemp2();
            aantalVragenGesteld = 1;
            size = vragenTest.size();

    }


    //SpelFuncties

    public void Reset(){
        testKlaar = false;
        poging = 1;
    }

    public void playJuist(){
        Media Juist = new Media(new File("resources/Sound/correct.wav").toURI().toString());
        MediaPlayer juist = new MediaPlayer(Juist);
        juist.play();
    }

    public void playFout(){
        Media Fout = new Media(new File("resources/Sound/Wrong.wav").toURI().toString());
        MediaPlayer fout = new MediaPlayer(Fout);
       fout.play();
    }

    public void geefVraag(){
        if(poging == 1) {

            random = rand.nextInt(vragenTest.size());

        }
        setVraagTest(vragenTest.get(random));
        setAntwoordTest(antwoordenTest.get(random));

    }

    public void kijkNa(String answer){
    poging = poging +1;
        if(answer.equals(antwoordenTest.get(random)) || answer.equals(antwoordenTest2.get(random))){
            punten = punten +1;
            poging = 1;
            aantalVragenGesteld = aantalVragenGesteld +1;
            maxpunten = maxpunten+1;
            vragenTest.remove(random);
            antwoordenTest.remove(random);
            playJuist();
        }else {
            playFout();
            if (poging == 4) {
                maxpunten = maxpunten + 1;
                aantalVragenGesteld = aantalVragenGesteld + 1;
                vragenTest.remove(random);
                antwoordenTest.remove(random);
                poging = 1;
            }
        }
        if(maxpunten == size){
            testKlaar = true;
        }
    }

    //Write

    public void WriteFile(String file_path){

    }
    //Exceptions

    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    //Geters//
    public String getNaam() {
        return naam;
    }
    public String getVraag(){
        return vraag;
    }
    public String getAntwoord(){
        return antwoord;
    }

    //Setters//
    public void setNaam(String naam) {
        this.naam = naam;
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

    public double getMaxpunten() {
        return maxpunten;
    }

    public void setMaxpunten(int maxpunten) {
        this.maxpunten = maxpunten;
    }

    public boolean isTestKlaar() {
        return testKlaar;
    }

    public String getAntwoord2() {
        return antwoord2;
    }

    public void setAntwoord2(String antwoord2) {
        this.antwoord2 = antwoord2;
    }

    public String getAntwoordTest2() {
        return antwoordTest2;
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

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public void setAntwoordTest2(String antwoordTest2) {
        this.antwoordTest2 = antwoordTest2;
    }

    public List<String> getVragenTest() {
        return vragenTest;
    }
}

//test

