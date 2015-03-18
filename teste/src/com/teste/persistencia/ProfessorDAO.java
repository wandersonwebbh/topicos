package com.teste.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.teste.entidade.Aluno;
import com.teste.entidade.Professor;

public class ProfessorDAO implements DAO<Professor, Long> {
	private SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");

	public Professor find(Long id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnector().prepareStatement(
					"select * from tb_professor where id=?");
			p.setLong(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				return new Professor(r.getLong("ID"), r.getString("NOME"),
						r.getString("CPF"), r.getBigDecimal("SALARIO"));
				// return new Professor
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil
					.getConnector()
					.prepareStatement(
							"INSERT INTO TB_PROFESSOR (NOME, CPF, SALARIO) VALUES (?,?,?)");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.executeUpdate();
			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void update(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil
					.getConnector()
					.prepareStatement(
							"update TB_PROFESSOR set NOME=?, CPF=?, SALARIO=? where (id=?)");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.setLong(4, t.getId());
			p.executeUpdate();
			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Professor t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnector().prepareStatement(
					"delete from TB_PROFESSOR where (id=?)");
			p.setLong(1, t.getId());
			p.executeUpdate();
			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Professor> lista = new ArrayList<Professor>();
		PreparedStatement p;
		try {
			p = JDBCUtil.getConnector().prepareStatement(
					"select * from TB_PROFESSOR");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Professor aa = new Professor(r.getLong("id"),
						r.getString("nome"), r.getString("cpf"),
						r.getBigDecimal("salario"));
				lista.add(aa);
			}
			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	public void clean() {
		try {
			JDBCUtil.getConnector().prepareStatement("truncate TB_PROFESSOR")
					.executeUpdate();
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
