package com.teste;

import java.math.BigDecimal;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < 10; i++) {
		//System.out.println(i + 1 + " Ola Mundo!!! ");
		//}
		//Aluno a1 = new Aluno(1234L, "joão", "12345678909", new Date());
		//Aluno a2 = new Aluno(4321L, "Lurdinha", "12345678909");
		//Aluno a3 = new Aluno(33333L, "Wanderson");
		
		//Professor p1 = new Professor("Jose", "123456789", new BigDecimal(1500));
		//Professor p2 = new Professor("Julesca", "434343434343434");
		Aluno a1 = new Aluno("João", "12343434343", 1234L, new Date());
		Aluno a2 = new Aluno("Lurdinha", "12343434343", 1234L, new Date());
		Aluno a3 = new Aluno("João", "12343434343", 1234L, new Date());
		
		Professor p1 = new Professor("Jose", "5454545454545454", new BigDecimal(1500));
		Professor p2 = new Professor("Julesca", "5454545454545454", new BigDecimal(5500));
		
		System.out.println(a1);
		System.out.println("");
		System.out.println(a2);
		System.out.println("");
		System.out.println(a3);
		System.out.println("");
		System.out.println("");
		System.out.println(p1);
		System.out.println("");
		System.out.println(p2);
	}

}
