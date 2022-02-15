package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cglib.core.TinyBitSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Fee;
@Transactional
@Repository("feeRepository")
public interface FeeRepository extends JpaRepository<Fee, Integer> {
@Query(value="select * from fee where fee.adm_no=?1", nativeQuery = true)
List<Fee> getfeestatus(int adm_no);
@Query(value="select * from fee where fee.fee_id=?1", nativeQuery = true)
Fee getfeebyfeeid(int fee_id);

@Modifying
@Query(value="update fee f set f.fee_status=?1 where f.fee_id=?2", nativeQuery = true)
void updatefeebyfee_id(boolean fee_status, int fee_id);
}
