package by.frolixepam.module4.simplest_class.task06;

/*
 * 6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и изменения его отдельных полей (час, минута,
 * секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы 
 * изменения времени на заданное количество часов, минут и секунд.
 */

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	private String time = hour + ":" + minute + ":" + second;
	
	public Time() {
		
	}
	
	public Time (int hour, int minute, int second) {
		if(hour >= 0 && hour < 24) {
			this.hour = hour;
		}
				
		if(minute >= 0 && minute < 60) {
			this.minute = minute;
		}
				
		if(second >= 0 && second < 60) {
			this.second = second;
		}
		
		time = this.hour + ":" + this.minute + ":" + this.second;
	
	}
	
	public void setHour(int hour) {
		if(hour >= 0 && hour < 24) {
			this.hour = hour;
		}
	}
	public int getHour() {
		return hour;
	}
	
	public void setMinute(int minute) {
		if(minute >= 0 && minute < 60) {
			this.minute = minute;
		}
	}
	public int getMinute() {
		return minute;
	}
	
	public void setSecond(int second) {
		if(second >= 0 && second < 60) {
			this.second = second;
		}
	}
	public int getSecond() {
		return second;
	}
	
	public void setTime(int hour, int minute, int second) {
		if(hour >= 0 && hour < 24) {
			this.hour = hour;
		}
				
		if(minute >= 0 && minute < 60) {
			this.minute = minute;
		}
				
		if(second >= 0 && second < 60) {
			this.second = second;
		}
		
		time = this.hour + ":" + this.minute + ":" + this.second;
	}
	public String getTime() {
		return hour + ":" + minute + ":" + second;
	}
	
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	
	public void changeTimeWithShift(int hour, int minute, int second) {
		
		changeHourWithShift(hour);
		changeMinWithShift(minute);
		changeSecWithShift(second);
				
	}
	
	public void changeHourWithShift(int hour) {				//изменение часов
	
		int finHour = this.hour + hour;				
		if(finHour >= 0 && finHour < 24) {
			this.hour = finHour;
		}
		else if (finHour >= 24){
			this.hour = (this.hour - 24 + hour) % 24;
		}
		else if (finHour < 0) {
			this.hour = 24 - (Math.abs(this.hour - Math.abs(hour)) % 24);
		}
		if(this.hour == 24) {
			this.hour = 0;
		}
	}
	
	public void changeMinWithShift(int minute) {			//изменение минут
		
		int finMin = this.minute + minute;			
		if(finMin >= 0 && finMin < 60) {
			this.minute = finMin;
		}
		else if(finMin >= 60) {
			this.minute = (this.minute + minute - 60) % 60;
			if((this.hour + finMin / 60) < 24) {					//увеличение часов вследствии увеличения минут
				this.hour = this.hour + finMin / 60;
			}
			else {
				this.hour = (this.hour -24 + finMin/60) % 24;
			}
			
		}
		else if(finMin < 0) {
			this.minute = 60 - (Math.abs(this.minute - Math.abs(minute)) % 60);
			if((this.hour - Math.abs(finMin / 60)) >= 0) {						//уменьшение часов вследствии уменьшения минут
				this.hour = (this.hour - (Math.abs(finMin / 60) + 1));
			}
			else {
				this.hour = 24 - Math.abs(this.hour -(Math.abs(finMin / 60) + 1)) % 24;
			}
			
			if(this.minute == 60) {
				this.minute = 0;
				if((this.hour + 1) == 24) {
					this.hour = 0;
				}
				else {
					this.hour++;
				}
			}
		}
	}
	
	public void changeSecWithShift(int second) {			//изменение секунд
		int finSec = this.second + second;			
		if(finSec >= 0 && finSec < 60) {
			this.second = finSec;
		}
		else if(finSec >= 60) {
			this.second = (this.second + second - 60) % 60;
			
			if((this.minute + finSec / 60) < 60) {					//увеличение минут вследствии увеличения секунд
				this.minute = this.minute + finSec / 60;
			}
			else {
				this.minute = (this.minute + finSec/60 - 60) % 60;
			}
			
			if((this.hour + finSec / 3600) < 24) {					//увеличение часов вследствии увеличения секунд
				this.hour = this.hour + finSec / 3600;
			}
			else {
				this.hour = (this.hour -24 + finSec / 3600) % 24;
			}
						
		}
		else if(finSec < 0) {
			int delta = Math.abs(this.second - Math.abs(second));
			this.second = 60 - (delta % 60);
			if((this.minute - Math.abs(finSec / 60 + 1)) >= 0) {						//уменьшение минут вследствии уменьшения секунд
				this.minute = (this.minute - (Math.abs(finSec / 60) + 1));
			}
			else {
				this.minute = 60 - (Math.abs(this.minute -(Math.abs(finSec / 60) + 1)) % 60);
			}
			
			if((this.hour - Math.abs(finSec / 3600 + 1)) >= 0) {						//уменьшение часов вследствии уменьшения секунд
				this.hour = (this.hour - (Math.abs(finSec / 3600) + 1));
			}
			else {
				this.hour = 24 - (Math.abs(this.hour -(Math.abs(finSec / 3600) + 1)) % 24);
			}
			
			if(this.second == 60) {
				this.second = 0;
				if((this.minute + 1) == 60) {
					this.minute = 0;
					
					if((this.hour + 1) == 24) {
						this.hour = 0;
					}
					else {
						this.hour++;
					}
				}
				else {
					this.minute++;
				}
							
			}

		}		
	}
	
	public void changeTimeNoShift(int hour, int minute, int second) {
		
		int finHour = this.hour + hour;									//изменение часов
		if(finHour >= 0 && finHour < 24) {
			this.hour = finHour;
		}
		else if (finHour >= 24){
			this.hour = (this.hour - 24 + hour) % 24;
		}
		else if (finHour < 0) {
			this.hour = 24 - (Math.abs(this.hour - Math.abs(hour)) % 24);
		}
		if(this.hour == 24) {
			this.hour = 0;
		}
		
		int finMin = this.minute + minute;								//изменение минут		
		if(finMin >= 0 && finMin < 60) {
			this.minute = finMin;
		}
		else if(finMin >= 60) {
			this.minute = (this.minute + minute - 60) % 60;
		}
		else if(finMin < 0) {
			this.minute = 60 - (Math.abs(this.minute - Math.abs(minute)) % 60);
			if(this.minute == 60) {
				this.minute = 0;
			}	
		}
		
		int finSec = this.second + second;								//изменение секунд	
		if(finSec >= 0 && finSec < 60) {
			this.second = finSec;
		}
		else if(finSec >= 60) {
			this.second = (this.second + second - 60) % 60;
		}
		else if(finSec < 0) {
			this.second = 60 - (Math.abs(this.second - Math.abs(second)) % 60);
			if(this.second == 60) {
				this.minute = 0;
			}
		}
	}

}
