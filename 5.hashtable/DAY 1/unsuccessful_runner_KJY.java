import java.util.Hashtable;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Hashtable<String, Integer> hashtableParticipant = new Hashtable<String, Integer>();

		for (int participantIndex = 0; participantIndex < participant.length; participantIndex++) {
			if (hashtableParticipant.containsKey(participant[participantIndex])) {
				int tmp = hashtableParticipant.get(participant[participantIndex]);
				tmp++;
				hashtableParticipant.put(participant[participantIndex], tmp);
			} else
				hashtableParticipant.put(participant[participantIndex], 1);
		}

		for (int cIdx = 0; cIdx < completion.length; cIdx++) {

			int tmp = hashtableParticipant.get(completion[cIdx]);
			if (tmp == 1)
				hashtableParticipant.remove(completion[cIdx]);
			else {
				tmp--;
				hashtableParticipant.put(completion[cIdx], tmp);
			}

		}
		for(String key:hashtableParticipant.keySet()) {
			answer=key;
		}

		return answer;
	}
}
