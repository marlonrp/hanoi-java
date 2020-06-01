package hanoi;

import stack.StackLinkedListImpl;

import java.util.Scanner;

public class Hanoi {

    private int size;
    private StackLinkedListImpl<Integer> leftStack;
    private StackLinkedListImpl<Integer> middleStack;
    private StackLinkedListImpl<Integer> rightStack;
    Scanner sc = new Scanner(System.in);

    public Hanoi() {
        this.size = 5;
        this.leftStack = new StackLinkedListImpl<Integer>();
        this.middleStack = new StackLinkedListImpl<Integer>();
        this.rightStack = new StackLinkedListImpl<Integer>();

        createHanoi(size);
        play();
    }

    private void createHanoi(Integer size) {
        for (int i = size; i > 0; i--) {
            leftStack.push(i);
        }

    }

    private void play() {
        do {
            menu();
        } while (!checkCompletion());
        showTowers();
        System.out.println("Parabéns você conseguiu!");
    }

    private void menu() {
        showTowers();
        System.out.println("Escolha a origem e destino para mover as pedras (1,2,3), Sem que sejam iguais!");
        int origin;
        int destiny;
        do {
            System.out.println("Origem: ");
            origin = this.sc.nextInt();
            if (isValideRange(origin)) {
            	System.out.println("Valor inválido, tente novamente");
            }
        } while (isValideRange(origin));

        do {
            System.out.println("Destino: ");
            destiny = this.sc.nextInt();
            if (isValideRange(destiny)) {
            	System.out.println("Valor inválido, tente novamente");
            }
        } while (isValideRange(destiny));
        move(TowersEnum.getTowerByCode(origin), TowersEnum.getTowerByCode(destiny));
    }
    
    private boolean isValideRange(Integer value) {
    	return value < 1 || value > 3;
    }

    private void move(TowersEnum origin, TowersEnum destiny) {
        StackLinkedListImpl<Integer> originStack = null;
        StackLinkedListImpl<Integer> destinyStack = null;
        if (origin.getValue() == TowersEnum.LEFTSTACk.getValue()) {
            originStack = leftStack;
        } else if (origin.getValue() == TowersEnum.MIDDLESTACK.getValue()) {
            originStack = middleStack;
        } else if (origin.getValue() == TowersEnum.RIGHTSTACK.getValue()) {
            originStack = rightStack;
        }

        if (destiny.getValue() == TowersEnum.LEFTSTACk.getValue()) {
            destinyStack = leftStack;
        } else if (destiny.getValue() == TowersEnum.MIDDLESTACK.getValue()) {
            destinyStack = middleStack;
        } else if (destiny.getValue() == TowersEnum.RIGHTSTACK.getValue()) {
            destinyStack = rightStack;
        }

        if (!originStack.isEmpty()) {
            if (destinyStack.isEmpty() || (int) originStack.top() < (int) destinyStack.top()) {
                destinyStack.push((int)originStack.pop());
            } else {
                System.out.println("erro o disco que esta tentando mover é maior que o que ja tem na pilha destino!");
                menu();
            }
        } else {
            System.out.println("erro de pilha vazia! selecione novamente");
            menu();
        }
    }

    private boolean checkCompletion() {
    	return this.rightStack.topIndex == 5 && this.rightStack.get(0) == 1 && this.rightStack.get(4) == 5;
    }

    private void showTowers() {
        StringBuilder towers = new StringBuilder();
        for (int i = 0; i < 5; i++) {
                towers.append(leftStack.get(i) == null ? "-" : (int)leftStack.get(i)).append("|");
                towers.append(middleStack.get(i) == null ? "-" : (int)middleStack.get(i)).append("|");
                towers.append(rightStack.get(i) == null ? "-" : (int)rightStack.get(i)).append("|");
                towers.append("\n");
        }
        System.out.println(towers);
        System.out.println("==============================================================================");
    }
}

