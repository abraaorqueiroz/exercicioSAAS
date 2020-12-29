package caixaEletronico;

class Cedulas {
		
/**
 * 	No chamado dessa classe, e criado um vetor de 4 posicoes,
 * onde cada indice do vetor corresponde a quantidade de notas disponivel no caixa,
 * onde na posição 0 sao as notas de 10 reais,  e assim sucessivamente ate a posicao 3 do vetor,
 * que armazena a quantidade de notras de 100 reais.
 */
	
	private int cedulas[];
	Cedulas(){
		cedulas = new int [4];
		for (byte j=0; j<4; j++)
			cedulas[j]=0;
		
	}
	
/**
 *	Metodo para inserção de notas no caixa,
 *onde deve ser informado qual o indice em que sera incluido cedulas,
 *e a quantidade a ser incluida
 */
	public void RegistrarNotas(int i, int qnt) {
		cedulas[i]+=qnt;						//
	}	
	
/**
 * 	Metodo para retornar quantas cedulas tem disponivel de um determinado valor,
 * definido pelo indice recebido
 */
	
	public int RetornaQuantidade(int i) {		
		return cedulas[i];
	}
	
/**
 * Metodo para saque de cédulas. Os parametos de entrada são de qual cédula sera sacado,
 * e quantas unidades serao sacadas
 */
	public void SacarNota (int i, int qnt) {
		cedulas[i]=cedulas[i]-qnt;
	}

/**
 * Metodo para exibir qual o total de dinheiro contido no caixa
 */
	
	public int SaldoCaixa() {
		int saldo;
		saldo = (cedulas[0]*10)+(cedulas[1]*20)+(cedulas[2]*50)+(cedulas[3]*100);
		return saldo;
	}
	

/**
 * Metodo para exibir o total de unidades de cada cedula contidas no caixa
 */	
	
	public void MostrarQuantidades () {
		System.out.print("O saldo total no caixa é: ");System.out.println(SaldoCaixa());
		System.out.println("Valor:\t\t|\tR$10\t|\tR$20\t|\tR$50\t|\tR$100\t|");
		System.out.print("Quantidade:");
		for(byte i = 0;i < 4;i ++){
            System.out.print("\t|\t"+RetornaQuantidade(i));
        }
        System.out.println("\t|");
	}
}