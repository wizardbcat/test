package com.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.bean.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/11/29
 */
public class CategoryDao {

    public boolean  addCategory(Category category) throws SQLException {

        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="insert into category values(null,?,?,?,?)";
        int row = queryRunner.update(sql, category.getC_name(), category.getPlace(), category.getCreatetime(), category.getType());
         if (row>0){
             return true;
         }else {
             return false;
         }

    }

    public List<Category> queryCategoryList() throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select * from category";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
          return categoryList;
    }
    public List<Category> queryPageCategoryList(int startPosition,int currentCount) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select * from category limit ?,?";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class),startPosition,currentCount);
        return categoryList;
    }

//    public List<Category> queryCategoryLimit(int start,int currentCount) throws SQLException {
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        QueryRunner queryRunner=new QueryRunner(dataSource);
//        String sql="select * from category limit ?,?";
//        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class),start,currentCount);
//        return categoryList;
//    }

//    /**
//     * @method:queryCount 查询数据总数
//     * @date: 2017/7/8
//     * @params:[]
//     * @return: int
//     */
//    public int queryCount() throws SQLException {
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        QueryRunner queryRunner=new QueryRunner(dataSource);
//        String sql="select count(*) from category";
//        Long query = queryRunner.query(sql, new ScalarHandler<>());
//        return query.intValue();
//    }

    /**
     * @method:updateCategory
     * @date: 2020/11/29
     * @params:[category]
     * @return: boolean
     */
    public boolean updateCategory(Category category) throws SQLException {

        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="update category set c_name=?,place=?,type=? where c_id=?";
        int row = queryRunner.update(sql, category.getC_name(), category.getPlace(), category.getType(),category.getC_id());
        if (row>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * @method:deleteCategory 操作数据库删除学生信息
     * @date: 2020/11/29
     * @params:[category]
     * @return: boolean
     */
    public boolean deleteCategory(Category category) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="delete from category where c_id=?";
        int row = queryRunner.update(sql,category.getC_id());
        return row>0?true:false;
    }

    public int queryCount() throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select count(*) from category";
        Long query = queryRunner.query(sql, new ScalarHandler<>());
        return query.intValue();
    }
}
