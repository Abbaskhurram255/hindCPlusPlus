/*
	public static void main(String[] args) {
		//createFile("g.txt","hi");
		deleteFile("g.txt");
		String name = scan("Please enter your name: ");
		next();
		int age = scani("And age? ");
		next();
		print("---- * ----");
		next();
		print("Name:", name, "\nAge:", age);
		String arrayOfTextChunks[] = {"hi", "this", "is", "me"};
		int nums[] = {1, 2, 5, 3, 6, 7, 8, 4, 9, 10};
		sort(nums);
		String collectedChunks = join(arrayOfTextChunks, "+");
		print(collectedChunks);
		print(randInt());

	print(randItem(arrayOfTextChunks));
	    //print(len(nums));
	    printAll(nums);
	}
	*/


//print(sentCase("hi love, how's it going? i am trying."));
//createFolder("g");
/*
String contents = readFile("Book.java");
print(contents);
*/
//deleteFolder("g");
//print(getSeason());
//print(upper(replace(trim("     Hi there love"), " ", "-")));
//print(endsWith("hello world", "rld"));



/*
Obj_S languages = new Obj_S("key", "value", "fruit", "banana", "car", "porsche");
Obj_D constants = new Obj_D("g", 9.8);
constants.add("pi", 3.15);
constants.set("pi", 3.16);
constants.update("pi", 3.14);
constants.printMap();
languages.add("java", "enterprise");
languages.add("python", "ml/ai")
languages.add("javascript", "frontend");
languages.printMap();
//iterating through keys
System.out.print("\n\nKeys: ");
for (String key : languages.keys()) {
	System.out.print(key);
	System.out.print(", ");
}
//iterating through values
System.out.print("\n\nValues: ");
for (var value : languages.values()) {
	System.out.print(value);
	System.out.print(", ");
}
*/



/*
int nums[] = {1, 2, 5, 3, 6, 7, 8, 4, 9, 10};
int nums_sorted[] = copyArr(nums);
sort(nums_sorted);
print("Nums: ");
printArr(nums);
br(1);
print("Nums, sorted: ");
printArr(nums_sorted);
*/



/*
print(now());
print(getSeason());
print(getMonth());
*/



//print(sliceToAfter("This is a lovely evening we shouldn't miss", "lovely "));
//for (int i : range(500)) print(th(i));
//printArr(divisorsOf(80));
//repeat(() -> print("hi"), 5);
//print(f("hi %s, sorry, you're %d minutes late", "Love", 23));  //print(f(75000124));
//print(pkr(1001510000000.294));
//double x = 8000.5;
//print(curr(x, "JP¥"));
//double x = 80143000000000000000000000000000000.0;
///print(ussuffix(x));
//Int_Arr arr = new Int_Arr(1, 0, -2, 3, 5, 7, 7, 7);
//arr.sort().unique();
//arr.pushStart(9);
//arr.shuffle();
//arr.map(n -> n*2);
//int popped = arr.pop(3);
//print("Popped:", popped);
//arr.forEach(n -> print(n));
//printArr(arr);



/*
int[] numbers = {1, 2, 3, 4, 5, 6, 7};
forEach(numbers, (n, i) -> print(f("%d: %d", i, n)));
*/



/*
        IntArr arr = new IntArr(1, 3, 5, 7);
		StrArr s = new StrArr("hi", "hallo", "hola", "namaste", "ciao");
		print("Contents of the integer array:");
		forEach(arr, (n, i) -> print(f("%d: %d", i, n)));
		br(1);
		print("Contents of the string array:");
		forEach(s, (str, i) -> print(f("%d: %s", i, str)));
*/

/*
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        numbers = map(numbers, n -> n+1);
		print(numbers[0]);
*/
/*
Money m = new Money(5*cr);
        m.curr("PK").add(8 * zr, 5 * zr).add(1 * zr).add(1 * lc);
        print(m.balance());
        print(m.balance(true));
        print(m.suffix(true));
*/

/*
        Tree_I tree =
            new Tree_I(6, "six", 1, "one", 2, "two", 3, "three", 4, "four");
        tree.add(5, "five").add(7, "seven");
        tree.printMap();
        print(tree.firstKey(), ":", tree.first());
        print(tree.nthKey(1), ":", tree.get(2));
        print(tree.nthKey(2), ":", tree.nthValue(2));
        int[] keys = tree.keyArray();
        printArr(keys);
        String[] values = tree.array();
        printArr(values);
*/

//tested, worked
//rndcts = filterOut(rndcts, match -> in(match, "Hi(m|s)"));


//StrArr arr = new StrArr("zoo", "hi", "beetles", "zer");
//setTimeout(() -> printArr(arr.reverse()), 5);
//print(fetch("https://randusers-api.vercel.app"));
/*
	    int n = 2;
	    String str = "hello";
	    boolean lightsOn = !true;
	    sw(n, ">5", () -> print("greater than 5"), 5, () -> print("equals 5"), Else, () -> print("all tof the guesses are incorrect"));
	    sw(str, "hey", () -> print("equals hey"), "woohoo", () -> print("equals woohoo"), Else, () -> print("bad guess, equals something else"));
	    sw(lightsOn, Yes, () -> print("the lights are on"), No, () -> print("the lights are off"));
*/
/*
        print(findMatch("'hi there love, am I late?', I ask, to which she replies, 'at least 15 mins late, you moron'", "%s %s %d %s %s"));
*/

/*
        int[] nums = range(1, 10).array();
	    int[] evens = onlyKeep(nums, n -> n % 2 == 0),
	        odds = onlyPop(nums, evens);
	    print("Evens: ");
	    printArr(evens);
	    print("Odds: ");
	    printArr(odds);
*/

/*
	    Object[] arr = {3, 3.14, 3.14f, true, "", 4L, 'c'};
	    each(arr, (obj, i) -> {
	    	print(cat("#", i+1, "."), "Is a", type(obj), ":", type(obj, Bool));
	    });
*/

/*
        sw(8.4, ">9", () -> print("uh...?"), "==8.47", () -> print("yeah"),
				">16", () -> print("still a no?"), "==12", () -> print("ugh"),
				">51", () -> print("no?"), ">92", () -> print("I dunno"), "<3",
				() -> print("could it be that?"), ">8",
				() -> print("you got me"), Else, () -> print("neither"));
		
		print(randPct());
		print(clr("#7fc6").getAlpha());
		printArr(intsOf("hi there 6.1 7.4 love, I'm 666, that's right, a devil girl"));
		sw('f', ">105", () -> print("possibly?"), 102, () -> print("quite a match"), Else, () -> print("it does NOT match"));
		//print(join(nums, "+"));
*/

        /*
		print(type(colors.red));
		print(type(new Number[]{7}));
		print(type(new Object[]{"hi"}));
    	print(type(arr2));
    	print(not(new String[]{}, new String[]{"hi"}));
        print(not("hi", null));
        */
        
        /*
		 * print(replace("hello there", "^hel\\w+", m -> m.toUpperCase())); int
		 * interval = setInterval(() -> print(randId()), 5, 2); //setTimeout(()
		 * -> clearInterval(interval), 20); print(type(red)); print(xor(Yes,
		 * not(Yes))); String[] arr = {"hi", "Hola", "hallo", "bonjour", "zoo",
		 * "YiPPe yay"}; arr = sort(arr, "desc"); arr = lower(arr); char[] chars
		 * = Chars(lastOf(arr)); printArr(upper(chars));
		 * printArr(sentCase(arr));
		 * 
		 * sw(len("hiya"), "<12&>=4", () -> print("match"), Else, () ->
		 * print("not a match")); int age = 22; print(sw(age, "<18", () ->
		 * print("Just too young."), "<23&>=18", () ->
		 * print("sorry, still underaged"), Else, () ->
		 * print("you're in the drinking age, get in the bar🍺"))); sw(true,
		 * Yes, () -> print("the lights are on"), Else, () -> print("off"));
		 */