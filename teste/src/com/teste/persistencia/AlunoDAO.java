package com.teste.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teste.entidade.Aluno;

public class AlunoDAO implements DAO<Aluno, Long> {
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Aluno find(Long id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnector().prepareStatement(
					"select * from tb_aluno where id = ?");
			p.setLong(1, id);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				// (Long id, String nome, String cpf, Long matricula, Date
				// dataAniversario) {
				return new Aluno(r.getLong("id"), r.getString("nome"),
						r.getString("cpf"), r.getLong("matricula"),
						r.getString("dataAniversario") == null ? null : df
								.parse(r.getString("dataAniversario")));

			}
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Aluno t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil
					.getConnector()
					.prepareStatement(
							"insert into tb_aluno (matricula, nome, cpf, dataAniversario) values (?,?,?,?)");
			p.setLong(1, t.getMatricula());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			p.setString(4, df.format(t.getDataAniversario()));
			p.executeUpdate();
			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void clean() {
		try {
			JDBCUtil.getConnector().prepareStatement("truncate tb_aluno")
					.executeUpdate();
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil
					.getConnector()
					.prepareStatement(
							"update tb_aluno set matricula=?, nome=?, cpf=?, dataAniversario=? where id=?");
			p.setLong(1, t.getMatricula());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			p.setString(4, df.format(t.getDataAniversario()));
			p.setLong(5, t.getId());
			p.executeUpdate();
			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnector().prepareStatement(
					"delete from tb_aluno where id=?");
			p.setLong(1, t.getId());
			p.executeUpdate();
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Aluno> findAll() {
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		PreparedStatement p;
		try {
			p = JDBCUtil.getConnector().prepareStatement(
					"select * from tb_aluno");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Aluno aa = new Aluno(r.getLong("id"), r.getString("nome"),
						r.getString("cpf"), r.getLong("matricula"),
						r.getString("dataAniversario") == null ? null : df
								.parse(r.getString("dataAniversario")));
				lista.add(aa);
			}
			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
