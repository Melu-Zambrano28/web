package it.esempio.sportivo.services;

import it.esempio.sportivo.entity.Cliente;

import java.sql.SQLException;

public interface ServiceCliente {

     void createCliente(Cliente cliente) throws SQLException;

     void  updateCliente(Cliente cliente) throws SQLException;

     void  deleteCliente(Cliente Cliente) throws SQLException;

      Cliente TrovaclienteById(int i) throws SQLException;

}
