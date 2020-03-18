package StudeerFX.model.Scores;
import javax.imageio.stream.ImageInputStream;
import javax.management.relation.Role;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scorebord {
    private List<Score> scores;

    public Scorebord() {
        this.scores = new ArrayList<>();
    }


    public void addScore(Score score) {
        scores.add(score);
        if (scores.size() > 10) {
            scores.sort(Score::compareTo);
            scores.remove(0);
        }
    }

    public String showScoreboard() {
        scores.sort(Score::compareTo);
        Collections.reverse(scores);
        StringBuilder output = new StringBuilder();
        for (Score score : scores) {
            output.append(String.format("%s / %f%%%n",score.getNaam(),score.getScore()).replaceAll("([,]0+)", ""));
        }
        return output.toString();
    }

    // Writing the file with the high-scores of the played games.
    public void writeScoreFile() {
        try {
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\resources\\Textfiles\\Scorebord", false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(showScoreboard());
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
        }
    }

    // Reading the file with the high-scores of the played games.
    public void readScoreFile() {
        try {
            File file = new File(System.getProperty("user.dir") + "\\resources\\Textfiles\\Scorebord");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder input = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null)
                input.append(st).append("\n");
            scores.clear();
            for (String line : input.toString().split("\n")) {
                line = line.replaceAll("[ %]", "");
                String[] score = line.split("/");
                addScore(new Score(score[0],Double.parseDouble(score[1].replaceAll(",","."))));
            }
        } catch (IOException ex) {
        }
    }

    public List<Score> getScores() {
        return scores;
    }
}


