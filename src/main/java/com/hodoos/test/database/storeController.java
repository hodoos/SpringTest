package com.hodoos.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.database.bo.StoreBO;
import com.hodoos.test.database.model.Store;

@Controller
public class storeController {
	
	@Autowired
	private StoreBO storeBO;
	
	@ResponseBody
	@RequestMapping("/database/store/list")
	public List<Store> storeList() {
		List<Store> storeList = storeBO.getStoreList();
		
		return storeList;
	}
}
