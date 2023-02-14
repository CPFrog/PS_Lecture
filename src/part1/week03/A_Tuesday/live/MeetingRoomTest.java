package part1.week03.A_Tuesday.live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MeetingRoomTest {
	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		// 종료시간기준 오름차순, 종료시간이 같을 경우 시작시간 기준 오름차순.
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Meeting[] meetings = new Meeting[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());

		for (Meeting meeting : result)
			System.out.println(meeting.start + " " + meeting.end);

	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		List<Meeting> result = new ArrayList<Meeting>();

		Arrays.sort(meetings);
		result.add(meetings[0]);

		for (int i = 1, size = meetings.length; i < size; i++) {
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}
}
