package part1.week02.B_Tuesday;

import java.io.*;
import java.util.ArrayList;

public class Main_11286_BOJ {
	public static void main(String[] args) throws Exception {
		Heap h = new Heap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				bw.append(h.delete() + "\n");
			} else
				h.add(input);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Heap {
	private ArrayList<Integer> heap;

	Heap() {
		heap = new ArrayList<>();
		heap.add(Integer.MAX_VALUE);
	}

	public void add(int val) {
		heap.add(val);
		int p = heap.size() - 1;

		int parent = heap.get(p / 2);
		int current = heap.get(p);

		while (p > 1 && Math.abs(parent) > Math.abs(current) && parent > current) {
			heap.set(p / 2, current);
			heap.set(p, parent);
			p /= 2;
			parent = heap.get(p / 2);
			current = heap.get(p);
		}
	}

	public int delete() {
		if (heap.size() - 1 < 1)
			return 0;

		int curDelete = heap.get(1);

		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int p = 1;
		while (p * 2 < heap.size()) {
			int max = heap.get(p * 2);
			int maxPos = p * 2;

			if (p * 2 + 1 < heap.size() && compare(heap.get(p), heap.get(p * 2 + 1)) == 1) {
				max = heap.get(p * 2 + 1);
				maxPos = p * 2 + 1;
			}
			if (compare(heap.get(p), max) == 1) {
				break;
			}
			int tmp = heap.get(p);
			heap.set(p, heap.get(maxPos));
			heap.set(maxPos, tmp);
			p = maxPos;
		}
		return curDelete;
	}

	private int compare(int a, int b) {
		if (Math.abs(a) > Math.abs(b))
			return 1;
		else if (Math.abs(a) < Math.abs(b)) {
			return -1;
		} else {
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			return 0;
		}
	}
}