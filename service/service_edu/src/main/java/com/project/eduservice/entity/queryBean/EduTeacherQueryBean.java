package com.project.eduservice.entity.queryBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 谷粒学院讲师表
 * </p>
 *
 * @author testjava
 * @since 2020-04-29
 */
@Data
@ApiModel(value="EduTeacherQueryBean", description="谷粒学院讲师查询对象")
public class EduTeacherQueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1-高级讲师 2-首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String startTime;

    @ApiModelProperty(value = "查询结束时间", example = "2019-01-01 10:10:10")
    private String endTime;


}
