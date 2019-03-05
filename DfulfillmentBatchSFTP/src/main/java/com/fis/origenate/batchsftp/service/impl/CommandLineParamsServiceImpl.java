package com.fis.origenate.batchsftp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.fis.origenate.batchsftp.service.CommandLineParamsService;

@Service
@Scope(value = "singleton")
public class CommandLineParamsServiceImpl implements CommandLineParamsService {

	private CommandLineParamsServiceImpl() {

	}

	@Value("${DocumentFolderLocationPath}")
	private String DocumentFolderLocationPath;

	@Value("${PdfDocumentLocation}")
	private String PdfDocumentLocation;

	@Value("${maxNumberOfConcurrentThreads}")
	private Integer maxNumberOfConcurrentThreads;
	
	// DB 1 config Values
	
	@Value("${spring.datasource.driverClassName}")
	private String dataSourceDriver1;
	
	@Value("${spring.datasource.jdbc-url}")
	private String dataSourceUrl1;
	
	@Value("${spring.datasource.username}")
	private String dataSourceUsername1;
	
	@Value("${spring.datasource.password}")
	private String dataSourcePass1;
	
	
	// DB 2 Config Values
	
	@Value("${spring.second-datasource.driverClassName}")
	private String dataSourceDriver2;
	
	@Value("${spring.second-datasource.jdbc-url}")
	private String dataSourceUrl2;
	
	@Value("${spring.second-datasource.username}")
	private String dataSourceUsername2;
	
	@Value("${spring.second-datasource.password}")
	private String dataSourcePass2;
	
	//SFTP Config Details
	
/*	@Value("${sftp.hostname}")
	private String sftpHostName;
	
	@Value("${sftp.username}")
	private String sftpUserName;
	
	@Value("${sftp.password}")
	private String sftpUserPass;
	
	@Value("${sftp.local.filpath}")
	private String localFilePath;
	
	@Value("${sftp.remote.filepath}")
	private String remoteFilePath;*/
	
	
/*	@Bean
	public String getSftpHostName() {
		return sftpHostName;
	}

	@Bean
	public String getSftpUserName() {
		return sftpUserName;
	}

	@Bean
	public String getSftpUserPass() {
		return sftpUserPass;
	}

	@Bean
	public String getLocalFilePath() {
		return localFilePath;
	}

	@Bean
	public String getRemoteFilePath() {
		return remoteFilePath;
	}*/

	public String getDataSourceDriver1() {
		return dataSourceDriver1;
	}

	public String getDataSourceUrl1() {
		return dataSourceUrl1;
	}

	public String getDataSourceUsername1() {
		return dataSourceUsername1;
	}

	public String getDataSourcePass1() {
		return dataSourcePass1;
	}

	public String getDataSourceDriver2() {
		return dataSourceDriver2;
	}

	public String getDataSourceUrl2() {
		return dataSourceUrl2;
	}

	public String getDataSourceUsername2() {
		return dataSourceUsername2;
	}

	public String getDataSourcePass2() {
		return dataSourcePass2;
	}

	public String getDocumentFolderLocation() {
		return DocumentFolderLocationPath;
	}

	public String getPdfDocumentLocation() {
		return PdfDocumentLocation;
	}

	public Integer getMaxNumberOfConcurrentThreads() {
		return maxNumberOfConcurrentThreads;
	}

}
