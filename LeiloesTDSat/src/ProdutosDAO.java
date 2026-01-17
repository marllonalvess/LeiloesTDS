/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {

        try {

            conn = new conectaDAO().connectDB();
            this.prep = this.conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES(?, ?, ?)");
            this.prep.setString(1, produto.getNome());
            this.prep.setInt(2, produto.getValor());
            this.prep.setString(3, produto.getStatus());
            int status = prep.executeUpdate();
        } catch (SQLException var1) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + var1.getMessage());

        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
