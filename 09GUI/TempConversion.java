public class TempConversion{
    public static double CtoF (double t) {
	return t * (9.0 / 5.0 ) + 32;
    }

    public static double FtoC (double t) {
	return (t - 32) * (5.0 / 9.0);
    }

    public static void main(String[]args){
	System.out.println("-40C = " + CtoF(-40.0) + "F"); //-40
 	System.out.println("100C = " + CtoF(100.0) + "F"); //212
 	System.out.println("212F = " + FtoC(212.0) + "C"); //100
    }
}
    
