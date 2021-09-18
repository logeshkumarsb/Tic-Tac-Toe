package javaprogram;

public class Player {

private String Name;
private char Symbol;
 public Player(String Name,char Symbol) {
	 setName(Name);
	 setSymbol(Symbol);
 }
public void setName(String Name) {
	if(!Name.isEmpty()) {
		this.Name=Name;
	}
}
public String getName() {
	return Name;
}
public void setSymbol(char Symbol) {
	if(Symbol!='\0') {
		this.Symbol=Symbol;
	}
}
public char getSymbol() {
	return Symbol;
}
 
}
