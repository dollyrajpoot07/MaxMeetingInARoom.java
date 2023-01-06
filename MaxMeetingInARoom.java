// There is one meeting room in a firm. There are N meetings 
// in the form of (S[i], F[i]) where S[i] is the start time of 
// meeting i and F[i] is the finish time of meeting i. The task 
// is to find the maximum number of meetings that can be accommodated 
// in the meeting room. Print all meeting numbers
// Input: s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9} 
// Output: 1 2 4 5
// First meeting [1, 2] 
// Second meeting [3, 4] 
// Fourth meeting [5, 7] 
// Fifth meeting [8, 9]

import java.util.*;

class mycomparator implements Comparator<meeting> {
	@Override public int compare(meeting o1, meeting o2) {
		if (o1.end < o2.end) {
			return -1;
		}
		else if (o1.end > o2.end)
			return 1;

		return 0;
	}
}

class meeting {
	int start;
	int end;
	int pos;

	meeting(int start, int end, int pos)
	{
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class MaxMeetingInARoom {
	public static void maxMeeting(ArrayList<meeting> al, int s) {
		ArrayList<Integer> m = new ArrayList<>();

		int time_limit = 0;

		mycomparator mc = new mycomparator();
		Collections.sort(al, mc);
		m.add(al.get(0).pos);
		time_limit = al.get(0).end;
		for (int i = 1; i < al.size(); i++) {
			if (al.get(i).start > time_limit) {
				m.add(al.get(i).pos);
				time_limit = al.get(i).end;
			}
		}
		for (int i = 0; i < m.size(); i++)
			System.out.print(m.get(i) + 1 + " ");
	}
	public static void main(String[] args) {
		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };
		ArrayList<meeting> meet = new ArrayList<>();
		for (int i = 0; i < s.length; i++)
			meet.add(new meeting(s[i], f[i], i));
		maxMeeting(meet, meet.size());
	}
}

