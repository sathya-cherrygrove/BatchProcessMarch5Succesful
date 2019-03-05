package com.fis.origenate.batchsftp.service.impl;

import java.io.File;
import java.nio.file.FileSystemException;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.fis.origenate.batchsftp.service.SecuredFileTransferService;


public class SecuredFileTransferServiceThread implements SecuredFileTransferService, Runnable  {

	Logger logger = LoggerFactory.getLogger(SecuredFileTransferServiceThread.class);
	private File pdfFile;

	public SecuredFileTransferServiceThread(File file) {
		this.pdfFile = file;
	}

	@Override
	public void run() {

		SFTPTransferFileToFis(this.pdfFile);

	}

	
	public void SFTPTransferFileToFis(File file) {

	/*	logger.info("SFTP Service: " + file.getName() + " Thread Name :" + Thread.currentThread().getName());
		String hostName = "demo.wftpserver.com:2222";
		String username = "demo-user";
		String password = "demo-user";
		String localFilePath = "C:/Users/SP00597539/Desktop/pdfresources/names.csv";
		String remoteFilePath = "/test/names.csv";
		upload(hostName, username, password, localFilePath, remoteFilePath);
*/
		logger.info("Processed File : "+ file.getName()+ " By Thread  : "+ Thread.currentThread().getName());

	}

	public static void upload(String hostName, String username, String password, String localFilePath,
			String remoteFilePath) {

		File file = new File(localFilePath);
		if (!file.exists())
			throw new RuntimeException("Error. Local file not found");

		StandardFileSystemManager manager = new StandardFileSystemManager();

		try {
			manager.init();

			FileObject localFile = manager.resolveFile(file.getAbsolutePath());

			FileObject remoteFile = (FileObject) manager.resolveFile(
					createConnectionString(hostName, username, password, remoteFilePath), createDefaultOptions());

			((org.apache.commons.vfs2.FileObject) remoteFile).copyFrom((org.apache.commons.vfs2.FileObject) localFile,
					Selectors.SELECT_SELF);

			System.out.println("File upload success");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		finally {
			manager.close();
		}
	}
	
	// Method to setup default SFTP config:
		public static FileSystemOptions createDefaultOptions()
				throws FileSystemException, org.apache.commons.vfs2.FileSystemException {
			// Create SFTP options
			FileSystemOptions opts = new FileSystemOptions();

			// SSH Key checking
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");

			// Root directory set to user home
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);

			// Timeout is count by Milliseconds
			SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 20000);

			return opts;
		}
		
		// Establishing connection
		public static String createConnectionString(String hostName, String username, String password,
				String remoteFilePath) {
			return "sftp://" + username + ":" + password + "@" + hostName + "/" + remoteFilePath;
		}


	
}