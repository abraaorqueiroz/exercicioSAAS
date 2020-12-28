package caixaEletronico;

class Cedulas {
	
	private int cedulas[];
	
	Cedulas(){
		cedulas = new int [4];  				//Cria um vetor de 4 posições, onde cada índice do vetor corresponde a quantidade de notas disponível no caixa
		for (byte j=0; j<4; j++) 				//Onde na posição 0 são as notas de 10 reais,  e assim sucessivamente até a posição 3 do vetor, que armazena a quantidade de notras de 100 reais
			cedulas[j]=0;						//Garante que na inicialização, todos os indíces do vetor armazena o valor 0
		
	}
	
	public void RegistrarNotas(int i, int qnt) {
		cedulas[i]+=qnt;						//Método para inserção de notas no caixa, onde deve ser informado qual o índice em que será incluido cédulas, e a quantidade a ser incluída
	}	
	
	public int RetornaQuantidade(int i) {		
		return cedulas[i];						//Método para retornar quantas cédulas tem disponível de um determinado valor, definido pelo índice recebido
	}
	
	public void SacarNota (int i, int qnt) {
		cedulas[i]=cedulas[i]-qnt;				//Método para saque de cédulas, onde recebe de qual cédula sera sacado, e quantas unidades serão sacadas
	}
	public int SaldoCaixa() {					//Método para exibir qual o total de dinheiro contido no caixa
		int saldo;
		saldo = (cedulas[0]*10)+(cedulas[1]*20)+(cedulas[2]*50)+(cedulas[3]*100);
		return saldo;
	}
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