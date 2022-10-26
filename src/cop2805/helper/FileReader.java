package cop2805.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    Path filePath;
    List<String> list;
    public FileReader(String path) {
        filePath = Paths.get(path);
        read();
    }
    private void read() {
        this.list = new ArrayList<>();
        try(BufferedReader bufferedReader =
            Files.newBufferedReader(this.filePath, Charset.defaultCharset())
        ) {
            String line = bufferedReader.readLine();
            while (line != null) {
                this.list.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return this.list;
    }
}
