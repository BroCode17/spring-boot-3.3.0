package com.efrimpon.lesson.batch.config;


import com.efrimpon.lesson.database.student.BatchStudent;
import com.efrimpon.lesson.database.student.BatchStudentRepo;
import com.efrimpon.lesson.database.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    //inject
    private final BatchStudentRepo studentRepository;

    private final JobRepository jobRepository;

    private final PlatformTransactionManager platformTransactionManager;


    //reader
    @Bean
    public FlatFileItemReader<BatchStudent> itemReader(){
        FlatFileItemReader<BatchStudent> itemReader = new FlatFileItemReader<>();
        //set resource
        itemReader.setResource(new FileSystemResource("src/main/resources/students.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    @Bean
    protected LineMapper<BatchStudent> lineMapper(){
        DefaultLineMapper<BatchStudent> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstname", "lastname", "age");

        BeanWrapperFieldSetMapper<BatchStudent> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BatchStudent.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    //processor
    public StudentProcessor processor(){
        return new StudentProcessor();
    }

    //writer
    @Bean
    public RepositoryItemWriter<BatchStudent> write(){
        RepositoryItemWriter<BatchStudent> writer = new RepositoryItemWriter<>();
        writer.setRepository(studentRepository);
        writer.setMethodName("save");

        return writer;

    }


    //steps
    @Bean
    public Step impoortStep(){
//        return new StepBuilder("csvImport", jobRepository)
//                .<BatchStudent, BatchStudent>chunk(10, platformTransactionManager)
//                .reader(itemReader())
//                .processor(processor())
//                .writer(write())
//                .build();
        //Chunk limit can be set to maybe 1000 to improve time
          return new StepBuilder("csvImport", jobRepository)
                .<BatchStudent, BatchStudent>chunk(10, platformTransactionManager)
                .reader(itemReader())
                .processor(processor())
                .writer(write())
                  .taskExecutor(taskExecutor())
                .build();
    }

    //Parallel Threading
    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(10);
        return  simpleAsyncTaskExecutor;
    }

    //job
    @Bean
    public Job runJob(){
        return new JobBuilder("importStudents", jobRepository)
                .start(impoortStep())
                .build();
    }


}
