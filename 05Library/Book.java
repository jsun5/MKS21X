public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book() {};
    
    public Book(String a, String t, String I){
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

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String a){
	author = a;
    }

    public void setTitle(String t){
	title = t;
    }

    public void setISBN(String I){
	ISBN = I;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}
