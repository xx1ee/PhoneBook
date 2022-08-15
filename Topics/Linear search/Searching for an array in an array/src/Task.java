// write your code here 

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("C:\\Users\\Sveta\\IdeaProjects\\Phone Book\\Topics\\Linear search\\Searching for an array in an array\\data\\sample\\input.txt"));
    LinkedList <String> mass = new LinkedList<>();
    int sum = 0;
    while(scanner.hasNext()){
      mass.add(scanner.next());
    }
    for (int i = 0; i < mass.size() / 2 ; i++) {
      for (int j = mass.size() / 2 ; j < mass.size(); j++) {
        sum++;
        if (mass.get(i).equals(mass.get(j))) {
          break;
        }
      }
    }
    System.out.println(sum);
  }
}
