package com.microservice.gitexchange;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ExchangeGift.findMemberRecipentExistInLastThreeYear", query = "SELECT exchangeGift FROM ExchangeGift exchangeGift WHERE exchangeGift.memberId = :memberId AND exchangeGift.recipientMemberId = :recipientMemberId AND exchangeGift.year > :year"),
	@NamedQuery(name = "ExchangeGift.findMemberRecipentExistWithCurrentYear", query = "SELECT exchangeGift FROM ExchangeGift AS exchangeGift  WHERE exchangeGift.memberId = :memberId AND exchangeGift.recipientMemberId = :recipientMemberId AND exchangeGift.year = :currentYear")})
public class ExchangeGift {
  
  @Id
  private Long id;
  
  @Column(name="member_id")
  private String memberId;
  
  @Column(name="recipient_member_id")
  private String recipientMemberId;
  
  private Integer year;
  
  public ExchangeGift() {
    
  }
  

  public ExchangeGift(Long id, String memberId, String recipientMemberId, Integer year) {
    super();
    this.id = id;
    this.memberId = memberId;
    this.recipientMemberId = recipientMemberId;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  
  public String getMemberId() {
	return memberId;
}


public void setMemberId(String memberId) {
	this.memberId = memberId;
}


public String getRecipientMemberId() {
	return recipientMemberId;
}


public void setRecipientMemberId(String recipientMemberId) {
	this.recipientMemberId = recipientMemberId;
}


public Integer getYear() {
	return year;
}


public void setYear(Integer year) {
	this.year = year;
}

}