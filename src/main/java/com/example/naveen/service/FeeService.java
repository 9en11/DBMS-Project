package com.example.naveen.service;

import java.util.List;

import com.example.naveen.model.Fee;

public interface FeeService {
List<Fee> getfeedetails(int adm_no);
Fee getfeedetailsbyfee_id(int fee_id);
public boolean updatefeestatus(boolean fee_status, int fee_id);

}
