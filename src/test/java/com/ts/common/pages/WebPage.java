package com.ts.common.pages;


/*
 * Base class for all pages
 */
public abstract class WebPage {

	protected Browser browser;

	protected abstract boolean isValid();
	
	public void setBrowser(Browser browser) {
		this.browser=browser;
		
	}

}
