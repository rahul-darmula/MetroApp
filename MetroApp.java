import java.util.Scanner;
import java.util.*;


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
					int otp = (int)(Math.random()*10000); 
					//0.5522052449411765 * 10000 --> 5522.052449411765 --> int->5522
			
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
			System.out.println("1. Bengaluru Metro");
			System.out.println("2. Chennai Metro");
			System.out.println("3. Delhi Metro");
			System.out.println("4. Hyderabad Metro");
			System.out.println("5. Mumbai Metro");
			System.out.println("6. Exit");
			System.out.print("Select your option: ");
			int op = Login.sc.nextInt();
			switch(op){
				case 1:  
				InvalidOp=false;
					break;
				case 2: InvalidOp=false;
					break;
				case 3: InvalidOp=false;
					break;
				case 4: 
					TravelOpMenu.chooseOpToTravel(op);
					//Hyderabad.showHyd();
					InvalidOp=false;
					break;
				case 5: InvalidOp=false;
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
class CalFare
{	
	static double hydDistArr[] = new double[27];
	
	
	static int calculateFare(int s, int e, int passCount){
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
		System.out.println();
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
		 
		//System.out.println(amt);
		//System.out.println(dist);
		return amt*passCount;
	}
	public static int calculateFare(int s, int e){
		hydDistArr[0]=1.8; hydDistArr[1]=1.6; hydDistArr[2]=1.4; hydDistArr[3]=1.2;
		hydDistArr[4]=0.7; hydDistArr[5]=0.85; hydDistArr[6]=1.1; hydDistArr[7]=1.2;
		hydDistArr[8]=0.8; hydDistArr[9]=0.8; hydDistArr[10]=0.95; hydDistArr[11]=1.1;
		hydDistArr[12]=1.0; hydDistArr[13]=1.2; hydDistArr[14]=1.1; hydDistArr[15]=0.65;
		hydDistArr[16]=0.95; hydDistArr[17]=0.8; hydDistArr[18]=0.55; hydDistArr[19]=1.4;
		hydDistArr[20]=0.85; hydDistArr[21]=0.95; hydDistArr[22]=1.5; hydDistArr[23]=0.95;
		hydDistArr[24]=1.2; hydDistArr[25]=1.7;
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
	
}

class Payment{
	
	static void paymentMethods(int amt){
		System.out.println("1. UPI");
		System.out.println("2. Credit Card");
		
	
		int op = Login.sc.nextInt();
		switch(op){
			case 1: UPI.payUsingUPI(amt);
					break;
			case 2: CC.payUsingCC(amt);
				break;
			//case 3: SC.payUsingSC(amt);
			//	break;
			default: System.out.println("Invalid selection");
				paymentMethods(amt);
		}
	}
}
class UPI{
	private long phNo;
	private long otp = (int)Math.random()*10000;
	public void setPhNo(long phNo){
		this.phNo=phNo;
	}
	public long getOTP(){
		return otp;
	}
	static void payUsingUPI(int amt){
		
	}
}
class CC{
	static void payUsingCC(int amt){
		
	}
}
class SC{
	static void SCRecharge(){
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
				System.out.println("Minimum recharge amount is Rs 100. Please enter the amount in multiples of 100 i.e 100, 150, 200 etc");
				boolean inValidAmt = true;
				while(inValidAmt){
					System.out.print("Enter amount: ");
					int amt = Login.sc.nextInt();
					if(Validation.validAmount(amt)){
						inValidAmt=false;
						System.out.println("Implement Payment methods");
					}
					else{
						System.out.println("Invalid Amount Please enter the amount in multiples of 100....");
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
			if(amt%100==0)	return true;
			else	return false;
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
			SC.SCRecharge();
		}
		else if(op==1){
			System.out.println("-----Buy Metro QR Ticket-----");
			askJourneyType(metroCity);
			if(metroCity == 4){
				
				Hyderabad.showHyd(isSingleJour, metroCity);
			}
		}
		else{
			MetroApp.selectMetroCity();
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
	static void getTravelDetails(LinkedHashMap<Integer, String> map, int metroCity, boolean isSingleJour){
		boolean is = true;
		int x=1;
		while(is){
			System.out.println();
			//enter b/w 1to27
			System.out.println("Enter values in range 1 to "+map.size());
			System.out.print("Choose start Location: ");
			int s = Login.sc.nextInt();
			if(s==0)	TravelOpMenu.askJourneyType(metroCity);//.........inka rayaledu back
			else if(!(s>=1 && s<=27)){
				System.out.println("Invalid Station");
				x=1;
			}
			else{
				System.out.print("Choose destination: ");
				int e = Login.sc.nextInt();
				if(s==e || !(s>=1&& s<=27)){
					System.out.println("Invalid Station");
					x=1;
				}
				else {

					x=0;
					System.out.print("Enter Passenger count: ");
					int passCount = Login.sc.nextInt();
					System.out.println();
					System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					printData(s, e, isSingleJour, map);
					System.out.println("Passengers: "+passCount);
					System.out.println("Rs: "+CalFare.calculateFare(s, e)+" / Person");
					int amt = CalFare.calculateFare(s, e, passCount);
					if(isSingleJour == false)	amt=amt*2;
					System.out.println("Total Amount: "+amt);
					System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					System.out.println("Select\t1. Proceed to Pay Rs: "+amt+"\n\t2. To select stations");
					int op = Login.sc.nextInt();
					if(op==1){
						x=0;
						Payment.paymentMethods(amt);
					}
					else{
						x=1;
						Hyderabad.showHyd(isSingleJour, metroCity);
					}
				}
				
			}
			if(x==0)	is=false;
		}
	}
}