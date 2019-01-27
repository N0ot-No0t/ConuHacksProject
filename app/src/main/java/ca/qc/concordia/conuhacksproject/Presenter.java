
public class Presenter {
	private String name;
	private int numPres; //how many presentations user wants to give. This could be consecutive or separate sessions.
	private boolean consecutivePres; //are the presentations consecutive?
	private int numDur; //The duration of a single presentation (minutes)
	private int numSeats; //How many attendees can the presenter handle?
	
	private boolean spendMoney; //Does the presenter think attendees will need gear/platform?
	private int gearNum; //how much gear does the presenter need?
	private String[] gearName; //What are the names of the gear that that the presenter.
	private double[] gearPrice;
	
	private int fieldNum; //how many fields does the presenter's presentation relate to? 
	//Science, Arts, Astronomy, etc
	private String[] fieldName; //type of field it's related to.
	
	public Presenter() {
		name="Default";
		numPres=1;
		consecutivePres=false;
		numDur=60;
		numSeats=10;
		
		spendMoney=false;
		gearNum=0;
		
		fieldNum=1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumPres() {
		return numPres;
	}
	public void setNumPres(int numPres) {
		this.numPres = numPres;
	}
	public boolean isConsecutivePres() {
		return consecutivePres;
	}
	public void setConsecutivePres(boolean consecutivePres) {
		this.consecutivePres = consecutivePres;
	}
	public int getNumDur() {
		return numDur;
	}
	public void setNumDur(int numDur) {
		this.numDur = numDur;
	}
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public boolean isSpendMoney() {
		return spendMoney;
	}
	public void setSpendMoney(boolean spendMoney) {
		this.spendMoney = spendMoney;
	}
	public int getGearNum() {
		return gearNum;
	}
	public void setGearNum(int gearNum) {
		this.gearNum = gearNum;
	}
	public String[] getGearName() {
		return gearName;
	}
	public void setGearName(String[] gearName) {
		this.gearName = gearName;
	}
	public double[] getGearPrice() {
		return gearPrice;
	}
	public void setGearPrice(double[] gearPrice) {
		this.gearPrice = gearPrice;
	}
	public int getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(int fieldNum) {
		this.fieldNum = fieldNum;
	}
	public String[] getFieldName() {
		return fieldName;
	}
	public void setFieldName(String[] fieldName) {
		this.fieldName = fieldName;
	}
	
	
	
}
