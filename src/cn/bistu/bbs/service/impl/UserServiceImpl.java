package cn.bistu.bbs.service.impl;

import cn.bistu.bbs.dao.UserDaoInf;
import cn.bistu.bbs.dao.impl.UserDaoImpl;
import cn.bistu.bbs.service.UserServiceInf;
import cn.bistu.bbs.entity.UserEntity;

import java.util.List;

public class UserServiceImpl implements UserServiceInf {
    @Override
    public UserEntity login(String userId, String passwd) {
        UserDaoInf userDao = new UserDaoImpl();
        UserEntity user = userDao.findUser(userId, passwd);
        return (user==null) ? null : user;
    }

    @Override
    public int saveUser(UserEntity user) {
        return 0;
    }

    @Override
    public void deleteUser(int uid) {

    }

    @Override
    public void updateUser(UserEntity user) {

    }

    @Override
    public UserEntity findUser(int uid) {
        return null;
    }

    @Override
    public List<UserEntity> findUserList() {
        return null;
    }
}
