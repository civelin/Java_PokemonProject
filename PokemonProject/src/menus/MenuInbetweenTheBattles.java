//package menus;
//
//import pokemons.Pokemon;
//import users.HumanUser;
//import users.User;
//import validators.Validator;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class MenuInbetweenTheBattles {
//    public static void printVictoriousTextAfterSuccessfulBattle (User pcUser){
//        System.out.println("Congratulations. You managed to defeat "+pcUser.getName()+" !");
//    }
//
//    public static void printTextAfterFirstBattle(User pcUser){
//        System.out.println("Now as a reward for your hard-fought victory , you must choose one pokemon from "+pcUser.getName()+"!");
//        System.out.println("Choose carefully and good luck on your next battle!");
//    }
//
//    public static List<Pokemon> humanPokemonChoiceAsReward(List<Pokemon> pcUserPokemons , HumanUser user){
//        List<Pokemon>humanPokemons = humanUserPokemons;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Choose one pokemon from your opponent inventory!");
//        System.out.println();
//        for(Pokemon pokemon : pcUserPokemons){
//            System.out.println("----> "+pokemon.getName());
//        }
//        String choice = sc.next();
//        while(!Validator.enterChoice(pcUserPokemons.size(), choice)){
//            System.out.println("Enter a number from 1 to 5 !");
//            choice = sc.next();
//        }
//        int choiceInt=Integer.parseInt(choice);
//        if(choiceInt==1){
//            humanUserPokemons.add(pcUserPokemons.get(choiceInt-1));
//        } else if (choiceInt==2) {
//            humanPokemons.add(pcUserPokemons.get(choiceInt-1));
//        } else if () {
//
//        }
//        return Integer.parseInt(choice);
//    }
//}
