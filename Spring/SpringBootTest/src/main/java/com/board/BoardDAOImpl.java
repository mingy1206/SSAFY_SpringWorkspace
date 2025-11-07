package com.board;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// controller에서 호출하면 db작업 후 결과를 controller에 넘겨 줌
// db작업 하는 객체(Create Read Update Delete )
@Component
public class BoardDAOImpl implements BoardDAO {
    DBUtil util = DBUtil.getInstance();

    @Override
    public ArrayList<Board> selectAll() throws Exception {
        String q = "select * from board order by num desc";

        Connection conn = util.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(q);
        ArrayList<Board> list = new ArrayList<>();
        while (rs.next()){
            String num =rs.getString("num");
            String name =rs.getString("name");
            String wdate =  rs.getString("wdate");
            String title =rs.getString("title");
            String count = rs.getString("count");
            Board b = new Board(num, null, name, wdate, title,null,count);
            list.add(b);
        }
        return list;
    }

    @Override
    public Board selectOne(String num) throws Exception {
        return null;
    }

    @Override
    public int insert(Board b) throws Exception {
        String q = "insert into board(pass,name,wdate,title,content, count) values(?,?,sysdate(),?,?,0)";

        Connection conn = util.getConnection();
        PreparedStatement pstat = conn.prepareStatement(q);
        // statement는 매 쿼리문을 컴파일
        // preapared statement는 db에서 처음에만 컴파일하고 동일한 쿼리문은 컴파일 안함

        pstat.setString(1, b.getPass());
        pstat.setString(2, b.getName());
        pstat.setString(3, b.getTitle());
        pstat.setString(4, b.getContent());
        return pstat.executeUpdate();
    }

    @Override
    public int delete(String num) throws Exception {

        return 0;
    }
}
