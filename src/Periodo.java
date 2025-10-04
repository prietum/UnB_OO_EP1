import java.time.*;
import java.util.Optional;
import java.text.*;

public class Periodo {
	////https://stackoverflow.com/questions/226910/how-to-sanity-check-a-date-in-java
	final static String DATE_FORMAT = "dd-MM-yyyy";
	
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
	}
	////
	
	private LocalDate p0;
	private Optional<LocalDate> p1;
	
	Periodo(String d0, Optional<String> d1) {
		if (d1.isPresent()) {
			this.p0 = LocalDate.parse(d0);
			this.p1 = Optional.of(LocalDate.parse(d1.get()));
		} else {
			this.p0 = LocalDate.parse(d0);
			this.p1 = Optional.empty();
		}
	}
	
	@Override
	public String toString() {
		if (this.p1.isPresent()) {
			return String.format("%s → %s",this.p0.toString(),this.p1.get().toString());
		} else {
			return String.format("%s → ...",this.p0.toString());
		}
		
	}
}