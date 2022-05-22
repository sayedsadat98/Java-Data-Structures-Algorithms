package Stack.UsingArray;
public class StackArr {
    static class Stackcls {
        public int maxSize;
        public int size;
        public int top;
        public int[] stackArray;
        public Stackcls(int limit) {
            maxSize = limit;
            stackArray = new int[limit];
            size = 0;
            top = -1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        public void push(int val) {
            if (!isFull()) {
                stackArray[++top] = val;
                size++;
            } else {
                System.out.println("Stack Overflow!");
            }
        }
        public int pop() {
            return !(top<=-1) ? stackArray[top--] : -1;
        }

        public int peek() {
            return !(top<=-1) ? stackArray[top] : -1;
        }

        public void deleteStack() {
            stackArray = new int[maxSize];
        }

    }

    public static void main(String[] args) {
        Stackcls st = new Stackcls(100);
        System.out.println(st.isEmpty());
        st.push(5);
        st.push(1);
        st.push(2);
        st.push(4);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
