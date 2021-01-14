package site.mizhuo.mall.dao;

import io.lettuce.core.dynamic.annotation.Param;
import site.mizhuo.mall.model.UmsPermission;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/1/11 9:41 下午
 * @description:
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
