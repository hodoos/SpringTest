package com.hodoos.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hodoos.test.database.model.Store;

@Repository
public interface StoreDAO {
	
	//store 테이블 조회 기능
	public List<Store> selectStoreList();
	
	
}
