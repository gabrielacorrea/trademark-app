package com.trademark.dao;

import com.trademark.bean.LojaBean;
import com.trademark.bean.MarcaBean;
import com.trademark.bean.PostagemBean;
import com.trademark.bean.UsuarioBean;

import java.sql.*;
import java.util.ArrayList;

public class PostagemDao {

    public ArrayList<PostagemBean> pesquisarPostagens() {
        Connection connection = null;
        ArrayList<PostagemBean> list = new ArrayList<PostagemBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/trademark_db",
                    "postgres", "112233");

            Statement st = connection.createStatement();

            String sql = "SELECT a.data_inicial, a.descricao, a.imagem, a.preco,"
                    + " b.nome AS marca,"
                    + " c.nome AS loja,"
                    + " d.nome AS postado_por,"
                    + " e.tipo"
                    + " FROM postagens a"
                    + " JOIN marcas b ON a.id_marca = b.id"
                    + " JOIN lojas c ON a.id_loja = c.id"
                    + " JOIN usuarios d ON a.id_usuario = d.id"
                    + " JOIN tipo_vestuario e on a.tipo_vestuario = e.id"
                    + " ORDER BY data_inicial desc, preco asc"
                    + " LIMIT 10";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                PostagemBean bean = new PostagemBean();
                bean.setLoja(rs.getString("loja"));
                bean.setMarca(rs.getString("marca"));
                bean.setPostadoPor(rs.getString("postado_por"));
                bean.setTipoVestuario(rs.getString("tipo"));
                bean.setDataInicial(rs.getTimestamp("data_inicial"));
                bean.setDescricao(rs.getString("descricao"));
                bean.setImgPath(rs.getString("imagem"));
                bean.setPreco(rs.getDouble("preco"));
                list.add(bean);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

    public ArrayList<PostagemBean> pesquisarComFiltros(int marca, int tipo, int loja, double preco) {
        Connection connection = null;
        ArrayList<PostagemBean> postagens = new ArrayList<PostagemBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/trademark_db",
                    "postgres", "112233");

            Statement st = connection.createStatement();

            String sql = "SELECT a.data_inicial, a.descricao, a.imagem, a.preco,"
                    + " b.nome AS marca,"
                    + " c.nome AS loja,"
                    + " d.nome AS postado_por,"
                    + " e.tipo"
                    + " FROM postagens a"
                    + " JOIN marcas b ON a.id_marca = b.id"
                    + " JOIN lojas c ON a.id_loja = c.id"
                    + " JOIN usuarios d ON a.id_usuario = d.id"
                    + " JOIN tipo_vestuario e on a.tipo_vestuario = e.id"
                    + " WHERE 1 = 1";

            if (marca != -1) {
                sql = sql + " and a.id_marca = " + marca;
            }
            if (loja != -1) {
                sql = sql + " and a.id_loja = " + loja;
            }
            if (tipo != -1) {
                sql = sql + " and a.tipo_vestuario = " + tipo;
            }
            if(preco > 0){
            	sql = sql + " and a.preco >= " + preco;
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                PostagemBean bean = new PostagemBean();
                bean.setLoja(rs.getString("loja"));
                bean.setMarca(rs.getString("marca"));
                bean.setPostadoPor(rs.getString("postado_por"));
                bean.setTipoVestuario(rs.getString("tipo"));
                bean.setDataInicial(rs.getTimestamp("data_inicial"));
                bean.setDescricao(rs.getString("descricao"));
                bean.setImgPath(rs.getString("imagem"));
                bean.setPreco(rs.getDouble("preco"));
                postagens.add(bean);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return postagens;
    }

    public ArrayList<LojaBean> selecaoLojas() {
        Connection connection = null;
        ArrayList<LojaBean> lojas = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            Statement st = connection.createStatement();
            String sql = "Select * from lojas order by nome";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                LojaBean bean = new LojaBean();
                bean.setId(rs.getInt("id"));
                bean.setNome(rs.getString("nome"));
                bean.setDescricao(rs.getString("descricao"));
                bean.setEndereco(rs.getString("endereco"));
                bean.setNumero(rs.getInt("numero"));
                bean.setBairro(rs.getString("bairro"));
                lojas.add(bean);
            }
            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lojas;
    }

    public ArrayList<MarcaBean> selecaoMarcas() {
        Connection connection = null;
        ArrayList<MarcaBean> marcas = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            Statement st = connection.createStatement();
            String sql = "Select * from marcas order by nome";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                MarcaBean bean = new MarcaBean();
                bean.setId(rs.getInt("id"));
                bean.setNome(rs.getString("nome"));
                bean.setDescricao(rs.getString("descricao"));
                marcas.add(bean);
            }
            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return marcas;
    }

    public int pesquisaUsuario(String nome, String email) {
        Connection connection = null;
        int idUsuario = 0;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            String sql = "Select id from usuarios where nome = ? and email = ?";
            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setString(1, nome);
            prepare.setString(2, email);

            ResultSet rs = prepare.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("id");
            } else {
                insereUsuario(nome, email);
                idUsuario = pesquisaUsuario(nome, email);
            }

            rs.close();
            prepare.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return idUsuario;
    }

    public void inserePostagem(String descricao, String imagem, int tipoProduto, int loja, int marca, 
    		UsuarioBean usuario, double preco) {
        Connection connection = null;

        try {
            int idUsuario = pesquisaUsuario(usuario.getNome(), usuario.getEmail());

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            String sqlInsert = "insert into postagens "
            		+ "(id, data_inicial, descricao, imagem, tipo_vestuario, id_loja, id_marca, id_usuario, preco) " +
                    "values(nextval('id_postagens'), current_timestamp, ?, ? , ?, ?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, descricao);
            stmt.setString(2, imagem);
            stmt.setInt(3, tipoProduto);
            stmt.setInt(4, loja);
            stmt.setInt(5, marca);
            stmt.setInt(6, idUsuario);
            stmt.setDouble(7, preco);

            stmt.execute();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insereUsuario(String nome, String email) {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            String sqlInsert = "insert into usuarios (id, nome, email, senha) " +
                    "values(nextval('id_usuarios'), ? , ?, 'senha')";

            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, nome);
            stmt.setString(2, email);

            stmt.execute();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
