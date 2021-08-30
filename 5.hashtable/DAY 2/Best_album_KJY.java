import java.util.Hashtable;

class Solution {
     public static int[] solution(String[] genres, int[] plays) {
        
        int[] result = new int[plays.length];
        int resultIndex = 0;
        
        Hashtable<String,Integer> g_sumP_ht = new Hashtable<>();
        
        // Sum of plays by genre
        for ( int index = 0; index<genres.length;index++) {
        	g_sumP_ht.put(genres[index],g_sumP_ht.getOrDefault(genres[index],0)+plays[index]);
        }
        
        while(!g_sumP_ht.isEmpty()) {
	        // Find the genre with the largest number of plays
	        int sumPlaysMax = 0;
	        String sumPlaysMaxGenres="";
	        for(String key :g_sumP_ht.keySet()) {
	        	if(g_sumP_ht.get(key) > sumPlaysMax) {
	        		sumPlaysMaxGenres=key;
	        		sumPlaysMax=g_sumP_ht.get(key);
	        	}
	        }
	        g_sumP_ht.remove(sumPlaysMaxGenres);
	        
	        // Make Hash table of index for the same genre
	        Hashtable<Integer,Integer> idx_play_ht = new Hashtable<>();
	        for(int index =0  ; index<genres.length;index++) {
	        	if(genres[index].equals(sumPlaysMaxGenres)) {
	        		idx_play_ht.put(index,plays[index]);
	        	}
	        }
	        
	        for(int count = 0 ; count < 2 ; count++) {
	        	if(idx_play_ht.isEmpty())
	        		break;
	        	
	        	int playMax = 0;
	        	int playMaxIndex=0;
	        	for(Integer key:idx_play_ht.keySet()) {
	        		if( idx_play_ht.get(key) > playMax) {
	        			playMax=idx_play_ht.get(key);
	        			playMaxIndex=key;
	        		}
	        		else if ( idx_play_ht.get(key).intValue() == playMax && key<playMaxIndex) {
	        			playMaxIndex=key;
	        		}
	        		else {
	        			continue;
	        		}
	        	}
	        	result[resultIndex]=playMaxIndex;
	        	resultIndex++;
	        	idx_play_ht.remove(playMaxIndex);
	        }
	        
        }
        
        int[] answer = new int[resultIndex];
        for(int rIndex = 0 ; rIndex< resultIndex ;rIndex++) {
        	answer[rIndex]=result[rIndex];
        }
        
        return answer;
    }
}
