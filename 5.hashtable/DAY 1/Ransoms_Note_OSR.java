package HashTable;

import java.util.Hashtable;

public class Ransoms_Note_OSR {
	public boolean canConstruct(String ransomNote, String magazine) {

		if(ransomNote.length()>magazine.length()) return false;
		if(ransomNote.isEmpty() && magazine.isEmpty()) return true;
		
		Hashtable<Character, Integer> ht = new Hashtable<>();

		for (char ch : magazine.toCharArray()) {

			if (ht.containsKey(ch))
				ht.put(ch, ht.get(ch) + 1);
			else
				ht.put(ch, 1);

		}

		for (char ch : ransomNote.toCharArray()) {
			
			// �������� ������ ������ false
			if(!ht.containsKey(ch))
				return false;
			// �����Ѵٸ�
			else {
				// value���� 0�̸� false
				if(ht.get(ch) == 0)
					return false;
				// �ƴ϶�� 1--
				else
					ht.put(ch, ht.get(ch) - 1);
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Hashtable<Character, Integer> ht = new Hashtable<>();

	}

}
