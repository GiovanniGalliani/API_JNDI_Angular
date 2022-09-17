package com.academy.dao;

public interface DAOConstants {

	String SELECT_IMPIEGATO = "SELECT * FROM IMPIEGATO";
	String SELECT_IMPIEGATO_BYPK = "SELECT * FROM IMPIEGATO WHERE ID_IMPIEGATO = ?";
	String UPDATE_IMPIEGATO = "UPDATE IMPIEGATO SET NOME = ?, COGNOME = ? WHERE ID_IMPIEGATO = ?";
	String DELETE_IMPIEGATO = "DELETE FROM IMPIEGATO WHERE ID_IMPIEGATO = ?";
}
