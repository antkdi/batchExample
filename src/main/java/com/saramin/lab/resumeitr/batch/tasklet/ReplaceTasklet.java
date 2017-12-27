package com.saramin.lab.resumeitr.batch.tasklet;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.*;

/**
 * Created by IntelliJ IDEA on 2017-12-26 15:40
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : ReplaceTasklet
 * Descrption :
 */

@Component
public class ReplaceTasklet implements Tasklet, InitializingBean {

    @Autowired
    Environment env;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String resourceDirectory = env.getProperty("INPUT.DIR.PATH");
        String reprocDir = env.getProperty("REPROC.DIR.PATH");
        File[] resources = new File(resourceDirectory).listFiles();
        for(File file : resources){
            StringBuffer sb = readFile(file);
            sb.toString().replaceAll("^(\r\n|\n)","");
            writerFile(new File(reprocDir+"/"+file.getName()),sb);
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(new Object());
    }

    @SneakyThrows
    private StringBuffer readFile(File f){
        StringBuffer sb = new StringBuffer();
        @Cleanup
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String ret;
        while( (ret = br.readLine()) != null){
            sb.append(ret);
            sb.append(System.lineSeparator());
        }
        br.close();
        return sb;
    }

    @SneakyThrows
    private void writerFile(File f, StringBuffer sb){
        @Cleanup
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f,false),"UTF-8"));
        bw.write(sb.toString());
        bw.close();

    }
}
