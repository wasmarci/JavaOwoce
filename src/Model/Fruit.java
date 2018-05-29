package Model;

public class Fruit {
	private String foto;
	private String name;
	private boolean chosen;
	
	public Fruit(String f, String n) {
		foto = f;
		name = n;
		chosen = false;
	}
	
	public String getFoto() {
		return foto;
	} 
	
	public String getName() {
		return name;
	}
	
	public Boolean getChosen() {
		return chosen;
	}
	
	public void setChosen(boolean c) {
		chosen = c; 
	}
}
