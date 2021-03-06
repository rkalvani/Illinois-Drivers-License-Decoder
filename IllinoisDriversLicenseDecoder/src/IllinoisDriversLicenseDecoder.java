import java.util.Scanner;

public class IllinoisDriversLicenseDecoder {

	public static void main(String[] args) {
		System.out.println("Do you have a driver's license from the state of Illinois?");
		System.out.println("If so please select 1 to let us guess your birthday, gender and initials.");
		System.out.println("If not select 2 to generate your own driver's license number.");
		System.out.println("Enter 1 or 2.");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		if (answer.equals("1")) {
			decode();
		} else if (answer.equals("2")) {
			encode();
		}
	}

	public static void encode() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name.");
		String firstName = scanner.nextLine();
		System.out.println("Please enter your middle name.");
		System.out.println("If you do not have a middle name, just press the spacebar and then hit enter.");
		String middleName = scanner.nextLine();
		System.out.println("Please enter your last name.");
		String lastName = scanner.nextLine();
		System.out.println("Please enter your birthday in this format MM/DD/YY");
		String birthday = scanner.nextLine();
		System.out.println("What is your gender?");
		System.out.println("Enter 1 for female or 2 for male.");
		String gender = scanner.nextLine();
		System.out.print("If you recieved a driver's license from the state of Illinois your license number would be: ");
		System.out.println(firstHalf(firstName, middleName, lastName) + secondHalf(birthday, gender));
	}

	public static String firstHalf(String firstName, String middleName, String lastName) {
		// changed all names to uppercase to make comparing easier
		firstName = firstName.toUpperCase();
		middleName = middleName.toUpperCase();
		lastName = lastName.toUpperCase();

		// variables to return at the end
		String soundex = "";
		String fff = "";

		// finding out the soundex code for the last name which is the first four
		// numbers of license
		for (int i = 1; i < lastName.length(); i++) {
			if ("BFPV".contains(lastName.substring(i, i + 1))) {
				soundex += "1";
			} else if ("CGJKQSXZ".contains(lastName.substring(i, i + 1))) {
				soundex += "2";
			} else if ("DT".contains(lastName.substring(i, i + 1))) {
				soundex += "3";
			} else if ("L".contains(lastName.substring(i, i + 1))) {
				soundex += "4";
			} else if ("MN".contains(lastName.substring(i, i + 1))) {
				soundex += "5";
			} else if ("R".contains(lastName.substring(i, i + 1))) {
				soundex += "6";
			} else if ("AEHIOUWY".contains(lastName.substring(i, i + 1))) {
				soundex += "";
			}
		}

		// making sure their last name has enough soundex code numbers
		if (soundex.length() > 2) {
			soundex = soundex.substring(0, 3);
		} else if (soundex.length() == 0) {
			soundex = "000";
		} else if (soundex.length() == 1) {
			soundex = soundex + "00";
		} else if (soundex.length() == 2) {
			soundex = soundex + "0";
		}

		// checking pre made firstnames
		int first = 0;
		if (firstName.equals("ALBERT") || firstName.equals("ALICE")) {
			first = 20;
		} else if (firstName.equals("ANN") || firstName.equals("ANNA") || firstName.equals("ANNE") || firstName.equals("ARTHUR") || firstName.equals("ANNIE")) {
			first = 40;
		} else if (firstName.equals("BERNARD") || firstName.equals("BETTE") || firstName.equals("BETTIE") || firstName.equals("BETTY")) {
			first = 80;
		} else if (firstName.equals("CARL") || firstName.equals("CATHERINE")) {
			first = 120;
		} else if (firstName.equals("CHARLES") || firstName.equals("CLARA")) {
			first = 140;
		} else if (firstName.equals("DORTHY") || firstName.equals("DONALD")) {
			first = 180;
		} else if (firstName.equals("EDWARD") || firstName.equals("ELIZABETH")) {
			first = 220;
		} else if (firstName.equals("FLORENCE") || firstName.equals("FRANK")) {
			first = 260;
		} else if (firstName.equals("GEORGE") || firstName.equals("GRACE")) {
			first = 300;
		} else if (firstName.equals("HAROLD") || firstName.equals("HARRIET")) {
			first = 340;
		} else if (firstName.equals("HARRY") || firstName.equals("HAZEL")) {
			first = 360;
		} else if (firstName.equals("HELEN") || firstName.equals("HENRY")) {
			first = 380;
		} else if (firstName.equals("JAMES") || firstName.equals("JANE") || firstName.equals("JAYNE")) {
			first = 440;
		} else if (firstName.equals("JEAN") || firstName.equals("JOHN")) {
			first = 460;
		} else if (firstName.equals("JOAN") || firstName.equals("JOSEPH")) {
			first = 480;
		} else if (firstName.equals("MARGARET") || firstName.equals("MARTIN")) {
			first = 560;
		} else if (firstName.equals("MARVIN") || firstName.equals("MARY")) {
			first = 580;
		} else if (firstName.equals("MELVIN") || firstName.equals("MILDRED")) {
			first = 600;
		} else if (firstName.equals("PATRICIA") || firstName.equals("PAUL")) {
			first = 680;
		} else if (firstName.equals("RICHARD") || firstName.equals("RUBY")) {
			first = 740;
		} else if (firstName.equals("ROBERT") || firstName.equals("RUTH")) {
			first = 760;
		} else if (firstName.equals("THELMA") || firstName.equals("THOMAS")) {
			first = 820;
		} else if (firstName.equals("WALTER") || firstName.equals("WANDA")) {
			first = 900;
		} else if (firstName.equals("WILLIAM") || firstName.equals("WILMA")) {
			first = 930;
		} 

		// check first letter of first name
		if (firstName.charAt(0) == 'A') {
			first = 0;
		} else if (firstName.charAt(0) == 'B') {
			first = 60;
		} else if (firstName.charAt(0) == 'C') {
			first = 100;
		} else if (firstName.charAt(0) == 'D') {
			first = 160;
		} else if (firstName.charAt(0) == 'E') {
			first = 200;
		} else if (firstName.charAt(0) == 'F') {
			first = 240;
		} else if (firstName.charAt(0) == 'G') {
			first = 280;
		} else if (firstName.charAt(0) == 'H') {
			first = 320;
		} else if (firstName.charAt(0) == 'I') {
			first = 400;
		} else if (firstName.charAt(0) == 'J') {
			first = 420;
		} else if (firstName.charAt(0) == 'K') {
			first = 500;
		} else if (firstName.charAt(0) == 'L') {
			first = 520;
		} else if (firstName.charAt(0) == 'M') {
			first = 540;
		} else if (firstName.charAt(0) == 'N') {
			first = 620;
		} else if (firstName.charAt(0) == 'O') {
			first = 640;
		} else if (firstName.charAt(0) == 'P') {
			first = 660;
		} else if (firstName.charAt(0) == 'Q') {
			first = 700;
		} else if (firstName.charAt(0) == 'R') {
			first = 720;
		} else if (firstName.charAt(0) == 'S') {
			first = 780;
		} else if (firstName.charAt(0) == 'T') {
			first = 800;
		} else if (firstName.charAt(0) == 'U') {
			first = 840;
		} else if (firstName.charAt(0) == 'V') {
			first = 860;
		} else if (firstName.charAt(0) == 'W') {
			first = 880;
		} else if (firstName.charAt(0) == 'X') {
			first = 940;
		} else if (firstName.charAt(0) == 'Y') {
			first = 960;
		} else if (firstName.charAt(0) == 'Z') {
			first = 980;
		}

		// checking first initial of middle name
		int middle = 0;
		String compareM = middleName.substring(0, 1).toUpperCase();
		if (compareM.equals("A")) {
			middle = 1;
		} else if(compareM.equals(" ")){
			middle = 0;
		} else if (compareM.equals("B")) {
			middle = 2;
		} else if (compareM.equals("C")) {
			middle = 3;
		} else if (compareM.equals("D")) {
			middle = 4;
		} else if (compareM.equals("E")) {
			middle = 5;
		} else if (compareM.equals("F")) {
			middle = 6;
		} else if (compareM.equals("G")) {
			middle = 7;
		} else if (compareM.equals("H")) {
			middle = 8;
		} else if (compareM.equals("I")) {
			middle = 9;
		} else if (compareM.equals("J")) {
			middle = 10;
		} else if (compareM.equals("K")) {
			middle = 11;
		} else if (compareM.equals("L")) {
			middle = 12;
		} else if (compareM.equals("M")) {
			middle = 13;
		} else if (compareM.equals("N")) {
			middle = 14;
		} else if (compareM.equals("O")) {
			middle = 14;
		} else if (compareM.equals("P")) {
			middle = 15;
		} else if (compareM.equals("Q")) {
			middle = 15;
		} else if (compareM.equals("R")) {
			middle = 16;
		} else if (compareM.equals("S")) {
			middle = 17;
		} else if (compareM.equals("T")) {
			middle = 18;
		} else if (compareM.equals("U")) {
			middle = 18;
		} else if (compareM.equals("V")) {
			middle = 18;
		} else if (compareM.equals("W")) {
			middle = 19;
		} else if (compareM.equals("X")) {
			middle = 19;
		} else if (compareM.equals("Y")) {
			middle = 19;
		} else if (compareM.equals("Z")) {
			middle = 19;
		}
		int fm = first + middle;
		fff = Integer.toString(fm);

		return lastName.substring(0, 1).toUpperCase() + soundex + "-" + fff;
	}

	public static String secondHalf(String birthdayString, String genderString) {
		// (MM-1)*31+DD +(600 if female, 0 if male)
		boolean isGirl = false;
		String possibleZeros = "";
		if (genderString.equals("1")) {
			isGirl = true;
		}
		int month = Integer.parseInt(birthdayString.substring(0, 2));
		int day = Integer.parseInt(birthdayString.substring(3, 5));
		int lastThreeDigits = ((month - 1) * 31) + day;
		if (isGirl) {
			lastThreeDigits += 600;
		}
		if (lastThreeDigits < 100) {
			possibleZeros = "0";
		} 
		if (lastThreeDigits < 10) {
			possibleZeros = "00";
		}
		return birthdayString.charAt(birthdayString.length() - 2) + "-" + birthdayString.charAt(birthdayString.length() - 1) + possibleZeros + lastThreeDigits;
	}

	public static void decode() {
		System.out.println("Please enter your Illinois State Driver's License number without any dashes or spaces");
		Scanner licenseNumber = new Scanner(System.in);
		String fullStringNumber = licenseNumber.nextLine();
		//Decodes your gender and birthday
		lastThreeDigits(fullStringNumber.substring(9));
		//Year of birth
		System.out.println(fullStringNumber.substring(7, 9));
		//Solves for your initials
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
