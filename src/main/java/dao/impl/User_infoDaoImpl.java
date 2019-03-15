package dao.impl;

import bean.User_info;
import dao.User_infoDao;
import dao.dbutils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class User_infoDaoImpl implements User_infoDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public List<User_info> getList() {
        List<User_info> list = new ArrayList<>();
        String sql = "select * from user_info";
        try{
            list = qr.query(sql, new BeanListHandler<>(User_info.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User_info getBean(String TrueName) {
        User_info user_info = null;
        String sql = "select * from leave_user where TrueName = ?";
        try {
            user_info = qr.query(sql, new BeanHandler<>(User_info.class), TrueName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user_info;
    }

//    @Override
//    public void create(User_info user_info) {
//        String sql = "insert into leave_user(name, type, password) values (?, ?, ?)";
//        try{
//            qr.update(sql, user.getName(), user.getType(), user.getPassword());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String name) {
//        String sql = "delete from leave_user where name=?";
//        try{
//            qr.update(sql, name);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(User user) {
//        String sql = "update leave_user set name=?, type=?, password=? where name=?";
//        try{
//            qr.update(sql, user.getName(), user.getType(), user.getPassword());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
