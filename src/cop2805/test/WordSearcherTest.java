package cop2805.test;


import cop2805.helper.Bits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import cop2805.server.WorldSearcher;



public class WordSearcherTest {
    WorldSearcher worldSearcher;
    @BeforeEach
    void setup() {
        this.worldSearcher = new WorldSearcher();
    }
    @Test
    void pyrrhusShouldReturnAnIntegerList() {
        List<Integer> results =new ArrayList<>(Arrays.asList(1668,1670,1672,
                1683,1694,1699,1702,1709,1713,1739));
        assertEquals(results, this.worldSearcher.search("Pyrrhus"));
    }
    @Test
    void ShouldReturnAnIntegerListWithOneValue() {
        List<Integer> results = new ArrayList<>(Collections.singletonList(1641));
        assertEquals(results, this.worldSearcher
                .search("Enter four or five Players."));
    }

    @Test
    void shouldReturnAnEmptyList() {
        List<Integer> results = new ArrayList<>();
        assertEquals(results, this.worldSearcher.search("Hello"));
    }

    @Test
    void shouldReturnHashMapWithTwoValues() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(81, ("  Hor. A piece of him.").trim());
        map.put(1648, ("    altitude of a chopine. Pray God your voice, like a piece of")
                .replace(',', (char) Bits.COMMA).trim());
        assertEquals(map, this.worldSearcher
                .getLines(this.worldSearcher.search("A piece of")));
    }

    @Test
    void shouldReturnHashMapWithOneValue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1641, ("                     Enter four or five Players.").trim());
        assertEquals(map, this.worldSearcher
                .getLines(this.worldSearcher.search("Enter four or five Players.")));
    }
}
