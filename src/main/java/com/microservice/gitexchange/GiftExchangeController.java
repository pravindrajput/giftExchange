package com.microservice.gitexchange;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftExchangeController {
  
  @Autowired
  private ExchangeGiftRepository repository;
  
  @Autowired
  private FamilyMemberRepository memeberRepository;  
  
  @GetMapping("/gitExchange/memberId/{memberId}/recipientMemberId/{recipientMemberId}")
  public Boolean retrieveExchangeGift
    (@PathVariable String memberId, @PathVariable String recipientMemberId){
    
	boolean retunrValue = false;
	
	//Check whether the memberId and recipientMemberId both are same then gift exchange not allowed.
	if(memberId!=null && recipientMemberId!=null && memberId.equalsIgnoreCase(recipientMemberId))
	{
		return retunrValue;
	}
	else
	{
		//Check whether the memberId and recipientMemberId passed are correct and exist in Family Member master table.
		if(memberId!=null && recipientMemberId!=null && memeberRepository.findById(memberId)!=null && memeberRepository.findById(recipientMemberId)!=null)
		{	
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			
			//Check whether the memberId and recipientMemberId has already exchange gift in current year.
			ExchangeGift exchangeGift = repository.findMemberRecipentExistWithCurrentYear(memberId, recipientMemberId, currentYear);
			
			if (exchangeGift!=null)
			{
				//If the given memberId and recipientMemberId has already exchange gift in current year then pass the value as false for gift exchange
				return retunrValue;
			}
			else
			{
				int year = currentYear - 3;
				
				//Check whether the memberId and recipientMemberId has already exchanged gift in last three year.
				exchangeGift = repository.findMemberRecipentExistInLastThreeYear(memberId, recipientMemberId, year);
				if (exchangeGift!=null)
				{
					//If the given memberId and recipientMemberId has already exchanged gift in last three year then pass the value as false for gift exchange
					return retunrValue;
				}
				else
				{
					//If the given memberId and recipientMemberId has not exchanged gift in last three year then pass the value as true for gift exchange.
					//Store the memberId, recipientMemberId and Year in one table.
					exchangeGift = new ExchangeGift();
					exchangeGift.setMemberId(memberId);
					exchangeGift.setRecipientMemberId(recipientMemberId);
					exchangeGift.setYear(year);
					
					repository.save(exchangeGift);
					retunrValue = true;
				}
			}
		}
	}
    return retunrValue;
  }
}