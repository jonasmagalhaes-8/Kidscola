package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Dado_DuplicadoBanco
{
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    
    public static String checa_telefone2(Connection conexao,String tabela,String campo1,String campo2,String dado)
    {
        String sql="SELECT * FROM "+tabela+" where "+campo1+"=? || "+campo2+"=?";
        String error=null;
        
        try
        {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, dado);
            pst.setString(2, dado);
            rs = pst.executeQuery();
            
            if(rs.next())
            error="Telefone 2"+dado+" já cadastrado!";
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
        finally
        {
            try
            {
                pst.close();
                rs.close();
            }
            catch (Exception e)
            {
                
            }  
        }
        return error;
    }
}
