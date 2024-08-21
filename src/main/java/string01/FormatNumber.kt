package string01

/**
 *
 * Toll-free telephone numbers are often branded using phonewords;
 * some firms use easily memorable vanity telephone numbers like 1-800 Contacts,
 * 1-800-Flowers, 1-866-RING-RING, or 1-800-GOT-JUNK?
 * as brands for flagship products or names for entire companies.
 *
 * We need to write a function which takes in one of these phonewords and converts it to a phone number.
 *
 * Step 1.  Write a function which takes a single phoneword as a string and outputs a phone number, also as a string.
 * You can assume that the string is a valid phone number and has already been cleaned of any hyphens, parenthesis,
 * etc.  e.g. "1800555Cats" or "1800GOTJUNK"
 *
 * Step 2.  You can no longer assume your input has been cleaned, it may have parenthesis, hyphens, spaces, etc. e.g.
 * "1(800)-555-CATS",  "1-800 CONTACTS", but it will still be a valid phone number.
 *
 * Number  Letter
 * 0  none (on some telephones, "OPERATOR" or "OPER")
 * 1  none
 * 2  ABC
 * 3  DEF
 * 4  GHI
 * 5  JKL
 * 6  MNO
 * 7  PQRS
 * 8  TUV
 * 9  WXYZ
 *
 */


object FormatNumber {
    fun convertToPhoneNumber(input: String): String {
        val output = StringBuilder()
        val mapper = getMapper()
        val sanitized = input.trim().toUpperCase()
        for (char in sanitized) {
            if (!char.isLetterOrDigit())
                continue
            else {
                output.append(if (!char.isDigit()) mapper[char] else char)
            }
        }
        return output.toString()
    }


    fun getMapper(): HashMap<Char, Int> {
        val numberMapper = HashMap<Char, Int>()
        numberMapper['A'] = 2
        numberMapper['B'] = 2
        numberMapper['C'] = 2
        numberMapper['D'] = 3
        numberMapper['E'] = 3
        numberMapper['F'] = 3
        numberMapper['G'] = 4
        numberMapper['H'] = 4
        numberMapper['I'] = 4
        numberMapper['J'] = 5
        numberMapper['K'] = 5
        numberMapper['L'] = 5
        numberMapper['M'] = 6
        numberMapper['N'] = 6
        numberMapper['O'] = 6
        numberMapper['P'] = 7
        numberMapper['Q'] = 7
        numberMapper['R'] = 7
        numberMapper['S'] = 7
        numberMapper['T'] = 8
        numberMapper['U'] = 8
        numberMapper['V'] = 8
        numberMapper['W'] = 8
        numberMapper['X'] = 8
        numberMapper['Y'] = 8
        numberMapper['Z'] = 8
        return numberMapper
    }
}