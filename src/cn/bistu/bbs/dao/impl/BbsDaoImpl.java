package cn.bistu.bbs.dao.impl;

import cn.bistu.bbs.dao.BbsDaoInf;
import cn.bistu.bbs.entity.ForumEntity;
import cn.bistu.bbs.entity.ReplyEntity;
import cn.bistu.bbs.entity.UserEntity;
import cn.bistu.bbs.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BbsDaoImpl implements BbsDaoInf {
    //查询帖子列表
    public List<ForumEntity> findForumList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ForumEntity> list = new ArrayList<ForumEntity>();
        String sql = "select * from forum";
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ForumEntity forum = new ForumEntity();
                forum.setFid(rs.getInt(1));
                forum.setTitle(rs.getString(2));
                forum.setContent(rs.getString(3));
                forum.setCreate_at(rs.getTimestamp(4));
                //获取对应用户表中的外键
                UserEntity author = new UserEntity();
                author.setUserid(rs.getInt(5));
                forum.setAuthor(author);
                list.add(forum);
                System.out.println("查询所有帖子:"+rs.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }
        return list;
    }

    //根据ID查询某个帖子
    public ForumEntity findForumById(int fid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ForumEntity forum = null;
        String sql = "select * from forum  where fid = ?";
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            if(rs.next()){
                forum = new ForumEntity();
                forum.setFid(rs.getInt(1));
                forum.setTitle(rs.getString(2));
                forum.setContent(rs.getString(3));
                forum.setCreate_at(rs.getTimestamp(4));
                //获取对应用户表中的外键
                UserEntity author = new UserEntity();
                author.setUserid(rs.getInt(5));
                forum.setAuthor(author);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }
        return forum;
    }

    //添加帖子
    public int addForum(ForumEntity forum) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into forum (title,content,created_at,userid) values(?,?,?,?)";


        System.out.println("添加帖子");
        int i = 0;
        System.out.println(forum.getCreate_at());
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, forum.getTitle());
            ps.setString(2, forum.getContent());
            ps.setTimestamp(3, forum.getCreate_at());
            ps.setInt(4, forum.getAuthor().getUserid());
            i = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null, ps, conn);
        }
        return i;
    }

    //查询帖子对应的所有回复
    public List<ReplyEntity> findReplyList(int fid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ReplyEntity> list = new ArrayList<ReplyEntity>();
        //根据外键作为条件查询当前帖子的所有回复
        String sql = "select * from reply where fid = ?";
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while(rs.next()){
                ReplyEntity reply = new ReplyEntity();
                reply.setRid(rs.getInt(1));
                reply.setContent(rs.getString(2));
                reply.setReplyTime(rs.getTimestamp(3));
                //获取对应用户表中的外键
                UserEntity replyUser = new UserEntity();
                replyUser.setUserid(rs.getInt(4));
                reply.setUser(replyUser);
                list.add(reply);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }
        return list;
    }


    //添加回复
    public int addReply(ReplyEntity reply) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;

        System.out.println("添加回复成功");
        String sql = "insert into reply (reply_content,reply_time,user_id,fid) values(?,?,?,?)";
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, reply.getContent());
            ps.setTimestamp(2, reply.getReplyTime());
            //将相应的两个外键设值
            ps.setInt(3, reply.getUser().getUserid());
            ps.setInt(4, reply.getForum().getFid());
            i = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null, ps, conn);
        }
        return i;
    }

    //根据用户ID查询用户的所有发帖
    public List<ForumEntity> personForum(int pid){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        String sql="select * from forum where userid=?";
        List<ForumEntity> list=new ArrayList<ForumEntity>();

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs=ps.executeQuery();

            while(rs.next()){
                ForumEntity forum=new ForumEntity();
                forum.setFid(rs.getInt(1));
                forum.setTitle(rs.getString(2));
                forum.setContent(rs.getString(3));
                forum.setCreate_at(rs.getTimestamp(4));
                UserEntity user=new UserEntity();
                user.setUserid(rs.getInt(5));
                forum.setAuthor(user);
                list.add(forum);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    //用户删除个人某个帖子
    public void deleteForum(int fid){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from forum  where fid=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, fid);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null, ps, conn);
        }
    }

    //根据帖子id删除所有回复
    public void deleteReply(int fid){

        System.out.println(fid);
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from reply  where fid=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, fid);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
           JdbcUtil.close(null,ps,conn);
        }
    }

    //用户删除某个回帖
    public void deleteReplyByRid(int rid){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from reply  where reply_id=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, rid);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,ps,conn);
        }
    }

    //用户管理模块
    //删除用户所有发帖
    public void dUserAllforumByUid(int uid){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from forum  where userid=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, uid);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,ps,conn);
        }
    }


    //删除用户的所有回帖
    public void dUserAllreplyByUid(int uid){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from reply  where user_id=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, uid);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
           JdbcUtil.close(null,ps,conn);
        }
    }

    //删除用户帖子下的所有回帖
    public void dUserOtherRelyByFid(int uid){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        String sql="select fid from forum  where userid=?";

        List<ForumEntity> fidlist=new ArrayList<ForumEntity>();
        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, uid);
            rs=ps.executeQuery();
            while(rs.next()){
                ForumEntity forum=new ForumEntity();
                forum.setFid(rs.getInt(1));
                fidlist.add(forum);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,ps,conn);
        }

        String fsql="delete from reply where fid=?";

        try {


            for(ForumEntity forum : fidlist){
                conn=JdbcUtil.getConnection();
                ps=conn.prepareStatement(fsql);
                ps.setInt(1, forum.getFid());

                ps.executeUpdate();
                JdbcUtil.close(null,ps,conn);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
