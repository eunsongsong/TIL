package chap07.class2.statics;

public class MyCount {
	private int serialNumber;
	private static int counter;
	
	public MyCount() {
		serialNumber++;
		counter++;
		System.out.println("¾å! serialNumber: "+serialNumber+" counter : "+counter);
	}
	
	public int getSerialNumber() {
		return this.serialNumber;
	}
	
	public static int getCounter() {
		return counter;
	}
}
