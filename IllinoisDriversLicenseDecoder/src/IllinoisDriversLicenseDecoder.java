
public class IllinoisDriversLicenseDecoder {

	public static void main(String[] args) {
		String fullLicenseNumber = "            "; //12 spaces as a placeholder for the number
		//decodes your gender and birthday
		lastThreeDigits(fullLicenseNumber.substring(9));
		//year of birth
		System.out.println(fullLicenseNumber.substring(7, 9));
		//solves for your initials
		initials(fullLicenseNumber.substring(0, 7));
		//last initial
		System.out.println(fullLicenseNumber.charAt(0));
	}

	public static void lastThreeDigits(String string) {
		int num = Integer.parseInt(string);
		if (num >= 601) {
			num -= 600;
			System.out.println("You are a female.");
		} else {
			System.out.println("You are a male.");
		}
		System.out.print("Your birthday is ");
		int day = num % 31;
		num -= day;
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
		//calculating your initials
	}
}
