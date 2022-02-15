package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Bus;
@Transactional
@Repository("busRepository")
public interface BusRepository extends JpaRepository<Bus, Integer> {
 @Modifying
	@Query(value="Insert into bus (driver_name, school_id, drivercontactno, route_string) values(?1, ?2, ?3, ?4)", nativeQuery = true)
	public void addbus(String driver_name, int school_id, String drivercontactno, String route_string );
	
	@Query(value="Select * from  bus", nativeQuery = true)
	List<Bus> getallbus();
	
	@Query(value="select * from bus where bus.bus_no=?1", nativeQuery = true)
	List<Bus> getbusbybus_no(int bus_no);
	
	@Query(value="Select * from bus where bus.school_id=?1", nativeQuery = true)
	List<Bus> getallbusbyschool_id(int school_id);
	
	@Modifying
	@Query(value="Delete from bus where bus.bus_no=?1", nativeQuery = true)
	public void deletebus(int bus_no);
	
}
