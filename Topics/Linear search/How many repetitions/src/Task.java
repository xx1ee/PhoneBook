// write your code here 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("C:\\Users\\Sveta\\IdeaProjects\\Phone Book\\Topics\\Linear search\\How many repetitions\\data\\dataset\\input.txt"));
    LinkedList<String> mass = new LinkedList<>();
    int sum = 0;
    while(scanner.hasNext()){
      mass.add(scanner.next());
    }
    for (int i = 1; i < mass.size() ; i++) {
      if (mass.get(1).equals(mass.get(i))) {
        sum++;
      }
    }
    System.out.println(sum);
  }
}
