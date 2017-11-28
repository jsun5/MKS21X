public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String a, String t, String I, String c){
	setAuthor(a);
	setTitle(t);
	setISBN(I);
	callNumber = c;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String c){
	callNumber = c;
    }

    public abstract void checkout(String patron, String due);

    public abstract void returned();

    public abstract String circulationStatus();

  
}
