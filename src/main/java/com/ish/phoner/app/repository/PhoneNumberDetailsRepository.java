package com.ish.phoner.app.repository;

import com.ish.phoner.app.entity.PhoneNumberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PhoneNumberDetailsRepository extends JpaRepository<PhoneNumberDetails, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(
            value = "update phone_number_details set status_active = ?1 where phone_number = ?2",
            nativeQuery = true
    )
    int updateActiveStatusByPhoneNumber(boolean isActiveStatus, String phoneNumber);
}
