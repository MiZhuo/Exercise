package site.mizhuo.mall.dao;

import org.apache.ibatis.annotations.Param;
import site.mizhuo.mall.nosql.elasticsearch.document.EsProduct;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/1/14 9:42 下午
 * @description:
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
