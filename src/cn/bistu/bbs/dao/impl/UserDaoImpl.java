package cn.bistu.bbs.dao.impl;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.bistu.bbs.dao.UserDaoInf;
import cn.bistu.bbs.utils.JdbcUtil;
import com.xh.bbs.entity.UserEntity;


public class UserDaoImpl implements UserDaoInf {

    public UserEntity findUser(String userId, String passwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users where userid=? and userpassword=?";
        UserEntity user = null;
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, passwd);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new UserEntity();

                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setIs_admin(String.valueOf(rs.getInt(5)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }
        return user;
    }

    public int addUser(UserEntity user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into userS(userid,username,userpassword,useremail,isAdmin) values(?,?,?,?,?,?,?,?)";

        System.out.println(user.getUserid());

        int i = 0;
        try{
//			String newPassword=MD5.generateCode(user.getUser_password());
            conn = JdbcUtil.getConnection();

            ps = conn.prepareStatement(sql);
            //ps.setInt(1, null);
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(4, user.getEmail());


            i = ps.executeUpdate();

            System.out.println("插入数据库成功");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(null,ps, conn);
        }
        return i;
    }

    public void deleteUser(int uid){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        String sql="delete from userS  where userid=?";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.executeUpdate();

            System.out.println("删除用户成功!");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }

    }


    public void updateUser(UserEntity user){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
//		user_name,user_password,user_sex,user_face,user_phone,user_email,user_from

//		String sql="update user_info set user_name='"+user.getUser_name()+"',user_password='"+user.getUser_password()+"',user_sex='"+user.getUser_sex()+"',user_face='"+user.getUser_face()+"',user_phone='"+user.getUser_phone()+"',user_email='"+user.getUser_email()+"',user_from='"+user.getUser_from()+"' where user_id="+user.getUser_id()+"";
        String sql="update users set username=?,userpassword=?,useremail=?where userid=?";
        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);

            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setUserid((rs.getInt(4)));
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }

    }
    public UserEntity findUserById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users where userid=?";
        UserEntity user = null;
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new UserEntity();
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setIs_admin(String.valueOf(rs.getInt(5)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }
        return user;
    }

    public List<UserEntity> findUserlist(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        List<UserEntity> userlist=new ArrayList<UserEntity>();
        String sql="select * from users";

        try {
            conn=JdbcUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                UserEntity user=new UserEntity();
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setIs_admin(String.valueOf(rs.getInt(5)));

                userlist.add(user);
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JdbcUtil.close(rs, ps, conn);
        }


        return userlist;
    }

}