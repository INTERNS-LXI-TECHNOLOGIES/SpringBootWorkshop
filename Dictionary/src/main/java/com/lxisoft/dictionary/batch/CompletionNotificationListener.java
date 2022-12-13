package com.lxisoft.dictionary.batch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lxisoft.dictionary.entity.Word;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CompletionNotificationListener extends JobExecutionListenerSupport {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompletionNotificationListener(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution)
    {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED)
        {
            System.out.println(" -------- JOB FINISHED ------------------ ");

            List<Word> results = jdbcTemplate.query("SELECT name,partsOfSpeech,meaning FROM word",new RowMapper<Word>()

                    {

                        @Override
                        public Word mapRow(ResultSet rs, int row) throws SQLException
                        {
//                            return new Word(rs.getString(1), rs.getInt(2),rs.getInt(3));
                            return new Word();
                        }
                    });

            for (Word word : results)
            {
                System.out.println("Found <" + word + "> in the database.");
            }
        }

    }
}
