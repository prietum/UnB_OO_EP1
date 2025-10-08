import java.time.*;
import java.util.Optional;
import java.text.*;

public class Periodo {
	////https://stackoverflow.com/questions/226910/how-to-sanity-check-a-date-in-java
	/* final static String DATE_FORMAT = "dd-MM-yyyy";
	
	public static boolean isDateValid(String date)
	{
			try {
				DateFormat df = new SimpleDateFormat(DATE_FORMAT);
				df.setLenient(false);
				df.parse(date);
				return true;
			} catch (ParseException e) {
				return false;
			}
	} */
	////
	
	private LocalDate d0;
	private LocalDate d1;
	
	Periodo(LocalDate d0, LocalDate d1) {
		this.d0 = d0;
		this.d1 = d1;
	}
	
	@Override
	public String toString() {
		return String.format("%s até %s",this.d0.toString(), this.d1.toString());
		
	}
}