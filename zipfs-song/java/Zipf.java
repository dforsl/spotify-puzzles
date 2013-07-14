import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Zipf {
	
	public static class Song implements Comparable<Song> {
		public final int index;
		public final String name;
		public final long quality;
		
		public Song(int index, long frequency, String name) {
			this.index = index;
			this.name = name;
			this.quality = 	frequency * (index+1);
		}

		@Override
		public int compareTo(Song arg0) {
			long dQ = arg0.quality - quality;
			
			/*
			 * Compare by index if the quality is the same.
			 */
			if(dQ == 0)
				dQ = index - arg0.index;
			
			return (int) Math.signum(dQ);
		}
	}

	public static String[] splitLine(String text) {
		return text.split("\\s");
	}
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {			
			/*
			 * Initialize the reader. 
			 */
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			int n = 0, m = 0; //Total number of songs and output number.
			Song s; //Song currently parsed
			String[] array;
			
			/*
			 * Read the number of songs following, and the requested number if songs in the output.
			 */
			String[] header = splitLine(reader.readLine());
			n = Integer.parseInt(header[0]);
			m = Integer.parseInt(header[1]);
			
			/*
			 * Declare and initialize the queue.
			 */
			PriorityQueue<Song> queue = new PriorityQueue<Song>(m);
			
			/*
			 * Read the songs and immediately "objectify" each song and put it in the priority queue.
			 */
			for(int i = 0; i < n; i++) {
				array = splitLine(reader.readLine());
				s = new Song(i, Long.parseLong(array[0]), array[1]);
				
				queue.offer(s);
			}
			
			reader.close();
		
			/*
			 * Build the results.
			 */
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < m; i++) {
				s = queue.poll();
				sb.append(s.name).append('\n');
			}
			
			/*
			 * Finally print.
			 */
			System.out.print(sb.toString());
			
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
