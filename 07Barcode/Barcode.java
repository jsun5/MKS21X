public class Barcode implements Comparable<Barcode> {
    private String zip;
    private String code;
    private static String[] key = { "||:::",
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
	if (zip.length() != 5) {
	      	throw new IllegalArgumentException("Please enter zip 5 digits in length");
	}
	for (int i = 0; i < zip.length(); i++) {
	    if ( (int)zip.charAt(i) - '0' < 0 || (int)zip.charAt(i) - '0' > 9) {
		throw new IllegalArgumentException("Please enter zip with only numberical values");
	    }
	}	
	this.zip = zip;
	code = toCode(zip);
    }

    public static String toCode (String zip) {
	    
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
        if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException("code formatting error");
        }
	code = code.substring(1,32);
	String zip = "";
	int check = 0;
	int checkSum = 0;
	for (int i = 0; i < 30; i += 5) {
	    for (int keyI = 0; keyI < 10; keyI ++) {
	        if (code.substring(i, i + 5).equals( key[keyI])) {
		    if (i < 25) {
			zip += keyI;
			check += keyI;
		    }
		    else {
			checkSum = keyI;
		    }
	        }
	    }
	}
	if (zip.length() < 5) {
	    throw new IllegalArgumentException("digit sequence incorrect or non-barcode characters used");
	}
      	if (checkSum != check % 10) {
	    throw new IllegalArgumentException("checkSum is invalid");
	}
	return zip;
    }
	       	
    public String getZip(){
	return zip;
    }

    public String getCode(){
	return code;
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
}
	
	    
	
	
	
