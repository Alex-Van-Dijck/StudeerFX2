package StudeerFX.model;
import java.text.DecimalFormat;
import java.util.*;
import java.math.*;
import javax.script.*;
/**
 * @author Alex Van Dijck on 10/03/2020
 * @project StudeerFX
 */
public class Vragen {

    Random rand = new Random();
    List<String> vragenFrans = new ArrayList<>();
    List<String> vragenStatistiek = new ArrayList<>();
    List<String> vragenProgrammeren = new ArrayList<>();
    List<String> antwoordenFrans = new ArrayList<>();
    List<String> antwoordenFrans2 = new ArrayList<>();
    List<String> antwoordenStatistiek = new ArrayList<>();
    List<String> antwoordenProgrammeren = new ArrayList<>();
    List<String> antwoordenProgrammeren2 = new ArrayList<>();
    private List<String> tekens = new ArrayList<String>(4);

    //Automatische vragen
    //Automatische Maximumvraag
    private void maakMaximumvraag3() {

        int random1 = rand.nextInt(100) + 1;
        int random2 = rand.nextInt(100) + 1;
        int random3 = rand.nextInt(100) + 1;
        int hoogste = Math.max(random1, Math.max(random2, random3));
        vragenStatistiek.add("Welk getal is hoger? " + random1 + ", " + random2 + " of " + random3 + "?");
        antwoordenStatistiek.add(Integer.toString(hoogste));
    }

    private void maakMaximumvraag2() {

        int random1 = rand.nextInt(100) + 1;
        int random2 = rand.nextInt(100) + 1;
        int hoogste = Math.max(random1, random2);
        vragenStatistiek.add("Welk getal is hoger? " + random1 + " of " + random2 + "?");
        antwoordenStatistiek.add(Integer.toString(hoogste));
    }

    //Automatische gemiddeldevraag
    private void maakGemiddeldevraag3() {
        int random1 = rand.nextInt(100) + 1;
        int random2 = rand.nextInt(100) + 1;
        int random3 = rand.nextInt(100) + 1;
        double gemiddelde = ((double) (random1 + random2 + random3) / 3) * 100;
        int rondaf = (int) Math.round(gemiddelde);
        double toon = rondaf * 0.01;
        // NUL NA DE KOMMA WEGWERKEN
        String toon2 = Double.toString(toon);
        String toon3 = toon2.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
        // TOT HIER
        vragenStatistiek.add("Wat is het gemiddelde van " + random1 + ", " + random2 + " en " + random3 + "? ");
        antwoordenStatistiek.add(toon3);

    }

    private void maakGemiddeldevraag2() {
        int random1 = rand.nextInt(100) + 1;
        int random2 = rand.nextInt(100) + 1;
        double gemiddelde = ((double) (random1 + random2) / 2) * 100;
        int rondaf = (int) Math.round(gemiddelde);
        double toon = rondaf * 0.01;
        // NUL NA DE KOMMA WEGWERKEN
        String toon2 = Double.toString(toon);
        String toon3 = toon2.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
        // TOT HIER
        vragenStatistiek.add("Wat is het gemiddelde van " + random1 + " en " + random2 + "?");
        antwoordenStatistiek.add(toon3);
    }

    public void maakStandaardDeviatieVraag() {
        double sdv = 0;
        int[] getallen = new int[]{1, 2, 3, 4, 5};

        for (int l = 0; l < 5; l++) {
            getallen[l] = rand.nextInt(100) + 1;
        }

        Arrays.sort(getallen);
        int som = 0;
        int max = getallen[4];
        int min = getallen[0];

        for (int o = 0; o < 5; o++) {
            som += getallen[o];
        }
        double gemiddelde = som / 5;

        for (int o = 0; o < 5; o++) {
            sdv += (getallen[o] - gemiddelde) * (getallen[o] - gemiddelde) / 5;
        }
        double sdv2 = Math.sqrt(sdv);
        BigDecimal standardDeviatie = new BigDecimal(sdv2).setScale(2, RoundingMode.HALF_UP);
        vragenStatistiek.add("Wat is de standaarddeviatie van: " + Arrays.toString(getallen) + " ? ");
        antwoordenStatistiek.add(standardDeviatie.toString());
    }

    public void bewerkingdrie() {
        tekens.add("-");
        tekens.add("+");
        tekens.add("*");
        tekens.add("/");
        int random1 = rand.nextInt(100) + 1;
        int random2 = rand.nextInt(100) + 1;
        int random3 = rand.nextInt(100) + 1;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = random1 + tekens.get(rand.nextInt(4)) + random2 + tekens.get(rand.nextInt(4)) + random3;
        vragenStatistiek.add(foo);

        try {
            double foo2 = Double.parseDouble(engine.eval(foo).toString()) * 100;
            double rondaf = (double) Math.round(foo2);
            String toon = String.valueOf(rondaf * 0.01);
            // NUL NA DE KOMMA WEGWERKEN
            String toon3 = toon.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");

            antwoordenStatistiek.add(engine.eval(toon3).toString());
        } catch (ScriptException ex) {

        }
    }

    //Random vraag selector
    public void maakVraag(int aantalVragen) {
        for (int m = 0; m < aantalVragen; m++) {
            int random = rand.nextInt(6) + 1;

            switch (random) {
                case 1:
                    maakGemiddeldevraag2();
                    break;
                case 2:
                    maakGemiddeldevraag3();
                    break;
                case 3:
                    maakMaximumvraag2();
                    break;
                case 4:
                    maakMaximumvraag3();
                    break;
                case 5:
                    maakStandaardDeviatieVraag();
                    break;
                case 6:
                    bewerkingdrie();
                    break;
            }
        }
    }

    //Vragen invoeren
    public void addVraagAntwoord(String vraag,String antwoord,String vakkeuze){

        switch  (vakkeuze){
            case "Frans":
                vragenFrans.add(vraag);
                antwoordenFrans.add(antwoord);
                break;

            case "Programmeren":
                vragenProgrammeren.add(vraag);
                antwoordenProgrammeren.add(antwoord);
                break;

            case "Statistiek":
                vragenStatistiek.add(vraag);
                antwoordenStatistiek.add(antwoord);
                break;

        }

    }
    public void addVraagAntwoord(String vraag,String antwoord,String antwoord2,String vakkeuze){

        switch  (vakkeuze){
            case "Frans":
                vragenFrans.add(vraag);
                antwoordenFrans.add(antwoord);
                antwoordenFrans2.add(antwoord2);
                break;

            case "Programmeren":
                vragenProgrammeren.add(vraag);
                antwoordenProgrammeren.add(antwoord);
                antwoordenProgrammeren2.add(antwoord2);
                break;

            case "Statistiek":
                vragenStatistiek.add(vraag);
                antwoordenStatistiek.add(antwoord);
                break;

        }

    }

//    public boolean checkVragen(int aantal, String vakkeuze){
//
////        switch  (vakkeuze){
//////            case "Frans":
//////                if(aantal > vragenFrans.size()){
//////                    return true;
//////                }else{ return false;}
//////            break;
//////
//////            case "Programmeren":
//////                if(aantal > vragenProgrammeren.size()){
//////                    return true;
//////                }else{ return false;}
//////                break;
//////
//////            case "Statistiek":
//////                if(aantal > vragenStatistiek.size()){
//////                    return true;
//////                }else{ return false;}
//////                break;
//////        }
//
//        if(vakkeuze.equals("Frans")){
//            if(aantal > vragenFrans.size()){
//                  return true;
//                }else{ return false;}
//        }else if(vakkeuze.equals("Programmeren")){
//            if (aantal > vragenProgrammeren.size()) {
//                return true;
//            } else {
//                return false;
//            }
//        }else if(vakkeuze.equals("Statistiek")){
//            if (aantal > vragenStatistiek.size()) {
//                return true;
//            } else {
//                return false;
//            }
//        }else{ return false;}
//    }


}


