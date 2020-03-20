package StudeerFX.model.Scores;

public class Score implements Comparable<Score> {
    private String strnaam;
    private double dblscore;

    public Score(String naam, double score) {
        this.strnaam = naam;
        this.dblscore = score;
    }

    public String getStrnaam() {
        return strnaam;
    }

    public double getDblscore() {
        return dblscore;
    }

    @Override
    public int compareTo(Score o) {
        return Double.compare(this.dblscore, o.dblscore);
    }
}



