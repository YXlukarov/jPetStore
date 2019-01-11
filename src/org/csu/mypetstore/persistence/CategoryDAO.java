package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;
import java.util.List;

public interface CategoryDAO {

    //返回所有大类的一个集合
    List<Category> getCategoryList();

    //根据类的ID返回某一类
    Category getCategory(String categoryId);
}
