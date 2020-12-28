package caixaEletronico;

import biblioteca.Keyboard;

class AbastecerCedulas {
	
	public Cedulas abastecerCedulas(Cedulas notas) {
		int qnt;
		System.out.println("Digite o quantidade de cedulas de DEZ reais a inserir no caixa : ");
		qnt=Keyboard.readInt();
		notas.RegistrarNotas(0,qnt);
		
		System.out.println("Digite o quantidade de cedulas de VINTE reais a inserir no caixa : ");
		qnt=Keyboard.readInt();
		notas.RegistrarNotas(1,qnt);
		
		System.out.println("Digite o quantidade de cedulas de CINQUENTA reais a inserir no caixa : ");
		qnt=Keyboard.readInt();
		notas.RegistrarNotas(2,qnt);
		
		System.out.println("Digite o quantidade de cedulas de CEM reais a inserir no caixa : ");
		qnt=Keyboard.readInt();
		notas.RegistrarNotas(3,qnt);
		
		return notas;
	}
	
	public Cedulas abastecerCedulasTest(Cedulas notas , int qnt) {
		
		notas.RegistrarNotas(0,qnt);


		notas.RegistrarNotas(1,qnt);


		notas.RegistrarNotas(2,qnt);


		notas.RegistrarNotas(3,qnt);
		
		return notas;
	}

}
