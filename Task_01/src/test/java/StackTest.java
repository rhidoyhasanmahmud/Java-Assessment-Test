import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    /*
     *   Test case number: 1
     *   Test case values: push A,B,C,D,E and pop twice
     *   Expected output (Post-state): value at the top is C
     */
    @Test
    public void test1() {
        Stack stack = new Stack(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.pop();
        stack.pop();
        assertEquals("C", stack.pop());
    }

    /*
     *   Test case number: 2
     *   Test case values: push A,B,C,D,E . So length is 5
     *   Expected output (Post-state): stack is full. So test the capacity
     */
    @Test
    public void test2() {
        Stack st = new Stack(5);
        assertEquals(false, st.isAtCapacity());
    }

    /*
     *   Test case number: 3
     *   Test case values: push A,B,C,D,E,F and pop twice
     *   Expected output (Post-state): stack is not empty
     */
    @Test
    public void test3() {
        Stack st = new Stack(6);
        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");
        st.push("F");
        st.pop();
        st.pop();
        assertEquals(false, st.isEmpty());
    }

    /*
     *   Test case number: 4
     *   Test case values: push A,B,C,D,E,F
     *   Expected output (Post-state): stack is full. So get Stack Overflow By element : F
     */
    @Test
    public void test6() {
        Stack st = new Stack(6);
        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");
        st.push("F");
        assertEquals(false, st.push("F"));
    }

    /*
     *   Test case number: 5
     *   Test case values: push A,B
     *   Expected output (Post-state): stack is not full
     */
    @Test
    public void test7() {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        assertEquals(true, st.push("C"));
    }

    /*
     *   Test case number: 6
     *   Test case values: push A,B,C,D,E and pop five times
     *   Expected output (Post-state): stack is empty
     */
    @Test
    public void test8() {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        assertEquals(true, st.isEmpty());
    }

    /*
     *   Test case number: 7
     *   Test case values: call isEmpty three times
     *   Expected output (Post-state): the stack is not full or empty
     */
    @Test
    public void test11() {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        assertEquals(false, st.isEmpty());
        assertEquals(false, st.isEmpty());
        assertEquals(false, st.isEmpty());
        assertEquals(true, st.isAtCapacity());
    }

    /*
     *   Test case number: 8
     *   Test case values: call isAtCapacity three times
     *   Expected output (Post-state): the stack is not full or empty
     */
    @Test
    public void test12 ()
    {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        assertEquals(true, st.isAtCapacity());
        assertEquals(true, st.isAtCapacity());
        assertEquals(true, st.isAtCapacity());
        assertEquals(false, st.isEmpty());
        assertEquals(2, st.size());
    }

    /*
     *   Test case number: 9
     *   Test case values: call isAtCapacity three times
     *   Expected output (Post-state): the stack is not full or empty
     */
    @Test
    public void test13 ()
    {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        assertEquals(false, st.isAtCapacity());
        assertEquals(false, st.isAtCapacity());
        assertEquals(false, st.isAtCapacity());
        assertEquals(true, st.push("C"));
    }

    /*
     *   Test case number: 10
     *   Test case values: push A,B,C,D,E,F to the stack
     *   Expected output (Post-state): call isAtCapacity return true, stack is full
     */
    @Test
    public void test14 ()
    {
        Stack st = new Stack(5);
        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");
        assertEquals(true, st.isAtCapacity());
        assertEquals(true, st.isAtCapacity());
        assertEquals(true, st.isAtCapacity());
    }

}
