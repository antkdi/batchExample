package com.saramin.lab.resumeitr.batch.jdbc;

import com.saramin.lab.resumeitr.batch.vo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by IntelliJ IDEA on 2017-12-22 16:23
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : PersonItemProcesor
 * Descrption :
 */

/*
@Slf4j
public class PersonItemProcesor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(final Person item) throws Exception {
        final String firstName = item.getFirstName().toUpperCase();
        final String lastName = item.getLastName().toUpperCase();
        final Person transformPerson = new Person(firstName,lastName);
        log.info("Transfrom person : " + transformPerson.toString());
        return transformPerson;
    }
}*/
