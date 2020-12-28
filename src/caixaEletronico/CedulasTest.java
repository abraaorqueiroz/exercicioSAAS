package caixaEletronico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CedulasTest {

	@Test
	void testCedulas() {
		Cedulas notas = new Cedulas();
		boolean teste = true;
		loop : for (byte i=0; i<4; i++) {
			if ( notas.RetornaQuantidade(i) != 0 ){
				teste = false;
				break loop;
			}
		}
		assertTrue(teste);
	}

	@Test
	void testRegistrarNotas() {
		Cedulas notas = new Cedulas();
		boolean teste = true;
		loop : for (byte i=0; i<4; i++) {
			notas.RegistrarNotas(i, 10);
			if ( !( notas.RetornaQuantidade(i) == 10 )){
				teste = false;
				break loop;
			}
		}
		assertTrue(teste);

	}

	@Test
	void testSacarNota() {
		Cedulas notas = new Cedulas();
		boolean teste = true;
		loop : for (byte i=0; i<4; i++) {
			notas.SacarNota(i, 10);
			if ( !( notas.RetornaQuantidade(i) == -10 )){
				teste = false;
				break loop;
			}
		}
		assertTrue(teste);
	}

	@Test
	void testSaldoCaixa() {
		Cedulas notas = new Cedulas();
		int valor = 10;
		for (byte i=0; i<4; i++) {
			notas.RegistrarNotas(i, valor);
		}

		int resultadoEsperado = (valor*10)+(valor*20)+(valor*50)+(valor*100);
		
		assertTrue(notas.SaldoCaixa() == resultadoEsperado);
	}

}
