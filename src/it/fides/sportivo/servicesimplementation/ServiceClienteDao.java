package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.Util.UtilClientDao;
import it.fides.sportivo.entity.Cliente;
import it.fides.sportivo.repository.DataSourceSingleton;
import it.fides.sportivo.services.ServiceCliente;

import java.sql.*;
import java.util.GregorianCalendar;

public class ServiceClienteDao implements ServiceCliente {
  private static Connection conex=null;
  private static PreparedStatement st = null;
  private static ResultSet rs = null;
  private static final String queryCreaUtente="INSERT INTO cliente(nome,cognome,data_nascita)"+"VALUES(?,?,?)";
  private static final String queryUpdateUtente="UPDATE cliente SET nome=?, cognome=?, data_nascita=? " +" WHERE id=? ";
  private static final String queryDeleteUtente="DELETE FROM cliente WHERE id=?";
  private static final String queryFind="SELECT * FROM cliente WHERE id=?";


    public void  createCliente(Cliente cliente) throws SQLException {
        conex= DataSourceSingleton.getInstance().getConnection();
        java.sql.Date sqlData= UtilClientDao.trasformaDataUtilSql(cliente.getData_nascita()); //trasformazione della data in formato sql
        st=conex.prepareStatement(queryCreaUtente);
        st.setString(1, cliente.getNome());
        st.setString(2,cliente.getCognome());
        st.setDate(3,sqlData);
        st.executeUpdate();
    }

    public void updateCliente(Cliente cliente) throws SQLException {
      conex =DataSourceSingleton.getInstance().getConnection();
      java.sql.Date sqlData= UtilClientDao.trasformaDataUtilSql(cliente.getData_nascita());
      st= conex.prepareStatement(queryUpdateUtente);
      st.setString(1,cliente.getNome());
      st.setString(2, cliente.getCognome());
      st.setDate(3,sqlData);
      st.setInt(4,cliente.getId());
      st.executeUpdate();


    }


    public void deleteCliente(Cliente cliente) throws SQLException {
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
   private Cliente mappaturaCliente(ResultSet result) throws SQLException {
      Cliente c = new Cliente();
      c.setId(result.getInt("id"));
      c.setNome(result.getString("nome"));
      c.setCognome(result.getString("cognome"));
      java.sql.Date sqlDate=result.getDate("data_nascita");
      GregorianCalendar newDate= UtilClientDao.trasformaDataSqlaUtil(sqlDate);
      c.setData_nascita(newDate);

      return c;
    }

    public  Cliente TrovaclienteById(int id) throws SQLException {
      conex =DataSourceSingleton.getInstance().getConnection();
      rs=st.executeQuery("SELECT * FROM  cliente WHERE id="+id);
      Cliente cliente=null;
      while ((rs.next())){
        cliente=this.mappaturaCliente(rs);
      }
      return cliente;


    }


}
