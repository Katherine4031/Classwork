package introduction;

public class DataTypes {

	public static void main(String[] args) {
		
		System.out.println(5.0/2); //returns 2.5 because 5.0 is a double
		System.out.println((double)5/2); //returns 2.5 because 5 becomes 5.0
		System.out.println(5/2); //returns 2 because both values are int
		System.out.println(3+5.0/2+5*2); //returns 15.5
		System.out.println(3.0+5/2+5*2); //returns 15.0
		System.out.println((int)(3.0 + 5)/(2 + 5 * 2)); //returns 0 because 8/12 = 0
		if(42 == 42.0) System.out.println("42 equals 42.0"); // it prints but why?
		
		double d1 = 4.64;
		double d2 = 2.0;
		double d3 = 2.64;
		System.out.println("d1 : " + d1);
		System.out.println("d2 : " + d2);
		System.out.println("d3 : " + d3);
		System.out.println("d1 - d2 : " + (d1 - d2)); //returns 2.6399999999999997
		
		//String s = 1;
		//System.out.println(s); //will not compile because 1 is an int
		
		//String s = (String)1;
		//System.out.println(s); //will not compile because 1 is an int
		
		String a = "1";
		System.out.println(a); //returns 1
		
		String b = ""+1;
		System.out.println(b); //returns 1 because "" assume value of 0?

		String c = "Happy "+18+"th birthday!";
		System.out.println(c); //returns string because concat?

		String d = "Happy 18th birthday!";
		System.out.println(d); //returns string because list of char?

		String e = "Happy "+54/3+"th birthday!";
		System.out.println(e); //returns string because 54/3 = int 18?

		String f = "Happy "+(54/3)+"th birthday!";
		System.out.println(f); //returns same string as above () don't change the order?

		int m = 22;
		int n = 7;
		System.out.println("m/n is "+(m/n)); // returns m/n is 3 because both values are int

		int o = 22;
		int p = 7;
		System.out.println("m/n is "+((double)o/p)); //returns m/n is 3.142857142857143 because m becomes double
		
		String ten = "10";
		String two = "2";
		if(ten.compareTo(two) > 0) System.out.print("10 is not greater than two"); //returns print
		
	}

}
