package com.trademark.test;

import com.trademark.bean.PostagemBean;
import com.trademark.dao.PostagemDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) throws SQLException {
        PostagemDao dao = new PostagemDao();

        ArrayList<PostagemBean> posts = dao.pesquisarPostagens();

        for (PostagemBean p : posts) {
            System.out.println(p.getImgPath());
        }
    }

}
