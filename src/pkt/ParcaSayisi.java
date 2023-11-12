package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class ParcaSayisi {
	private FIS fis;
	private double yas;
	private double isTecrubesi;
	
	public ParcaSayisi(double yas,double isTecrubesi) throws URISyntaxException {
		this.yas = yas;
		this.isTecrubesi = isTecrubesi;
		
		File dosya = new File(getClass().getResource("Sirket.fcl").toURI());
		fis = FIS.load(dosya.getPath());
		fis.setVariable("yas", yas);
		fis.setVariable("isTecrubesi", isTecrubesi);
		fis.evaluate();
	}
	@Override
	public String toString() {
		String output;
		output = "Parca Sayisi: " + Math.round(fis.getVariable("parcaSayisi").getValue())+" parca Sayisi";
		return output;
	}
	public FIS getModel() {
		return fis;
	}
}
