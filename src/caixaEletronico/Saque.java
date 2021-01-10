package caixaEletronico;

class Saque {
		
	/**
	 * 	O metodo CalculoQuantidades serve para calcular quantas cedulas de cada valor
	 * serao necessarias para compor o valor do saque.
	 * 	A estrategia escolhida e dar o minimo de notas possivel em cada saque.
	 * 	Dessa forma podendo ser realizado o maior numero de saques possiveis.
	 * 	E montado um vetor com a quantidade de cada cedula que sera fornecida,
	 * sendo que a cada iteracao e adicionada a cedula com maoir valor disponivel,
	 * menor que o valor faltante para o total do saque.
	 * 
	 * 	Exixte uma familia de valores de saques que podem dar problemas,
	 * são valores em que a combinação inclui por último uma nota de 10 reais,
	 * sendo que não têm disponivel mais notas de 10 no caixa.
	 * 	Porem e possivel fazer uma combicao com outros valores de nota,
	 * por exemplo 60, que inicialmente seria calculada uma combinacao de 50 e 10,
	 * mas como 10 não esta disponivel, caso tenha 3 notas de 20 é possivel aprovar o saque.
	 * 	O mesmo vale para valores com 80, 110, 130, etc.
	 * 	Para solucionar esse problema foi desenvolvido duas condicoes extras,
	 * tentar remover uma nota de 50, caso exista no calculo de combinação e tentar refazer a combinacao,
	 * ou tentar remover uma nota de 100, caso exista no calculo de combinação e tentar refazer a combinacao.
	 * 	Caso nao seja possivel fazer um combinacao, é inserido o valor -1, no primeiro elemento do vetor, idicando erro,
	 * em caso de sucesso, retorna o vetor com a quantidades de notas.
	 */

	private int[] CalculoQuantidades(Cedulas notas , int valor) {
		int soma=valor;
		
		boolean flag50=true;
		boolean flag100=true;
		boolean controle=true;

		int quantidades[];
		quantidades = new int [4];
		for (byte i=0; i<4; i++) {
			quantidades[i]=0;
		}
		
		while (controle) {
			if ( (soma>=100) && ( (notas.RetornaQuantidade(3) - quantidades[3]) > 0 ) && flag100 ) {
				quantidades[3]++;
				soma=soma-100;
			}
			else if ( (soma>=50) && ( (notas.RetornaQuantidade(2) - quantidades[2]) > 0 ) && flag50 ) {
				quantidades[2]++;
				soma=soma-50;
			}
			else if ( (soma>=20) && ( (notas.RetornaQuantidade(1) - quantidades[1]) > 0 )) {
				quantidades[1]++;
				soma=soma-20;
			}
			else if ( (soma>=10) && ( (notas.RetornaQuantidade(0) - quantidades[0]) > 0 )) {
				quantidades[0]++;
				soma=soma-10;
			}
			else if ( (soma>=10) && (quantidades[2] > 0) && flag50){
				flag50=false;
				quantidades[2]--;
				soma=soma+50;
			}
			else if ( (soma>=10) && (quantidades[3] > 0) && flag100){
				flag100=false;
				quantidades[3]--;
				soma=soma+100;
			}
			else if (soma == 0){
				controle=false;
			}
			else{
				quantidades[0]=-1;
				controle=false;
			}
						
		}
		return quantidades;
	}
	
	/**
	 * 	O metodo RealizarSaque verifica se e possivel realizar o saque, dado as cedulas em caixa.
	 * 	Inicialmente verifica os possiveis erros relacionados ao valor de saque desejado, sendo eles:
	 * 	1- Valor nao multiplo de 10
	 * 	2- Valor menor do que 10 (inclui valores negativos)
	 * 	3- Valor maior do que o saldo do caixa.
	 * 	Caso ache um dos erros acima, exibe mensagem de erro, e não realiza o saque,
	 * retornando um código de erro correspondente ao erro.
	 * 	Apos isso chama o metodo CalculoQuantidades, e caso seja possivel realizar o saque,
	 * imprime uma mensagem com a combinacao de notas para o saque, e retorna o codigo 0, que representa sucesso.
	 */
	
	public int RealizarSaque (Cedulas notas, int valor) {
		if ( ( (valor % 10) != 0) || (valor < 10) ){
			System.out.println("Valor de saque impossivel!");
			return 1;
		}
		
		int saldo;
		saldo = notas.SaldoCaixa();		
		if (valor > saldo) {
			System.out.println("Saldo do caixa eletronico insuficiente para valor do saque");
			return 2;
		}
		
		int quantidades[];
		quantidades = CalculoQuantidades (notas , valor);
		
		if (quantidades[0]==-1) {
			System.out.println("Combinacao de cedulas impossivel para esse valor de saque");
			return 3;
		}
			
		for(byte i=0; i<4; i++) {
			notas.SacarNota(i,quantidades[i]);
		}
		System.out.println("A combinacao de cedulas para esse saque e: ");
		System.out.println("Cedulas:\t|\tR$10\t|\tR$20\t|\tR$50\t|\tR$100\t|");
		System.out.print("Quantidade:");
		for(byte i = 0;i < 4;i ++){
			System.out.print("\t|\t"+quantidades[i]);
		}
		System.out.println("\t|");
		
		return 0;
	}
	
}
