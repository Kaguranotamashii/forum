package cn.bistu.bbs.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import cn.bistu.bbs.entity.UserEntity;

/**
 * 帖子实体类
 */
public class ForumEntity {

    private int fid;
    private String title;
    private String userid;
    private String content;
    //	private Timestamp createTime;
    private Timestamp create_at;

    private UserEntity author = new UserEntity();

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
}
