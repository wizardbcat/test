package com.service;

import com.bean.User;
import com.dao.UserDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2020/11/29
 */
public class UserService {
    /**
     * @method:register 用户注册
     * @date: 2020/11/29
     * @params:[name, password, email]
     * @return: boolean
     */
    //1. 判断注册用户是否存在
    public boolean register(User user) {


        boolean register=false;
        UserDao userDao = new UserDao();
        boolean checkUser = userDao.checkUser(user.getName());
        //2. 如果不存在就将用户信息添加到数据库
        if (checkUser) {
             register = userDao.register(user);
        }
        return register;
    }


    /**
     * @method:login 用户登录
     * @date: 2020/11/29
     * @params:[name, password]
     * @return: void
     */
    public User login(String name, String password) throws SQLException {
        UserDao userDao=new UserDao();
        User user = userDao.login(name, password);
        return  user;
    }


}
