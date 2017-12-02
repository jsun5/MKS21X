public class Barcode {
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
	    code += key[(int)zip.charAt(i)];
	    check += (int)zip.charAt(i);
	}
	return code + key[check];
    }
}
	
	
	    
	
	
	
