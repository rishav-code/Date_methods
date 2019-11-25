package com.atmecs.practice1.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.practice1.constant.FilePath;
import com.atmecs.practice1.constant.Findloc;
import com.atmecs.practice1.constant.TimeOut;
import com.atmecs.practice1.helper.CommonUtlity;
import com.atmecs.practice1.helper.Waits;
import com.atmecs.practice1.reports.LogReport;
import com.atmecs.practice1.util.ExcelReader;
import com.atmecs.practice1.util.NullCellValueException;

public class PhpTravlesFuncationality {
	WebDriver driver;
	CommonUtlity commonutility;
	LogReport log;
	ExcelReader excelFile;
	Waits wait;
	 
	Findloc loc;

	public PhpTravlesFuncationality(WebDriver driver) {
		this.driver = driver;
		commonutility = new CommonUtlity(driver);
		loc = new Findloc();
		log=new LogReport();
		excelFile = new ExcelReader();
		wait= new Waits();
	}

	public void loginFunctionality() {
		try {
		log.info("login funcationality starts");
		System.out.println("Hi");
		//System.out.println( excelFile.getCellData);
		commonutility.clickAndSendText(loc.getlocator("loc.username.sendtext"), TimeOut.TIMEOUT_INSECONDS, excelFile.getCellData(FilePath.TESTDATA_FILE, "logindata", "User_Name", "Test_ID1"));
		commonutility.clickAndSendText(loc.getlocator("loc.password.sendtext"), TimeOut.TIMEOUT_INSECONDS, excelFile.getCellData(FilePath.TESTDATA_FILE, "logindata", "Password", "Test_ID1"));
		commonutility.clickElement(loc.getlocator("loc.search.button"));
		log.info("login fincationality ends");
		
		}
	
		
	catch (NullCellValueException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	public void accountPageValidation() throws NullCellValueException {
		log.info("Hi Demo User Text validation starts");
		wait.hardWait(TimeOut.WAIT_TIMEOUT_INSECONDS);
		String demouserTest=commonutility.getElement(loc.getlocator("loc.demouservalidation.text")).getText();
		commonutility.assertion(demouserTest, excelFile.getCellData(FilePath.TESTDATA_FILE, "logindata", "Demo _User_Validation", "Test_ID1"));
//		log.info("Booking Tab Text Validation ");
//		System.out.println((loc.getlocator("loc.bookingtab.text")));
//		String bookingValidationText=commonutility.getElement(loc.getlocator("loc.bookingtab.text")).getText();
//		commonutility.assertion(bookingValidationText,excelFile.getCellData(FilePath.TESTDATA_FILE, "logindata", "Booking_Page_validation", "Test_ID1"));
		
		
	}

}
