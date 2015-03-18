package com.teste;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.teste.entidade.Aluno;
import com.teste.entidade.Professor;
import com.teste.persistencia.JDBCUtil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < 10; i++) {
		//System.out.println(i + 1 + " Ola Mundo!!! ");
		//}
		//Aluno a1 = new Aluno(1234L, "jo�o", "12345678909", new Date());
		//Aluno a2 = new Aluno(4321L, "Lurdinha", "12345678909");
		//Aluno a3 = new Aluno(33333L, "Wanderson");
		
		//Professor p1 = new Professor("Jose", "123456789", new BigDecimal(1500));
		//Professor p2 = new Professor("Julesca", "434343434343434");
		Aluno a1 = new Aluno(01L,"Jo�o", "12343434343", 1234L, new Date());
		Aluno a2 = new Aluno(02L, "Lurdinha", "12343434343", 1234L, new Date());
		Aluno a3 = new Aluno(03L, "Jo�o", "12343434343", 1234L, new Date());
		
	
		Professor p1 = new Professor(04L, "Jose", "5454545454545454", new BigDecimal(1500));
		Professor p2 = new Professor(05L, "Julesca", "5454545454545454", new BigDecimal(5500));
		
		System.out.println(Aluno.verificaMatricula("12345678"));
		System.out.println("");
		System.out.println("chamando o BONUS professor "+Professor.BONUS);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a1);
		System.out.println(a2);		
		System.out.println(a3);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("");		
		try {
			ResultSet res = JDBCUtil.getConnector().prepareStatement("select * from tb_aluno").executeQuery();
			while (res.next()){
				System.out.println(res.getLong("id")+"\t"+res.getString("nome"));
			}
			JDBCUtil.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
