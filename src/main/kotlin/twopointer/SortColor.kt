package twopointer
/**
 * Problem statement :
 * Given an array, colors, which contains a combination of the following three elements:
 * 0 (representing red)
 * 1 (representing white)
 * 2 (representing blue)
 * Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of
 * red, white, and blue. The function should return the same array.
 */
class SortColor {

    fun sortColors(colors: IntArray) : IntArray {
        // will have three pointer for each color.
        var red = 0; // represent red
        var white = 0; // represent white
        var blue = colors.size - 1 // blue index to be last.
        // now we check the array wh
        while (white <= blue) {
            if (colors[white] == 0) {// it is red , swap with red and increase both, r and w
                if(colors[red] != 0) {
                    val temp = colors[red]
                    colors[red] = colors[white]
                    colors[white] = temp
                }
                red ++
                white ++
            }
            else if (colors[white] == 1){
                // no change
                white ++
            }else { // when it is 2
                if(colors[blue] != 2) {
                    val temp = colors[blue]
                    colors[blue] = colors[white]
                    colors[white] = temp
                }
                blue --
            }
        }
        return colors
    }
}