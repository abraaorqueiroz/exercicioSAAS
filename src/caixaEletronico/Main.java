package caixaEletronico;

import biblioteca.Keyboard;

public class Main {
	public static void main(String[] args) {
		Cedulas notas = new Cedulas();
		AbastecerCedulas abastecimento = new AbastecerCedulas();
		Saque novoSaque = new Saque();
		
		boolean condicao = true;
		
		do {
			int resp;
			System.out.println("_______________________________________________________________________________________\n");
			System.out.println("Digite a opcao desejada");
			System.out.println("1- Abastecer de notas");
			System.out.println("2- Saque");
			System.out.println("3- Mostrar quantidades: ");
			System.out.println("4- Encerrar aplicação\n");
			resp= Keyboard.readInt();
			
			switch (resp) {
				case 1: {
					notas = abastecimento.abastecerCedulas(notas);
				}break;
				case 2:{
					int valor;
					System.out.print("Digite o valor do saque: ");
					valor=Keyboard.readInt();							
					if (novoSaque.RealizarSaque(notas , valor) == 0) {
						System.out.println("/nSaque bem sucedido!");
					}
				}break;
				case 3:{
					notas.MostrarQuantidades();
				}break;			
				case 4:{
					System.out.println("Você tem certeza que deseja encerrar a apricacao? (S/n)");
					char confirmacao;
					confirmacao = Keyboard.readChar();
					if ((confirmacao == 'S') || (confirmacao == 's'))
						condicao=false;
				}break;
				default:{
					System.out.println("Opcao Invalida");
					
				}
			}
			
			System.out.println();
			
		}while(condicao);
		
	}
	
}