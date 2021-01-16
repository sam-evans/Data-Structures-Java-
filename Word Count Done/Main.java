import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\report.txt");
		PrintWriter output = new PrintWriter(fw);
		Scanner sf = new Scanner(new File("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\captmid.txt"));
		//floats to calculate a percentage
		float totWords= 0;
		float uniWords = 0;
		
		
		List<Words> ListOfWords = new List<Words>();
		//read file
		
		while(sf.hasNext()) {
			String s = sf.next();
			//splits blank space characters
			String[] str = s.split("[,.;:?!]");
			String w = str[0];
			//increment total words
			totWords++;
			//defines unique words
			if(w.length() > 4) {
				int c = 1;
				Words word = new Words(w,c);
				uniWords++;
				
				if(ListOfWords.IsEmpty())
					ListOfWords.InsertAfter(word);
				else
					ListOfWords.First();
				//runs through linked list and increments counter of a word when repeated
				for(int j = 0; j < ListOfWords.GetSize(); j++) {
					
					if(word.getWord().equals(ListOfWords.GetValue().getWord())) {
						
						word.setCount(c += 1);
						//ListOfWords.Prev();
						ListOfWords.Replace(word);
						ListOfWords.Next();
			
					}
					else
						ListOfWords.Next();
			}
				if(word.getCount() == 1)
					ListOfWords.InsertAfter(word);
			
			
			}
		}
		
		
			
		
			
		//uniqueness ratio
		float a = (uniWords/totWords)*100;
		ListOfWords.First();
		//report file output
		output.println("-----Unique Words-----");
		
		//prints every word in the linked list and it's counter 
		for(int i = 0; i<ListOfWords.GetSize(); i++) {
			//if(ListOfWords.GetValue().getWord().equals(ListOfWords.GetValue().getWord()))
			
			output.println(ListOfWords.GetValue().getWord() + " Count =  " + ListOfWords.GetValue().getCount() );
			ListOfWords.Next();
		
		}
		//prints unique score
		output.println("Unique Report Score---> "+ uniWords + "/" + totWords + " = " + a + "%");
		
		sf.close();
		output.close();
		fw.close();

	}
}


