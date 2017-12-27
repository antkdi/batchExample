package com.saramin.lab.resumeitr.dao;

import com.saramin.lab.resumeitr.batch.vo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA on 2017-12-24 20:22
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : PersonDao
 * Descrption :
 */


@Mapper
@Component
public interface PersonDao {
    public Person getPerson();

    int insertPerson(Person person);

}
