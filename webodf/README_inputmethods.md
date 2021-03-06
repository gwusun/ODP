Input methods in browsers
=========================

Mac OSX Browser behaviour
=========================
Events are all captured using the provided imedemo.html file.

Scenarios
=========
1. English letter 'a'
2. Option+u (¨ char), u
3. Option+u (¨ char), j (ends composition)
4. Option+u (¨ char), option+u (chains composition), <left arrow>
5. Option+k (˚ char)
6. Pinyin Simplified IME, r + 1
7. Input using character viewer

Chrome
------
= Scenario 1 =
cycle: 0| keydown: A
cycle: 0| keypress: a
cycle: 0| textInput: a
cycle: 0| input: a
cycle: 1| keyup: A

= Scenario 2 =
cycle: 0| keydown: 
cycle: 1| keydown: å
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| keyup: U
cycle: 3| keyup: 
cycle: 4| keydown: å
cycle: 4| compositionend: ü
cycle: 4| textInput: ü
cycle: 4| input: ü
cycle: 5| keyup: U

= Scenario 3 =
cycle: 0| keydown: 
cycle: 1| keydown: å
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| keyup: U
cycle: 3| keyup: 
cycle: 4| keydown: å
cycle: 4| compositionend: ¨j
cycle: 4| textInput: ¨j
cycle: 4| input: ¨j
cycle: 5| keyup: J

= Scenario 4 =
cycle: 0| keydown: 
cycle: 1| keydown: å
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| keyup: U
cycle: 3| keydown: å
cycle: 3| compositionend: ¨
cycle: 3| textInput: ¨
cycle: 3| input: ¨
cycle: 3| compositionstart:
cycle: 3| compositionupdate: ¨
cycle: 3| input: ¨¨
cycle: 4| keyup: U
cycle: 5| keyup: 
cycle: 6| keydown: å
cycle: 6| compositionend: ¨
cycle: 6| textInput: ¨
cycle: 6| input: ¨¨
cycle: 6| keyup: '
cycle: 6| keydown: '
cycle: 7| keyup: '

= Scenario 5 =
cycle: 0| keydown: 
cycle: 1| keydown: K
cycle: 1| keypress: ˚
cycle: 1| textInput: ˚
cycle: 1| input: ˚
cycle: 2| keyup: K
cycle: 3| keyup: 

= Scenario 6 =
cycle: 0| keydown: å
cycle: 0| compositionstart:
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 1| keyup: R
cycle: 2| keydown: å
cycle: 2| compositionend: 人
cycle: 2| textInput: 人
cycle: 2| input: 人
cycle: 3| keyup: 1

= Scenario 7 =
cycle: 0| textInput: →
cycle: 0| input: →

Safari
------
= Scenario 1 =
cycle: 0| keydown: A
cycle: 0| keypress: a
cycle: 0| textInput: a
cycle: 0| input: a
cycle: 1| keyup: A

= Scenario 2 =
cycle: 0| keydown: 
cycle: 1| compositionstart: ¨
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 1| keydown: å
cycle: 2| keyup: U
cycle: 3| keyup: 
cycle: 4| compositionend: ü
cycle: 4| textInput: ü
cycle: 4| input: ü
cycle: 4| keydown: å
cycle: 5| keyup: U

= Scenario 3 =
cycle: 0| keydown: 
cycle: 1| compositionstart: ¨
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 1| keydown: å
cycle: 2| keyup: U
cycle: 3| keyup: 
cycle: 4| compositionend: ¨
cycle: 4| textInput: ¨
cycle: 4| input: ¨
cycle: 4| keydown: J
cycle: 4| keypress: ¨
cycle: 4| textInput: j
cycle: 4| input: ¨j
cycle: 5| keyup: J

= Scenario 4 =
cycle: 0| keydown: 
cycle: 1| compositionstart: ¨
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 1| keydown: å
cycle: 2| keyup: U
cycle: 3| compositionend: ¨
cycle: 3| textInput: ¨
cycle: 3| input: ¨
cycle: 3| compositionstart: ¨
cycle: 3| compositionupdate: ¨
cycle: 3| input: ¨¨
cycle: 3| keydown: å
cycle: 4| keyup: U
cycle: 5| keyup: 
cycle: 6| compositionend: ¨
cycle: 6| textInput: ¨
cycle: 6| input: ¨¨
cycle: 6| keydown: '
cycle: 7| keyup: '

= Scenario 5 =
cycle: 0| keydown: 
cycle: 1| keydown: K
cycle: 1| keypress: ˚
cycle: 1| textInput: ˚
cycle: 1| input: ˚
cycle: 2| keyup: K
cycle: 3| keyup:

= Scenario 6 =
cycle: 0| compositionstart: r
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 0| keydown: å
cycle: 1| keyup: R
cycle: 2| compositionend: 人
cycle: 2| textInput: 人
cycle: 2| input: 人
cycle: 2| keydown: å
cycle: 3| keyup: 1

= Scenario 7 =
cycle: 0| textInput: →
cycle: 0| input: →

Firefox
-------
= Scenario 1 =
keyup: A |cycle: 1
input: a |cycle: 0
keypress: a |cycle: 0
keydown: A |cycle: 0

= Scenario 2 =
cycle: 0| keydown: 
cycle: 1| keydown: U
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| compositionupdate: ü
cycle: 2| compositionend: ü
cycle: 2| input: ü
cycle: 3| keyup: U

= Scenario 3 =
cycle: 0| keydown: 
cycle: 1| keydown: U
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| compositionend: ¨
cycle: 2| input: ¨
cycle: 2| keypress: j
cycle: 2| input: ¨j
cycle: 3| keyup: J

= Scenario 4 =
cycle: 0| keydown: 
cycle: 1| keydown: U
cycle: 1| compositionstart:
cycle: 1| compositionupdate: ¨
cycle: 1| input: ¨
cycle: 2| compositionend: ¨
cycle: 2| input: ¨
cycle: 2| compositionstart:
cycle: 2| compositionupdate: ¨
cycle: 2| input: ¨¨
cycle: 3| compositionend: ¨
cycle: 3| input: ¨¨
cycle: 3| keypress:  
cycle: 4| keyup: '

= Scenario 5 =
cycle: 0| keydown: 
cycle: 1| keydown: K
cycle: 1| keypress: ˚
cycle: 1| input: ˚
cycle: 2| keyup: K
cycle: 3| keyup: 

= Scenario 6 =
cycle: 0| keydown: R
cycle: 0| compositionstart:
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 1| compositionupdate: 人
cycle: 1| compositionend: 人
cycle: 1| input: 人
cycle: 2| keyup: 1

= Scenario 7 =
cycle: 0| keypress: →
cycle: 0| input: →

Linux OS browser behaviours
===========================
Events are all captured using the provided imedemo.html file.

Scenarios
=========
1. English letter 'a'
2. hold ctrl+shift+u, A, A, release ctrl+shift+u (http://en.wikipedia.org/wiki/Alt_code#Linux)
3. scenario 2 twice  (chains composition)
4. Japanese IME + trycode, r, o
5. Japanese IME + tcode, r, o

Chrome
------
= Scenario 1 =
cycle: 0| keydown: A
cycle: 0| keypress: a
cycle: 0| textInput: a
cycle: 0| input: a
cycle: 1| keyup: A

= Scenario 2 =
cycle: 0| keydown: 
cycle: 1| keydown: 
cycle: 2| keydown: å
cycle: 2| compositionstart:
cycle: 2| compositionupdate: u
cycle: 2| input: u
cycle: 2| keyup: å
cycle: 3| keydown: å
cycle: 3| compositionupdate: uA
cycle: 3| input: uA
cycle: 3| keyup: å
cycle: 4| keyup: A
cycle: 5| keydown: å
cycle: 6| compositionupdate: uAA
cycle: 6| input: uAA
cycle: 6| keyup: å
cycle: 7| keyup: U
cycle: 8| keydown: å
cycle: 9| compositionend:
cycle: 9| input:
cycle: 9| keyup: å
cycle: 9| keydown: å
cycle: 9| textInput: ª
cycle: 9| input: ª
cycle: 9| keyup: å
cycle: 10| keyup: 

= Scenario 3 =
cycle: 0| keydown: 
cycle: 1| keydown: 
cycle: 2| keydown: å
cycle: 2| compositionstart:
cycle: 2| compositionupdate: u
cycle: 2| input: u
cycle: 2| keyup: å
cycle: 3| keydown: å
cycle: 3| compositionupdate: uA
cycle: 3| input: uA
cycle: 3| keyup: å
cycle: 4| keyup: A
cycle: 5| keydown: å
cycle: 5| compositionupdate: uAA
cycle: 5| input: uAA
cycle: 5| keyup: å
cycle: 6| keyup: U
cycle: 7| keydown: å
cycle: 7| compositionend:
cycle: 7| input:
cycle: 7| keyup: å
cycle: 7| keydown: å
cycle: 7| textInput: ª
cycle: 7| input: ª
cycle: 7| keyup: å
cycle: 8| keyup: 
cycle: 9| keydown: 
cycle: 10| keydown: 
cycle: 11| keyup: U
cycle: 12| textInput: ª
cycle: 12| input: ªª
cycle: 12| keyup: 
cycle: 13| keyup:

= Scenario 4 =
cycle: 0| keydown: å
cycle: 0| compositionstart:
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 0| keyup: å
cycle: 1| keyup: R
cycle: 2| keydown: å
cycle: 2| compositionupdate: r
cycle: 2| input: r
cycle: 2| keyup: å
cycle: 3| keydown: å
cycle: 3| compositionend:
cycle: 3| input:
cycle: 3| keyup: å
cycle: 3| keydown: å
cycle: 3| textInput: 生
cycle: 3| input: 生
cycle: 3| keyup: å
cycle: 4| keyup: O

= Scenario 5 =
cycle: 0| keydown: å
cycle: 1| compositionstart:
cycle: 1| compositionupdate: r
cycle: 1| input: r
cycle: 1| keyup: å
cycle: 2| keyup: R
cycle: 3| keydown: å
cycle: 3| compositionupdate: r
cycle: 3| input: r
cycle: 3| keyup: å
cycle: 3| keydown: å
cycle: 3| compositionend:
cycle: 3| input:
cycle: 3| keyup: å
cycle: 4| keydown: å
cycle: 4| textInput: 低
cycle: 4| input: 低
cycle: 4| keyup: å
cycle: 5| keyup: O

Firefox
-------
= Scenario 1 =
cycle: 0| keydown: A
cycle: 0| keypress: a
cycle: 0| input: a
cycle: 1| keyup: A

= Scenario 2 =
cycle: 0| keydown: 
cycle: 1| keydown: 
cycle: 2| compositionstart:
cycle: 2| compositionupdate: u
cycle: 2| input: u
cycle: 3| compositionupdate: uA
cycle: 3| input: uA
cycle: 4| compositionupdate: uAA
cycle: 4| input: uAA
cycle: 5| compositionupdate:
cycle: 5| compositionend:
cycle: 5| input:
cycle: 5| compositionstart:
cycle: 5| compositionupdate: ª
cycle: 5| compositionend: ª
cycle: 5| input: ª
cycle: 6| keyup: 

= Scenario 3 =
cycle: 0| keydown: 
cycle: 1| keydown: 
cycle: 2| compositionstart:
cycle: 2| compositionupdate: u
cycle: 2| input: u
cycle: 3| compositionupdate: uA
cycle: 3| input: uA
cycle: 4| compositionupdate: uAA
cycle: 4| input: uAA
cycle: 5| compositionupdate:
cycle: 5| compositionend:
cycle: 5| input:
cycle: 5| compositionstart:
cycle: 5| compositionupdate: ª
cycle: 5| compositionend: ª
cycle: 5| input: ª
cycle: 6| keyup: 
cycle: 7| keydown: 
cycle: 8| keydown: 
cycle: 9| keyup: U
cycle: 10| keyup: A
cycle: 11| keyup: A
cycle: 12| compositionstart:
cycle: 12| compositionupdate: ª
cycle: 12| compositionend: ª
cycle: 12| input: ªª
cycle: 13| keyup: 

= Scenario 4 =
cycle: 0| compositionstart:
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 1| input: r
cycle: 1| compositionupdate:
cycle: 1| compositionend:
cycle: 1| input:
cycle: 1| compositionstart:
cycle: 1| compositionupdate: 生
cycle: 1| compositionend: 生
cycle: 1| input: 生
cycle: 2| keyup: O

= Scenario 5 =
cycle: 0| compositionstart:
cycle: 0| compositionupdate: r
cycle: 0| input: r
cycle: 1| input: r
cycle: 1| compositionupdate:
cycle: 1| compositionend:
cycle: 1| input:
cycle: 1| compositionstart:
cycle: 1| compositionupdate: 低
cycle: 1| compositionend: 低
cycle: 1| input: 低
cycle: 2| keyup: O