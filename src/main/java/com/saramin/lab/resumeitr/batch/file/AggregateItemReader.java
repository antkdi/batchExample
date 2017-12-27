package com.saramin.lab.resumeitr.batch.file;

import lombok.Data;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA on 2017-12-26 19:04
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : AggregateItemReader
 * Descrption :
 */

@Data
@Component
public class AggregateItemReader implements ItemReader<StringBuffer> {

    private ItemReader<String> itemReader;

    @Override
    public StringBuffer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        ResultHolder holder = new ResultHolder();

        while(checkRecord(itemReader.read(),holder)){
            continue;
        }

        if(!holder.isExhausted()){
            return holder.getRecords();
        }else{
            return null;
        }
    }

    private boolean checkRecord(String value, ResultHolder holder){

        if(value == null){
            holder.setExhausted(true);
            return false;
        }

        if(value.startsWith("<__contents_sum__>")){
            holder.addRecord(value);
            return false;
        }

        holder.addRecord(value);
        return true;
    }




    /**
     * Private class for temporary state management while item is being
     * collected.
     *
     * @author Dave Syer
     *
     */
    private class ResultHolder {
        private StringBuffer records = new StringBuffer();
        private boolean exhausted = false;

        public StringBuffer getRecords() {
            return records;
        }

        public boolean isExhausted() {
            return exhausted;
        }

        public void addRecord(String record) {
            records.append(record);
            records.append(System.lineSeparator());
        }

        public void setExhausted(boolean exhausted) {
            this.exhausted = exhausted;
        }
    }

}


