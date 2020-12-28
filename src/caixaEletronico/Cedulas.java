package caixaEletronico;

class Cedulas {
	
	private int cedulas[];
	
	Cedulas(){
		cedulas = new int [4];  				//Cria um vetor de 4 posi��es, onde cada �ndice do vetor corresponde a quantidade de notas dispon�vel no caixa
		for (byte j=0; j<4; j++) 				//Onde na posi��o 0 s�o as notas de 10 reais,  e assim sucessivamente at� a posi��o 3 do vetor, que armazena a quantidade de notras de 100 reais
			cedulas[j]=0;						//Garante que na inicializa��o, todos os ind�ces do vetor armazena o valor 0
		
	}
	
	public void RegistrarNotas(int i, int qnt) {
		cedulas[i]+=qnt;						//M�todo para inser��o de notas no caixa, onde deve ser informado qual o �ndice em que ser� incluido c�dulas, e a quantidade a ser inclu�da
	}	
	
	public int RetornaQuantidade(int i) {		
		return cedulas[i];						//M�todo para retornar quantas c�dulas tem dispon�vel de um determinado valor, definido pelo �ndice recebido
	}
	
	public void SacarNota (int i, int qnt) {
		cedulas[i]=cedulas[i]-qnt;				//M�todo para saque de c�dulas, onde recebe de qual c�dula sera sacado, e quantas unidades ser�o sacadas
	}
	public int SaldoCaixa() {					//M�todo para exibir qual o total de dinheiro contido no caixa
		int saldo;
		saldo = (cedulas[0]*10)+(cedulas[1]*20)+(cedulas[2]*50)+(cedulas[3]*100);
		return saldo;
	}
	public void MostrarQuantidades () {
		System.out.print("O saldo total no caixa �: ");System.out.println(SaldoCaixa());
		System.out.println("Valor:\t\t|\tR$10\t|\tR$20\t|\tR$50\t|\tR$100\t|");
		System.out.print("Quantidade:");
		for(byte i = 0;i < 4;i ++){
            System.out.print("\t|\t"+RetornaQuantidade(i));
        }
        System.out.println("\t|");
	}
}