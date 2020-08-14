package data;

public class Person
{
	private String name;
	private String surname;
	private String birthPlace;
	private String birthCountry;
	private String birthDate;
	private char sex;
	
	public Person(String name, String surname, String birthPlace, String birthCountry, String birthDate, char sex)
	{
		this.name = name;
		this.surname = surname;
		this.birthPlace = birthPlace;
		this.birthCountry = birthCountry;
		this.birthDate = birthDate;
		this.sex = sex;
	}
	
	public String getName() {return name;}
	public String getSurname() {return surname;}
	public String getBirthPlace() {return birthPlace;}
	public String getBirthCountry() {return birthCountry;}
	public String getBirthDate() {return birthDate;}
	public char getSex() {return sex;}
	
	public String getBirthDay()
	{
		return birthDate.split("-")[0];
	}
	
	public String getBirthMonth()
	{
		return birthDate.split("-")[1];
	}
	
	public String getBirthYear()
	{
		return birthDate.split("-")[2];
	}
	
	public void setName(String name) {this.name = name;}
	public void setSurname(String surname) {this.surname = surname;}
	public void setBirthPlace(String birthPlace) {this.birthPlace = birthPlace;}
	public void setBirthCountry(String birthCountry) {this.birthCountry = birthCountry;}
	public void setBirthDate(String birthDate) {this.birthDate = birthDate;}
	public void setSex(char sex) {this.sex = sex;}

}
