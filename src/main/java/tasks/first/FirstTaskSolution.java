package tasks.first;

import java.util.ArrayDeque;


public class FirstTaskSolution implements FirstTask {
    public boolean chek(char x) {
        return x != '+' && x != '-' && x != '*' && x != '/';
    }

    public Integer compute(int a, int b, char d) {
        switch (d) {
            case '-':
                return b - a;
            case '+':
                return a + b;
            case '/':
                return b / a;
            case '*':
                return a * b;
        }
        return null;
    }

    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        return null;
    }

    @Override
    public Boolean validateBrackets(String s) {
        if (s.isEmpty()) return true;
        ArrayDeque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                characters.addFirst(s.charAt(i));
                continue;
            }


            if (s.charAt(i) == ')' && characters.peekFirst() == '(') characters.pollFirst();
            if (s.charAt(i) == ']' && characters.peekFirst() == '[') characters.pollFirst();
            if (s.charAt(i) == '}' && characters.peekFirst() == '{') characters.pollFirst();
        }
        return characters.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String dig = "";
        int i = 0;
        while (chek(s.charAt(i))) {
            if (s.charAt(i) != ' ') {
                dig += s.charAt(i);
            } else {
                deque.addLast(Integer.parseInt(dig));
                dig = "";
            }
            i++;
        }
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) != ' ') {
                if (deque.size() >= 2) {
                    int a = deque.pollLast();
                    int b = deque.pollLast();
                    deque.addLast(compute(a, b, s.charAt(j)));
                } else throw new IndexOutOfBoundsException();
            }
        }
        if (deque.size() > 1) throw new IllegalArgumentException();
        else return Long.valueOf(deque.pollLast());
    }
}
