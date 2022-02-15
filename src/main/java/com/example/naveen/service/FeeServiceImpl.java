package com.example.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Fee;
import com.example.naveen.repository.FeeRepository;

@Service("feeService")
public class FeeServiceImpl implements FeeService{
@Autowired
private FeeRepository feeRepository;
	@Override
	public List<Fee> getfeedetails(int adm_no) {
		// TODO Auto-generated method stub
		List<Fee> l1=feeRepository.getfeestatus(adm_no);
		return l1;

	}
	@Override
	public boolean updatefeestatus(boolean fee_status, int fee_id) {
		// TODO Auto-generated method stub
		try {
			feeRepository.updatefeebyfee_id(fee_status, fee_id);
			System.out.println("fee paid successfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	
	}
	@Override
	public Fee getfeedetailsbyfee_id(int fee_id) {
		// TODO Auto-generated method stub
		return feeRepository.getfeebyfeeid(fee_id);
	
	}
	


}
