#include <stdio.h>
#include <stdarg.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#define string char*
#define flt float
#define haal bool
#define falaana ""
#define yes true
#define sach true
#define han true
#define no false
#define jhoot false
#define na false
#define nahi == false
#define agar_sach == true
#define agar_jhoot ""
#define warna ""
#define bana =
#define bani =
#define bane =
#define be =
#define is_now =
#define ab =
#define ab_he =
#define he_ab =
#define exchange swap
#define hera_pheri swap
#define exists !!
#define karo do
#define jabtak while (
#define tabtak {
#define then {
#define to {
#define tab {
#define abbas }
#define basab }
#define khatm }
#define ant }
#define ruko break
#define skip continue
#define phere for (
#define keejye )
#define ka )
#define ko )
#define or_run {
#define agar if (
#define hen )
#define nahi_to_agar } else if (
#define nahi_to } else
#define agar_koi_na } else 
#define me_izafa +=
#define me_dalo +=
#define me_dala +=
#define me_barha +=
#define me_barhao +=
#define me_gaya +=
#define me_ghata -=
#define me_ghatao -=
#define se_gaya -=
#define se_ghata -=
#define se_ghatao -=
#define koshish try
#define rukawat catch (...)
#define na_kami catch (...)
#define newError throw
#define nayaError throw
#define halat switch (
#define haalat switch (
#define ki ) {
#define surat case
#define basurat case
#define barabar =
#define me :
#define is ==
#define wakai_barabar ==
#define nahi_barabar !=
#define zyada_ya_barabar >=
#define kam_ya_barabar <=
#define zyada_ya_barabar >=
#define bara_ya_barabar >=
#define bare_ya_barabar >=
#define kam_ya_barabar <=
#define chota_ya_barabar <=
#define chote_ya_barabar <=
#define se_bara <
#define se_bare <
#define se_bari <
#define se_chota >
#define se_chote >
#define se_choti >
#define se )
#define re ;
#define ri ;
#define love ;
#define janu ;
#define pyari ;
#define larki ;
#define ji ;
#define object typedef struct
#define Object typedef struct
#define on int main() {
#define off }
#define shuru int main() {
#define shurwat int main() {
#define khu int main() {
#define ram }
#define hind int main() {
#define C }
#define co int main() {
#define de }
#define aye int main() {
#define sha }


#define khurram ;printf("");
#define set ;printf("");
#define hui ;printf("");
#define hua ;printf("");
#define hue ;printf("");
#define pagli ;printf("");
#define baba ;printf("");
#define meri_jan ;printf("");
#define ayesha ;printf("");
#define not !
#define type(x) _Generic((x), \
    int: "int", \
    float: "float", \
    double: "double", \
    char: "char", \
    char*: "string", \
    default: "unknown")
#define typeof type
#if defined __has_include
    #if __has_include (<conio.h>)
        #include <conio.h>
        int black = BLACK, red = RED, yellow = YELLOW, green = GREEN, blue = BLUE, white = WHITE, cyan = CYAN;
        int kala, kaala, lal, laal, peela, hara, nira, neera, sufed, safed, shurwati, _def, samandari;
        void recognize_colors()
        {
            kala = kaala = black, lal = laal = red, peela = yellow, hara = green, nira = neera = blue, safed = sufed = shurwati = _def = white, samandari = cyan;
        }
        void clr(int new_color)
        {
            textcolor(new_color);
        }
        void bg(int new_bg_color)
        {
            textbackground(new_bg_color);
        }
        void bgclr(int new_bg_color)
        {
            textbackground(new_bg_color);
        }
        void backgr(int new_bg_color)
        {
            textbackground(new_bg_color);
        }
        void cls()
        {
            clrscr();
        }
    #endif
#endif

#define len strlen
#define lambai strlen
#define arrlen(arr) (sizeof(arr) / sizeof(arr[0]))

void kaho(const char *args, ...)
{
    printf(args);
    printf("\n");
}
void print(const char *args, ...)
{
    kaho(args);
}
void kaho_inline(const char *args, ...)
{
    printf(args);
}
void kaho_nobr(const char *args, ...)
{
    kaho_inline(args);
}
void kaho_sameln(const char *args, ...)
{
    kaho_inline(args);
}
void print_(const char *args, ...)
{
    kaho_inline(args);
}
void print_inline(const char *args, ...)
{
    kaho_inline(args);
}
void kaho_i(const int args, ...)
{
    printf("%i", args);
    printf("\n");
}
void print_i(const int args, ...)
{
    kaho_i(args);
}
void kaho_i_inline(const int args, ...)
{
    printf("%i", args);
}
void kaho_i_nobr(const int args, ...)
{
    kaho_i_inline(args);
}
void kaho_i_sameln(const int args, ...)
{
    kaho_i_inline(args);
}
void print_i_inline(const int args, ...)
{
    kaho_i_inline(args);
}
void kaho_c(const char args, ...)
{
    printf("%c", args);
    printf("\n");
}
void print_c(const char args, ...)
{
    kaho_c(args);
}
void kaho_c_inline(const char args, ...)
{
    printf("%c", args);
}
void kaho_c_nobr(const char args, ...)
{
    kaho_c_inline(args);
}
void kaho_c_sameln(const char args, ...)
{
    kaho_c_inline(args);
}
void print_c_inline(const char args, ...)
{
    kaho_c_inline(args);
}
void kaho_f(const float args, ...)
{
    printf("%.1f", args);
    printf("\n");
}
void print_f(const float args, ...)
{
    kaho_f(args);
}
void kaho_f_inline(const float args, ...)
{
    printf("%.1f", args);
}
void kaho_f_nobr(const float args, ...)
{
    kaho_f_inline(args);
}
void kaho_f_sameln(const float args, ...)
{
    kaho_f_inline(args);
}
void print_f_inline(const float args, ...)
{
    kaho_f_inline(args);
}
void kaho_n(const float args, ...)
{
    kaho_f(args);
}
void print_n(const float args, ...)
{
    kaho_f(args);
}
void kaho_n_inline(const float args, ...)
{
    kaho_f_inline(args);
}
void print_n_inline(const float args, ...)
{
    kaho_f_inline(args);
}
void kaho_n_nobr(const float args, ...)
{
    kaho_f_inline(args);
}
void kaho_n_sameln(const float args, ...)
{
    kaho_f_inline(args);
}
void kaho_b(const int args, ...)
{
    printf("%s", !args ? "false" : "true");
    printf("\n");
}
void print_b(const int args, ...)
{
    kaho_b(args);
}
void kaho_b_inline(const int args, ...)
{
    printf("%s", !args ? "false" : "true");
}
void kaho_b_nobr(const int args, ...)
{
    kaho_b_inline(args);
}
void kaho_b_sameln(const int args, ...)
{
    kaho_b_inline(args);
}
void print_b_inline(const int args, ...)
{
    kaho_b_inline(args);
}
void pucho(char *x, char *y)
{
    printf("\n%s\n", x);
    scanf("%s", y);
}
int pucho_i(char *x)
{
    int y = 0;
    printf("\n%s\n", x);
    scanf("%i", &y);
    return y;
}
char pucho_c(char *x)
{
    char y;
    printf("\n%s\n", x);
    scanf("%s", &y);
    return y;
}
float pucho_f(char *x)
{
    float y = 0;
    printf("\n%s\n", x);
    scanf("%f", &y);
    return y;
}
void scan(char *x, char *y)
{
    pucho(x, y);
}
int scan_i(char *x)
{
    return pucho_i(x);
}
char scan_c(char *x)
{
    return pucho_c(x);
}
float scan_f(char *x)
{
    return pucho_f(x);
}
void ask(char *x, char *y)
{
    pucho(x, y);
}
int ask_i(char *x)
{
    return pucho_i(x);
}
char ask_c(char *x)
{
    return pucho_c(x);
}
float ask_f(char *x)
{
    return pucho_f(x);
}
void linechoro(int n)
{
    for (; n; n--)
        printf("\n");
}
void agline()
{
    linechoro(1);
}
void br(int n)
{
    linechoro(n);
}
void tb(int n)
{
    for (int i = 0; i < n; i++)
        printf("\t");
}
void repeat(char *h, int j)
{
    for (int i = 0; i < j; i++)
        kaho(h);
}
void repeat_inline(char *h, int j)
{
    for (int i = 0; i < j; i++)
        kaho_inline(h);
}
void repeat_i(int h, int j)
{
    for (int i = 0; i < j; i++)
        kaho("%i", h);
}
void repeat_i_inline(int h, int j)
{
    for (int i = 0; i < j; i++)
        kaho_inline("%i", h);
}
void repeat_c(char h, int j)
{
    for (int i = 0; i < j; i++)
        kaho("%c", h);
}
void repeat_c_inline(char h, int j)
{
    for (int i = 0; i < j; i++)
        kaho_inline("%c", h);
}
void repeat_f(float h, int j)
{
    for (int i = 0; i < j; i++)
        kaho("%.1f", h);
}
void repeat_f_inline(float h, int j)
{
    for (int i = 0; i < j; i++)
        kaho_inline("%.1f", h);
}
void repeat_b(int h, int j)
{
    for (int i = 0; i < j; i++)
        kaho("%s", !h ? "false" : "true");
}
void repeat_b_inline(int h, int j)
{
    for (int i = 0; i < j; i++)
        kaho_inline("%s", !h ? "false" : "true");
}
void duhrao(char *str, int n_times)
{
    repeat(str, n_times);
}
void duhrao_inline(char *str, int n_times)
{
    repeat_inline(str, n_times);
}
void duhrao_i(int i, int n_times)
{
    repeat_i(i, n_times);
}
void duhrao_i_inline(int i, int n_times)
{
    repeat_i_inline(i, n_times);
}
void duhrao_c(char c, int n_times)
{
    repeat_c(c, n_times);
}
void duhrao_c_inline(char c, int n_times)
{
    repeat_c_inline(c, n_times);
}
void duhrao_f(float f, int n_times)
{
    repeat_f(f, n_times);
}
void duhrao_f_inline(float f, int n_times)
{
    repeat_f_inline(f, n_times);
}
void duhrao_b(int boolean, int n_times)
{
    repeat_b(boolean, n_times);
}
void duhrao_b_inline(int boolean, int n_times)
{
    repeat_b_inline(boolean, n_times);
}

//STRING METHODS
char *replace(char *orig, char *rep, char *with)
{
    char *result;
    char *ins;
    char *tmp;
    int len_rep;
    int len_with;
    int len_front;
    int count;
    if (!orig || !rep)
        return NULL;
    len_rep = strlen(rep);
    if (len_rep == 0)
        return NULL;
    if (!with)
        with = "";
    len_with = strlen(with);
    ins = orig;
    for (count = 0; (tmp = strstr(ins, rep)); ++count)
    {
        ins = tmp + len_rep;
    }
    tmp = result = malloc(strlen(orig) + (len_with - len_rep) * count + 1);
    if (!result)
        return NULL;
    while (count--)
    {
        ins = strstr(orig, rep);
        len_front = ins - orig;
        tmp = strncpy(tmp, orig, len_front) + len_front;
        tmp = strcpy(tmp, with) + len_with;
        orig += len_front + len_rep;
    }
    strcpy(tmp, orig);
    return result;
}
char *badlo(char *org, char *toreplace, char *replacement)
{
    return replace(org, toreplace, replacement);
}
char *keepFirst(char *str, char *with)
{
    char *org = str;
    char *result = strtok(str, with);
    strcpy(str, "");
    strcpy(str, org);
    return result;
}
char *keepLast(char *str, char *with)
{
    char *token;
    token = strtok(str, with);
    char *result = token = strtok(NULL, with);
    return result;
}
char *keepAfter(char *a, char *b)
{
    char *result = strstr(a, b);
    return result;
}
char *slice(char *str, int start, int end)
{
    int i;
    int size = end - start;
    char *output = (char *)malloc(size * sizeof(char));
    for (i = 0; start <= end; start++, i++)
    {
        output[i] = str[start];
    }
    output[size] = '\0';
    return output;
}
char *trim(char *str, int start, int end)
{
    return slice(str, start, end);
}
void strappend(char *s, char c)
{
    int l = strlen(s);
    s[l] = c;
    s[l + 1] = '\0';
    //works
}
char *upper(char *str)
{
    for (int i = 0; i < strlen(str); i++)
        str[i] = toupper(str[i]);
    return str;
}
char *cap(char *str)
{
    return upper(str);
}
char *lower(char *str)
{
    for (int i = 0; i < strlen(str); i++)
        str[i] = tolower(str[i]);
    return str;
}
char *sentCase(char *str)
{
    char c = toupper(str[0]);
    char *sliced = slice(str, 1, strlen(str));
    char firstChar[96] = {c, '\0'};
    char *result = strcat(firstChar, sliced);
    if (result[strlen(result) - 1] != '.')
        strcat(result, ".");
    return result;
}

char *strPop(char *str)
{
    str[strlen(str) - 1] = '\0';
    return str;
}

int he(char *x, char *y)
{
    return strcasecmp(x, y) == 0;
}
char *naya(char *x, char *y)
{
    return strcpy(x, y);
}
char *nai(char *x, char *y)
{
    return strcpy(x, y);
}
char *addTo(char *str1, char *str2)
{
    return strcat(str1, str2);
}
char *addTwo(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *connect(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *join(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *concat(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *merge(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *stradd(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *strplus(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *makeone(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *strmilao(char *str1, char *str2)
{
    return addTo(str1, str2);
}
char *strjoro(char *str1, char *str2)
{
    return addTo(str1, str2);
}

//NUMBER METHODS
int isNumlike(char *str)
{
    int checks_passed = 0;
    for (int i = 0; str[i]; i++)
    {
        char c = str[i];
        if (isdigit(c) || c == '.')
            checks_passed += 1;
    }
    return checks_passed == strlen(str);
}
int isIntlike(char *str)
{
    int checks_passed = 0, all_checks_passed = 0;
    for (int i = 0; str[i]; i++)
    {
        char c = str[i];
        if (isdigit(c))
            checks_passed += 1;
        all_checks_passed = checks_passed == strlen(str);
    }
    return all_checks_passed | 0;
}
int isFltlike(char *str)
{
    int n_digits = 0, n_periods = 0, all_checks_passed = 0;
    for (int i = 0; str[i]; i++)
    {
        char c = str[i];
        if (isdigit(c))
            n_digits += 1;
        else if (c == '.')
            n_periods += 1;
        all_checks_passed = n_digits && n_periods;
    }
    return all_checks_passed || 0;
}
int heNumjesa(char *str)
{
    return isNumlike(str);
}
int heIntjesa(char *str)
{
    return isIntlike(str);
}
int heFltjesa(char *str)
{
    return isFltlike(str);
}

// ::Math
double Pos(double n) {
    return fabs(n);
}
double Neg(double n) {
    return -n;
}
int sq(int n)
{
    return n * n;
}
int cb(int n)
{
    return n * n * n;
}
int area(int width, int height)
{
    return width * height;
}
int rect(int w, int h)
{
    return area(w, h);
}
int tria(int base, int height)
{
    return area(base, height) / 2;
}
float sum(float a, float b)
{
    return a + b;
}
float diff(float a, float b)
{
    return a - b;
}
float prd(float a, float b)
{
    return a * b;
}
float quo(float a, float b)
{
    return a / b;
}
#define add sum
#define dalo sum
#define sub diff
#define nikalo diff
#define mul prd
#define zarb prd
#define div quo
int mod(float a, float b)
{
    if (b > a)
    {
        float temp = a;
        a = b, b = temp;
    }
    return fabs(remainder(a, b));
}
int isperfmod(float a, float b)
{
    return mod(a, b) == 0;
}
int isdiv(float of, float n)
{
    return mod(of, n) == 0;
}
#define isdivisor isdiv
float pct(float n1, float n2)
{
    if (n1 > n2)
        return (n1 * n2) / 100;
    else
        return (n1 / n2) * 100;
}
int iseven(float n)
{
    return isperfmod(n, 2);
}
int isodd(float n)
{
    return !isperfmod(n, 2);
}
int isprime(int n)
{
    for (int i = 2; i <= n / 2; i++)
    {
        if (n % i == 0)
            return 0;
    }
    return 1;
}
int Int(char *numeric_str)
{
    return atoi(numeric_str);
}
float Flt(char *numeric_str)
{
    return atof(numeric_str);
}
int randi()
{
    srand(time(NULL));
    return (rand() + 1) % 100;
}
float randf()
{
    return randi() * .3;
}
int randint(int max)
{
    srand(time(NULL));
    return (rand() + 1) % max;
}
float randflt(int max)
{
    srand(time(NULL));
    return ((rand() + 1) % max) * .3;
}
int randInt(int min_num, int max_num)
{
    int result = 0, low_num = 0, hi_num = 0;

    if (min_num < max_num)
    {
        low_num = min_num;
        hi_num = max_num + 1; // include max_num in output
    }
    else
    {
        low_num = max_num + 1; // include max_num in output
        hi_num = min_num;
    }

    srand(time(NULL));
    result = (rand() % (hi_num - low_num)) + low_num;
    return result;
}
float randFlt(int min_num, int max_num)
{
    int result = 0, low_num = 0, hi_num = 0;

    if (min_num < max_num)
    {
        low_num = min_num;
        hi_num = max_num + 1; // include max_num in output
    }
    else
    {
        low_num = max_num + 1; // include max_num in output
        hi_num = min_num;
    }

    srand(time(NULL));
    result = ((rand() % (hi_num - low_num)) + low_num) * .3;
    return result;
}
char *randstr(int len)
{
    int max = 800;
    srand(time(NULL));
    const char ALLOWED[] = "abcdefghijklmnopqrstuvwxyz1234567890";
    char result[max + 1];
    int i = 0,
        c = 0,
        nbAllowed = sizeof(ALLOWED) - 1;
    for (i = 0; i < max; i++)
    {
        c = rand() % nbAllowed;
        result[i] = ALLOWED[c];
    }
    result[max + 1] = '\0';
    return slice(result, 0, len);
}
int strHas(char *str, char *lookup) {
    char *p = strstr(str, lookup);
    if (p) return p-str;
    return 0;
}
#define strincl strHas
void reverseStr(char s[])
{
    int i, j;
    char k;

    for (i = 0, j = strlen(s) - 1; i < j; i++, j--)
    {
        k = s[i];
        s[i] = s[j];
        s[j] = k;
    }
}
void itoa(int n, char s[])
{
    int i, sign;
    if ((sign = n) < 0)
        n = -n;
    i = 0;
    do
    {
        s[i++] = n % 10 + '0';
    } while ((n /= 10) > 0);
    if (sign < 0)
        s[i++] = '-';
    s[i] = '\0';
    reverseStr(s);
}


//DATE METHODS
char *timegr(char *period, int hh)
{
    char *greeting = "";
    if (he(period, "pm"))
    {
        if (hh >= 9)
            greeting = "Good night!";
        else if (hh >= 4)
            greeting = "Good evening.";
        else
            greeting = "Good afternoon.";
    }
    else
    {
        if (hh >= 5)
            greeting = "Good morning!";
        else
            greeting = "Good start of a brand-new day!!";
    }
    return greeting;
}

typedef struct
{
    char *time, *timegreet, *period, *day, *date, *month, stamp[100];
    int mins, hours, dayAsNumber, isWeekend, year;
} Date;

Date new_date()
{
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[64];
    size_t ret = strftime(s, sizeof(s), "%c", tm);
    assert(ret);
    char *ampm = "am",
         *day = slice(s, 0, 3),
         *month = slice(s, 4, 7),
         *date = slice(s, 8, 10),
         *year = &s[20],
         *tim = slice(s, 11, 16);
    int hh = atoi(slice(tim, 0, 2));

    if (he(month, "jan"))
        strmilao(month, "uary");
    else if (he(month, "feb"))
        strmilao(month, "ruary");
    else if (he(month, "mar"))
        strmilao(month, "ch");
    else if (he(month, "apr"))
        strmilao(month, "il");
    else if (he(month, "may"))
        strmilao(month, "");
    else if (he(month, "jun"))
        strmilao(month, "e");
    else if (he(month, "jul"))
        strmilao(month, "y");
    else if (he(month, "aug"))
        strmilao(month, "ust");
    else if (he(month, "sep"))
        strmilao(month, "tember");
    else if (he(month, "oct"))
        strmilao(month, "ober");
    else if (he(month, "nov"))
        strmilao(month, "ember");
    else if (he(month, "dec"))
        strmilao(month, "ember");

    if (hh >= 12)
    {
        ampm = "pm";
        hh -= 12;
    }
    if (hh == 0)
        hh = 12;

    char hrs[] = "";
    itoa(hh, hrs);

    nai(date, connect(connect(connect(connect(month, " "), date), " "), year));
    join(join(join(date, " ("), day), ")");
    time_t ds = time(NULL);
    struct tm tmn;
    localtime_r(&ds, &tmn);
    char timestamp[100];
    strftime(timestamp, sizeof(timestamp), "%Y-%d-%m", &tmn);
    
    bool isWeekend = false;
    int dayAsNumber = 0;
    if (he(day, "sun")) {
        strmilao(day, "day");
        dayAsNumber = 0;
    }
    else if (he(day, "mon")) {
        strmilao(day, "day");
        dayAsNumber = 1;
    } else if (he(day, "tue")) {
        strmilao(day, "sday");
        dayAsNumber = 2;
    } else if (he(day, "wed")) {
        strmilao(day, "nesday");
        dayAsNumber = 3;
    } else if (he(day, "thu")) {
        strmilao(day, "rsday");
        dayAsNumber = 4;
    } else if (he(day, "fri")) {
        strmilao(day, "day");
        dayAsNumber = 5;
    } else {
        strmilao(day, "urday");
        dayAsNumber = 6;
    }

    if (dayAsNumber % 6 == 0)
        isWeekend = true;

    Date this;
    this.day = day;
    this.dayAsNumber = dayAsNumber;
    this.isWeekend = isWeekend;
    this.date = date;
    this.month = slice(month, 0, 5);
    this.year = atoi(year);
    this.time = merge(merge(merge(merge(hrs, ":"), slice(s, 14, 16)), " "), ampm);
    this.time = merge(slice(this.time, 0, strlen(this.time) - 3), ampm);
    this.hours = atoi(hrs);
    this.mins = atoi(slice(s, 14, 16));
    this.period = ampm;
    this.timegreet = timegr(ampm, atoi(hrs));
    strcpy(this.stamp, timestamp);
    merge(merge(merge(merge(this.stamp, "-"), slice(day, 0, 3)), "-"), this.time);
    strcpy(this.stamp, upper(replace(this.stamp, ":", "-")));
    return this;
}
int isWeekend()
{
    return new_date().isWeekend;
}
char *today()
{
    char *ptr = (char *)malloc(strlen(new_date().stamp)+1);
    strcpy(ptr, new_date().stamp);
    return ptr;
}
char *tareekh()
{
    return today();
}
char *din()
{
    return new_date().day;
}
#define salam new_date().timegreet
#define salaam salam
int age2birthyear(int age) {
    int birthyr = new_date().year - age;
    return birthyr && birthyr > 1.9e3 && birthyr < new_date().year ? birthyr : 0;
}
int birthyear2age(int bday) {
    int age = new_date().year - bday;
    return age && age < 1.2e2 ? age : 0;
}

//FILE METHODS
int createFile(char *fname, char *content)
{
    FILE *fptr;
    fptr = fopen(fname, "w");
    if (fprintf(fptr, "%s", content))
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File \"%s\" banai/update ki ja chuki he, apki farmaish pe.\n", fname);
        fclose(fptr);
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n❌ Shayad apko is directory me files banane ki permission nahi😔\n");
    fclose(fptr);
    return 0;
}
int newFile(char *fname, char *content)
{
    return createFile(fname, content);
}
char *readFile(char *fname)
{
    FILE *fptr;
    fptr = fopen(fname, "r");
    if (fptr)
    {
        char content[8192];
        char contents[8192];
        while (fgets(contents, sizeof(contents), fptr))
        {
            strcat(content, contents);
        }
        char *cptr = (char *)malloc(strlen(content)+1);
        strcpy(cptr, content);
        fclose(fptr);
        return cptr;
    }
    printf("\n[Message from HindC FileReader]:\n❌ File %s ko read karna na kaam raha. Mana ja sakta he, ya to apke pas file ko read karne ki permission nahi, ya to file ger mojood he.\n", fname);
    fclose(fptr);
    char *error = "\0";
    return error;
}
char *updateFile(char *fname, char *content)
{
    createFile(fname, content);
    printf("\n*New File Content*:\n");
    return readFile(fname);
}
char *appendToFile(char *fname, char *content)
{
    FILE *fptr;
    fptr = fopen(fname, "a");
    if (fprintf(fptr, "%s", content))
    {
        printf("\n[Message from HindC FileReader]:\n✔️Apki request mukammal rahi. As requested, source file me kuch tabdeelia lai ja chuki hen!\n[{Updated File}]: ");
        fclose(fptr);
        return readFile(fname);
    }
    printf("\n[Message from HindC FileReader]:\n❎ Failed! Shayad apko is directory me files banane ki mukammal ijaazat nahi😔\n");
    fclose(fptr);
    char *error = "\0";
    return error;
}
int deleteFile(char *fname)
{
    if (remove(fname) == 0)
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File %s ko delete karna kaamyaab raha.\n", fname);
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n❌ File \"%s\" ko remove karna na kaam raha. Ya apke pas file ko delete karne ki permission nahi, ya file he hi ger mojood.\n", fname);
    return 0;
}
int copyFile(char *src, char *dest)
{
    if (strcasecmp(src, dest) == 0)
    {
        printf("\n[Message from HindC FileReader]:\n⚠️ Cannot replace the source with the destination!\n");
        return 0;
    }
    int c;
    FILE *stream_R;
    FILE *stream_W;
    stream_R = fopen(src, "r");
    if (!stream_R || stream_R == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ Source file ki ger mojoodgi ki soorat, file ko copy/move/rename karna na kaam raha!\n");
        return 0;
    }
    stream_W = fopen(dest, "w");
    if (!stream_W || stream_W == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ File ko copy/move/rename karna na kaam raha!\n");
        fclose(stream_R);
        return 0;
    }
    while ((c = fgetc(stream_R)) != EOF)
    {
        fputc(c, stream_W);
    }
    fclose(stream_R);
    fclose(stream_W);
    return 1;
}
int renameFile(char *oldName, char *newName)
{
    if (copyFile(oldName, newName) && deleteFile(oldName))
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File renamed successfully\n");
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to rename!\n");
    return 0;
}
int moveFile(char *fname, char *dest)
{
    if (copyFile(fname, dest) && deleteFile(fname))
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File moved successfully\n");
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to move!\n");
    return 0;
}
int fileBanao(char *fname, char *content)
{
    return newFile(fname, content);
}
int naiFile(char *fname, char *content)
{
    return newFile(fname, content);
}
int fileHatao(char *fname, char *content)
{
    return deleteFile(fname);
}

//ARRAY METHODS
#define arrSecLast(arr) (arr[sizeof(arr)/sizeof(arr[0])-2])
#define arrLast(arr) (arr[sizeof(arr)/sizeof(arr[0])-1])
#define arrNthLast(arr, index) (arr[sizeof(arr)/sizeof(arr[0])-index])
#define arrReplaceStrAt(arr, index, replacement) (strcpy(arr[index], replacement))
#define arrReplaceStrAtLast(arr, index, replacement) (strcpy(arr[sizeof(arr)/sizeof(arr[0])-index], replacement))
#define arrReplaceIntAt(arr, index, replacement) (arr[index] = replacement)
#define arrReplaceIntAtLast(arr, index, replacement) (arr[sizeof(arr)/sizeof(arr[0])-index] = replacement)
#define arrPopStr(str) (strcpy(str[sizeof(str)/sizeof(str[0])-1], ""))
#define reverseArr(arr) (std::reverse(std::begin(arr), std::end(arr)))
#define randItem(arr) (arr[randint(sizeof(arr)/sizeof(arr[0]))])
#define randFrom randItem
void bubbleSort(int array[], int size) {
  phere int step barabar 0; step se_bare (size-1); step me_izafa 1 ka tabtak
    haal swappingKiZarurat barabar na;
    phere int i barabar 0; i se_bare (size-step-1); i me_izafa 1 ka or_run
      agar array[i] se_chote array[i + 1] hen to
        set swappingKiZarurat ab han;
        int temp bana array[i];
        array[i] bana array[i + 1];
        array[i + 1] bana temp;
      basab
    basab
    agar swappingKiZarurat nahi hen
      ruko;
  basab
}
#define bubbleSortAsc bubbleSort
void bubbleSortDesc(int array[], int size) {
  phere int step barabar 0; step se_bare (size-1); step me_izafa 1 ka tabtak
    haal swappingKiZarurat barabar na;
    phere int i barabar 0; i se_bare (size-step-1); i me_izafa 1 ka or_run
      agar array[i] se_bare array[i + 1] hen to
        set swappingKiZarurat ab han;
        int temp bana array[i];
        array[i] bana array[i + 1];
        array[i + 1] bana temp;
      basab
    basab
    agar swappingKiZarurat nahi hen
      ruko;
  basab
}
void printArr(char *arr[], int size) {
  for (int i = 0; i < size; ++i) {
    printf("%s\n", arr[i]);
  }
  br(1);
}
void printArrInt(int arr[], int size) {
  for (int i = 0; i < size; ++i) {
    printf("%d ", arr[i]);
  }
  br(1);
}
void printArrReversedInt(int arr[], int size) {
  size -= 1;
  //bugfix: we want the size not as a number, but as an index, and indexes always start with 0
  for (; size >= 0; size--) {
    print_i(arr[size]);
  }
}
#define printArrIntReverse printArrReversedInt

//Library GUI
typedef struct {
    char *name;
    char *version;
} App;
App new_app(char *name, char *version) {
    App my_app;
    my_app.name = name;
    my_app.version = version;
    return my_app;
}
App appMeta(char *name, char *version) {
    App my_app = new_app(name, version);
    Date dt = new_date();
    #ifdef CONIO_H
        recognize_colors();
    #endif
    kaho("\t\t><><><><><><>❤️<><><><><><\n\t\t|        HindC\n\t\t\t   by\n\t\t\t Khurram Ali\n\t\t>💗🌷<><><><><><><><>🌹💘<\n\t\t   =====================\n\t\t|\\/\t\t\t\\/|\n\n");
    kaho("%s%s v%s\t\t      © Licensed under MIT™\n", strlen(name) > 3 && strlen(name) < 15 ? name : "Sample", strlen(name) < 9 ? " App" : "", strlen(version) && strlen(version) < 9 ? version : "1.0.0");
	repeat_inline("<<", 30);
	br(2);
	#ifdef CONIO_H
        clr(peela);
    #endif
	kaho("Happy %s❤️,\t\t      %s\n\t\t\t\t       ___________________\n", strlen(dt.day) < 8 ? join(dt.day, "  ") : dt.day, dt.stamp);
    #ifdef CONIO_H
        clr(_def);
    #endif
	repeat_inline("^^", 30);
	br(2);
    return my_app;
}
App setMeta(char *name, char *version) {
    return appMeta(name, version);
}
App new_sample_app() {
    return setMeta("", "");
}
App new_custom_app(char *name, char *version) {
    return setMeta(name, version);
}
    

/*
int main()
{
    #ifdef CONIO_H
        recognize_colors();
    #endif
    char naam[] = "";
    pucho("Please enter your name: ", naam);
    agline();
    float numA = pucho_f("Pick a number: ");
    float numB = pucho_f("Pick number two: ");
    if (he(naam, "Hifazat"))
        naya(naam, "Sunny");
    cap(naam);
    #ifdef CONIO_H
        clr(hara);
    #endif
    kaho("%s,", naam);
    #ifdef CONIO_H
        clr(peela);
    #endif
    kaho("Sum = %.1f", numA + numB);
    #ifdef CONIO_H
        clr(shurwati);
    #endif
    kaho("Triangular area of %d, and %d: %d", 10, 60, tria(10, 60));
    repeat("test", 5);
    repeat_i(5, 5);
    kaho_f_inline(pct(400, 800));
    kaho("%%");
    kaho_n(randInt(5, 50));
    return 0;
}
*/
/*
C++-like functionality in C
int main(){
    string name = "Ayesha";
    flt height = 4.9;
    print("%s is %.1f ft. high", name, height);
}
*/
/*
int main()
{
    char *content = readFile("q2.c");
    print(content);
}
*/


/*
khu
    char name[] barabar "";
    pucho("Please apna naam share keejye? ", name);
    phere int i barabar 1; i chota_ya_barabar 5; i me_izafa 1 ka or_run
        kaho("hi %s, I'm counting... %d", name, i);
    basab
ram
*/
