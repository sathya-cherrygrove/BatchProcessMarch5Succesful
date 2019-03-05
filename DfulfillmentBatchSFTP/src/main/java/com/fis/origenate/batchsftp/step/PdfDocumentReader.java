package com.fis.origenate.batchsftp.step;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class PdfDocumentReader implements ItemReader<File> {

	private List<File> pdfDocumentList;
	private int documentCount = 0;

	public PdfDocumentReader(List<File> files) {
		this.pdfDocumentList = files;
	}

	@Override
	public synchronized File read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if (!pdfDocumentList.isEmpty()) {
			System.out.println("Read Thread Name : " + Thread.currentThread().getName() + " File Name : "
					+ pdfDocumentList.get(0).getName());

			return pdfDocumentList.remove(0);
		}
		return null;
	}

}
