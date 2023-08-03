import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class GameEntry implements Scores{
    private String name;
    private int score;
    private ArrayList<GameEntry> scores;
    protected static int maxCapacity = 10;
    private LocalDate date;

    
    
    public GameEntry(String name, int score, LocalDate date){
         scores = new ArrayList<GameEntry>();
         this.name = name;
         this.score = score;
         this.date = date;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public LocalDate getDate(){
        return date;
    }

    
    /** Retorna uma string representando o objeto
    * Formato: [(<name>, <score>, <date>), (<name>, <score>, <date>) …]
    * Exemplo: [(John, 10, 10/04/2023), (Carol, 5, 01/02/2022)]
    */
    @Override  
    public String toString(){ 
        return 
         "Name: %s" + name + ", Score: %d" + score + ", Date: %s" + getDate();
    }
    
    /** Adiciona um novo score se ele for grande o suficiente
    * * Retorna verdadeiro se foi adicionado, falso caso contrário 
    */ 
    @Override 
    public boolean add(GameEntry e) {
        //Dont let you add score that is less or equal to the lower score in the list.
       if (scores.size() >= maxCapacity && e.getScore() <= scores.get(scores.size() - 1).getScore()) {
        return false;
       }
       scores.add(e);
       //Sort the list in a descending order.
       Collections.sort(scores, Collections.reverseOrder());
       //remove the last score if the list is full.
       if (scores.size() >= maxCapacity){
        scores.remove(maxCapacity);
       }
       return true;
    }
   

    @Override /** Retorna o score na posição i */
    public GameEntry get(int i) {
        if (i < 0 || i >= scores.size()){
            throw new IndexOutOfBoundsException();
        }
        return scores.get(i);
    }

    @Override /** Retorna a capacidade máxima da coleção */
    public int getCapacity() {
           return maxCapacity;
    }

    @Override /** Retorna o número de scores armazenados */
    public int getNumScores() {
          return scores.size(); 
    }
    
    @Override /** Retorna a média dos scores armazenados */
    public double getAvgScores(){
        double soma = 0.0;
        if (scores.isEmpty()){
            return 0.0;
        }
        for (GameEntry entry : scores){
            soma += entry.getScore();
        }
        return soma/scores.size();
    }

}
