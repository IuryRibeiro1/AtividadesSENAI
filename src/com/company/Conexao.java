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
            //Este comando permite alterar tabela criando uma coluna no banco de dados.
            stm.executeUpdate("alter table produtos add column Validade varchar(30)");
            //Este comando insere dados na tabela selecionado (nesse caso aqui a tabela ''produtos'' recebe novos valores.
            stm.executeUpdate("insert into produtos values ( 6, 'Biscoito' , 'R$ 2.99', '5 Unidades'  , 'Valido até 28-04-2025') ");
            //Este comando permite alterar tabela deletando uma coluna no banco dados.
            stm.executeUpdate("alter table produtos drop column Validade");
            //Comando de manipulação de linhas, deletando a linha '5' selecionada da tabela 'Produtos'
            stm.executeUpdate("delete from produtos where idprodutos = '5'");
            //Comando que executa a consulta de todos os dados dentro da tabela 'produtos'.
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

