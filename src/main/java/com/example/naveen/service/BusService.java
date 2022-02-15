package com.example.naveen.service;

import java.util.List;

import com.example.naveen.model.Bus;

public interface BusService {
public boolean addbus(Bus bus);

public List<Bus> getallbus();

public List<Bus> getbusbyschool_id(int school_id);

public Bus getbusbybusno(int bus_no);

public boolean  deletebusbybus_no(int bus_no);


}
