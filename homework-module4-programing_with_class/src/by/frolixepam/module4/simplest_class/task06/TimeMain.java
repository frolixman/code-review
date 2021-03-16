package by.frolixepam.module4.simplest_class.task06;

public class TimeMain {

	public static void main(String[] args) {
		System.out.println("констр-р по умолчанию");
		Time tDef = new Time();
		System.out.println(tDef.toString());
		
		System.out.println("\nконстр-р с параметрами");
		Time t1 = new Time(15, 0, 0);
		Time t2 = new Time(15, 0, 0);
		System.out.println(t1.toString());
		
		System.out.println("\nизменим время со сдвигом");
		t1.changeTimeWithShift(0, -60, 0);
		System.out.println(t1.getTime());
		
		System.out.println("\nизменим время без сдвига");
		t2.changeTimeNoShift(0, -60, 0);
		System.out.println(t2.getTime());

	}

}
