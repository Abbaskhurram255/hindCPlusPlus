/*
    * LICENSED UNDER MIT: github.com/Abbaskhurram255/hindCPlusPlus/blob/main/LICENSE
    * Hardcoded by GitHub.com/abbaskhurram255
*/

//importing all the common internal libraries, so you DON'T have to. Next time, you can just import the library, without having the need to do any boilerplate initialization yourself: no more "#include <iostream>\nusing namespace std;"
#include <stdio.h>
#include <stdarg.h>
#include <cstring>
#include <string>
#include <regex>
#include <stdbool.h>
#include <ctype.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#include <iostream>
#include <sstream>
#include <algorithm>
#include <random>
#include <array>
#include <vector>

//declaring types
using namespace std;
using jumla = std::string;
using jumlo = jumla;
using lafz = jumla;
using String = jumla;
using str = jumla;
using dbl = double;
using flt = float;
using ch = char;
using haal = bool;

//initialization
#define array std::vector
#define char_array std::string
#define string_array std::vector<std::string>
#define integer_array std::vector<int>
#define float_array std::vector<float>
#define double_array std::vector<double>
#define ch_array std::string
#define str_array std::vector<std::string>
#define int_array std::vector<int>
#define flt_array std::vector<float>
#define dbl_array std::vector<double>
/*
int main() {
    str_array x = {"hi", "love"};
    int_array y = {1, 3, 5, 7};
    cout << x[0];
}
*/
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
#define enough or_bas
#define bas_re or_bas
#define aen_bas aen_agya bas
#define agya_bas aen_bas
#define agyo_bas aen_bas
#define akhir_me aen_bas
#define sout(x) ( ((std::stringstream&)(std::stringstream() << x )).str())
#define falaana ""
#define falaano ""
#define falaani ""
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
#define gaddu , 
#define or_sath &&
#define or_to_or &&
#define aur_to_aur &&
#define aen_gad &&
#define aen_ta_aen &&
#define gado_gad &&
#define par &&
#define para &&
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
#define jab_tak true&&
#define jesi_tae true&&
#define jesi_tore true&&
#define har for (
#define ever ;;)
#define ek auto
#define each auto
#define har_ek for (auto
#define harEk for (auto
#define for_each for (auto
#define forEach for (auto
#define from :
#define jo_hissa :
#define jeko_hisso :
#define jeki_hisso :
#define ka_he ) {
#define ki_he ) {
#define jo_ahe ) {
#define ke_lie ) {
#define lae ) {
#define je_lae ) {
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
#define cha if (
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
#define me_wadhae +=
#define me_wadhio +=
#define me_wadhaiyo +=
#define me_wayo +=
#define me_ghatio -=
#define me_ghaato -=
#define me_ghato -=
#define kha_wayo -=
#define kha_ghatio -=
#define kha_ghataiyo -=
#define kha_ghatae -=
#define ma_wayo -=
#define ma_ghatio -=
#define ma_ghaato -=
#define ma_ghatyo -=
#define ma_ghataiyo -=
#define ma_ghatae -=
#define ma_kad -=
#define ma_kaddu -=
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
#define kha_kaddu -=
#define koshish try
#define rukawat catch (...)
#define na_kami catch (...)
#define newError throw
#define nayaError throw
#define halat switch (
#define haalat switch (
#define ki ) {
#define wari ) {
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
#define ghano_ya_barabar >=
#define ghara_ya_barabar >=
#define ghana_ya_barabar >=
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
#define kha_ghano <
#define kha_ghara <
#define kha_ghana <
#define kha_ghari <
#define kha_ghani <
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
#define var auto
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
#define extends : public
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
#define haare ;std::cout<<"";
#define je ;std::cout<<"";
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
#define yara ;std::cout<<"";
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

//making getting length of a string, and array|vector easier
#define len(x) x.size()
#define arrlen len


//C-style prints, and helpers
string format(string fmt, ...) 
{ 
    va_list ap;
    va_start(ap, fmt);
    const size_t SIZE = 512;
    char buffer[SIZE] = { 0 };
    vsnprintf(buffer, SIZE, fmt.data(), ap);
    va_end(ap);
    string resultAsCppString = buffer;
    resultAsCppString += "\n";
    return resultAsCppString;
}
string format_inline(string fmt, ...) 
{ 
    va_list ap;
    va_start(ap, fmt);
    const size_t SIZE = 512;
    char buffer[SIZE] = { 0 };
    vsnprintf(buffer, SIZE, fmt.data(), ap);
    va_end(ap);
    string resultAsCppString = buffer;
    return resultAsCppString;
}
#define f format
#define f_inl format_inline
#define print cout <<
/*
on
    kahie sout("hi honey, " << "I heard you just turned 24!") << endl;
off
*/
/*
on
    str x = f("hi %s, I heard it's your %dth birthday", "love", 44);
    print x;
off
*/
void print_inline(string args, ...)
{
    printf("%s", args.data());
}
#define print_nobr print_inline
#define print_sameln print_inline
#define printStr print
#define printStrInline print_inline
#define kaho print
#define kaho_inline print_inline
#define kaho_nobr print_inline
#define kaho_sameln print_inline
void print_i(const int args, ...)
{
    printf("%i", args);
    printf("\n");
}
void print_i_inline(const int args, ...)
{
    printf("%i ", args);
}
#define print_i_nobr print_i_inline
#define print_i_sameln print_i_inline
#define printInt print_i
#define printIntInline print_i_inline
#define kaho_i print_i
#define kaho_i_inline print_i_inline
#define kaho_i_nobr print_i_inline
#define kaho_i_sameln print_i_inline
void print_f(const float args, ...)
{
    printf("%.1f", args);
    printf("\n");
}
void print_f_inline(const float args, ...)
{
    printf("%.1f ", args);
}
#define print_f_nobr print_f_inline
#define print_f_sameln print_f_inline
#define printFlt print_f
#define printFltInline print_f_inline
#define kaho_f print_f
#define kaho_f_inline print_f_inline
#define kaho_f_nobr print_f_inline
#define kaho_f_sameln print_f_inline
#define print_n print_f
#define print_n_inline print_f_inline
#define print_n_nobr print_f_inline
#define print_n_sameln print_f_inline
#define printN print_f
#define printNInline print_f_inline
#define kaho_n print_f
#define kaho_n_inline print_f_inline
#define kaho_n_nobr print_f_inline
#define kaho_n_sameln print_f_inline
void print_b(const int args, ...)
{
    printf("%s", !args ? "false" : "true");
    printf("\n");
}
void print_b_inline(const int args, ...)
{
    printf("%s ", !args ? "false" : "true");
}
#define print_b_nobr print_b_inline
#define print_b_sameln print_b_inline
#define printBool print_b
#define printBoolInline print_b_inline
#define kaho_b print_b
#define kaho_b_inline print_b_inline
#define kaho_b_nobr print_b_inline
#define kaho_b_sameln print_b_inline
void print_c(const char args, ...)
{
    printf("%c", args);
    printf("\n");
}
void print_c_inline(const char args, ...)
{
    printf("%c", args);
}
#define print_c_nobr print_c_inline
#define print_c_sameln print_c_inline
#define printChar print_c
#define printCharInline print_c_inline
#define kaho_c print_c
#define kaho_c_inline print_c_inline
#define kaho_c_nobr print_c_inline
#define kaho_c_sameln print_c_inline

//prompts
string puchoWord(string x) {
    std::string returnValue = "";
    std::cout << x;
    std::cin >> returnValue;
    return returnValue;
}
#define puchoLafz puchoWord
#define puchLafz puchoWord
#define puchWord puchoWord
#define puchuLafz puchoWord
#define puchuWord puchoWord
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
int pucho_i(string x)
{
    int y = 0;
    printf("\n%s\n", x.data());
    scanf("%i", &y);
    return y;
}
char pucho_c(string x)
{
    char y;
    printf("\n%s\n", x.data());
    scanf("%s", &y);
    return y;
}
float pucho_f(string x)
{
    float y = 0;
    printf("\n%s\n", x.data());
    scanf("%f", &y);
    return y;
}
#define puch_i pucho_i
#define puch_c pucho_c
#define puch_f pucho_f
#define puchu_i pucho_i
#define puchu_c pucho_c
#define puchu_f pucho_f
int puchoInt(string x)
{
    return pucho_i(x.data());
}
char puchoCh(string x)
{
    return pucho_c(x.data());
}
float puchoFlt(string x)
{
    return pucho_f(x.data());
}
#define puchInt puchoInt
#define puchCh puchoCh
#define puchFlt puchoFlt
#define scan pucho
#define scanWord puchoWord
int scan_i(string x)
{
    return pucho_i(x.data());
}
char scan_c(string x)
{
    return pucho_c(x.data());
}
float scan_f(string x)
{
    return pucho_f(x.data());
}
#define ask pucho
#define askWord puchoWord
int ask_i(string x)
{
    return pucho_i(x.data());
}
char ask_c(string x)
{
    return pucho_c(x.data());
}
float ask_f(string x)
{
    return pucho_f(x.data());
}
int askint(string x)
{
    return pucho_i(x.data());
}
char askch(string x)
{
    return pucho_c(x.data());
}
float askflt(string x)
{
    return pucho_f(x.data());
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
void next()
{
    agline();
}
void br(int n)
{
    linechoro(n);
}
void tb(int n)
{
    for (; n; n--)
        printf("\t");
}
void repeat(string h, int j)
{
    for (; j; j--)
        printf("%s\n", h.data());
}
void repeat_inline(string h, int j)
{
    for (; j; j--)
        printf("%s", h.data());
}
void repeat_i(int h, int j)
{
    for (; j; j--)
        print_i(h);
}
void repeat_i_inline(int h, int j)
{
    for (; j; j--)
        print_i_inline(h);
}
void repeat_f(float h, int j)
{
    for (; j; j--)
        print_f(h);
}
void repeat_f_inline(float h, int j)
{
    for (; j; j--)
        print_f_inline(h);
}
void repeat_c(char h, int j)
{
    for (; j; j--)
        print_c(h);
}
void repeat_c_inline(char h, int j)
{
    for (; j; j--)
        print_c_inline(h);
}
void repeat_b(int h, int j)
{
    for (; j; j--)
        printf("%s\n", !h ? "false" : "true");
}
void repeat_b_inline(int h, int j)
{
    for (; j; j--)
        printf("%s", !h ? "false" : "true");
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
template <typename T> string Str(T to_turn)
{
    //helps force turn any type into a string
    try {
        ostringstream ost;
        ost << to_turn;
        return ost.str();
    } catch (...) {
        return "";
    }
}
/*
@params:
    @to_turn: any
@returnVal: std::string
@test:
on
    string temp = Str(38);
    cout << "Today is " + temp + " degree Celsius outside";
off
*/
string_array split(const std::string str, const std::string regex_or_str) {

    std::regex regexz(regex_or_str);

    return {
        std::sregex_token_iterator(str.begin(), str.end(), regexz, -1),

        std::sregex_token_iterator()
    };
}
string_array splitIntoWords(string str) {
    let words = split(str, "[^\\w]+");
    return words;
}
/*
@params:
    @@str: string
        @@regex_or_str|delimiter|token_to_break_with: string|regex
@returnVal:
    vector<string> {iterable}
@test:
on
    string sentence = "Love, I bet you remember our first kiss- - under-the-rain";
    let words = split(sentence, "\\W+");
    print words[7];
off
*/
fn join(str_array x, string delim) {
    str result;
    for (let item from x) {
        result += delim + Str(item);
    }
    return result;
}
fn join(int_array x, string delim) {
    str result;
    for (let item from x) {
        result += delim + Str(item);
    }
    return result;
}
fn join(flt_array x, string delim) {
    str result;
    for (let item from x) {
        result += delim + Str(item);
    }
    return result;
}
fn join(dbl_array x, string delim) {
    str result;
    for (let item from x) {
        result += delim + Str(item);
    }
    return result;
}
/*
on
    int_array x = {1, 3, 5};
    print join(x);
off
*/
string slice(string str, int start, int end)
{
    int i;
    int size = end - start;
    char *output = (char *)malloc(size * sizeof(char));
    for (i = 0; start <= end; start++, i++)
    {
        output[i] = str[start];
    }
    output[size] = '\0';
    string resultAsCppString = output;
    return resultAsCppString;
}
string trim(string str, int start, int end)
{
    return slice(str, start, end);
}
string sliceTo(string str, string that_part_of_the_string)
{
    string result = strstr(str.data(), that_part_of_the_string.data());
    return result;
}
#define trimUntilMatch sliceTo
string sliceToAfter(string str, string that_part_of_the_string)
{
    string result = sliceTo(str, that_part_of_the_string);
    result = slice(result, that_part_of_the_string.length(), str.length());
    return result;
}
/*
@params: 
    @str|origin: string
    @that_part_of_the_string: 
@returnVal:
    if @that_part_of_the_string exists within @str|origin: new string with the first part torn away
    else: returns @str|origin back
@test:
on
    str testStr = "hi love, how's it going?";
    str y = sliceTo(testStr, "how's");
    print y;
off
*/
string replace(string str, const string &_this_string, const string &_that_string) {
    size_t start_pos = str.find(_this_string);
    str.replace(start_pos, _this_string.length(), _that_string);
    return str;
}
string replaceAll(string str, const string &toRemove, const string &toInsert) 
{
    string::size_type pos = 0;
    while ((pos = str.find(toRemove, pos)) != string::npos)
    {
        str.replace(pos, toRemove.size(), toInsert);
        pos++;
    }
    return str;
}
string replaceMutate(string &str, const string &_this_string, const string &_that_string) {
    size_t start_pos = str.find(_this_string);
    str.replace(start_pos, _this_string.length(), _that_string);
    return str;
}
string replaceAllMutate(string &str, const string &toRemove, const string &toInsert) 
{
    string::size_type pos = 0;
    while ((pos = str.find(toRemove, pos)) != string::npos)
    {
        str.replace(pos, toRemove.size(), toInsert);
        pos++;
    }
    return str;
}
#define replaceMutateAll replaceAllMutate
string reg_replace(string &str, string regex, string replacement) {
    str = std::regex_replace(str, std::regex(regex), replacement);
    return str;
}
string strRemove(string &str, const string &toRemove) {
    return replaceMutate(str, toRemove, "");
}
string strRemoveAll(string &str, const string &toRemove) {
    return replaceAllMutate(str, toRemove, "");
}
/*
test:
on
    string sentence = "Hi {name}, {she} said {girlPronoun} loves you. I was like what'd you see in {name}? And {girlPronoun} goes, \"{name} \'s the best boyfriend I could ever have, as {boyPronoun} loves me to the moon and back.\"";
    replaceAllMutate(sentence, "{name}", "Max");
    replaceAllMutate(sentence, "{she}", "Jenny");
    replaceAllMutate(sentence, "{boyPronoun}", "he");
    replaceAllMutate(sentence, "{girlPronoun}", "she");
    print sentence;
off
*/
string nformat(int n) {
    string str = Str(n);
    if (str.size() == 4) str = reg_replace(str, "\\d(?=\\d{3}$)", "$&,");
    else if (str.size() == 5) str = reg_replace(str, "\\d(?=\\d{3}$)", "$&,");
    else if (str.size() == 6) str = reg_replace(str, "\\d(?=\\d{5}$)|\\d(?=\\d{3}$)", "$&,");
    else if (str.size() == 7) str = reg_replace(str, "\\d(?=\\d{5}$)|\\d(?=\\d{3}$)", "$&,");
    else str = "";
    return str;
}
on
    print nformat(8000000);
off
string randstr()
{
    int max = 800;
    srand(time(NULL));
    const char ALLOWED[] = "abcdefghijklmnopqrstuvwxyz1234567890";
    char rst[max + 1];
    int i = 0,
        c = 0,
        nbAllowed = sizeof(ALLOWED) - 1;
    for (i = 0; i < max; i++)
    {
        c = rand() % nbAllowed;
        rst[i] = ALLOWED[c];
    }
    rst[max + 1] = '\0';
    char *rstt = rst;
    string result = rstt;
    string resultAsCppString = slice(result, 0, 32);
    return resultAsCppString;
}
string randStr(int len)
{
    int max = 800;
    srand(time(NULL));
    const char ALLOWED[] = "abcdefghijklmnopqrstuvwxyz1234567890";
    char rst[max + 1];
    int i = 0,
        c = 0,
        nbAllowed = sizeof(ALLOWED) - 1;
    for (i = 0; i < max; i++)
    {
        c = rand() % nbAllowed;
        rst[i] = ALLOWED[c];
    }
    rst[max + 1] = '\0';
    char *rstt = rst;
    string result = rstt;
    string resultAsCppString = slice(result, 0, len);
    return resultAsCppString;
}
string reverseStr(string s)
{
    char k;
    for (int i = 0, j = strlen(s.data()) - 1; i < j; i++, j--)
    {
        k = s.data()[i];
        s.data()[i] = s.data()[j];
        s.data()[j] = k;
    }
    return s;
}
#define reverse_str reverseStr
#define itoa std::to_string
string upper(string str)
{
    for (int i = 0; i < strlen(str.data()); i++)
        str[i] = toupper(str[i]);
    return str;
}
#define cap upper
string lower(string str)
{
    for (int i = 0; i < strlen(str.data()); i++)
        str[i] = tolower(str[i]);
    return str;
}
string sentCase(string str)
{
    char c = toupper(str[0]);
    string sliced = slice(str, 1, strlen(str.data()));
    char firstChar[96] {c, '\0'};
    string result = firstChar + sliced;
    return result;
}
#define sent_case sentCase
string strPop(string str)
{
    str[strlen(str.data()) - 1] = '\0';
    string result = str;
    return result;
}
#define str_pop strPop
int strEq(string x, string y)
{
    return strcasecmp(x.data(), y.data()) == 0;
}
#define str_eq strEq
string naya(string x, string y)
{
    string resultAsCppString = strcpy(x.data(), y.data());
    return resultAsCppString;
}
#define nai naya
#define nao naya
string concat(string str1, string str2)
{
    string result = str1 + str2;
    return result;
}
#define merge concat
#define strmilao concat
#define strmilae concat
#define ek_bane concat
int strAt(string str, string lookup) {
    char *p = strstr(str.data(), lookup.data());
    if (p) return p-str.data();
    return -1;
}
int strAtInsens(string str, string lookup) {
    str = lower(str);
    lookup = lower(lookup);
    char *p = strstr(str.data(), lookup.data());
    if (p) return p-str.data();
    return -1;
}
int strHas(string str, string lookup) {
    //-1 means not an index in the string
    return strAt(str, lookup) != -1 || strAt(str, lookup) >= 0;
}
int strHasInsens(string str, string lookup) {
    //-1? Not an index!
    return strAtInsens(str, lookup) != -1 || strAtInsens(str, lookup) >= 0;
}
#define strIndex strAt
#define strIndexInsens strAtInsens
#define match strHas
#define matches strHas
#define strMatch strHas
#define strMatchInsens strHasInsens
#define strIncl strHas
#define strInclInsens strHasInsens
#define str_has strHas
#define str_at strHas
#define str_index strAt
#define str_indexOf strAt
#define str_indexOf_insens strAt
#define str_index_of strAt
#define indexOf strAt
#define indexOfInsens strAtInsens
#define index_of strAt
#define index_of_insens strAtInsens
#define insens_index_of
#define str_incl strHas
#define in strHasInsens

//NUMBER METHODS
int Int(string numeric_str)
{
    return atoi(numeric_str.data());
}
float Flt(string numeric_str)
{
    return atof(numeric_str.data());
}
double Pos(double n) {
    return fabs(n);
}
double Neg(double n) {
    return -n;
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
    return result;;
}
int *range(int n) {
    static int arr[32768] = {};
    for (int i=0; i<n+1; i++)
        arr[i] = i+1;
    return arr;
}
int isNumlike(string str)
{
    int checks_passed = 0, all_checks_passed = 0;
    for (int i = 0; i<str.length(); i++)
    {
        char c = str[i];
        if (isdigit(c) || c == '.')
            checks_passed += 1;
    }
    all_checks_passed = checks_passed == strlen(str.data());
    return all_checks_passed;
}
int isIntlike(string str)
{
    int checks_passed = 0, all_checks_passed = 0;
    for (int i = 0; i<str.length(); i++)
    {
        char c = str[i];
        if (isdigit(c))
            checks_passed += 1;
    }
    all_checks_passed = checks_passed == strlen(str.data());
    return all_checks_passed;
}
int isFltlike(string str)
{
    int n_digits = 0, n_periods = 0, all_checks_passed = 0;
    for (int i = 0; i<str.length(); i++)
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
auto tria(double base, double height)
{
    return area(base, height) / 2;
}
auto sum(double a, double b)
{
    return a + b;
}
auto diff(double a, double b)
{
    return a - b;
}
auto prd(double a, double b)
{
    return a * b;
}
auto quo(double a, double b)
{
    return a / b;
}
#define add sum
#define dalo sum
#define joro sum
#define jor sum
#define wij sum
#define dif diff
#define sub diff
#define nikalo diff
#define kad diff
#define mul prd
#define zarb prd
#define div quo
#define toro quo
#define wand quo
#define wanda quo
#define hissa quo
#define hisso quo
#define adha(n) (n/2)
#define chotha(n) (n/4)
int mod(double a, double b)
{
    if (b > a)
    {
        float temp = a;
        a = b, b = temp;
    }
    return fabs(remainder(a, b));
}
int isperfmod(double a, double b)
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
#define baddi iseven
#define ikki isodd
auto pct(double n1, double n2)
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
#define ctof(c) (round(1.8 * c + 32))
#define ftoc(f) (round(((f - 32) * 5) / 9))
/*
co
    print ftoc(98);
de
*/

//DATE METHODS
typedef struct
{
    string period, time, timegreet, date, day, month, season, stamp;
    int mins, hours, dayAsIndex, isWeekend, isLeapYear, year;
} Date;
Date new_date()
{
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[128];
    char timePartB[128];
    size_t ret = strftime(s, sizeof(s), "%c", tm);
    assert(ret);
    strftime(timePartB, sizeof(timePartB), ":%M:%S %p", tm);

    string day = slice(s, 0, 3),
        month = slice(s, 4, 7),
        date = slice(s, 8, 10),
        year = &s[20];
    
    string season;
    if (str_eq(month, "may") || str_eq(month, "jun") || str_eq(month, "jul") || str_eq(month, "aug")) season = "Summer";
	else if (str_eq(month, "sep") || str_eq(month, "oct")) season = "Spring";
	else if (str_eq(month, "nov") || str_eq(month, "dec") || str_eq(month, "jan") || str_eq(month, "feb")) season = "Winter";
	else season = "Fall";
        
    if (str_eq(month, "jan")) {
        month += "uary";
    } else if (str_eq(month, "feb")) {
        month += "ruary";
    } else if (str_eq(month, "mar")) {
        month += "ch";
    } else if (str_eq(month, "apr")) {
        month += "il";
    } else if (str_eq(month, "may")) {
        month += "";
    } else if (str_eq(month, "jun")) {
        month += "e";
    } else if (str_eq(month, "jul")) {
        month += "y";
    } else if (str_eq(month, "aug")) {
        month += "ust";
    } else if (str_eq(month, "sep")) {
        month += "tember";
    } else if (str_eq(month, "oct")) {
        month += "ober";
    } else if (str_eq(month, "nov")) {
        month += "ember";
    } else if (str_eq(month, "dec")) {
        month += "ember";
    }

    date = day + ", " + month + " " + date + ", " + year;
    time_t ds = time(NULL);
    struct tm tmn;
    localtime_r(&ds, &tmn);
    char tms[128];
    strftime(tms, sizeof(tms), "%Y-%d-%m", &tmn);
    string timestamp = tms;

    bool isWeekend = false;
    int dayAsIndex = 0;
    if (str_eq(day, "sun")) {
        day += "day";
        dayAsIndex = 0;
    }
    else if (str_eq(day, "mon")) {
        day += "day";
        dayAsIndex = 1;
    } else if (str_eq(day, "tue")) {
        day += "sday";
        dayAsIndex = 2;
    } else if (str_eq(day, "wed")) {
        day += "nesday";
        dayAsIndex = 3;
    } else if (str_eq(day, "thu")) {
        day += "rsday";
        dayAsIndex = 4;
    } else if (str_eq(day, "fri")) {
        day += "day";
        dayAsIndex = 5;
    } else {
        day += "urday";
        dayAsIndex = 6;
    }
    if (dayAsIndex % 6 == 0)
        isWeekend = true;

    string period = "am";
    int hours = Int(slice(s, 11, 13));
    if (hours >= 12)
    {
        period = "pm";
        hours -= 12;
    }
    if (hours == 0)
        hours = 12;

    string gtg = "";
    if (str_eq(period, "pm"))
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

    string hrs = std::to_string(hours);
    string curTime = strcat(hrs.data(), timePartB);
    int isLeapYear = Int(year) % 4 == 0;


    Date THIS;
    THIS.hours = hours;
    THIS.mins = Int(slice(s, 14, 16));
    THIS.timegreet = gtg;
    THIS.time = curTime;
    THIS.period = period;
    THIS.day = day;
    THIS.dayAsIndex = dayAsIndex;
    THIS.isWeekend = isWeekend;
    THIS.month = slice(month, 0, 5);
    THIS.season = season;
    THIS.isLeapYear = isLeapYear;
    THIS.year = Int(year);
    THIS.stamp = upper(slice(day, 0, 3) + "-" + timestamp);
    THIS.date = date;
    return THIS;
}
void date_log() {
    Date d = new_date();
    cout << "Hour: " << d.hours << "\nMins: " << d.mins << "\nTimegreet: "  << d.timegreet << "\nTime: " << d.time << "\nPeriod: " << d.period << "\nDay: " << d.day << "\nDay as index: " << d.dayAsIndex << "\nisWeekend: " << d.isWeekend << "\nMonth: " << d.month << "\nSeason: " << d.season << "\nIs leap year: " << d.isLeapYear << "\nYear: " << d.year << "\nStamp: " << d.stamp << "\nDate: " << d.date << endl;
}
/*
on
    date_log();
off
*/
int isWeekend()
{
    return new_date().isWeekend;
}
string today() {
    char *ptr = (char *)malloc(strlen(new_date().stamp.data())+1);
    strcpy(ptr, new_date().stamp.data());
    string result = ptr;
    return result;
}
#define tareekh today
string din()
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
int createFile(string fname, string content)
{
    FILE *fptr;
    fptr = fopen(fname.data(), "w");
    if (fprintf(fptr, "%s", content.data()))
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File \"%s\" banai/update ki ja chuki he, apki farmaish pe.\n", fname.data());
        fclose(fptr);
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n❌ Shayad apko is directory me files banane ki permission nahi😔\n");
    fclose(fptr);
    return 0;
}
int newFile(string fname, string content)
{
    return createFile(fname, content);
}
string readFile(string fname)
{
    FILE *fptr;
    fptr = fopen(fname.data(), "r");
    if (fptr)
    {
        string content;
        string contents;
        while (fgets(contents.data(), sizeof(contents.data()), fptr))
        {
            content += contents;
        }
        char *cptr = (char *)malloc(strlen(content.data())+1);
        strcpy(cptr, content.data());
        fclose(fptr);
        string resultAsCppString = cptr;
        return resultAsCppString;
    }
    printf("\n[Message from HindC FileReader]:\n❌ File %s ko read karna na kaam raha. Mana ja sakta he, ya to apke pas file ko read karne ki permission nahi, ya to file ger mojood he.\n", fname.data());
    fclose(fptr);
    string error = "\0";
    return error.data();
}
string updateFile(string fname, string content)
{
    createFile(fname, content);
    printf("\n*New File Content*:\n");
    return readFile(fname);
}
string appendToFile(string fname, string content)
{
    FILE *fptr;
    fptr = fopen(fname.data(), "a");
    if (fprintf(fptr, "%s", content.data()))
    {
        printf("\n[Message from HindC FileReader]:\n✔️Apki request mukammal rahi. As requested, source file me kuch tabdeelia lai ja chuki hen!\n[{Updated File}]: ");
        fclose(fptr);
        return readFile(fname);
    }
    printf("\n[Message from HindC FileReader]:\n❎ Failed! Shayad apko is directory me files banane ki mukammal ijaazat nahi😔\n");
    fclose(fptr);
    string error = "\0";
    return error;
}
int deleteFile(string fname)
{
    int successInRemoval = remove(fname.data()) == 0;
    if (successInRemoval)
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File %s ko delete karna kaamyaab raha.\n", fname.data());
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n❌ File \"%s\" ko remove karna na kaam raha. Ya apke pas file ko delete karne ki permission nahi, ya file he hi ger mojood.\n", fname.data());
    return 0;
}
int copyFile(string src, string dest)
{
    if (str_eq(src.data(), dest.data()))
    {
        printf("\n[Message from HindC FileReader]:\n⚠️ Source matches destination, unable to replace the source file with the destination file!\n");
        return 0;
    }
    int c;
    FILE *stream_R;
    FILE *stream_W;
    stream_R = fopen(src.data(), "r");
    if (!stream_R || stream_R == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ Source file ki ger mojoodgi ki soorat, file ko copy/move karna na kaam raha!\n");
        return 0;
    }
    stream_W = fopen(dest.data(), "w");
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
int renameFile(string oldName, string newName)
{
    int renameSuccessful = (rename(oldName.data(), newName.data()) == 0);
    if (renameSuccessful)
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File renamed successfully\n");
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to rename!\n");
    return 0;
}
int moveFile(string fname, string dest)
{
    if (renameFile(fname.data(), dest.data()))
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File moved successfully\n");
        return 1;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to move!\n");
    return 0;
}
int fileBanao(string fname, string content)
{
    return newFile(fname, content);
}
int naiFile(string fname, string content)
{
    return newFile(fname, content);
}
int fileHatao(string fname)
{
    return deleteFile(fname);
}

//Arrays
#define push(arr, el) arr.push_back(el)
#define pushStart(arr, el) arr.insert(arr.begin(), el)
#define pushAt(arr, i, el) arr.insert(arr.begin() + i, el)
#define shift(arr) arr.erase(arr.begin())
#define pop(arr) arr.pop_back()
#define popAt(arr, i) arr.erase(arr.begin + i)
#define arrSecLast(arr) (arr[arr.size()-2])
#define arrLast(arr) (arr[arr.size()-1])
#define arrNthLast(arr, index) (arr[arr.size()-index])
#define arrReplaceAtLast(arr, index, replacement) (arr[arr.size()-index] = replacement)
#define reverseArr(arr) (std::reverse(arr.begin(), arr.end()))
#define shuffleArr(arr) (std::shuffle(arr.begin(), arr.end(), std::default_random_engine{}))
#define randItem(arr) (arr[randint(arr.size()-1)])
#define randFrom randItem
//work for strings as well:
#define sortAsc(arr) std::sort(arr.begin(), arr.end())
#define sortDesc(arr) std::sort(arr.rbegin(), arr.rend())
#define sort sortAsc
//get min/max
int minAmongInts(int_array nums) {
  auto min = nums[0];
  for (auto n : nums) {
    if (n < min) min = n;
  }
  return min;
}
flt minAmongFlts(flt_array nums) {
  auto min = nums[0];
  for (auto n : nums) {
    if (n < min) min = n;
  }
  return min;
}
dbl minAmongDbls(dbl_array nums) {
  auto min = nums[0];
  for (auto n : nums) {
    if (n < min) min = n;
  }
  return min;
}
int maxAmongInts(int_array nums) {
  auto max = nums[0];
  for (auto n : nums) {
    if (n > max) max = n;
  }
  return max;
}
flt maxAmongFlts(flt_array nums) {
  auto max = nums[0];
  for (auto n : nums) {
    if (n > max) max = n;
  }
  return max;
}
dbl maxAmongDbls(dbl_array nums) {
  auto max = nums[0];
  for (auto n : nums) {
    if (n > max) max = n;
  }
  return max;
}
void printArrStr(string_array arr) {
  int size = arr.size();
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << "\n";
  }
  br(1);
}
void printArrInt(int_array arr) {
  int size = arr.size();
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  br(1);
}
void printArrFlt(float_array arr) {
  int size = arr.size();
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  br(1);
}
void printArrDbl(double_array arr) {
  int size = arr.size();
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  br(1);
}
#define printStrArr printArrStr
#define printIntArr printArrInt
#define printFltArr printArrFlt
#define printDblArr printArrDbl
void printArrReversedInt(int_array arr) {
  int size = arr.size()-1;
  //bugfix: we need the last element, not the length of the array, as that would get us a null character
  for (; size >= 0; size--) {
    cout << arr[size] << " ";
  }
  br(1);
}
void printArrReversedFlt(flt_array arr) {
  int size = arr.size()-1;
  //bugfix: we need the last element, not the length of the array, as that would get us a null character
  for (; size >= 0; size--) {
    cout << arr[size] << " ";
  }
  br(1);
}
void printArrReversedDbl(double_array arr) {
  int size = arr.size()-1;
  //bugfix: we need the last element, not the length of the array, as that would get us a null character
  for (; size >= 0; size--) {
    cout << arr[size] << " ";
  }
  br(1);
}
#define printIntArrReversed printArrReversedInt
#define printArrIntReversed printArrReversedInt
#define printReversedIntArr printArrReversedInt
#define reversePrintIntArr printArrReversedInt
#define printFltArrReversed printArrReversedFlt
#define printArrFltReversed printArrReversedFlt
#define printReversedFltArr printArrReversedFlt
#define reversePrintFltArr printArrReversedFlt
#define printDblArrReversed printArrReversedDbl
#define printArrDblReversed printArrReversedDbl
#define printReversedDblArr printArrReversedDbl
#define reversePrintDblArr printArrReversedDbl
int strInArr(string_array arr, string lookupStr)
{
    int length = len(arr);
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupStr) return 1;
    }
    return 0;
}
int intInArr(int_array arr, int lookupInt)
{
    int length = len(arr);
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupInt) return 1;
    }
    return 0;
}
int intInArr(float_array arr, int lookupInt)
{
    int length = len(arr);
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupInt) return 1;
    }
    return 0;
}
int intInArr(double_array arr, int lookupInt)
{
    int length = len(arr);
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupInt) return 1;
    }
    return 0;
}
#define inArrStr strInArr
#define inArrInt intInArr

//Library GUI
object {
    string name;
    string version;
} App;
App new_app(string name, string version) {
    App my_app;
    my_app.name = name;
    my_app.version = version;
    return my_app;
}
App appMeta(string name, string version) {
    App my_app = new_app(name, version);
    Date dt = new_date();
    #ifdef CONIO_H
        recognize_colors();
    #endif
    printf("\t\t><><><><><><>❤️<><><><><><\n\t\t|        HindC++\n\t\t\t   by\n\t\t\t Khurram Ali\n\t\t>💗🌷<><><><><><><><>🌹💘<\n\t\t   =====================\n\t\t|\\/\t\t\t\\/|\n\n\n\n");
    printf("%s%s v%s\t\t      © Licensed under MIT™\n", strlen(name.data()) > 3 && strlen(name.data()) < 15 ? name.data() : "Sample", strlen(name.data()) < 9 ? " App" : "", strlen(version.data()) && strlen(version.data()) < 9 ? version.data() : "1.0.0");
    repeat_inline("<<", 30);
    br(2);
    #ifdef CONIO_H
        clr(peela);
    #endif
     printf("Happy %s❤️,\t\t          %s\n\t\t\t\t       ___________________\n", strlen(dt.day.data()) < 8 ? (dt.day + "  ").data() : dt.day.data(), dt.stamp.data());
    #ifdef CONIO_H
        clr(_def);
    #endif
    repeat_inline("^^", 30);
    br(2);
    return my_app;
}
App setMeta(string name, string version) {
    return appMeta(name, version);
}
App new_sample_app() {
    return setMeta("", "");
}
App new_custom_app(string name, string version) {
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

    kahen ke "Hey @" aage username aage ", aj" or_aage falaana aage tareekh() aage "he. Oh, to apki pedaish" aage birthyear or_age "ki he?" or_bas;
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

    bolie ke "\nYour score:" or_age score or_bas;
}
*/
/*
    string word = puchoWord("Please enter a word: ") re
    bolie ke "You entered:" aage word aage_bas na
    kahie ke salaam;
}
*/
/*
co
    ayesha kahie "hi" aur "love" age_bas ji
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
    nata_agar n wakai_barabar wanda(8, 2) ahe ta
        bhau chau "4 ta asal me 8 jo addu (8/2) hundo ahe!" ji
    bas_hare
off
*/
/*
on
    int nums[] = {0, 2, 4, 6, 8};
    har_ek n from nums ke_lie
        kahie n aur " ";
    basab
    br(2);
    kahie "Questions" age_bas;
    str questions[] = {"Mike, right?", "How are you?"};
    har_ek question from questions ke_lie
        kahie "*" aur question age_bas;
    basab
off
*/
/*
on
    chau new_date().timegreet agya_bas yaara
    
off
*/