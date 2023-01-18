package com.hodoos.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDAO {
	
	public int insertSeller(
			@Param("nickName") String nickName
			,@Param("temperature") double temperature
			,@Param("profileImage") String profileImage);
}
