package cop2805.server;

import cop2805.helper.Bits;
import cop2805.helper.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldSearcher {
    private final FileReader fileReader;
    private final List<String> list;
    public WorldSearcher() {
        fileReader = new FileReader("hamlet.txt");
        this.list = fileReader.getList();
    }
    public List<Integer> search(String word) {
        List<Integer> linesNumbers = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).toUpperCase().contains(word)) {
                linesNumbers.add(i + 1);
            }
        }
        return linesNumbers;
    }
    public HashMap<Integer, String> getLines(List<Integer> lineNumbers) {
        HashMap<Integer, String> map = new HashMap<>();
        for (Integer number : lineNumbers) {
            String quote = fileReader.getList().get(number - 1)
                    .replace(',', (char) Bits.COMMA);
            map.put(number, quote.trim());
        }
        return map;
    }

}
