
public class Attendee {
	private String name;
	private int numDur;
	private boolean spendMoney;
	private double priceLimit;
	private int fieldNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumDur() {
		return numDur;
	}
	public void setNumDur(int numDur) {
		this.numDur = numDur;
	}
	public boolean isSpendMoney() {
		return spendMoney;
	}
	public void setSpendMoney(boolean spendMoney) {
		this.spendMoney = spendMoney;
	}
	public double getPriceLimit() {
		return priceLimit;
	}
	public void setPriceLimit(double priceLimit) {
		this.priceLimit = priceLimit;
	}
	public int getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(int fieldNum) {
		this.fieldNum = fieldNum;
	}
	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	private String[] fields;
}
