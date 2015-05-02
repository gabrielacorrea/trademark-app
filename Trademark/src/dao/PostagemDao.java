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
}
