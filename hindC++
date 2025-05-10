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
using shrt = short;
using lng = long;
using dbl = double;
using flt = float;
using ch = char;
using haal = bool;

//initialization
#define array std::vector
#define char_array std::string
#define string_array std::vector<std::string>
#define integer_array std::vector<int>
#define long_array std::vector<long>
#define float_array std::vector<float>
#define double_array std::vector<double>
#define char_arr std::string
#define string_arr std::vector<std::string>
#define integer_arr std::vector<int>
#define long_arr std::vector<long>
#define float_arr std::vector<float>
#define double_arr std::vector<double>
#define ch_array std::string
#define str_array std::vector<std::string>
#define int_array std::vector<int>
#define lng_array std::vector<long>
#define flt_array std::vector<float>
#define dbl_array std::vector<double>
#define ch_arr std::string
#define str_arr std::vector<std::string>
#define int_arr std::vector<int>
#define lng_arr std::vector<long>
#define flt_arr std::vector<float>
#define dbl_arr std::vector<double>
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
#define ke_age << " " <<
#define ke_aage << " " <<
#define agya << " " <<
#define je_agya << " " <<
#define je_agyo << " " <<
#define or_age << " " <<
#define aen_agya << " " <<
#define wari_agya << " " <<
#define or_aage << " " <<
#define aen_agyo << " " <<
#define wari_agyo << " " <<
#define bas endl
#define or_bas or_age bas
#define age_bas or_bas
#define aage_bas or_bas
#define aen_agya << " " <<
#define aen_agyo << " " <<
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
#define ahe_hare =
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
#define ghani_ya_barabar >=
#define ghari_ya_barabar >=
#define bara_ya_barabar >=
#define wado_ya_barabar >=
#define bare_ya_barabar >=
#define wada_ya_barabar >=
#define wadi_ya_barabar >=
#define ghat_ya_barabar <=
#define chota_ya_barabar <=
#define kam_ya_barabar <=
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
#define re ;std::cout<<"";
#define ri ;std::cout<<"";
#define love ;std::cout<<"";
#define pyari ;std::cout<<"";;
#define ji ;std::cout<<"";
#define object typedef struct
#define Object typedef struct
#define extends : public
#define on int main() {
#define off }
#define khu int main() {
#define ram }
#define khuram ;std::cout<<"";
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
string fmt(string fmt, ...) 
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
string fmt_inline(string fmt, ...) 
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
#define print cout <<
#define f fmt
#define f_inl fmt_inline
/*
//POV: you hate type conversion
on
    kahie sout("hi honey, " << "I heard you just turned " << 24 << "!") << endl
off
@deprecated
*/
/*
//or EVEN BETTER, a template string
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
#define askWord puchoWord
string pucho(string x) {
    std::string returnValue = "";
    std::cout << x;
    getline(std::cin, returnValue);
    return returnValue;
}
#define puch pucho
#define puchu pucho
#define puchuJumlo pucho
#define pucholine pucho
#define puchoJumla pucho
#define askline pucho
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
#define linechadyo linechoro
#define linechad linechoro
#define linegap linechad(
//^stays as/is, the additional opening parenthesis at the end is used to allow following syntax: linegap x ka|jo re|ji|yaara|;
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
string_array split(string str, string regex_or_str="") {

    std::regex regexz(regex_or_str);

    return {
        std::sregex_token_iterator(str.begin(), str.end(), regexz, -1),

        std::sregex_token_iterator()
    };
}
/*
@params:
    @@str: string
        @@regex_or_str|delimiter|token_to_break_with: string|regex
@returnVal:
    vector<string> {iterable}
@test:
on
    string sentence = "Love, I bet you remember our first kiss under-the-rain";
    let words = split(str, "[^a-zA-Z'\\-]|\\-(?![a-zA-Z]{2,})");
    for (int i=0; i<words.size(); i++) print words[i] + "\n";
off
*/
string_array splitIntoWords(string str) {
    let words = split(str, "[^a-zA-Z'\\-]|\\-(?![a-zA-Z]{2,})");
    return words;
}
#define lafzo_me_toro splitIntoWords
#define alfazo_me_to splitIntoWords
#define lafzan_me_bhanyo splitIntoWords
fn join(str_array arr, string delim="") {
    string result;
    for (let item from arr) {
        result += delim + Str(item);
    }
    return result;
}
fn join(int_array arr, string delim="") {
    string result;
    for (let item from arr) {
        result += delim + Str(item);
    }
    return result;
}
fn join(lng_array arr, string delim="") {
    string result;
    for (let item from arr) {
        result += delim + Str(item);
    }
    return result;
}
fn join(flt_array arr, string delim="") {
    string result;
    for (let item from arr) {
        result += delim + Str(item);
    }
    return result;
}
fn join(dbl_array arr, string delim="") {
    string result;
    for (let item from arr) {
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
string slice(string str, int start=0)
{
    return slice(str, start, str.size());
}
#define trim slice
string sliceRight(string str, int start, int end)
{
    return slice(str, str.size()-start, str.size()-end);
}
string sliceRight(string str, int start=0)
{
    return slice(str, str.size()-start, str.size());
}
#define trimRight sliceRight
string sliceEnd(string str, int end)
{
    return slice(str, 0, str.size()-end);
}
#define trimEnd sliceEnd
#define trimOut sliceEnd
#define trimLast sliceEnd
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
    @that_part_of_the_string: string
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
/*
Before we proceed, let's make some Number maps, for each of use
*/
/*Pakistani*/
#define hazar *1e3
#define zr *1e3
#define hzr zr
#define lac *1e5
#define lacs *1e5
#define lakh lac
#define lakhs *1e5
#define lc *1e5
#define crore *1e7
#define crores crore
#define cr *1e7
#define arab *1e9
#define arabs *1e9
#define ar *1e9

/*Intl*/
#define K *1e3
#define Mi *1e6
#define million Mi
#define Bi *1e9
#define billion Bi
#define Tri *1e12
#define trillion Tri
#define qdr *1e15
#define quadrillion qdr
#define qnt *1e18
#define quintillion qnt
#define sxn *1e21
#define sextillion sxn
#define spt *1e24
#define septillion spt
#define oct *1e27
#define octillion oct
#define nnn *1e30
#define nonillion nnn
#define dcn *1e33
#define decillion dcn
string f(long n) {
    string sign;
    if (n < 0) {
        sign = "-";
        n = abs(n);
    }
    string str = Str(n);
    int zeros = str.size()-1;
    if (zeros <= 2 || zeros >= 11) return sign + str;
    switch (zeros) {
        case 3:
        case 4:
            str = reg_replace(str, "\\d(?=\\d{3}$)", "$&,");
            break;
        case 5:
        case 6:
            str = reg_replace(str, "\\d(?=\\d{5}$)|\\d(?=\\d{3}$)", "$&,");
            break;
        case 7:
        case 8:
            str = reg_replace(str, "^\\d{1,2}(?=\\d{7,8})|\\d(?=\\d{5}$)|\\d(?=\\d{3}$)", "$&,");
            break;
        case 9:
        case 10:
            str = reg_replace(str, "^\\d{1,2}(?=\\d{9,10})|\\d(?=\\d{7}$)|\\d(?=\\d{5}$)|\\d(?=\\d{3}$)", "$&,");
            break;
    }
    string output = sign + str;
    return output;
}
string fIntl(long n) {
    string sign;
    if (n < 0) {
        sign = "-";
        n = abs(n);
    }
    string str = Str(n);
    int zeros = str.size()-1;
    if (zeros <= 2 || zeros >= 11) return sign + str;
    switch (zeros) {
        case 3:
        case 4:
            str = reg_replace(str, "\\d(?=\\d{3}$)", "$&,");
            break;
        case 5:
        case 6:
            str = reg_replace(str, "\\d(?=\\d{6}$)|\\d(?=\\d{3}$)", "$&,");
            break;
        case 7:
        case 8:
            str = reg_replace(str, "^\\d{1,2}(?=\\d{9,10})|\\d(?=\\d{6}$)|\\d(?=\\d{3}$)", "$&,");
            break;
        case 9:
        case 10:
            str = reg_replace(str, "^\\d{1,2}(?=\\d{11,13})|\\d(?=\\d{9}$)|\\d(?=\\d{6}$)|\\d(?=\\d{3}$)", "$&,");
            break;
    }
    string output = sign + str;
    return output;
}
func pkr(long n) {
    string formattedN = f(n);
    string result = "PKR " + formattedN;
    return result;
}
func usd(long n) {
    string formattedN = fIntl(n);
    string result = "$" + formattedN;
    return result;
}
/*
on
    long n = 3040070000;
    print f("%s\n%s", pkr(n).data(), usd(n).data());
off
*/
func suffix(long n) {
    let formattedN = f(n);
    let parts = split(formattedN, ",");
    let size = parts.size();
    if (n < 800 || n > 99 arabs) return formattedN;
    string result;
    switch (size) {
        case 1:
        case 2:
            result = Str(n/1e3) + "zr";
            break;
        case 3:
            result = Str(n/1e5) +  "lc";
            break;
        case 4:
            result = Str(n/1e7) +  "cr";
            break;
        case 5:
            result = Str(n/1e9) +  "ar";
            break;
    }
    return result;
}
func intl(long n) {
    let formattedN = fIntl(n);
    let parts = split(formattedN, ",");
    let size = parts.size();
    if (n < 800 || n > 99 billion) return formattedN;
    string result;
    switch (size) {
        case 1:
        case 2:
            result = Str(n/1e3) + "k";
            break;
        case 3:
            result = Str(n/1e6) +  "M";
            break;
        case 4:
            result = Str(n/1e9) +  "B";
            break;
    }
    return result;
}
/*
on
    int n1 = 3 lakh,
      n2 = 2 lakh;
    print f("%s me se %s gae, bacha %s", suffix(n1).data(), suffix(n2).data(), pkr(3 lakh minus 2 lakh).data());
off
*/
/*
on
    //print intl(75000000000);
    //print suffix(85.71 ar - 5ar);
off
*/
func ordinal(long n) {
    string result = Str(n);
    int size = result.size();
    string last_two = &result[size-2];
    char last_char = result[size-1];
    if (n > 14 && n < 111) {
        switch (last_char) {
            case '1': result += "st"; break;
            case '2': result += "nd"; break;
            case '3': result += "rd"; break;
            default: result += "th";
        }
    }
    else {
       if (last_two == "11" || last_two == "12" || last_two == "13") result += "th";
       else {
           switch (last_char) {
                case '1': result += "st"; break;
                case '2': result += "nd"; break;
                case '3': result += "rd"; break;
                default: result += "th";
           }
        }
    }
    return result;
}
#define th ordinal
/*
on
    for (int i = 0; i<500; i++)
        print th(i) age_bas;
off
*/
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
string randstr(int len)
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
    for (int i = 0, j = strlen(s.data()) - 1; i < j; i++, j--)
    {
        s.data()[i] += s.data()[j],
        s.data()[j] = s.data()[i] - s.data()[j],
        s.data()[i] -= s.data()[j];
    }
    return s;
}
#define ulta reverseStr
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
string titleCase(string str)
{
	bool checked = false;		
	for (int i=0; i<str.length(); i++)
	{
		if (!checked && (str.at(i)>='a' && str.at(i)<='z'))
			str.at(i) = str.at(i) + 'A'-'a';
		if ((str.at(i)>='a' && str.at(i)<='z') || (str.at(i)>='A' && str.at(i)<='Z') )
			checked = true;
		else
			checked = false;
	}
	return str;
}
#define sent_case sentCase
#define title_case titleCase
char nthLastCharOf(string str, int n) {
    return str[str.size() - n];
}
char secondLastCharOf(string str) {
    return nthLastCharOf(str, 2);
}
char lastCharOf(string str) {
    return nthLastCharOf(str, 1);
}
string strPop(string str)
{
    str[strlen(str.data()) - 1] = '\0';
    string result = str;
    return result;
}
#define str_pop strPop
bool eq(string x, string y)
{
    return strcasecmp(x.data(), y.data()) == 0;
}
bool eq(double x, double y)
{
    return x == y;
}
int strAt(string str, string lookup) {
    char *p = strstr(str.data(), lookup.data());
    //@returnVal: $index[int]
    if (p) return p-str.data();
    return -1;
}
int strAtInsens(string str, string lookup) {
    str = lower(str);
    lookup = lower(lookup);
    char *p = strstr(str.data(), lookup.data());
    //@returnVal: $index[int]
    if (p) return p-str.data();
    return -1;
}
bool strHas(string str, string lookup) {
    //-1 means not an index in the string
    return strAt(str, lookup) != -1 || strAt(str, lookup) >= 0;
}
bool strHasInsens(string str, string lookup) {
    //-1? Not an index found in the string!
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
    return -Pos(n);
}
int randint(int max=999)
{
    srand(time(NULL));
    return (rand() + 1) % max;
}
float randflt(int max=999)
{
    srand(time(NULL));
    return ((rand() + 1) % max) * .3;
}
#define randi randint
#define randf randflt
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
int_array range(int n, bool startWithZero=false) {
    int_array arr = {};
    for (int i=0; i<n; i++)
        arr.push_back(!startWithZero ? i+1 : i);
    return arr;
}
/*
on
    //if you prefer n based values over the index based, you could either remove the second parameter or set it to false
    har ek x from range(50, true) ke_lie
        print x age_bas;
    basab
off
*/
bool isNumlike(string str)
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
bool isIntlike(string str)
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
bool isFltlike(string str)
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
auto sum(double a, double b, double c=0, double d=0, double e=0, double f=0, double g=0, double h=0, double i=0, double j=0)
{
    return a+b+c+d+e+f+g+h+i+j;
}
auto diff(double a, double b, double c=0, double d=0, double e=0, double f=0, double g=0, double h=0, double i=0, double j=0)
{
    return a-b-c-d-e-f-g-h-i-j;
}
auto prd(double a, double b)
{
    return a*b;
}
auto quo(double a, double b)
{
    return a/b;
}
/*
on
    print f(sum(5, 4, 7.11, 4, 2, 6.57, 8, 3, 15, 21));
off
*/
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
bool isperfmod(double a, double b)
{
    return mod(a, b) == 0;
}
bool isdiv(float of_n, float this_n)
{
    return mod(of_n, this_n) == 0;
}
#define isdivisor isdiv
bool iseven(int n)
{
    return isperfmod(n, 2);
}
bool isodd(int n)
{
    return !isperfmod(n, 2);
}
#define baddi iseven
#define ikki isodd
bool isprime(int n)
{
    for (int i = 2; i <= n / 2; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
}
int fibonacci(int n)
{
    if (n<2) return n;
    return fibonacci(n-2) + fibonacci(n-1);
}
auto pct(double n1, double n2)
{
    if (n1 > n2)
        return (n1 * n2) / 100;
    else
        return (n1 / n2) * 100;
}
#define ctof(c) (round(1.8 * c + 32))
#define ftoc(f) (round(((f - 32) * 5) / 9))
/*
co
    print ftoc(98);
de
*/

//DATE METHODS
object
{
    string period, time, timegreet, date, day, month, season, stamp;
    int mins, hours, dayAsIndex, year;
    bool isWeekend, isLeapYear;
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
    if (eq(month, "may") || eq(month, "jun") || eq(month, "jul") || eq(month, "aug")) season = "Summer";
	else if (eq(month, "sep") || eq(month, "oct")) season = "Spring";
	else if (eq(month, "nov") || eq(month, "dec") || eq(month, "jan") || eq(month, "feb")) season = "Winter";
	else season = "Fall";
        
    if (eq(month, "jan")) {
        month += "uary";
    } else if (eq(month, "feb")) {
        month += "ruary";
    } else if (eq(month, "mar")) {
        month += "ch";
    } else if (eq(month, "apr")) {
        month += "il";
    } else if (eq(month, "may")) {
        month += "";
    } else if (eq(month, "jun")) {
        month += "e";
    } else if (eq(month, "jul")) {
        month += "y";
    } else if (eq(month, "aug")) {
        month += "ust";
    } else if (eq(month, "sep")) {
        month += "tember";
    } else if (eq(month, "oct")) {
        month += "ober";
    } else if (eq(month, "nov")) {
        month += "ember";
    } else if (eq(month, "dec")) {
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
    if (eq(day, "sun")) {
        day += "day";
        dayAsIndex = 0;
    }
    else if (eq(day, "mon")) {
        day += "day";
        dayAsIndex = 1;
    } else if (eq(day, "tue")) {
        day += "sday";
        dayAsIndex = 2;
    } else if (eq(day, "wed")) {
        day += "nesday";
        dayAsIndex = 3;
    } else if (eq(day, "thu")) {
        day += "rsday";
        dayAsIndex = 4;
    } else if (eq(day, "fri")) {
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
    if (eq(period, "pm"))
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
    bool isLeapYear = Int(year) % 4 == 0;


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
bool isWeekend()
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
bool createFile(string fname, string content)
{
    FILE *fptr;
    fptr = fopen(fname.data(), "w");
    if (fprintf(fptr, "%s", content.data()))
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File \"%s\" banai/update ki ja chuki he, apki farmaish pe.\n", fname.data());
        fclose(fptr);
        return true;
    }
    printf("\n[Message from HindC FileReader]:\n❌ Shayad apko is directory me files banane ki permission nahi😔\n");
    fclose(fptr);
    return false;
}
bool newFile(string fname, string content)
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
bool deleteFile(string fname)
{
    int successInRemoval = remove(fname.data()) == 0;
    if (successInRemoval)
    {
        printf("\n[Message from HindC FileReader]:\n✔️ File %s ko delete karna kaamyaab raha.\n", fname.data());
        return true;
    }
    printf("\n[Message from HindC FileReader]:\n❌ File \"%s\" ko remove karna na kaam raha. Ya apke pas file ko delete karne ki permission nahi, ya file he hi ger mojood.\n", fname.data());
    return false;
}
bool copyFile(string src, string dest)
{
    if (eq(src.data(), dest.data()))
    {
        printf("\n[Message from HindC FileReader]:\n⚠️ Source matches destination, unable to replace the source file with the destination file!\n");
        return false;
    }
    int c;
    FILE *stream_R;
    FILE *stream_W;
    stream_R = fopen(src.data(), "r");
    if (!stream_R || stream_R == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ Source file ki ger mojoodgi ki soorat, file ko copy/move karna na kaam raha!\n");
        return false;
    }
    stream_W = fopen(dest.data(), "w");
    if (!stream_W || stream_W == NULL)
    {
        printf("\n[Message from HindC FileReader]:\n❌ File ko copy/move karna na kaam raha!\n");
        fclose(stream_R);
        return false;
    }
    while ((c = fgetc(stream_R)) != EOF)
    {
        fputc(c, stream_W);
    }
    fclose(stream_R);
    fclose(stream_W);
    return true;
}
bool renameFile(string oldName, string newName)
{
    bool renameSuccessful = (rename(oldName.data(), newName.data()) == 0);
    if (renameSuccessful)
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File renamed successfully\n");
        return true;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to rename!\n");
    return false;
}
bool moveFile(string fname, string dest)
{
    if (renameFile(fname.data(), dest.data()))
    {
        printf("\n[Message from HindC FileReader]:\n ✔️ File moved successfully\n");
        return true;
    }
    printf("\n[Message from HindC FileReader]:\n ❌ File failed to move!\n");
    return false;
}
bool fileBanao(string fname, string content)
{
    return newFile(fname, content);
}
bool naiFile(string fname, string content)
{
    return newFile(fname, content);
}
bool fileHatao(string fname)
{
    return deleteFile(fname);
}

//Arrays
#define push(arr, el) arr.push_back(el)
#define pushStart(arr, el) arr.insert(arr.begin(), el)
#define pushAt(arr, i, el) arr.insert(arr.begin() + i, el)
#define pushAtLast(arr, i, el) arr.insert(arr.end() - i, el)
#define shift(arr) arr.erase(arr.begin())
#define pop(arr) arr.pop_back()
#define popAt(arr, i) arr.erase(arr.begin() + i)
#define popAtLastOf(arr, i) arr.erase(arr.end() - i)
#define secLastOf(arr) (arr[arr.size()-2])
#define lastOf(arr) (arr[arr.size()-1])
#define nthLastOf(arr, index) (arr[arr.size()-index])
#define replaceNthLastOf(arr, index, replacement) (arr[arr.size()-index] = replacement)
#define reverseArr(arr) (std::reverse(arr.begin(), arr.end()))
#define shuffleArr(arr) (std::shuffle(arr.begin(), arr.end(), std::default_random_engine{}))
#define randItem(arr) (arr[randint(arr.size()-1)])
#define randIt randItem
#define randFrom randItem
//work for strings as well:
#define sortAsc(arr) std::sort(arr.begin(), arr.end())
#define sortDesc(arr) std::sort(arr.rbegin(), arr.rend())
#define sort sortAsc
//get min/max out of numbers
func maxAmong(double p, double q) {
    return p>q ? p : q;
}
func maxAmong(double p, double q, double r) {
    return maxAmong(maxAmong(p, q), r);
}
func maxAmong(double p, double q, double r, double s) {
    return maxAmong(maxAmong(p,q,r), s);
}
func maxAmong(double p, double q, double r, double s, double t) {
    return maxAmong(maxAmong(p,q,r,s), t);
}
func maxAmong(double p, double q, double r, double s, double t, double u) {
    return maxAmong(maxAmong(p,q,r,s,t), u);
}
func minAmong(double p, double q) {
    return p<q ? p : q;
}
func minAmong(double p, double q, double r) {
    return minAmong(minAmong(p, q), r);
}
func minAmong(double p, double q, double r, double s) {
    return minAmong(minAmong(p,q,r), s);
}
func minAmong(double p, double q, double r, double s, double t) {
    return minAmong(minAmong(p,q,r,s), t);
}
func minAmong(double p, double q, double r, double s, double t, double u) {
    return minAmong(minAmong(p,q,r,s,t), u);
}
#define max_among maxAmong
#define min_among minAmong
/*
on
    double a = 5.5,
      b = -50;
    print "Max:" aage max_bw(a, b) age_bas;
    print "Min:" aage min_bw(a, b) age_bas;
off
*/
int minAmongArr(int_array nums) {
  int min = nums[0];
  for (int n : nums) {
    if (n < min) min = n;
  }
  return min;
}
lng minAmongArr(long_array nums) {
  lng min = nums[0];
  for (lng n : nums) {
    if (n < min) min = n;
  }
  return min;
}
flt minAmongArr(flt_array nums) {
  flt min = nums[0];
  for (flt n : nums) {
    if (n < min) min = n;
  }
  return min;
}
dbl minAmongArr(dbl_array nums) {
  dbl min = nums[0];
  for (dbl n : nums) {
    if (n < min) min = n;
  }
  return min;
}
int maxAmongArr(int_array nums) {
  int max = nums[0];
  for (int n : nums) {
    if (n > max) max = n;
  }
  return max;
}
lng maxAmongArr(long_array nums) {
  lng max = nums[0];
  for (lng n : nums) {
    if (n > max) max = n;
  }
  return max;
}
flt maxAmongArr(flt_array nums) {
  flt max = nums[0];
  for (flt n : nums) {
    if (n > max) max = n;
  }
  return max;
}
dbl maxAmongArr(dbl_array nums) {
  dbl max = nums[0];
  for (dbl n : nums) {
    if (n > max) max = n;
  }
  return max;
}
void printArr(string_array arr) {
    int size = arr.size();
    cout << "{";
    for (int i = 0; i < size; i++) {
        cout << "\n\t<" << arr[i] << ">,";
    }
    cout << "\n}\n";
}
void printArr(int_array arr) {
    int size = arr.size();
    cout << "{";
    for (int i = 0; i < size; i++) {
        cout << "\n\t<" << arr[i] << ">,";
    }
    cout << "\n}\n";
}
void printArr(long_array arr) {
    int size = arr.size();
    cout << "{";
    for (int i = 0; i < size; i++) {
        cout << "\n\t<" << arr[i] << ">,";
    }
    cout << "\n}\n";
}
void printArr(float_array arr) {
    int size = arr.size();
    cout << "{";
    for (int i = 0; i < size; i++) {
        cout << "\n\t<" << arr[i] << ">,";
    }
    cout << "\n}\n";
}
void printArr(double_array arr) {
    int size = arr.size();
    cout << "{";
    for (int i = 0; i < size; i++) {
        cout << "\n\t<" << arr[i] << ">,";
    }
    cout << "\n}\n";
}
void printArrReversed(string_array arr) {
    int size = arr.size()-1;
    //bugfix: we need the last element, not the length of the array, as that would get us a null character
    cout << "{";
    for (; size >= 0; size--) {
        cout << "\n\t<" << arr[size] << ">,";
    }
    cout << "\n}\n";
}
void printArrReversed(int_array arr) {
    int size = arr.size()-1;
    //bugfix: we need the last element, not the length of the array, as that would get us a null character
    cout << "{";
    for (; size >= 0; size--) {
        cout << "\n\t<" << arr[size] << ">,";
    }
    cout << "\n}\n";
}
void printArrReversed(long_array arr) {
    int size = arr.size()-1;
    //bugfix: we need the last element, not the length of the array, as that would get us a null character
    cout << "{";
    for (; size >= 0; size--) {
        cout << "\n\t<" << arr[size] << ">,";
    }
    cout << "\n}\n";
}
void printArrReversed(float_array arr) {
    int size = arr.size()-1;
    //bugfix: we need the last element, not the length of the array, as that would get us a null character
    cout << "{";
    for (; size >= 0; size--) {
        cout << "\n\t<" << arr[size] << ">,";
    }
    cout << "\n}\n";
}
void printArrReversed(double_array arr) {
    int size = arr.size()-1;
    //bugfix: we need the last element, not the length of the array, as that would get us a null character
    cout << "{";
    for (; size >= 0; size--) {
        cout << "\n\t<" << arr[size] << ">,";
    }
    cout << "\n}\n";
}
#define printReversedArr printArrReversed
#define reversePrintArr printArrReversed
bool inArr(string_array arr, string lookupStr)
{
    int size = len(arr);
    for (int i=0; i<size; i++)
    {
        if (arr[i] == lookupStr) return true;
    }
    return false;
}
bool inArr(int_array arr, int lookupInt)
{
    int size = len(arr);
    for (int i=0; i<size; i++)
    {
        if (arr[i] == lookupInt) return true;
    }
    return false;
}
bool inArr(lng_array arr, int lookupLng)
{
    int size = len(arr);
    for (int i=0; i<size; i++)
    {
        if (arr[i] == lookupLng) return true;
    }
    return false;
}
bool inArr(float_array arr, float lookupFlt)
{
    int size = len(arr);
    for (int i=0; i<size; i++)
    {
        if (arr[i] == lookupFlt) return true;
    }
    return false;
}
bool inArr(double_array arr, double lookupDbl)
{
    int length = len(arr);
    for (int i=0; i<length; i++)
    {
        if (arr[i] == lookupDbl) return true;
    }
    return false;
}


//Library's in-console GUI
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
    
const string_array ctss = {"Abbottabad","Adilpur","Ahmadpur East","Ahmadpur Sial","Akora","Aliabad","Alik Ghund","Alipur","Alizai","Alpurai","Aman Garh","Amirabad","Arifwala","Ashanagro Koto","Athmuqam","Attock City","Awaran","Baddomalhi","Badin","Baffa","Bagarji","Bagh","Bahawalnagar","Bahawalnagar","Bahawalpur","Bakhri Ahmad Khan","Bandhi","Bannu","Barishal","Barkhan","Basirpur","Basti Dosa","Bat Khela","Battagram","Begowala","Bela","Berani","Bhag","Bhakkar","Bhalwal","Bhan","Bhawana","Bhera","Bhimbar","Bhiria","Bhit Shah","Bhopalwala","Bozdar Wada","Bulri","Būrewāla","Chak","Chak Azam Sahu","Chak Five Hundred Seventy-five","Chak Jhumra","Chak One Hundred Twenty Nine Left","Chak Thirty-one -Eleven Left","Chak Two Hundred Forty-nine Thal Development Authority","Chakwal","Chaman","Chamber","Charsadda","Chawinda","Chenab Nagar","Cherat Cantonement","Chhor","Chichawatni","Chilas","Chiniot","Chishtian","Chitral","Choa Saidan Shah","Chowki Jamali","Chuchar-kana Mandi","Chuhar Jamali","Chunian","Dadhar","Dadu","Daggar","Daira Din Panah","Dajal","Dalbandin","Dandot RS","Daromehar","Darya Khan","Darya Khan Marri","Daska Kalan","Dasu","Daud Khel","Daulatpur","Daultala","Daur","Dera Allahyar","Dera Bugti","Dera Ghazi Khan","Dera Ismail Khan","Dera Murad Jamali","Dhanot","Dhaunkal","Dhoro Naro","Digri","Dijkot","Dinan Bashnoian Wala","Dinga","Dipalpur","Diplo","Doaba","Dokri","Duki","Dullewala","Dunga Bunga","Dunyapur","Eidgah","Eminabad","Faisalabad","Faqirwali","Faruka","Fazilpur","Fort Abbas","Gadani","Gakuch","Gambat","Gandava","Garh Maharaja","Garhi Khairo","Garhiyasin","Ghauspur","Ghotki","Gilgit","Gojra","Goth Garelo","Goth Phulji","Goth Radhan","Gujar Khan","Gujranwala","Gujrat","Gulishah Kach","Gwadar","Hadali","Hafizabad","Hala","Hangu","Haripur","Harnai","Harnoli","Harunabad","Hasilpur","Hattian Bala","Haveli Lakha","Havelian","Hazro City","Hingorja","Hujra Shah Muqim","Hyderabad","Islamabad","Islamkot","Jacobabad","Jahanian Shah","Jalalpur Jattan","Jalalpur Pirwala","Jampur","Jamshoro","Jand","Jandiala Sher Khan","Jaranwala","Jati","Jatoi Shimali","Jauharabad","Jhang City","Jhang Sadr","Jhawarian","Jhelum","Jhol","Jiwani","Johi","Jām Sāhib","Kabirwala","Kadhan","Kahna Nau","Kahror Pakka","Kahuta","Kakad Wari Dir Upper","Kalabagh","Kalaswala","Kalat","Kaleke Mandi","Kallar Kahar","Kalur Kot","Kamalia","Kamar Mushani","Kambar","Kamoke","Kamra","Kandhkot","Kandiari","Kandiaro","Kanganpur","Karachi","Karak","Karaundi","Kario Ghanwar","Karor","Kashmor","Kasur","Keshupur","Keti Bandar","Khadan Khak","Khadro","Khairpur","Khairpur Mir’s","Khairpur Nathan Shah","Khairpur Tamewah","Khalabat","Khandowa","Khanewal","Khangah Dogran","Khangarh","Khanpur","Khanpur Mahar","Kharan","Kharian","Khewra","Khurrianwala","Khushāb","Khuzdar","Kohat","Kohlu","Kot Addu","Kot Diji","Kot Ghulam Muhammad","Kot Malik Barkhurdar","Kot Mumin","Kot Radha Kishan","Kot Rajkour","Kot Samaba","Kot Sultan","Kotli","Kotli Loharan","Kotri","Kulachi","Kundian","Kunjah","Kunri","Lachi","Ladhewala Waraich","Lahore","Lakhi","Lakki","Lala Musa","Lalian","Landi Kotal","Larkana","Layyah","Liliani","Lodhran","Loralai","Mach","Madeji","Mailsi","Malakand","Malakwal","Malakwal City","Malir Cantonment","Mamu Kanjan","Mananwala","Mandi Bahauddin","Mangla","Mankera","Mansehra","Mardan","Mastung","Matiari","Matli","Mehar","Mehmand Chak","Mehrabpur","Mian Channun","Mianke Mor","Mianwali","Minchianabad","Mingora","Miran Shah","Miro Khan","Mirpur Bhtoro","Mirpur Khas","Mirpur Mathelo","Mirpur Sakro","Mirwah Gorchani","Mitha Tiwana","Mithi","Moro","Moza Shahwala","Multan","Muridke","Murree","Musa Khel Bazar","Mustafābād","Muzaffargarh","Muzaffarābād","Nabisar","Nankana Sahib","Narang Mandi","Narowal","Nasirabad","Naudero","Naukot","Naushahra Virkan","Naushahro Firoz","Nawabshah","Nazir Town","New Bādāh","New Mirpur","Noorabad","Nowshera","Nowshera Cantonment","Nushki","Okara","Ormara","Pabbi","Pad Idan","Paharpur","Pakpattan","Panjgur","Pano Aqil","Parachinar","Pasni","Pasrur","Pattoki","Peshawar","Phalia","Pind Dadan Khan","Pindi Bhattian","Pindi Gheb","Pir Jo Goth","Pir Mahal","Pishin","Pithoro","Qadirpur Ran","Qila Abdullah","Qila Saifullah","Quetta","Rahim Yar Khan","Raiwind","Raja Jang","Rajanpur","Rajo Khanani","Ranipur","Rasulnagar","Ratodero","Rawala Kot","Rawalpindi","Renala Khurd","Risalpur Cantonment","Rohri","Rojhan","Rustam","Saddiqabad","Sahiwal","Sahiwal","Saidu Sharif","Sakrand","Samaro","Sambrial","Sanghar","Sangla Hill","Sanjwal","Sann","Sarai Alamgir","Sarai Naurang","Sarai Sidhu","Sargodha","Sehwan","Setharja Old","Shabqadar","Shahdad Kot","Shahdadpur","Shahkot","Shahpur","Shahpur Chakar","Shahr Sultan","Shakargarh","Sharqpur Sharif","Shekhupura","Shikarpur","Shingli Bala","Shinpokh","Shorkot","Shujaabad","Sialkot","Sibi","Sillanwali","Sinjhoro","Skardu","Sobhodero","Sodhri","Sohbatpur","Sukheke Mandi","Sukkur","Surab","Surkhpur","Swabi","Sīta Road","Talagang","Talamba","Talhar","Tandlianwala","Tando Adam","Tando Allahyar","Tando Bago","Tando Jam","Tando Mitha Khan","Tando Muhammad Khan","Tangi","Tangwani","Tank","Taunsa","Thal","Tharu Shah","Thatta","Thul","Timargara","Toba Tek Singh","Topi","Turbat","Ubauro","Umarkot","Upper Dir","Usta Muhammad","Uthal","Utmanzai","Vihari","Wana","Warah","Wazirabad","Yazman","Zafarwal","Zahir Pir","Zaida","Zhob","Ziarat"};
#define randCity() randItem(ctss)
#define rand_city randCity
#define koiSheher randCity
#define koi_sheher randCity
#define kisiSheher randCity
#define kisi_sheher randCity
const string_array wdss = {"Armor","Barrymore","Cabot","Catholicism","Chihuahua","Christianity","Easter","Frenchman","Lowry","Mayor","Orientalism","Pharaoh","Pueblo","Pullman","Saturday","Sister","Snead","Syrah","Tuesday","Woodward","abbey","absence","absorption","abstinence","absurdity","abundance","acceptance","accessibility","accommodation","accomplice","accountability","accounting","accreditation","accuracy","acquiescence","acreage","actress","actuality","adage","adaptation","adherence","adjustment","adoption","adultery","advancement","advert","advertisement","advertising","advice","aesthetics","affinity","aggression","agriculture","aircraft","airtime","allegation","allegiance","allegory","allergy","allies","alligator","allocation","allotment","altercation","ambulance","ammonia","anatomy","anemia","ankle","announcement","annoyance","annuity","anomaly","anthropology","anxiety","apartheid","apologise","apostle","apparatus","appeasement","appellation","appendix","applause","appointment","appraisal","archery","archipelago","architecture","ardor","arrears","arrow","artisan","artistry","ascent","assembly","assignment","association","asthma","atheism","attacker","attraction","attractiveness","auspices","authority","avarice","aversion","aviation","babbling","backlash","baker","ballet","balls","banjo","baron","barrier","barrister","bases","basin","basis","battery","battling","bedtime","beginner","begun","bending","bicycle","billing","bingo","biography","biology","birthplace","blackberry","blather","blossom","boardroom","boasting","bodyguard","boldness","bomber","bondage","bonding","bones","bonus","bookmark","boomer","booty","bounds","bowling","brainstorming","breadth","breaker","brewer","brightness","broccoli","broth","brotherhood","browsing","brunch","brunt","building","bullion","bureaucracy","burglary","buyout","by-election","cabal","cabbage","calamity","campaign","canonization","captaincy","carcass","carrier","cartridge","cassette","catfish","caught","celebrity","cemetery","certainty","certification","charade","chasm","check-in","cheerleader","cheesecake","chemotherapy","chili","China","chivalry","cholera","cilantro","circus","civilisation","civility","clearance","clearing","clerk","climber","closeness","clothing","clutches","coaster","coconut","coding","collaborator","colleague","college","collision","colors","combustion","comedian","comer","commander","commemoration","commenter","commissioner","commune","competition","completeness","complexity","computing","comrade","concur","condominium","conduit","confidant","configuration","confiscation","conflagration","conflict","consist","consistency","consolidation","conspiracy","constable","consul","consultancy","contentment","contents","contractor","conversation","cornerstone","corpus","correlation","councilman","counselor","countdown","countryman","coverage","covering","coyote","cracker","creator","criminality","crocodile","cropping","cross-examination","crossover","crossroads","culprit","cumin","curator","curfew","cursor","custard","cutter","cyclist","cyclone","cylinder","cynicism","daddy","damsel","darkness","dawning","daybreak","dealing","dedication","deduction","defection","deference","deficiency","definition","deflation","degeneration","delegation","delicacy","delirium","deliverance","demeanor","demon","demonstration","denomination","dentist","departure","depletion","depression","designation","despotism","detention","developer","devolution","dexterity","diagnosis","dialect","differentiation","digger","digress","dioxide","diploma","disability","disarmament","discord","discovery","dishonesty","dismissal","disobedience","dispatcher","disservice","distribution","distributor","diver","diversity","docking","dollar","dominance","domination","dominion","donkey","doorstep","doorway","dossier","downside","drafting","drank","drilling","driver","drumming","drunkenness","duchess","ducking","dugout","dumps","dwelling","dynamics","eagerness","earnestness","earnings","eater","editor","effectiveness","electricity","elements","eloquence","emancipation","embodiment","embroidery","emperor","employment","encampment","enclosure","encouragement","endangerment","enlightenment","enthusiasm","environment","environs","envoy","epilepsy","equation","equator","error","espionage","estimation","evacuation","exaggeration","examination","exclamation","expediency","exploitation","extinction","eyewitness","falls","fascism","fastball","feces","feedback","ferocity","fertilization","fetish","finale","firing","fixing","flashing","flask","flora","fluke","folklore","follower","foothold","footing","forefinger","forefront","forgiveness","formality","formation","formula","foyer","fragmentation","framework","fraud","freestyle","frequency","friendliness","fries","frigate","fulfillment","function","functionality","fundraiser","fusion","futility","gallantry","gallery","genesis","genitals","girlfriend","boyfriend","glamor","chemistry","glitter","sparkles","glucose","sugar","sugardaddy","vase","bracelet","bra","neck","kiss","pleasure","google","grandeur","grappling","greens","gridlock","grocer","groundwork","grouping","gunman","gusto","habitation","hacker","hallway","hamburger","hammock","handling","hands","handshake","happiness","hardship","headcount","header","headquarters","heads","headset","hearth","hearts","heath","hegemony","height","hello","helper","helping","helplessness","hierarchy","hoarding","hockey","homeland","homer","honesty","horror","horseman","hostility","housing","humility","hurricane","iceberg","ignition","illness","illustration","illustrator","immunity","immunization","imperialism","imprisonment","inaccuracy","inaction","inactivity","inauguration","indecency","indicator","inevitability","infamy","infiltration","influx","iniquity","innocence","innovation","insanity","inspiration","instruction","instructor","insurer","interact","intercession","intercourse","intermission","interpretation","intersection","interval","intolerance","intruder","invasion","investment","involvement","irritation","iteration","jenny","jogging","jones","joseph","juggernaut","juncture","jurisprudence","juror","kangaroo","kingdom","knocking","laborer","larceny","laurels","layout","leadership","leasing","legislation","leopard","liberation","licence","lifeblood","lifeline","ligament","lighting","likeness","line-up","lineage","liner","lineup","liquidation","listener","literature","litigation","litre","loathing","locality","lodging","logic","longevity","lookout","lordship","lustre","ma'am","machinery","madness","magnificence","mahogany","mailing","mainframe","maintenance","majority","manga","mango","manifesto","mantra","manufacturer","maple","martin","martyrdom","mathematician","matrix","matron","mayhem","mayor","means","meantime","measurement","mechanics","mediator","medics","melodrama","memory","mentality","metaphysics","method","meter","miner","mirth","misconception","misery","mishap","misunderstanding","mobility","molasses","momentum","monarchy","monument","morale","mortality","motto","mouthful","mouthpiece","mover","movie","mowing","murderer","musician","mutation","mythology","narration","narrator","nationality","negligence","neighborhood","neighbor","nervousness","networking","nexus","nightmare","nobility","nobody","noodle","normalcy","notification","nourishment","novella","nucleus","nuisance","nursery","nutrition","nylon","oasis","obscenity","obscurity","observer","offense","onslaught","operation","opportunity","opposition","oracle","orchestra","organisation","organizer","orientation","originality","ounce","outage","outcome","outdoors","outfield","outing","outpost","outset","overseer","owner","oxygen","pairing","panther","paradox","parliament","parsley","parson","passenger","pasta","patchwork","pathos","patriotism","pendulum","penguin","permission","persona","perusal","pessimism","peter","philosopher","phosphorus","phrasing","physique","piles","plateau","playing","plaza","plethora","plurality","pneumonia","pointer","poker","policeman","polling","poster","posterity","posting","postponement","potassium","pottery","poultry","pounding","pragmatism","precedence","precinct","preoccupation","pretense","priesthood","prisoner","privacy","probation","proceeding","proceedings","processing","processor","progression","projection","prominence","propensity","prophecy","prorogation","prospectus","protein","prototype","providence","provider","provocation","proximity","puberty","publicist","publicity","publisher","pundit","putting","quantity","quart","quitting","Chihuahua","quorum","racism","radiance","ralph","rancher","ranger","rapidity","rapport","ratification","rationality","reaction","reader","reassurance","rebirth","receptor","recipe","recognition","recourse","recreation","rector","recurrence","redemption","redistribution","redundancy","refinery","reformer","refrigerator","regularity","regulator","reinforcement","reins","reinstatement","relativism","relaxation","rendition","repayment","repentance","repertoire","repository","republic","reputation","resentment","residency","resignation","restaurant","resurgence","retailer","retention","retirement","reviewer","riches","righteousness","roadblock","robber","rocks","rubbing","runoff","saloon","salvation","sarcasm","saucer","savior","scarcity","scenario","scenery","schism","scholarship","schoolboy","schooner","scissors","scolding","scooter","scouring","scrimmage","scrum","seating","sediment","seduction","seeder","seizure","self-confidence","self-control","self-respect","semicolon","semiconductor","semifinal","senator","sending","serenity","seriousness","servitude","sesame","setup","sewing","sharpness","shoplifting","shopping","siding","sidewalk","simplicity","simulation","sinking","skate","sloth","slugger","snack","snail","snapshot","snark","soccer","solemnity","solicitation","solitude","somewhere","sophistication","sorcery","souvenir","spaghetti","specification","specimen","specs","spectacle","specter","speculation","sperm","spoiler","squad","squid","staging","stagnation","staircase","stairway","stamina","standpoint","standstill","stanza","statement","stillness","stimulus","stocks","stole","stoppage","story","storyteller","stylus","subcommittee","subscription","subsidy","suburb","success","sufferer","supposition","suspension","sweater","sweepstakes","swimmer","syndrome","synopsis","syntax","system","tablespoon","taker","tavern","technology","telephony","template","tempo","tendency","tendon","terrier","terror","terry","theater","theology","therapy","thicket","thoroughfare","threshold","thriller","thunderstorm","ticker","tiger","tights","tossing","touchdown","tourist","tourney","toxicity","tracing","tractor","translation","transmission","transmitter","trauma","traveler","treadmill","trilogy","trout","tuning","twenties","tycoon","tyrant","ultimatum","antidote","underwear","unhappiness","unification","university","rise","uprising","downfall","vaccination","validity","vampire","vanguard","variation","vegetation","verification","viability","vicinity","victory","beauty","viewpoint","viewport","villa","vanilla","vindication","violation","vocalist","vogue","volcano","voltage","vomiting","vulnerability","waistcoat","waitress","wardrobe","warmth","watchdog","wealth","weariness","whereabouts","whisky","whiteness","widget","width","windfall","wiring","witchcraft","withholding","womanhood","words","workman","laborer","lumberjack","youngster","mobile phone","telephone","Television","information","technology","automobile","picture","movie","document","documentary","compliment","insult","vocalist","pianist","violinist","thirst","hunger","brevity","longevity","sanity","insanity","bikini","panty","breasts","hymen","synthesis","dementia","amnesia","blood sugar","fever","flu","diarrhea","glucose","Latino","Latina","anesthetics","anesthesia","Cannabis","oasis","desert","dessert","hemoglobin","cardiographer","carpenter","oceanic","terran","abroad","absorbing","abstract","academic","accelerated","accented","accountant","acquainted","acute","obtuse","protective","possessive","real","unreal","realistic","unrealistic","imagined","delusional","addicting","addictive","adjustable","admired","adult","adverse","advised","aerosol","afraid","creeped out","horrified","horrific","terrified","terrific","devastated","frustrated","aggravated","aggressive","agreeable","alienate","aligned","all-round","alleged","almond","alright","altruistic","ambient","ambivalent","amiable","amino","amorphous","amused","anatomical","ancestral","angelic","angrier","answerable","antiquarian","antiretroviral","appellate","applicable","apportioned","approachable","appropriated","archer","aroused","arrested","assertive","assigned","athletic","atrocious","attained","authoritarian","autobiographical","avaricious","avocado","awake","awesome","backstage","backwoods","balding","bandaged","banded","banned","barreled","battle","beaten","begotten","beguiled","bellied","belted","beneficent","besieged","betting","big-money","biggest","biochemical","bipolar","blackened","blame","blessed","blindfolded","bloat","blocked","blooded","blue-collar","blushing","boastful","bolder","bolstered","bonnie","bored","boundary","bounded","bounding","branched","brawling","brazen","breeding","bridged","brimming","brimstone","broadest","broiled","broker","bronze","bruising","buffy","bullied","bungling","burial","buttery","candied","canonical","cantankerous","cardinal","carefree","caretaker","casual","cathartic","causal","chapel","characterized","charcoal","cheeky","cherished","chipotle","chirping","chivalrous","circumstantial","civic","civil","civilised","clanking","clapping","claptrap","classless","cleansed","cleric","cloistered","codified","colloquial","colour","combat","combined","comely","commissioned","commonplace","commuter","commuting","comparable","complementary","compromising","conceding","concentrated","conceptual","conditioned","confederate","confident","confidential","confining","confuse","congressional","consequential","conservative","constituent","contaminated","contemporaneous","contraceptive","convertible","convex","cooked","coronary","corporatist","correlated","corroborated","cosmic","cover","crash","crypto","culminate","cushioned","dandy","dashing","dazzled","decreased","decrepit","dedicated","defaced","defective","defenseless","deluded","deodorant","departed","depress","designing","despairing","destitute","detective","determined","devastating","deviant","devilish","devoted","diagonal","dictated","didactic","differentiated","diffused","dirtier","disabling","disconnected","discovered","disdainful","diseased","disfigured","disheartened","disheveled","disillusioned","disparate","dissident","doable","doctrinal","doing","dotted","double-blind","downbeat","dozen","draining","draught","dread","dried","dropped","dulled","duplicate","eaten","echoing","economical","elaborated","elastic","elective","electoral","elven","embryo","emerald","emergency","emissary","emotional","employed","enamel","encased","encrusted","endangered","engraved","engrossing","enlarged","enlisted","enlivened","ensconced","entangled","enthralling","entire","envious","eradicated","eroded","esoteric","essential","evaporated","ever-present","evergreen","everlasting","exacting","exasperated","excess","exciting","executable","existent","exonerated","exorbitant","exponential","export","extraordinary","exultant","exulting","facsimile","fading","fainter","faith-based","fallacious","faltering","famous","fancier","fast-growing","fated","favourable","fearless","feathered","fellow","fermented","ferocious","fiddling","filling","firmer","fitted","flammable","flawed","fledgling","fleshy","flexible","flickering","floral","flowering","flowing","foggy","folic","foolhardy","foolish","footy","forehand","forked","formative","formulaic","foul-mouthed","fractional","fragrant","fraudulent","freakish","freckled","freelance","freight","fresh","fretted","frugal","fulfilling","fuming","funded","funny","garbled","gathered","geologic","geometric","gibberish","gilded","ginger","glare","glaring","gleaming","glorified","glorious","goalless","gold-plated","goody","grammatical","grande","grateful","gratuitous","graven","greener","grinding","grizzly","groaning","grudging","guaranteed","gusty","half-breed","hand-held","handheld","hands-off","hard-pressed","harlot","healing","healthier","healthiest","heart","heart-shaped","heathen","hedonistic","heralded","herbal","high-density","high-performance","high-res","high-yield","hissy","hitless","holiness","homesick","honorable","hooded","hopeless","horrendous","horrible","hot-button","huddled","human","humbling","humid","humiliating","hypnotized","idealistic","idiosyncratic","ignited","illustrated","illustrative","imitated","immense","immersive","immigrant","immoral","impassive","impressionable","improbable","impulsive","in-between","in-flight","inattentive","inbound","inbounds","incalculable","incomprehensible","indefatigable","indigo","indiscriminate","indomitable","inert","inflate","inform","inheriting","injured","injurious","inking","inoffensive","insane","insensible","insidious","insincere","insistent","insolent","insufferable","intemperate","interdependent","interesting","interfering","intern","interpreted","intersecting","intolerable","intolerant","intuitive","irresolute","irritate","jealous","jerking","joining","joint","journalistic","joyful","keyed","knowing","lacklustre","laden","lagging","lamented","laughable","layered","leather","leathern","leery","left-footed","legible","leisure","lessening","liberating","life-size","lifted","lightest","limitless","listening","literary","liver","livid","lobster","locked","long-held","long-lasting","long-running","long-suffering","loudest","loveliest","low-budget","low-carb","lowering","lucid","luckless","lusty","luxurious","magazine","maniac","manmade","maroon","mastered","mated","material","materialistic","meaningful","measuring","mediaeval","medical","meditated","medley","melodic","memorable","tasty","delicious","inspiring","motivational","default","good","bad","neutral","fine","okay","alright","memorial","metabolic","metallic","metallurgical","metering","midair","midterm","midway","mighty","migrating","mind-blowing","mind-boggling","major","minor","visual","visible","audible","mirrored","misguided","misshapen","joyful","mixed","twisted","mitigated","mixed","modernized","molecular","monarch","monastic","morbid","motley","motorized","mounted","multi-million","multidisciplinary","muscled","muscular","muted","mysterious","mythic","nail-biting","natural","nauseous","negative","networked","neurological","neutered","newest","night","nitrous","no-fly","noncommercial","nonsense","north","nuanced","occurring","offensive","oldest","oncoming","one-eyed","one-year","onstage","onward","opaque","open-ended","operating","opportunist","opposing","opt-in","ordinate","outdone","outlaw","outsized","overboard","overheated","oversize","overworked","oyster","paced","panting","paralyzed","paramount","parental","parted","partisan","passive","edible","eatable","kissable","killable","pastel","patriot","peacekeeping","pedestrian","peevish","penal","penned","pensive","perceptual","perky","permissible","pernicious","perpetuate","perplexed","pervasive","petrochemical","philosophical","picturesque","pillaged","piped","piquant","pitching","plausible","pliable","plumb","politician","polygamous","poorest","portmanteau","posed","positive","possible","postpartum","prank","pre-emptive","precocious","predicted","premium","preparatory","prerequisite","prescient","preserved","presidential","pressed","pressurized","presumed","prewar","priced","pricier","primal","primer","primetime","printed","private","problem","procedural","process","prodigious","professional","programmed","progressive","prolific","promising","promulgated","pronged","proportionate","protracted","pulled","pulsed","purgatory","quick","rapid-fire","raunchy","razed","reactive","readable","realizing","recognised","recovering","recurrent","recycled","redeemable","reflecting","regal","registering","reliable","reminiscent","remorseless","removable","renewable","repeating","repellent","reserve","resigned","respectful","rested","restrict","resultant","retaliatory","retiring","revelatory","reverend","reversing","revolving","ridiculous","right-hand","ringed","risque","robust","roomful","rotating","roused","rubber","run-down","running","runtime","rustling","safest","salient","sanctioned","saute","saved","scandalized","scarlet","scattering","sceptical","scheming","scoundrel","scratched","scratchy","scrolled","seated","second-best","segregated","self-taught","semiautomatic","senior","sensed","sentient","sexier","shadowy","shaken","shaker","shameless","shaped","shiny","shipped","shivering","shoestring","short","short-lived","signed","simplest","simplistic","sizable","skeleton","skinny","skirting","skyrocketed","slamming","slanting","slapstick","sleek","sleepless","sleepy","slender","slimmer","smacking","smokeless","smothered","smouldering","snuff","socialized","solid-state","sometime","sought","spanking","sparing","spattered","specialized","specific","speedy","spherical","spiky","spineless","sprung","squint","stainless","standing","starlight","startled","stately","statewide","stereoscopic","sticky","stimulant","stinky","stoked","stolen","storied","strained","strapping","strengthened","stubborn","stylized","suave","subjective","subjugated","subordinate","succeeding","suffering","summary","sunset","sunshine","supernatural","supervisory","supply-side","surrogate","suspended","suspenseful","swarthy","sweating","sweeping","swinging","swooning","sympathize","synchronized","synonymous","synthetic","tailed","tallest","tangible","tanked","tarry","technical","tectonic","telepathic","tenderest","territorial","testimonial","theistic","thicker","threatening","tight-lipped","timed","timely","timid","torrent","totalled","tougher","traditional","transformed","trapped","traveled","traverse","treated","trial","trunk","trusting","trying","twisted","two-lane","tyrannical","unaided","unassisted","unassuming","unattractive","uncapped","uncomfortable","uncontrolled","uncooked","uncooperative","underground","undersea","undisturbed","unearthly","uneasy","unequal","unfazed","unfinished","unforeseen","unforgivable","unidentified","unimaginative","uninspired","unintended","uninvited","universal","unmasked","unorthodox","unparalleled","unpleasant","unprincipled","unread","unreasonable","unregulated","unreliable","unremitting","unsafe","unsanitary","unsealed","unsuccessful","unsupervised","untimely","unwary","unwrapped","uppity","upstart","useless","utter","valiant","valid","valued","vanilla","vaulting","vaunted","veering","vegetative","vented","verbal","verifying","veritable","versed","vinyl","virgin","visceral","visual","voluptuous","walk-on","wanton","warlike","washed","waterproof","waved","weakest","well-bred","well-chosen","well-informed","wet","wheeled","whirlwind","widen","widening","willful","willing","winnable","winningest","wireless","wistful","woeful","wooded","woodland","wordless","workable","worldly","worldwide","worst-case","worsted","worthless","able","abnormal","absent-minded","above average","adventurous","affectionate","agile","agreeable","alert","amazing","ambitious","amiable","amusing","analytical","angelic","apathetic","apprehensive","ardent","artificial","artistic","assertive","attentive","average","awesome","awful","balanced","beautiful","below average","beneficent","blue","blunt","boisterous","brave","bright","brilliant","buff","callous","candid","cantankerous","capable","careful","careless","caustic","cautious","charming","childish","childlike","cheerful","chic","churlish","circumspect","civil","clean","clever","clumsy","coherent","cold","competent","composed","conceited","condescending","confident","confused","conscientious","considerate","content","cool","cool-headed","cooperative","cordial","courageous","cowardly","crabby","crafty","cranky","crass","critical","cruel","curious","cynical","dainty","decisive","deep","deferential","deft","delicate","demonic","dependent","delightful","demure","depressed","devoted","dextrous","diligent","direct","dirty","disagreeable","discerning","discreet","disruptive","distant","distraught","distrustful","dowdy","dramatic","dreary","drowsy","drugged","drunk","dull","dutiful","eager","earnest","easy-going","efficient","egotistical","elfin","emotional","energetic","enterprising","enthusiastic","evasive","even-tempered","exacting","excellent","excitable","experienced","fabulous","fastidious","ferocious","fervent","fiery","flabby","flaky","flashy","frank","friendly","funny","fussy","generous","gentle","gloomy","glutinous","good","grave","great","groggy","grouchy","guarded","hateful","hearty","helpful","hesitant","hot-headed","hypercritical","hysterical","idiotic","idle","illogical","imaginative","immature","immodest","impatient","imperturbable","impetuous","impractical","impressionable","impressive","impulsive","inactive","incisive","incompetent","inconsiderate","inconsistent","independent","indiscreet","indolent","indefatigable","industrious","inexperienced","insensitive","inspiring","intelligent","interesting","intolerant","inventive","irascible","irritable","irritating","jocular","jovial","joyous","judgmental","keen","kind","lame","lazy","lean","leery","lethargic","level-headed","listless","lithe","lively","local","logical","long-winded","lovable","love-lorn","lovely","maternal","mature","mean","meddlesome","mercurial","methodical","meticulous","mild","miserable","modest","moronic","morose","motivated","musical","naive","nasty","natural","naughty","negative","nervous","noisy","normal","nosy","numb","obliging","obnoxious","old-fashioned","one-sided","orderly","ostentatious","outgoing","outspoken","passionate","passive","paternal","paternalistic","patient","peaceful","peevish","pensive","persevering","persnickety","petulant","picky","plain","plain-speaking","playful","pleasant","plucky","polite","popular","positive","powerful","practical","prejudiced","pretty","proficient","proud","provocative","prudent","punctual","quarrelsome","querulous","quick","quick-tempered","quiet","realistic","reassuring","reclusive","reliable","reluctant","resentful","reserved","resigned","resourceful","respected","respectful","responsible","restless","revered","ridiculous","sad","sassy","saucy","sedate","self-assured","selfish","sensible","sensitive","sentimental","serene","serious","sharp","short-tempered","shrewd","shy","silly","sincere","sleepy","slight","sloppy","slothful","slovenly","slow","smart","snazzy","sneering","snobby","somber","sober","sophisticated","soulful","soulless","sour","spirited","spiteful","stable","staid","steady","stern","stoic","striking","strong","stupid","sturdy","subtle","sullen","sulky","supercilious","superficial","surly","suspicious","sweet","tactful","tactless","talented","testy","thinking","thoughtful","thoughtless","timid","tired","tolerant","touchy","tranquil","ugly","unaffected","unbalanced","uncertain","uncooperative","undependable","unemotional","unfriendly","unguarded","unhelpful","unimaginative","unmotivated","unpleasant","unpopular","unreliable","unsophisticated","unstable","unsure","unthinking","unwilling","venal","versatile","vigilant","warm","warmhearted","wary","watchful","weak","well-behaved","well-developed","well-intentioned","well-respected","well-rounded","willing","wonderful","volcanic","vulnerable","zealous","abandoned","absent minded","abused","accepted","accomplished","accusatory","accused","admired","adored","adrift","affectionate","afraid","aggravated","aggressive","agitated","alarmed","alert","alienated","alive","alluring","alone","aloof","amazed","ambushed","amused","angry","annoyed","antagonistic","anxious","apathetic","apologetic","appalled","appreciated","appreciative","apprehensive","aroused","ashamed","astonished","attacked","attractive","awake","aware","awe","awed","awestruck","awkward","bad","baffled","barren","bashful","beaten","belittled","benevolent","berated","betrayed","bewildered","bitchy","bitter","bittersweet","blah","blamed","blank","blissful","blue","bold","bored","bothered","bouncy","brave","broken","brooding","bummed","burdened","burned-out","callous","calm","capable","carefree","careless","caring","caustic","cautious","censored","centered","certain","challenged","charmed","cheated","cheerful","cherished","childish","chipper","choleric","clean","clear","clever","close","closed","clueless","clumsy","cold","comfortable","committed","compassionate","competent","competitive","complacent","complete","concerned","condemned","condescension","confident","confining","confused","considerate","contemplative","contempt","contemptuous","content","controlled","conventional","convicted","cornered","courageous","cowardly","cranky","crappy","crazy","critical","cross","crushed","curious","cynical","daring","dark","dashed","dazed","dead","deceived","dedicated","defeated","defenseless","defensive","defiant","degraded","dejected","delicate","delighted","demoralized","dependent","depressed","deprived","derisive","deserted","desired","desolate","despair","desperate","destroyed","detached","determined","devastated","devious","devoted","didactic","different","difficult","dignified","dirty","disappointed","disbelieving","discarded","disconnected","discontent","discontented","discouraged","disdainful","disgraced","disgusted","disheartened","dishonest","disillusioned","dismal","dismayed","disobedient","disorganized","disposable","distant","distracted","distressed","disturbed","ditzy","dorky","doubtful","down","drained","dreamy","dreary","dropped","drunk","dull","dumb","eager","earnest","ecstatic","edgy","effective","elated","embarassed","embarrassed","empathetic","empowered","empty","enchanted","encouraged","energetic","energized","enlightened","enraged","enriched","entertained","enthralled","enthusiastic","envious","erudite","evasive","evil","exasperated","excited","excluded","exhausted","exhilarated","expectant","exploited","exposed","exuberant","faithful","fake","fanciful","fantastic","fatalistic","fatigued","fearful","fearless","feisty","fine","flirty","flustered","foolish","foreboding","forgiven","forgiving","forgotten","forthright","fortunate","framed","frantic","free","friendly","frightened","frisky","frustrated","fulfilled","full","funny","furious","futile","geeky","generous","gentle","giddy","giggly","giving","glad","gloomy","glorious","good","grateful","great","grieving","groggy","grouchy","grumpy","guarded","guilty","gullible","handicapped","happy","harmonious","hateful","haughty","haunted","haunting","healthy","heard","heartbroken","heavy-hearted","helpful","helpless","hesitant","high","honored","hopeful","hopeless","horrible","horrified","hospitable","hostile","hot","humble","humiliated","hungry","hurt","hyper","hysterical","idealistic","idiotic","idyllic","ignorant","ignored","imaginative","immune","impatient","impelled","imperfect","impertinent","important","impressed","impulsive","inadequate","inattentive","incensed","inclusive","incompetent","incomplete","incredulous","indebted","indecisive","independent","indescribable","indifferent","indignant","industrious","inept","inferior","inflated","informed","infuriated","inhibited","innocent","innovative","inquisitive","insane","insecure","insensitive","insidious","insignificant","insulted","intense","interested","interrogated","interrupted","intimate","intimidated","intrigued","invigorated","invisible","involved","irate","irked","irrational","irresponsible","irritated","isolated","jaded","jealous","jinxed","jolly","jovial","joyful","joyous","jubilant","judged","judgmental","jumpy","just","justified","kidded","kind","knowledgeable","late","lazy","leery","left","let","lethargic","liable","liberated","liberating","lifeless","light-hearted","liked","listened","listless","logical","lonely","loose","lost","lousy","lovable","loved","loving","lucky","lyrical","mad","malicious","manipulated","matter","fact","mean","meditative","melancholic","melancholy","mellow","merciless","merry","mischievous","miserable","misinterpreted","mistreated","misunderstood","mixed","mocked","mocking","modest","molested","moody","morose","motivated","mournful","moved","mystified","naive","nasty","naughty","nauseated","needed","needy","negative","neglected","nerdy","nervous","neurotic","nightmarish","nonchalant","nostalgic","not","specified","noticed","numb","obeyed","objective","obligated","obvious","odd","offended","okay","old","open","oppressed","optimistic","ornery","control","outraged","overcome","overjoyed","overloaded","overwhelmed","overworked","owned","painful","pampered","panicky","paralyzed","passionate","passive","patient","patronizing","peaceful","peeved","pensive","perky","perplexed","persecuted","pessimistic","pestered","petrified","petty","phony","pious","pissed","off","playful","pleased","poor","positive","possessive","powerful","powerless","practical","predatory","pressured","private","productive","protected","protective","proud","provoked","prudish","punished","pushy","puzzled","questioned","quiet","quixotic","quizzical","rambunctious","realistic","reassured","rebellious","reborn","receptive","reckless","recognized","reconciled","recumbent","reflective","refreshed","regretful","rejected","rejuvenated","relaxed","released","relieved","reluctant","reminiscent","remorse","renewed","replaced","replenished","repressed","rescued","resentful","reserved","resistant","resourceful","respected","responsible","restless","restricted","revengeful","reverent","revitalized","ribald","rich","ridicule","ridiculous","right","rigid","robbed","romantic","rotten","rushed","sabotaged","sad","safe","sarcastic","sardonic","sassy","satiated","satiric","satisfied","saved","scared","scolded","scorned","secure","seductive","selfish","self-assured","self-centered","self-confident","self-conscious","self-destructive","self-reliant","sensitive","sentimental","serene","serious","sexy","shaken","shamed","sheepish","shocked","shunned","shy","sick","silenced","silly","sincere","sinful","skeptical","skillful","slandered","sleepy","sluggish","small","smart","smothered","solemn","somber","soothed","sorry","special","spiteful","splendid","spunky","squashed","stifled","stimulated","stingy","strained","stressed","stretched","strong","stubborn","stumped","stunned","stupid","submissive","successful","suffocated","suicidal","sullen","sunk","super","superior","supported","sure","surly","surprised","suspenseful","suspicious","sympathetic","tacky","tactful","talented","talkative","tame","tarnished","tasteful","tearful","teased","tenacious","tender","tense","tepid","terrible","terrific","terrified","terrifying","tested","testy","thankful","thoughtful","threatened","threatening","thrifty","thrilled","tired","tormented","torn","tortured","touched","tough","tragic","tranquil","transformed","trapped","treasured","trembly","tremendous","tricked","troubled","trusted","trustful","ugly","unaccepted","unappreciated","unbalanced","unburdened","uncanny","uncomfortable","unconcerned","uneven","unfit","unfriendly","united","unjust","unknown","unneeded","unpleasant","unreal","unruly","unwise","up","uplifted","used","useless","vacant","vague","vain","valid","valued","vengeful","vexed","vicious","victimized","victorious","violated","violent","vivacious","vivid","void","wacky","warlike","warm","warmhearted","warned","wary","wasted","weak","wealthy","weary","weird","welcoming","whimsical","whole","wild","willful","wishful","witty","worldly","worried","worse","worthy","wounded","wrong","yearning","yellow","yielding","young","youthful","zany","zealous"};
#define randWord() randItem(wdss)
#define rand_word randWord
#define koiLafz randWord
#define koi_lafz randWord
#define kisiLafz randWord
#define kisi_lafz randWord
const string_array ntltss = {"Afghan","Egyptian","Ålandic","Albanian","Algerian","Virgin Islander","American Samoan","Andorran","Angolan","Anguillan","Antarctic","Antiguan and Barbudan","Equatorial Guinean","Argentine; Argentinian","Armenian","Aruban","Azerbaijani","Ethiopian","Australian","Bahamian","Bahraini","Bangladeshi","Barbadian","Belarusian","Belgian","Belizean","Beninese","Bermudian","Bhutanese","Bolivian","Bosnian","Botswanan","of Bouvet Island","Brazilian","of the British Indian Ocean Territory","British Virgin Islander","Bruneian","Bulgarian","Burkinabe","Burundian","Cape Verdean","Chilean","Chinese","of Clipperton Island","Cook Islander","Costa Rican","Ivorian","Curaçaoan","Danish","German","Dominican","Djiboutian","Ecuadorian","Salvadorian; Salvadoran","Eritrean","Estonian","Falklander","Faroese","Fijian","Finnish","French","of the French Southern and Antarctic Lands","Guianese","Polynesian","Gabonese","Gambian","Georgian","Ghanaian","Gibraltarian","Grenadian","Greek","Greenlandic","Guadeloupean","Guamanian","Guatemalan","Guernsey","Guinean","Bissau-Guinean","Guyanese","Haitian","of the Heard Island and McDonald Islands","of the Holy See/of the Vatican","Honduran","Hong Kong Chinese","Indian","Indonesian","Manx","Iraqi","Iranian","Irish","Icelandic","Israeli","Italian","Jamaican","Japanese","Yemeni","Jersey","Jordanian","Caymanian","Cambodian","Cameroonian","Canadian","Kazakh","Qatari","Kenyan","Kyrgyz","Kiribatian","—","of the Cocos (Keeling) Islands","Colombian","Comorian","Congolese","Croatian","Cuban","Kuwaiti","Lao; Laotian","Mesotho","Latvian","Lebanese","Liberian","Libyan","Liechtensteiners","Lithuanian","Luxembourgish","Macanese","Malagasy","Malawian","Malaysian","Maldivian","Malian","Maltese","Moroccan","Marshallese","Martinican","Mauritanian","Mauritian","Mahoran","Mexican","Micronesian","Moldovan","Monegasque","Mongolian","Montenegrin","Montserratian","Mozambican","Burmese","Namibian","Nauruan","Nepalese","New Caledonian","New Zealander","Nicaraguan","Dutch","Nigerien","Nigerian","Niuean","North Korean","Marian Islander","Norfolk Islander","Norwegian","Omani","Austrian","Pakistani","Palauan","Panamanian","Papua New Guinean","Paraguayan","Peruvian","Filipino","Pitcairner","Polish","Portuguese","Puerto Rican","Reunionese","Rwandan; Rwandese","Romanian","Russian","Solomon Islander","Zambian","Samoan","Sammarinese","São Toméan","Saudi Arabian","Swedish","Swiss","Senegalese","Serbian","Seychellois","Sierra Leonean","Zimbabwean","Singaporean","Slovak","Slovenian","Somali; Somalian","Spanish","Sri Lankan","Saint Barthélemian","of Saint Helena, Ascension and Tristan da Cunha","of Saint Kitts and Nevis","Saint Lucian","of Saint Martin","of Sint Maarten","of Saint Pierre and Miquelon","Vincentian; of Saint Vincent and the Grenadines","South African","Sudanese","of South Georgia and the South Sandwich Islands","South Korean","South Sudanese","Surinamese","of Svalbard, of Jan Mayen","Swazi","Syrian","Tajik","Taiwanese","Tanzanian","Thai","East Timorese","Togolese","Tokelauan","Tongan","of Trinidad and Tobago","Chadian","Czech","Tunisian","Turkish","Turkmen","of the Turks and Caicos Islands","Tuvaluan","Ugandan","Ukrainian","Hungarian","Uruguayan","Uzbek","Vanuatuan","Venezuelan","Emirian","American; The United States of America","British","Vietnamese","of the Wallis and Futuna Islands","of Christmas Island","Sahrawi","Central African","Cypriot"};
#define randNationality() randItem(ntltss)
#define rand_nationality randNationality
#define fakeNationality randNationality
#define fake_nationality randNationality
#define koiNationality randNationality
#define koi_nationality randNationality
#define kisiNationality randNationality
#define kisi_nationality randNationality
const string_array rfnss = {"+92 (337) 705 2471","+92 (304) 856 3453","+92 (334) 462 6112","+92 (318) 133 8724","+92 (305) 578 5856","+92 (310) 462 5351","+92 (312) 731 7316","+92 (333) 853 8132","+92 (325) 818 0176","+92 (307) 531 4378","+92 (308) 231 0403","+92 (324) 113 2465","+92 (308) 350 1245","+92 (304) 778 1655","+92 (308) 212 6486","+92 (337) 003 6218","+92 (318) 388 5662","+92 (311) 032 8777","+92 (317) 457 2031","+92 (303) 475 4653","+92 (313) 246 8410","+92 (308) 215 2441","+92 (305) 205 3250","+92 (314) 763 2228","+92 (323) 267 3234","+92 (320) 005 8284","+92 (312) 486 1408","+92 (313) 556 6782","+92 (312) 188 8504","+92 (321) 517 0564","+92 (300) 215 0018","+92 (331) 066 8182","+92 (305) 621 8357","+92 (312) 303 6683","+92 (330) 315 6554","+92 (318) 702 7462","+92 (307) 083 6477","+92 (333) 585 3443","+92 (315) 547 0136","+92 (327) 660 2848","+92 (330) 144 4028","+92 (323) 276 4840","+92 (327) 738 8321","+92 (305) 812 7050","+92 (324) 620 5556","+92 (310) 681 7606","+92 (336) 286 8600","+92 (333) 241 8207","+92 (322) 527 1520","+92 (303) 510 4857","+92 (337) 650 1744","+92 (321) 331 4144","+92 (301) 515 4836","+92 (332) 460 3760","+92 (333) 168 2174","+92 (304) 272 1350","+92 (320) 375 3538","+92 (336) 516 5606","+92 (330) 088 7340","+92 (317) 523 7275","+92 (314) 128 3831","+92 (326) 825 7157","+92 (302) 115 2032","+92 (336) 362 6505","+92 (313) 627 6536","+92 (302) 832 5304","+92 (300) 131 4753","+92 (311) 588 0281","+92 (337) 412 0180","+92 (321) 601 7236","+92 (306) 075 0548","+92 (336) 744 6742","+92 (335) 684 5677","+92 (323) 753 4302","+92 (322) 864 6866","+92 (301) 077 0316","+92 (320) 080 7036","+92 (327) 613 3783","+92 (334) 138 2771","+92 (330) 343 8104","+92 (325) 201 0684","+92 (337) 775 7221","+92 (311) 857 5310","+92 (322) 615 5255","+92 (310) 731 2176","+92 (323) 412 7433","+92 (323) 180 3238","+92 (318) 704 5111","+92 (321) 485 2814","+92 (334) 611 2074","+92 (314) 343 0881","+92 (300) 537 3177","+92 (310) 187 8100","+92 (320) 878 2262","+92 (324) 785 1028","+92 (313) 070 1354","+92 (318) 204 0637","+92 (328) 877 2626","+92 (318) 018 4006","+92 (306) 104 1463","+92 (313) 862 3726","+92 (318) 388 7683","+92 (330) 738 5730","+92 (316) 166 6803","+92 (313) 271 3641","+92 (307) 718 8285","+92 (306) 256 2360","+92 (321) 104 8067","+92 (300) 884 5048","+92 (307) 085 3035","+92 (335) 446 3531","+92 (322) 647 3410","+92 (328) 760 2861","+92 (327) 772 6701","+92 (300) 211 6834","+92 (333) 515 7716","+92 (314) 534 3700","+92 (330) 078 1205","+92 (304) 316 1564","+92 (338) 782 0723","+92 (318) 250 1765","+92 (300) 125 7551","+92 (330) 715 6381","+92 (306) 366 6305","+92 (330) 548 0703","+92 (324) 818 1781","+92 (334) 057 4635","+92 (327) 646 3800","+92 (337) 112 4745","+92 (334) 312 5800","+92 (332) 323 4057","+92 (323) 141 4625","+92 (321) 725 5403","+92 (306) 316 7326","+92 (326) 857 5082","+92 (311) 733 5287","+92 (310) 288 5856","+92 (318) 744 6625","+92 (302) 038 3437","+92 (300) 543 5048","+92 (311) 524 0182","+92 (310) 517 5147","+92 (336) 677 5164","+92 (333) 544 3314","+92 (301) 158 0516","+92 (320) 663 3225","+92 (324) 267 5737","+92 (334) 134 1455","+92 (315) 612 3858","+92 (317) 457 4026","+92 (310) 135 2187","+92 (312) 026 5570","+92 (305) 642 0803","+92 (318) 188 8582","+92 (312) 247 0835","+92 (322) 565 2507","+92 (322) 604 7714","+92 (308) 777 5758","+92 (334) 408 6214","+92 (303) 463 8153","+92 (326) 681 5836","+92 (337) 751 8272","+92 (301) 361 7477","+92 (313) 360 1062","+92 (302) 147 0657","+92 (310) 071 1840","+92 (305) 862 3122","+92 (330) 021 0070","+92 (302) 746 8830","+92 (337) 872 0571","+92 (312) 421 4418","+92 (326) 767 1476","+92 (338) 868 0422","+92 (304) 742 2570","+92 (322) 603 5815","+92 (336) 134 4630","+92 (332) 213 3405","+92 (328) 770 5337","+92 (334) 377 0753","+92 (332) 536 0507","+92 (333) 577 3367","+92 (314) 873 0856","+92 (313) 223 7860","+92 (333) 858 4750","+92 (313) 014 7425","+92 (336) 510 7005","+92 (306) 682 0351","+92 (311) 462 1763","+92 (331) 013 6165","+92 (305) 633 2143","+92 (303) 481 7545","+92 (300) 640 4238","+92 (307) 154 7560","+92 (305) 231 6152","+92 (327) 820 1002","+92 (300) 384 2010","+92 (302) 882 2088","+92 (314) 621 3515","+92 (305) 243 8763","+92 (327) 326 3071","+92 (333) 105 7024","+92 (332) 544 1170","+92 (322) 830 3481","+92 (310) 368 7228","+92 (312) 034 5444","+92 (324) 387 8832","+92 (311) 658 7085","+92 (333) 471 6534","+92 (318) 511 2514","+92 (306) 478 6607","+92 (324) 702 4308","+92 (336) 360 1744","+92 (312) 513 8375","+92 (334) 686 7874","+92 (306) 627 6338","+92 (332) 460 7558","+92 (316) 817 8703","+92 (300) 601 1281","+92 (336) 617 8334","+92 (335) 780 7855","+92 (304) 482 7718","+92 (336) 768 6462","+92 (311) 105 6765","+92 (321) 106 0335","+92 (336) 527 7517","+92 (317) 505 6640","+92 (312) 666 2872","+92 (310) 408 1200","+92 (310) 146 4768","+92 (308) 267 4746","+92 (325) 507 4071","+92 (327) 543 6632","+92 (334) 167 4164","+92 (301) 788 8214","+92 (337) 445 8301","+92 (322) 363 8213","+92 (313) 307 8076","+92 (302) 147 4655","+92 (308) 733 2787","+92 (323) 603 8653","+92 (326) 063 5886","+92 (303) 214 8782","+92 (306) 135 6700","+92 (331) 764 0407","+92 (338) 245 1083","+92 (327) 387 7425","+92 (334) 518 1635","+92 (336) 844 1154","+92 (331) 607 8080","+92 (317) 847 4253","+92 (304) 034 4855","+92 (311) 676 5521","+92 (328) 162 1822","+92 (316) 780 8086","+92 (303) 513 8441","+92 (324) 777 0074","+92 (336) 162 6318","+92 (323) 282 2211","+92 (325) 712 2150","+92 (313) 082 2570","+92 (308) 406 7281","+92 (333) 735 6170","+92 (314) 502 5084","+92 (337) 485 0163","+92 (325) 380 8500","+92 (315) 674 0704","+92 (326) 808 7182","+92 (338) 760 7774","+92 (305) 307 2061","+92 (336) 535 3642","+92 (302) 727 4036","+92 (300) 338 0680","+92 (306) 074 0122","+92 (325) 560 7146","+92 (321) 532 6483","+92 (318) 742 5523","+92 (322) 160 5367","+92 (331) 218 5540","+92 (307) 263 0607","+92 (328) 740 7545","+92 (334) 081 0154","+92 (323) 740 6273","+92 (306) 168 2305","+92 (338) 747 0835","+92 (323) 066 8320","+92 (338) 438 3555","+92 (300) 346 0563","+92 (320) 634 7562","+92 (330) 316 1011","+92 (300) 351 7074","+92 (313) 758 8350","+92 (313) 727 2310","+92 (331) 371 0261","+92 (305) 370 5643","+92 (314) 475 8816","+92 (311) 281 3765","+92 (325) 662 4084","+92 (310) 033 4327","+92 (313) 530 7815","+92 (327) 380 8188","+92 (308) 070 8470","+92 (323) 418 6367","+92 (317) 233 5022","+92 (301) 516 1310","+92 (327) 836 1122","+92 (326) 888 3055","+92 (317) 648 1424","+92 (332) 563 1855","+92 (300) 453 1100","+92 (336) 810 8634","+92 (320) 055 6327","+92 (314) 586 4743","+92 (301) 106 3066","+92 (308) 578 0821","+92 (322) 047 4055","+92 (310) 354 2234","+92 (323) 771 8476","+92 (312) 012 0767","+92 (320) 455 4883","+92 (322) 073 0140","+92 (300) 677 1541","+92 (330) 210 6046","+92 (314) 722 4560","+92 (331) 784 2382","+92 (303) 273 8846","+92 (331) 024 2853","+92 (330) 454 8617","+92 (317) 757 1833","+92 (308) 334 3602","+92 (316) 705 0848","+92 (327) 174 5515","+92 (308) 561 1524","+92 (317) 165 3512","+92 (334) 458 5500","+92 (307) 264 5644","+92 (313) 735 4003","+92 (300) 554 0808","+92 (327) 801 3402","+92 (308) 857 7614","+92 (304) 041 1408","+92 (323) 772 7663","+92 (337) 543 3248","+92 (335) 017 2204","+92 (313) 574 0726","+92 (328) 572 5058","+92 (311) 426 2002","+92 (325) 006 8227","+92 (307) 180 3504","+92 (301) 370 2756","+92 (300) 536 2556","+92 (336) 562 4745","+92 (335) 456 8361","+92 (327) 356 5473","+92 (305) 766 2753","+92 (336) 010 0246","+92 (311) 626 7526","+92 (302) 860 4252","+92 (322) 084 0662","+92 (304) 101 0800","+92 (316) 146 2018","+92 (320) 235 7701","+92 (338) 414 8473","+92 (312) 441 2302","+92 (306) 424 1504","+92 (313) 652 7648","+92 (314) 551 6166","+92 (302) 804 5450","+92 (334) 382 6883","+92 (304) 448 6162","+92 (331) 813 1683","+92 (316) 562 4504","+92 (303) 536 6031","+92 (338) 772 3065","+92 (331) 280 5101","+92 (335) 220 0570","+92 (317) 402 3502","+92 (321) 752 0763","+92 (330) 617 7136","+92 (302) 083 2232","+92 (300) 307 4675","+92 (301) 401 8434","+92 (303) 265 0173","+92 (323) 752 2184","+92 (302) 751 5347","+92 (320) 764 1510","+92 (314) 717 2422","+92 (303) 631 6215","+92 (334) 583 5180","+92 (322) 725 4143","+92 (320) 860 6378","+92 (323) 756 6850","+92 (302) 028 7823","+92 (303) 868 0017","+92 (316) 316 5303","+92 (303) 088 8025","+92 (307) 587 5757","+92 (301) 256 3062","+92 (316) 111 1886","+92 (338) 146 8025","+92 (312) 847 2754","+92 (325) 456 0504","+92 (333) 041 6237","+92 (315) 411 8384","+92 (314) 772 4233","+92 (338) 307 1476","+92 (300) 781 3662","+92 (324) 150 3080","+92 (311) 136 5282","+92 (326) 672 2210","+92 (323) 076 1370","+92 (305) 210 4504","+92 (323) 834 8236","+92 (302) 425 4403","+92 (318) 336 1325","+92 (335) 340 1847","+92 (316) 165 7848","+92 (303) 121 8036","+92 (322) 014 0663","+92 (303) 178 6580","+92 (315) 604 1032","+92 (318) 777 7127","+92 (303) 801 0731","+92 (324) 874 4252","+92 (323) 772 5020","+92 (324) 123 5511","+92 (324) 361 3683","+92 (303) 001 5461","+92 (304) 682 8504","+92 (332) 562 5224","+92 (304) 262 8807","+92 (305) 314 8151","+92 (331) 254 1780","+92 (307) 577 5812","+92 (301) 008 5052","+92 (337) 183 3788","+92 (330) 357 2760","+92 (315) 167 5753","+92 (322) 267 3232","+92 (313) 075 3123","+92 (338) 477 0012","+92 (317) 130 5726","+92 (326) 281 4226","+92 (333) 568 8062","+92 (317) 422 1660","+92 (301) 720 8626","+92 (302) 410 5526","+92 (326) 844 4805","+92 (301) 723 3603","+92 (328) 830 4776","+92 (305) 488 1204","+92 (332) 407 0326","+92 (301) 747 4714","+92 (333) 112 8873","+92 (308) 464 8353","+92 (322) 377 1834","+92 (323) 112 7256","+92 (302) 057 2273","+92 (328) 111 4086","+92 (314) 754 5812","+92 (337) 065 0672","+92 (327) 304 5525","+92 (331) 706 7060","+92 (326) 842 0557","+92 (318) 757 5610","+92 (322) 262 7500","+92 (308) 487 4450","+92 (310) 325 5215","+92 (315) 273 2531","+92 (328) 525 4201","+92 (301) 268 2380","+92 (303) 255 6243","+92 (318) 176 6448","+92 (300) 530 5801","+92 (318) 774 2284","+92 (317) 240 7745","+92 (303) 676 6783","+92 (330) 717 1205","+92 (336) 737 4067","+92 (322) 524 6531","+92 (303) 405 3577","+92 (322) 758 4304","+92 (305) 837 4377","+92 (323) 655 6411","+92 (312) 658 0070","+92 (324) 535 2735","+92 (334) 527 6220","+92 (302) 445 5428","+92 (317) 086 7076","+92 (316) 341 8151","+92 (317) 112 5715","+92 (314) 740 6752","+92 (304) 155 0421","+92 (306) 061 8135","+92 (324) 760 5853","+92 (326) 385 2458","+92 (338) 644 4116","+92 (312) 467 0330","+92 (332) 164 8136","+92 (332) 338 6288","+92 (305) 176 7874","+92 (337) 135 0287","+92 (327) 837 2660","+92 (334) 634 6377","+92 (334) 863 5246","+92 (315) 478 0036","+92 (302) 148 0766","+92 (330) 642 7017","+92 (333) 756 1563","+92 (304) 270 5240","+92 (327) 345 3262","+92 (315) 165 5068","+92 (312) 675 3868","+92 (328) 868 7680","+92 (304) 473 8118","+92 (318) 415 3416","+92 (311) 881 5740","+92 (313) 302 7407","+92 (307) 738 4570","+92 (311) 541 8247","+92 (300) 644 0706","+92 (334) 708 5770","+92 (301) 442 4742","+92 (313) 753 5365","+92 (315) 651 4668","+92 (316) 616 6408","+92 (334) 112 6355","+92 (324) 422 7760","+92 (336) 786 4805","+92 (338) 860 4180","+92 (317) 404 1136","+92 (333) 506 7452","+92 (331) 885 5308","+92 (327) 883 1783","+92 (306) 331 1388","+92 (301) 421 3682","+92 (318) 025 1434","+92 (333) 122 3674","+92 (314) 657 6471","+92 (306) 180 2386","+92 (315) 572 5133","+92 (311) 620 3644","+92 (318) 451 6657","+92 (327) 868 4180","+92 (327) 315 1422","+92 (325) 655 6065","+92 (312) 653 7064","+92 (324) 168 2330","+92 (325) 233 0561","+92 (330) 726 8615","+92 (316) 076 2140","+92 (325) 782 5605","+92 (332) 652 6485","+92 (322) 807 1788","+92 (305) 656 1200","+92 (317) 514 6875","+92 (313) 577 4641","+92 (325) 802 4317","+92 (323) 530 4064","+92 (316) 265 6040","+92 (331) 882 5661","+92 (312) 652 6383","+92 (307) 804 3032","+92 (334) 753 7100","+92 (317) 787 6787","+92 (312) 567 6467","+92 (300) 210 0430","+92 (325) 313 2488","+92 (311) 284 7758","+92 (325) 440 7610","+92 (336) 136 3610","+92 (302) 021 3846","+92 (310) 878 6343","+92 (331) 727 3114","+92 (306) 350 5763","+92 (316) 622 0084","+92 (322) 743 7554","+92 (307) 757 3552","+92 (325) 104 4534","+92 (306) 747 0562","+92 (330) 741 7754","+92 (321) 513 6244","+92 (304) 678 1280","+92 (308) 018 3212","+92 (311) 238 3186","+92 (318) 450 4783","+92 (302) 362 2165","+92 (323) 576 3067","+92 (328) 006 8543","+92 (318) 306 5310","+92 (326) 533 7647","+92 (330) 845 8535","+92 (325) 217 0370","+92 (336) 746 1107","+92 (312) 624 5734","+92 (306) 286 0504","+92 (301) 063 5608","+92 (325) 641 3545","+92 (311) 785 5360","+92 (331) 808 5821","+92 (331) 257 3212","+92 (320) 871 1021","+92 (313) 054 6555","+92 (327) 133 2437","+92 (336) 210 8837","+92 (301) 062 0603","+92 (308) 673 3162","+92 (327) 547 5486","+92 (317) 571 8081","+92 (303) 517 0081","+92 (326) 065 5272","+92 (335) 261 7380","+92 (335) 346 1654","+92 (328) 571 1571","+92 (300) 125 7047","+92 (320) 712 7327","+92 (332) 564 7345","+92 (322) 256 1152","+92 (320) 830 7246","+92 (300) 806 2421","+92 (301) 434 7814","+92 (314) 076 8230","+92 (325) 168 2023","+92 (336) 466 6411","+92 (335) 470 7667","+92 (334) 447 2776","+92 (302) 708 3706","+92 (302) 852 5785","+92 (336) 522 8808","+92 (314) 180 7243","+92 (308) 470 5136","+92 (333) 084 8324","+92 (330) 437 0843","+92 (328) 810 1775","+92 (313) 708 1215","+92 (317) 756 8871","+92 (317) 232 8002","+92 (306) 024 7223","+92 (338) 241 8280","+92 (323) 870 0517","+92 (336) 064 0476","+92 (318) 616 5257","+92 (301) 043 1286","+92 (332) 178 6454","+92 (318) 322 5100","+92 (318) 184 4084","+92 (334) 768 8286","+92 (312) 626 6142","+92 (333) 326 6448","+92 (318) 521 5065","+92 (322) 381 5162","+92 (327) 056 2443","+92 (316) 384 0387","+92 (331) 157 8358","+92 (333) 751 6550","+92 (305) 563 3313","+92 (324) 220 1570","+92 (321) 057 0564","+92 (302) 853 8342","+92 (325) 002 4156","+92 (322) 274 6885","+92 (308) 574 2308","+92 (303) 782 2721","+92 (313) 267 8741","+92 (327) 877 4073","+92 (321) 831 3254","+92 (318) 037 4838","+92 (317) 254 0628","+92 (331) 344 1636","+92 (332) 273 5453","+92 (318) 161 8138","+92 (338) 315 8803","+92 (330) 378 8120","+92 (327) 125 6506","+92 (338) 631 4447","+92 (310) 504 1341","+92 (337) 303 1074","+92 (303) 416 3713","+92 (322) 821 7811","+92 (331) 872 3252","+92 (318) 604 6676","+92 (316) 383 1662","+92 (317) 485 6302","+92 (313) 715 3725","+92 (336) 035 3047","+92 (310) 101 4524","+92 (305) 463 8322","+92 (305) 366 1783","+92 (325) 388 5600","+92 (325) 746 6638","+92 (322) 833 8176","+92 (305) 356 3327","+92 (311) 560 5884","+92 (338) 171 4428","+92 (305) 340 2644","+92 (324) 147 0156","+92 (333) 420 5426","+92 (318) 165 2608","+92 (326) 184 5407","+92 (316) 111 8046","+92 (314) 624 7880","+92 (313) 084 7725","+92 (328) 063 2444","+92 (334) 618 7113","+92 (337) 276 0888","+92 (327) 528 8026","+92 (312) 310 0130","+92 (317) 721 0874","+92 (308) 847 1172","+92 (300) 428 8126","+92 (302) 077 3722","+92 (314) 325 2543","+92 (313) 506 1302","+92 (305) 122 3737","+92 (302) 752 6357","+92 (324) 022 6028","+92 (338) 222 7078","+92 (320) 213 7517","+92 (331) 213 8817","+92 (310) 068 5358","+92 (338) 620 5566","+92 (335) 626 8240","+92 (315) 652 1817","+92 (332) 846 6577","+92 (335) 885 7711","+92 (317) 887 6852","+92 (306) 000 3508","+92 (302) 874 1686","+92 (314) 762 2085","+92 (337) 844 7485","+92 (330) 777 1026","+92 (336) 716 4556","+92 (301) 108 6281","+92 (335) 254 1552","+92 (311) 054 3172","+92 (333) 552 0287","+92 (303) 186 8664","+92 (325) 041 6053","+92 (301) 514 7068","+92 (336) 823 2382","+92 (307) 353 0800","+92 (333) 704 3385","+92 (310) 437 4860","+92 (321) 585 5306","+92 (317) 407 7052","+92 (314) 302 1804","+92 (323) 408 8585","+92 (335) 354 4567","+92 (301) 376 5687","+92 (326) 467 4706","+92 (301) 821 2724","+92 (304) 034 4315","+92 (335) 716 3762","+92 (308) 133 5733","+92 (337) 284 0511","+92 (324) 341 2386","+92 (328) 235 4226","+92 (316) 126 8582","+92 (302) 242 2400","+92 (318) 340 6838","+92 (322) 256 2733","+92 (335) 374 3860","+92 (334) 715 5133","+92 (306) 317 2016","+92 (320) 828 8337","+92 (328) 534 2567","+92 (326) 617 6452","+92 (314) 720 4233","+92 (317) 023 4610","+92 (314) 713 7561","+92 (328) 222 1817","+92 (335) 283 2364","+92 (332) 363 6001","+92 (326) 540 1332","+92 (316) 624 0821","+92 (336) 052 4752","+92 (310) 514 6312","+92 (323) 112 3030","+92 (300) 263 2664","+92 (328) 037 1480","+92 (317) 538 0664","+92 (336) 631 3570","+92 (303) 410 4255","+92 (332) 450 1286","+92 (310) 537 6050","+92 (300) 200 1104","+92 (336) 175 6245","+92 (301) 852 4125","+92 (334) 276 6570","+92 (337) 673 8378","+92 (306) 041 1858","+92 (325) 443 2745","+92 (310) 277 2755","+92 (330) 161 2625","+92 (320) 364 2646","+92 (337) 048 3076","+92 (311) 565 0688","+92 (303) 445 1032","+92 (327) 263 6168","+92 (324) 784 1040","+92 (320) 572 0418","+92 (333) 482 1875","+92 (338) 544 5218","+92 (306) 618 5530","+92 (320) 000 2431","+92 (328) 346 4248","+92 (332) 241 7422","+92 (305) 440 0012","+92 (324) 451 2733","+92 (318) 255 4867","+92 (302) 738 4437","+92 (332) 427 0108","+92 (321) 300 0483","+92 (302) 680 1783","+92 (313) 533 7440","+92 (333) 605 7573","+92 (322) 606 4167","+92 (334) 818 6024","+92 (333) 053 6064","+92 (333) 245 4261","+92 (300) 423 7811","+92 (321) 128 1720","+92 (328) 265 3640","+92 (337) 888 3112","+92 (326) 761 5407","+92 (320) 155 7256","+92 (320) 404 0628","+92 (333) 180 1576","+92 (318) 046 1405","+92 (335) 167 6683","+92 (317) 007 1388","+92 (337) 540 5800","+92 (333) 043 8586","+92 (322) 788 8264","+92 (308) 307 2054","+92 (315) 011 7121","+92 (333) 822 8314","+92 (337) 660 5386","+92 (332) 535 5188","+92 (333) 328 5115","+92 (337) 228 5066","+92 (323) 412 4062","+92 (314) 134 6276","+92 (327) 507 2674","+92 (307) 271 8722","+92 (325) 348 0843","+92 (325) 380 8821","+92 (335) 070 7356","+92 (330) 416 5243","+92 (334) 022 5371","+92 (324) 703 3150","+92 (310) 430 7387","+92 (336) 308 8663","+92 (311) 116 3886","+92 (338) 572 2043","+92 (326) 715 5632","+92 (316) 287 4021","+92 (314) 304 1511","+92 (333) 150 1405","+92 (318) 774 6731","+92 (322) 810 2760","+92 (304) 038 5777","+92 (312) 210 7703","+92 (321) 074 6620","+92 (316) 381 0633","+92 (314) 258 1186","+92 (338) 100 7238","+92 (320) 556 5551","+92 (316) 306 2785","+92 (332) 221 1403","+92 (324) 626 2883","+92 (316) 246 2304","+92 (332) 648 0665","+92 (332) 243 1842","+92 (308) 486 6277","+92 (315) 238 6624","+92 (315) 357 2316","+92 (305) 775 7086","+92 (327) 373 1063","+92 (328) 247 3277","+92 (318) 154 2306","+92 (325) 018 0763","+92 (336) 606 1040","+92 (326) 403 0727","+92 (315) 250 5275","+92 (308) 066 1265","+92 (333) 568 1424","+92 (300) 786 2857","+92 (323) 435 1550","+92 (333) 727 8435","+92 (310) 881 5112","+92 (307) 882 5312","+92 (302) 445 8778","+92 (311) 800 0008","+92 (317) 640 7531","+92 (333) 237 6177","+92 (318) 464 0016","+92 (305) 006 1547","+92 (322) 875 7103","+92 (301) 556 0062","+92 (336) 871 6340","+92 (322) 065 3615","+92 (316) 823 7423","+92 (318) 444 7450","+92 (303) 666 6444","+92 (336) 070 6183","+92 (320) 016 2208","+92 (322) 622 0766","+92 (333) 537 5127","+92 (330) 377 4220","+92 (313) 405 2686","+92 (323) 406 6056","+92 (300) 037 8734","+92 (305) 848 4165","+92 (321) 704 8336","+92 (303) 182 0734","+92 (316) 225 5822","+92 (307) 046 6381","+92 (337) 788 2286","+92 (338) 042 2458","+92 (336) 778 4674","+92 (306) 203 7522","+92 (315) 370 0243","+92 (300) 038 1033","+92 (322) 083 3875","+92 (316) 148 6546","+92 (300) 668 2808","+92 (323) 430 2560","+92 (320) 414 7440","+92 (300) 800 6458","+92 (314) 470 1187","+92 (325) 327 8826","+92 (327) 547 4614","+92 (337) 774 7418","+92 (314) 011 6573","+92 (306) 580 1362","+92 (337) 131 8866","+92 (312) 276 3010","+92 (328) 753 2824","+92 (305) 273 1681","+92 (338) 886 4573","+92 (314) 136 2268","+92 (323) 380 3355","+92 (314) 824 8845","+92 (334) 431 2253","+92 (307) 156 7677","+92 (333) 117 0783","+92 (331) 013 5573","+92 (300) 870 5171","+92 (338) 028 5733","+92 (335) 118 7133","+92 (312) 463 5666","+92 (331) 440 6131","+92 (316) 487 3805","+92 (326) 624 0734","+92 (314) 863 7845","+92 (316) 181 2687","+92 (301) 835 2063","+92 (331) 882 5684","+92 (333) 110 8655","+92 (305) 583 0513","+92 (301) 864 0378","+92 (307) 834 2234","+92 (302) 288 0455","+92 (316) 843 1038","+92 (304) 765 1721","+92 (321) 547 6215","+92 (312) 507 5302","+92 (338) 832 2811","+92 (314) 575 4485","+92 (314) 045 7821","+92 (313) 330 7751","+92 (313) 458 1023","+92 (312) 237 1866","+92 (328) 158 5722","+92 (301) 663 6682","+92 (313) 044 2852","+92 (331) 108 2005","+92 (331) 230 4222","+92 (323) 437 2121","+92 (324) 727 5827","+92 (303) 356 2517","+92 (333) 284 0116","+92 (300) 821 0324","+92 (310) 552 0533","+92 (334) 616 7264","+92 (325) 056 4214","+92 (334) 353 3453","+92 (338) 185 7472","+92 (327) 830 4315","+92 (325) 183 3332","+92 (301) 802 7623","+92 (333) 257 3838","+92 (317) 502 8321","+92 (300) 226 5635","+92 (308) 535 3013","+92 (313) 472 6065","+92 (307) 016 1843","+92 (301) 661 1410","+92 (331) 543 0253","+92 (328) 284 0678"};
#define randPhone() randFrom(rfnss)
#define rand_phone randPhone
#define koiPhoneNumber randPhone
#define koi_phone_number randPhone
#define kisiPhoneNumber randPhone
#define kisi_phone_number randPhone
const string_array rgynss = {"Ahmed Raza","Bilal Tariq","Usman Siddiqi","Omar Farooq","Waleed Kamal","Talha Iqbal","Faisal Latif","Hassan Jameel","Adnan Bashir","Kashif Rauf","Imran Saeed","Adeel Qureshi","Zeeshan Hashmi","Shoaib Nadeem","Noman Shahid","Faizan Khalid","Hammad Zubair","Naveed Aslam","Waqar Mehmood","Sarmad Sheikh","Tariq Anwar","Junaid Riaz","Sufyan Abbas","Shahzad Hussain","Mudassir Younas","Jawad Hamid","Ammar Khalil","Rizwan Waheed","Hasnain Saleem","Basit Jamal","Sheraz Ahmed","Umer Shahbaz","Arsalan Hashim","Raheel Sultan","Fahad Zaman","Sajid Irfan","Owais Rauf","Sarfaraz Kamran","Khizar Ali","Ahsan Waseem","Tauseef Haroon","Murtaza Shah","Maaz Asif","Samiullah Arif","Nabeel Qamar","Taimoor Rauf","Atif Nawaz","Hashir Siddiqui","Zubair Imran","Abrar Hussain","Farhan Waseem","Umair Tariq","Arif Ali","Shayan Latif","Irfan Khalid","Hamza Masood","Sameer Riaz","Shoaib Hanif","Adil Jameel","Ahmed Saeed","Mudassir Kamal","Haris Younas","Noman Waqar","Waseem Abbas","Faizan Rauf","Mubashir Jamil","Sohail Shahzad","Ubaid Latif","Sikandar Saeed","Hasham Khalid","Farrukh Hussain","Zain Qureshi","Arslan Abbas","Muzammil Tariq","Usama Rasheed","Adeel Sultan","Taha Iqbal","Kamil Arshad","Danish Rauf","Talal Farooq","Sarmad Mehmood","Shoaib Azhar","Omer Siddiqi","Dawood Mushtaq","Ammar Waheed","Fasih Shah","Adnan Khalil","Imran Waseem","Waleed Anwar","Yasir Rauf","Arham Bashir","Shehryar Latif","Azhar Siddiqui","Jibran Hussain","Hassan Qamar","Usman Kamal","Tariq Yousaf","Owais Farooq","Raheel Bashir","Waqas Khalid","Faisal Shah","Bilal Latif","Zeeshan Abbas","Faizan Hussain","Mudassir Farooq","Kashif Khalid","Abrar Tariq","Umair Siddiqi","Hamza Jameel","Nabeel Usman","Khalil Laghari","Murtaza Waseem","Sajid Waheed","Noman Riaz","Hashir Hussain","Sheraz Rauf","Ahmed Tariq","Atif Bashir","Omar Siddiqui","Irfan Khalil","Raheel Jamil","Tauseef Rauf","Hammad Abbas","Hasnain Kamran","Waleed Hussain","Taimoor Abbas","Mudassir Waheed","Umer Khalid","Khurram Anwar","Junaid Bashir","Shayan Rauf","Ahmed Hanif","Bilal Hussain","Umair Riaz","Zubair Khalid","Adeel Haroon","Sajid Qamar","Faizan Latif","Hammad Saleem","Shoaib Tariq","Noman Anwar","Fahad Hussain","Hashim Waseem","Hamza Abbas","Arsalan Khalid","Taha Rasheed","Usama Farooq","Sarim Bashir","Khizar Waheed","Mudassir Khalid","Waqas Rauf","Tariq Hussain","Jawad Siddiqui","Shehryar Abbas","Naveed Tariq","Muzammil Jamil","Zeeshan Khalid","Atif Hussain","Sarmad Waqar","Shoaib Khalid","Ahmed Qureshi","Raheel Abbas","Hammad Riaz","Sheraz Bashir","Danish Khalid","Adil Waheed","Hashir Tariq","Faizan Waseem","Usman Abbas","Khurram Latif","Owais Siddiqui","Mudassir Hussain","Tauseef Khalid","Farrukh Waseem","Umer Saleem","Hamza Rauf","Shoaib Kamran","Bilal Abbas","Sajid Tariq","Faizan Shahbaz","Hasnain Abbas","Abrar Khalid","Ahmed Farooq","Atif Khalid","Irfan Waseem","Junaid Tariq","Umair Saleem","Arsalan Hussain","Waleed Abbas","Adnan Waseem","Sheraz Khalid","Mudassir Abbas","Shoaib Rauf","Omar Hussain","Raheel Khalid","Hammad Waseem","Waseem Farooq","Hasham Tariq","Faisal Khalid","Kashif Abbas","Tauseef Abbas","Hamza Saleem","Zeeshan Waseem","Sarmad Hussain","Bilal Khalid","Umair Abbas","Mudassir Riaz","Adil Khalid","Ahmed Abbas","Owais Hussain"};
const string_array rglnss = {"Ayesha Waleed","Fatima Kamal","Hira Latif","Sana Farooq","Mahnoor Tariq","Faiza Tehseem","Fozia Mehshar","Iqra Siddiqui","Laiba Aslam","Anum Riaz","Saba Kiani","Hafsa Saeed","Sidra Hashmi","Zunaira Naz","Sadaf Bhutto","Kiran Jameel","Rida Abbas","Nimra Waseem","Huma Tariq","Samina Khalid","Zeenat Rauf","Amna Waheed","Neelam Hashmi","Aiman Qamar","Romaisa Hussain","Fareeda Asif","Sania Anwar","Humaisa Khalil","Asma Riaz","Sadia Kamran","Sehrish Waseem","Uzma Tariq","Mehwish Latif","Hina Abbas","Areeba Waqar","Tanzeela Jafar","Anila Saleem","Mahira Umer","Bushra Nadeem","Zoya Mehmood","Nida Hashim","Sumaira Yasir","Mahnoor Hussain","Komal Saeed","Laiba Waseem","Amina Abbas","Rida Jameel","Saeeka Haroon","Zainab Farooq","Fatima Hussain","Hafsa Mehmood","Minal Khawar","Yumna Tariq","Ayeza Barkat","Asia Farhan","Kinza Jamal","Mehwish Touseef","Rimsha Ibrahim","Neelam Saeed","Hira Khalid","Amna Riaz","Iqra Farooq","Anum Abbas","Mehwish Iqrar","Sumaiya Tariq","Romaisa Khalil","Faiza Waseem","Bushra Farooq","Sadia Abbas","Hiba Hussain","Afshan Siddiqui","Sana Basit","Areeba Khalid","Maira Waseem","Nimra Hussain","Sehrish Saleem","Amna Jameel","Zoya Khalid","Mehreen Tariq","Aiman Abbas","Komal Riaz","Hira Saleem","Palwasha Moazzam","Laiba Nayyar","Minahal Tahir","Mehwish Shuja","Javeria Feroze","Zara Munawwar","Fiza Jatoi","Fatima Riaz","Zainab Alvi","Tanzeela Abbas","Kiran Waseem","Ayesha Khalid","Samina Hussain","Sadia Waseem","Bisma Majeed","Areeba Latif","Sehrish Tariq","Hafsa Waseem","Hina Tariq","Zoya Saleem","Maham Khalid","Muneera Rauf","Bushra Tariq","Zeenat Hussain","Areeba Saleem","Kainat Rizvi","Sumaiya Hussain","Sadia Khalid","Mahnoor Irshad","Fatima Jameel","Sakina Hilaj","Iqra Danyal","Hina Riaz","Neha Saleem","Mehwish Khalid","Asma Waseem","Romaisa Tariq","Laiba Khalid","Komal Noor","Bushra Waseem","Zainab Tariq","Sadia Saleem","Kiran Jamshed","Uzmia Sayyad","Komal Hussain","Maryam Raza","Romaisa Haroon","Mehwish Abbas","Maham Riaz","Sumaiya Khalid","Anila Anjum","Areeba Hussain"};
#define randGuyName() randFrom(rgynss)
#define randGirlName() randFrom(rglnss)
#define koiLarkaNaam randGuyName
#define koi_larka_naam randGuyName
#define kisiLarkeNaam randGuyName
#define kisi_larke_naam randGuyName
#define koiLarkiNaam randGirlName
#define koi_larki_naam randGirlName
#define kisiLarkiNaam randGirlName
#define kisi_larki_naam randGirlName
const string_array areas_in_karachi = {"Askari 1","Askari 2","Askari 3","Askari 4","Askari 5","Bahria Town - Precinct 1","Bahria Town - Precinct 10","Bahria Town - Precinct 11","Bahria Town - Precinct 12","Bahria Town - Precinct 13","Bahria Town - Precinct 14","Bahria Town - Precinct 15","Bahria Town - Precinct 16","Bahria Town - Precinct 17","Bahria Town - Precinct 18","Bahria Town - Precinct 19","Bahria Town - Precinct 2","Bahria Town - Precinct 20","Bahria Town - Precinct 21","Bahria Town - Precinct 22","Bahria Town - Precinct 23","Bahria Town - Precinct 24","Bahria Town - Precinct 25","Bahria Town - Precinct 26","Bahria Town - Precinct 27","Bahria Town - Precinct 28","Bahria Town - Precinct 29","Bahria Town - Precinct 3","Bahria Town - Precinct 30","Bahria Town - Precinct 31","Bahria Town - Precinct 32","Bahria Town - Precinct 33","Bahria Town - Precinct 4","Bahria Town - Precinct 5","Bahria Town - Precinct 6","Bahria Town - Precinct 7","Bahria Town - Precinct 8","Bahria Town - Precinct 9","BufferZone - Sector 15 A 1","BufferZone - Sector 15 A 2","BufferZone - Sector 15 A 3","BufferZone - Sector 15 A 4","BufferZone - Sector 15 A 5","BufferZone - Sector 15 B","BufferZone - Sector 16 A","BufferZone - Sector 16 B","Cantonment","Clifton - Block 1","Clifton - Block 2","Clifton - Block 3","Clifton - Block 4","Clifton - Block 5","Clifton - Block 6","Clifton - Block 7","Clifton - Block 8","Clifton - Block 9","Clifton - Kehkashan","DHA - Phase 1","DHA - Phase 2","DHA - Phase 3","DHA - Phase 4","DHA - Phase 5","DHA - Phase 6","DHA - Phase 7","DHA - Phase 8","DHA - Phase 9","F.B Area - Azizabad","F.B Area - B1 Area","F.B Area - B Area","F.B Area - Block 1","F.B Area - Block 10","F.B Area - Block 11","F.B Area - Block 12","F.B Area - Block 13","F.B Area - Block 14","F.B Area - Block 15","F.B Area - Block 16","F.B Area - Block 17","F.B Area - Block 18","F.B Area - Block 19","F.B Area - Block 2","F.B Area - Block 20","F.B Area - Block 21","F.B Area - Block 22","F.B Area - Block 3","F.B Area - Block 4","F.B Area - Block 5","F.B Area - Block 6","F.C Area - C1 Area","F.C Area - C Area","Garden - Garden East","Garden - Garden West","Garden - Soldier Bazaar","Gulistan-e-Johar - Block 1","Gulistan-e-Johar - Block 10","Gulistan-e-Johar - Block 11","Gulistan-e-Johar - Block 12","Gulistan-e-Johar - Block 13","Gulistan-e-Johar - Block 14","Gulistan-e-Johar - Block 15","Gulistan-e-Johar - Block 16","Gulistan-e-Johar - Block 17","Gulistan-e-Johar - Block 18","Gulistan-e-Johar - Block 19","Gulistan-e-Johar - Block 2","Gulistan-e-Johar - Block 20","Gulistan-e-Johar - Block 3","Gulistan-e-Johar - Block 4","Gulistan-e-Johar - Block 5","Gulistan-e-Johar - Block 6","Gulistan-e-Johar - Block 7","Gulistan-e-Johar - Block 8","Gulistan-e-Johar - Block 9","Gulshan-e-Hadeed - Data Nagar","Gulshan-e-Hadeed - EIDU Goth","Gulshan-e-Hadeed - Gulshan-e-Mauzzam","Gulshan-e-Hadeed - Gulshan-e-Rehman","Gulshan-e-Hadeed - Mehran Road","Gulshan-e-Hadeed - Phase 1","Gulshan-e-Hadeed - Phase 2","Gulshan-e-Hadeed - Phase 3","Gulshan-e-Hadeed - PTCL Satellite Station","Gulshan-e-Hadeed - Shah Latif Town","Gulshan-e-Hadeed - Shahnawaz Goth","Gulshan-e-Hadeed - Shah Town","Gulshan-e-Hadeed - Steel Town","Gulshan-e-Hadeed - TCP Godowns","Gulshan-e-Iqbal - Adamjee Nagar","Gulshan-e-Iqbal - Block 1","Gulshan-e-Iqbal - Block 10","Gulshan-e-Iqbal - Block 11","Gulshan-e-Iqbal - Block 12","Gulshan-e-Iqbal - Block 13","Gulshan-e-Iqbal - Block 14","Gulshan-e-Iqbal - Block 15","Gulshan-e-Iqbal - Block 16","Gulshan-e-Iqbal - Block 17","Gulshan-e-Iqbal - Block 18","Gulshan-e-Iqbal - Block 19","Gulshan-e-Iqbal - Block 2","Gulshan-e-Iqbal - Block 3","Gulshan-e-Iqbal - Block 4","Gulshan-e-Iqbal - Block 5","Gulshan-e-Iqbal - Block 6","Gulshan-e-Iqbal - Block 7","Gulshan-e-Iqbal - Block 8","Gulshan-e-Iqbal - Block 9","Gulshan-e-Iqbal - Civic Center","Gulshan-e-Iqbal - Dhoraji","Korangi - Abdullah Shah Noorani Pahari Colony","Korangi - Korangi Industrial Area","Korangi - Nasir Colony","Korangi - PAF Base Korangi Creek","Korangi - Zaman Town","Korangi - Zia Colony","Landhi - Alflah Housing Society","Landhi - Awami Colony","Landhi - Bagh-e-Korangi","Landhi - Bakhtawar Goth","Landhi - Barmi Colony","Landhi - Bhutto Nagar","Landhi - Future Colony","Landhi - Gulshan-e-Rafi","Landhi - Ilyas Goth","Landhi - Labour Colony","Landhi - Landhi Industrial Area","Landhi - Muslimabad Colony","Landhi - Muzaffarabad Colony","Landhi - Punjab Town","Landhi - Qasim Town","Landhi - Sadat Colony","Landhi - Shah Khalid Colony","Landhi - Sharafi Goth","Landhi - Zamanabad","Liaquatabad - Block 1","Liaquatabad - Block 10","Liaquatabad - Block 2","Liaquatabad - Block 3","Liaquatabad - Block 4","Liaquatabad - Block 5","Liaquatabad - Block 6","Liaquatabad - Block 7","Liaquatabad - Block 8","Liaquatabad - Block 9","Malir - Malir Halt","Malir - Malir Cantt","Nazimabad - Block 1","Nazimabad - Block 2","Nazimabad - Block 3","Nazimabad - Block 4","Nazimabad - Block 5","North Karachi - Sector 10","North Karachi - Sector 11 - A","North Karachi - Sector 11 - B","North Karachi - Sector 11 - C 1","North Karachi - Sector 11 - C 2","North Karachi - Sector 11 - C 3","North Karachi - Sector 11 - E","North Karachi - Sector 11 - H","North Karachi - Sector 11 - I","North Karachi - Sector 11 - K","North Karachi - Sector 11 - L","North Karachi - Sector 2","North Karachi - Sector 3","North Karachi - Sector 4","North Karachi - Sector 5 - A 1","North Karachi - Sector 5 - A 2","North Karachi - Sector 5 - A 3","North Karachi - Sector 5 - A 4","North Karachi - Sector 5 - B 1","North Karachi - Sector 5 - B 2","North Karachi - Sector 5 - B 3","North Karachi - Sector 5 - B 4","North Karachi - Sector 5 - C 1","North Karachi - Sector 5 - C 2","North Karachi - Sector 5 - C 3","North Karachi - Sector 5 - C 4","North Karachi - Sector 5 - I","North Karachi - Sector 5 - J","North Karachi - Sector 5 - K","North Karachi - Sector 5 - L","North Karachi - Sector 5 - M","North Karachi - Sector 6","North Karachi - Sector 7 - D 1","North Karachi - Sector 7 - D 2","North Karachi - Sector 7 - D 3","North Karachi - Sector 7 - D 4","North Karachi - Sector 8","North Karachi - Sector 9","North Nazimabad - Block A","North Nazimabad - Block B","North Nazimabad - Block C","North Nazimabad - Block D","North Nazimabad - Block E","North Nazimabad - Block F","North Nazimabad - Block G","North Nazimabad - Block H","North Nazimabad - Block I","North Nazimabad - Block J","North Nazimabad - Block K","North Nazimabad - Block L","North Nazimabad - Block M","North Nazimabad - Block N","North Nazimabad - Block O","North Nazimabad - Block P","North Nazimabad - Block Q","North Nazimabad - Block R","North Nazimabad - Block S","North Nazimabad - Block T","Old Town - Bhimpora","Old Town - Bohra Pir","Old Town - Bombay Bazar","Old Town - Jodia Bazar","Old Town - Kagzi Bazar","Old Town - Kakri Ground","Old Town - Kamil Gali","Old Town - Khada Market","Old Town - Kharadar","Old Town - Lee Market","Old Town - Mithadar","Old Town - Nanwara","Old Town - Nishter Road","Old Town - Pan Mandi","Old Town - Ramswami","Old Town - Ranchorline","Orangi Town - Banaras Town","Orangi Town - Bangla Bazaar","Orangi Town - Bilal Colony","Orangi Town - Katti Pahari","Orangi Town - Moria Goth Orangi","Orangi Town - Orangi","Orangi Town - Sector 14 - A","Orangi Town - Sector 14 - C","Orangi Town - Thorani Goth","Baldiya Town","Baloch Colony","Civil Line","FC Area","Firdous Colony","Gulshan-e-Maymar","Hawksbay","I.I Chundrigar","Jamshed Road","K.D.A Officers","Kemari","Liyari","M.A Jinnah Rd","Manora","New Karachi","New Surjani","PIB Colony","Pipri Goth","Rizvia Society","Saddar","Scheme 33","Shabbirabad","P.E.C.H.S - Block 1","P.E.C.H.S - Block 2","P.E.C.H.S - Block 3","P.E.C.H.S - Block 4","P.E.C.H.S - Block 5","P.E.C.H.S - Block 6","P.E.C.H.S - Khalid Bin Walid","P.E.C.H.S - Tariq Road","S.I.T.E - Golimar","S.I.T.E - S.I.T.E","Shah Faisal Colony - Aswan Town","Shah Faisal Colony - Gulshan-e-Asghar","Shah Faisal Colony - Shah Faisal Colony 1","Shah Faisal Colony - Shah Faisal Colony 5","F.B Area– Block 7","F.B Area - Block 9","P.E.C.H.S - Block 7","Aram Bagh","Bath Island","University Road","Bahadurabad","Shah Faisal Colony - 4","Banglore Town","Fowler Lines","Shah Faisal Colony - Shamsi Society","Gulshan-e-Jamal","Shah Faisal Colony - 3","Shah Faisal Colony - Green Town","Darwaish Colony","Korangi - Sector 31 B","Firdous Colony","North Nazimabad - Block W","K.A.E.C.H.S","Mehmoodabad","Korangi - Mehran Town","Landhi Town - 36 B","Karachi Memon Society","Madras Cooperative Housing Society","Shahrah-e-Faisal","Korangi - Sector 41 B","Clifton - Delhi Colony","Korangi - Sector 32 B","Dhoraji - Adamjee Nagar","Bhimpura","Dhoraji - CP& Berar Society","Shahra-e-Faisal - Umar Colony","Model Colony","Gulshan-e-Shamim","Clifton - Shah Rasool Colony","North Karachi - Sector 12 C","Jail Road - Hyderabad Colony","Napier Quarter","Gulzar-e-Hijri","North Karachi - Sector 12 A","Shahra-e-Faisal - Jinnah Housing Society","K.D.A Scheme 1","Clifton - Punjab Colony","Korangi - Sector 31 D","Clifton - Zamzama","Parsi Colony","Qayyumabad","Khokrapar","Shah Faisal Colony - Muslimabad Malir City","F.B Area - Block 8","Nanak Wara","Mohammad Ali Society","Manzoor Colony","Dalmia","Defence View - Phase 1","Defence View - Phase 2","KDA Officers Housing Society","Karimabad","Soldier Bazar","Hussainabad","Sharfabad Society","Gharibabad","Sindhi Muslim Cooperative Housing Society"};
#define randAreaInKarachi() randFrom(areas_in_karachi)
#define koiKarachiArea randAreaInKarachi
#define koi_karachi_area randAreaInKarachi
#define kisiKarachiArea randAreaInKarachi
#define kisi_karachi_area randAreaInKarachi
const string_array rstcss = {"Your heart is the size of an ocean. Go find yourself in its hidden depths.","The bay of bengal is hit frequently by cyclones. The months of november and may, in particular, are dangerous in this regard.","Thinking is the capital, enterprise is the way, hard work is the solution.","If you can't make it good, at least make it look good.","Heart be brave. If you cannot be brave, just go. Love's glory is not a small thing.","It is bad for a young man to sin; but it is worse for an old man to sin.","If you are out to describe the truth, leave elegance to the tailor.","O man you are busy working for the world, and the world is busy trying to turn you out.","While children are struggling to be unique, the world around them is trying all means to make them look like everybody else.","These capitalists generally act harmoniously and in concert, to fleece the people.","I don't believe in failure. It is not failure if you enjoyed the process.","Do not get elated at any victory, for all such victory is subject to the will of god.","Wear gratitude like a cloak and it will feed every corner of your life.","If you even dream of beating me you'd better wake up and apologize.","I will praise any man that will praise me.","One of the greatest diseases is to be nobody to anybody.","I'm so fast that last night I turned off the light switch in my hotel room and was in bed before the room was dark.","People must learn to hate and if they can learn to hate, they can be taught to love.","Everyone has been made for some particular work, and the desire for that work has been put in every heart.","The less of the world, the freer you live.","Respond to every call that excites your spirit.","The way to get started is to quit talking and begin doing.","God doesn't require us to succeed, he only requires that you try.","Speak any language, turkish, greek, persian, arabic, but always speak with love.","Happiness comes towards those which believe in him.","Knowledge is of two kinds: that which is absorbed and that which is heard. And that which is heard does not profit if it is not absorbed.","When I am silent, I have thunder hidden inside.","Technological progress is like an axe in the hands of a pathological criminal.","No one would choose a friendless existence on condition of having all the other things in the world.","Life is a gamble. You can get hurt, but people die in plane crashes, lose their arms and legs in car accidents; people die every day. Same with fighters: some die, some get hurt, some go on. You just don't let yourself believe it will happen to you.","The end of life is to be like god, and the soul following god will be like him.","Let us sacrifice our today so that our children can have a better tomorrow.","Your task is not to seek for love, but merely to seek and find all the barriers within yourself that you have built against it.","In every religion there is love, yet love has no religion.","Everything in the universe is within you. Ask all from yourself.","I'm not a handsome guy, but I can give my hand to someone who needs help. Beauty is in the heart, not in the face.","What do I wear in bed? Why, chanel no. 5, of course.","A good head and a good heart are always a formidable combination.","The soul never thinks without a picture.","In your light I learn how to love. In your beauty, how to make poems. You dance inside my chest where no-one sees you, but sometimes I do, and that sight becomes this art.","Let the beauty we love be what we do. There are hundreds of ways to kneel and kiss the ground.","If you like your brother and he's prospering, you'll be pleased for him.","Success is dependent upon the glands - sweat glands.","Champions are not generated from the championship. Champion is generated from something they have in them, desires, dreams, and visions.","No matter what is the environment around you, it is always possible to maintain your brand of integrity.","Applause waits on success.","Just as courage imperils life, fear protects it.","It's better to be a lion for a day than a sheep all your life.","The devil's voice is sweet to hear.","Sometimes the people with the worst past, create the best future.","Every day, nay every moment, try to do some good deed.","No matter what people tell you, words and ideas can change the world.","Champions have to have the skill and the will. But the will must be stronger than the skill.","Men occasionally stumble over the truth, but most of them pick themselves up and hurry off as if nothing had happened.","Goodbyes are only for those who love with their eyes. Because for those who love with heart and soul there is no such thing as separation.","The best revenge is to improve yourself.","Success is a personal standard, reaching for the highest that is in us, becoming all that we can be.","When you have really exhausted an experience you always reverence and love it.","Now you see me, now you don't. George thinks he will, but I know he won't!","Elegance does not consist in putting on a new dress.","It is always consoling to think of suicide: in that way one gets through many a bad night.","Eating words has never given me indigestion.","India has to be transformed into a developed nation, a prosperous nation and a healthy nation, with a value system.","It's not bragging if you can back it up.","I wish people would love everybody else the way they love me. It would be a better world.","Why do I want my wife to show off her panties when the wind blows? Horses show their behinds, and cows and mules, not humans.","Words are only painted fire; a look is the fire itself.","Words, without power, is mere philosophy.","The cure for pain is in the pain.","Whatever happens, just keep smiling and lose yourself in love.","Do the right thing. It will gratify some people and astonish the rest.","Only the soul knows what love is.","Earning of livelihood by following some profession is better than living on charity.","Burdens are the foundations of ease and bitter things the forerunners of pleasure.","Too many have dispensed with generosity in order to practice charity.","Even the greatest was once a beginner. Don't be afraid to take that first step.","No great intellectual thing was ever done by great effort.","To fight against one's desires is the greatest of all fights.","Innovation distinguishes between a leader and a follower.","We enjoy the process far more than the proceeds.","When I started counting my blessings, my whole life turned around.","This being human is a guest house. Every morning a new arrival. Welcome and entertain them all!","All my life I've looked at words as though I were seeing them for the first time.","Waiting is painful. Forgetting is painful. But not knowing which to do is the worse kind of suffering.","Never allow someone to be your priority while allowing yourself to be their option.","To jaw-jaw is always better than to war-war.","That's the real trouble with the world, too many people grow up","It is easier to stay out than get out.","The worst man is the one who sees himself as the best.","The world breaks everyone, and afterward, some are strong at the broken places.","Rule no.1: never lose money. Rule no.2: never forget rule no.1.","Convergence of our views on global trade issues under the wto and our common resolve to combat terrorism provide a valuable base for mutual understanding.","Whenever you find yourself on the side of the majority, it is time to pause and reflect.","Whatever is done for love always occurs beyond good and evil.","Things should be made as simple as possible, but not any simpler.","Stop acting so small. You are the universe in ecstatic motion.","All truth is simple... Is that not doubly a lie?","Money is only a tool. It will take you wherever you wish, but it will not replace you as the driver.","The fight is won or lost far away from witnesses - behind the lines, in the gym, and out there on the road, long before I dance under those lights.","He who avoids complaint invites happiness.","We are the mirror - as well as the face in it.","Yesterday I was clever, so I wanted to change the world. Today I am wise, so I am changing myself.","For 2,500 years, india has never invaded anybody.","If past history was all there was to the game, the richest people would be librarians.","Your souls are precious and can only be equal to the price of paradise, therefore sell them only at that price.","A wise man can learn more from a foolish question than a fool can learn from a wise answer.","If allah wants for a people ill, he gives them debates and takes away from them actions.","He who builds a masjid in the way of allah, god will build a house for him in the paradise.","Love is blind; friendship closes its eyes.","Don't go around saying the world owes you a living. The world owes you nothing. It was here first.","An alert and learned man will take advice from any event.","I don't count my sit-ups. I only start counting when it starts hurting. When I feel pain, that's when I start counting, because that's when it really counts.","The wound is the place where the light enters you.","Luxury is an obstacle, and so is the fatness of the body.","Come, come, whoever you are. Wanderer, worshiper, lover of leaving. It doesn't matter. Ours is not a caravan of despair. Come, even if you have broken your vows a thousand times. Come, yet again, come, come.","The golden age is before us, not behind us.","Fiction is the truth inside the lie.","Believe you can and you're halfway there.","All the great things are simple, and many can be expressed in a single word: freedom, justice, honor, duty, mercy, hope.","Allah's the arabic term for god. Stand up for god, fight for god, work for god and do the right thing, and go the right way, things will end up in your corner.","Anger is never without a reason, but seldom with a good one.","Good actions are a guard against the blows of adversity.","Use the same measure for selling that you use for purchasing.","The secret of getting ahead is getting started","I don't know the key to success, but the key to failure is trying to please everybody.","Real loss is only possible when you love something more than you love yourself.","This is the first convention of the space age - where a candidate can promise the moon and mean it.","I don't like that man. I must get to know him better.","To shipbrokers, coal was black gold.","History, despite its wrenching pain, cannot be unlived, but if faced with courage, need not be lived again.","Success is not achieved by winning all the time. Real success comes when we rise after we fall. Some mountains are higher than others. Some roads steeper than the next. There are hardships and setbacks but you cannot let them stop you. Even on the steepest road you must not turn back.","A riot is the language of the unheard.","The law is reason, free from passion.","The people who abandon jihad fall a victim to humility and degradation.","We are all born with a divine fire in us. Our efforts should be to give wings to this fire and fill the world with the glow of its goodness.","Woman was god's second mistake.","All black americans have slave names. They have white names; names that the slave master has given to them.","I'm most proud of my family.","And you? When will you begin that long journey into yourself?","How many lessons there are and how little they are taken.","The best way to make your dreams come true is to wake up.","What one writer can make in the solitude of one room is something no power can easily destroy.","If there is something to pardon in everything, there is also something to condemn.","At home I am a nice guy: but I don't want the world to know. Humble people, I've found, don't get very far.","No amount of guilt can change the past and no amount of worrying can change the future.","Not the ones speaking the same language, but the ones sharing the same feeling understand each other.","It is better to deserve honors and not have them than to have them and not deserve them.","Success is a lousy teacher. It seduces smart people into thinking they can't lose.","Cursed is the man who dies, but the evil done by him survives.","The quality, not the longevity, of one's life is what is important.","Age is whatever you think it is. You are as old as you think you are.","Derivatives are financial weapons of mass destruction.","Don't you know yet? It is your light that lights the worlds.","Hold on to your salah, because if you lose that, you will lose everything else.","I am not this hair. I am not this skin. I am the soul that lives within.","Be faithful in small things because it is in them that your strength lies.","He who sleeps without offering the night prayer, may he never enjoy a sound sleep.","I was influenced a lot by those around me - there was a lot of singing that went on in the cotton fields.","Greed is permanent slavery.","Everything that we see is a shadow cast by that which we do not see.","To the master's honor all must turn, each in its track, without a sound, forever tracing newton's ground.","Women are the field that produces our nation. And if you can't protect your women, you can't protect your nation.","To give victory to the right, not bloody bullets, but peaceful ballots only, are necessary.","The ache for home lives in all of us, the safe place where we can go as we are and not be questioned.","Don't be distracted by criticism. Remember ~ the only taste of success some people have is when they take a bite out of you.","Words are a pretext. It is the inner bond that draws one person to another, not words.","Where there is no struggle, there is no strength.","The function of muscle is to pull and not to push, except in the case of the genitals and the tongue.","Through love, all pain will turn to medicine.","Do not be embarrassed by your failures, learn from them and start over.","I know where I'm going and I know the truth, and I don't have to be what you want me to be. I'm free to be what I want.","He who prays five times a day is in the protection of god, and he who is protected by god cannot be harmed by anyone.","I find hope in the darkest of days, and focus in the brightest. I do not judge the universe.","The wisest among you is he whose sustenance is the fear of allah.","Because I cannot sleep I make music in the night.","Strive not to be a success, but rather to be of value.","If you tell the truth, you don't have to remember anything.","Disneyland will never be completed. It will continue to grow as long as there is imagination left in the world.","If you have good thoughts they will shine out of your face like sunbeams and you will always look lovely.","If you wish to be a mine of jewels, open the deep ocean within your heart.","Let me alone, and go in search of someone else.","A true friend is one who sees a fault, gives you advice and who defends you in your absence.","You can tell whether a man is clever by his answers. You can tell whether a man is wise by his questions.","No one changes the world who isn't obsessed.","The best deed of a great man is to forgive and forget.","One may sometimes tell a lie, but the grimace that accompanies it tells the truth.","Do not hate what you do not know, for the greater part of knowledge consists of what you do not know.","Love begins at home, and it is not how much we do... But how much love we put in that action.","My religion is very simple. My religion is kindness.","There are forces in life working for you and against you. One must distinguish the beneficial forces from the malevolent ones and choose correctly between them.","Beware of little expenses. A small leak will sink a great ship.","All my life through, the new sights of nature made me rejoice like a child.","He who indulges in falsehood will find the paths of paradise shut to him.","Man is descended from a hairy, tailed quadruped, probably arboreal in its habits.","The minute I heard my first love story, I started looking for you.","People of the world don't look at themselves, and so they blame one another.","The truth. It is a beautiful and terrible thing, and must therefore be treated with great caution.","The object of the superior man is truth.","Live amongst people in such a manner that if you die they weep over you and if you are alive they crave for your company.","Pride in the case of a rich man is bad, but pride in the case of a poor man is worse.","Tell me and I forget. Teach me and I remember. Involve me and I learn.","Why is it that we rejoice at a birth and grieve at a funeral? It is because we are not the person involved.","If you have a particular faith or religion, that is good. But you can survive without it.","You don't want no pie in the sky when you die, you want something here on the ground while you're still around.","Don't be satisfied with stories, how things have gone with others. Unfold your own myth.","Purify your eyes, and see the pure world. Your life will fill with radiant forms.","Associating with the wise and the knowledgeable people adds to the prestige of a person.","There is no darkness but ignorance.","All great achievements require time.","One does not leave a convivial party before closing time.","You are not only responsible for what you say, but also for what you do not say.","So go ahead. Fall down. The world looks different from the ground.","When we lose one blessing, another is often most unexpectedly given in its place.","Intelligence is the wife, imagination is the mistress, memory is the servant.","It is a matter of shame that in the morning the birds should be awake earlier than you.","What doesn't kill us makes us stronger.","The weakest man is the one who is able to correct his moral defects, but doesn't take action.","I do not need the idea of god to explain the world I live in.","The highest person is he who is of most use to humankind.","Common sense is the collection of prejudices acquired by age eighteen.","Do not let your difficulties fill you with anxiety, after all it is only in the darkest nights that stars shine more brightly.","Preserve the sayings of those people who are indifferent to the world. They say only that what allah wishes them to say.","I hated every minute of training, but I said, “don't quit. Suffer now and live the rest of your life as a champion.”","The only way to do news on television is not to be terrified of it.","It is a mistake to look too far ahead. Only one link of the chain of destiny can be handled at a time.","I'll destroy you. I am the master of disaster.","I fear the day when the kuffar are proud of their falsehood, and the muslims are shy of their faith.","Stay in college, get the knowledge. And stay there until you're through. If they can make penicillin out of moldy bread, they can sure make something out of you.","Those who dare to fail miserably can achieve greatly.","You show your worth by what you seek.","Acquire knowledge before you become leaders and pride prevents you from learning and you live in ignorance.","Fear is the main source of superstition, and one of the main sources of cruelty. To conquer fear is the beginning of wisdom.","If a free society cannot help the many who are poor, it cannot save the few who are rich.","As he was valiant, I honour him. But as he was ambitious, I slew him.","Who's gonna dare to be great?","He who keeps his own counsel keeps his affairs in his own hands.","To whatever extent a person's knowledge increases, his attention will be turned more towards his soul.","If an ignorant person is attracted by the things of the world, that is bad. But if a learned person is thus attracted, it is worse.","Surely silence can sometimes be the most eloquent reply.","Once your mind stretches to a new level it never goes back to its original dimension.","I was saying “I'm the greatest” long before I believed it.","Our peace shall stand as firm as rocky mountains.","Only buy something that you'd be perfectly happy to hold if the market shut down for 10 years.","Intellectual property has the shelf life of a banana.","He who understands humanity seeks solitude.","I was not created to be occupied by eating delicious foods like tied up cattle.","Time stays long enough for anyone who will use it.","I feel the same way about disco as I do about herpes.","Civilization is the limitless multiplication of unnecessary necessities.","If you hear a voice within you say 'you cannot paint ' then by all means paint, and that voice will be silenced.","When one has not had a good father, one must create one.","I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.","If we cannot now end our differences, at least we can help make the world safe for diversity.","The cautious seldom err.","Admiration for a quality or an art can be so strong that it deters us from striving to possess it.","I myself prefer my new zealand eggs for breakfast.","To line only for some unknown future is superficial.","Money is the barometer of a society's virtue.","Convictions are more dangerous foes of truth than lies.","I have not failed. I've just found 10 000 ways that won't work.","Maybe a thing that you do not like is really in your interest. It is possible that a thing that you may desire may be against your interest.","People always ask me, 'were you funny as a child?' well, no, I was an accountant.","I'm not an expert on the arms race.","Sit with those who love allah, for that enlightens the mind.","You cannot perform in a manner inconsistent with the way you see yourself.","I say that the most liberating thing about beauty is realizing that you are the beholder.","Happiness in intelligent people is the rarest thing I know.","A person who never made a mistake never tried anything new.","In the big leagues everyone has ability. It always comes down to mind games. Who ever is more mentally strong-wins.","Don't take rest after your first victory because if you fail in second, more lips are waiting to say that your first victory was just luck.","Stop learning. Start knowing.","One of the greatest discoveries a man makes, one of his great surprises, is to find he can do what he was afraid he couldn't do.","You are never too old to set another goal or to dream a new dream.","Keep your eyes on the stars, and your feet on the ground.","I know of only one duty, and that is to love.","God helps those who help themselves.","You are not just the drop in the ocean. You are the mighty ocean in the drop.","Teaching is a very noble profession that shapes the character, caliber, and future of an individual. If the people remember me as a good teacher, that will be the biggest honour for me.","A man should never neglect his family for business.","Isn't it strange that I who have written only unpopular books should be such a popular fellow?","Drag your thoughts away from your troubles... By the ears, by the heels, or any other way you can manage it.","The greatest discovery of all time is that a person can change his future by merely changing his attitude.","Whoever listens to slander is himself a slanderer.","The best way to find out if you can trust somebody is to trust them.","Take account of your deeds before they are taken account of.","Faith is taking the first step even when you don't see the whole staircase.","To give thanks in solitude is enough. Thanksgiving has wings and goes where it must go. Your prayer knows much more about it than you do.","Those who dare to fail miserably can achieve greatly.","Like your body your mind also gets tired so refresh it by wise sayings.","God helps those who fear him.","During civil disturbance adopt such an attitude that people do not attach any importance to you - they neither burden you with complicated affairs, nor try to derive any advantage out of you.","Whether you think that you can, or that you can't, you are usually right.","O! Let me not be mad, not mad, sweet heaven; keep me in temper; I would not be mad!","The man with no imagination has no wings.","Today, india is a nuclear weapons state.","The public is merely a multiplied \"Me.\"","If a man could have half of his wishes, he would double his troubles.","There are no moral phenomena at all, but only a moral interpretation of phenomena.","To say \"I love you\" one must first be able to say the \"I.\"","Patience to faith is like the head to the body. The person who has no patience has not faith.","Nations are born in the hearts of poets, they prosper and die in the hands of politicians.","Rivers, ponds, lakes and streams - they all have different names, but they all contain water. Just as religions do - they all contain truths.","The time has come to turn your heart into a temple of fire. Your essence is gold hidden in dust. To reveal its splendor you need to burn in the fire of love.","Only last week I murdered a rock, injured a stone and hospitalized a brick.","If you would have a faithful servant, and one that you like, serve yourself.","If all you can do is crawl, start crawling.","Extreme hopes are born from extreme misery.","When a person cannot deceive himself the chances are against his being able to deceive other people.","I am the greatest. I said that even before I knew I was. Don't tell me I can't do something. Don't tell me it's impossible. Don't tell me I'm not the greatest. I'm the double greatest.","Geologists have a saying - rocks remember.","Be silent, only the hand of god can remove the burdens of your heart.","Peace cannot be kept by force; it can only be achieved by understanding.","The best way to get a bad law repealed is to enforce it strictly.","Wherever you are, and whatever you do, be in love.","Should I kill myself, or have a cup of coffee?","It is very dangerous to have your self-worth riding on your results as an athlete.","No part of the education of a politician is more indispensable than the fighting of elections.","War is never a lasting solution for any problem.","I never think of the future - it comes soon enough.","At the end of my life, with just one breath left, if you come, I'll sit up and sing.","Indigestion is charged by god with enforcing morality on the stomach.","Fear allah, for he alone lives; all other things are liable to perish.","I once had a thousand desires. But in my one desire to know you, all else melted away.","God forbid, men should be jealous of knowledge as they are jealous of women.","I wish they would only take me as I am.","I have lived on the lip of insanity, wanting to know reasons, knocking on a door. It opens. I've been knocking from the inside.","Once you replace negative thoughts with positive ones, you'll start having positive results.","What is wanted is not the will to believe, but the will to find out, which is the exact opposite.","I'm going to show you how great I am!","In the depth of winter I finally learned that there was in me an invincible summer.","He who fears to weep, should learn to be kind to those who weep.","The criminal is trying to solve his immediate problems.","It is very easy to defeat someone, but it is very hard to win someone.","A casual stroll through the lunatic asylum shows that faith does not prove anything.","Things may come to those who wait, but only the things left by those who hustle.","No sanction can stand against ignited minds.","Understanding the knowledge and wisdom of the qur'an is by far, higher than memorizing.","Gratitude is the wine for the soul. Go on. Get drunk.","All of our dreams can come true.","The days of life pass away like clouds, so do good while you are alive.","Once the choice is made, do not look back, do not second-guess your decisions.","Tear off the mask. Your face is glorious.","How hard, how bitter it is to become a man!","Conduct, which involves a decision of the ultimate fate of the agent cannot be based on illusions.","I don't know who my grandfather was; I am much more concerned to know what his grandson will be.","Look for the answer inside your question.","Adversity makes men, and prosperity makes monsters.","Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.","It is better to remain silent and be thought a fool than to open one's mouth and remove all doubt.","He who has never learned to obey cannot be a good commander.","You cannot create experience. You must undergo it.","I am grateful for all my victories, but I am especially grateful for my losses, because they only made me work harder.","No legacy is so rich as honesty.","The outcome of fear is disappointment and shyness is frustration.","All my life through, the new sights of nature made me rejoice like a child.","He who avoids complaint invites happiness.","Work with integrity and succeed with integrity.","You were born with potential. You were born with goodness and trust. You were born with ideals and dreams. You were born with greatness. You were born with wings. You are not meant for crawling, so don't. You have wings. Learn to use them and fly.","Move, but don't move the way fear makes you move.","It does not matter how slowly you go as long as you do not stop.","There is no nobility with bad manners.","You should not quarrel with your neighbor, for he will remain where he is, but your high handedness will become the talk of the people.","Never stop fighting until you arrive at your destined place - that is, the unique you. Have an aim in life, continuously acquire knowledge, work hard, and have perseverance to realise the great life.","I like to see a man proud of the place in which he lives. I like to see a man live so that his place will be proud of him.","Let me define a leader. He must have vision and passion and not be afraid of any problem. Instead, he should know how to defeat it. Most importantly, he must work with integrity.","Whatever your heart clings to and confides in, that is really your god.","Dogs never bite me. Humans do.","Your successes and happiness are forgiven you only if you generously consent to share them.","When a person really desires something, all the universe conspires to help that person to realize his dream.","I didn't fail the test, I just found 100 ways to do it wrong.","One who thinks and reflects develops his foresight and vision.","When red-haired people are above a certain social grade their hair is auburn.","I have held many things in my hands, and I have lost them all; but whatever I have placed in god's hands, that I still possess.","Always remember you are braver than you believe, stronger than you seem, smarter than you think and twice as beautiful as you'd ever imagined. Yesterday I was clever, so I wanted to change the world. Today I am wise, so I am changing myself.","That which you do not wish for yourself, do not impose on others.","I am the greatest, I said that even before I knew I was.","There is no labor a person does that is undignified; if they do it right.","The people themselves, and not their servants, can safely reverse their own deliberate decisions.","I hated every minute of training, but I said, 'don't quit. Suffer now and live the rest of your life as a champion.'","We shall draw from the heart of suffering itself the means of inspiration and survival.","When the solution is simple, god is answering.","I have a theory that the truth is never told during the nine-to-five hours.","Democracy is when the indigent, and not the men of property, are the rulers.","You're not going to enjoy every minute of the journey, but the success you'll find at the end will make it all worth it.","It's hard to be humble when you're as great as I am.","There is no knowledge and science like pondering and thought; and there is no prosperity and advancement like knowledge and science.","If we did all the things we are capable of, we would literally astound ourselves.","Be like a tree and let the dead leaves drop.","Don't find fault, find a remedy.","A friend cannot be considered a friend until he is tested in three occasions: in timeof need, behind your back, and after your death.","I'm too fast. I'm too smart. I'm too pretty.","You cannot create experience. You must undergo it.","Indignation is a submission of our thoughts, but not of our desires.","Sir, my concern is not whether god is on our side; my greatest concern is to be on god's side, for god is always right.","At times one remains faithful to a cause only because its opponents do not cease to be insipid.","I put my heart and my soul into my work, and have lost my mind in the process.","In a competition of love we'll all share in the victory, no matter who comes first.","Some are born great, some achieve greatness, and some have greatness thrust upon them.","There is no capital more useful than intellect and wisdom, and there is no indigence more injurious than ignorance and unawareness.","There is a voice that doesn't use words. Listen.","If a sheep dies on the shore of the euphrates I fear lest allah ask me to account for it on the day of resurrection.","Do not deceive or be faithless even with your enemy.","Pondering must turn out to be your cash asset, regardless of whichever ups and downs you occur throughout in the everyday living.","Building capacity dissolves differences. It irons out inequalities.","All your anxiety is because of your desire for harmony. Seek disharmony, then you will gain peace.","As long as you are pure of heart, you speak the truth.","Most people spend more time and energy going around problems than in trying to solve them.","If you judge people, you have no time to love them.","Talent in cheaper than table salt. What separates the talented individual from the successful one is a lot of hard work.","The world we have created is a product of our thinking.","When a hundred men stand together, each of them loses his mind and gets another one.","Fanatics are picturesque, mankind would rather see gestures than listen to reasons.","Every day is different, and some days are better than others, but no matter how challenging the day, I get up and live it.","The educated southerner has no use for an 'r', except at the beginning of a word.","To love is to act.","My dream is of a place and a time where america will once again be seen as the last best hope of earth.","What comes, will go. What is found, will be lost again. But what you are is beyond coming and going and beyond description.","Dreams are not those which comes while we are sleeping, but dreams are those when u don't sleep before fulfilling them.","To fear love is to fear life, and those who fear life are already three parts dead.","Expect the best. Prepare for the worst. Capitalize on what comes.","My soul is my guide, for my soul is of that abode. I will not speak of the earthly. I am of the unknown.","Many marriages would be better if the husband and the wife clearly understood that they are on the same side.","Try not to resist the changes that come your way. Instead let life live through you. And do not worry that your life is turning upside down. How do you know that the side you are used to is better than the one to come?","Religions have different names, and they all contain truth, expressed in different ways forms and times.","All that I am, or hope to be, I owe to my angel mother.","Doing as others told me, I was blind. Coming when others called me, I was lost. Then I left everyone, myself as well. Then I found everyone, myself as well.","Happiness is when what you think, what you say, and what you do are in harmony.","Nothing will work unless you do.","My books are like water; those of the great geniuses are wine. (fortunately) everybody drinks water.","Grief can be the garden of compassion. If you keep your heart open through everything, your pain can become your greatest ally in your life's search for love and wisdom.","To be alone means that you avoid bad company. But to have a true friend is better than being alone.","I am the greatest.","Only a man who knows what it is like to be defeated can reach down to the bottom of his soul and come up with the extra ounce of power it takes to win when the match is even.","Riches without faith are the greatest poverty.","I'm the most recognized and loved man that ever lived cuz there weren't no satellites when jesus and moses were around, so people far away in the villages didn't know about them.","The lord prefers common-looking people. That is why he makes so many of them.","Whether you love god or you love a human being, if you love enough you will come into the presence of love itself.","O allah do not give me in excess lest I may be disobedient.","Eros will have naked bodies; friendship naked personalities.","In a democracy, the well-being, individuality and happiness of every citizen is important for the overall prosperity, peace and happiness of the nation.","The happiest of people is the one under whose care people are happy because of him, and the most miserable of people is the one under whose care people are miserable because of him.","He who guards his secrets retains control in his own hands.","Success is not achieved by winning all the time. Real success comes when we rise after we fall.","Humility is not thinking less of yourself, it's thinking of yourself less.","No amount of worrying can change the future. Go easy on yourself, for the outcome of all affairs is determined by god's decree. If something is meant to go elsewhere, it will never come your way, but if it is yours by destiny, from you it cannot flee.","Fear him, whom you hate.","The word of god is the medicine of the heart.","Do you think god gets stoned? I think so... Look at the platypus.","The good life is one inspired by love and guided by knowledge.","I believe in christianity as I believe that the sun has risen: not only because I see it, but because by it I see everything else.","The airplane has had a big impact on my life.","We make a living by what we get, but we make a life by what we give.","Indifference and neglect often do much more damage than outright dislike.","When I am silent, I fall into the place where everything is music.","A word to the wise ain't necessary - it's the stupid ones that need the advice.","Always consider your intellect to be lacking; otherwise too much faith in it surely leads to error.","That's okay, I'm still the greatest.","When I look into the future, it's so bright it burns my eyes.","I'm gonna whup whoever stole my bike!","To be a great champion you must believe you are the best. If you're not, pretend you are.","Get up sucker and fight. Get up and fight.","We shall require a substantially new manner of thinking if mankind is to survive.","I try to build a full personality for each of our cartoon characters - to make them personalities.","Without freedom, no art; art lives only on the restraints it imposes on itself, and dies of all others.","When you're right, nobody remembers. When you're wrong, nobody forgets.","We have one life; it soon will be past; what we do for god is all that will last.","When we practice loving kindness and compassion we are the first ones to profit.","I never gave up on country music because I knew what I was doing was not that bad.","Israel, as the jewish state, must disappear from the map.","The world is a dangerous place to live; not because of the people who are evil, but because of the people who don't do anything about it.","It is not best that we should all think alike; it is a difference of opinion that makes horse races.","Intense love does not measure, it just gives.","A penny saved is a penny earned.","Whatever purifies you is the right path, I will not try to define it.","Coming together is a beginning; keeping together is progress; working together is success.","Total commitment is the common denominator among all successful men and women.","Rest but never quit. Even the sun has a sinking spell each evening. But it always rises the next morning. At sunrise, every soul is born again.","You can have no dominion greater or less than that over yourself.","I want you to be concerned about your next door neighbor. Do you know your next door neighbor?","I shook up the world.","I learned that every mortal will taste death. But only some will taste life.","Parkinson's is my toughest fight. No, it doesn't hurt. It's hard to explain. I'm being tested to see if I'll keep praying, to see if I'll keep my faith. All great people are tested by god.","You have been a prisoner of a little pond I am the ocean and its turbulent flood come merge with me leave this world of ignorance.","Do not share the knowledge with which you have been blessed with everyone in general, as you do with some people in particular; and know that there are some men in whom allah, may he he glorified, has placed hidden secrets, which they are forbidden to reveal.","Your heart knows the way. Run in that direction.","The angel is free because of his knowledge, the beast because of his ignorance. Between the two remains the son of man to struggle.","I like not fair terms and a villain's mind.","Our abode in this world is transitory, our life therein is but a loan, our breaths are numbered and our indolence is manifest.","All credibility, all good conscience, all evidence of truth come only from the senses.","Once spirit was god, then it became man, and now it is even becoming mob.","Wealth tends to create enemies, whereas knowledge tends to warm hearts.","Be afraid of a dignified man when he is hungry and a wicked man when his belly is full.","Nothing says holidays, like a cheese log.","A man wrapped up in himself makes a very small bundle.","There is a candle in your heart, ready to be kindled. There is a void in your soul, ready to be filled. You feel it, don't you?","I am the literary equivalent of a big mac and fries.","To forgive an oppressor is oppression upon the oppressed.","Our death is our wedding with eternity.","Imagination is more important than knowledge.","When proven wrong, the wise will correct themselves and the ignorants will just keep arguing.","Grieving? Don't. With time, whatever you've lost might come 'round in some other form.","The breeze at dawn has secrets to tell you. Don't go back to sleep.","Positive thinking will let you do everything better than negative thinking will.","Design is not just what it looks like and feels like. Design is how it works.","Contentment is a wealth that is never exhausted.","There is nothing outside of yourself, look within. Everything you want is there. You are that."};
#define randSentence() randFrom(rstcss)
#define koiJumla randSentence
#define koi_jumla randSentence
#define kisiJumle randSentence
#define kisi_jumle randSentence
#define koiJumle randSentence
#define koi_jumle randSentence
/*
on
    print "City:" ke_age koi_sheher() age_bas;
    print "Area:" ke_age koi_karachi_area() age_bas;
    print "Word:" ke_age koi_lafz() age_bas;
    print "Sentence:" ke_age koi_jumla() age_bas;
    print "Nationality:" ke_age koi_nationality() age_bas;
    print "Phone:" ke_age koi_phone_number() age_bas;
    print "Guy name:" ke_age koi_larka_naam() age_bas;
    print "Girl name:" ke_age koi_larki_naam() age_bas;
off
*/
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
on

    farz score barabar 40;

    haalat score ki
        basurat 20:
            kahie ke "Low on score";
            ruko;
        basurat 40:
            kahie ke "Moderate score";
            ruko;
        basurat 70:
            kahie ke "High on score";
            ruko;
    basab
    
    br(1);
    kahie ke "Your score:" or_age score age_bas;
    
off
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
/*
khu
    kahie salaam ji
    linechoro(2) re
    farz naam barabar pucho("Please enter your name: ") ji
    farz umr barabar pucho_i("Please enter your age:") ji
    
    kahie "Comment:" ke_aage naam aur "agar apki umr" aage umr aage "he, to birthday" aage age2birthyear(umr) aage "ki hogi. " age_bas ji
    
    agar umr zyada_ya_barabar 18 hen to
        khuram ji kahie "Yani ap 18 se upar ho." re
    nahi_to
        khuram ji kahie "Yani ap ab bhi chote/choti ho." re
    basab
ram
*/

/*
khu
    chau salaam yaara
    linegap 2 jo yaara
    farz naalo barabar puchu("Please enter your name: ") je
    farz umr barabar puchu_i("Please enter your age:") je
    
    chau "Comment:" je_agya naalo aen "agar apki umr" agya umr agya "he, to birthday" agya age2birthyear(umr) agya "ki hogi. " agya_bas yaara
    
    agar umr ghani_ya_barabar 18 ahe ta
        khuram ba chau "Yani ap 18 se upar ho." re
    nata
        khuram ba chau "Yani ap ab bhi chote/choti ho." re
    bas_hare
ram
*/
/*
on
    farz city barabar koiSheher();
    print "Haseeb" aage city aage "ka rehaishi he";
off
*/
