package be.vdab.tasks;

public class Woord {
	private String woord;
	
	public Woord(String woord){
		this.woord = woord;
	}
	
	public boolean isPalindroom(){
		String omgekeerdWoord = new StringBuilder(woord).reverse().toString();
		return woord.equals(omgekeerdWoord);
	}
}
