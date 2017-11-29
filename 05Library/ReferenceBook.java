public class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook(String a, String t, String I, String c, String coll) {
	super(a,t,I,c);
	/*setAuthor(a);
	setTitle(t);
	setISBN(I);
	setCallNumber(c);*/
        collection = coll;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String coll){
	collection = coll;
    }

    public void checkout(String patron, String due){
	throw new UnsupportedOperationException("cannot check out a reference book");
    }

    public void returned() {
	throw new UnsupportedOperationException("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + ", " + getCollection();
    }
}

    
