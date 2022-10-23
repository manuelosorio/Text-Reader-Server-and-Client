package cop2805.server;

import cop2805.helper.FileReader;

import java.util.List;

public class WorldSearcher {
    private final List<String> list;
    public WorldSearcher() {
        FileReader fileReader = new FileReader("hamlet.txt");
        this.list = fileReader.getList();
    }
    public List<Integer> search(String word) {
        List<Integer> linesNumbers = new java.util.ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).contains(word.toUpperCase())) {
                linesNumbers.add(i + 1);
            }
        }
        return linesNumbers;
    }
}
