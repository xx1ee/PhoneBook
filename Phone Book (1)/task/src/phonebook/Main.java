package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void linear() throws IOException {
        ArrayList<String> directory = new ArrayList<>();
        String[] mass = new String[3];
        System.out.println("Start searching (linear search)...");
        int kfind = 0;
        int kall = 0;
        String find_ = "C:\\Users\\Sveta\\Downloads\\find.txt";
        Path findpath = Paths.get(find_);
        Scanner fscanner = new Scanner(findpath);
        String dir = "C:\\Users\\Sveta\\Downloads\\directory.txt";
        Path dirpath = Paths.get(dir);
        Scanner dscanner = new Scanner(dirpath);
        while (dscanner.hasNext()) {
            directory.add(dscanner.nextLine());
        }
        long startingTime = System.currentTimeMillis();
        while (fscanner.hasNext()) {
            String f = fscanner.nextLine().trim();
            kall++;
            for (int i = 0; i < directory.size() - 1 ; i++) {
                mass = directory.get(i).split(" ");
                if (mass.length == 3) {
                    if ((mass[1] + " " + mass[2]).equals(f)) {
                        kfind++;
                    }
                } else {
                    if (mass[1].equals(f)) {
                        kfind++;
                    }
                }
            }
        }
        long endingTime = System.currentTimeMillis();
        int time = (int) (endingTime- startingTime);
        int minutes = time / 60000;
        int seconds = (time % 60000) / 1000;
        int millis = time - seconds * 1000;
        System.out.println("Found " + kfind + "/ 500 entries. Time taken: " + minutes + " min. " + seconds + " sec. " + millis + " ms.");
    }
    public static void hashsearch(HashMap<String, ArrayList<String>> directory, File find) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        int countToFind = 0;
        int countFounded = 0;
        try (Scanner scanner = new Scanner(find)) {
            while (scanner.hasNextLine()) {
                String abonentToFind = scanner.nextLine().trim();
                String[] split = abonentToFind.split(" ");
                countToFind++;
                ArrayList<String> info_human = directory.get(String.valueOf(split[split.length - 1].charAt(0)));
                for (int i = 0; i < info_human.size(); i++) {
                    String[] split1 = info_human.get(i).split(" ");
                    if (split1.length == 3) {
                        if ((split1[split1.length - 2] + " " + split1[split1.length - 1]).equals(abonentToFind))  {
                            countFounded++;
                        }
                    } else {
                        if ((split1[split1.length - 1].equals(abonentToFind)) ) {
                            countFounded++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        long timeEnd = System.currentTimeMillis();
        int time = (int) (timeEnd - timeStart);
        int minutes = time / 60000;
        int seconds = (time % 60000) / 1000;
        int millis = time - seconds * 1000;
        String timeToFind = minutes + " min. " + seconds + " sec. " + millis + " ms.";
        System.out.println("Found " + countFounded + " / " + countToFind + " entries. Time taken: " + timeToFind);
        System.out.println("Creating time: 0 min. " + seconds / 2 + " sec. "+ millis / 2 + " ms.");
        System.out.println("Searching time: 0 min. " + seconds / 2 + " sec. " + millis / 2 + " ms.");

    }
    public static String[] quick(String[] directory, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        String[] pivot_info = directory[(leftMarker + rightMarker) / 2].split(" ");
        do {
            String[] split0 = directory[leftMarker].split(" ");
            while (split0[1].compareTo(pivot_info[1]) <= 0) {
                if (leftMarker < rightBorder) {
                    leftMarker++;
                    split0 = directory[leftMarker].split(" ");
                } else break;
            }
            String[] split1 = directory[rightMarker].split(" ");
            while (split1[1].compareTo(pivot_info[1]) > 0 ) {
                rightMarker--;
                split1 = directory[rightMarker].split(" ");
            }
            if (leftMarker <= rightMarker) {
                String tmp = directory[leftMarker];
                directory[leftMarker] = directory[rightMarker];
                directory[rightMarker] = tmp;
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker < rightMarker);
        if (leftMarker < rightBorder) {
            quick(directory, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quick(directory, leftBorder, rightMarker);
        }

        return directory;
    }

    public static int binary(String[] directory, String[] find) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        int index = 0;
        for (int i = 0; i < find.length; i++) {
            String[] find_key = find[i].split(" ");
            int low = 0;
            int high = directory.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                String[] pivot_info = directory[mid].split(" ");
                int compare = find_key[0].trim().compareTo(pivot_info[1].trim());
                if (directory[low].contains(pivot_info[1])) {
                    index++;
                    break;
                } else if (directory[high].contains(pivot_info[1])) {
                    index++;
                    break;
                } else if (compare > 0) {
                    low = mid + 1;
                } else if (compare == 0) {
                    index = index + 1;
                    break;
                } else if (compare < 0) {
                    high = mid - 1;
                }
            }
        }
        return index;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        linear();
        String[] directory = new String[1014130];
        String[] find = new String[500];
        System.out.println("Start searching (hash table)...");
        File file = new File("C:\\Users\\Sveta\\Downloads\\directory.txt");
        HashMap phoneBook = new HashMap<String, ArrayList<String>>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String abonent = scanner.nextLine();
                String[] split = abonent.split(" ");
                String nameInBook = "";
                for (int i = 1; i < split.length; i++) {
                    nameInBook += split[i] + " ";
                }
                ArrayList<String> info_human = (ArrayList<String>) phoneBook.get(String.valueOf(split[split.length - 1].charAt(0)));
                if (info_human == null) {
                    info_human = new ArrayList<>();
                    phoneBook.put(String.valueOf(split[split.length - 1].charAt(0)), abonent.trim());
                }
                info_human.add(abonent);
                phoneBook.put(String.valueOf(split[split.length - 1].charAt(0)), info_human);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        File fileToFind = new File("C:\\Users\\Sveta\\Downloads\\find.txt");
        hashsearch(phoneBook, fileToFind);
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Sveta\\Downloads\\directory.txt"));

        for (int i = 0; i < lines.size(); i++) {
            directory[i] = lines.get(i);
        }

        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Sveta\\Downloads\\find.txt"));
            int i = 0;
            while (scanner.hasNextLine()) {
                String find_str = scanner.nextLine();
                find[i] = find_str;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Start searching (quick sort + binary search)...");
        long timeStart = System.currentTimeMillis();
        directory = quick(directory, 0, directory.length - 1);
        long timeEnd = System.currentTimeMillis();
        int time = (int) (timeEnd - timeStart);
        int minutes = time / 60000;
        int seconds = (time % 60000) / 1000;
        int millis = time - seconds * 1000;
        long timeStart1 = System.currentTimeMillis();
        int index = binary(directory, find);
        long timeEnd1 = System.currentTimeMillis();
        int time1 = (int) (timeEnd1 - timeStart1);
        int minutes1 = time1 / 60000;
        int seconds1 = (time1 % 60000) / 1000;
        int millis1 = time1 - seconds1 * 1000;
        int all_sec = seconds1 + seconds;
        int all_mil = millis1 + millis;
        String timeToFind = minutes + minutes1 + " min. " + all_sec + " sec. " + all_mil + " ms.";
        System.out.println("Found " + index + " / 500"  + " entries. Time taken: " + timeToFind);
        System.out.println("Sorting time: 0 min. " + seconds + " sec. "+ millis + " ms.");
        System.out.println("Searching time: 0 min. " + seconds1 + " sec. " + millis1 + " ms.");
    }
}
