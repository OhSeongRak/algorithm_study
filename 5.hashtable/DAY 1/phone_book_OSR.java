package HashTable;

import java.util.Arrays;

public class phone_book_OSR {

	public static boolean solution(String[] phone_book) {

		int len = phone_book.length;

		Arrays.sort(phone_book);

		for (int i = 0; i < len; i++)
			System.out.println(phone_book[i] + " ");

		for (int i = 0; i < len - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i]))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		String[] phone_book = { "12", "123", "1235", "567", "88" };

		System.out.println(solution(phone_book));
	}

}
