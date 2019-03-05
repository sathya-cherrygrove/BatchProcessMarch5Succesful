package com.fis.origenate.batchsftp.service;

public interface CommandLineParamsService {

	public String getDocumentFolderLocation();

	public String getPdfDocumentLocation();

	public Integer getMaxNumberOfConcurrentThreads();

	// DB1 Configuration

	public String getDataSourceDriver1();

	public String getDataSourceUrl1();

	public String getDataSourceUsername1();

	public String getDataSourcePass1();

	// DB2 Configuration

	public String getDataSourceDriver2();

	public String getDataSourceUrl2();

	public String getDataSourceUsername2();

	public String getDataSourcePass2();

}
