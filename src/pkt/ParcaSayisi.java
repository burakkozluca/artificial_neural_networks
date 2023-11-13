package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class ParcaSayisi {
	private FIS fis;
	private double yas;
	private double isTecrubesi;
	private double cinsiyet;
	
	public ParcaSayisi(double yas,double isTecrubesi,double cinsiyet) throws URISyntaxException {
		this.yas = yas;
		this.isTecrubesi = isTecrubesi;
		this.cinsiyet = cinsiyet;
		
		File dosya = new File(getClass().getResource("Sirket.fcl").toURI());
		fis = FIS.load(dosya.getPath());
		fis.setVariable("yas", yas);
		fis.setVariable("isTecrubesi", isTecrubesi);
		fis.setVariable("cinsiyet", cinsiyet);
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
