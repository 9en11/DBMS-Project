package com.example.naveen.model;
import java.sql.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
public class Fee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
public int fee_id;
public String month_name;
public int adm_no;
public boolean fee_status;
public int getFee_id() {
	return fee_id;
}
public void setFee_id(int fee_id) {
	this.fee_id = fee_id;
}
public String getmonth_name() {
	return month_name;
}
public void setmonth_name(String month_name) {
	this.month_name = month_name;
}
public int getAdm_no() {
	return adm_no;
}
public void setAdm_no(int adm_no) {
	this.adm_no = adm_no;
}
public boolean isfee_status() {
	return fee_status;
}
public void setfee_status(boolean fee_status) {
	this.fee_status = fee_status;
}


}
