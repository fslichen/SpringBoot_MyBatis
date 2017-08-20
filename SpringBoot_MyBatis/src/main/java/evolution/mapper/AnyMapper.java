package evolution.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import evolution.entity.AnyEntity;

@Mapper
public interface AnyMapper {
    @Select("select * from any_table where name = #{name}")
    public List<AnyEntity> findByName(@Param("name") String name);
    
    public List<Map<String, Object>> findAll();
    
    public List<AnyEntity> findById(long id);
    
    public void insertInBatch(List<AnyEntity> anyEntities);
    
    public void insert(AnyEntity anyEntity);
}
