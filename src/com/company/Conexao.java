package com.company;

import java.sql.*;

public class Conexao {




    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro";

    public static void main(String[] args) {
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            stm = connection.createStatement();
            stm.executeUpdate("alter table produtos add column Validade varchar(30)");
            stm.executeUpdate("insert into produtos values ( 6, 'Biscoito' , 'R$ 2.99', '5 Unidades'  , 'Valido até 28-04-2025') ");
            stm.executeUpdate("alter table produtos drop column Validade");
            stm.executeUpdate("delete from produtos where idprodutos = '5'");
            rs = stm.executeQuery("select * from produtos");

            while (rs.next())
                System.out.println(rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getString(3) +
                        " " + rs.getString(4));
            connection.close();

        } catch (SQLException se){
            se.printStackTrace();
        }
    }

}
