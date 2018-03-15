package it.esempio.sportivo.servicesimplementation;

import it.esempio.sportivo.Util.Util_Data_Time;
import it.esempio.sportivo.entity.Cliente;
import it.esempio.sportivo.repository.DataSourceSingleton;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ServiceClienteDao  {
  private static Connection conex=null;
  private static PreparedStatement st = null;
  private static ResultSet rs = null;

  private static final String queryCreaUtente="INSERT INTO cliente(nome,cognome,data_nascita)"+"VALUES(?,?,?)";
  private static final String queryUpdateUtente="UPDATE cliente SET nome=?, cognome=?, data_nascita=? " +" WHERE id=? ";
  private static final String queryDeleteUtente="DELETE FROM cliente WHERE id=?";
  private static final String querySelect="SELECT * FROM cliente";
  private static final String querySelectClientebyNameSurname = "SELECT * FROM cliente WHERE nome=? AND cognome=?";


    public static void  createCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        conex= DataSourceSingleton.getInstance().getConnection();
        java.sql.Date sqlData= Util_Data_Time.covertiGregorianCalendar_Sql(cliente.getData_nascita()); //trasformazione della data in formato sql
        st=conex.prepareStatement(queryCreaUtente);
        st.setString(1, cliente.getNome());
        st.setString(2,cliente.getCognome());
        st.setDate(3,sqlData);
        st.executeUpdate();
    }

    public static void updateCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
      conex =DataSourceSingleton.getInstance().getConnection();
      java.sql.Date sqlData= Util_Data_Time.covertiGregorianCalendar_Sql(cliente.getData_nascita());
      st= conex.prepareStatement(queryUpdateUtente);
      st.setString(1,cliente.getNome());
      st.setString(2, cliente.getCognome());
      st.setDate(3,sqlData);
      st.setInt(4,cliente.getId());
      st.executeUpdate();


    }


    public static void deleteCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
      conex =DataSourceSingleton.getInstance().getConnection();
      st=conex.prepareStatement(queryDeleteUtente);
      st.setInt(1,cliente.getId());
      st.executeUpdate();


    }



  public static void chiudiTutto() throws SQLException {
      conex.close();
      st.close();

    }

    //mappatura di ogni singolo cliente
   private static Cliente mappaturaCliente(ResultSet result) throws SQLException {
      Cliente c = new Cliente();
      c.setId(result.getInt("id"));
      c.setNome(result.getString("nome"));
      c.setCognome(result.getString("cognome"));
      java.sql.Date sqlDate=result.getDate("data_nascita");
      GregorianCalendar newDate= Util_Data_Time.convertiDataSql_Gregorian(sqlDate);
      c.setData_nascita(newDate);

      return c;
    }

    public static  Cliente TrovaclienteById(int id) throws SQLException, ClassNotFoundException {
      conex =DataSourceSingleton.getInstance().getConnection();
      rs=st.executeQuery("SELECT * FROM  cliente WHERE id="+id);
      Cliente cliente=null;
      while ((rs.next())){
        cliente=ServiceClienteDao.mappaturaCliente(rs);
      }
      return cliente;


    }

    public ArrayList<Cliente> listaCliente() throws SQLException, ClassNotFoundException {
        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(querySelect);
        GregorianCalendar dataNascita = null;
        Cliente c=null;
        ArrayList<Cliente> elencoCliente= new ArrayList<Cliente>();
        rs = st.executeQuery();
        while(rs.next()) {
            c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCognome(rs.getString("cognome"));
            java.sql.Date sqlDate=rs.getDate("data_nascita");
            dataNascita= Util_Data_Time.convertiDataSql_Gregorian(sqlDate);
            c.setData_nascita(dataNascita);
            elencoCliente.add(c);
        }
        return elencoCliente;
    }

    public static Cliente getClienteByNameSurname(String name, String surname) throws SQLException, ClassNotFoundException{

        conex = DataSourceSingleton.getInstance().getConnection();
        st = conex.prepareStatement(querySelectClientebyNameSurname);
        st.setString(1, name);
        st.setString(2, surname);
        rs = st.executeQuery();

        Cliente c = ServiceClienteDao.mappaturaCliente(rs);

        return c;

    }






}
