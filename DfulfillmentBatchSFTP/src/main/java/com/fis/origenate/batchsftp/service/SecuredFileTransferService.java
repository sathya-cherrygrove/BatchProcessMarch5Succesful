package com.fis.origenate.batchsftp.service;

import java.io.File;

import org.apache.commons.vfs2.FileSystemOptions;
import org.springframework.stereotype.Service;


public interface SecuredFileTransferService {

	public void SFTPTransferFileToFis(File file);
	
	

}
