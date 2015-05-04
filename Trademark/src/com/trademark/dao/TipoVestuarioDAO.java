package com.trademark.dao;

import com.trademark.bean.TipoVestuarioBean;

import java.sql.*;
import java.util.ArrayList;

public class TipoVestuarioDAO {

    public ArrayList<TipoVestuarioBean> pesquisarTipoVestuario() {
        Connection connection = null;
        ArrayList<TipoVestuarioBean> list = new ArrayList<TipoVestuarioBean>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/trademark_db",
                    "postgres", "112233");

            Statement st = connection.createStatement();

            String sql = "SELECT id,tipo FROM tipo_vestuario order by tipo asc";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                TipoVestuarioBean bean = new TipoVestuarioBean();
                bean.setId(rs.getInt("id"));
                bean.setTipo(rs.getString("tipo"));
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
