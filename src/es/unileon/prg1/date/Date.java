
//PABLO GARCIA CELADILLA

package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 2017;
	}

	public Date(Date aDay) {
		this.day = aDay.getDay();
		this.month = aDay.getMonth();
		this.year = aDay.getYear();
	}

	public int getDay() {
		return this.day;
	}
	
	public void setDay(int day) throws DateException {
		if ( day <= 0 || !this.isDayRight(day) ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");
			
		}
		this.day = day;
	}
	
	

	public int getMonth() {
		return this.month;
	}
	
	//setMonth no esta bn hay que cambiar como camino ver video del dia 18
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}else this.month = month;
		if (this.day>daysOfMonth(month)) {
			throw new DateException("Date error: Month " + month + " not valid for that day");
		}
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) throws DateException{
		if ( year < 0) {
			throw new DateException("Negative years are not allowed - wrong value for year: " + year + "\n");			
		} else {
			this.year = year;
		}
	}
	

	
//comprueba dia mes correcto
	
	private int daysOfMonth(int month) {
		int numDays=0;		
	
		switch (month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4: //next
		case 6: //next
		case 9: //next
		case 11:
			numDays = 30;
			break;
		case 2:
		
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
	
//Mismo dia	
	public boolean isSameDay(Date aDay) {		
		if(this.day == aDay.getDay()) {
			return true;
		}
		else {
			return false;
		}
		
	}
//Mismo mes	
	public boolean isSameMonth(Date aDay) {
		if(this.month == aDay.getMonth()) {
			return true;
		}
		else {
			return false;
		}
	}
//Mismo año	
	public boolean isSameYear(Date aDay) {
		if(this.year == aDay.getYear()) {
			return true;
		}
		else {
			return false;
		}
	}
	
//Misma fecha
	public boolean isSame(Date aDay) {		
		if((this.day == aDay.getDay()) && (this.month == aDay.getMonth()) && (this.year == aDay.getYear())) {
			return true;
		}else {
			return false;
		}
	}
	
/** NO HAY TEST SIN IF
//sin if
	
	public boolean isSameDaySinIF(Date aDay) {
		return this.day == aDay.getDay();
	}
	
	public boolean isSameMonthSinIf(Date aDay) {
		return this.month == aDay.getMonth();
	}
	
	public boolean isSameYearSinIf(Date aDay) {
		return this.year == aDay.getYear();
	}
	
	public boolean isSameSinIf(Date aDay) {
		return this.isSameDay(aDay) && this.isSameMonth(aDay) && this.isSameYear(aDay);
	}
	
*/
	
	private boolean isDayRight(int day) {
		
		return ((day > 0) && (day <= this.daysOfMonth(this.month)));
	}
	
	
//estacion
	
	public String getSeasonName() {
		
		String season=null;
		
		switch(this.month) {
		
		case 1: //next
		case 2: //next
		case 3: 
			season="Winter";
			break;
		case 4: //next
		case 5: //next
		case 6: 
			season="Spring";
			break;
		case 7: //next
		case 8: //next
		case 9:
			season="Summer";
			break;
		case 10: //next
		case 11: //next
		case 12:
			season="Autumn";
			break;
			
		
		}
		return season;
		
	}
//Nombre del mes	
	public String getMonthName() {
		
		String monthName= null;
		
		switch(this.month) {
		
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		default:
		//case 12:
			monthName = "December";
			break;
		
		}
		return monthName;
		
	}
	

	public Date tomorrow() {
		Date tomorrow=null;
		
		int dia=this.day;
		int mes=this.month;
		int anio=this.year;
		
		dia++;
		if(dia>this.daysOfMonth(month)){
			dia=1;
			mes++;
			if(mes>12){
				mes=1;
				anio++;
			}
		}
		try{
			tomorrow=new Date(dia,mes,anio);
		}catch(DateException e){
			System.out.println("Date.tomorrow:" + e.getMessage());
		}
		
		return tomorrow;
	}

	
	public String getMonthsLeft(){
		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for(int i = this.month +1;i<=12;i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName()+ " ");
			}
		}catch(DateException e){
			System.out.println("Date.getMonthsLeft:" +e.getMessage());
		}
		return monthsLeft.toString();
	}
	
	
	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer dias = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); isDayRight(i); i++) {
				aux.setDay(i);
				dias.append(aux.toString() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getDaysLeftOfMonth: " + e.getMessage());
		}
		return dias.toString();
	}

			
	public String getMonthsSameDays(){
		Date aux = new Date(this);
		StringBuffer meses = new StringBuffer();
		
		try{
			for(int i = 1;i<=12;i++){
				aux.setMonth(i);
				if(aux.daysOfMonth() == this.daysOfMonth()){
					meses.append(aux.getMonthName()+ " ");
				}
			}
		}catch(DateException e){
			System.err.println("Date.getMonthsSameDays:" +e.getMessage());
		}
		return meses.toString();
	}
		
		public int daysPast() {
			int resultado =0;
			
			try{
				Date aux=new Date(1,1,this.year);
				for(int i=1;i<this.month; i++){
					resultado += aux.daysOfMonth();
					aux.setMonth(i+1);
				}
			}catch(DateException e){
				System.out.println("Date.daysPast:" +e.getMessage());
			}
			return resultado + this.day -1;
		}

		
//INTENTO PARA GENERAR FECHA ALEATORIA IGUAL A FECHA while
		public int numRandomTriesEqualDate() {
			
			int d,m, intentos=0;
			
			boolean caso=false;
			
			while(caso==false){
				
				m=(int)(Math.random()*12)+1;
				
				if(m==4 || m==6 || m==9 || m==11){
					d=(int)(Math.random()*30)+1;

				}
				else if(m==2){
					d=(int)(Math.random()*28)+1;
				}
				else{
					d=(int)(Math.random()*31)+1;
				}
					intentos++;
					
				if(m==this.month && d==this.day){
					caso=true;
				}
				
			}
				
				return intentos;
		}


//Dia de la semana
		public String nameDayOfWeek(int day){
			
			String _dia;

			switch(day) {
				
				case 1:  
					_dia="Monday";
					break;
				case 2: 
					_dia="Tuesday";
					break;
				case 3:  
					_dia="Wednesday";
					break;
				case 4:  
					_dia="Thursday";
					break;
				case 5:  
					_dia="Friday";
					break;
				case 6: 
					_dia="Saturday";
					break;
				case 7:  
					_dia="Sunday";
					break;
					
				default:
					_dia="Wrong day";
			}		

		return _dia;
		}
	
		public String dayOfWeek(int firstOfJanuary){
			int dayNumber;
			
			dayNumber = ( daysPast() % 7 + firstOfJanuary ) % 7;
			
			return nameDayOfWeek(dayNumber);
		}
		
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	
	

	

	

	
	

	

	

}

