
package javaminiproject;
import java.util.*;
import java.util.InputMismatchException;

// ===================== MOVIE GENRE QUIZ CLASSES=====================
interface Describable {
void describe();
}
class Genre implements Describable {
String name;
int score;
Genre(String name) {
this.name = name;
this.score = 0;
}
void addPoint() {
score = score + 1;
}
public void describe() {

System.out.println("You are a " + name + " person!");
}
}
class ActionGenre extends Genre {
ActionGenre() { super("Action"); }
public void describe() {
System.out.println("You are ACTION genre!");
System.out.println("You are energetic, bold and love excitement.");
System.out.println("Movies for you: John Wick, Mad Max, Fast and Furious");
}
}
class RomanceGenre extends Genre {
RomanceGenre() { super("Romance"); }
public void describe() {
System.out.println("You are ROMANCE genre!");
System.out.println("You are warm, emotional and deeply caring.");
System.out.println("Movies for you: The Notebook, Titanic, La La Land");
}
}
class HorrorGenre extends Genre {
HorrorGenre() { super("Horror"); }
public void describe() {
System.out.println("You are HORROR genre!");
System.out.println("You are mysterious, intense and love the thrill.");
System.out.println("Movies for you: The Conjuring, Get Out, IT");
}
}
class ComedyGenre extends Genre {
ComedyGenre() { super("Comedy"); }
public void describe() {
System.out.println("You are COMEDY genre!");
System.out.println("You are fun, cheerful and life of the party.");
System.out.println("Movies for you: Home Alone, The Hangover, Dumb and Dumber");
}
}
class SciFiGenre extends Genre {
SciFiGenre() { super("Sci-Fi"); }
public void describe() {
System.out.println("You are SCI-FI genre!");

System.out.println("You are curious, imaginative and love deep thinking.");
System.out.println("Movies for you: Interstellar, The Matrix, Inception");
}
}
// ===================== NUMBER GUESSING GAME CLASSES=====================
class Game {
private int secretNumber;
private int maxAttempts;
private int attempts;
private int lowerBound;
private int upperBound;
private Scanner scanner;
public Game(int lowerBound, int upperBound, int maxAttempts, Scanner scanner) {
this.lowerBound = lowerBound;
this.upperBound = upperBound;
this.maxAttempts = maxAttempts;
this.scanner = scanner;
generateNumber();
}
private void generateNumber() {
Random rand = new Random();
secretNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
attempts = 0;
}
public boolean playRound() {
System.out.println("\nGuess a number between " + lowerBound + " and " +
upperBound);
System.out.println("You have " + maxAttempts + " attempts!");
while (attempts < maxAttempts) {
System.out.print("Attempt " + (attempts + 1) + ": ");
int guess = scanner.nextInt();
attempts++;
if (guess == secretNumber) {
System.out.println(" Correct! You got it in " + attempts + " attempt(s)!");
return true;
} else if (guess < secretNumber) {
System.out.println(" Too Low!");
} else {
System.out.println(" Too High!");

}
if (attempts == 3) {
System.out.println(" Hint: The number is " +
(secretNumber % 2 == 0 ? "Even" : "Odd"));
}
System.out.println("Attempts remaining: " + (maxAttempts - attempts));
}
System.out.println(" Out of attempts! The number was: " + secretNumber);
return false;
}
public int getAttempts() {
return attempts;
}
}
class Player {
private String name;
private int gamesPlayed = 0;
private int gamesWon = 0;
public Player(String name) {
this.name = name;
}
public void recordResult(int attempts, boolean won) {
gamesPlayed++;
if (won) gamesWon++;
}
public String getName() {
return name;
}
public String getStats() {
return name + " | Played: " + gamesPlayed + " | Won: " + gamesWon;
}
}
class ScoreBoard {
private Player[] players;
private int count = 0;
public ScoreBoard(int size) {
players = new Player[size];
}
public void addPlayer(Player p) {
players[count++] = p;

}
public void display() {
System.out.println("\n=== SCOREBOARD ===");
for (int i = 0; i < count; i++) {
System.out.println(players[i].getStats());
}
}
}
// ===================== TRAVEL QUIZ CLASSES =====================
abstract class Question {
protected String ques;
abstract int ask();
}
class MCQues extends Question {
String opt1, opt2, opt3, opt4;
private Scanner sc;
MCQues(String q, String o1, String o2, String o3, String o4, Scanner sc) {
ques = q; opt1 = o1; opt2 = o2; opt3 = o3; opt4 = o4;
this.sc = sc;
}
public int ask() {
System.out.println("\n Question: " + ques);
System.out.println("\n 1. " + opt1);
System.out.println("\n 2. " + opt2);
System.out.println("\n 3. " + opt3);
System.out.println("\n 4. " + opt4);
int y;
while (true) {
try {
y = sc.nextInt();
if (y >= 1 && y <= 4) {
break;
} else {
System.out.println("\n Enter a number between 1 - 4. ");
}
} catch (java.util.InputMismatchException e) {
System.out.println("\n Invalid input. Enter a number between 1 - 4.");
sc.nextLine();
}
}

return y;
}
}
abstract class calculateResult {
protected int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
protected ArrayList<Integer> ans = new ArrayList<>();
void addans(int y) {
ans.add(y);
}
void calc() {
for (int y : ans) {
if (y == 1) c1++;
else if (y == 2) c2++;
else if (y == 3) c3++;
else if (y == 4) c4++;
}
}
abstract void show();
}
class TravelResult extends calculateResult {
void show() {
System.out.println("\n Get your passport ready! \n Your Destination is: ");
int max = Math.max(Math.max(c1, c2), Math.max(c3, c4));
if (c1 == max && max > c2 && max > c3 && max > c4) { System.out.println("\n LEH, INDIA "); }
else if (c2 == max && max > c1 && max > c3 && max > c4) { System.out.println("\n~~ SYDNEY, AUSTRALIA ~~"); }
else if (c3 == max && max > c1 && max > c2 && max > c4) { System.out.println("\n!! NEW YORK CITY, USA !!"); }
else if (max == c4 && max > c1 && max > c2 && max > c3) { System.out.println("\n* GORDES, FRANCE *"); }
else { System.out.println("\n ^^ GOKARNA, INDIA ^^"); }
}
}

// ===================== MAIN MENU =====================
public class main{
// ---- Helper: valid a/b/c/d/e answer (Movie Genre Quiz) ----
static char getValidAnswer(Scanner scanner) {
char answer = ' ';
int valid = 0;

while (valid == 0) {
answer = scanner.next().toLowerCase().charAt(0);
if (answer == 'a' || answer == 'b' || answer == 'c'|| answer == 'd' || answer == 'e') {
valid = 1;
} 
else {
System.out.println("Wrong input! Please enter a, b, c, d or e only");
System.out.print("Try again: ");
}
}
return answer;
}
// ---- Game 1: Number Guessing Game ----
static void playNumberGuessingGame(Scanner sc) {
System.out.println("\n=== NUMBER GUESSING GAME ===");
System.out.print("How many players? ");
int numPlayers = sc.nextInt();
sc.nextLine();
ScoreBoard scoreboard = new ScoreBoard(numPlayers);
Player[] players = new Player[numPlayers];
for (int i = 0; i < numPlayers; i++) {
System.out.print("Enter name for Player " + (i + 1) + ": ");
players[i] = new Player(sc.nextLine());
scoreboard.addPlayer(players[i]);
}
System.out.println("\nSelect Difficulty:");
System.out.println("1. Easy (1–50, 10 attempts)");
System.out.println("2. Medium (1–100, 7 attempts)");
System.out.println("3. Hard (1–200, 5 attempts)");
System.out.print("Choice: ");
int difficulty = sc.nextInt();
int upper, maxAttempts;
switch (difficulty) {
case 1 -> { upper = 50; maxAttempts = 10; }
case 3 -> { upper = 200; maxAttempts = 5; }
default -> { upper = 100; maxAttempts = 7; }
}
boolean playAgain = true;
while (playAgain) {
for (Player player : players) {

System.out.println("\n" + player.getName() + "'s turn!");
Game game = new Game(1, upper, maxAttempts, sc);
boolean won = game.playRound();
player.recordResult(game.getAttempts(), won);
}
scoreboard.display();
System.out.print("Play another round? (yes/no): ");
sc.nextLine();
String response = sc.nextLine();
playAgain = response.equalsIgnoreCase("yes");
}
System.out.println("Thanks for playing!");
}

// ---- Game 2: Movie Genre Quiz ----
static void playMovieGenreQuiz(Scanner sc) 
{
Genre[] genres = new Genre[5];
genres[0] = new ActionGenre();
genres[1] = new RomanceGenre();
genres[2] = new HorrorGenre();
genres[3] = new ComedyGenre();
genres[4] = new SciFiGenre();
System.out.println("\n WELCOME TO QUIZ ");
System.out.println(" WHICH MOVIE GENRE ARE YOU? - QUIZ");
System.out.println("Answer 6 questions honestly!");
System.out.println("Enter only a, b, c, d or e");
System.out.println("\nQ1: Its Friday night, what are you doing?");
System.out.println(" a) Going to gym or playing a sport");
System.out.println(" b) Watching romantic movie with someone");
System.out.println(" c) Exploring a haunted place for fun");
System.out.println(" d) Hanging out with friends and joking");
System.out.println(" e) Reading about space or documentary");
System.out.print("Your answer: ");
char q1 = getValidAnswer(sc);
if (q1 == 'a') genres[0].addPoint();
if (q1 == 'b') genres[1].addPoint();
if (q1 == 'c') genres[2].addPoint();
if (q1 == 'd') genres[3].addPoint();
if (q1 == 'e') genres[4].addPoint();
System.out.println("\nQ2: What kind of music do you like?");
System.out.println(" a) Loud rock or hip hop");

System.out.println(" b) Soft romantic songs");
System.out.println(" c) Dark and eerie music");
System.out.println(" d) Fun party songs");
System.out.println(" e) Electronic or futuristic music");
System.out.print("Your answer: ");
char q2 = getValidAnswer(sc);
if (q2 == 'a') genres[0].addPoint();
if (q2 == 'b') genres[1].addPoint();
if (q2 == 'c') genres[2].addPoint();
if (q2 == 'd') genres[3].addPoint();
if (q2 == 'e') genres[4].addPoint();
System.out.println("\nQ3: Pick a vacation type:");
System.out.println(" a) Skydiving or bungee jumping");
System.out.println(" b) Cozy beach sunset with partner");
System.out.println(" c) Exploring abandoned buildings");
System.out.println(" d) Comedy show or fun theme park");
System.out.println(" e) Space museum or science exhibition");
System.out.print("Your answer: ");
char q3 = getValidAnswer(sc);
if (q3 == 'a') genres[0].addPoint();
if (q3 == 'b') genres[1].addPoint();
if (q3 == 'c') genres[2].addPoint();
if (q3 == 'd') genres[3].addPoint();
if (q3 == 'e') genres[4].addPoint();
System.out.println("\nQ4: How do you react under pressure?");
System.out.println(" a) Face it head on, no fear");
System.out.println(" b) Rely on emotions and loved ones");
System.out.println(" c) Stay calm and embrace the unknown");
System.out.println(" d) Crack a joke to lighten the mood");
System.out.println(" e) Analyze and find logical solution");
System.out.print("Your answer: ");
char q4 = getValidAnswer(sc);
if (q4 == 'a') genres[0].addPoint();
if (q4 == 'b') genres[1].addPoint();
if (q4 == 'c') genres[2].addPoint();
if (q4 == 'd') genres[3].addPoint();
if (q4 == 'e') genres[4].addPoint();
System.out.println("\nQ5: Your dream superpower?");
System.out.println(" a) Super strength and speed");
System.out.println(" b) Reading minds and feeling emotions");

System.out.println(" c) Becoming invisible");
System.out.println(" d) Making everyone laugh");
System.out.println(" e) Time travel or teleportation");
System.out.print("Your answer: ");
char q5 = getValidAnswer(sc);
if (q5 == 'a') genres[0].addPoint();
if (q5 == 'b') genres[1].addPoint();
if (q5 == 'c') genres[2].addPoint();
if (q5 == 'd') genres[3].addPoint();
if (q5 == 'e') genres[4].addPoint();
System.out.println("\nQ6: Which best describes you?");
System.out.println(" a) I am a go-getter, always on the move");
System.out.println(" b) I am sensitive and deeply emotional");
System.out.println(" c) I am mysterious and hard to read");
System.out.println(" d) I am the funny one in my friend group");
System.out.println(" e) I am curious and question everything");
System.out.print("Your answer: ");
char q6 = getValidAnswer(sc);
if (q6 == 'a') genres[0].addPoint();
if (q6 == 'b') genres[1].addPoint();
if (q6 == 'c') genres[2].addPoint();
if (q6 == 'd') genres[3].addPoint();
if (q6 == 'e') genres[4].addPoint();
int maxScore = 0;
int winnerIndex = 0;
for (int i = 0; i < genres.length; i++) {
if (genres[i].score > maxScore) {
maxScore = genres[i].score;
winnerIndex = i;
}
}
System.out.println(" YOUR RESULT IS: ");
genres[winnerIndex].describe();
System.out.println("THANK U");
}
// ---- Game 3: Travel Destination Quiz ----
static void playTravelQuiz(Scanner sc) {
System.out.println("\n Welcome to THE TRAVEL QUIZ !");
System.out.println(" **Answer the questions and get your perfect travel destination**");

System.out.println(" Just trust your gut ;) ");
TravelResult r = new TravelResult();
Question m1 = new MCQues(
"How would you spend your day off?",
"Learning something that interests you",
"Doing physical hobbies or exercise",
"Going out with your friends",
"Having a slow morning", sc
);
r.addans(m1.ask());
Question m2 = new MCQues(
"Which career are you drawn to?",
"Historian",
"Scuba Diving instructor",
"Economist",
"Veterinarian", sc
);
r.addans(m2.ask());
Question m3 = new MCQues(
"Choose one of these appetisers-",
"Tomato Soup with grilled cheese sandwich.",
"Garlic Bread.",
"French fries",
"Hot-honey roasted vegetables", sc
);
r.addans(m3.ask());
Question m4 = new MCQues(
"Choose one of these special rooms in a home: ",
"Rock climbing room",
"Pool",
"Home theatre",
"Garden", sc
);
r.addans(m4.ask());
Question m5 = new MCQues(
"Choose your favorite icecream flavor: ",
"Pistachio",
"Mango",
"Chocolate chip",
"Mixed berry", sc

);
r.addans(m5.ask());
Question m6 = new MCQues(
"Choose your favorite movie genre - ",
"Thriller",
"Musical",
"Sci-Fi",
"Mystery", sc
);
r.addans(m6.ask());
r.calc();
r.show();
}
// ===================== MAIN METHOD =====================
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int choice;
while (true) {
System.out.println("\n========================================");
System.out.println(" MINI PROJECT MENU ");
System.out.println("========================================");
System.out.println(" 1. Number Guessing Game");
System.out.println(" 2. Movie Genre Quiz");
System.out.println(" 3. Travel Destination Quiz");
System.out.println(" 4. Exit");
System.out.println("========================================");
System.out.print("Enter your choice (1-4): ");
try {
choice = sc.nextInt();
} catch (InputMismatchException e) {
System.out.println("Invalid input! Please enter a number between 1 and 4.");
sc.nextLine();
continue;
}
switch (choice) {
case 1 -> playNumberGuessingGame(sc);
case 2 -> playMovieGenreQuiz(sc);
case 3 -> playTravelQuiz(sc);
case 4 -> {
System.out.println("\nThank you for playing! Goodbye :)");

sc.close();
return;
}
default -> System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
}
}
}
}


