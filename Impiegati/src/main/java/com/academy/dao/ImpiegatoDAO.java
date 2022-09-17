package com.academy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.academy.businesscomponent.model.Impiegato;

public class ImpiegatoDAO  implements DAOConstants {
	private Statement stmt;
	private ResultSet rs;
	
	
	public static ImpiegatoDAO getFactory() {
		return new ImpiegatoDAO();
	}
	
	private ImpiegatoDAO() {
	}
 	
	public ArrayList<Impiegato> getPianeti(Connection conn) throws SQLException {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(SELECT_IMPIEGATO);
		
	
		
		ArrayList<Impiegato> lista = new ArrayList<Impiegato>();
		rs.beforeFirst();
		while(rs.next()) {
			Impiegato i = new Impiegato();
			i.setId(rs.getLong(1));
			i.setNome(rs.getString(2));
			i.setCognome(rs.getString(3));
			lista.add(i);
		}
		return lista;
	}
	
	
	public void create(Connection conn, Impiegato p) throws SQLException {
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(SELECT_IMPIEGATO);
		
		if(p != null) {
			rs.moveToInsertRow();
			rs.updateLong(1, p.getId());
			rs.updateString(2, p.getNome());
			rs.updateString(3, p.getCognome());
			rs.insertRow();
		}
	}
	
	public Impiegato findByPK(Connection conn, Long id) throws SQLException {
		PreparedStatement ps= conn.prepareStatement(SELECT_IMPIEGATO_BYPK);
		ps.setLong(1, id);
		Impiegato i = new Impiegato();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			i.setId(rs.getLong(1));
			i.setNome(rs.getString(2));
			i.setCognome(rs.getString(3));
		}
		return i;
	}
	
	public void delete(Connection conn, Long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_IMPIEGATO);
		ps.setLong(1, id);
		ps.execute();
	}
	
	public void update(Connection conn, Impiegato p) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_IMPIEGATO);
		ps.setLong(1, p.getId());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getCognome());
		ps.execute();
		
	}
}
