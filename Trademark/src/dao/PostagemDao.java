package dao;

import java.sql.*;
import java.util.ArrayList;

public class PostagemDao {

    public ArrayList<PostagemBean> pesquisarPostagens() {
        Connection connection = null;
        ArrayList<PostagemBean> list = new ArrayList<PostagemBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            Statement st = connection.createStatement();
            String sql = "Select * from postagens order by 1";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                PostagemBean bean = new PostagemBean();
                bean.setId(rs.getInt("id"));
                bean.setDataInicial(rs.getTimestamp("data_inicial"));
                bean.setDescricao(rs.getString("descricao"));
                bean.setIdLoja(rs.getInt("id_loja"));
                bean.setIdMarca(rs.getInt("id_marca"));
                bean.setImgPath(rs.getString("imagem"));
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


    public void inserePostagem() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trademark_db", "postgres", "112233");
            String sqlInsert = "insert into postagens values(1, current_timestamp, 'descricao a', '/Users/gcorrea/Faculdade/projeto-desenvolvimento/trademark-app/Trademark/WebContent/imagens/1' ,'calcado', 1, 1, 1)";

            PreparedStatement stmt = connection.prepareStatement(sqlInsert);

            /*
            stmt.setString(1, 1);
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            stmt.setString(4, usuario.getNome());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getEndereco());
            */

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
