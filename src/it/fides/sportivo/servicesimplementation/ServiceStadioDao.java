package it.fides.sportivo.servicesimplementation;

import it.fides.sportivo.entity.Stadio;
import it.fides.sportivo.repository.DataSourceSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceStadioDao
{

    public ArrayList<Stadio> stadio = new ArrayList<Stadio>();
    public List<Stadio> lista()
    {
        Connection coni=null;
        try
        {
            coni= DataSourceSingleton.getInstance().getConnection();
            Statement comandoSQL = coni.createStatement();
            ResultSet rs = comandoSQL.executeQuery("select * from stadio");

            while(rs.next())
            {
                stadio.add(
                        new Stadio(rs.getInt(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getDouble(4)));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (coni != null )
                try
                {
                   coni.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
        }
        return stadio;
    }
    public static void insert(int id, String nome, int grand, double price) throws SQLException
    {
        Connection coni = null;
        {
            try {
                coni = DataSourceSingleton.getInstance().getConnection();
                Statement comandoSQL = coni.createStatement();
                comandoSQL.execute("insert into stadio values(" + id + ",'" + nome + "'," + grand + "," + price + ")");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (coni != null)
                    try {
                        coni.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
    public static void update ( String nome, int grand, double price,int id)
    {
        Connection coni = null;
        try
        {
            coni = DataSourceSingleton.getInstance().getConnection();
            Statement comandoSQL = coni.createStatement();
            String query = "UPDATE stadio SET nome ='"+nome+"',capienza="+grand+",costo_blg="+price+" WHERE id = "+id+"";
            System.out.println(query);
            comandoSQL.execute(query);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (coni != null)
                try {
                    coni.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
    public static void delete (int id)
    {
        Connection coni = null;
        try
        {
            coni = DataSourceSingleton.getInstance().getConnection();
            Statement comandoSQL = coni.createStatement();
            String query = "delete from stadio  WHERE id= "+id;
            comandoSQL.execute(query);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (coni != null)
                try {
                    coni.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


}




