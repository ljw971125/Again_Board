package net.board.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// DB쿼리 실행
public class BoardDAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public BoardDAO() {
        try {
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
            con = ds.getConnection();
        } catch (Exception ex) {
            System.out.println("DB :" + ex);
            return;
        }
    }
    public int getListCount(){
        int x=0;

        try{
            pstmt = con.prepareStatement("select count(*) from board");
            rs=pstmt.executeQuery();

            if(rs.next()){
                x=rs.getInt(1);
            }

        }catch(Exception ex){
            System.out.println("getListCount : " + ex);
        }finally {
            if(rs != null) try{rs.close();} catch (SQLException ex){}
            if(pstmt != null) try{pstmt.close();} catch (SQLException ex){}

        }
        return x;
        }
        public List getBoardList(int page, int limit) {
            String board_list_sql =
            "select BOARD_NUM, BOARD_NAME,BOARD_SUBJECT,BOARD_CONTENT,BOARD_DATE " +
            "from board ";

            List list = new ArrayList();

            int startrow=(page-1)*10+1;
            int endrow=startrow+limit-1;
            try{
                pstmt = con.prepareStatement(board_list_sql);
                rs = pstmt.executeQuery();

                while(rs.next()){
                    BoardBean board = new BoardBean();
                    board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
                    board.setBOARD_NAME(rs.getString("BOARD_NAME"));
                    board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
                    board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
                    board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
                    list.add(board);
                }
                return list;
            }catch (Exception ex){
                System.out.println("getBoardList : " + ex);
            }finally {
                if(rs != null) try{rs.close();}catch (SQLException ex){}
                if(pstmt != null) try {pstmt.close();}catch (SQLException ex){}
            }
            return null;
        }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}

