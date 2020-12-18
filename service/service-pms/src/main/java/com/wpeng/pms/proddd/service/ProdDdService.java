package com.wpeng.pms.proddd.service;


import com.wpeng.commonutils.jpa.base.service.BaseService;
import com.wpeng.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.wpeng.pms.proddd.dao.ProdDdDao;
import com.wpeng.pms.proddd.entity.ProdDd;
import com.wpeng.pms.proddd.vo.ProdDdQuery;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/14 11:04
 *
 * 【管理-生产调度-逻辑层】
 */

@Service
@Api(tags = "【管理-生产调度-逻辑层】")
public class ProdDdService extends BaseService<ProdDdDao, ProdDd> {

    @Autowired
    private ProdDdDao prodDdDao;

    public List<ProdDd> findAll() {
        // 查询，调用 Dao
        return prodDdDao.findAll();
    }

    /**
     * 带条件分页查询
     * @param prodDdQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<ProdDd> findByCondAndPage(ProdDdQuery prodDdQuery, int pageNo, int pageSize) {
        // 指定需要查询的条件
        SimpleSpecificationBuilder<ProdDd> prodDdSimpleSpecificationBuilder = new SimpleSpecificationBuilder<>();

        /**
         * 可用操作符
         * = 等值、!= 不等值 (字符串、数字)
         * >=、<=、>、< (数字)
         * ge，le，gt，lt(字符串)
         * :表示like %v%
         * l:表示 v%
         * :l表示 %v
         * null表示 is null
         * !null表示 is not null
         */
        if (!StringUtils.isEmpty(prodDdQuery.getOrderName())) {
            prodDdSimpleSpecificationBuilder.and("orderName", ":", prodDdQuery.getOrderName());
        }
        if (!StringUtils.isEmpty(prodDdQuery.getOrderType()) && prodDdQuery.getOrderType() != 0) {
            prodDdSimpleSpecificationBuilder.and("orderType", "=", prodDdQuery.getOrderType());
        }
        if (!StringUtils.isEmpty(prodDdQuery.getGmtCreateStart())) {
            prodDdSimpleSpecificationBuilder.and("gmtCreateStart", ">=", prodDdQuery.getGmtCreateStart());
        }
        if (!StringUtils.isEmpty(prodDdQuery.getGmtCreateEnd())) {
            prodDdSimpleSpecificationBuilder.and("gmtCreateEnd", "<=", prodDdQuery.getGmtCreateEnd());
        }

        Page page = prodDdDao.findAll(prodDdSimpleSpecificationBuilder.getSpecification(), PageRequest.of(pageNo -1, pageSize));

        return page;
    }

}
