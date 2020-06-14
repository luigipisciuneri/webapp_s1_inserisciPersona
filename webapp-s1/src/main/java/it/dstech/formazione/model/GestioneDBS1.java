package it.dstech.formazione.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class GestioneDBS1 {
private Connection connessione;

public GestioneDBS1() throws SQLException, ClassNotFoundException {
	// connessione db in locale	
	Class.forName("com.mysql.cj.jdbc.Driver");
	String password = "gigi";
	String username = "root";
	String url = "jdbc:mysql://localhost:3306/mio?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
	this.connessione = DriverManager.getConnection(url, username, password);
	
}

public void addPersona(Persona p) throws SQLException {
	PreparedStatement st=this.connessione.prepareStatement("insert into persona (cognome,nome,eta) values(?,?,?)");
    st.setString(1, p.getCognome());
    st.setString(2, p.getNome());
    st.setInt(3, p.getEta());
    st.execute();
}

public List<Persona> getAll() throws SQLException {
	PreparedStatement st=this.connessione.prepareStatement("select * from persona;");
	ResultSet executeQuery=st.executeQuery();
	List<Persona> elenco=new ArrayList<>();
    while(executeQuery.next()) {
    	Persona temp=new Persona();
    	temp.setId(executeQuery.getInt(1));
    	temp.setCognome(executeQuery.getString(2));
    	temp.setNome(executeQuery.getString(3));
    	temp.setEta(executeQuery.getInt(4));
    	
    	elenco.add(temp);  	
    }
	return elenco;
}

}
