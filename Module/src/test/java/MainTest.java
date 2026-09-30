import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    //TESTS FOR ARRAY STACK
    AStack as0 = new AStack(new String[0]);
    AStack as1 = new AStack(new String[]{"abc", "def", "csc"});
    AStack as2 = new AStack(new String[]{"abc", "def", "csc"}, 10);
    AStack as3 = new AStack(new String[]{"abc", "def", "csc", "hello"}, 10);
    AStack as4 = new AStack(new String[]{"abc", "def"}, 3);

    @Test
    void empty_stack() {
        assertEquals(true, as0.equals(AStack.aempty_stack()));
        assertEquals(false, as1.equals(AStack.aempty_stack()));
    }

    @Test
    void push() {
        as2.apush("hello");
        assertEquals(true, as2.equals(as3));
        as1.apush("hello");
        assertEquals(false, as1.equals(as3));
        as2.apush("ruin");
        assertEquals(false, as2.equals(as3));
    }

    @Test
    void pop() {
        assertEquals("csc", as1.apop());
        assertEquals(true, as1.equals(as4));
        assertEquals("hello", as3.apop());
        assertEquals(true, as2.equals(as3));
        assertThrows(NoSuchElementException.class, () -> {
            as0.apop();
        });
    }

    @Test
    void peep() {
        assertEquals("csc", as1.apeep());
        assertEquals("hello", as3.apeep());
        assertThrows(NoSuchElementException.class, () -> {
            as0.apeep();
        });
    }

    @Test
    void size() {
        assertEquals(3, as1.asize());
        assertEquals(3, as2.asize());
        assertEquals(0, as0.asize());
    }

    @Test
    void is_empty() {
        assertEquals(true, as0.ais_empty());
        assertEquals(false, as1.ais_empty());
    }

    //TESTS FOR LINKED LIST STACK
    LLStack lstack0 = new LLStack(null);
    LLStack lstack1 = new LLStack(new Pair("abc", new Pair("def", null)));
    LLStack lstack2 = new LLStack(new Pair("hello", new Pair("abc", new Pair("def", null))));
    LLStack lstack3 = new LLStack(new Pair("def", null));

    @Test
    void llempty_stack() {
        assertEquals(true, lstack0.equals(LLStack.llempty_stack()));
        assertEquals(false, lstack1.equals(LLStack.llempty_stack()));
    }

    @Test
    void llpush() {
        lstack1.llpush("hello");
        assertEquals(true, lstack1.equals(lstack2));
        lstack1.llpush("ruin");
        assertEquals(false, lstack1.equals(lstack2));
    }

    @Test
    void llpop() {
        assertEquals("abc", lstack1.llpop());
        assertEquals(true, lstack1.equals(lstack3));
        assertEquals("def", lstack3.llpop());
        assertEquals(true, lstack0.equals(lstack3));
        assertThrows(NoSuchElementException.class, () -> {
            lstack0.llpop();
        });
    }

    @Test
    void llpeep() {
        assertEquals("abc", lstack1.llpeep());
        assertEquals("def", lstack3.llpeep());
        assertThrows(NoSuchElementException.class, () -> {
            lstack0.llpeep();
        });
    }

    @Test
    void llsize() {
        assertEquals(2, lstack1.llsize());
        assertEquals(3, lstack2.llsize());
        assertEquals(0, lstack0.llsize());
    }

    @Test
    void llis_empty() {
        assertEquals(true, lstack0.llis_empty());
        assertEquals(false, lstack1.llis_empty());
    }

    //1.1 MEASUREMENT TIMING
    static int findMaxNAStack(int t) {
        int n = 1;
        long duration = 0;
        while (duration < t) {
            AStack a = AStack.aempty_stack();
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                a.apush("x");
            }
            for (int i = 0; i < n; i++) {
                a.apop();
            }
            long endTime = System.nanoTime();
            duration = ((endTime - startTime) / 1000000);
            n = n * 2;
        }
        return n / 4; //n was doubled after failing, so the previous n before failing is a fourth the size
    }

    static int findMaxNLLStack(int t) {
        int n = 1;
        long duration = 0;
        while (duration < t) {
            LLStack a = LLStack.llempty_stack();
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                a.llpush("x");
            }
            for (int i = 0; i < n; i++) {
                a.llpop();
            }
            long endTime = System.nanoTime();
            duration = ((endTime - startTime) / 1000000);
            n = n * 2;
        }
        return n / 4; //n was doubled after failing, so the previous n before failing is a fourth the size
    }
    //Testing Timing
    public static void main(String[] args) {
        for(int t = 100; t <= 1000; t += 100){
            IO.println("t= "+t+" ms. AStack handled: "+findMaxNAStack(t)+" \nLLStack handled: "+findMaxNLLStack(t));
        }
    }
}