package edu.escuelaing.arem.repository;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import edu.escuelaing.arem.entites.Greeting;

@Service
public interface IGreeting{
    public List<Greeting> findAll() throws SQLException ;  
}