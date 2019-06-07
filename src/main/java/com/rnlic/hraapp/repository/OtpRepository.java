package com.rnlic.hraapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rnlic.hraapp.bean.modal.OtpMasterModal;

@Repository
public interface OtpRepository extends JpaRepository<OtpMasterModal, Long>{

	@Query("SELECT o FROM OtpMasterModal o WHERE o.mobileNumber =:mobile_number and o.otpValue =:otp_value and validUpto > CURRENT_TIMESTAMP()")
	OtpMasterModal findByUserId(@Param("mobile_number") String mobile_number, @Param("otp_value") int otp_value);

}
