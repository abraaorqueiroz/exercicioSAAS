package caixaEletronico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbastecerCedulasTest {

	@Test
	void testAbastecerCedulasTest() {
		Cedulas notas = new Cedulas();
		AbastecerCedulas deposito = new AbastecerCedulas();
		
		int qnt = 5;
		
		notas = deposito.abastecerCedulasTest(notas, qnt);
		notas.MostrarQuantidades();
		
		boolean teste = true;
		
		loop : for (byte i=0; i<4; i++) {
			if ( notas.RetornaQuantidade(i) != qnt ){
				teste = false;
				break loop;
			}
		}
		
		assertTrue(teste);
	}

}
