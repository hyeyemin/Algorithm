package com.ssafy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BJ_17471_게리맨더링 {
	static class Node {
	    int x;
	    int peopleNum;
	 
	    Node(int x, int peopleNum) {
	        this.x = x;
	        this.peopleNum = peopleNum;
	    }
	}
    static int N;
    static Node[] number; 
    static ArrayList<ArrayList<Integer>> list;
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
 
        N = Integer.parseInt(br.readLine());
 
        number = new Node[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int peopleNum = Integer.parseInt(st.nextToken());
            number[i] = new Node(i, peopleNum);
        }
 
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list.get(i).add(temp);
            }
        }
 
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            comb(1, N, i, A);
        }
 
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }
 
    public static void comb(int start, int n, int r, ArrayList<Integer> A) {
        if (r == 0) {
            solve(A);
            return;
        }
 
        for (int i = start; i <= n; i++) {
            A.add(i);
            comb(i + 1, n, r - 1, A);
            A.remove(A.size() - 1);
        }
    }
 
    public static void solve(ArrayList<Integer> A) {
        if(!isConnect(number[A.get(0)].x, A, A.size())) {
            return;
        }
 
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (A.contains(i)) {
                continue;
            }
            B.add(i);
        }
        
        if(!isConnect(number[B.get(0)].x, B, B.size())) {
            return;
        }
 
        int resultA = 0;
        for (int i = 0; i < A.size(); i++) {
            resultA += number[A.get(i)].peopleNum;
        }
 
        int resultB = 0;
        for (int i = 0; i < B.size(); i++) {
            resultB += number[B.get(i)].peopleNum;
        }
 
        int result = Math.abs(resultA - resultB);
        ans = Math.min(ans, result);
 
    }
    public static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
        boolean[] visited = new boolean[N + 1];
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
 
        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int i : list.get(start)) {
                if (!visited[i] && arr.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }
        if (count == size) {
            return true;
        }
        return false;
    }
 
}