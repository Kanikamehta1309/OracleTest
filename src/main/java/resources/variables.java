package resources;


public class variables {
	
	ExcelDriven excelData = new ExcelDriven();
	
	
	public String topic = ExcelDriven.excelData("Topic");
	public String ErrorType = ExcelDriven.excelData("ErrorType");
	public String Subject = ExcelDriven.excelData("Subject");
	public String Description = ExcelDriven.excelData("Description");
	public String HotelName = ExcelDriven.excelData("HotelName");
	public String BookingSite = ExcelDriven.excelData("BookingSite");
	public String CheckinDate = ExcelDriven.excelData("CheckinDate");
	public String Attachments = ExcelDriven.excelData("Attachments");
	public String expectedSuccessMsg = ExcelDriven.excelData("expectedSuccessMsg");

}
