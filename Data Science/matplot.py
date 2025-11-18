from matplotlib.pyplot import *
from random import *

languages = ["Java", "Python", "Kotlin"]
my_rankings = [randint(5, 50), randint(5, 50), randint(5, 50)]
plot(languages, my_rankings)
show()
