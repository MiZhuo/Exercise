package site.mizhuo.mall.service.impl;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import site.mizhuo.mall.dao.EsProductDao;
import site.mizhuo.mall.nosql.elasticsearch.document.EsProduct;
import site.mizhuo.mall.nosql.elasticsearch.repository.EsProductRepository;
import site.mizhuo.mall.service.EsProductService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/1/14 9:41 下午
 * @description: 商品搜索管理Service实现类
 */
@Service
public class EsProductServiceImpl implements EsProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);

    @Autowired
    private EsProductDao productDao;

    @Autowired
    private EsProductRepository productRepository;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while(iterator.hasNext()){
            result ++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if(esProductList.size() > 0){
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            List<EsProduct> esProductList = new ArrayList<>();
            ids.forEach(id->{
                EsProduct product = new EsProduct();
                product.setId(id);
                esProductList.add(product);
            });
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword,pageable);
    }
}