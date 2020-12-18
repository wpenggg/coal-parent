package com.wpeng.pms.proddd.dao;

import com.wpeng.commonutils.jpa.base.dao.BaseDao;
import com.wpeng.pms.proddd.entity.ProdDd;
import io.swagger.annotations.Api;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/14 11:04
 *
 * 【管理-生产调度-数据交互层】
 */
@Api(tags = "【管理-生产调度-数据交互层】")
public interface ProdDdDao extends BaseDao<ProdDd, String> {
}
