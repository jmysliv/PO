import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data){
        try{
            PrintWriter file = new PrintWriter(filename);
            file.print(data);
            file.close();
        } catch(FileNotFoundException ignored){
        }

    }

    @Override
    public String readData(){
        try{
            String content = Files.readString(Paths.get(filename), StandardCharsets.US_ASCII);
            return content;
        }catch(IOException ignored){
            return null;
        }
    }
}
