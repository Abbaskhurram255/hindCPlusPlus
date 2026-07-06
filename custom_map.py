from types import *
from typing import *
import datetime, re, sys, builtins

def when(src, cond1, sol1, cond2=None, sol2=None, cond3=None, sol3=None, cond4=None, sol4=None, cond5=None, sol5=None, cond6=None, sol6=None, cond7=None, sol7=None, cond8=None, sol8=None, cond9=None, sol9=None, cond10=None, sol10=None, cond11=None, sol11=None, cond12=None, sol12=None, cond13=None, sol13=None, cond14=None, sol14=None, cond15=None, sol15=None, cond16=None, sol16=None, cond17=None, sol17=None, cond18=None, sol18=None, cond19=None, sol19=None, cond20=None, sol20=None, default=None):
	from _translate import translate_for_jupyter
	from KL_Py import ltype
		# the import holding this entire function together
	if callable(getattr(src, "copy", None)):
		real_src = src.copy()
	else:
		real_src = src
	if type(real_src) in (type, GenericAlias, UnionType):
		real_src = str(real_src)
		if re.search(r"[\"\']", real_src):
			real_src = re.split(r"[\"\']", real_src)[1]
	if isinstance(src, str):
		src = f"'{src}'"
	if isinstance(cond1, str) and " " not in cond1 and not re.search(r"[><=]", cond1):
		cond1 = f"'{cond1}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond1, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond1 = str(cond1)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond1):
			cond1 = re.split(r"[\"\']", cond1)[1]
		elif "[" in cond1:
			src = ltype(src_pre_type_check)
	elif callable(cond1):
		try:
			cond1 = cond1(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond1)):
		cond1 = re.split(r"[\"\']", str(cond1))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond1).strip()):
		cond1 = f"== {cond1}"
	test = f"{src} {cond1}"
	raw_test = f"{real_src} {cond1}"
	if isinstance(cond1, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol1):
				return sol1
			try:
				return sol1()
			except Exception:
				try:
					return sol1(real_src)
				except Exception:
					try:
						return sol1(real_src, cond1)
					except Exception:
						return sol1(real_src, cond1, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond2, str) and " " not in cond2 and not re.search(r"[><=]", cond2):
		cond2 = f"'{cond2}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond2, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond2 = str(cond2)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond2):
			cond2 = re.split(r"[\"\']", cond2)[1]
		elif "[" in cond2:
			src = ltype(src_pre_type_check)
	elif callable(cond2):
		try:
			cond2 = cond2(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond2)):
		cond2 = re.split(r"[\"\']", str(cond2))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond2).strip()):
		cond2 = f"== {cond2}"
	test = f"{src} {cond2}"
	raw_test = f"{real_src} {cond2}"
	if isinstance(cond2, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol2):
				return sol2
			try:
				return sol2()
			except Exception:
				try:
					return sol2(real_src)
				except Exception:
					try:
						return sol2(real_src, cond2)
					except Exception:
						return sol2(real_src, cond2, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond3, str) and " " not in cond3 and not re.search(r"[><=]", cond3):
		cond3 = f"'{cond3}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond3, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond3 = str(cond3)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond3):
			cond3 = re.split(r"[\"\']", cond3)[1]
		elif "[" in cond3:
			src = ltype(src_pre_type_check)
	elif callable(cond3):
		try:
			cond3 = cond3(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond3)):
		cond3 = re.split(r"[\"\']", str(cond3))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond3).strip()):
		cond3 = f"== {cond3}"
	test = f"{src} {cond3}"
	raw_test = f"{real_src} {cond3}"
	if isinstance(cond3, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol3):
				return sol3
			try:
				return sol3()
			except Exception:
				try:
					return sol3(real_src)
				except Exception:
					try:
						return sol3(real_src, cond3)
					except Exception:
						return sol3(real_src, cond3, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond4, str) and " " not in cond4 and not re.search(r"[><=]", cond4):
		cond4 = f"'{cond4}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond4, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond4 = str(cond4)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond4):
			cond4 = re.split(r"[\"\']", cond4)[1]
		elif "[" in cond4:
			src = ltype(src_pre_type_check)
	elif callable(cond4):
		try:
			cond4 = cond4(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond4)):
		cond4 = re.split(r"[\"\']", str(cond4))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond4).strip()):
		cond4 = f"== {cond4}"
	test = f"{src} {cond4}"
	raw_test = f"{real_src} {cond4}"
	if isinstance(cond4, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol4):
				return sol4
			try:
				return sol4()
			except Exception:
				try:
					return sol4(real_src)
				except Exception:
					try:
						return sol4(real_src, cond4)
					except Exception:
						return sol4(real_src, cond4, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond5, str) and " " not in cond5 and not re.search(r"[><=]", cond5):
		cond5 = f"'{cond5}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond5, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond5 = str(cond5)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond5):
			cond5 = re.split(r"[\"\']", cond5)[1]
		elif "[" in cond5:
			src = ltype(src_pre_type_check)
	elif callable(cond5):
		try:
			cond5 = cond5(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond5)):
		cond5 = re.split(r"[\"\']", str(cond5))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond5).strip()):
		cond5 = f"== {cond5}"
	test = f"{src} {cond5}"
	raw_test = f"{real_src} {cond5}"
	if isinstance(cond5, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol5):
				return sol5
			try:
				return sol5()
			except Exception:
				try:
					return sol5(real_src)
				except Exception:
					try:
						return sol5(real_src, cond5)
					except Exception:
						return sol5(real_src, cond5, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond6, str) and " " not in cond6 and not re.search(r"[><=]", cond6):
		cond6 = f"'{cond6}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond6, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond6 = str(cond6)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond6):
			cond6 = re.split(r"[\"\']", cond6)[1]
		elif "[" in cond6:
			src = ltype(src_pre_type_check)
	elif callable(cond6):
		try:
			cond6 = cond6(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond6)):
		cond6 = re.split(r"[\"\']", str(cond6))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond6).strip()):
		cond6 = f"== {cond6}"
	test = f"{src} {cond6}"
	raw_test = f"{real_src} {cond6}"
	if isinstance(cond6, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol6):
				return sol6
			try:
				return sol6()
			except Exception:
				try:
					return sol6(real_src)
				except Exception:
					try:
						return sol6(real_src, cond6)
					except Exception:
						return sol6(real_src, cond6, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond7, str) and " " not in cond7 and not re.search(r"[><=]", cond7):
		cond7 = f"'{cond7}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond7, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond7 = str(cond7)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond7):
			cond7 = re.split(r"[\"\']", cond7)[1]
		elif "[" in cond7:
			src = ltype(src_pre_type_check)
	elif callable(cond7):
		try:
			cond7 = cond7(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond7)):
		cond7 = re.split(r"[\"\']", str(cond7))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond7).strip()):
		cond7 = f"== {cond7}"
	test = f"{src} {cond7}"
	raw_test = f"{real_src} {cond7}"
	if isinstance(cond7, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol7):
				return sol7
			try:
				return sol7()
			except Exception:
				try:
					return sol7(real_src)
				except Exception:
					try:
						return sol7(real_src, cond7)
					except Exception:
						return sol7(real_src, cond7, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond8, str) and " " not in cond8 and not re.search(r"[><=]", cond8):
		cond8 = f"'{cond8}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond8, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond8 = str(cond8)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond8):
			cond8 = re.split(r"[\"\']", cond8)[1]
		elif "[" in cond8:
			src = ltype(src_pre_type_check)
	elif callable(cond8):
		try:
			cond8 = cond8(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond8)):
		cond8 = re.split(r"[\"\']", str(cond8))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond8).strip()):
		cond8 = f"== {cond8}"
	test = f"{src} {cond8}"
	raw_test = f"{real_src} {cond8}"
	if isinstance(cond8, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol8):
				return sol8
			try:
				return sol8()
			except Exception:
				try:
					return sol8(real_src)
				except Exception:
					try:
						return sol8(real_src, cond8)
					except Exception:
						return sol8(real_src, cond8, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond9, str) and " " not in cond9 and not re.search(r"[><=]", cond9):
		cond9 = f"'{cond9}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond9, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond9 = str(cond9)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond9):
			cond9 = re.split(r"[\"\']", cond9)[1]
		elif "[" in cond9:
			src = ltype(src_pre_type_check)
	elif callable(cond9):
		try:
			cond9 = cond9(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond9)):
		cond9 = re.split(r"[\"\']", str(cond9))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond9).strip()):
		cond9 = f"== {cond9}"
	test = f"{src} {cond9}"
	raw_test = f"{real_src} {cond9}"
	if isinstance(cond9, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol9):
				return sol9
			try:
				return sol9()
			except Exception:
				try:
					return sol9(real_src)
				except Exception:
					try:
						return sol9(real_src, cond9)
					except Exception:
						return sol9(real_src, cond9, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond10, str) and " " not in cond10 and not re.search(r"[><=]", cond10):
		cond10 = f"'{cond10}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond10, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond10 = str(cond10)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond10):
			cond10 = re.split(r"[\"\']", cond10)[1]
		elif "[" in cond10:
			src = ltype(src_pre_type_check)
	elif callable(cond10):
		try:
			cond10 = cond10(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond10)):
		cond10 = re.split(r"[\"\']", str(cond10))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond10).strip()):
		cond10 = f"== {cond10}"
	test = f"{src} {cond10}"
	raw_test = f"{real_src} {cond10}"
	if isinstance(cond10, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol10):
				return sol10
			try:
				return sol10()
			except Exception:
				try:
					return sol10(real_src)
				except Exception:
					try:
						return sol10(real_src, cond10)
					except Exception:
						return sol10(real_src, cond10, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond11, str) and " " not in cond11 and not re.search(r"[><=]", cond11):
		cond11 = f"'{cond11}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond11, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond11 = str(cond11)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond11):
			cond11 = re.split(r"[\"\']", cond11)[1]
		elif "[" in cond11:
			src = ltype(src_pre_type_check)
	elif callable(cond11):
		try:
			cond11 = cond11(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond11)):
		cond11 = re.split(r"[\"\']", str(cond11))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond11).strip()):
		cond11 = f"== {cond11}"
	test = f"{src} {cond11}"
	raw_test = f"{real_src} {cond11}"
	if isinstance(cond11, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol11):
				return sol11
			try:
				return sol11()
			except Exception:
				try:
					return sol11(real_src)
				except Exception:
					try:
						return sol11(real_src, cond11)
					except Exception:
						return sol11(real_src, cond11, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond12, str) and " " not in cond12 and not re.search(r"[><=]", cond12):
		cond12 = f"'{cond12}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond12, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond12 = str(cond12)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond12):
			cond12 = re.split(r"[\"\']", cond12)[1]
		elif "[" in cond12:
			src = ltype(src_pre_type_check)
	elif callable(cond12):
		try:
			cond12 = cond12(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond12)):
		cond12 = re.split(r"[\"\']", str(cond12))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond12).strip()):
		cond12 = f"== {cond12}"
	test = f"{src} {cond12}"
	raw_test = f"{real_src} {cond12}"
	if isinstance(cond12, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol12):
				return sol12
			try:
				return sol12()
			except Exception:
				try:
					return sol12(real_src)
				except Exception:
					try:
						return sol12(real_src, cond12)
					except Exception:
						return sol12(real_src, cond12, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond13, str) and " " not in cond13 and not re.search(r"[><=]", cond13):
		cond13 = f"'{cond13}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond13, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond13 = str(cond13)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond13):
			cond13 = re.split(r"[\"\']", cond13)[1]
		elif "[" in cond13:
			src = ltype(src_pre_type_check)
	elif callable(cond13):
		try:
			cond13 = cond13(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond13)):
		cond13 = re.split(r"[\"\']", str(cond13))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond13).strip()):
		cond13 = f"== {cond13}"
	test = f"{src} {cond13}"
	raw_test = f"{real_src} {cond13}"
	if isinstance(cond13, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol13):
				return sol13
			try:
				return sol13()
			except Exception:
				try:
					return sol13(real_src)
				except Exception:
					try:
						return sol13(real_src, cond13)
					except Exception:
						return sol13(real_src, cond13, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond14, str) and " " not in cond14 and not re.search(r"[><=]", cond14):
		cond14 = f"'{cond14}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond14, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond14 = str(cond14)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond14):
			cond14 = re.split(r"[\"\']", cond14)[1]
		elif "[" in cond14:
			src = ltype(src_pre_type_check)
	elif callable(cond14):
		try:
			cond14 = cond14(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond14)):
		cond14 = re.split(r"[\"\']", str(cond14))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond14).strip()):
		cond14 = f"== {cond14}"
	test = f"{src} {cond14}"
	raw_test = f"{real_src} {cond14}"
	if isinstance(cond14, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol14):
				return sol14
			try:
				return sol14()
			except Exception:
				try:
					return sol14(real_src)
				except Exception:
					try:
						return sol14(real_src, cond14)
					except Exception:
						return sol14(real_src, cond14, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond15, str) and " " not in cond15 and not re.search(r"[><=]", cond15):
		cond15 = f"'{cond15}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond15, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond15 = str(cond15)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond15):
			cond15 = re.split(r"[\"\']", cond15)[1]
		elif "[" in cond15:
			src = ltype(src_pre_type_check)
	elif callable(cond15):
		try:
			cond15 = cond15(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond15)):
		cond15 = re.split(r"[\"\']", str(cond15))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond15).strip()):
		cond15 = f"== {cond15}"
	test = f"{src} {cond15}"
	raw_test = f"{real_src} {cond15}"
	if isinstance(cond15, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol15):
				return sol15
			try:
				return sol15()
			except Exception:
				try:
					return sol15(real_src)
				except Exception:
					try:
						return sol15(real_src, cond15)
					except Exception:
						return sol15(real_src, cond15, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond16, str) and " " not in cond16 and not re.search(r"[><=]", cond16):
		cond16 = f"'{cond16}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond16, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond16 = str(cond16)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond16):
			cond16 = re.split(r"[\"\']", cond16)[1]
		elif "[" in cond16:
			src = ltype(src_pre_type_check)
	elif callable(cond16):
		try:
			cond16 = cond16(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond16)):
		cond16 = re.split(r"[\"\']", str(cond16))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond16).strip()):
		cond16 = f"== {cond16}"
	test = f"{src} {cond16}"
	raw_test = f"{real_src} {cond16}"
	if isinstance(cond16, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol16):
				return sol16
			try:
				return sol16()
			except Exception:
				try:
					return sol16(real_src)
				except Exception:
					try:
						return sol16(real_src, cond16)
					except Exception:
						return sol16(real_src, cond16, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond17, str) and " " not in cond17 and not re.search(r"[><=]", cond17):
		cond17 = f"'{cond17}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond17, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond17 = str(cond17)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond17):
			cond17 = re.split(r"[\"\']", cond17)[1]
		elif "[" in cond17:
			src = ltype(src_pre_type_check)
	elif callable(cond17):
		try:
			cond17 = cond17(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond17)):
		cond17 = re.split(r"[\"\']", str(cond17))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond17).strip()):
		cond17 = f"== {cond17}"
	test = f"{src} {cond17}"
	raw_test = f"{real_src} {cond17}"
	if isinstance(cond17, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol17):
				return sol17
			try:
				return sol17()
			except Exception:
				try:
					return sol17(real_src)
				except Exception:
					try:
						return sol17(real_src, cond17)
					except Exception:
						return sol17(real_src, cond17, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond18, str) and " " not in cond18 and not re.search(r"[><=]", cond18):
		cond18 = f"'{cond18}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond18, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond18 = str(cond18)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond18):
			cond18 = re.split(r"[\"\']", cond18)[1]
		elif "[" in cond18:
			src = ltype(src_pre_type_check)
	elif callable(cond18):
		try:
			cond18 = cond18(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond18)):
		cond18 = re.split(r"[\"\']", str(cond18))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond18).strip()):
		cond18 = f"== {cond18}"
	test = f"{src} {cond18}"
	raw_test = f"{real_src} {cond18}"
	if isinstance(cond18, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol18):
				return sol18
			try:
				return sol18()
			except Exception:
				try:
					return sol18(real_src)
				except Exception:
					try:
						return sol18(real_src, cond18)
					except Exception:
						return sol18(real_src, cond18, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond19, str) and " " not in cond19 and not re.search(r"[><=]", cond19):
		cond19 = f"'{cond19}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond19, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond19 = str(cond19)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond19):
			cond19 = re.split(r"[\"\']", cond19)[1]
		elif "[" in cond19:
			src = ltype(src_pre_type_check)
	elif callable(cond19):
		try:
			cond19 = cond19(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond19)):
		cond19 = re.split(r"[\"\']", str(cond19))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond19).strip()):
		cond19 = f"== {cond19}"
	test = f"{src} {cond19}"
	raw_test = f"{real_src} {cond19}"
	if isinstance(cond19, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol19):
				return sol19
			try:
				return sol19()
			except Exception:
				try:
					return sol19(real_src)
				except Exception:
					try:
						return sol19(real_src, cond19)
					except Exception:
						return sol19(real_src, cond19, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	if isinstance(cond20, str) and " " not in cond20 and not re.search(r"[><=]", cond20):
		cond20 = f"'{cond20}'"
	if callable(getattr(src, "copy", None)):
		src_pre_type_check = src.copy()
	else:
		src_pre_type_check = src
	if isinstance(cond20, (type, GenericAlias, UnionType)):
		if type(src) not in (type, GenericAlias, UnionType):
			src = type(src)
		src = str(src)
		cond20 = str(cond20)
		if re.search(r"[\"\']", src):
			src = re.split(r"[\"\']", src)[1]
		real_src = f"kism({real_src})"
		if re.search(r"[\"\']", cond20):
			cond20 = re.split(r"[\"\']", cond20)[1]
		elif "[" in cond20:
			src = ltype(src_pre_type_check)
	elif callable(cond20):
		try:
			cond20 = cond20(real_src)
		except Exception:
			pass
	if re.search(r"^<class .+>$", str(cond20)):
		cond20 = re.split(r"[\"\']", str(cond20))[1]
	if not re.search(r"^(?:[<>!=]+|(?:is|he|in|da?rmya{0,2}n|me|b(?:ee|i)ch|ba?r[aie]{0,2}(?:ba?r)?|chota)\b)", str(cond20).strip()):
		cond20 = f"== {cond20}"
	test = f"{src} {cond20}"
	raw_test = f"{real_src} {cond20}"
	if isinstance(cond20, str):
		strings: list[str] = re.findall(r"[\"\'][^\"\']*[\"\']", test)
		for i, string in enumerate(strings):
			test = test.replace(string, f"__STRING_{i}__", 1)
		test = re.sub(r"(?<=\S) +\bis\b +(?=\S)", " == ", test)
		test = translate_for_jupyter(test)
		test = re.sub(r"\bf(?=__STRING)", "", test)
		test = re.sub(rf" +(?:ya|or) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" or {src} ", test)
		test = re.sub(rf" +(?:aur|and) +(?!ba?r[aie]{0,2}(?:ba?r)?\b)(?:{src} *)?", f" and {src} ", test)
		test = re.sub(r" *\| *([^\|]+)(?<!\s)", rf" or {src} == \1", test)
		test = re.sub(r" *\& *([^\&]+)(?<!\s)", rf" and {src} == \1", test)
		for i, string in enumerate(strings):
			test = test.replace(fr"__STRING_{i}__", string, 1)
	print(f"{test=}")
	try:
		if eval(test):
			if not callable(sol20):
				return sol20
			try:
				return sol20()
			except Exception:
				try:
					return sol20(real_src)
				except Exception:
					try:
						return sol20(real_src, cond20)
					except Exception:
						return sol20(real_src, cond20, raw_test)
	except Exception:
		pass
	src = src_pre_type_check
	return default
agar = jab = when


if __name__ == "__main__":
	print(when("glamor", "bara 15 se", "gt 15", None, "is null", "chota 7 se", "st 7", "bara ya barabar 13 ke", "gte 13", "darmyan ('glam', 'glamo')", "in glam, glamo", "he 'glamor'", lambda m: f"match he {m}", [1, 3], lambda m: print(f"it's {m}")))
	print(when("hello world", "me he 'hello'", lambda m, n, o: o))
	x = "hello"
	print(when([1, 4, 5, 7], lambda m: f"{m} he [1, 3, 5] | [1, 4, 5] | [1, 4, 5, 7]", lambda m, n, o: f"{m=} {n=} {o=}", None, lambda m: f"match he {m}"))
	print(agar(len("hey"), lambda m: f"({m} bari ya barabar 7 ke aur darmyan 2..3) ya he 3 ya he 5", lambda m, n, o: o))
	print(agar("hihi", str, lambda m,n,o: f"{m=} {n=} {o=}", "he 'hi' * 2", lambda m: print(m)))
	