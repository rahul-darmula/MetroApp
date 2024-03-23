import java.util.Scanner;
import java.util.*;
class Login{
	//public static void main(String[] args){
		static Scanner sc = new Scanner(System.in);
	static boolean login(){
		//boolean loginSucess = false;
		
		boolean isInvalid = true;
		int x=1;
		while(isInvalid){
			if(x==1){
				System.out.println("-----------------------------------");
				System.out.println("             Login                 ");
				System.out.println("-----------------------------------");
				x=0;
			}
			else{
				System.out.print("Enter Mobile Number: +91 ");
				long mobNum = sc.nextLong();
				String num = mobNum+"";
				if(num.length()<10 || num.length()>10){
					System.out.println("Invalid Mobile number please re-enter.");
					isInvalid = true;
				}
				else{
					isInvalid = false;
					boolean invalidOtp = true;
					//double randNum = Math.random(); //0.5522052449411765
					int otp = (int)(Math.random()*10000); 
					//0.5522052449411765 * 10000 --> 5522.052449411765 --> int->5522
			
					System.out.println("Your OTP to login is: "+otp);
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
			}
		}
		return false;
	}
}
class MetroApp{
	public static void main(String[] args){
		if(Login.login()){
			System.out.println("---Select your Metro---");
			
			boolean InvalidOp = true;
			while(InvalidOp){
				System.out.println("1. Bengaluru Metro");
				System.out.println("2. Chennai Metro");
				System.out.println("3. Delhi Metro");
				System.out.println("4. Hyderabad Metro");
				System.out.println("5. Mumbai Metro");
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
						Hyderabad.hyd();
						InvalidOp=false;
						break;
					case 5: InvalidOp=false;
						break;
					default: System.out.println("Invalid selection please select again");
					InvalidOp=true;		
				}
			}
		}
	}
}
//Red Line Miyapur - LB Nagar
class Hyderabad{
	static void hyd(){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "Ameerpet");
		map.put(2, "Assembly");
		map.put(3, "Begumpet");
		map.put(4, "Bharat Nagar");
		map.put(5, "Chaitanyapuri");
		map.put(6, "Chikkadpally");
		map.put(7, "Dilsukhnagar");
		map.put(8, "Dr. B. R. Ambedkar Balanagar");
		map.put(1, "Ameerpet");
		map.put(2, "Assembly");
		map.put(3, "Begumpet");
		map.put(4, "Bharat Nagar");
		map.put(5, "Chaitanyapuri");
		map.put(6, "Chikkadpally");
		map.put(7, "Dilsukhnagar");
		map.put(8, "Dr. B. R. Ambedkar Balanagar");
		System.out.println("All Stations");
		for(Map.Entry<Integer, String> mapEle: map.entrySet()){
			Integer key = mapEle.getKey();
			String value = mapEle.getValue();
			System.out.println(key+". "+value);
		}
	}
}