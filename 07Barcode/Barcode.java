public class Barcode implements Comparable<Barcode> {
    private String zip;
    
    public Barcode(String zip) {
	if (zip.length() != 5) {
	      	throw new IllegalArgumentException("Please enter zip 5 digits in length");
	}
	for (int i = 0; i < zip.length(); i++) {
	    if ( (int)zip.charAt(i) - '0' < 0 || (int)zip.charAt(i) - '0' > 9) {
		throw new IllegalArgumentException("Please enter zip with only numberical values");
	    }
	}	
	this.zip = zip;
    }

    public static String toCode (String zip) {
	    String[] key = { "||:::",
			     ":::||",
			     "::|:|",
			     "::||:",
			     ":|::|",
			     ":|:|:",
			     ":||::",
			     "|:::|",
			     "|::|:",
			     "|:|::"  };
	    
      	if (zip.length() != 5) { //same throws as constructor
	      	throw new IllegalArgumentException("Please enter zip 5 digits in length");
	}
	for (int i = 0; i < zip.length(); i++) {
	    if ( (int)zip.charAt(i) - '0' < 0 || (int)zip.charAt(i) - '0' > 9) {
		throw new IllegalArgumentException("Please enter zip with only numberical values");
	    }
	}	

	String code = "";
	int check = 0;
	for (int i = 0; i < 5; i ++) {
	    code += key[(int)zip.charAt(i) - '0'];
	    check += (int)zip.charAt(i) - '0';
	}
	return "|" + code + key[check % 10] + "|";
    }

    public static String toZip (String code) {
		    String[] key = { "||:::",
			     ":::||",
			     "::|:|",
			     "::||:",
			     ":|::|",
			     ":|:|:",
			     ":||::",
			     "|:::|",
			     "|::|:",
			     "|:|::"  };
		    if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
			throw new IllegalArgumentException("code formatting error");
		    }
	code = code.substring(1,32);
	String zip = "";
	for (int i = 0; i < 25; i += 5) {
	    for (int keyI = 0; keyI < 10; keyI ++) {
		if (keyI == 10) {
		    throw new IllegalArgumentException("Digit sequence or character at line " + i + " to " + (i + 5 + " is invalid"));
		}
	        if (code.substring(i, i + 5).equals( key[keyI])) {
		    zip += keyI;
	        }
	    }
	}
	return zip;
    }
		

	
    public String getZip(){
	return zip;
    }

    public String getCode(){
	return toCode(zip);
    }

    public String toString(){
	return getCode() + " (" + getZip() + ")";
    }

    public int compareTo (Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public boolean equals (Barcode other){
	return getZip() == other.getZip();
    }


    ////////////// TESTING /////////////////
    public static void main(String[] args) {
	System.out.println( (int) '9' - '0');// 9
	Barcode test = new Barcode ("00000");
	System.out.println (test); // "|||:::||:::||:::||:::||:::||:::| (00000)"
	System.out.println (toCode("00000"));
	Barcode test2 = new Barcode ("08451");
	System.out.println (test2); // "|||:::|::|::|::|:|:|::::|||::|:| (08451)"
	//Barcode error = new Barcode ("1234567"); 
	//System.out.println (error); // need 5 digits
	//Barcode error2 = new Barcode ("1a^?>");
	//System.out.println (error2); //need numbers
	System.out.println (toZip("|||:::||:::||:::||:::||:::||:::|"));
	System.out.println (toZip("|||:::|::|::|::|:|:|::::|||::|:|"));	

    }
}
	
	
	    
	
	
	
