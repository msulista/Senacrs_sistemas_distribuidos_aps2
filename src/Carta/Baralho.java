package Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Baralho {
	
	private CartaST cartaST;
	private List<CartaST> maoPlayer = new ArrayList<CartaST>();
	private Random gerador = new Random();
	
	public List<CartaST> geraBaralhoPlayer() {
		
		for (int i = 0; i < 16; i++) {
			
			cartaST = new CartaST();
			cartaST.setNome("Carta" + i);
			int agilidade = gerador.nextInt(10);
			cartaST.setAgilizade(agilidade);
			int energia = gerador.nextInt(10);
			cartaST.setEnergia(energia);
			int poder = gerador.nextInt(10);
			cartaST.setPoder(poder);
			int forca = gerador.nextInt(10);
			cartaST.setPoder(forca);
			
			maoPlayer.add(cartaST);
		}
		return maoPlayer;
	}
	 

}
