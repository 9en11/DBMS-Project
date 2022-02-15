package com.example.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Bus;
import com.example.naveen.repository.BusRepository;
@Service("busService")
public class BusServiceImpl implements BusService{
  @Autowired
  BusRepository busRepository;
	@Override
	public boolean addbus(Bus bus) {
		// TODO Auto-generated method stub
		try {
			busRepository.addbus(bus.getDriver_name(), bus.getSchool_id(), bus.getDrivercontactno(), bus.getRoute_string());
			
			//System.out.println(bus.getDriver_name());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	
	}

	@Override
	public List<Bus> getallbus() {
		// TODO Auto-generated method stub
		List<Bus> list=busRepository.getallbus();
		return list;
	
	}

	@Override
	public List<Bus> getbusbyschool_id(int school_id) {
		// TODO Auto-generated method stub
		List<Bus> list=busRepository.getallbusbyschool_id(school_id);
		return list;
		
	}

	@Override
	public Bus getbusbybusno(int bus_no) {
		// TODO Auto-generated method stub
		
		return busRepository.getbusbybus_no(bus_no).get(0);
	}

	@Override
	public boolean deletebusbybus_no(int bus_no) {
		// TODO Auto-generated method stub
		try {
			busRepository.deletebus(bus_no);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		return false;
		}
	}

}
