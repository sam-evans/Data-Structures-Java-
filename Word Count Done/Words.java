
public class Words {
	private String Word;
	private int Count;
	public Words(String w, int c) {
		Word = w;
		Count = c;
	}
	public void setWord(String newWord){
		this.Word = newWord;
	}
	public String getWord(){
		return Word;
	}
	public void setCount(int newCount){
		this.Count = newCount;
	}
	public int getCount(){
		return Count;
	}
}
