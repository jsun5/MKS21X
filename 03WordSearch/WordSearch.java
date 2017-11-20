import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;

    public WordSearch(int rows,int cols){
        data = new char[rows][cols];
        clear();
    }

    public WordSearch(int rows, int cols, String fileName) {
        data = new char[rows][cols];
        clear();            
        int seed = (int)(Math.random()*100000);
        System.out.println("This is your seed: "+seed);
        randgen = new Random(seed);
        wordsToAdd = new ArrayList<String>();
        wordsAdded = new ArrayList<String>();
        try{
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while(in.hasNext()){
                String word = in.next().toUpperCase();
                wordsToAdd.add(word);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            //e.printStackTrace():
            System.exit(1);
        }
        addAllWords();
    }

    public WordSearch(int rows, int cols, String fileName, int  randSeed) {
      //  this(rows, cols, fileName);
      //  randgen = new Random(1);       calling other constructor didnt work :((
        data = new char[rows][cols];
        clear();
        randgen = new Random(randSeed);
        wordsToAdd = new ArrayList<String>();
        wordsAdded = new ArrayList<String>();    
        try{
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while(in.hasNext()){
                String word = in.next().toUpperCase();
                wordsToAdd.add(word);  
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            //e.printStackTrace():
            System.exit(1);
        }
        addAllWords();
    }

    private void clear(){
        for (int i = 0; i < data.length; i++) {
            for (int ind = 0; ind < data[i].length; ind++) {
                data[i][ind] = '_';
            }
        }
    }

    public String toString(){
        String grid = "\n";
        for (int i = 0; i < data.length; i++) {
            for (int ind = 0; ind < data[i].length; ind++) {
                grid += data[i][ind] + " ";
            }
            grid += "\n";
        }
        return grid;
    }

    public boolean addWordHorizontal(String word,int row, int col){
        if ((col + word.length()) > data[row].length) {
            System.out.println("Column out of range");
            return false;
        }
        int letter = 0;
        for (int c = col; c < col + word.length(); c++) {
            if (data[row][c] != word.charAt(letter) && data[row][c] != '_') {
                System.out.println("Word cannot be overwritten");
                return false;
            }
            letter ++;
        }
        letter = 0;
        for (int c = col; c < col + word.length(); c++) {
            data[row][c] = word.charAt(letter);
            letter ++;
        }
        System.out.println("Congrats you added word " + word);
        return true;
    }

    public boolean addWordVertical(String word,int row, int col){
        if ((row + word.length()) > data.length) {
            System.out.println("Row out of range");
            return false;
        }
        int letter = 0;
        for (int r = row; r < row + word.length(); r++) {
            if (data[r][col] != word.charAt(letter) && data[r][col] != '_') {
                System.out.println("Word cannot be overwritten");
                return false;
            }
            letter ++;
        }
        letter = 0;
        for (int r = row; r < row + word.length(); r++) {
            data[r][col] = word.charAt(letter);
            letter ++;
        }
        System.out.println("Congrats you added word " + word);
        return true;
    }
    
    public boolean addWordDiagonal(String word,int row, int col){
        if (col + word.length() > data[row].length || row + word.length() > data.length) {
            System.out.println("Out of range");
            return false;
        }
        int letter = 0;
        int c = col;
        for (int r = row; r < row + word.length(); r++) {
            if (data[r][c] != word.charAt(letter) && data[r][c] != '_') {
                System.out.println("Word cannot be overwritten");
                return false;
            }
            letter ++;
            c++;
        }
        letter = 0;
        c = col;
        for (int r = row; r < row + word.length(); r++) {
            data[r][c] = word.charAt(letter);
            letter ++;
            c++;
        }
        System.out.println("Congrats you added word " + word);
        return true;
    }

    private boolean addWord( int row, int col, String word, int rowInc, int colInc) {
        if (rowInc == 0 && colInc == 0) {
            return false;
        }
        int r = row;
        int c = col;
        for (int letter = 0; letter < word.length(); letter ++) {
        if (r >= data.length || r < 0 || c >= data[0].length || c < 0) {
                //System.out.println("Word out of range");
                return false;
            }
            if (data[r][c] != word.charAt(letter) && data[r][c] != '_') {
                //System.out.println("Word cannot be overwritten");
                return false;
            }
            r += rowInc;
            c += colInc;
        }
        r = row;
        c = col;
        for (int letter = 0; letter < word.length(); letter ++) {
            data[r][c] = word.charAt(letter);
            r += rowInc;
            c += colInc;
        }
        wordsToAdd.remove(word);
        wordsAdded.add(word);
        return true;
    }
    
    private boolean addAllWords() {
        int tries = 0;
        while (wordsToAdd.size() != 0 && tries < 1000) {
            addWord(randgen.nextInt(data.length ), randgen.nextInt(data[0].length), wordsToAdd.get(randgen.nextInt(wordsToAdd.size())), randgen.nextInt(3) - 1, randgen.nextInt(3) - 1 );
            tries++;
        }
        return tries < 1000;
    }
    
    
    /////////////////11/13/17///////////////////
    private boolean fillIn() {
        for (int i= 0; i < data.length; i++) {
            for (int ind = 0; ind < data[i].length; ind++) {
                if (data[i][ind] == '_') {
                    data[i][ind] = (char)(randgen.nextInt(26) + 65);
                }
            }
        }
        return true;
    }
    
    private String wordBox() {
        String box = "";
        for (int i = 0; i < wordsAdded.size(); i++) {
            if (i % 3 == 0) {
                box += "\n";
            }
            box += wordsAdded.get(i) + "     ";
        }
        return box;
    }
    ////////////////////////////////////////////
    
    public static void main(String[] args) {
        try{
            if (args.length == 0) {
                System.out.println(
                    "Please include more terminal arguments, in the following order: \n    row dimension, column dimension, txt file name. \nOptional:\n    input seed for a repeat puzzle, 'key' for the answer key. \nFormat: [int int String [int [key]]]"
                );
            }
            if (args.length == 3) {
                WordSearch test = new WordSearch (Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
                test.fillIn();
                System.out.println(test + test.wordBox()); 
            }
            if (args.length == 4) {
                WordSearch test = new WordSearch (Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
                test.fillIn();
                System.out.println(test + test.wordBox());
            }
            if (args.length == 5) {
                if (args[4].equals("key")) {
                    WordSearch test = new WordSearch (Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
                    System.out.println(test);
                }
                else {
                    WordSearch test = new WordSearch (Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
                    test.fillIn();
                    System.out.println(test + test.wordBox());
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Please follow the correct format (int int String int key)");
        }
    }
}