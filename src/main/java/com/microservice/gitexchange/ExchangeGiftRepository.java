package com.microservice.gitexchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeGiftRepository extends 
    JpaRepository<ExchangeGift, Long>{
  ExchangeGift findMemberRecipentExistInLastThreeYear(String memberId, String recipientMemberId, int year);
  ExchangeGift findMemberRecipentExistWithCurrentYear(String memberId, String recipientMemberId, int currentYear);
}