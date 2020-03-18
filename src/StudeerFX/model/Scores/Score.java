package StudeerFX.model.Scores;

public class Score implements Comparable<Score> {
    private String naam;
    private double score;

    public Score(String naam, double score) {
        this.naam = naam;
        this.score = score;
    }

    public String getNaam() {
        return naam;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(Score o) {
        return Double.compare(this.score, o.score);
    }
}



