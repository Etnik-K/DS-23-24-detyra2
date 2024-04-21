# Route Transposition Cipher

Ky program implementon algoritmin e Route Transposition Cipher për enkriptimin dhe dekriptimin e mesazheve.

## Ekzekutimi i Programit

1. Hapni compajlerin favorit tuajin.
2. Ekzekutoni skriptën dhe ndiq instrukcionet:


## Përshkrimi i Algoritmit

Në botën e kriptografisë, një Transposition Cipher është një mënyrë e kodimit që shpërndan pozicionet e karaktereve, duke mos ndryshuar vetë karakteret. Plaintext mund të zhvendosen në tekst të koduar duke përdorur një çelës. Rezultati është një mesazh i vështirë për të dekriptuar pa çelësin e duhur, pasi ka shumë mënyra se si karakteret mund të rregullohen.

## Shembuj të Rezultateve

Për të ilustruar funksionimin e algoritmit, këtu janë disa shembuj të rezultateve të ekzekutimit për enkriptimin dhe dekriptimin e mesazheve:

## Enkriptimi

1. Kodimi i një mesazhi me ane te C (Clockwise):

Mesazhi i hyrjes: "Route Transposition Cipher"

Mesazhi i koduar: "RnTru orpstsnhitpoait iiecCir"

2. Kodimi i një mesazhi me ane te CC (Counter-Clockwise):

Mesazhi i hyrjes: ""

Mesazhi i koduar: ""

## Dekriptimi

1. Dekodimi i një mesazhi me ane te C (Clockwise):

Mesazhi i hyrjes: "RnTru orpstsnhitpoait iiecCir"

Mesazhi i dekoduar: "Route Transposition Cipher"

2. Dekodimi i një mesazhi me ane te CC (Counter-Clockwise):

Mesazhi i hyrjes: ""

Mesazhi i dekoduar: ""


Këto shembuj tregojnë se si algoritmi i Route Transposition Cipher funksionon për kodimin dhe dekodimin e mesazheve.


#**BookCipher**
Ky program implementon algoritmin e BookCipher për enkriptimin dhe dekriptimin e mesazheve.

## Ekzekutimi i Programit
Për ekzekutimin e algoritmit nevojitet një compailer i gjuhës Java.
Tek metoda main jepet teksti që dëshirojmë të enkriptojmë, pastaj nëpërmjet metodave të implementuara kryhet procesi i kodimit dhe dekodimit


## Shembuj të Rezultateve

Për të ilustruar funksionimin e algoritmit, këtu janë disa shembuj të rezultateve të ekzekutimit për enkriptimin dhe dekriptimin e mesazheve:
1)
Mesazhi per enkriptim: The mice moved the cheese
Mesazhi i enkriptuar: 3 7 12 8 1 6 3 15 15 4 5 1 10 16 10
Mesazhi i denkriptuar: the mice Moved The Cheese

2)
Mesazhi per enkriptim: The mice moved the cheese
Mesazhi i enkriptuar: 8 1 5 6 18 5 9 3 16 12 11 12 7 5 6
Mesazhi i denkriptuar: the mice moved The cheese

3)
Mesazhi per enkriptim: The mice moved the cheese
Mesazhi i enkriptuar: 12 15 4 8 1 6 2 5 13 11 10 1 12 1 3
Mesazhi i denkriptuar: the mice Moved The Cheese

Nga shembujt kuptojmë që edhe pse po enkriptojmë të njëjtin mesazh rezultatet janë të ndryshme për arsye që një fjalë mund të gjindet në më shumë se një pozite andaj lista e pozitave behet shuffle kështu zgjedhet një pozicion rastësisht


## Leximi i Librit
Lexon rreshtat nga një text file, permes filereader, dhe i ruan në një listë

## Enkriptimi
Kemi caktuar një numër i rreshtave që do ta ketë një faqe. Pasi numri i rreshtave të lexuar kalon numrin e caktuar nga ne, pasi arrihet ai numër kalojmë në faqen e re.
I gjen dhe i ruan pozitat e cdo fjale të librit(ne formatin: faqja, rreshti, fjala). Nëse fjala e njejtë gjendet disa herë lista në fund bëhet shuffle që me rrit sigurinë. Nëse një pozitë përdoret gjatë enkriptimit ajo fshihet nga lista. Në bazë të tekstit që dëshirojmë të enkirptojmë, në fund kthehet një String me pozitat e cdo fjale(faqja, rreshti, fjala, faqja, rreshti, fjala...)

## Dekriptimi
Në array-in e Strings iterojme nga 3 numra në mënyrë që të marrim faqen, rreshtin dhe fjalen.
Kur fjala gjendet i shtohet mesazhit të dekriptuar dhe unaza vazhdon
Kthen mesazhin e dekriptuar

## Main
Specifikohet path për tek libri, caktohet numri i rreshtave të cilët konsiderojmë që e formojnë një faqe(variabile)
Thirren metodat dhe printohet rezultati



