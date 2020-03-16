package StudeerFX.model;
import java.util.*;
/**
 * @author Alex Van Dijck on 15/03/2020
 * @project StudeerFX
 */

public class VraagSelector {

    private List<String> vragenTemp = new ArrayList<>();
    private List<String> antwoordenTemp = new ArrayList<>();
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
                    }
                }
                break;
            case "Programmeren":
                for (int m = 0; m < hoeveelheid; m++) {
                    int random = rand.nextInt(objectVragen.vragenProgrammeren.size());
                    vragenTemp.add(objectVragen.vragenProgrammeren.get(random));
                    antwoordenTemp.add(objectVragen.antwoordenProgrammeren.get(random));
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
                    }
                }
                break;
            default:
                System.out.println("Ongeldig vak");
        }
        System.out.println("Vragen:" + vragenTemp + " Antwoorden: " + antwoordenTemp);
    }

//    public void stelVragen(String naamGebruiker) {
//        int size = vragenTemp.size();
//        for (int k = 0; k < size; k++) { //Loop om het aantal vragen af te printen
//            aantalVragenGesteld += 1;
//            int random = rand.nextInt(vragenTemp.size());
//            for (int l = 1; l < 4; l++) { //Loop om de 3 kansen te geven
//                if (aantalVragenGesteld != 1) {
//                    System.out.println("Je tijdelijke score is " + punten + "/" + size);
//                    System.out.println("--------------------------------------");
//                }
////                System.out.println("Vraag " + aantalVragenGesteld + " (Poging: " + l + ")");
////                String antwoord = input.nextLine();
//                if (antwoordenTemp.get(random).equals(antwoord)) {
//                    l = 4;
//                    punten += 1;
//                    System.out.println("Correct!");
//                } else {
//                    System.out.println("Jammer, dat is fout.");
//                }
//            }
//            vragenTemp.remove(random);
//            antwoordenTemp.remove(random);
//        }
//        System.out.println("Proficiat " + naamGebruiker + ", je haalde " + punten + "/" + aantalVragenGesteld + "!");
//        aantalVragenGesteld = 0;
//        punten = 0;
//    }

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
}


