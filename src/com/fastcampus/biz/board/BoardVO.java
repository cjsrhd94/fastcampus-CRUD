package com.fastcampus.biz.board;

import java.util.Date;

// VO(Value Object) 클래스
public class BoardVO {
    // BOARD 테이블의 컬럼을 참조한 멤버변수 선언
    // 컬럼의 데이터 타입과 일치시켜줘야한다.
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", cnt=" + cnt +
                '}';
    }
}
