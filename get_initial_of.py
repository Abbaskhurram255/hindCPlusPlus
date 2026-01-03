from typing import Any

def get_initial_of(x: Any) -> Any:
	if not x:
		return None
	out: Any
	match x:
		case "str":
			out = ""
		case "int":
			out = 0 
		case "flt" | "float":
			out = 0.0
		case "bool" | "bln":
			out = False
		case "list":
			out = []
		case "dict":
			out = {}
		case _:
			out = None
	return out
	
print(get_initial_of("list"))