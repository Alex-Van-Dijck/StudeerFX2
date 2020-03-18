package StudeerFX.model;
import java.util.*;
/**
 * @author Alex Van Dijck on 15/03/2020
 * @project StudeerFX
 */

public class VraagSelector {

    private List<String> vragenTemp = new ArrayList<>();
    private List<String> antwoordenTemp = new ArrayList<>();
    private List<String> antwoordenTemp2 = new ArrayList<>();
    private Random rand = new Random();
    private int aantalVragenGesteld = 0;
    private int punten = 0;

    public void addVragen(int hoeveelheid, String vak, Vragen objectVragen) {
        switch (vak) {
            case "Frans":
                for (int m = 0; m < hoeveelheid; m++) {
                    int random = rand.nextInt(objectVragen.vragenFrans.size());
                    String tempVraag = objectVragen.vragenFrans.get(random);
                    if (vragenTemp.contains(tempVraag)) {
                        m--;
                    } else {
                        vragenTemp.add(objectVragen.vragenFrans.get(random));
                        antwoordenTemp.add(objectVragen.antwoordenFrans.get(random));
                        antwoordenTemp2.add(objectVragen.antwoordenFrans2.get(random));
                    }
                }
                break;
            case "Programmeren":
                for (int m = 0; m < hoeveelheid; m++) {
                    int random = rand.nextInt(objectVragen.vragenProgrammeren.size());
                    vragenTemp.add(objectVragen.vragenProgrammeren.get(random));
                    antwoordenTemp.add(objectVragen.antwoordenProgrammeren.get(random));
                    antwoordenTemp2.add(objectVragen.antwoordenProgrammeren2.get(random));
                    System.out.println(objectVragen.antwoordenProgrammeren2.get(random));
                }
                break;
            case "Statistiek":
                for (int m = 0; m < hoeveelheid; m++) {
                    int size = objectVragen.vragenStatistiek.size();
                    int random = rand.nextInt(size);
                    String tempVraag = objectVragen.vragenStatistiek.get(random);
                    if (vragenTemp.contains(tempVraag)) {
                        m--;
                    } else {
                        vragenTemp.add(objectVragen.vragenStatistiek.get(random));
                        antwoordenTemp.add(objectVragen.antwoordenStatistiek.get(random));
                        antwoordenTemp2.add(null);
                    }
                }
                break;
            default:
                System.out.println("Ongeldig vak");
        }
        System.out.println("Vragen:" + vragenTemp);
        System.out.println(" Antwoorden: " + antwoordenTemp );
        System.out.println("Extra Antwoorden: " + antwoordenTemp2);
    }



    public List<String> getVragenTemp() {
        return vragenTemp;
    }

    public void setVragenTemp(List<String> vragenTemp) {
        this.vragenTemp = vragenTemp;
    }

    public List<String> getAntwoordenTemp() {
        return antwoordenTemp;
    }

    public void setAntwoordenTemp(List<String> antwoordenTemp) {
        this.antwoordenTemp = antwoordenTemp;
    }

    public List<String> getAntwoordenTemp2() {
        return antwoordenTemp2;
    }

    public void setAntwoordenTemp2(List<String> antwoordenTemp2) {
        this.antwoordenTemp2 = antwoordenTemp2;
    }
}


