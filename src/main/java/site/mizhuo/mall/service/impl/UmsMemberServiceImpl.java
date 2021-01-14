package site.mizhuo.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import site.mizhuo.mall.common.api.CommonResult;
import site.mizhuo.mall.service.RedisService;
import site.mizhuo.mall.service.UmsMemberService;

import java.util.Optional;
import java.util.Random;

/**
 * @author: Mizhuo
 * @time: 2021/1/11 4:20 下午
 * @description: 会员管理Service实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号储存到Redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功!");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(!Optional.ofNullable(authCode).isPresent()){
            return CommonResult.failed("请输入验证码!");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if(authCode.equals(realAuthCode)){
            return CommonResult.success(null,"校验码验证成功!");
        }else{
            return CommonResult.failed("验证码不正确!");
        }
    }
}
