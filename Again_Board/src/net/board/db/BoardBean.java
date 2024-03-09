package net.board.db;
// DB값을 저장하는 곳
import java.sql.Date;
public class BoardBean {
    private int BOARD_NUM; // 게시글 번호
    private String BOARD_NAME; // 작성자
    private String BOARD_SUBJECT; // 제목
    private String BOARD_CONTENT; // 내용
    private Date BOARD_DATE; // 날짜

    public int getBOARD_NUM() {
        return BOARD_NUM;
    }

    public void setBOARD_NUM(int BOARD_NUM) {
        this.BOARD_NUM = BOARD_NUM;
    }

    public String getBOARD_NAME() {
        return BOARD_NAME;
    }

    public void setBOARD_NAME(String BOARD_NAME) {
        this.BOARD_NAME = BOARD_NAME;
    }

    public String getBOARD_SUBJECT() {
        return BOARD_SUBJECT;
    }

    public void setBOARD_SUBJECT(String BOARD_SUBJECT) {
        this.BOARD_SUBJECT = BOARD_SUBJECT;
    }

    public String getBOARD_CONTENT() {
        return BOARD_CONTENT;
    }

    public void setBOARD_CONTENT(String BOARD_CONTENT) {
        this.BOARD_CONTENT = BOARD_CONTENT;
    }

    public Date getBOARD_DATE() {
        return BOARD_DATE;
    }

    public void setBOARD_DATE(Date BOARD_DATE) {
        this.BOARD_DATE = BOARD_DATE;
    }
}
