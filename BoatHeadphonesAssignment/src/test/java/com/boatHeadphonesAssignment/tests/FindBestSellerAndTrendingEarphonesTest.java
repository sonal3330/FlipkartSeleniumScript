package com.boatHeadphonesAssignment.tests;

import org.testng.annotations.Test;

import com.boatHeadphonesAssignment.base.TestBase;
import com.boatHeadphonesAssignment.pages.HomePage;
import com.boatHeadphonesAssignment.pages.SearchPage;

public class FindBestSellerAndTrendingEarphonesTest extends TestBase {
	
	HomePage homepage;
	SearchPage searchPage;
	
	@Test(description="Test to find bestseller and trending boar headphones on flipkart")
	public void findBestSellerAndTrendingBoatEarphones() {
		homepage=new HomePage();
		//search partial text and select boat bluetooth earphones from dropdown
		homepage.closePopUp();
		homepage.searchEarphones();
		searchPage=homepage.selectEarphones();
		//print best selling and trending earphones of first page
		searchPage.printBestSellingHeadphones();
		searchPage.printTrendingEarphones();
	}

}
