package com.saramin.lab.resumeitr.batch.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA on 2017-12-22 15:09
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : PersonVo
 * Descrption :
 */


@Data
@Component
public class Person {

    private String firstName;
    private String lastName;

    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
