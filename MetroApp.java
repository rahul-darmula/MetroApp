import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;  
import java.text.DateFormat; 
import java.time.*; //
import java.time.LocalDateTime; //
class Login{
	//public static void main(String[] args){
	static int banner=1;
	static Scanner sc = new Scanner(System.in);
	static boolean login(){
		//boolean loginSucess = false;
	
		boolean isInvalidNum = true;
		//int x=1;
		//while(isInvalid){
			if(banner==1){
				System.out.println("-----------------------------------");
				System.out.println("             Login                 ");
				System.out.println("-----------------------------------");
				banner=0;
			}
			
				System.out.print("Enter Mobile Number: +91 ");

				long mobNum = sc.nextLong();
				
				String num = mobNum+"";
				//if(num.length()<10 || num.length()>10){
				if(Validation.checkPhoneNo(mobNum)){
					System.out.println("Invalid Mobile number please re-enter.");
					isInvalidNum = true;
				}
				else{
					isInvalidNum = false;
					boolean invalidOtp = true;
					//double randNum = Math.random(); //0.5522052449411765
					//int otp = (int)(Math.random()*10000); 
					//0.5522052449411765 * 10000 --> 5522.052449411765 --> int->5522
					//int max = 999999;
					//int min = 100000;
					//int otp = (int) Math.round(Math.random() * (max - min + 1) + min);
					Random random = new Random();

					// Generate a random integer between 1000 (inclusive) and 10000 (exclusive)
					int otp = random.nextInt(10000 - 1000) + 1000;

				// Print the 4-digit number with leading zeros (if necessary)
				//System.out.printf("%04d\n", randomNumber);
					
					System.out.println("Your OTP to login is: "+otp);
					System.out.print("Enter OTP: ");
					while(invalidOtp){
						int enteredOtp = sc.nextInt();
						if(otp == enteredOtp){
							invalidOtp = false;
							return true;
							
						}
						else{
							System.out.println("Invalid OTP Re-enter OTP");
							
						}
					}	
				}
				if(isInvalidNum)	return login();
				
			
		//}
		return false;
	}
}
class MetroApp{
	public static void main(String[] args){
		if(Login.login()){
			
			
			selectMetroCity();
		}
	}
	static void selectMetroCity(){
		System.out.println("-----Select your Metro-----");
		boolean InvalidOp = true;
		while(InvalidOp){
			System.out.println("1. Bengaluru Metro"); //banglore ki FareWRTDist rayaledu
			System.out.println("2. Chennai Metro");
			System.out.println("3. Delhi Metro");
			System.out.println("4. Hyderabad Metro");
			System.out.println("5. Mumbai Metro");
			System.out.println("6. Exit");
			System.out.print("Select your option: ");
			int op = Login.sc.nextInt();
			switch(op){
				case 1:  
					TravelOpMenu.chooseOpToTravel(op);
					
					InvalidOp=false;
					break;
				case 2: 
					TravelOpMenu.chooseOpToTravel(op);
					InvalidOp=false;
					break;
				case 3: 
					TravelOpMenu.chooseOpToTravel(op);
					InvalidOp=false;
					break;
				case 4: 
					TravelOpMenu.chooseOpToTravel(op);
					//Hyderabad.showHyd();
					InvalidOp=false;
					break;
				case 5: 
					TravelOpMenu.chooseOpToTravel(op);
					InvalidOp=false;
					break;
				case 6:	
					System.out.println("Thank You for Visiting Metro App");
					System.exit(0);
				default: System.out.println("Invalid selection please select again");
				InvalidOp=true;		
			}
		}
	}
}
//Red Line Miyapur - LB Nagar
class Hyderabad{
	//QR
	//smart card rechare
	//single //return jounney
	static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	static void showHyd(boolean isSingleJour, int metroCity){
		
		map.put(1,	"Miyapur");
		map.put(2,	"JNTU College");//
		map.put(3,	"KPHB Colony");
		map.put(4,	"Kukatpally");
		map.put(5, "Dr. B. R. Ambedkar Balanagar");
		map.put(6,	"Moosapet");
		map.put(7, "Bharat Nagar");
		map.put(8,	"Erragadda");
		map.put(9,	"ESI Hospital");
		map.put(10,	"S.R. Nagar");
		map.put(11, "Ameerpet");
		map.put(12,	"Punjagutta");
		map.put(13,	"Irrum Manzil");
		map.put(14,	"Khairatabad");
		map.put(15,	"Lakdi-ka-pul");
		map.put(16, "Assembly");
		map.put(17,	"Nampally");
		map.put(18,	"Gandhi Bhavan");
		map.put(19,	"Osmania Medical College");
		map.put(20,	"MG Bus Station");
		map.put(21,	"Malakpet");
		map.put(22,	"New Market");
		map.put(23,	"Musarambagh");
		map.put(24, "Dilsukhnagar");
		map.put(25, "Chaitanyapuri");
		map.put(26,	"Victoria Memorial");
		map.put(27,	"LB Nagar");

		System.out.println("-----All Stations-----");

		System.out.printf("|%-2s| %-28s |%-2s| %-28s |", "S.No", "Station Name", "S.No", "Station Name");
		
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			
			if(key%2==0){
				if(key<=9)	System.out.printf("| %-2s | %-28s |", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s |", key, value);
			}
			else{
				System.out.println();
				if(key<=9)	System.out.printf("| %-2s | %-28s ", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s ", key, value);
			}
		}
		//System.out.println();
		//System.out.println("!Enter 0 to exit!");
		TravelDetails.getTravelDetails(map, metroCity, isSingleJour);
	}
	
}
//---------------------------------------------------------------------------------------------------------------------------------------------------
class Bengaluru{
	static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	static void showBengaluru(boolean isSingleJour, int metroCity){
		
		map.put(1,	"Kengeri");
		map.put(2,	"Kengeri bus terminal");//
		map.put(3,	"pattanagare");
		map.put(4,	"Jnanabharathi");
		map.put(5, "Rajeswari Nagar");
		map.put(6,	"Nayandahalli");
		map.put(7, "Mysore Road");
		map.put(8,	"Attiguppe");
		map.put(9,	"Vijayanagar");
		map.put(10,	"Sri Balagangadaranadha Swamiji S.T.N.Hosahali");
		map.put(11, "Magadi Road");
		map.put(12,	"Kranthivira Sangoli Rayanna Railway");
		map.put(13,	"Sri M Visveswaraya Station Central College");
		map.put(14,	"Dr.B.R.Ambedkar stn Vidhana Soudha");
		map.put(15,	"Mahatma Gandhi Road");
		map.put(16, "Trinity");
		map.put(17,	"Halasuru");
		map.put(18,	"Indranagar");
		map.put(19,	"Swami vivekanandha road");
		map.put(20,	"Baiyyapanahalli");
		

		System.out.println("-----All Stations-----");

		System.out.printf("|%-2s| %-45s |%-2s| %-45s |", "S.No", "Station Name", "S.No", "Station Name");
		
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			
			if(key%2==0){
				if(key<=9)	System.out.printf("| %-2s | %-45s |", "0"+key, value);
				else
				System.out.printf("| %-2s | %-45s |", key, value);
			}
			else{
				System.out.println();
				if(key<=9)	System.out.printf("| %-2s | %-45s ", "0"+key, value);
				else
				System.out.printf("| %-2s | %-45s ", key, value);
			}
		}
		
		TravelDetails.getTravelDetails(map, metroCity, isSingleJour);
	}
}

class Chennai{
	static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	static void showChennai(boolean isSingleJour, int metroCity){
		
		map.put(1,	"Alandur");
		map.put(2,	"Ekkattuthangal");
		map.put(3,	"Ashoke Nagar");
		map.put(4,	"Vadapalani");
		map.put(5, "Arumbakkam");
		map.put(6,	"C M B T");
		map.put(7, "Koyambedu");
		map.put(8,	"Thirumangalam");
		map.put(9,	"Anna Nagar Tower");
		map.put(10,	"Anna nagar East");
		map.put(11, "Shenoy Nagar");
		map.put(12,	"Pachiyappa's College");
		map.put(13,	"kilpauk");
		map.put(14,	"Nehru Park");
		map.put(15,	"Egmore Metro");
		map.put(16, "Central Metro");

		System.out.println("-----All Stations-----");

		System.out.printf("|%-2s| %-28s |%-2s| %-28s |", "S.No", "Station Name", "S.No", "Station Name");
		
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			
			if(key%2==0){
				if(key<=9)	System.out.printf("| %-2s | %-28s |", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s |", key, value);
			}
			else{
				System.out.println();
				if(key<=9)	System.out.printf("| %-2s | %-28s ", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s ", key, value);
			}
		}
		
		TravelDetails.getTravelDetails(map, metroCity, isSingleJour);
	}
}
class Delhi{
	static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	static void showDelhi(boolean isSingleJour, int metroCity){
		
		map.put(1,	"Shaheed Sthal(New Bus Adda)");
		map.put(2,	"Hindon River");//
		map.put(3,	"Arthala");
		map.put(4,	"Mohan Nagar");
		map.put(5, "Shyam park");
		map.put(6,	"Major Mohit Sharma");
		map.put(7, "Raj Bagh");
		map.put(8,	"Shaheed Nagar");
		map.put(9,	"Dilshad Garden");
		map.put(10,	"Jhil Mil");
		map.put(11, "Mansarovar Park");
		map.put(12,	"Shahdara");
		map.put(13,	"Welcome Conn:Pink");
		map.put(14,	"Seelampur");
		map.put(15,	"Shastri Park");
		map.put(16, "kashmere Gate Conn:Violet");
		map.put(17,	"Tis Hazari");
		map.put(18,	"Pul Bangash");
		map.put(19,	"Pratap Nagar");
		map.put(20,	"Shastri Nagar");
		map.put(21,	"Inderlok");
		map.put(22,	"Kanhaiya Nagar");//
		map.put(23,	"keshav Puram");
		map.put(24,	"Netaji Subash Place Conn:Pink");
		map.put(25, "Kohat Enclave");
		map.put(26,	"pitam Pura");
		map.put(27, "Rohini East");
		map.put(28,	"Rohini West");
		map.put(29,	"Rithala");
		

		System.out.println("-----All Stations-----");

		System.out.printf("|%-2s| %-28s |%-2s| %-28s |", "S.No", "Station Name", "S.No", "Station Name");
		
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			
			if(key%2==0){
				if(key<=9)	System.out.printf("| %-2s | %-28s |", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s |", key, value);
			}
			else{
				System.out.println();
				if(key<=9)	System.out.printf("| %-2s | %-28s ", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s ", key, value);
			}
		}
		
		TravelDetails.getTravelDetails(map, metroCity, isSingleJour);
	}
}
class Mumbai{
	static LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	static void showMumbai(boolean isSingleJour, int metroCity){
		
		map.put(1,	"Versova");
		map.put(2,	"DN Nagar");
		map.put(3,	"Azad Nagar");
		map.put(4,	"Andheri");
		map.put(5, "W E H");
		map.put(6,	"Chakala");
		map.put(7, "Airport");
		map.put(8,	"Moral Naka");
		map.put(9,	"Sakinaka");
		map.put(10,	"Asalpha");
		map.put(11, "Jagruthi Nagal");
		map.put(12,	"Ghatkopar");

		System.out.println("-----All Stations-----");

		System.out.printf("|%-2s| %-28s |%-2s| %-28s |", "S.No", "Station Name", "S.No", "Station Name");
		
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			
			if(key%2==0){
				if(key<=9)	System.out.printf("| %-2s | %-28s |", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s |", key, value);
			}
			else{
				System.out.println();
				if(key<=9)	System.out.printf("| %-2s | %-28s ", "0"+key, value);
				else
				System.out.printf("| %-2s | %-28s ", key, value);
			}
		}
		
		TravelDetails.getTravelDetails(map, metroCity, isSingleJour);
	}
}
//---------------------------------------------------------------------------------------------------------------------------------------------------


class CalFare
{
	//bengaluru pending
	static double hydDistArr[] = new double[27];
	static double chenDistArr[] = new double[15];
	static double delDistArr[] = new double[29];
	static double mumbDistArr[] = new double[11];
	static int calBangloreFareWRTStations(int s, int e){
		int amt = 0;
		int noOfStations = Math.abs(s-e);
		if(noOfStations <= 1)amt = 10;
		else if(noOfStations <=3) amt= 15;
		else if(noOfStations <=4) amt= 18;
		else if(noOfStations<=5) amt= 20;
		else if(noOfStations <=6) amt = 22;
		else if(noOfStations <= 7) amt = 25;
		else if(noOfStations <=8) amt = 28;
		else if(noOfStations <=10) amt = 30;
		else if(noOfStations <=12) amt = 35;
		else if(noOfStations <=13) amt = 38;
		else if(noOfStations <=14) amt = 40;
		else if(noOfStations <=15) amt = 42;
		else if(noOfStations <=17) amt = 45;
		else if(noOfStations <=19) amt = 50;
		else if(noOfStations <=20) amt = 52;
		
		return amt;
	}
	static int calMumbaiFareWRTDist(int s, int e){
		mumbDistArr[0]=1.2; mumbDistArr[1]=0.8; mumbDistArr[2]=1.6; mumbDistArr[3]=0.85;
		mumbDistArr[4]=1.2; mumbDistArr[5]=0.9; mumbDistArr[6]=1.4; mumbDistArr[7]=0.95;
		mumbDistArr[8]=1.0; mumbDistArr[9]=0.85; mumbDistArr[10]=1.3; 
		
		System.out.println();
		double dist = 0;
		
		int amt = 0;
		if(s<e){
			for(int i=s-1; i<e-1; i++){
				dist+=mumbDistArr[i];
			}
		}
		else{
			for(int i=e-1; i<s-1; i++){
				dist+=mumbDistArr[i];
			}
		}
		//System.out.println(dist);
		if(dist>=0 && dist<=3)	amt=10; 
		else if(dist>3 && dist<=12)	amt=20; 
		else if(dist>12 && dist <=18)	amt=30; 
		else if(dist>18 && dist <=24)	amt=40; 
		else if(dist>24 && dist <=30)	amt=50; 
		else if(dist>30 && dist <=36)	amt=60; 
		else if(dist>36 && dist <=42)	amt=70; 
		else if(dist>42)	amt=80; 
		
		
		return amt;
	}
	static int calChennaiFareWRTDist(int s, int e){
		chenDistArr[0]=1.7; chenDistArr[1]=2.2; chenDistArr[2]=2.3; chenDistArr[3]=1.5;
		chenDistArr[4]=1.4; chenDistArr[5]=2.1; chenDistArr[6]=2.5; chenDistArr[7]=0.9;
		chenDistArr[8]=1.1; chenDistArr[9]=1.2; chenDistArr[10]=2.4; chenDistArr[11]=1.1;
		chenDistArr[12]=1.8; chenDistArr[13]=3.1; chenDistArr[14]=1.4; 
		System.out.println();
		double dist = 0;
		int amt = 0;
		if(s<e){
			for(int i=s-1; i<e-1; i++){
				dist+=chenDistArr[i];
			}
		}
		else{
			for(int i=e-1; i<s-1; i++){
				dist+=chenDistArr[i];
			}
		}
		if(dist>=0 && dist<=2)	amt=10; 
		else if(dist>2 && dist<=5)	amt=20; 
		else if(dist>5 && dist <=8)	amt=30; 
		else if(dist>8 && dist <=12)	amt=40; 
		else if(dist>12)	amt=50; 
		//System.out.println(dist);
		return amt;
	}
	static int calDelhiFareWRTDist(int s, int e){
		delDistArr[0]=0.0; delDistArr[1]=1.0; delDistArr[2]=2.5; delDistArr[3]=3.2;
		delDistArr[4]=4.5; delDistArr[5]=5.7; delDistArr[6]=6.9; delDistArr[7]=8.2;
		delDistArr[8]=9.4; delDistArr[9]=10.3; delDistArr[10]=11.4; delDistArr[11]=12.4;
		delDistArr[12]=13.4; delDistArr[13]=14.8; delDistArr[14]=16.4; delDistArr[15]=18.5;
		delDistArr[16]=19.7; delDistArr[17]=20.6; delDistArr[18]=21.4; delDistArr[19]=23.1; 
		delDistArr[20]=24.3; delDistArr[21]=25.5; delDistArr[22]=26.2;delDistArr[23]=27.4;
		delDistArr[24]=28.6; delDistArr[25]=29.6; delDistArr[26]=30.4; delDistArr[27]=31.7;
		delDistArr[28]=32.7;
	
		
		//System.out.println();
		double dist = 0;
		int amt = 0;
		if(s<e){
			for(int i=s-1; i<e-1; i++){
				dist+=delDistArr[i];
			}
		}
		else{
			for(int i=e-1; i<s-1; i++){
				dist+=delDistArr[i];
			}
		}
		if(dist>=0 && dist<=2)	amt=10; 
		else if(dist>2 && dist<=5)	amt=20; 
		else if(dist>5 && dist <=12)	amt=30; 
		else if(dist>12 && dist <=21)	amt=40; 
		else if(dist>21 && dist <=32)	amt=50; 
		else if(dist>32)	amt=60; 
		
		return amt;
	}
	
	static int calHydFareWRTDist(int s, int e){
		hydDistArr[0]=1.8; hydDistArr[1]=1.6; hydDistArr[2]=1.4; hydDistArr[3]=1.2;
		hydDistArr[4]=0.7; hydDistArr[5]=0.85; hydDistArr[6]=1.1; hydDistArr[7]=1.2;
		hydDistArr[8]=0.8; hydDistArr[9]=0.8; hydDistArr[10]=0.95; hydDistArr[11]=1.1;
		hydDistArr[12]=1.0; hydDistArr[13]=1.2; hydDistArr[14]=1.1; hydDistArr[15]=0.65;
		hydDistArr[16]=0.95; hydDistArr[17]=0.8; hydDistArr[18]=0.55; hydDistArr[19]=1.4;
		hydDistArr[20]=0.85; hydDistArr[21]=0.95; hydDistArr[22]=1.5; hydDistArr[23]=0.95;
		hydDistArr[24]=1.2; hydDistArr[25]=1.7; 
		//for(int i=0; i<hydDistArr.length; i++){
		//	System.out.print(hydDistArr[i]+" ");
		//}
		//System.out.println();
		double dist = 0;
		int amt = 0;
		if(s<e){
			for(int i=s-1; i<e-1; i++){
				dist+=hydDistArr[i];
			}
		}
		else{
			for(int i=e-1; i<s-1; i++){
				dist+=hydDistArr[i];
			}
		}
		if(dist>=0 && dist<=2)	amt=10; 
		else if(dist>2 && dist<=4)	amt=15; 
		else if(dist>4 && dist <=6)	amt=25; 
		else if(dist>6 && dist <=8)	amt=30; 
		else if(dist>8 && dist <=10)	amt=35; 
		else if(dist>10 && dist <=14)	amt=40; 
		else if(dist>14 && dist <=18)	amt=45; 
		else if(dist>18 && dist <=22)	amt=50; 
		else if(dist>22 && dist <=26)	amt=55; 
		else if(dist>26)	amt=60; 
		
		return amt;
	}
	
	static int calculateFare(int s, int e, int metroCity){
		int amt = 0;
		
		switch(metroCity){
			case 1: amt=calBangloreFareWRTStations(s, e);
				break;
			case 2: amt = calChennaiFareWRTDist(s, e);
				break;
			case 3: amt = calDelhiFareWRTDist(s, e);
				break;
			case 4: amt=calHydFareWRTDist(s, e);
				break;
			case 5: amt = calMumbaiFareWRTDist(s, e);
				break;
			
		}
		 
		return amt;
	}
	
}

class Payment{
	static void paymentMethods(int amt){
		System.out.println("-----Select an option to pay Rs "+amt+" -----");
		System.out.println("1. UPI");
		System.out.println("2. Credit Card");
		//System.out.println("3. Back");
		int op = Login.sc.nextInt();
		switch(op){
			case 1: UPI.payUsingUPI(amt);
					break;
			case 2: CC.payUsingCC(amt);
				break;
			//case 3: TravelDetails.getTravelDetails();
			//	break;
			default: System.out.println("Invalid selection");
				paymentMethods(amt);
		}
	}
}
//---------------------------------------------------
interface TicketPayment{
	public abstract void ticketBooking(int quantity);
}
abstract class Bank{
	static int balance = 1000;
	abstract boolean withdraw(int amt);
	static void balanceEnquiry(){
		System.out.println("Available balance: "+balance);
	}
}
class PhonePay extends Bank implements TicketPayment{
	static boolean paySucess = false;
	boolean withdraw(int amt){//int unde
		
		if(amt <= Bank.balance){
			System.out.println("Enter Pin: ");
			int pin = Login.sc.nextInt();
			Bank.balance -= amt;
			paySucess = true;
			//System.out.println("Transaction Sucessful"+Bank.balance);
		}
		return paySucess;
		
	}
	public void ticketBooking(int amt){//int unde
	
		if(withdraw(amt)){
			//System.out.println("Ticket Purchase Sucessfull Rs. "+Bank.balance);
			
		}
		else{
			System.out.println("Insufficient balance");
		}
	}
	
}
class AmazonPay extends Bank implements TicketPayment{
	int apb = 10;
	static boolean paySucess = false;
	boolean withdraw(int amt){//int unde
		if(amt <= Bank.balance){
			System.out.println("Enter Pin: ");
			int pin = Login.sc.nextInt();
			Bank.balance -= amt;
			paySucess = true;
			//System.out.println("Transaction Sucessful");
		}
		return paySucess;
		
	}
	public void ticketBooking(int amt){//int unde
		if(withdraw(amt)){
			//System.out.println("Ticket Purchase Sucessfull Rs. "+Bank.balance);
			
		}
		else{
			System.out.println("Insufficient balance");
		}
	}
}
class TimeAndDate{
	static Date date = new Date();
     static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
     static  String str = formatter.format(date);//date
      //System.out.println(str);
	 static DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	static	String strResult = dateFormat.format(new Date());
	
	//---
	
	//---
	static void showTracactionTimeAndDate(){
		
      System.out.println("Transaction Date and Time: "+str+" "+strResult);
	}
	static boolean timeCrossed(){
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime date2 = LocalDateTime.of(year, month, day, 22, 45, 00);
		LocalDateTime date3 = LocalDateTime.of(year, month, day, 5, 30, 00);
		System.out.println("Current time is: "+strResult);
		if(date1.isAfter(date2)) {
			
            return true;
        }
		else if(date1.isBefore(date3)){
			return true;
		}
		return false;

	}
}
//---------------------------------------------------
class UPI{
	/*private long phNo;
	private int otp = (int)Math.random()*10000;
	public void setPhNo(long phNo){
		this.phNo=phNo;
	}
	public int getOTP(){
		return otp;
	} */
	static void payUsingUPI(int amt){
		System.out.println("-----Select UPI-----");
		System.out.println("1. PhonePe\n2. Amazon Pay");
		int op = Login.sc.nextInt();
		if(op==1){
			PhonePay pp = new PhonePay();
			pp.ticketBooking(amt); //actually to recharge SC
		}
		else if(op==2){
			AmazonPay ap = new AmazonPay();
			ap.ticketBooking(amt); //actually to recharge SC
		}
	}
}
class CC{
	/*
	private long cardNo;
	private int cvv, pin;
	private String expiry;
	*/
	static boolean paySucess = false;
	static void payUsingCC(int amt){
		System.out.println("Enter Card No: ");
		long cardNo = Login.sc.nextLong();
		System.out.println("Enter CVV: ");
		int cvv = Login.sc.nextInt();
		System.out.println("Enter Expiry: ");
		String expiry = Login.sc.next();
		paySucess= true;
		
	}
}
class SC{
	static void SCRecharge(int metroCity){
		System.out.println("\n-----Recharge Smart Card-----");
		System.out.println("Please enter your 14 digit Metro Smart card number to recharge");
		boolean invalidSCNum = true;
		while(invalidSCNum){
			System.out.print("Enter Card Number: ");
			long scNum = Login.sc.nextLong();
			if(Validation.checkSCNum(scNum)){
				invalidSCNum = false;
				System.out.println("Your Card Number: "+scNum);
				//availabe balance validity
				System.out.println("Minimum recharge amount is Rs 100. Please enter the amount in multiples of 50 i.e 100, 150, 200 etc");
				boolean inValidAmt = true;
				while(inValidAmt){
					System.out.print("Enter amount: ");
					int amt = Login.sc.nextInt();
					if(Validation.validAmount(amt)){
						inValidAmt=false;
						System.out.println("1. Proceed to pay Rs "+amt+"\n2.Back");
						if(Login.sc.nextInt()==1){
							Payment.paymentMethods(amt);
							if(PhonePay.paySucess || AmazonPay.paySucess||CC.paySucess){
								System.out.println("Smart card Recharge of amount Rs "+amt+" sucessful");
								TimeAndDate.showTracactionTimeAndDate();
								return;
							}
						}
						else{
							TravelOpMenu.chooseOpToTravel(metroCity);
						}
					}
					else{
						System.out.println("Invalid Amount....");
						inValidAmt=true;
					}
				}
			}
			else{
				System.out.println("Invalid smart card number. Please re enter again");	
			}
		}
	}
}


class TravelOpMenu{
	static boolean isSingleJour = true;
	static void chooseOpToTravel(int metroCity){
		System.out.println("-----Choose an option to travel-----");
		System.out.println("\t1. Metro QR Ticket\n\t2. Smart Card Recharge\n\t3. Back(To change your Metro city selection)");
		System.out.print("Enter option(1-3): ");
		int op = Login.sc.nextInt();
		if(op==2){
			SC.SCRecharge(metroCity);
		}
		else if(op==1){
			System.out.println("-----Buy Metro QR Ticket-----");
			askJourneyType(metroCity);
			if(metroCity == 1){
				Bengaluru.showBengaluru(isSingleJour, metroCity);
			}
			else if(metroCity == 2){
				Chennai.showChennai(isSingleJour, metroCity);
			}
			else if(metroCity == 3){
				Delhi.showDelhi(isSingleJour, metroCity);
			}	
			else if(metroCity == 4){
				Hyderabad.showHyd(isSingleJour, metroCity);
			}
			else if(metroCity == 5){
				Mumbai.showMumbai(isSingleJour, metroCity);
			}
				
		}
		else if(op==3){
			MetroApp.selectMetroCity();
		}
		else{
			System.out.println("Invalid selection..Please select again");
			chooseOpToTravel(metroCity);
		}
	}
	static void askJourneyType(int metroCity){
		
		boolean invalidOp = true;
		while(invalidOp){
			System.out.println("Select journey type:");
			System.out.println("\t1.Single Journey\n\t2.Return Journey\n\t3.Back");
			System.out.print("Enter selection: ");
			int op = Login.sc.nextInt();
			if(op==1){	
				isSingleJour = true;
				invalidOp = false;
			}
			else if(op==2){ 
				isSingleJour = false;
				invalidOp = false;
			}
			else if(op==3){
				chooseOpToTravel(metroCity);
				invalidOp = false;
			}
			else{
				System.out.println("Invalid selection please re enter again...");
				invalidOp = true;
			}
		}
		//return isSingleJour;
	}
}
class TravelDetails{
	static String metro[] = {"Bengaluru Metro", "Delhi Metro", "Hyderabad Metro", "Mumbai Metro"};
	static int getPassCount(int metroCity){
		System.out.print("Enter Passenger count: ");
		int passCount = Login.sc.nextInt();
		if(passCount <= 0){
			System.out.println("Inavalid Passenger count");
			return getPassCount(metroCity);
		}
		if(Validation.isValidPassCount(passCount)==false){
			//String metro[] = new String[5];
			
			System.out.println("Maximum 6 QR tickets are allowed per user by "+metro[metroCity-1]);
			return getPassCount(metroCity);
		}
		return passCount;
	}
	static void printData(int s, int e, boolean isSingleJour, LinkedHashMap<Integer, String> map){
		String sVal ="", eVal="" ;
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			if(key==s)
				sVal = mapEle.getValue();
			else if(key==e)
				eVal = mapEle.getValue();
		}
		if(isSingleJour){
			//System.out.printf("\t%-15s ----> \t%-15s ", sVal, eVal);
			//System.out.println();
			System.out.println("\t"+sVal+" ----> "+eVal);
		}
		else{
			System.out.println("\t"+sVal+" ----> "+eVal);
			System.out.println("\t"+eVal+" <---- "+sVal);
		}
	}
	static void paymentFwdBwd(){
		
	}
	static void getTravelDetails(LinkedHashMap<Integer, String> map, int metroCity, boolean isSingleJour){
		boolean is = true;
		int x=1;
		while(is){
			System.out.println();
			//enter b/w 1to27f
			System.out.println("1.Proceed\n2.Back");
			System.out.print("Enter selection: ");
			int sel = Login.sc.nextInt();
			if(sel==2) TravelOpMenu.chooseOpToTravel(metroCity);
			else if(sel!=1 && sel!=2){
				System.out.println("Invalid Input. Please select again");
				getTravelDetails(map, metroCity, isSingleJour);
			}
			System.out.println("Enter values in range 1 to "+map.size());
			System.out.print("Choose start Location: ");
			int s = Login.sc.nextInt();
			//if(s==0)	TravelOpMenu.askJourneyType(metroCity);//.........inka rayaledu back
			if(!(s>=1 && s<=map.size())){
				System.out.println("Invalid Station");
				x=1;
			}
			else{
				System.out.print("Choose destination: ");
				int e = Login.sc.nextInt();
				if(s==e || !(e>=1 && e<=map.size())){
					System.out.println("Invalid Station");
					x=1;

				}
				else {

					//x=0;
					int passCount = getPassCount(metroCity);
					
		
					System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					printData(s, e, isSingleJour, map);
					System.out.println("Passengers: "+passCount);
					int amtPerPerson = CalFare.calculateFare(s, e, metroCity);
					System.out.println("Rs: "+amtPerPerson+" / Person");
					int amt = amtPerPerson*passCount;
					if(isSingleJour == false)	amt=amt*2;
					System.out.println("Total Amount: "+amt);
					System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					System.out.println("Select\t1. Proceed to Pay Rs: "+amt+"\n\t2. Back(To select stations)");
					int op = Login.sc.nextInt();
					if(op==1){
						x=0;
						if(TimeAndDate.timeCrossed()){
							System.out.println(metro[metroCity-1]+" allows QR ticket \npurchase from 5:30 AM to 10:45 PM (IST)\n on all days. Please visit us during the eligible time to purchase the QR ticket.");
							return;
						}
						else{
							Payment.paymentMethods(amt);
							if(CC.paySucess || AmazonPay.paySucess || PhonePay.paySucess){
								System.out.println("-----Ticket purchase Sucessfull Rs "+amt+" -----");
								TimeAndDate.showTracactionTimeAndDate();
								System.out.println();
								if(isSingleJour){
									System.out.println("Single Journey");
									System.out.println(TravelDetails.metro[metroCity-1]);
									printData(s, e, isSingleJour, map);
								}
								else{
									System.out.println("Return Journey");
									printData(s, e, isSingleJour, map);
								}
								System.out.println("Valid till "+TimeAndDate.str+" 11:00 PM");
								return;
							}
						}
						//if payment is sucessfull show that ticket purchase sucessfull
						//print ticket booked time and sorce, dest, (if possibel QR code)
					}
					else{
						//x=1; //-------
						if(metroCity==1)Bengaluru.showBengaluru(isSingleJour, metroCity);
						else if(metroCity ==2)Chennai.showChennai(isSingleJour, metroCity);
						else if(metroCity==3)Delhi.showDelhi(isSingleJour, metroCity);
						else if(metroCity==4)Hyderabad.showHyd(isSingleJour, metroCity);
						else if(metroCity==5)Mumbai.showMumbai(isSingleJour, metroCity);
					}
				}	
			}
			if(x==0)	is=false;
		}
	}
}

class Validation{
		static boolean checkPhoneNo(long mobNum){
			String num = mobNum+"";
			if(num.length()<10 || num.length()>10){
				return true;
			}
			else{
				return false;
			}
		}
		static boolean checkSCNum(long scNum){
			String num = scNum+"";
			if(num.length()==14)
				return true;
			else
				return false;
		}
		static boolean validAmount(int amt){
			if(amt%50==0 && amt>=100)	return true;
			else	return false;
		}
		static boolean isValidPassCount(int passCount){
			if(passCount>=1 && passCount<=6) return true;
			else return false;
		}
	
}