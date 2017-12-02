public class Barcode implements Comparable<Barcode> {
    private String zip;
    private String[] key = { "||:::",
			     ":::||",
			     "::|:|",
			     "::||:",
			     ":|::|",
			     ":|:|:",
			     ":||::",
			     "|:::|",
			     "|::|:",
			     "|:|::"  };
    
    public Barcode(String zip) {
	this.zip = zip;
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	String code = "";
	int check = 0;
	for (int i = 0; i < zip.length(); i ++) {
	    code += key[(int)zip.charAt(i) - '0'];
	    check += (int)zip.charAt(i) - '0';
	}
	return code + key[check % 10];
    }

    public String toString(){
	return "|" + getCode() + "| (" + getZip() + ")";
    }

    public int compareTo (Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public boolean equals (Barcode other){
	return getZip() == other.getZip();
    }


    ////////////// TESTING /////////////////
    public static void main(String[] args) {
	System.out.println( (int) '9' - '0');
	Barcode test = new Barcode ("00000");
	System.out.println (test); // "|||:::||:::||:::||:::||:::||:::| (00000)"
	Barcode test2 = new Barcode ("08451");
	System.out.println (test2); // "|||:::|::|::|::|:|:|::::|||::|:| (08451)"
    }
}
	
	
	    
	
	
	
