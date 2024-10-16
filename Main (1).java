package Bar;

import java.util.Locale;

public class Comanda {
	

	int cerveja;
	int refrigerante;
	int espetinho;
	double consumo;
	double total;
	double ingresso;
	double couvert;
	char sexo;
	
	public double consumo() {
	consumo = (cerveja*5)+(refrigerante*3)+(espetinho*7);
	return consumo;
	}
	
	public String calcularCouvert() {
		if (consumo<31 && consumo >0) {
			couvert = 4;
			return ("\nCouvert = R$" +couvert);
			
		}
		else if (consumo >= 31) {
			couvert = 0;
			return ("\nIsento de couvert");
		}
		else return ("Valor Negativo");
	}

	public double valorCouvert() {
		if (consumo<31 && consumo >0) {
			couvert = 4;
			return 	couvert;	
		}
		else if (consumo >= 31) {
			couvert = 0;
			return couvert;
		}
		else return couvert = 0;
	}
	
	public double calcularIngresso() {
		if (sexo == 'F') {
			ingresso = 8;
			return ingresso;
		}
		if (sexo == 'M') {
			ingresso = 10;
			return ingresso;
		}
		return ingresso;
	}
	public double calcularTotal() {
		total = consumo() + valorCouvert() + calcularIngresso();
		return total;
	}
	
	
	
	
	
			
	

	
	public void impressao() {
	       
		Locale.setDefault(Locale.US);

		System.out.println("Sexo = "+sexo);
        System.out.println("Quantidade de cervejas: " + cerveja);
        System.out.println("Quantidade de refrigerantes: " +refrigerante);
        System.out.println("Quantidade de espetinho: " +espetinho);
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo: R$" +consumo());
        System.out.println(calcularCouvert());
        System.out.println("Ingresso = R$ " +calcularIngresso());
        System.out.println("Valor a pagar = R$ " +calcularTotal());

        

				
		
	}
	
	public static void main(String[] args) {
		
		Comanda pessoa1 = new Comanda();
		pessoa1.sexo = 'F';
		pessoa1.cerveja = 2;
		pessoa1.refrigerante = 1;
		pessoa1.espetinho = 1;
		
		pessoa1.impressao();
}
}