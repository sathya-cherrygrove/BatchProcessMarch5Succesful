package com.fis.origenate.batchsftp.constants;

public class SQLQueriesUtil {

	private SQLQueriesUtil() {

	}

	// Extracting all documents from CREDIT_REQ_EXT_DOC_HISTORY after applying "Exclude if printed" using ACM_PRINT_HISTORY
	public static final String ExtractAllDocumentsAfterFilteringPrint = "select  * from CREDIT_REQ_EXT_DOC_HISTORY  inner join ACM_PRINT_HISTORY on CREDIT_REQ_EXT_DOC_HISTORY.REQUEST_ID = ACM_PRINT_HISTORY.REQUEST_ID AND ACM_PRINT_HISTORY.DOC_ACTION = 'View/Print'";
    public static final String ExtractDelayDayDecision ="SELECT ACM_MSTR_DF_EXT_COMPL_DOC.DOC_DESC, ACM_MSTR_DF_EXT_COMPL_DOC.DOC_ID, ACM_CONFIG_DF_EXT_COMPL_DOC.DECISION_STATUS, ACM_CONFIG_DF_EXT_COMPL_DOC.DELAY_DAYS from ACM_MSTR_DF_EXT_COMPL_DOC inner join ACM_CONFIG_DF_EXT_COMPL_DOC on ACM_MSTR_DF_EXT_COMPL_DOC.DOC_ID = ACM_CONFIG_DF_EXT_COMPL_DOC.DOC_ID";
	
}
