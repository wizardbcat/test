package com.service;

import com.bean.Page;
import com.dao.CategoryDao;
import com.bean.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/11/29
 */
public class CategoryService {
    /**
     * @method:addCategory 添加学生数据
     * @params:[category]
     * @return: boolean
     */
    public boolean addCategory(Category category) throws SQLException {

        CategoryDao dao = new CategoryDao();
        boolean addCategory = dao.addCategory(category);
        return addCategory;
    }

    /**
     * @method:findCategory 查询所有学生数据
     * @params:[]
     */
    public List<Category> findCategory() throws SQLException {
        CategoryDao dao = new CategoryDao();
        List<Category> categories = dao.queryCategoryList();
        return categories;
    }
    /**
     * @method:findPageCategory 分页查询学生数据
     * @params:[currentPage, currentCount]
     * @return:
     */
    public Page findPageCategory(int currentPage, int currentCount) throws SQLException {

        Page page=new Page();
        // 1 查询出学生数据的总数
        CategoryDao dao = new CategoryDao();
        int totalCount = dao.queryCount();

        /*  总数   每页显示数目  总页数
             9        10    0.9     1
             10       10     1      1
             11       10    1.1     2
            java ceil
         */
        // 2 根据总数和当前页显示数 计算出总页数
        int totalPage= (int) Math.ceil(1.0*totalCount/currentCount);
        //3 将分页相关信息封装到page类中
        page.setCurrentCount(currentCount);
        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);

        // 计算查询的起始位置
//        页数  每页显示条数  起始位置
//
//        1        3           0
//        2        3           3
//        3        3           6  （currentPage-1）*currentCount
        //计算出起始位置
         int startPosition=(currentPage-1)*currentCount;
         // 分页查询数据
         List<Category> categories = dao.queryPageCategoryList(startPosition,currentCount);
        // 将集合数据封装到page类中
        page.setList(categories);

         return page;
    }

    public boolean updateCategory(Category category) throws SQLException {
        CategoryDao dao=new CategoryDao();
        boolean updateCategory = dao.updateCategory(category);
        return updateCategory;
    }

    /**
     * @method:deleteCategory servcie删除学生信息数据
     * @date: 2020/11/29
     * @params:[category]
     * @return: boolean
     */
    public boolean deleteCategory(Category category) throws SQLException {
        CategoryDao dao=new CategoryDao();
        boolean updateCategory = dao.deleteCategory(category);
        return updateCategory;
    }
}
