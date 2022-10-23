package cop2805.test;

import cop2805.server.WorldSearcher;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WorldSearcher worldSearcher = new WorldSearcher();
        while (true) {
            System.out.println("Enter a word to search for: ");
            String word = scan.nextLine();
            if (word.equals("stop searching")) {
                break;
            }
            System.out.println("Searching for " + word);
            System.out.println(worldSearcher.search(word));
        }
    }
}
