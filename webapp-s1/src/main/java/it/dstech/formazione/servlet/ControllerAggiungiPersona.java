package it.dstech.formazione.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.formazione.model.GestioneDBS1;
import it.dstech.formazione.model.Persona;

public class ControllerAggiungiPersona extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione=req.getParameter("azione");
		
	if("aggiungi".equalsIgnoreCase(azione))	{
	   String cognome=req.getParameter("cognome");
       String nome=req.getParameter("nome");
       int eta=Integer.parseInt(req.getParameter("eta"));
       Persona p=new Persona();
       p.setCognome(cognome);
       p.setNome(nome);
       p.setEta(eta);
       
       try {
		GestioneDBS1 gestioneDB=new GestioneDBS1();
		gestioneDB.addPersona(p);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
		req.getRequestDispatcher("inizio.jsp").forward(req, resp);
		
	}else if ("stampa".equalsIgnoreCase(azione)) {
		try {
			GestioneDBS1 db=new GestioneDBS1();
			List<Persona> lista=db.getAll();
			req.setAttribute("lista", lista);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("stampa.jsp").forward(req, resp);
	}
	}
	

}
