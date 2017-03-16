package evolution.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import evolution.entity.City;

@Mapper
public interface CityMapper {
    @Select("SELECT * FROM CITY WHERE state = #{state}")
    City findByState(@Param("state") String state);
}
