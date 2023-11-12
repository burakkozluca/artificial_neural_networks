package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class main {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("is tecrubesi: ");
		double isTecrubesi = in.nextDouble();
		System.out.print("yas: ");
		double yas = in.nextDouble();
		try {
			ParcaSayisi parcasayisi = new ParcaSayisi(yas, isTecrubesi);
			var kurallar = parcasayisi.getModel().getFunctionBlock("Sirket").getFuzzyRuleBlock("kuralblok1").getRules();
			for (var kural : kurallar) {
				if(kural.getDegreeOfSupport() > 0) {
					System.out.print(kural);
				}
			}
			//System.out.print(parcasayisi);
			//JFuzzyChart.get().chart(makine.getModel());
			JFuzzyChart.get().chart(parcasayisi.getModel().getVariable("parcaSayisi"), true);
			JFuzzyChart.get().chart(parcasayisi.getModel().getVariable("parcaSayisi").getDefuzzifier(),"ParcaSayisi", true);
		}
		catch (Exception e) {
			System.out.print("There is a Problem");
		}
	}
}
