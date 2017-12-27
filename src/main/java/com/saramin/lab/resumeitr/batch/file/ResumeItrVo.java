package com.saramin.lab.resumeitr.batch.file;

import lombok.Data;

/**
 * Created by IntelliJ IDEA on 2017-12-26 19:13
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : ResumeItrVo
 * Descrption :
 */


@Data
public class ResumeItrVo {

    String res_idx;
    String title;
    String contents_len;
    String contents;
    String seq;
    String contents_sum;

}
