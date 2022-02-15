package com.example.naveen.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Bus {
	@Id
	  @Column(unique = true)
	 @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
	public int bus_no;
	public String driver_name;
	
	public int school_id;
	 public String drivercontactno;
	public String route_string;
	
	public Bus() {
	
	}
	
	public String getRoute_string() {
		return route_string;
	}
	public void setRoute_string(String route_string) {
		this.route_string = route_string;
	}

	public String getDrivercontactno() {
		return drivercontactno;
	}
	public void setDrivercontactno(String drivercontactno) {
		this.drivercontactno = drivercontactno;
	}
	public int getBus_no() {
		return bus_no;
	}
	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	

}
