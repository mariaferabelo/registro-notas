package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conector;

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");

            // URL com SSL obrigatório (Neon exige)
            String url = "jdbc:postgresql://ep-hidden-glitter-actpv1uq-pooler.sa-east-1.aws.neon.tech:5432/neondb?sslmode=require";
            String usuario = "neondb_owner";
            String senha = "npg_izZeM5pRE7CI";

            conector = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado ao Neon com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao Neon: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void desconectar() {
        if (conector != null) {
            try {
                conector.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}