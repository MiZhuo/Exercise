package site.mizhuo.mall.service;

import site.mizhuo.mall.model.PmsBrand;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/1/10 9:06 下午
 * @description:
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
