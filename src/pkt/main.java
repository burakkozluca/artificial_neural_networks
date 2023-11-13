package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class main {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		double dcinsiyet = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("is tecrubesi: ");
		double isTecrubesi = in.nextDouble();
		System.out.print("yas: ");
		double yas = in.nextDouble();
		System.out.print("Cinsiyet(E|K):");
		String cinsiyet = in.next();
		
		System.out.print(cinsiyet);
		if(cinsiyet.equals("E"))
			dcinsiyet = 0;
		if(cinsiyet.equals("K")) {
			dcinsiyet = 1;
			System.out.print("burak");
		}
			
		try {
			ParcaSayisi parcasayisi = new ParcaSayisi(yas, isTecrubesi, dcinsiyet);
			var kurallar = parcasayisi.getModel().getFunctionBlock("Sirket").getFuzzyRuleBlock("kuralblok1").getRules();
			//for (var kural : kurallar) {
			//	if(kural.getDegreeOfSupport() > 0) {
			//		System.out.print(kural);
			//	}
			//}
			System.out.print(parcasayisi);
			JFuzzyChart.get().chart(parcasayisi.getModel());
			JFuzzyChart.get().chart(parcasayisi.getModel().getVariable("parcaSayisi"), true);
			JFuzzyChart.get().chart(parcasayisi.getModel().getVariable("parcaSayisi").getDefuzzifier(),"ParcaSayisi", true);
		}
		catch (Exception e) {
			System.out.print("There is a Problem");
		}
	}
}
