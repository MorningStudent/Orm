package finance.transformers;

import finance.entities.Money;
import finance.entities.Rate;

public class CurrencyTransformer {

	private static CurrencyTransformer instance;
	
	public static CurrencyTransformer getInastance() {
        if(instance == null) {
            instance = new CurrencyTransformer();
        }
        return instance;

    }
	
	private CurrencyTransformer() {
		
	}
	
	public Money transformCurrency(Money money, Rate rate) throws MoneyOrRateCurrencyMismatchException {
		Money returnedMoney;
		if (money.getCurrency().getCode().equals(rate.getSourceCurrency().getCode())) {
			returnedMoney = new Money((money.getValue() * rate.getValue()), rate.getTargetCurrency());
		} else {
			throw new MoneyOrRateCurrencyMismatchException("Currency mismatch!!!");
		}
		return returnedMoney;
		
	}
	
	public class MoneyOrRateCurrencyMismatchException extends Exception { 

		public MoneyOrRateCurrencyMismatchException (String errorMessage) {
	        super(errorMessage);
	    }
	}
	
}
