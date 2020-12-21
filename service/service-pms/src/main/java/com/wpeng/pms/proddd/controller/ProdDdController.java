package com.wpeng.pms.proddd.controller;

import com.wpeng.commonutils.api.APICODE;
import com.wpeng.pms.proddd.entity.ProdDd;
import com.wpeng.pms.proddd.service.ProdDdService;
import com.wpeng.pms.proddd.vo.ProdDdQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/14 11:03
 *
 * 【管理-生产调度-控制层】
 */
@RestController // 包含了 @Controller  和  @ResponseBody
@RequestMapping("/pms/prodDd")
@Api(tags = "【管理-生产调度-控制层】")
public class ProdDdController {

    @Autowired
    private ProdDdService prodDdService;

    /**
     * 查询所有指令
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询所有指令")
    public APICODE findAll() {
        // 查询,调用逻辑层
        List<ProdDd> prodDds = prodDdService.findAll();

        int i = 1 / 0;

        return APICODE.OK()
                .dataMap("items", prodDds);
    }

    @PostMapping("{pageNo}/{pageSize}")
    @ApiOperation(value = "带条件分页查询")
    public APICODE findByCondAndPage(ProdDdQuery prodDdQuery, @PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize) {
        // 查询
        Page<ProdDd> page = prodDdService.findByCondAndPage(prodDdQuery, pageNo, pageSize);

        long totalElements = page.getTotalElements(); //总条数
        List<ProdDd> prodDdList = page.getContent(); // 数据
        return APICODE.OK()
                .dataMap("prodDdList", prodDdList)
                .dataMap("total", totalElements)
                .message("查询成功！^_^");
    }

    @PostMapping("insert")
    @ApiOperation(value = "新增指令")
    public APICODE insert(@RequestBody ProdDd prodDd) {

        prodDdService.saveOrUpdate(prodDd);

        return APICODE.OK();
    }

    @GetMapping("{prodDdId}")
    @ApiOperation(value = "根据 id 查询单条指令")
    public APICODE findOneById(@PathVariable(name = "prodDdId") String prodDdId) {
        ProdDd prodDd = prodDdService.getById(prodDdId);

        return APICODE.OK()
                .dataMap("obj", prodDd);
    }

    @PutMapping
    @ApiOperation(value = "根据 id 修改指令")
    public APICODE update(@RequestBody ProdDd prodDd) {
        prodDdService.saveOrUpdate(prodDd);
        return APICODE.OK();
    }

    @DeleteMapping("{prodDdId}")
    @ApiOperation(value = "根据 id 删除单条指令")
    public APICODE deleteById(@PathVariable(name = "prodDdId") String prodDdId) {
        prodDdService.removeById(prodDdId);
        return APICODE.OK();
    }

}
