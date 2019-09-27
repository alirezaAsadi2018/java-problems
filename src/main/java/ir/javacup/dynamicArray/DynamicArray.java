package ir.javacup.dynamicArray;

import java.util.Arrays;

public class DynamicArray {
	private String[] data;
	private int capacity;
	private int pointer;

	public String[] getData() {
		return data;
	}

	public DynamicArray(int initialSize) {
		this.data = new String[initialSize];
		capacity = initialSize;
	}

	public void add(String data) {
		if(pointer == capacity){
			capacity *= 2;
			this.data = Arrays.copyOf(this.data, capacity);
		}
		this.data[pointer++] = data;
	}

	public int delete(int index) {
		if(index < 0 || index >= pointer)
			return -1;
		data[index] = null;
		if (pointer - index > 1) {
			String[] copy = new String[capacity];
			System.arraycopy(data, 0, copy, 0, index);
			System.arraycopy(data, index + 1, copy, index, pointer - index - 1);
			data = copy;
		}
		--pointer;
		if(pointer <= 0.25 * capacity) {
			capacity /= 2;
			data = Arrays.copyOf(data, capacity);
		}
		return 1;
	}

}
