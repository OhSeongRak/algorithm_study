package HashTable;

import java.util.Collection;
import java.util.Hashtable;

public class Camouflage_OSR {

	public static int solution(String[][] clothes) {

		Hashtable<String, Integer> cTable = new Hashtable<>();
		int N = 1;

		for (int i = 0; i < clothes.length; i++)
			cTable.put(clothes[i][1], cTable.getOrDefault(clothes[i][1], 0) + 1);

		Collection<Integer> tableValues = cTable.values();

		for (Integer i : tableValues)
			N *= i + 1;

		return N - 1;
	}

	public static void main(String[] args) {

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));
	}

}
