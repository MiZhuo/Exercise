package site.mizhuo.mall.nosql.elasticsearch.repository;

import com.github.pagehelper.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import site.mizhuo.mall.nosql.elasticsearch.document.EsProduct;


/**
 * @author: Mizhuo
 * @time: 2021/1/14 9:20 下午
 * @description: 商品ES操作类
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {

    /**
     * 搜索查询
     * @param name      商品名称
     * @param subTitle  商品标题
     * @param keyWords  商品关键字
     * @param page      分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keyWords, Pageable page);
}
