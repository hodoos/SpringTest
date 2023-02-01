package com.hodoos.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hodoos.test.ajax.model.WebSite;

@Repository
public interface WebSiteDAO {

	public List<WebSite> selectWebSiteList();
	public int insertWebSite(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteWebSite(@Param("id") int id);
}
