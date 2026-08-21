class MinStack {
    int[] arr;
    int top;
    int min;
    public MinStack() {
        arr = new int[30000];
        top = -1;
    }
    public void push(int val) {
        top++;
        arr[top] = val;
        if (top == 0 || val < min) {
            min = val;
        }
    }
    public void pop() {
        top--;
        min = arr[0];
        for (int i = 1; i <= top; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
    }
    public int top() {
        return arr[top];
    }
    public int getMin() {
        return min;
    }
}