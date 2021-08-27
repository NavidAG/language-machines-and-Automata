import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        State q0 = new State("q0", true, false);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);

        Stack<String> stack = new Stack<>();
        stack.push("z");
        State currentState = q0;
//        String[] transitions;

        String grammar = "S->aA,A->aABC|bB|a,B->b,C->c";
        String grammar2 = "S->aABCD,A->bBCD,B->cD,D->a";

        ArrayList<String> unifiedGrammars;
        unifiedGrammars = grammarSeparator(grammar);
        System.out.println(unifiedGrammars);


        ArrayList<PDA> pdaArrayList = conversion(unifiedGrammars, stack, currentState);
//        System.out.println(stack.pop());
        String language = "aabc";
        isContextFree(pdaArrayList, language, stack);





    }

    public static ArrayList<String> grammarSeparator(String grammar){
        System.out.println("The actual grammar: " + grammar);
        System.out.println();
        String[] tokens = grammar.split(Pattern.quote(","));
        ArrayList<String> unifiedGrammars = new ArrayList<String>();
        for(int i=0; i<tokens.length; i++){
//            System.out.println(tokens[i]);
            String[] partition = tokens[i].split(Pattern.quote("->"));
            String[] statements = partition[1].split(Pattern.quote("|"));
            for(int j=0; j<statements.length; j++){
                String temp = partition[0]+"->"+statements[j];
                unifiedGrammars.add(temp);
            }
        }
        return unifiedGrammars;
    }

    public static ArrayList<PDA> conversion(ArrayList<String> unifiedGrammars, Stack<String> stack, State state){
        ArrayList<PDA> pdaList = new ArrayList<PDA>();
        State nextState = new State("q1", false, false);
        PDA pda;
        if(stack.peek().equals("z") && state.name.equals("q0")){

            pda = new PDA(state.name, nextState.name, "λ", stack.pop(), "Sz");
            stack.push("z");
            stack.push("S");
            pdaList.add(pda);


        }
        for(int j=0; j<unifiedGrammars.size(); j++){
//            System.out.println(Arrays.toString(stack.toArray()));
//            System.out.println(unifiedGrammars.get(j).substring(4));

            if(unifiedGrammars.get(j).substring(4).isEmpty()){

                pda = new PDA(nextState.name, nextState.name, unifiedGrammars.get(j).substring(3, 4), unifiedGrammars.get(j).substring(0, 1), "λ");

            } else {
                pda = new PDA(nextState.name, nextState.name, unifiedGrammars.get(j).substring(3, 4), unifiedGrammars.get(j).substring(0, 1), unifiedGrammars.get(j).substring(4));

                for(int i=0; i<unifiedGrammars.get(j).substring(4).length(); i++){
//                    System.out.print(unifiedGrammars.get(j).substring(unifiedGrammars.get(j).length() - 1 - i, unifiedGrammars.get(j).length() - i));
                    stack.push(unifiedGrammars.get(j).substring(unifiedGrammars.get(j).length() - 1 - i, unifiedGrammars.get(j).length() - i));
//                    System.out.println(Arrays.toString(stack.toArray()));
                }
//                System.out.println('\n');
            }

            pdaList.add(pda);
        }
        State finalState = new State("q2", false, true);
        pda = new PDA(nextState.name, finalState.name, "λ", stack.peek(), "z");
        pdaList.add(pda);


        for(int i=0; i<pdaList.size(); i++){
            System.out.println(pdaList.get(i).getFunction());
        }
        return pdaList;
//        String[] partition = new String[10];
//        for(int i=0; i<tokens.length; i++){
////            System.out.println(tokens[i]);
//            partition = tokens[i].split(Pattern.quote("->"));
//            //partition[0]: left hand side
//            //partition[1]: right hand side
//        }
//        System.out.println(partition);

    }
    public static void isContextFree(ArrayList<PDA> pdaArrayList, String language, Stack<String> stack){
        System.out.println();
        ArrayList<PDA> similarSituations = new ArrayList<PDA>();
        stack.clear();
//        State q0 = new State("q0", true, false);
//        State q1 = new State("q1", false, false);
//        State q2 = new State("q2", false, false);
        stack.push("z");
        stack.push("S");

//        System.out.println(pdaArrayList.get(0).getFunction().substring(7,8));
        int step = 0;
        for(int j=0; j<language.length(); j++) {
            boolean flag = false;
            System.out.println("j: " + j);
            step++;
            for(int i=0; i<pdaArrayList.size(); i++){
               if(
                       pdaArrayList.get(i).getFunction().substring(7,8).equals(stack.peek())
                       &&
                       pdaArrayList.get(i).getFunction().substring(5,6).equals(language.substring(j, j+1)))
               {
                   similarSituations.add(pdaArrayList.get(i));
                   flag = true;
               }

            }
//            if(similarSituations.isEmpty()){
//                flag = false;
//                break;
//            }
            System.out.println(language.substring(j, j+1));
            for(int i=0; i<similarSituations.size(); i++){
                System.out.println(similarSituations.get(i).getFunction());
                backTracking(similarSituations.get(i), stack, language.substring(j, j+1));
                System.out.println(Arrays.toString(stack.toArray()));
            }
            if(stack.peek().equals("z") && step == language.length() && flag){
                System.out.println("This language belongs to a PDA.");
            }

            similarSituations.clear();
        }
//        if(iterator == language.length()){
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
    }
    public static void backTracking(PDA pda, Stack<String> stack, String currentCharacter){
        stack.pop();
//        System.out.println(pda.getFunction().substring(17, pda.getFunction().length() - 2));
        if(!pda.getFunction().substring(17, pda.getFunction().length() - 2).equals("λ")){
            for(int i=pda.getFunction().substring(17, pda.getFunction().length() - 2).length(); i>0; i--){
                System.out.println(pda.getFunction().substring(17, pda.getFunction().length() - 2).substring(i-1,i));
                stack.push(pda.getFunction().substring(17, pda.getFunction().length() - 2).substring(i-1,i));
            }
        }

    }
    public static boolean check(int size, int step, String language){
        if(size != 1 || step != language.length()){
            return false;
        }
        return true;
    }
}

