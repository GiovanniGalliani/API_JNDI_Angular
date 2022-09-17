package com.academy.businesscomponent.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.academy.businesscomponent.ImpiegatoBC;
import com.academy.businesscomponent.model.Impiegato;

@Path("/impiegatoservice")
public class ImpiegatoService {

	@GET
	@Path("/impiegati")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Impiegato> getImpiegati() throws SQLException, NamingException {
		ImpiegatoBC iBC = new ImpiegatoBC();
		return iBC.getImpiegati();
	}
	
	@GET
	@Path("/impiegato/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Impiegato getImpiegato(@PathParam("id") long id) throws SQLException, NamingException {
		ImpiegatoBC pBC = new ImpiegatoBC();
		return pBC.findByPK(id);
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Impiegato createImpiegato(Impiegato impiegato) throws SQLException, NamingException {
		ImpiegatoBC iBC = new ImpiegatoBC();
		iBC.create(impiegato);
		return impiegato;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Impiegato updateImpiegato(Impiegato impiegato) throws SQLException, NamingException {
		ImpiegatoBC iBC = new ImpiegatoBC();
		iBC.update(impiegato);
		return impiegato;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteImpiegato(@PathParam("id") long id) throws NamingException, SQLException {
		ImpiegatoBC iBC = new ImpiegatoBC();
		iBC.delete(id);
	}	
}
