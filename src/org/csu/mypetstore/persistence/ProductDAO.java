package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import java.util.List;

public interface ProductDAO {

    //根据类别返回产品清单
    List<Product> getProductListByCategory(String categoryId);

    //根据产品ID获得指定产品
    Product getProduct(String productId);

    //根据关键字搜索产品的集合
    List<Product> searchProductList(String keywords);
}
