/**
 * 
 */
package com.greatLearning.skyscraper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Question 1 from Graded_Project_2.pdf
 *
 */
public class Building {

	Stack<Integer> stack = new Stack<>();
	Queue<List<Integer>> queue = new LinkedList<>();

	int ht; //Height of Building

	void construction(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (ht == arr[i]) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				int x = arr[i];
				while (!stack.isEmpty() && stack.peek() == --x) { //checking that stack is not empty as well as to make sure only requisite elements are pop
					list.add(stack.pop()); 
				} 
				queue.add(list);
				ht = ht - list.size();

			} else {
				stack.push(arr[i]);
				queue.add(new ArrayList<>());

			}

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building building = new Building();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the height of Building:\n");
		int j = sc.nextInt();
		building.ht = j;
		int a[] = new int[j];

		for (int i = 0; i < j; i++) {
			System.out.println("Enter the floor size given on day :" + (i + 1));
			a[i] = sc.nextInt();
		}

		building.construction(a);
		System.out.println("The order of construction is as follows\n");
		for (int i = 1; i <= j; i++) {
			System.out.println("Day:" + i);
			System.out.println(building.queue.poll());
		}

	}

}
