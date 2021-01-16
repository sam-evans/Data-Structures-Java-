
public class Book {
	private String Title;
	private String Name;
	private boolean CheckStat;
	private int Prio;
	
	public Book(String t, String n, boolean c, int p) {
		Title = t;
		Name = n;
		CheckStat = c;
		Prio = p;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getName() {
		return this.Name;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getTitle() {
		return this.Title;
	}
	public void setCheckStat(boolean CheckStat) {
		this.CheckStat = CheckStat;
	}
	public Boolean getCheckStat() {
		return this.CheckStat;
	}
	public void setPrio(int Prio) {
		this.Prio = Prio;
	}
	public int getPrio() {
		return this.Prio;
	}
	public void changeStat(boolean cs) {
		
		if(CheckStat == true) {
			CheckStat = false;
		}
		else
			CheckStat = true;
	
}
	
}
