package com.hodoos.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.database.dao.StoreDAO;
import com.hodoos.test.database.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO;
	
	// store 테이블의 데이터를 조회하고 리턴하는 메소드
	public List<Store> getStoreList() {
		List<Store> storeList = storeDAO.selectStoreList();
		
		return storeList;
	}
	
}
