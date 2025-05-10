# HindC++
A Hindi to GCC translation engine
<br/>
<br/>

## Hello World
`shuru`<br/>
`    ayesha kahie "hello world";`
    <br/>
`ant`

## For Loop
`hind`<br/>
`    phere int i barabar 1; i kam_ya_barabar 10; i me_izafa 1 ka or_run`</br>
`        agar i wakai_barabar 3 hen skip;`<br/>
`        //skipping numbers`</br>
`        kahie "Counting..." aage i age_bas;`<br/>
`    basab`<br/>
`C`

## Do-While
`func x() {`<br/>
`    return 1;`<br/>
`}`<br/>
<br/>
`co`<br/>
`    farz i barabar x() pagli`<br/>
    <br/>
`    karo ye`<br/>
`        kahie "Ginti:" aur i aage_bas meri_jan`<br/>
`        i me_dalo 1 ayesha`<br/>
`    sab jabtak i chote_ya_barabar 5 hen re`<br/>
`de`<br/>

## Swapping
`#include "hindC++"`<br/>

`func stateOf(int a, int b){`<br/>
`    kahie "Abhi A barabar he" aage a aage "; B barabar he" aage b age_bas re`<br/>
`}`<br/>

`on`<br/>
`    farz A barabar 2 sath`<br/>
`      B barabar 5 re`<br/>
`    farz aInPast barabar A sath`<br/>
`      bInPast barabar B re`<br/>
`    stateOf(A, B);`<br/>
`    hera_pheri of A, B karie;`<br/>
`    stateOf(A, B);`<br/>
`    farz failure = A wakai_barabar aInPast or_sath B wakai_barabar bInPast ji`<br/>
`    agar failure nahi he to`<br/>
`        kahie "Exchanging data was successful. int A ab B ke barabar he, or B ab A ke!" re`<br/>
`    nahi_to`<br/>
`        kahie "Failure in data exchange, a=aInPast, and b still equals state of bInPast, so nothing changed" re`<br/>
`    basab`<br/>
`off`<br/>



## *Pros*
  * for loops
  * while
  * do-while
  * hindi-friendly if-else
  * hindi-friendly switchCase
  * int, float, or double likhne ki jaga, ab farz x barabar y likh do, compiler khud hi samajh jaega data type ko
  * semicolons ki jaga ab words ka istamal: ji, re, ri, baba, meri_jan
  * ...or bhi hazaaro cheeze, wo bhi hindi syntax me
  * Say goodbye to the junky main function (i.e. `int main(){(...code)}`), just go:
  <br/>`on`<br/>`(   ...code)`<br/>`off`
  * Comes with Date functions
  * Comes with File functions
  * and much more

## Try Online

[Hindi/Urdu Demo](https://onecompiler.com/cpp/43dxht7ak)
 | 
[Sindhi Demo](https://onecompiler.com/cpp/43g4b26sf)

## Importing the library
`#include "project_root_directory/[hindC++]"`

## Download the library at:
https://raw.githubusercontent.com/Abbaskhurram255/hindCPlusPlus/refs/heads/main/hindC++.hpp
