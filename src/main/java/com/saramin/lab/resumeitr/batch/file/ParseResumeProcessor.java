package com.saramin.lab.resumeitr.batch.file;

import com.saramin.lab.resumeitr.batch.vo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA on 2017-12-27 08:46
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : ParseResumeProcessor
 * Descrption :
 */

@Slf4j
public class ParseResumeProcessor implements ItemProcessor<StringBuffer,ResumeItrVo> {
    @Override
    public ResumeItrVo process(StringBuffer sb) throws Exception {

        final ResumeItrVo vo = new ResumeItrVo();
        vo.setRes_idx(getTargetContent(sb,"<__res_idx__>","<__title__>"));
        vo.setTitle(getTargetContent(sb,"<__title__>","<__contents_len__>"));
        vo.setContents_len(getTargetContent(sb,"<__contents_len__>","<__contents__>"));
        vo.setContents(getTargetContent(sb,"<__contents__>","<__seq__>"));
        vo.setSeq(getTargetContent(sb,"<__seq__>","<__contents_sum__>"));
        vo.setContents_sum(getTargetContent(sb,"<__contents_sum__>","$"));

        log.info("Transfrom person : " + vo.toString());
        return vo;
    }

    private String getTargetContent(StringBuffer sb, String start, String end){

        Pattern pattern = Pattern.compile(start + ".*" + end,Pattern.DOTALL);
        Matcher m = pattern.matcher(sb.toString());
        String ret = "";
        while (m.find()){
            ret = m.group().replaceAll(start,"").replaceAll(end,"");
        }
        return ret;
    }
}
