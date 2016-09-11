package no.uis.dat630;

public class Person {

	private int age;
	private String workclass;
	private int fnlwgt;
	private String education;
	private int educationNum;
	private String maritalStatus;
	private String occupation;
	private String relationship;
	private String race;
	private String sex;
	private int capitalGain;
	private int capitalLoss;
	private int hoursPerWeek;
	private String nativeCountry;
	private boolean over50K;
	
	public Person () {
		age = 0;
		workclass = null;
		fnlwgt = 0;
		education = null;
		educationNum = 0;
		maritalStatus = null;
		occupation = null;
		relationship = null;
		race = null;
		sex = null;
		capitalGain = 0;
		capitalLoss = 0;
		hoursPerWeek = 0;
		nativeCountry = null;
		over50K = false;
	}
	
	public Person (int age, String workclass, int fnlwgt, String education, int educationNum, String maritalStatus, String occupation, String relationship,
				   String race, String sex, int capitalGain, int capitalLoss, int hoursPerWeek, String nativeCountry, boolean over50K) {
		this.age = age;
		this.workclass = workclass;
		this.fnlwgt = fnlwgt;
		this.education = education;
		this.educationNum = educationNum;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.relationship = relationship;
		this.race = race;
		this.sex = sex;
		this.capitalGain = capitalGain;
		this.capitalLoss = capitalLoss;
		this.hoursPerWeek = hoursPerWeek;
		this.nativeCountry = nativeCountry;
		this.over50K = over50K;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWorkclass() {
		return workclass;
	}

	public void setWorkclass(String workclass) {
		this.workclass = workclass;
	}

	public int getFnlwgt() {
		return fnlwgt;
	}

	public void setFnlwgt(int fnlwgt) {
		this.fnlwgt = fnlwgt;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getEducationNum() {
		return educationNum;
	}

	public void setEducationNum(int educationNum) {
		this.educationNum = educationNum;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getCapitalGain() {
		return capitalGain;
	}

	public void setCapitalGain(int capitalGain) {
		this.capitalGain = capitalGain;
	}

	public int getCapitalLoss() {
		return capitalLoss;
	}

	public void setCapitalLoss(int capitalLoss) {
		this.capitalLoss = capitalLoss;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getNativeCountry() {
		return nativeCountry;
	}

	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public boolean isOver50K() {
		return over50K;
	}

	public void setOver50K(boolean over50k) {
		over50K = over50k;
	}
	
	@Override	
	public String toString() {
		if(isOver50K()) {
			return ">50K";
		} else {
			return "<=50K";
		}
	}
	
}
