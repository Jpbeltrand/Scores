import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;


public class ScoresSerializacao extends GameEntry{
    String currDir = Paths.get("").toAbsolutePath().toString();
    private String nomeArquivo = currDir + "\\" + "Entradas.txt";
    Path path = Paths.get(nomeArquivo);
    
    ArrayList<GameEntry> scores = new ArrayList<GameEntry>();

    public ScoresSerializacao(String nomeArquivo,String name, int score, LocalDate date){
        super(name, score, date);
        this.nomeArquivo = nomeArquivo;
       
    }

    public String getNomeArquivo(){
        return nomeArquivo;
    }
      
    public static void salvarScoresCSV(ArrayList<GameEntry> scores, String nomeArquivo) {
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (GameEntry score : scores) {
                bufferedWriter.write(score.getName() + "," + score.getScore() + "\n");
            }
            
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar scores em CSV: " + e.getMessage());
        }
    } 

    public static ArrayList<GameEntry> carregarScoresCSV(String nomeArquivo) {
        ArrayList<GameEntry> scores = new ArrayList<GameEntry>();
        
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                GameEntry score = new GameEntry(fields[0], Integer.parseInt(fields[1]), LocalDate.now());
                scores.add(score);
                line = bufferedReader.readLine();
            }
            
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar scores em CSV: " + e.getMessage());
        }
        
        return scores;
    }
}