package com.hodoos.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.ajax.dao.WebSiteDAO;
import com.hodoos.test.ajax.model.WebSite;

@Service
public class WebSiteBO {

	@Autowired
	private WebSiteDAO webSiteDAO;
	public List<WebSite> getWebsiteList() {
		
		return webSiteDAO.selectWebSiteList();
	}
	
	public int addWebSite(String name, String url) {
		return webSiteDAO.insertWebSite(name, url);
		
	}
	
	public boolean isDuplicateUrl(String url) {
		
		int count = webSiteDAO.selectCountUrl(url);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public int deleteWebSite(int id) {
		
		return webSiteDAO.deleteWebSite(id);
	}
	
}
