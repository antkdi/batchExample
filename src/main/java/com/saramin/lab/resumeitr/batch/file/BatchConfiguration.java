package com.saramin.lab.resumeitr.batch.file;

import com.saramin.lab.resumeitr.batch.vo.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 * Created by IntelliJ IDEA on 2017-12-22 16:27
 * PROJECT : Smart Filter API
 * Department : Matching Technology
 * Cell : Search R&D
 * Author : Hyungeun.jung
 * ClassName : BatchConfiguration
 * Descrption :
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    Environment env;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    ResourceLoader resourceLoader;


    @Bean
    public AggregateItemReader resumeFgfReader(){
        /*MultiResourceItemReader reader = new MultiResourceItemReader();
        Resource[] resources = new Resource[] {resourceLoader.getResource(env.getProperty("INPUT.FILE.DIR")) };
        reader.setResources(resources);*/

        AggregateItemReader aggregateItemReader = new AggregateItemReader();


        FlatFileItemReader<String> fileReader = new FlatFileItemReader();
        fileReader.setLineMapper(new LineMapper<String>(){
            private LineTokenizer tokenizer;
            private FieldSetMapper<String> fieldSetMapper;

            @Override
            public String mapLine(String line, int lineNumber) throws Exception {
                return line;
            }
        });

        MultiResourceItemReader multiResourceItemReader =  new MultiResourceItemReader();
        Resource[] resources = new Resource[] {resourceLoader.getResource("classpath:data-23-20171226151543.fgf") };
        multiResourceItemReader.setResources(resources);
        multiResourceItemReader.setDelegate(fileReader);

        aggregateItemReader.setItemReader(multiResourceItemReader);

        /*FlatFileItemReader<Person> reader = new FlatFileItemReader<>();

        reader.setResource(new ClassPathResource("sample-data.csv"));

        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[] { "firstName", "lastName" });
        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        reader.setLineMapper(lineMapper);*/
        return aggregateItemReader;
    }

    @Bean
    public PersonItemProcesor processor(){
        return new PersonItemProcesor();
    }

    @Bean
    public ParseResumeProcessor parseResumeProcessor(){
        return new ParseResumeProcessor();
    }

    @Bean
    public FlatFileItemWriter<Person> writer(){
        FlatFileItemWriter<Person> writer = new FlatFileItemWriter<>();

        DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");
        writer.setLineAggregator(lineAggregator);
        writer.setResource(new FileSystemResource(env.getProperty("OUTPUT.FILE.PATH")));

        return writer;
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener){
        return jobBuilderFactory.get("AggregateResumeItrJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(AggregateResumeItr())
                .end()
                .build();

    }
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(4);
        return taskExecutor;
    }

    @Bean Step AggregateResumeItr(){
        return stepBuilderFactory.get("AggregateResumeItr")
                .<StringBuffer,ResumeItrVo>chunk(2)
                .reader(resumeFgfReader())
                .processor(parseResumeProcessor())
                .build();
    }


    /*@Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<StringBuffer,StringBuffer> chunk(10)
                .reader(fgfReader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }*/


}
