package caixaEletronico;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class SaqueTest {

	@Test
	void testRealizarSaque() {
		Cedulas notas = new Cedulas();
		Saque saque = new Saque();
		AbastecerCedulas deposito = new AbastecerCedulas();
		
		int qnt = 5;
		notas = deposito.abastecerCedulasTest(notas, qnt);

		System.out.println("-> Mostra o saldo e quantidades de notas de cada valor no caixa\n");
		notas.MostrarQuantidades();
		

		System.out.println("\n-> Testa para saque de numero negativo (-1) \n Mostra 'Valor de saque impossivel' em caso de sucesso\n");
		int valor = -1;
		if ( (saque.RealizarSaque(notas, valor)) !=1) 
			assertTrue(false);			
		

		System.out.println("\n-> Testa para valor de saque menor do que 10 (5) \n Mostra 'Valor de saque impossivel' em caso de sucesso\n");
		valor = 5;
		if ( (saque.RealizarSaque(notas, valor)) !=1) 
			assertTrue(false);			
		

		System.out.println("\n-> Tenta fazer para valor de saque não multiplo de 10 \n Mostra 'Valor de saque impossivel' em caso de sucesso\n");
		valor = 22;
		if ( (saque.RealizarSaque(notas, valor)) !=1)
			assertTrue(false);			
		
		

		System.out.println("\n-> Tenta fazer para valor de saque maior que o saldo total do caixa \n Mostra 'Saldo insuficiente' em caso de sucesso\n");
		int saldo;
		saldo = (qnt*10)+(qnt*20)+(qnt*50)+(qnt*100);
		valor = saldo + 10;
		if ( (saque.RealizarSaque(notas, valor)) !=2)
			assertTrue(false);
		
		

		System.out.println("\n-> Tenta fazer um saque de 110 reais\n");
		valor = 110;
		if ( (saque.RealizarSaque(notas, valor)) != 0)
			assertTrue(false);
		System.out.println("\n-> Mostra o saldo e quantidades em caso de sucesso\n");
		notas.MostrarQuantidades();
		

		System.out.println("\n-> Tenta fazer 5 saques consecutivos de 60 reais. \n Esse teste busca saber se o caixa é capaz de saques consecutivos,\n alem de ver se consegue fazer uma combinação de 3 notas de 20,\n no caso de haver notas de 50 disponiveis, mas não de 10 reais.\n");
		valor = 60;
		loop : for (byte i=0; i<5; i++) {
			System.out.println("\n-> Tenta fazer o saque de 60 reais numero: "+(i+1));
			if ( (saque.RealizarSaque(notas, valor)) != 0) {
				assertTrue(false);
				break loop;
			}
			System.out.println("\n-> Mostra o saldo e quantidades em caso de sucesso\n");
			notas.MostrarQuantidades();
		}
		System.out.println("\n-> Tenta fazer mais um saque de 60 reais.\n Nesse caso não pode ser possível ");
		if ( (saque.RealizarSaque(notas, valor)) != 3)
			assertTrue(false);
		System.out.println("\n-> Mostra 'Combinacao impossivel' em caso de sucesso\n");
		notas.MostrarQuantidades();


		System.out.println("\n-> Tenta fazer um saque de 490 reais, que é o que resta no caixa caso todas os testes obtenham sucesso\n");
		valor = 490;
		if ( (saque.RealizarSaque(notas, valor)) == 0)
			assertTrue(true);
		notas.MostrarQuantidades();
		System.out.println("\n-> Mostra saldo e quantidades em caso de sucesso\n");
		
		
	}

}
