package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  15:40
 */
public interface AddressBookService {

    List<AddressBook> list(AddressBook addressBook);

    void save(AddressBook addressBook);

    AddressBook getById(Long id);

    void update(AddressBook addressBook);

    void setDefault(AddressBook addressBook);

    void deleteById(Long id);
}
