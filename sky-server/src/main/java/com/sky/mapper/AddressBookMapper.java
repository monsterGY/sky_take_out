package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  15:42
 */
@Mapper
public interface AddressBookMapper {
    void update(AddressBook addressBook);

    @Delete("delete from address_book where id = #{id}")
    void deleteById(Long id);

    @Update("update address_book set is_default = #{isDefault} where user_id = #{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);

    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    @Insert("insert into address_book" +
            " (user_id, consignee, phone, sex, province_code, province_name, city_code, city_name, district_code," +
            " district_name, detail, label, is_default)" +
            " values (#{userId}, #{consignee}, #{phone}, #{sex}, #{provinceCode}, #{provinceName}, #{cityCode}, #{cityName}," +
            " #{districtCode}, #{districtName}, #{detail}, #{label}, #{isDefault})")
    void insert(AddressBook addressBook);

    List<AddressBook> list(AddressBook addressBook);
}
