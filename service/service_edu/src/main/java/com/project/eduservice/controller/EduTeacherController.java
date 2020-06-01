package com.project.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.commonutils.Result;
import com.project.commonutils.ResultUtils;
import com.project.eduservice.entity.EduTeacher;
import com.project.eduservice.entity.queryBean.EduTeacherQueryBean;
import com.project.eduservice.service.EduTeacherService;
import com.project.eduservice.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 谷粒学院讲师表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-29
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
@Api(value ="讲师管理")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/findAll")
    public Result<List<EduTeacher>> findAll() {
        List<EduTeacher> list = eduTeacherService.list();
        return ResultUtils.genSuccessForResult(list);
    }

    @ApiOperation(value = "分页查询讲师信息", notes = "分页查询讲师信息")
    @PostMapping("findByPage/{page}/{pageSize}")
    public Result findByPage(@PathVariable("page") Long page,
                                               @PathVariable("pageSize") Long pageSize,
                                               @RequestBody(required = false) EduTeacherQueryBean eduTeacherQueryBean) {
        // 调用mp方法实现分页
        Page<EduTeacher> eduTeacherPage = new Page<EduTeacher>(page, pageSize);
        QueryWrapper wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(eduTeacherQueryBean.getName())) {
            wrapper.like("name", eduTeacherQueryBean.getName());
        }
        if (!StringUtils.isEmpty(eduTeacherQueryBean.getLevel())) {
            wrapper.eq("level", eduTeacherQueryBean.getLevel());
        }
        if (!StringUtils.isEmpty(eduTeacherQueryBean.getStartTime())) {
            wrapper.ge("gmt_create", eduTeacherQueryBean.getStartTime());
        }
        if (!StringUtils.isEmpty(eduTeacherQueryBean.getEndTime())) {
            wrapper.le("gmt_create", eduTeacherQueryBean.getEndTime());
        }
        eduTeacherService.page(eduTeacherPage,wrapper);
        // 总记录数
        long total = eduTeacherPage.getTotal();
        // 数据list集合
        List<EduTeacher> records = eduTeacherPage.getRecords();
        PageUtils pageUtils = new PageUtils();
        pageUtils.setTotal(total);
        pageUtils.setRows(records);
        return ResultUtils.genSuccessForResult(pageUtils);
    }

    @ApiOperation(value = "新增 修改讲师信息", notes = "新增修改讲师")
    @PostMapping("addOrUpdate")
    public Result addTeacher (@RequestBody EduTeacher eduTeacher) {
        if (!StringUtils.isEmpty(eduTeacher.getId())) {
            boolean flag = eduTeacherService.updateById(eduTeacher);
            if (flag) {
                return ResultUtils.genSuccessForResult("讲师更新成功");
            } else {
                return ResultUtils.genFailForResult("讲师更新失败");
            }
        }
        boolean flag = eduTeacherService.save(eduTeacher);
        if (flag) {
            return ResultUtils.genSuccessForResult("讲师新增成功");
        } else {
            return ResultUtils.genFailForResult("讲师新增失败");
        }
    }

    @ApiOperation(value = "查询讲师信息", notes = "查询讲师信息")
    @GetMapping("/getTeacher")
    public Result<EduTeacher> findById(String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        if (eduTeacher == null) {
            return ResultUtils.genFailForResult("讲师信息不存在");
        } else {
            return ResultUtils.genSuccessForResult(eduTeacher);
        }
    }

    @ApiOperation(value = "删除讲师信息", notes = "删除讲师信息")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return ResultUtils.genSuccessForResult("删除讲师信息成功");
        } else {
            return ResultUtils.genFailForResult("删除讲师信息失败");
        }
    }
}

