package edu.escuelaing.arem.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.escuelaing.arem.entites.Greeting;
import edu.escuelaing.arem.repository.IGreeting;


@Component
public class GreetingImpl implements IGreeting {


	@Autowired
	private DataSource dataSource;

    public List<Greeting> findAll() throws SQLException {
       String query = "SELECT * FROM prueba;";
		List<Greeting> auctions = new ArrayList<Greeting>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Greeting auction = new Greeting();
				auction.setHello(rs.getString("sayHello"));						
				auctions.add(auction);
			}
			connection.close();
			return auctions;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
    }



}