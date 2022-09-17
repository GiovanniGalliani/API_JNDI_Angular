package com.academy.businesscomponent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.academy.architecture.dbaccess.DBAccess;
import com.academy.businesscomponent.model.Impiegato;
import com.academy.dao.ImpiegatoDAO;

public class ImpiegatoBC {
private ImpiegatoDAO pDAO;

	public ImpiegatoBC() throws NamingException, SQLException {
		pDAO = ImpiegatoDAO.getFactory();
	}

	public ArrayList<Impiegato> getImpiegati() throws SQLException, NamingException {
		try {
			return pDAO.getImpiegati(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void create(Impiegato p) throws SQLException, NamingException {
		try {
			pDAO.create(DBAccess.getConnection(), p);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void update(Impiegato p) throws SQLException, NamingException {
		try {
			pDAO.update(DBAccess.getConnection(), p);
		} finally {
			DBAccess.closeConnection();

		}
	}

	public void delete(long id) throws SQLException, NamingException {
		try {
			pDAO.delete(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Impiegato findByPK(Long id) throws SQLException, NamingException {
		try {
			return pDAO.findByPK(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}

	}
}
