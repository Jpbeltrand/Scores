public interface Scores {
    public String toString();
    boolean add(GameEntry e);
    GameEntry get(int i);
    int getCapacity();
    int getNumScores();
    double getAvgScores();
}