package com.fis.origenate.batchsftp.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.fis.origenate.batchsftp.config.DataSourceConfiguration;
import com.fis.origenate.batchsftp.model.AcmPrintHistory;
import com.fis.origenate.batchsftp.service.impl.CommandLineParamsServiceImpl;
import com.fis.origenate.batchsftp.service.impl.DBPdfDocumentServiceImpl;

@Component
@ComponentScan({ "com.fis.origenate.batchsftp.config", "com.fis.origenate.batchsftp.step",
		"com.fis.origenate.batchsftp.service.impl","com.fis.origenate.batchsftp" })
public class PdfCollectionTasklet implements Tasklet {

	Logger logger = LoggerFactory.getLogger(PdfCollectionTasklet.class);

	@Autowired
	Environment environment;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		logger.info("About to Call IMPL class for db connection");
		getPdfDocumentService().extractEligibleDocumentsFromSource();
		return RepeatStatus.FINISHED;

	}

	@Bean
	public DBPdfDocumentServiceImpl getPdfDocumentService() {
		return new DBPdfDocumentServiceImpl();
	}

}
