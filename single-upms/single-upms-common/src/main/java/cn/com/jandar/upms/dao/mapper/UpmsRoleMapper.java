package cn.com.jandar.upms.dao.mapper;

import cn.com.jandar.upms.dao.model.UpmsRole;
import cn.com.jandar.upms.dao.model.UpmsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsRoleMapper {
    long countByExample(UpmsRoleExample example);

    int deleteByExample(UpmsRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(UpmsRole record);

    int insertSelective(UpmsRole record);

    List<UpmsRole> selectByExample(UpmsRoleExample example);

    UpmsRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByExample(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByPrimaryKeySelective(UpmsRole record);

    int updateByPrimaryKey(UpmsRole record);
}