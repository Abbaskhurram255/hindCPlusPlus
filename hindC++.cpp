#include <stdio.h>
#include <stdarg.h>
#include <string.h>
#include <cstring>
#include <stdbool.h>
#include <ctype.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#include <iostream>
#include <algorithm>
using namespace std;
using jumla = char*;
using jumlo = jumla;
using lafz = jumla;
using str = lafz;
using nr = double;
using dbl = nr;
using flt = float;
using ch = char;
using haal = bool;
#define out std::cout <<
#define farmaiye out
#define or_farmaiye out
#define farmao out
#define or_farmao out
#define keh out
#define or_keh out
#define kahie out
#define or_kahie out
#define kahen out
#define or_kahen out
#define bolie out
#define or_bolie out
#define bolen out
#define or_bolen out
#define farmayo out
#define aen_farmayo out
#define farmae out
#define aen_farmae out
#define chao out
#define aen_chao out
#define chau out
#define aen_chau out
#define ke "" <<
#define yar "" <<
#define or_yar << " " <<
#define aen_yar << " " <<
#define aur << " " <<
#define aen << " " <<
#define aage << " " <<
#define agya << " " <<
#define or_age << " " <<
#define aen_agya << " " <<
#define or_aage << " " <<
#define aen_agyo << " " <<
#define bas endl
#define or_bas or_age bas
#define age_bas or_bas
#define aage_bas or_bas
#define bas_re or_bas
#define aen_bas aen_agya bas
#define agya_bas aen_bas
#define agyo_bas aen_bas
#define akhir_me aen_bas
#define falaana ""
#define falaano ""
#define yes true
#define sach true
#define han true
#define hau true
#define no false
#define jhoot false
#define koor false
#define na false
#define nahi == false
#define nahe == false
#define na_ahe == false
#define agar_sach == true
#define agar_jhoot ""
#define agar_koor ""
#define nata_wari ""
#define bana =
#define bani =
#define bane =
#define be =
#define is_now =
#define ab =
#define ab_he =
#define hare =
#define hare_ahe =
#define he_ab =
#define ahe_hare
#define into =
#define exchange swap
#define hera_pheri swap
#define adla_badli swap
#define exists !!
#define mojood !!
#define sath , 
#define gad ,
#define or_sath &&
#define or_to_or &&
#define aur_to_aur &&
#define aen_gad &&
#define aen_ta_aen &&
#define gado_gad &&
#define karo do
#define kar do
#define ye {
#define hee {
#define sab }
#define jabtak while (
#define jesitae while (
#define jasitore while (
#define tabtak {
#define tesitae {
#define tesitore {
#define then {
#define to {
#define ta {
#define tab {
#define tadhen {
#define abbas }
#define hare_bas }
#define basab }
#define bas_hare }
#define khatm }
#define khatam }
#define ant }
#define ruko break
#define skip continue
#define phere for (
#define phera for (
#define karie )
#define keejye )
#define kario )
#define kayo )
#define kajo )
#define ka )
#define ko )
#define jo )
#define khe )
#define of (
#define or_run {
#define or_karo {
#define aen_kar {
#define agar if (
#define he )
#define hen )
#define ahe )
#define ahin )
#define nahi_to_agar } else if (
#define nahi_to } else {
#define nata_agar } else if (
#define nata } else {
#define agar_koi_na } else {
#define agar_sab_galat } else {
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
#define me_izafo +=
#define me_wij +=
#define me_wadhai +=
#define me_wadhio +=
#define me_wadhaiyo +=
#define me_wayo +=
#define me_ghatio -=
#define me_ghato -=
#define kha_wayo -=
#define kha_ghatio -=
#define kha_ghataiyo -=
#define kha_ghatae -=
#define ma_wayo -=
#define ma_ghatio -=
#define ma_ghataiyo -=
#define ma_ghatae -=
#define ma_kad -=
#define ma_wanyan -=
#define ma_nikto -=
#define ma_nikta -=
#define ma_nikre -=
#define ma_nikriya -=
#define ma_nikran -=
#define kha_nikto -=
#define kha_nikta -=
#define kha_nikre -=
#define kha_nikriya -=
#define kha_nikran -=
#define kha_wayo -=
#define kha_kad -=
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
#define na_barabar !=
#define zyada_ya_barabar >=
#define gharo_ya_barabar >=
#define ghara_ya_barabar >=
#define bara_ya_barabar >=
#define wado_ya_barabar >=
#define bare_ya_barabar >=
#define wada_ya_barabar >=
#define kam_ya_barabar <=
#define ghat_ya_barabar <=
#define chota_ya_barabar <=
#define nandho_ya_barabar <=
#define nandhro_ya_barabar <=
#define chote_ya_barabar <=
#define nandha_ya_barabar <=
#define nandhra_ya_barabar <=
#define se_bara <
#define se_bare <
#define se_bari <
#define se_chota >
#define se_chote >
#define se_choti >
#define kha_wado <
#define kha_wada <
#define kha_wadi <
#define kha_gharo <
#define kha_ghara <
#define kha_ghari <
#define kha_nandho >
#define kha_nandhro >
#define kha_nandha >
#define kha_nandhra >
#define kha_nandhi >
#define kha_nandhri >
#define se )
#define kha )
#define ma )
#define mau )
#define let auto
#define fn auto
#define func auto
#define farz auto
#define mano auto
#define re ;
#define ri ;
#define love ;
#define pyari ;
#define ji ;
#define object typedef struct
#define Object typedef struct
#define on int main() {
#define off }
#define shuru int main() {
#define shurwat int main() {
#define hind int main() {
#define sind int main() {
#define C }
#define co int main() {
#define de }
#define aye int main() {
#define sha }
#define set ;std::cout<<"";
#define hua ;std::cout<<"";
#define hui ;std::cout<<"";
#define hue ;std::cout<<"";
#define aap ;std::cout<<"";
#define tum ;std::cout<<"";
#define tu ;std::cout<<"";
#define tussi ;std::cout<<"";
#define larki ;std::cout<<"";
#define chori ;std::cout<<"";
#define behen ;std::cout<<"";
#define behna ;std::cout<<"";
#define baji ;std::cout<<"";
#define didi ;std::cout<<"";
#define kuri ;std::cout<<"";
#define kurio ;std::cout<<"";
#define kurie ;std::cout<<"";
#define yaara ;std::cout<<"";
#define tawheen ;std::cout<<"";
#define tawhan ;std::cout<<"";
#define adi ;std::cout<<"";
#define bhen ;std::cout<<"";
#define penji ;std::cout<<"";
#define aap ;std::cout<<"";
#define bhau ;std::cout<<"";
#define pagli ;std::cout<<"";
#define ba ;std::cout<<"";
#define baba ;std::cout<<"";
#define meri_jan ;std::cout<<"";
#define ayesha ;std::cout<<"";









#if defined __has_include
    #if __has_include (<conio.h>)
        #include <conio.h>
        int black = BLACK, red = RED, yellow = YELLOW, green = GREEN, blue = BLUE, white = WHITE, cyan = CYAN;
        int kala, kaala, lal, laal, peela, hara, nira, neera, sufed, safed, shurwati, _def, samandari;
        int kaaro, gaaro, peelo, saao, niro, neero, acho, asmaani;
        void recognize_colors()
        {
            kala = kaala = black, lal = laal = red, peela = yellow, hara = green, nira = neera = blue, safed = sufed = shurwati = _def = white, samandari = cyan,
            kaaro = black, gaaro = red, peelo = yellow, saao = green, niro = neero = blue, acho = shurwati = _def = white, asmaani = cyan;
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
    printf("%s", args);
    printf("\n");
}
void print(const char *args, ...)
{
    kaho(args);
}
void printf_inline(const char *args, ...)
{
    printf("%s", args);
}
void printf_nobr(const char *args, ...)
{
    printf_inline(args);
}
void printf_sameln(const char *args, ...)
{
    printf_inline(args);
}
void print_(const char *args, ...)
{
    printf_inline(args);
}
void print_inline(const char *args, ...)
{
    printf_inline(args);
}
void printf_i(const int args, ...)
{
    printf("%i", args);
    printf("\n");
}
void print_i(const int args, ...)
{
    printf_i(args);
}
void printf_i_inline(const int args, ...)
{
    printf("%i", args);
}
void printf_i_nobr(const int args, ...)
{
    printf_i_inline(args);
}
void printf_i_sameln(const int args, ...)
{
    printf_i_inline(args);
}
void print_i_inline(const int args, ...)
{
    printf_i_inline(args);
}
void printf_f(const float args, ...)
{
    printf("%.1f", args);
    printf("\n");
}
void print_f(const float args, ...)
{
    printf_f(args);
}
void printf_f_inline(const float args, ...)
{
    printf("%.1f", args);
}
void printf_f_nobr(const float args, ...)
{
    printf_f_inline(args);
}
void printf_f_sameln(const float args, ...)
{
    printf_f_inline(args);
}
void print_f_inline(const float args, ...)
{
    printf_f_inline(args);
}
void printf_n(const float args, ...)
{
    printf_f(args);
}
void print_n(const float args, ...)
{
    printf_f(args);
}
void printf_n_inline(const float args, ...)
{
    printf_f_inline(args);
}
void print_n_inline(const float args, ...)
{
    printf_f_inline(args);
}
void printf_n_nobr(const float args, ...)
{
    printf_f_inline(args);
}
void printf_n_sameln(const float args, ...)
{
    printf_f_inline(args);
}
void printf_b(const int args, ...)
{
    printf("%s", !args ? "false" : "true");
    printf("\n");
}
void print_b(const int args, ...)
{
    printf_b(args);
}
void printf_b_inline(const int args, ...)
{
    printf("%s", !args ? "false" : "true");
}
void printf_b_nobr(const int args, ...)
{
    printf_b_inline(args);
}
void printf_b_sameln(const int args, ...)
{
    printf_b_inline(args);
}
void print_b_inline(const int args, ...)
{
    printf_b_inline(args);
}
string puchoWord(string x) {
    std::string returnValue = "";
    std::cout << x;
    std::cin >> returnValue;
    return returnValue;
}
#define puchWord puchoWord
string pucho(string x) {
    std::string returnValue = "";
    std::cout << x;
    getline(std::cin, returnValue);
    return returnValue;
}
#define puch pucho
#define askline pucho
#define saveline pucho
#define askWord puchoWord
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
#define puch_i pucho_i
#define puch_c pucho_c
#define puch_f pucho_f
int puchoInt(char *x)
{
    return pucho_i(x);
}
char puchoCh(char *x)
{
    return pucho_c(x);
}
float puchFlt(char *x)
{
    return pucho_f(x);
}
#define puchInt puchoInt
#define puchCh puchoCh
#define puchFlt puchoFlt
#define scan pucho
#define scanWord puchoWord
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
#define ask pucho
#define askWord puchoWord
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
int askint(char *x)
{
    return pucho_i(x);
}
char askch(char *x)
{
    return pucho_c(x);
}
float askflt(char *x)
{
    return pucho_f(x);
}
void linechoro(int n)
{
    for (; n; n--)
        cout << endl;
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
        printf_inline(h);
}
void repeat_f(float h, int j)
{
    for (int i = 0; i < j; i++)
        printf("%.1f", h);
}
void repeat_f_inline(float h, int j)
{
    for (int i = 0; i < j; i++)
        printf_inline("%.1f", h);
}
void repeat_i(int h, int j)
{
    for (int i = 0; i < j; i++)
        printf("%i", h);
}
void repeat_i_inline(int h, int j)
{
    for (int i = 0; i < j; i++)
        printf_inline("%i", h);
}
void repeat_b(int h, int j)
{
    for (int i = 0; i < j; i++)
        printf("%s", !h ? "false" : "true");
}
void repeat_b_inline(int h, int j)
{
    for (int i = 0; i < j; i++)
        printf_inline("%s", !h ? "false" : "true");
}
#define duhrao repeat
#define duhrao_inline repeat_inline
#define duhrao_i repeat_i
#define duhrao_i_inline repeat_i_inline
#define duhrao_f repeat_f
#define duhrao_f_inline repeat_f_inline
#define duhrao_b repeat_b
#define duhrao_b_inline repeat_b_inline
#define duhrae duhrao
#define duhrae_inline duhrao_inline
#define duhrae_i duhrao_i
#define duhrae_i_inline duhrao_i_inline
#define duhrae_f duhrao_f
#define duhrae_f_inline duhrao_f_inline
#define duhrae_b duhrao_b
#define duhrae_b_inline duhrao_b_inline

//STRING METHODS
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
#define cap upper
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
int strEq(char *x, char *y)
{
    return strcasecmp(x, y) == 0;
}
char *naya(char *x, char *y)
{
    return strcpy(x, y);
}
#define nai naya
#define nao naya
char *concat(char *str1, char *str2)
{
    return strcat(str1, str2);
}
#define connect concat
#define join concat
#define merge concat
#define stradd concat
#define makeone concat
#define strmilao concat
#define strmilae concat
#define strjoro concat
int strAt(char *str, char *lookup) {
    char *p = strstr(str, lookup);
    if (p) return p-str;
    return -1;
}
int strHas(char *str, char *lookup) {
    return strAt(str, lookup) >= 0 && strAt(str, lookup) != -1;
}
#define strIncl strHas
#define in strHas
#define match strHas
#define matches strHas

//NUMBER METHODS
int isNumlike(char *str)
{
    int checks_passed = 0, all_checks_passed = 0;
    for (int i = 0; str[i]; i++)
    {
        char c = str[i];
        if (isdigit(c) || c == '.')
            checks_passed += 1;
    }
    all_checks_passed = checks_passed == strlen(str);
    return all_checks_passed;
}
int isIntlike(char *str)
{
    int checks_passed = 0, all_checks_passed = 0;
    for (int i = 0; str[i]; i++)
    {
        char c = str[i];
        if (isdigit(c))
            checks_passed += 1;
    }
    all_checks_passed = checks_passed == strlen(str);
    return all_checks_passed;
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
    }
    all_checks_passed = n_digits && n_periods;
    return all_checks_passed;
}
#define heNumjesa isNumlike
#define heIntjesa isIntlike
#define heFltjesa isFltlike
#define heNumjesi isNumlike
#define heIntjesi isIntlike
#define heFltjesi isFltlike

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
#define wij sum
#define sub diff
#define nikalo diff
#define kad diff
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
int isdiv(float of_n, float this_n)
{
    return mod(of_n, this_n) == 0;
}
#define isdivisor isdiv
int iseven(int n)
{
    return isperfmod(n, 2);
}
int isodd(int n)
{
    return !isperfmod(n, 2);
}
float pct(float n1, float n2)
{
    if (n1 > n2)
        return (n1 * n2) / 100;
    else
        return (n1 / n2) * 100;
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
typedef struct
{
    char *period, time[50], *timegreet, date[50], *day, *month, stamp[100];
    int mins, hours, dayAsNumber, isWeekend, year;
} Date;
Date new_date()
{
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[64];
    char timePartB[64];
    size_t ret = strftime(s, sizeof(s), "%c", tm);
    assert(ret);
    strftime(timePartB, sizeof(timePartB), ":%M:%S %p", tm);

    char *day = slice(s, 0, 3),
        *month = slice(s, 4, 7),
        *date = slice(s, 8, 10),
        *year = &s[20];
    if (strcasecmp(month, "jan") == 0)
        strcat(month, "uary");
    else if (strcasecmp(month, "feb") == 0)
        strcat(month, "ruary");
    else if (strcasecmp(month, "mar") == 0)
        strcat(month, "ch");
    else if (strcasecmp(month, "apr") == 0)
        strcat(month, "il");
    else if (strcasecmp(month, "may") == 0)
        strcat(month, "");
    else if (strcasecmp(month, "jun") == 0)
        strcat(month, "e");
    else if (strcasecmp(month, "jul") == 0)
        strcat(month, "y");
    else if (strcasecmp(month, "aug") == 0)
        strcat(month, "ust");
    else if (strcasecmp(month, "sep") == 0)
        strcat(month, "tember");
    else if (strcasecmp(month, "oct") == 0)
        strcat(month, "ober");
    else if (strcasecmp(month, "nov") == 0)
        strcat(month, "ember");
    else if (strcasecmp(month, "dec") == 0)
        strcat(month, "ember");

    char zz[] = " ";
    char *yearTemp = year;
    nai(date, connect(slice(connect(connect(connect(slice(month, 0, 3), connect(zz, date)), zz), year), 0, 7), year));
    strcat(strcat(strcat(date, " ("), day), ")");
    time_t ds = time(NULL);
    struct tm tmn;
    localtime_r(&ds, &tmn);
    char timestamp[100];
    strftime(timestamp, sizeof(timestamp), "%Y-%d-%m", &tmn);

    bool isWeekend = false;
    int dayAsNumber = 0;
    if (strcasecmp(day, "sun") == 0) {
        strcat(day, "day");
        dayAsNumber = 0;
    }
    else if (strcasecmp(day, "mon") == 0) {
        strcat(day, "day");
        dayAsNumber = 1;
    } else if (strcasecmp(day, "tue") == 0) {
        strcat(day, "sday");
        dayAsNumber = 2;
    } else if (strcasecmp(day, "wed") == 0) {
        strcat(day, "nesday");
        dayAsNumber = 3;
    } else if (strcasecmp(day, "thu") == 0) {
        strcat(day, "rsday");
        dayAsNumber = 4;
    } else if (strcasecmp(day, "fri") == 0) {
        strcat(day, "day");
        dayAsNumber = 5;
    } else {
        strcat(day, "urday");
        dayAsNumber = 6;
    }
    if (dayAsNumber % 6 == 0)
        isWeekend = true;

    string pd = "am";
    int hours = atoi(slice(s, 11, 13));
    if (hours >= 12)
    {
        pd = "pm";
        hours -= 12;
    }
    if (hours == 0)
        hours = 12;

    char *period = pd.data();
    string gtg = "";
    if (strcasecmp(period, "pm") == 0)
    {
        if (hours >= 9)
            gtg = "Hi, good night, sweet dreams!";
        else if (hours >= 4)
            gtg = "Good evening.";
        else
            gtg = "Good afternoon.";
    }
    else
    {
        if (hours >= 5)
            gtg = "Good morning!";
        else
            gtg = "Good start of a brand-new day!!";
    }

    char *greeting = gtg.data();

    char hrs[50];
    itoa(hours, hrs);
    char *curTime = stradd(hrs, timePartB);

    Date THIS;
    THIS.hours = hours;
    THIS.mins = atoi(slice(s, 14, 16));
    THIS.timegreet = greeting;
    strcpy(THIS.time, curTime);
    THIS.period = period;
    THIS.day = day;
    THIS.dayAsNumber = dayAsNumber;
    THIS.isWeekend = isWeekend;
    THIS.month = slice(month, 0, 5);
    THIS.year = atoi(yearTemp);
    strcpy(THIS.stamp, timestamp);
    strcat(strcat(THIS.stamp, "-"), slice(day, 0, 3));
    strcpy(THIS.stamp, upper(THIS.stamp));
    strcpy(THIS.date, THIS.stamp);
    return THIS;
}
int isWeekend()
{
    return new_date().isWeekend;
}
char *today() {
    char *ptr = (char *)malloc(strlen(new_date().stamp)+1);
    strcpy(ptr, new_date().stamp);
    return ptr;
}
#define tareekh today
char *din()
{
    return new_date().day;
}
#define deeh din
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
    string error = "\0";
    return error.data();
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
    string error = "\0";
    return error.data();
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
        printf("\n[Message from HindC FileReader]:\n❌ Source file ki ger mojoodgi ki soorat, file ko copy/move karna na kaam raha!\n");
        return 0;
    }
    stream_W = fopen(dest, "w");
    if (!stream_W || stream_W == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ File ko copy/move karna na kaam raha!\n");
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
    int renameSuccessful = rename(oldName, newName) == 0;
    if (renameSuccessful)
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File renamed successfully\n");
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to rename!\n");
    return 0;
}
int moveFile(char *fname, char *dest)
{
    if (renameFile(fname, dest))
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
void printArr(char arr[], int size) {
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  cout << "\n";
}
void printArrInt(int arr[], int size) {
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  cout << " ";
}
void printArrReversedInt(int arr[], int size) {
  size -= 1;
  //bugfix: we want the size not as a number, but as an index, and indexes always start with 0
  for (; size >= 0; size--) {
    cout << arr[size] << " ";
  }
  cout << " ";
}
#define printArrIntReverse printArrReversedInt
int strInArr(char *arr[], char *lookupStr, int length)
{
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupStr) return 1;
    }
    return 0;
}
int intInArr(int arr[], int lookupInt, int length)
{
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupInt) return 1;
    }
    return 0;
}
#define inArrStr strInArr
#define inArrInt intInArr

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
    printf("\t\t><><><><><><>❤️<><><><><><\n\t\t|        HindC++\n\t\t\t   by\n\t\t\t Khurram Ali\n\t\t>💗🌷<><><><><><><><>🌹💘<\n\t\t   =====================\n\t\t|\\/\t\t\t\\/|\n\n\n\n");
    printf("%s%s v%s\t\t      © Licensed under MIT™\n", strlen(name) > 3 && strlen(name) < 15 ? name : "Sample", strlen(name) < 9 ? " App" : "", strlen(version) && strlen(version) < 9 ? version : "1.0.0");
    string temp1 = "<<";
    repeat_inline(temp1.data(), 30);
    br(2);
    #ifdef CONIO_H
        clr(peela);
    #endif
    string temp2 = "Happy %s❤️,\t\t          %s\n\t\t\t\t       ___________________\n",
         temp3 = "  ";
     printf(temp2.data(), strlen(dt.day) < 8 ? join(dt.day, temp3.data()) : dt.day, dt.stamp);
    #ifdef CONIO_H
        clr(_def);
    #endif
    string temp4 = "^^";
    repeat_inline(temp4.data(), 30);
    br(2);
    return my_app;
}
App setMeta(char *name, char *version) {
    return appMeta(name, version);
}
App new_sample_app() {
    string temp = "";
    return setMeta(temp.data(), temp.data());
}
App new_custom_app(char *name, char *version) {
    return setMeta(name, version);
}
const string _app_name = "hindC++", 
    _app_version = "1.0.1",
    _app_vendor = "github.com/abbaskhurram255";


/*
int main()
{
    string username = ask("What's your username: ");
    int age = ask_i("How old are you: ");
    int birthyear = age2birthyear(age);

    kahen ke "Hey @" aage username aage ", aj " or_aage falaana aage tareekh() aage " he. Oh, to apki pedaish " aage birthyear or_age " ki he?" or_bas;
}
*/
/*
int main() {
    str s = "2 and 2 are equal";
    farz num barabar 2;

    agar num wakai_barabar (1+1) hen to
        kahie ke s or_bas;
        or_kahie "duh" akhir_me;
    nahi_to_agar num wakai_barabar (1-1) hen to
        kahen ke "not quite right, 2 is actually equivalent to 0" or_bas;
    agar_koi_na tab
      kahen ke "dono galat";
    basab

}
*/
/*
int main() {
    farz score barabar 40;

    haalat score ki
        surat 20 me
            kahie ke "Low on score";
            ruko;
        surat 40 me
            kahie ke "Moderate score";
            ruko;
        surat 70 me
            kahie ke "High on score";
            ruko;
    basab

    bolie ke "\nYour score: " or_age score or_bas;
}
*/
/*
    string word = puchoWord("Please enter a word: ") re
    bolie ke "You entered: " aage word aage_bas na
    kahie ke salaam;
}
*/
/*
co
    ayesha kahie "hi" aur " love" age_bas ji
    kahie 5 ji
de
*/


/*
func x() {
    return 1;
}

co
    farz i barabar x() pagli
    
    karo ye
        kahie "Ginti: " aur i aage_bas meri_jan
        i me_dalo 1 ayesha
    sab jabtak i chote_ya_barabar 5 hen ri
de
*/
/*
on
    int myInts[] = {1, 3, 5, 7};
    printArrReversedInt(myInts, arrlen(myInts));
off
*/
/*
co
    int x[] = {1, 3, 5, 7};
    kahie "int 5 in integer array \"x\": " aur intInArr(x, 5, arrlen(x)) age_bas;
    str arr[] = {"hi", "hola", "hallo", "ciao"};
    kahie "string \"helio\" in stringed array \"arr\":" aur strInArr(arr, "helio", arrlen(arr)) age_bas;
    kahie "string \"la\" in a string at index 1 from stringed array \"arr\":" aur in(arr[1], "la");
de
*/
/*
on
    farz n barabar 4 re
    agar n nandho_ya_barabar 2 ahe ta
        bhau chau "hakeekat, 4 2 kha nandha ahin" ba
    nata_agar n wakai_barabar 8/2 ahe ta
        bhau chau "4 ta asal me, 8 jo addu hundo ahe!" ji
    bas_hare
C
*/