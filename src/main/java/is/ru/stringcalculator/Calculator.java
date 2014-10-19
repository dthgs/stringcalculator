package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text){
		if(text.equals(""))
			return 0;
		if(text.contains("//"))
			try { return sum(splitNumbers(text.substring(4), text.substring(2,3))); }
			catch (Exception e) { System.out.println("Negatives not allowed: " + e.getMessage()); }
		if(text.contains("\n"))
			try { text = text.replace("\n", ","); }
			catch (Exception e) { System.out.println("Negatives not allowed: " + e.getMessage()); }
		//if(text.contains(","))
			return sum(splitNumbers(text));
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
			return numbers.split(",");
	}
	
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
    
    private static String[] splitNumbers(String numbz, String delimeter) throws Exception{
    	String[] numbers = numbz.split(delimeter);
    	if (numbz.contains("-")) {
    		throw new Exception(negsInString(numbers));
    		} else {
    		return numbers;
    		} 
    }

    public static String negsInString(String[] numbers) {
    	String negatives = "";
    	for (String number : numbers) 
    		if (toInt(number) < 0)
    			negatives += (number + ",");
    	return negatives.substring(0, negatives.length() - 1);
    }
}