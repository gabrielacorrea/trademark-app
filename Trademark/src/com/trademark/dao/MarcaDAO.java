package com.trademark.dao;

import com.trademark.bean.MarcaBean;

import java.sql.*;
import java.util.ArrayList;

public class MarcaDAO {
    public ArrayList<MarcaBean> pesquisarMarcas() {
        Connection connection = null;
        ArrayList<MarcaBean> list = new ArrayList<MarcaBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/trademark_db",
                    "postgres", "112233");

            Statement st = connection.createStatement();

            String sql = "SELECT id,nome FROM marcas order by nome asc";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                MarcaBean bean = new MarcaBean();
                bean.setId(rs.getInt("id"));
                bean.setNome(rs.getString("nome"));
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
