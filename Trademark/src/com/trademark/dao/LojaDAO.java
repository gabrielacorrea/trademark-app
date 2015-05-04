package com.trademark.dao;

import com.trademark.bean.LojaBean;

import java.sql.*;
import java.util.ArrayList;

public class LojaDAO {

    public ArrayList<LojaBean> pesquisarLojas() {
        Connection connection = null;
        ArrayList<LojaBean> list = new ArrayList<LojaBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/trademark_db",
                    "postgres", "112233");

            Statement st = connection.createStatement();

            String sql = "SELECT id,nome FROM lojas order by nome asc";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                LojaBean bean = new LojaBean();
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
