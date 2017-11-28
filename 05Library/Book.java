public class Book{
    private String author;
    private String title;
    private int ISBN;

    public Book() {};
    
    public Book(String a, String t, int I){
	author = a;
	title = t;
	ISBN = I;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public int getISBN(){
	return ISBN;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}
