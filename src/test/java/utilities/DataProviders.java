package utilities;


import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginDataProvider")
	public String[][] getLoginData() {
		ExcelUtility excelUtility = new ExcelUtility("./testData/login_test_data.xlsx", 0);
		int totalRows = excelUtility.getTotalRows();
		int totalColumns = excelUtility.getTotalColumns();
		
		String[][] data = new String[totalRows][totalColumns];
		
		for(int i = 1; i <= totalRows; i++) {
			for(int j = 0; j < totalColumns; j++) {
				String cellValue = excelUtility.getCellValue(i, j);
				data[i-1][j] = cellValue;
				System.out.print(data[i-1][j] + " ");
			}
			System.out.println();
		}
		excelUtility.close();
		return data;
	}
	@DataProvider(name="loginData")
	public String[][] getSingleLoginData(){
		ExcelUtility excelUtility = new ExcelUtility("./testData/DataDrivenLoginTest.xlsx", 0);
		int totalRows = excelUtility.getTotalRows();
		int totalCells = excelUtility.getTotalColumns();
		String[][] data = new String[totalRows][totalCells];
		for(int i = 1; i <= totalRows; i++) {
			for(int j = 0; j < totalCells; j++) {
				String cellValue = excelUtility.getCellValue(i, j);
				data[i-1][j] = cellValue;
				System.out.print(data[i-1][j] + " ");
			}
			System.out.println();
		}
		
		excelUtility.close();
		return data;
	}
//	@DataProvider(name="signUpDataProvider")
//	public String[][] getSignUpData(){
//		PropertiesUtility propUtility = new PropertiesUtility("./testData/signup.properties");
//		String[][] data = new String[1][7];
//		data[0][0] = propUtility()
//		return data;
//	}
	
}
