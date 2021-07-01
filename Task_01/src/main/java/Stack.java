class Stack {
    String[] stackArray;
    int sizeOfStackArray;
    int topIndexOfStackArray = -1;

    Stack(int stackSize) {
        sizeOfStackArray = stackSize;
        stackArray = new String[sizeOfStackArray];

    }

    Boolean push(String data) {
        if (topIndexOfStackArray >= sizeOfStackArray - 1) {
            System.out.print("Stack Overflow By element : " + data + "\n");
            return false;
        } else {
            stackArray[++topIndexOfStackArray] = data;
            return true;
        }
    }

    String pop() {
        if (topIndexOfStackArray < 0) {
            System.out.println("Stack Underflow");
            return "Stack Underflow";
        } else {
            String popData = stackArray[topIndexOfStackArray];
            topIndexOfStackArray--;
            return popData;
        }
    }

    Boolean isAtCapacity() {
        return topIndexOfStackArray < sizeOfStackArray - 1;
    }

    void show() {
        for (int i = 0; i < topIndexOfStackArray; i++) {
            System.out.println(stackArray[i] + " ");
        }
    }

    Boolean isEmpty() {
        return topIndexOfStackArray < 0;
    }

    int size() {
        return topIndexOfStackArray + 1;
    }

}
