package com.boatHeadphonesAssignment.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boatHeadphonesAssignment.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy(xpath="//div[contains(text(),'Bestseller')]")
	List<WebElement> bestSellers;
	
	@FindBy(xpath="//div[contains(text(),'Bestseller')]//following::a[1]")
	List<WebElement> bestSellersTitle;
	
	@FindBy(xpath="//div[contains(text(),'Bestseller')]//following::a[2]//div[starts-with(text(),'₹')][1]")
	List<WebElement> bestSellerssellingPrice;
	
	@FindBy(xpath="//div[contains(text(),'Bestseller')]//following::a[2]//div[starts-with(text(),'₹')][2]")
	List<WebElement> bestSellersactualPrice;
	
	@FindBy(xpath="//div[contains(text(),'Bestseller')]//following::a[2]//div//span")
	List<WebElement> bestSellersdiscount;
	
	@FindBy(xpath="//div[contains(text(),'Trending')]")
	List<WebElement> trending;
	
	@FindBy(xpath="//div[contains(text(),'Trending')]//following::a[1]")
	List<WebElement> trendingTitle;
	
	@FindBy(xpath="//div[contains(text(),'Trending')]//following::a[2]//div[starts-with(text(),'₹')][1]")
	List<WebElement> trendingSellingPrice;
	
	@FindBy(xpath="//div[contains(text(),'Trending')]//following::a[2]//div[starts-with(text(),'₹')][2]")
	List<WebElement> trendingActualPrice;
	
	@FindBy(xpath="//div[contains(text(),'Trending')]//following::a[2]//div//span")
	List<WebElement> trendingDiscount;
	
	@FindBy(xpath="//span[text()='Filters']")
	WebElement filtersText;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HashMap<String, String> getBestSellerEarphones(int i) {
		HashMap<String,String> bestSellerHashmap=new HashMap<String, String>();
		bestSellerHashmap.put("Name",getAttribute(bestSellersTitle.get(i),"title"));
		bestSellerHashmap.put("Original price",getAttribute(bestSellersactualPrice.get(i),"innerHTML"));
		bestSellerHashmap.put("Current price",getAttribute(bestSellerssellingPrice.get(i),"innerHTML"));
		bestSellerHashmap.put("Discount",getText(bestSellersdiscount.get(i)));	
    	return bestSellerHashmap;
	}
	
	public void printBestSellingHeadphones() {
		System.out.println("Bestseller Earphones Information:");
		List<Map<String,String>> bestSellingEarphone=new ArrayList<Map<String,String>>();
		scrollDownSmoothly();
		for(int i=0;i<bestSellers.size();i++) {
			bestSellingEarphone.add(getBestSellerEarphones(i));
			System.out.println("Model "+(i+1)+":");
			System.out.println(bestSellingEarphone.get(i));
		}
	}
	
	public HashMap<String, String> getTrendingEarphones(int i) {
		HashMap<String,String> trendingHashmap=new HashMap<String, String>();
			trendingHashmap.put("Name",getAttribute(trendingTitle.get(i),"title"));
			trendingHashmap.put("Original price",getAttribute(trendingActualPrice.get(i),"innerHTML"));
			trendingHashmap.put("Current price",getAttribute(trendingSellingPrice.get(i),"innerHTML"));
			trendingHashmap.put("Discount",getText(trendingDiscount.get(i)));
			return trendingHashmap;
	}
	
	public void printTrendingEarphones() {
	System.out.println("Trending Earphones Information:");
	List<Map<String,String>> trendingEarphone=new ArrayList<Map<String,String>>();
	scrollToElement(filtersText);
	scrollDownSmoothly();
	for(int i=0;i<trending.size();i++) {
		trendingEarphone.add(getTrendingEarphones(i));
		System.out.println("Model "+(i+1)+":");
		System.out.println(trendingEarphone.get(i));
	}
}
		

}
