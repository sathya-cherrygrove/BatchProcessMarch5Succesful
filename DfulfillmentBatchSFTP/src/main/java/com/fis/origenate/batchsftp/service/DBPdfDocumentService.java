package com.fis.origenate.batchsftp.service;

import java.util.List;
import java.util.Map;

public interface DBPdfDocumentService {
	
	public void extractEligibleDocumentsFromSource();
	public List<Map<String, Object>> getAllDocumentsFromHistoryFilteredForPrint();
	public void docConfigurationDelayDaysCheck();

}
