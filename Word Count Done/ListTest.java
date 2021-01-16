/* *****************************************
 * YOU MAY NOT CHANGE THIS FILE IN ANY WAY!
 ***************************************** */

public class ListTest
{
	public static void main(String[] args)
	{
		List<Integer> a = new List<Integer>();
		List<Integer> b = new List<Integer>();

		System.out.println(" 1 " + a.GetValue());
		System.out.println(" 2 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println(" 3 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		for (int i=1; i<=25; i++)
		{
			a.InsertAfter(i);
			b.InsertBefore(i);
		}
		System.out.println(" 4 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println(" 5 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		List<Integer> c = new List<Integer>(a);
		System.out.println(" 6 c(" + c.GetSize() + "/" + c.GetPos() + ") = " + c);
		a.Remove();
		a.Remove();
		for (int i=0; i<5; i++)
			a.Prev();
		a.Remove();
		a.Remove();
		System.out.println(" 7 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		a.First();
		a.Remove();
		for (int i=0; i<a.GetSize()/2; a.Next(),i++)
		{
			a.Replace(a.GetValue()*5);
			a.Next();
		}
		System.out.println(" 8 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		a.Last();
		a.Next();
		a.Next();
		a.Remove();
		System.out.println(" 9 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		a.SetPos(a.GetSize()*2/3);
		a.Replace(a.GetValue()*12345);
		System.out.println("10 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		a.SetPos(a.GetSize());
		a.Remove();
		System.out.println("11 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		a.SetPos(a.GetSize()-1);
		a.Remove();
		System.out.println("12 a is " + (!a.IsEmpty() ? "not " : "") + "empty");
		System.out.println("13 a is " + (!a.IsFull() ? "not " : "") + "full");
		for (int i=0; i<1000; i++)
			a.InsertBefore(i);
		System.out.println("14 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("15 c(" + c.GetSize() + "/" + c.GetPos() + ") = " + c);
		System.out.println("16 a is " + (!a.IsEmpty() ? "not " : "") + "empty");
		System.out.println("17 a is " + (!a.IsFull() ? "not " : "") + "full");
		List<Integer> d = new List<Integer>(a);
		System.out.println("18 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("19 d(" + d.GetSize() + "/" + d.GetPos() + ") = " + d);
		System.out.println("20 a " + (a.Equals(d) ? "==" : "!=") + " d");
		a.Remove();
		System.out.println("21 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("22 d(" + d.GetSize() + "/" + d.GetPos() + ") = " + d);
		System.out.println("23 a " + (a.Equals(d) ? "==" : "!=") + " d");
		a = new List<Integer>(c);
		c.Remove();
		System.out.println("24 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("25 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		System.out.println("26 c(" + c.GetSize() + "/" + c.GetPos() + ") = " + c);
		System.out.println("27 a " + (a.Equals(c) ? "==" : "!=") + " c");
		List<Integer> e = b.Add(a);
		System.out.println("28 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("29 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		System.out.println("30 e(" + e.GetSize() + "/" + e.GetPos() + ") = " + e);
		for (int i=0; i<1000; i++)
		{
			b.Remove();
			c.Remove();
		}
		System.out.println("31 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("32 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		System.out.println("33 c(" + c.GetSize() + "/" + c.GetPos() + ") = " + c);
		System.out.println("34 e(" + e.GetSize() + "/" + e.GetPos() + ") = " + e);
		List<Integer> f = b.Add(a);
		System.out.println("35 a(" + a.GetSize() + "/" + a.GetPos() + ") = " + a);
		System.out.println("36 b(" + b.GetSize() + "/" + b.GetPos() + ") = " + b);
		System.out.println("37 f(" + f.GetSize() + "/" + f.GetPos() + ") = " + f);

		List<Character> g = new List<Character>();
		for (char i='a'; i<='m'; i++)
		{
			g.InsertAfter(i);
			g.InsertBefore((char)(i+13));
		}
		System.out.println("38 g(" + g.GetSize() + "/" + g.GetPos() + ") = " + g);

		List<Float> h = new List<Float>();
		for (float i=2.71828f; i<=3.14159f; i+=.111f)
			h.InsertAfter(i);
		h.InsertBefore(3.14159f);
		System.out.println("39 h(" + h.GetSize() + "/" + h.GetPos() + ") = " + h);
	}
}