import java.util.ArrayList;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        ArrayList<GameEntry> scores = new ArrayList<GameEntry>();

        // Carregar scores do arquivo CSV
        ScoresSerializacao carregador = new ScoresSerializacao("Entradas.txt", "", 0, LocalDate.now());
        scores = ScoresSerializacao.carregarScoresCSV(carregador.getNomeArquivo());

        // Salvar scores em formato CSV
        ScoresSerializacao salvador = new ScoresSerializacao("Saidas.txt", "", 0, LocalDate.now());
        ScoresSerializacao.salvarScoresCSV(scores, salvador.getNomeArquivo());
    }

}
    

