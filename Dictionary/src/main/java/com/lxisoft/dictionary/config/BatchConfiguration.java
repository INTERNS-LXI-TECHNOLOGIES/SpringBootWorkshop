package com.lxisoft.dictionary.config;

import com.lxisoft.dictionary.batch.CompletionNotificationListener;
import com.lxisoft.dictionary.batch.WordItemProcessor;
import com.lxisoft.dictionary.entity.Word;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 *
 * This is a batch configuration file
 *
 *
 * @author sujith.k.s@lxisoft.com
 * @version 1.2
 * @see com.lxisoft.dictionary.entity.Word
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    /**
     * This method uses a special logic.
     * @return
     */
    @Bean
    public FlatFileItemReader<Word> reader()
    {
        System.out.println("-----------Inside reader() method--------");
        FlatFileItemReader<Word> reader = new FlatFileItemReader<Word>();
        reader.setEncoding("UTF-8");
        reader.setResource(new ClassPathResource("words.csv"));
        reader.setLineMapper(new DefaultLineMapper<Word>()
        {
            {
                setLineTokenizer(new DelimitedLineTokenizer()
                {
                    {
                        setNames(new String[] { "meaning", "name", "parts_of_speech" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Word>()
                {
                    {
                        setTargetType(Word.class);
                    }
                });
            }
        });
        return reader;
    }

    /**
     * Intermediate processor to do the operations after the reading the data from the CSV file and
     * before writing the data into SQL.
     */
    @Bean
    public WordItemProcessor processor()
    {
        System.out.println("-----------Inside  processor() method--------");
        return new WordItemProcessor();
    }

    /**
     * The writer() method is used to write a data into the SQL.
     */
    @Bean
    public JdbcBatchItemWriter<Word> writer()
    {
        System.out.println("-----------Inside writer() method--------");
        JdbcBatchItemWriter<Word> writer = new JdbcBatchItemWriter<Word>();
        writer.setSql("INSERT INTO Word ( MEANING, NAME, PARTS_OF_SPEECH) VALUES ( :meaning, :name, :partsOfSpeech )");
        writer.setDataSource(dataSource);
        writer.setItemSqlParameterSourceProvider(
                new BeanPropertyItemSqlParameterSourceProvider<Word>());

        return writer;
    }

    @Bean
    public Job importWord(CompletionNotificationListener listener)
    {
        return jobBuilderFactory.get("importWord").incrementer(new RunIdIncrementer())
                .listener(listener).flow(step1()).end().build();
    }

    @Bean
    public Step step1()
    {
        return stepBuilderFactory.get("step1").<Word, Word>chunk(10).reader(reader())
                .processor(processor()).writer(writer()).build();
    }
}
