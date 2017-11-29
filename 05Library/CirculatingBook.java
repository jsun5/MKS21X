public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String I, String c){
	super(a,t,I,c);
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String cH){
	currentHolder = cH;

    }

    public void setDueDate(String dD){
	dueDate = dD;
    }

    public void checkout (String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned() {
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus(){
	if (getCurrentHolder() == null && getDueDate() == null){
	    return "book available on shelves";
	}
	return "checked out by " + getCurrentHolder() + ", due by " + getDueDate();
    }

    public String toString() {
	if (getCurrentHolder() == null && getDueDate() == null) {
	    return super.toString();
	}
	return super.toString() + ", " +  getCurrentHolder() + ", " + getDueDate();
    }
}
