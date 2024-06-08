package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */

    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
/**
 * 插入员工数据
 * @param employee:
 * @return void
 * @author 23774
 * @description
 * @date 2024/4/29 21:00
 */

@Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status) " +
        "values " +
        "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    void insert(Employee employee);

/**
 * @param employeePageQueryDTO:
 * @return Page<Employee>
 * @description 分页查询
 * @date 2024/5/4 23:12
 */

    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * @param employee:
     * @return void
     * @author yxb
     * @description 根据主键动态修改属性
     * @date 2024/6/1 20:45
     */

    void update(Employee employee);

    /**
     * @param id:
     * @return Employee
     * @author yxb
     * @description 根据id查询员工信息
     * @date 2024/6/8 16:51
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
