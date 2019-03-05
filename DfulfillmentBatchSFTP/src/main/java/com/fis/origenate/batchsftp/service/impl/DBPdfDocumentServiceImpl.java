package com.fis.origenate.batchsftp.service.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.fis.origenate.batchsftp.config.DataSourceConfiguration;
import com.fis.origenate.batchsftp.constants.SQLQueriesUtil;
import com.fis.origenate.batchsftp.service.DBPdfDocumentService;

@Service
@ComponentScan({ "com.fis.origenate.batchsftp.config", "com.fis.origenate.batchsftp.step",
		"com.fis.origenate.batchsftp" })
public class DBPdfDocumentServiceImpl implements DBPdfDocumentService {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("jdbc2") public JdbcTemplate jdbctemplate;
	 */

	static final Logger logger = LoggerFactory.getLogger(DBPdfDocumentServiceImpl.class);

	public void extractEligibleDocumentsFromSource() {

		/*
		 * Extracting all documents from CREDIT_REQ_EXT_DOC_HISTORY after filtering for
		 * "Exclude if printed"
		 */
		List<Map<String, Object>> allDocuments = getAllDocumentsFromHistoryFilteredForPrint();
		docConfigurationDelayDaysCheck();

		// List<Map<String, Object>> result =
		// getJdbcSecondaryTemplate().queryForList("select * from
		// CREDIT_REQ_EXT_DOC_HISTORY");

		/*
		 * List<Map<String, Object>> delayDaysDecisionStatus =
		 * getJdbcSecondaryTemplate().queryForList(
		 * "SELECT ACM_MSTR_DF_EXT_COMPL_DOC.DOC_DESC, ACM_MSTR_DF_EXT_COMPL_DOC.DOC_ID, ACM_CONFIG_DF_EXT_COMPL_DOC.DECISION_STATUS, ACM_CONFIG_DF_EXT_COMPL_DOC.DELAY_DAYS from ACM_MSTR_DF_EXT_COMPL_DOC inner join ACM_CONFIG_DF_EXT_COMPL_DOC on ACM_MSTR_DF_EXT_COMPL_DOC.DOC_ID = ACM_CONFIG_DF_EXT_COMPL_DOC.DOC_ID"
		 * );
		 * 
		 * List<Map<String, Object>> allDocumentsFromHistory =
		 * getJdbcSecondaryTemplate()
		 * .queryForList("select * from CREDIT_REQ_EXT_DOC_HISTORY");
		 * 
		 * for (Map<String, Object> X : delayDaysDecisionStatus) { for
		 * (Map.Entry<String, Object> entry : X.entrySet()) {
		 * 
		 * logger.info(entry.getKey() + ": " + entry.getValue());
		 * 
		 * } }
		 */

		// logger.info("Data Obtained : #### " + result.size());
	}

	private JdbcTemplate getJdbcSecondaryTemplate() {
		DataSourceConfiguration datasourconfiguration = new DataSourceConfiguration();
		JdbcTemplate jdbctemplate = datasourconfiguration
				.secondaryJdbcTemplate(datasourconfiguration.secondDataSource());
		return jdbctemplate;

	}

	public List<Map<String, Object>> getAllDocumentsFromHistoryFilteredForPrint() {

		List<Map<String, Object>> listOfSelectedDocuments = getJdbcSecondaryTemplate()
				.queryForList(SQLQueriesUtil.ExtractAllDocumentsAfterFilteringPrint);
		return listOfSelectedDocuments;
	}

	public void docConfigurationDelayDaysCheck() {
		List<Map<String, Object>> delayDaysDecisionStatus = getJdbcSecondaryTemplate()
				.queryForList(SQLQueriesUtil.ExtractDelayDayDecision);

		for (Map<String, Object> X : delayDaysDecisionStatus) {
			for (Map.Entry<String, Object> entry : X.entrySet()) {

				logger.info(entry.getKey() + ": " + entry.getValue());

			}
		}
	}

}
