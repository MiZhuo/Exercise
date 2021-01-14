package site.mizhuo.mall.service;

import site.mizhuo.mall.common.api.CommonResult;

/**
 * @author: Mizhuo
 * @time: 2021/1/11 4:18 下午
 * @description: 会员管理Service
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 校验验证码
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
