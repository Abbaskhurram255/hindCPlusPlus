fc add(x: nr, y: nr) -> nr:
	return x plus y

cls TestClass:
    _make(self):
		print("you've instantiated a TestClass")

fc main() -> None:
	print(TestClass)
	har i andar limit(5):
		x: nr = 7
		y: nr = 3
		text: lafz = "abcde"
		current: lafz = text[i]
		agar i == 2 ya "b" andar current:
    		ignore
		print(i)
    #print(f"{x} + {y} = {add(x, y)}")
    #print(add(x, y))
        
on_start:
	main()