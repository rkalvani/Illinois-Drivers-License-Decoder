import java.util.Scanner;

public class IllinoisDriversLicenseDecoder {

	public static void main(String[] args) {
		System.out.println("Decode or Encode?");
		System.out.println("Enter 1 to decode or 2 to encode.");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		if (answer.equals("1")) {
			decode();
		} else if (answer.equals("2")){
			encode();
		} 
	}
	
	public static void encode() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String firstName = scanner.nextLine();
		System.out.println("Please enter your middle name");
		String middleName = scanner.nextLine();
		System.out.println("Please enter your last name");
		String lastName = scanner.nextLine();
		System.out.println("Please enter your birthday MM/DD/YY");
		String birthday = scanner.nextLine();
		System.out.println("What is your gender?");
		System.out.println("Enter 1 for female or 2 for male.");
		String gender = scanner.nextLine();
		System.out.print("Your Driver's License number would be: ");
		System.out.println(firstHalf(firstName, middleName, lastName) + secondHalf(birthday, gender));
	}
	
	public static String firstHalf(String firstName, String middleName, String lastName) {
		String soundex = "";
		String fff = "";
		for(int i = 1; i < lastName.length()-1; i++) {
			if(lastName.substring(i, i+1).contains("BFPV")) {
				soundex += "1";
			} else if(lastName.substring(i, i+1).contains("CGJKQSXZ")){
				soundex += "2";
			} else if(lastName.substring(i, i+1).contains("DT")) {
				soundex += "3";
			} else if(lastName.substring(i, i+1).contains("L")) {
				soundex += "4";
			} else if(lastName.substring(i, i+1).contains("MN")) {
				soundex += "5";
			} else if(lastName.substring(i, i+1).contains("R")) {
				soundex += "6";
			} else if(lastName.substring(i, i+1).contains("AEHIOUWY")) {
				soundex += "";
			}
		}
			if(soundex.length() > 2) {
				soundex = soundex.substring(0, 3);
			} else if(soundex.length() == 0){
				soundex = "000";
			} else if(soundex.length() == 1) {
				soundex = soundex + "00";
			} else if(soundex.length() == 2) {
				soundex = soundex + "0";
			} 
		
		
		
		
		return lastName.substring(0,1).toUpperCase() + soundex + "-" + fff;
	}
	
	public static String secondHalf(String birthdayString, String genderString) {
		boolean isGirl = false;
		if (genderString.equals("1")) {
			isGirl = true;
		}
		int month = Integer.parseInt(birthdayString.substring(0, 2));
		int day = Integer.parseInt(birthdayString.substring(3, 5));
		int lastThreeDigits = ((month - 1) * 31) + day;
		if (isGirl) {
			lastThreeDigits += 600;
		}
		return birthdayString.charAt(birthdayString.length() - 2) + "-" + birthdayString.charAt(birthdayString.length()) + lastThreeDigits;
	}
	
	public static void decode() {
		System.out.println("Please enter your Illinois State Driver's License number:");
		Scanner licenseNumber = new Scanner(System.in);
		String fullStringNumber = licenseNumber.nextLine();
		//decodes your gender and birthday
		lastThreeDigits(fullStringNumber.substring(9));
		//year of birth
		System.out.println(fullStringNumber.substring(7, 9));
		//solves for your initials
		initials(fullStringNumber);
	}

	public static void lastThreeDigits(String string) {
		// (MM-1)*31+DD +(600 if female, 0 if male)
		int num = Integer.parseInt(string);
		if (num > 600) {
			num -= 600;
			System.out.println("You are a female");
		} else {
			System.out.println("You are a male");
		}
		System.out.print("Your birthday is ");
		int day = num % 31;
		num = num - day;
		num = num / 31;
		num = num + 1;
		if (num < 10) {
			System.out.print("0");
		}
		System.out.print(num + "/");
		if (day < 10) {
			System.out.print("0");
		}
		System.out.print(day + "/");

	}

	public static void initials(String string) {
		String first = "";
		String middle = "";
		String last = "";

		String name = string.substring(4, 7);
		int nameNum = Integer.parseInt(name);
		int mid = nameNum % 20;
		int firstName = nameNum - mid;
		if (mid == 0) {
			middle = "";
		}
		if (mid == 1) {
			middle = "A";
		}
		if (mid == 2) {
			middle = "B";
		}
		if (mid == 3) {
			middle = "C";
		}
		if (mid == 4) {
			middle = "D";
		}
		if (mid == 5) {
			middle = "E";
		}
		if (mid == 6) {
			middle = "F";
		}
		if (mid == 7) {
			middle = "G";
		}
		if (mid == 8) {
			middle = "H";
		}
		if (mid == 9) {
			middle = "I";
		}
		if (mid == 10) {
			middle = "J";
		}
		if (mid == 11) {
			middle = "K";
		}
		if (mid == 12) {
			middle = "L";
		}
		if (mid == 13) {
			middle = "M";
		}
		if (mid == 14) {
			middle = " N or O ";
		}
		if (mid == 15) {
			middle = "P or Q";
		}
		if (mid == 16) {
			middle = "R";
		}
		if (mid == 17) {
			middle = "S";
		}
		if (mid == 18) {
			middle = "T or U or V";
		}
		if (mid == 19) {
			middle = "W or X or Y or Z";
		}
		if (firstName < 60) {
			first = "A";
		}
		if (firstName >= 60 && firstName < 100) {
			first = "B";
		}
		if (firstName >= 100 && firstName < 160) {
			first = "C";
		}
		if (firstName >= 160 && firstName < 200) {
			first = "D";
		}
		if (firstName >= 200 && firstName < 240) {
			first = "E";
		}
		if (firstName >= 240 && firstName < 280) {
			first = "F";
		}
		if (firstName >= 280 && firstName < 320) {
			first = "G";
		}
		if (firstName >= 320 && firstName < 400) {
			first = "H";
		}
		if (firstName >= 400 && firstName < 420) {
			first = "I";
		}
		if (firstName >= 420 && firstName < 500) {
			first = "J";
		}
		if (firstName >= 500 && firstName < 520) {
			first = "K";
		}
		if (firstName >= 520 && firstName < 540) {
			first = "L";
		}
		if (firstName >= 540 && firstName < 620) {
			first = "M";
		}
		if (firstName >= 620 && firstName < 640) {
			first = "N";
		}
		if (firstName >= 640 && firstName < 660) {
			first = "O";
		}
		if (firstName >= 660 && firstName < 700) {
			first = "P";
		}
		if (firstName >= 700 && firstName < 720) {
			first = "Q";
		}
		if (firstName >= 720 && firstName < 780) {
			first = "R";
		}
		if (firstName >= 780 && firstName < 800) {
			first = "S";
		}
		if (firstName >= 800 && firstName < 840) {
			first = "T";
		}
		if (firstName >= 840 && firstName < 860) {
			first = "U";
		}
		if (firstName >= 860 && firstName < 880) {
			first = "V";
		}
		if (firstName >= 880 && firstName < 940) {
			first = "W";
		}
		if (firstName >= 940 && firstName < 960) {
			first = "X";
		}
		if (firstName >= 960 && firstName < 980) {
			first = "Y";
		}
		if (firstName >= 980) {
			first = "Z";
		}
		last = string.substring(0, 1);

		System.out.println("Your initials are first: " + first + " middle: " + middle + " last: " + last.toUpperCase());
	}


}
